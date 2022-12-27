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
      projectStatus: null,
      repository: new ProjectRepository(),
    }
  },

  methods: {
    async deleteProject(project) {
      await this.$swal({
        title: "Wil je dit project verwijderen?", text: "Weet je het zeker?",
        type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
      }).then((result) => {
        if (result.value) {
          this.repository.deleteProjectById(project.id);
          location.reload();
        }
      });
    },

    editProjectStatus(projectStatus) {
      this.projectStatus = projectStatus;
    }
  }
}
</script>

<style scoped>

</style>
