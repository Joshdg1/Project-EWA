<template>
  <div>
    <projectsList v-if="!this.projectStatus" :projects="this.projects" @deleteProject="deleteProject"
                  @editProject="editProjectStatus"></projectsList>
    <edit v-if="this.projectStatus" :projects="this.projects" @deleteProject="deleteProject"
          @editProject="editProjectStatus"></edit>
  </div>
</template>


<script>


//{project} import is for fake data.
// import {project} from '../../../models/project.js'
import ProjectRepository from '../../../repository/ProjectRepository'
import projectsList from '../../../components/ProjectAdmin.vue'
import edit from '../../../components/ProjectAdminEdit.vue'
import {Project} from "@/models/project";

export default {
  name: "ProjectAdminView",
  components: {
    projectsList,
    edit
  },

  created() {
    for (let i = 0; i < 8; i++) {
      this.projects.push(Project.createProject());
    }
  },

  data() {
    return {
      projects: [],
      projectStatus: null,
      repository: new ProjectRepository(),
    }
  },

  methods: {
    async deleteProject(project) {
      await this.repository.deleteProjectById(project.id);
      location.reload();
    },

    editProjectStatus(projectStatus) {
      this.projectStatus = projectStatus;
    }
  }
}
</script>

<style scoped>

</style>
