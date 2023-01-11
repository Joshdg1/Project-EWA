<template>
  <div>
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
          <th>Specialist(en)</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="project in projects" v-bind:key="project.id">
          <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="project.title"></td>
          <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="project.description"></td>
          <td>
            <select class="form-select form-select-sm form-select-solid" v-model="project.client.id">
              <option v-for="client in companies" v-bind:key="client.id" v-bind:value="client.id">
                {{ client.companyName }}
              </option>
            </select>
          </td>
          <td><input type="date" class="form-control form-control-sm form-control-solid" v-model="project.startDate"></td>
          <td><input type="date" class="form-control form-control-sm form-control-solid" v-model="project.endDate"></td>
          <td>
            <select style="max-height: 100px" multiple class="form-select form-select-sm form-select-solid" v-model="project.user_ids">
              <option v-for="programmer in programmers" v-bind:key="programmer.id" v-bind:value="programmer.id">
                {{ programmer.firstName }} {{ programmer.lastName }}
              </option>
            </select>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  <div class="card-footer">
    <div class="d-flex flex-stack">
      <div class="mr-2">
        <button @click="cancel()" type="button" class="btn btn-sm btn-light-primary me-3">
          Annuleren
        </button>
      </div>
      <div>
        <button @click="confirm()" type="button" class="btn btn-sm btn-primary">
          Opslaan
        </button>
      </div>
    </div>
  </div>
  </div>
</template>

<script>
import ProjectRepository from '../../../repository/ProjectRepository.js'
import UserRepository from "../../../repository/UserRepository";

export default {

  name: "ProjectAdminEdit",
  props: ['projects'],
  emits: ['editProject'],

  async created(){
    for (const project of this.projects) {
      project.user_ids = project.users.map(a => a.id);
    }

    this.companies = await this.userRepository.getAllClients();
    this.companies = this.companies.filter(client => client.companyName);
    this.programmers = await this.userRepository.getAllProgrammers();
  },

  data() {
    return {
      companies: [],
      programmers: [],
      repository: new ProjectRepository(),
      userRepository: new UserRepository(),
    }
  },

  methods: {
    cancel() {
      this.$emit('editProject', false);
    },

    async confirm() {
      await this.$swal({
        title: "Opslaan",
        text: "Wil u de projecten opslaan?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, wijzig!",
        cancelButtonText: "Wijzigingen weggooien"
      }).then(this.saveProjects);
    },

    async saveProjects(result){
      if (result.value) {
        for (const project of this.projects) {
          await this.repository.updateProjectById(
                  project.id,
                  project.title,
                  project.description,
                  project.client.id,
                  project.startDate,
                  project.endDate,
                  project.user_ids,
          );
        }

        this.$toasted.show("Projecten opgeslagen", {
          theme: "bubble",
          position: "bottom-right",
          duration : 5000
        });
      }

      this.cancel();
    },
  }
}
</script>

<style scoped>

</style>