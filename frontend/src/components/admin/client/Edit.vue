<template>
  <div>
    <div class="card-body py-3">
      <div class="table-responsive">
        <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
          <thead>
          <tr class="fw-bolder text-muted">
            <th>Email</th>
            <th>Voornaam(en)</th>
            <th>Achternaam</th>
            <th>Telefoonnummer</th>
            <th>Bedrijf</th>
            <th>Type gebruiker</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="client in clients" v-bind:key="client.id">
            <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="client.email"></td>
            <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="client.firstName"></td>
            <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="client.lastName"></td>
            <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="client.phoneNumber"></td>
            <td><input type="text" class="form-control form-control-sm form-control-solid" v-model="client.companyName"></td>
            <td>
              <select class="form-select form-select-solid form-select-sm" v-model="client.userType">
                <option value="client">Cliënt</option>
                <option value="programmer">Programmeur</option>
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
  name: "ClientAdminEdit.vue",
  props: ['clients'],
  emits: ['deleteClient', 'editClient'],

  data() {
    return {
      repository: new UserRepository(),
    }
  },

  methods: {
    cancel() {
      this.$emit('editClient', false);
    },

    async confirm() {
      await this.$swal({
        title: "Opslaan", text: "Wil u de cliënten opslaan?",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, wijzig!",
        cancelButtonText: "Wijzigingen weggooien"
      }).then(this.saveClients);
    },

    async saveClients(result){
      if (result.value) {
        for (const client of this.clients) {
          await this.repository.updateUserById(
                  client.id,
                  client.email,
                  client.firstName,
                  client.lastName,
                  client.phoneNumber,
                  client.companyName,
                  client.userType
          );
        }

        this.$toasted.show("Cliënten opgeslagen", {
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