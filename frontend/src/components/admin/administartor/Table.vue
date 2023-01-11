<template>
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
          <th>
            <a class="float-end btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editClient()">
              <edit-icon></edit-icon>
            </a>
          </th>
        </tr>
        </thead>

        <tbody>
        <tr v-if="this.clients.length === 0">
          <td class="text-center text-muted fs-4 p-10" colspan="6">
            Geen resultaten
          </td>
        </tr>
        <tr v-else v-for="client in clients" v-bind:key="client.id">
          <td>{{ client.email }}</td>
          <td>{{ client.firstName }}</td>
          <td>{{ client.lastName }}</td>
          <td>{{ client.phoneNumber }}</td>
          <td>{{ client.companyName}}</td>
          <td>
            <a v-if="this.user.id !== client.id" class="float-end btn btn-icon btn-bg-light btn-active-color-primary btn-sm"
               @click="deleteClient(client)">
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
  import UserRepository from '../../../repository/UserRepository'
  import EditIcon from "../../icons/edit";
  import DeleteIcon from "../../icons/delete";

  export default {
    name: "ClientAdmin.vue",
    components: {DeleteIcon, EditIcon},
    props: ['clients'],
    emits: ['editClient'],

    data() {
      return {
        repository: new UserRepository(),
        user: JSON.parse(sessionStorage.getItem('user')),
      }
    },

    methods: {
      async deleteClient(client) {
        await this.$swal({
          title: "Wil je deze administartor verwijderen?",
          text: "Weet je het zeker?",
          type: "warning",
          showCancelButton: true,
          confirmButtonColor: "#3085d6",
          confirmButtonText: "Ja, verwijder!",
          cancelButtonText: "Annuleer"
        }).then((result) => {
          if (result.value) {
            this.postDeleteClient(client);
          }
        });
      },

      async postDeleteClient(client){
        await this.repository.deleteUserById(client.id);
        this.$emit('editClient', false);
      },

      editClient() {
        this.$emit('editClient', true);
      }
    },
  }
</script>

