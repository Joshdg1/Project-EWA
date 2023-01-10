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
          <div class="card-toolbar">
            <router-link to="/clients/create" class="btn btn-sm btn-light-primary">
              <plus-icon></plus-icon>
              Nieuwe cliënt
            </router-link>
          </div>
        </div>
        <div class="card-body py-3">
          <div class="table-responsive">
            <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
              <thead>
              <tr class="fw-bolder text-muted">
                <th>Email</th>
                <th>Voornaam(en)</th>
                <th>Achternaam</th>
                <th>Telefoonnummer</th>
                <th>Type gebruiker</th>
                <th>Bedrijf</th>
                <th>Acties</th>
              </tr>
              </thead>

              <tbody>
              <tr v-for="client in resultQuery" v-bind:key="client.id">
                <td>{{ client.email }}</td>
                <td>{{ client.firstName }}</td>
                <td>{{ client.lastName }}</td>
                <td>{{ client.phoneNumber }}</td>
                <td>{{ client.userType }}</td>
                <td>{{ client.companyName}}</td>
                <td class="d-flex flex-shrink-0">
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editClient()">
                    <edit-icon></edit-icon>
                  </a>
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="deleteClient(client)">
                    <delete-icon></delete-icon>
                  </a>
                </td>
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
  import UserRepository from '../repository/UserRepository'
  import PlusIcon from "./icons/plus";
  import SearchIcon from "./icons/search";
  import EditIcon from "./icons/edit";
  import DeleteIcon from "./icons/delete";

  export default {
    name: "ClientAdmin.vue",
    components: {DeleteIcon, EditIcon, SearchIcon, PlusIcon},
    props: ['clients'],
    emits: ['deleteClient', 'editClient'],

    data() {
      return {
        editingClient: null,
        sortType: "increasing",
        search: null,
        sortTypes: ["increasing", "decreasing"],
        repository: new UserRepository(),
      }
    },
    computed: {
      resultQuery: function () {
        if (this.search) {
          return this.clients.filter(item => {
            if (this.search
                    .toLowerCase()
                    .split(" ")
                    .every(v => item.firstName.toLowerCase().includes(v))) {
              return this.search
                      .toLowerCase()
                      .split(" ")
                      .every(v => item.firstName.toLowerCase().includes(v));
            } else {
              return this.search
                      .toLowerCase()
                      .split(" ")
                      .every(v => item.lastName.toLowerCase().includes(v));
            }
          })
        } else if (this.value) {
          let skillArray = []
          for (const element of this.clients) {
            for (const item of this.allSkills) {
              if (element.id === item.user.id) {
                skillArray.push(element)
              }
            }
          }
          return this.clients.filter(p => skillArray.includes(p));
        } else {
          return this.clients;
        }
      },


    },
    watch: {
      sortType: function (newValue) {
        console.log("NEWVAL" + newValue)
        if (newValue === "increasing") {
          console.log("WORKS")
          this.amountOfClientsIncreasing()
        } else if (newValue === "decreasing") {
          console.log("WORKS")
          this.amountOfClientsDecreasing()
        } else {
          const newList = this.clients
          console.log(newList)
        }
      }
    },
    methods: {
      async deleteClient(client) {
        await this.$swal({
          title: "Wil je deze client verwijderen?", text: "Weet je het zeker?",
          type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
          confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
        }).then((result) => {
          if (result.value) {
            this.repository.deleteUserById(client.id);
            location.reload();
          }
        });
      },

      editClient() {
        this.editingClient = true;
        this.$emit('editClient', this.editingClient)
      }
    },
    amountOfClientsIncreasing() {
      const newList = this.projects
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return a.users.length - b.users.length
      })
      console.log(sortedList)
    },
    amountOfClientsDecreasing() {
      const newList = this.projects
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return b.users.length - a.users.length
      })
      console.log(sortedList)
    },
  }
</script>

