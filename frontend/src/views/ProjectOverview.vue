<template>
<!--<project-admin-details v-if="Administrator === true"></project-admin-details>-->
<!--<project-client-details v-if="Client === true"></project-client-details>-->
<projectsBlockedList v-if="Programmer === true"></projectsBlockedList>
</template>

<script>
// import ProjectAdminDetails from "@/components/projects/ProjectAdminDetails";
//
// import ProjectClientDetails from "@/components/projects/ProjectClientDetails";
import projectsBlockedList from "@/components/ProjectBlockedList";

export default {
  components: { projectsBlockedList},
  name: "ProjectOverview",
  created() {
    const user = sessionStorage.getItem('user')
    switch (user.userType){
      case 'administrator':
        this.Administrator = true
        break;
      case 'programmer':
        this.Programmer = true
        break;
      case 'client':
        this.Client = true
        break;
    }
  },
  data(){
    return {
      Programmer: null,
      Administrator: null,
      Client: null,
    }
  }
}

</script>

<style scoped>

</style>