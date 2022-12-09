<template>
  <div>
    <projectsBlockedList :projects="this.projects" ></projectsBlockedList>
  </div>
</template>


<script>


//{project} import is for fake data.
// import {project} from '../../../models/project.js'
import ProjectRepository from '../../../repository/ProjectRepository'
import projectsBlockedList from '../../../components/ProjectBlockedList.vue'


export default {
  name: "ProjectProgrammerView",
  components: {
    projectsBlockedList,
  },

  async created() {
    const data = await this.repository.getAllProjects();

    for (let i = 0; i < data.length; i++) {
      this.projects.push(data[i]);
    }
  },

  data() {
    return {
      projects: [
        {
          id: 69,
          title: 'project',
          description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.',
          company: 'company',
          programmers: 'programmers',
          hours: 16,
        },
        {
          id: 420,
          title: 'project',
          description: 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.',
          company: 'company',
          programmers: 'programmers',
          hours: 12,
        }
      ],
      repository: new ProjectRepository(),
    }
  },
}
</script>

<style scoped>

</style>
