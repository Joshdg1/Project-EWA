<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card ">
        <div class="card-header border-0 pt-5">
          <div class="row">
            <div class="col">
              <div class="position-relative mb-5 mb-lg-0">
                <search-icon></search-icon>
                <input type="text" data-kt-ecommerce-order-filter="search"
                       v-model="searchQ"
                       class="form-control form-control-solid w-250px ps-14"
                       placeholder="Zoeken...">
              </div>
            </div>
          </div>
          <div class="card-toolbar">
            <label class="me-3 fs-6">Sorteren op: </label>
            <select class="form-select form-select-sm form-select-solid  me-5 w-200px" v-model="sortType">
              <option value="name-asc">Naam (A-Z)</option>
              <option value="name-desc">Naam (Z-A)</option>
            </select>
            <router-link to="/admins/create" class="btn btn-sm btn-light-primary">
              <plus-icon></plus-icon>Nieuwe Administrator
            </router-link>
          </div>
        </div>

        <clientsList v-if="!this.clientStatus" :clients="resultQuery" @editClient="editClientStatus"></clientsList>
        <edit v-if="this.clientStatus" :clients="resultQuery" @editClient="editClientStatus"></edit>
      </div>
    </div>
  </div>
</template>

<script>
import clientsList from '../../../components/admin/client/Table.vue'
import edit from '../../../components/admin/client/Edit.vue'

import UserRepository from '../../../repository/UserRepository'
import SearchIcon from "../../../components/icons/search";
import PlusIcon from "../../../components/icons/plus";

export default {
  name: "ClientAdminView",
  components: {
    PlusIcon,
    SearchIcon,
    clientsList,
    edit
  },

  data() {
    return {
      clients: [],
      clientStatus: null,
      searchQ: "",
      sortType: "",
      repository: new UserRepository(),
    }
  },

  async created() {
    await this.loadClients();
  },

  methods: {
    async loadClients(){
      console.log('loadClients');
      this.sortType = '';
      this.clients = await this.repository.getAllUsers();
      this.clients = this.clients.filter((x) => {return x.userType === "administrator"})
      this.sortType = 'name-asc';
    },

    editClientStatus(clientStatus) {
      this.clientStatus = clientStatus;

      if (!clientStatus)
       this.loadClients();
    },


    nameAsc() {
      this.clients = this.clients.sort((b, a) => {
        if (a.firstName < b.firstName) {
          return -1;
        }
        if (a.firstName > b.firstName) {
          return 1;
        }
        return 0;
      });
    },
    nameDesc() {
      this.clients = this.clients.sort((b, a) => {
        if (b.firstName < a.firstName) {
          return -1;
        }
        if (b.firstName > a.firstName) {
          return 1;
        }
        return 0;
      });
    },
  },

  watch: {
    sortType: function (newValue) {
      switch (newValue) {
        case "name-asc":
          this.nameAsc()
          break;
        case "name-desc":
          this.nameDesc()
          break;
      }
    }
  },

  computed: {
    resultQuery: function () {
      if (this.searchQ) {
        return this.clients.filter(item => {
          if (this.searchQ
                  .toLowerCase()
                  .split(" ")
                  .every(v => item.firstName.toLowerCase().includes(v))) {
            return this.searchQ
                    .toLowerCase()
                    .split(" ")
                    .every(v => item.firstName.toLowerCase().includes(v));
          } else {
            return this.searchQ
                    .toLowerCase()
                    .split(" ")
                    .every(v => item.lastName.toLowerCase().includes(v));
          }
        })
      } else {
        return this.clients;
      }
    },
  },
}
</script>

<style scoped>

</style>