<template>
  <ProjectAdminView v-if="user.userType === 'administrator'"></ProjectAdminView>
  <client-view  v-else-if="user.userType === 'client'"></client-view>
  <project-programmer-view v-else-if="user.userType === 'programmer'"></project-programmer-view>
</template>

<script>

import ProjectAdminView from "./admin/project/View";
import ClientView from "./client/project/View";
import ProjectProgrammerView from "./programmer/project/View";
export default {
  // eslint-disable-next-line
  name: "ProjectViewGeneral",
  components: {ProjectProgrammerView, ClientView, ProjectAdminView},
  created() {
    this.user = sessionStorage.user ? JSON.parse(sessionStorage.user) : false;
  },

  data() {
    return {
      user: null,
    }
  }
}


</script>
