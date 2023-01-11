<template>
  <div>
    <div class="card-body py-3">
      <!--begin::Table container-->
      <div class="table-responsive">
        <!--begin::Table-->
        <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
          <!--begin::Table head-->
          <thead>
          <tr class="fw-bolder text-muted">
            <th>Email</th>
            <th>Voornaam(en)</th>
            <th>Achternaam</th>
            <th>Telefoonnummer</th>
            <th>
              Type gebruiker
            </th>
          </tr>
          </thead>
          <tbody>
          <tr v-if="this.programmers.length === 0">
            <td class="text-center text-muted fs-4 p-10" colspan="6">
              Geen resultaten
            </td>
          </tr>
          <tr v-else v-for="programmer in programmers" v-bind:key="programmer.id">
            <td><input type="text" class="form-control  form-control-sm form-control-solid" v-model="programmer.email">
            </td>
            <td><input type="text" class="form-control  form-control-sm form-control-solid"
                       v-model="programmer.firstName"></td>
            <td><input type="text" class="form-control  form-control-sm form-control-solid"
                       v-model="programmer.lastName"></td>
            <td><input type="text" class="form-control  form-control-sm form-control-solid"
                       v-model="programmer.phoneNumber"></td>
            <td><select class="form-control form-control-sm  form-control-solid" v-model="programmer.userType">
              <option value="client">Cliënt</option>
              <option value="programmer">Specialist</option>
              <option value="administrator">Administrator</option>
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
import UserRepository from '../../../repository/UserRepository'

export default {
  name: "ProgrammerAdminEdit.vue",
  props: ['programmers'],
  emits: ['deleteProgrammer', 'editProgrammer', 'reloadProgrammers'],

  data() {
    return {
      repository: new UserRepository(),
    }
  },

  methods: {
    cancel() {
      this.editingProgrammer = false;
      this.$emit('editProgrammer', this.editingProgrammer);
    },

    async confirm() {
      await this.$swal({
        title: "Opslaan", text: "Wil u de specialisten opslaan?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, wijzig!",
        cancelButtonText: "Wijzigingen weggooien"
      }).then(this.saveProgrammers);
    },

    async saveProgrammers(result){
      if (result.value) {
        for (const programmer of this.programmers) {
          await this.repository.updateUserById(programmer.id, programmer.email, programmer.firstName, programmer.lastName, programmer.phoneNumber, "", programmer.userType);
        }

        this.$toasted.show("Programmeurs opgeslagen", {
          theme: "bubble",
          position: "bottom-right",
          duration : 5000
        });
      }

      this.cancel();
    }

  }
}
</script>

<style scoped>

</style>