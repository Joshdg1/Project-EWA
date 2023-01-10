<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <div class="card-header border-0 pt-5">

            <div class=" position-relative mb-5 mb-lg-0">
            <search-icon></search-icon>
            <input type="text" data-kt-ecommerce-order-filter="search"
                 v-model="search"
                 class="form-control form-control-solid w-250px ps-14"
                 placeholder="Zoeken...">
            </div>

            <div class="card-toolbar flex" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-trigger="hover">

                <label class="me-3 fs-6">Sorteren: </label>

                <select class="form-select form-select-sm form-select-solid  me-5 w-200px" v-model="sortType">
                    <option value="skill-asc">Meeste skills eerst</option>
                    <option value="skill-desc">Minste skills eerst</option>
<!--                    <option value="programmer-asc">Meeste sepcialisten eerst</option>-->
<!--                    <option value="programmer-desc">Minste sepcialisten eerst</option>-->
                </select>

                <router-link to="/projects/create" href="#" class="btn btn-sm btn-light-primary">
                    <plus-icon></plus-icon>
                    Nieuw project
                </router-link>
            </div>
        </div>
        <!--end::Header-->
        <!--begin::Body-->
        <div class="card-body py-3">
          <!--begin::Table container-->
          <div class="table-responsive">
            <!--begin::Table-->
            <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
              <!--begin::Table head-->
              <thead>
              <tr class="fw-bolder text-muted">
                <th>Titel</th>
                <th>Beschrijving</th>
                <th>Bedrijf</th>
                <th>Startdatum</th>
                <th>Einddatum</th>
                <th>Status</th>
                <th>Programmeur(s)</th>
                <th>Acties</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="project in resultQuery" v-bind:key="project.id">
                <td>{{ project.title }}</td>
                <td>{{ project.description }}</td>
                <td v-html="getCompanyNameClient(project.client)"></td>
                <td>{{ dateFormat(project.startDate) }}</td>
                <td>{{ dateFormat(project.endDate) }}</td>
                <td>{{ setStatus(project.startDate, project.endDate) }}</td>
                <td v-html="getUserProjects(project.users)"></td>

                <div class="d-flex justify-content-start flex-shrink-0">
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editProject()">
                      <edit-icon></edit-icon>
                  </a>
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="deleteProject(project)">
                      <delete-icon></delete-icon>
                  </a>
                </div>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import ProjectRepository from '../repository/ProjectRepository.js'
import PlusIcon from "./icons/plus";
import SearchIcon from "./icons/search";
import EditIcon from "./icons/edit";
import DeleteIcon from "./icons/delete";

export default {
  components: {DeleteIcon, EditIcon, SearchIcon, PlusIcon},
  name: "ProjectAdmin.vue",
  props: ['projects'],
  emits: ['deleteProject', 'editProject'],

  data() {
    return {
      editingProject: null,
      sortType: "skill-asc",
      search: null,
      repository: new ProjectRepository(),
    }
  },
  watch: {
    sortType: function (newValue) {
        switch (newValue) {
            case "skill-asc":
                this.amountOfProgrammersIncreasing()
                break;
            case "skill-desc":
                this.amountOfProgrammersDecreasing()
                break;
        }
    }
  },
  computed: {
    resultQuery: function () {
      if (this.search) {
        return this.projects.filter(item => {
          if (this.search
              .toLowerCase()
              .split(" ")
              .every(v => item.title.toLowerCase().includes(v))) {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.title.toLowerCase().includes(v));
          } else {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.company.toLowerCase().includes(v));
          }
        })
      } else if (this.value) {
        let skillArray = []
        for (const element of this.projects) {
          for (const item of this.allSkills) {
            if (element.id === item.user.id) {
              skillArray.push(element)
            }
          }
        }
        return this.projects.filter(p => skillArray.includes(p));
      } else {
        return this.projects;
      }
    },


  },

  methods: {

    async deleteProject(project) {
      await this.$swal({
        title: "Wil je dit project verwijderen?", text: "Weet je het zeker?",
        type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
      }).then((result) => {
        if (result.value) {
          this.repository.deleteProjectById(project.id);
          location.reload();
        }
      });
    },

    editProject() {
      this.editingProject = true;
      this.$emit('editProject', this.editingProject)
    },

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
    amountOfProgrammersIncreasing() {
      const newList = this.projects
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return a.users.length - b.users.length
      })
      console.log(sortedList)
    },
    amountOfProgrammersDecreasing() {
      const newList = this.projects
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return b.users.length - a.users.length
      })
      console.log(sortedList)
    },

    getCompanyNameClient(clients) {
      return clients.companyName
    },

    setStatus(startDate, endDate) {
      if (Date.now() >= Date.parse(startDate) && Date.parse(endDate) >= Date.now()) {
        return "Actief"
      }

      return "Inactief"
    }
  }
}
</script>
