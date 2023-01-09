<template>
  <div>
    <projectsBlockedList v-if="projectDetails === false" @selecting-project="selectProject"   ></projectsBlockedList>
    <projectClientDetails v-if="projectDetails === true" :project="selectedProject"
                              @view-project ="setProjectDetails"></projectClientDetails>
  </div>
</template>


<script>

import projectsBlockedList from '../../../components/ProjectBlockedList.vue';
import projectClientDetails from "@/components/projects/ProjectClientDetails";


export default {
  name: "Client-view",
  components: {
    projectsBlockedList, projectClientDetails
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


      this.selectedProject = project
      this.projectDetails = true
    }
  }
}

</script>

<style scoped>

</style>
