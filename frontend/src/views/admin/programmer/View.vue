<template>
  <div>
    <programmersList v-if="!this.programmerStatus" :programmers="this.programmers" @deleteProgrammer="deleteProgrammer"
                     @editProgrammer="editProgrammerStatus"></programmersList>
    <edit v-if="this.programmerStatus" :programmers="this.programmers" @deleteProgrammer="deleteProgrammer"
          @editProgrammer="editProgrammerStatus"></edit>
  </div>
</template>

<script>
import programmersList from '../../../components/ProgrammerAdmin'
import edit from '../../../components/ProgrammerAdminEdit'
import UserRepository from '../../../repository/UserRepository'

export default {
  name: "AdminProgrammerView",
  components: {
    programmersList,
    edit
  },

  async created() {
    await this.loadProgrammers();
  },

  data() {
    return {
      programmers: [],
      programmerStatus: null,
      repository: new UserRepository(),
    }
  },

  methods: {
    async loadProgrammers(){
      console.log('loadProgrammers');
      this.programmers = await this.repository.getAllProgrammers();
    },

    async deleteProgrammer(programmer) {
      await this.$swal({     title: "Wil je deze programmeur verwijderen?",     text: "Weet je het zeker?",
        type: "warning",     showCancelButton: true,     confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer" }).then((result) => { if (result.value) {
          this.repository.deleteUserById(programmer.id); location.reload();} });
    },

    editProgrammerStatus(programmerStatus) {
      this.programmerStatus = programmerStatus;

      if (!programmerStatus)
        this.loadProgrammers();
    }
  },
}
</script>

<style scoped>

</style>