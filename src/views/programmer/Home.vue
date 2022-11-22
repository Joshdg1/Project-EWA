<template>
 <div class="row">
   <Programmers v-if="!this.editProfile" :programmers="this.programmers" @edit-status="editStatus"></Programmers>
   <ProgrammersEdit  v-if="this.editProfile === true" :programmers="this.programmers" @edit-status="editStatus"></ProgrammersEdit>
 </div>
</template>

<script>

import ProgrammerRepository from "@/assets/Repositories/ProgrammerService";
import Programmers from "@/components/programmersPage/Programmers";
import ProgrammersEdit from "@/components/programmersPage/ProgrammersEdit";
export default {
  name: "ProgrammerHome",
  components:{
    Programmers, ProgrammersEdit
  },
 async created() {
    const programmer = await this.repository.getAllProgrammers()
    console.log(programmer)

    for (let j = 0; j < programmer.length; j++) {
      this.programmers.push(programmer[j])
      console.log(programmer[j].id)
    }
  },
  data() {
    return {
      projects: [],
      programmers: [],
      editProfile: null,
      repository: new ProgrammerRepository()
    }
  },

  methods:{
    // createProject()
    // {
    //   this.projects.push("alle project ophalen en hier neerzettten")
    //   "project moet in array worden gezet."
    // },
  editStatus(status){
    this.editProfile = status
  }


  }
}

</script>

<style scoped>
/*.buttonFloatRight {*/
/*  display: flex;*/
/*  float: right!important;*/
/*}*/
</style>