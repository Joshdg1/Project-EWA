<template>
  <div>
  <programmersList v-if="!this.programmerStatus" :programmers="this.programmers" @deleteProgrammer="deleteProgrammer"
                   @editProgrammer="editProgrammerStatus"></programmersList>
  <edit v-if="this.programmerStatus" :programmers="this.programmers" @deleteProject="deleteProgrammer"
        @editProgrammer="editProgrammerStatus"></edit>
  </div>
</template>

<script>
import Programmer from '../../../models/programmer.js'
import programmersList from '../../../components/ProgrammerAdmin'
import edit from '../../../components/ProgrammerAdminEdit'

export default {
  name: "AdminProgrammerView",
  components: {
    programmersList,
    edit
  },

  created() {
    for (let i = 0; i < 8; i++) {
      this.programmers.push(Programmer.createProgrammer());
    }
  },

  data() {
    return {
      programmers: [],
      programmerStatus: null
    }
  },

  methods: {
    deleteProgrammer(programmer) {
      for (let i = 0; i < this.programmers.length; i++) {
        if (programmer === this.programmers[i]) {
          this.programmers.splice(i, 1);
        }
      }
    },

    editProgrammerStatus(programmerStatus) {
      this.programmerStatus = programmerStatus;
      console.log(programmerStatus)
    }
  },
}
</script>

<style scoped>

</style>