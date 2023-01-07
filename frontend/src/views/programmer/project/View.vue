<template>
  <div>
    <projectsBlockedList :projects="this.programmerProjects" ></projectsBlockedList>
  </div>
</template>


<script>

import ProjectRepository from '../../../repository/ProjectRepository'
import projectsBlockedList from '../../../components/ProjectBlockedList.vue'
import UserRepository from "@/repository/UserRepository";


export default {
  name: "ProjectProgrammerView",
  components: {
    projectsBlockedList,
  },

  async created() {

    this.userID = sessionStorage.getItem("id")

    const data = await this.repository.getAllProjects();

    for (const element of data) {
      this.projects.push(element);
    }
    console.log("PROJECT "+this.projects.length)
    for (const element of this.projects) {
      for (let j = 0; j < element.users.length; j++) {
        if ((element.users[j].id).toString() === this.userID) {
          this.programmerProjects.push(element)
          }
      }
    }
    console.log("PROGRMMAAR PROJECTS" + this.programmerProjects.length)
  },

  data() {
    return {
      users: [],
      programmerProjects: [],
      projects: [
        // {
        //   id: 69,
        //   title: 'project',
        //   description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.',
        //   company: 'company',
        //   programmers: 'programmers',
        //   hours: 16,
        // },
        // {
        //   id: 420,
        //   title: 'project',
        //   description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.',
        //   company: 'company',
        //   programmers: 'programmers',
        //   hours: 12,
        // }
      ],
      userRepository: new UserRepository(),
      userID: null,
      repository: new ProjectRepository(),
    }
  },
}
</script>

<style scoped>

</style>
