<template>
  <div>
    <projectsBlockedList  ></projectsBlockedList>
  </div>
</template>


<script>

import ProjectRepository from '../../../repository/ProjectRepository'
import projectsBlockedList from '../../../components/ProjectBlockedList.vue'
import UserRepository from "@/repository/UserRepository";
import HourRepository from "@/repository/HourRepository";


export default {
  name: "ProjectProgrammerView",
  components: {
    projectsBlockedList,
  },

  async created() {

  },

  data() {
    return {
      users: [],
      programmerProjects: [],
      projects: [

      ],
      userRepository: new UserRepository(),
      userID: null,
      hourRepository: new HourRepository(),
      repository: new ProjectRepository(),
    }
  },
}
</script>

<style scoped>

</style>
