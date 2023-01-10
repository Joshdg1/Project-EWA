<template>
  <div>
    <projectsBlockedList v-if="projectDetails === false" @selecting-project="selectProject"   ></projectsBlockedList>
    <ProjectProgrammerDetails v-if="projectDetails === true" :project="selectedProject"
                              @view-project ="setProjectDetails"></ProjectProgrammerDetails>
  </div>
</template>


<script>

import projectsBlockedList from '../../../components/ProjectBlockedList.vue';
import ProjectProgrammerDetails from "@/components/projects/ProjectProgrammerDetails";


export default {
  name: "ProjectProgrammerView",
  components: {
    projectsBlockedList, ProjectProgrammerDetails
  },
  data(){
    return{
      projectDetails: false,
      selectedProject: null
    }
  },
  methods: {
    setProjectDetails(projectStatus){

      this.projectDetails = projectStatus


    },
    selectProject(project){

        console.log("KOMT ER IN")
        this.selectedProject = project
      this.projectDetails = true
    }
  }
}

</script>

<style scoped>

</style>
