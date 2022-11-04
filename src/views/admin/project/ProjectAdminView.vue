<template>
  <div>
    <projectsList v-if="!this.projectStatus" :projects="this.projects" @deleteProject="deleteProject"
                  @editProject="editProjectStatus"></projectsList>
    <edit v-if="this.projectStatus" :projects="this.projects" @deleteProject="deleteProject"
          @editProject="editProjectStatus"></edit>
  </div>
</template>


<script>
import {Project} from '../../../models/project.js'
import projectsList from '../../../components/ProjectAdmin.vue'
import edit from '../../../components/ProjectAdminEdit.vue'

export default {
  name: "ProjectAdminView",
  components: {
    projectsList,
    edit
  },

  created() {
    for (let i = 0; i < 8; i++) {
      this.projects.push(Project.fakeData());
    }
  },

  data() {
    return {
      projects: [],
      projectStatus: null
    }
  },

  methods: {
    deleteProject(project) {
      for (let i = 0; i < this.projects.length; i++) {
        if (project === this.projects[i]) {
          this.projects.splice(i, 1);
        }
      }
    },

    editProjectStatus(projectStatus) {
      this.projectStatus = projectStatus;
    }
  }
}
</script>

<style scoped>

</style>