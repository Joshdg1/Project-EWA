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

  async created() {
    const data = await this.repository.getAllProjects();

    for (let i = 0; i < data.length; i++) {
      this.projects.push(data[i]);
    }
  },

  data() {
    return {
      projects: [],
      repository: new ProjectRepository(),

    }
  },

  methods: {
    async deleteProject(project) {
      await this.repository.deleteProjectById(project.id);
      location.reload();
    },
  }
}
</script>

<style scoped>

</style>