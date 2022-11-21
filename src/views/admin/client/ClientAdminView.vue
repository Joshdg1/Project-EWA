<template>
  <div>
    <clientsList v-if="!this.clientStatus" :clients="this.clients" @deleteClient="deleteClient"
                  @editClient="editClientStatus"></clientsList>
    <edit v-if="this.clientStatus" :clients="this.clients" @deleteClient="deleteClient"
          @editClient="editClientStatus"></edit>
  </div>
</template>

<script>
import Client from '../../../models/client.js'
import clientsList from '../../../components/ClientAdmin.vue'
import edit from '../../../components/ClientAdminEdit.vue'

export default {
  name: "ClientAdminView",
  components: {
    clientsList,
    edit
  },

  created() {
    for (let i = 0; i < 8; i++) {
      this.clients.push(Client.createClient());
    }
  },

  data() {
    return {
      clients: [],
      clientStatus: null
    }
  },
  methods:{
    deleteClient(client){
      for (let i = 0; i < this.clients.length; i++) {
        if (client === this.clients[i])
        {
          this.clients.splice(i, 1);
        }
      }
    },

    editClientStatus(clientStatus) {
      this.clientStatus = clientStatus;
    }
  }

}
</script>

<style scoped>

</style>