<template>
    <div class="card-body py-3">
        <div class="table-responsive">
            <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
                <thead>
                <tr class="fw-bolder text-muted">
                    <th>Titel</th>
                    <th>Beschrijving</th>
                    <th>Bedrijf</th>
                    <th>Startdatum</th>
                    <th>Einddatum</th>
                    <th>Status</th>
                    <th>Specialist(en)</th>
                    <th>
                        <a v-if="this.projects.length > 0"
                           class="float-end btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1"
                           @click="editProject()">
                            <edit-icon></edit-icon>
                        </a>
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr v-if="this.projects.length === 0">
                    <td class="text-center text-muted fs-4 p-10" colspan="6">
                        Geen resultaten
                    </td>
                </tr>
                <tr v-else v-for="project in projects" v-bind:key="project.id">
                    <td>{{ project.title }}</td>
                    <td>{{ project.description }}</td>
                    <td v-html="getCompanyNameClient(project.client)"></td>
                    <td>{{ dateFormat(project.startDate) }}</td>
                    <td>{{ dateFormat(project.endDate) }}</td>
                    <td v-html="setStatus(project.startDate, project.endDate)"></td>
                    <td v-html="getUserProjects(project.users)"></td>
                    <td>
                        <a class="float-end btn btn-icon btn-bg-light btn-active-color-primary btn-sm"
                           @click="deleteProject(project)">
                            <delete-icon></delete-icon>
                        </a>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import ProjectRepository from '../../../repository/ProjectRepository.js'
import EditIcon from "../../icons/edit";
import DeleteIcon from "../../icons/delete";

export default {
  components: {DeleteIcon, EditIcon},
  name: "ProjectAdmin.vue",
  props: ['projects'],
  emits: ['deleteProject', 'editProject'],

  data() {
    return {
      repository: new ProjectRepository(),
    }
  },

  methods: {
      dateFormat(date) {
          if (date == null) {
              return null;
          }
          return new Date(date).toLocaleDateString('en-GB');
      },

      getUserProjects(users) {
          if (users.length === 0)
              return "";

          let content = `<div class="symbol-group symbol-hover flex-nowrap">`;
          for (const user of users) {
              content += `<div title="${user.firstName} ${user.lastName}" class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
      data-bs-original-title="Susan Redwood" data-kt-initialized="1">
              <span class="symbol-label bg-primary text-inverse-primary fw-bold">${(user.firstName[0]).toUpperCase()}</span>
              </div>`;
          }
          content += `</div>`;


          return content
      },

      getCompanyNameClient(clients) {
          return clients.companyName
      },

      setStatus(startDate, endDate) {
          let now = new Date().toISOString().slice(0, 10);
          let start = new Date(startDate).toISOString().slice(0, 10);
          let end = new Date(endDate).toISOString().slice(0, 10);

          if (now >= start && end >= now) {
              return "<span class='badge badge-light-primary'>Actief</span>"
          }

          return  "<span class='badge badge-light'>Inactief</span>"
      },

      async deleteProject(project) {
          await this.$swal({
              title: "Wil je dit project verwijderen?", text: "Weet je het zeker?",
              type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
              confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
          }).then((result) => {
              if (result.value) {
                  this.postDeleteProject(project);
              }
          });
      },

      async postDeleteProject(project){
          await this.repository.deleteProjectById(project.id);
          this.$toasted.show("Project verwijderd", {
              theme: "bubble",
              position: "bottom-right",
              duration : 5000
          });
          this.$emit('editProject', false)
      },

      editProject() {
          this.$emit('editProject', true)
      },
  }
}
</script>
