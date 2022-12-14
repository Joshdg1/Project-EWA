<template>
  <div>
    <projectsBlockedList :projects="this.programmerProjects" ></projectsBlockedList>
  </div>
</template>


<script>


//{project} import is for fake data.
// import {project} from '../../../models/project.js'
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
    console.log(this.userID)

    const data = await this.repository.getAllProjects();

    for (let i = 0; i < data.length; i++) {
      this.projects.push(data[i]);
    }
    console.log("PROJECT "+this.projects)
    for (let i = 0; i < this.projects.length; i++) {
      console.log("ALLPROJECTS " + this.projects[i])
      console.log("ALL USERS " + this.projects[i].users)
      console.log("ALL USERS LENGTH" + this.projects[i].users.length)

      for (let j = 0; j < this.projects[i].users.length; j++) {
        console.log("USER ID " + typeof this.projects[i].users[j].id)

          if ((this.projects[i].users[j].id).toString() === this.userID ){
            console.log("ZIT IK AAN VAST")
            this.programmerProjects.push(this.projects[i])
          }
      }
      console.log()
    }


    // for (const user in users){
    //   console.log("EYO")
    //   // console.log("User" + user.firstname)
    // }
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
