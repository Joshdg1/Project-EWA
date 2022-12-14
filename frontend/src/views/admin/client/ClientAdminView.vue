<template>
  <div>
    <clientsList v-if="!this.clientStatus" :clients="this.clients" @deleteClient="deleteClient"
                  @editClient="editClientStatus"></clientsList>
    <edit v-if="this.clientStatus" :clients="this.clients" @deleteClient="deleteClient"
          @editClient="editClientStatus"></edit>
  </div>
</template>

<script>
import clientsList from '../../../components/ClientAdmin.vue'
import edit from '../../../components/ClientAdminEdit.vue'
import UserRepository from '../../../repository/UserRepository'

export default {
  name: "ClientAdminView",
  components: {
    clientsList,
    edit
  },

  data() {
    return {
      clients: [],
      clientStatus: null,
      repository: new UserRepository()
    }
  },

  async created() {
    const data = await this.repository.getAllClients();

    for (let i = 0; i < data.length; i++) {
      this.clients.push(data[i]);
    }
  },

  methods:{
    async deleteClient(client) {
      await this.repository.deleteUserById(client.id);
      location.reload();
    },

    editClientStatus(clientStatus) {
      this.clientStatus = clientStatus;
    }
  }

}
</script>

<style scoped>

</style>