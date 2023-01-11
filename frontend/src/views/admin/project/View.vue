<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card ">
        <div class="card-header border-0 pt-5">
          <div class="row">
            <div class="col">
              <div class="position-relative mb-5 mb-lg-0">
                <search-icon></search-icon>
                <input type="text"
                       v-model="searchQ"
                       class="form-control form-control-solid w-250px ps-14"
                       placeholder="Zoeken...">
              </div>
            </div>
          </div>
          <div class="card-toolbar">
            <label class="me-3 fs-6">Sorteren op: </label>
            <select class="form-select form-select-sm form-select-solid  me-5 w-200px" v-model="sortType">
              <option value="name-asc">Naam (A-Z)</option>
              <option value="name-desc">Naam (Z-A)</option>
            </select>
            <router-link to="/projects/create" class="btn btn-sm btn-light-primary">
              <plus-icon></plus-icon>Nieuw Project
            </router-link>
          </div>
        </div>
        <projectsList v-if="!this.projectStatus" :projects="this.resultQuery" @editProject="editProjectStatus"></projectsList>
        <edit v-if="this.projectStatus" :projects="this.resultQuery" @editProject="editProjectStatus"></edit>
      </div>
    </div>
  </div>
</template>
<script>


import ProjectRepository from '../../../repository/ProjectRepository'

import projectsList from '../../../components/admin/project/Table.vue'
import edit from '../../../components/admin/project/Edit.vue'
import PlusIcon from "../../../components/icons/plus";
import SearchIcon from "../../../components/icons/search";


export default {
  name: "ProjectAdminView",
  components: {
    SearchIcon,
    PlusIcon,
    projectsList,
    edit
  },

  async created() {
    await this.loadProjects();
  },

  data() {
    return {
      searchQ: "",
      sortType: "",
      projects: [],
      projectStatus: null,
      repository: new ProjectRepository(),
    }
  },

  methods: {
    async loadProjects(){
      console.log('loadProjects');
      this.sortType = '';
      this.projects = [];
      for (const project of await this.repository.getAllProjects()) {
        project.startDate = this.dateFormat(project.startDate);
        project.endDate = this.dateFormat(project.endDate);
        this.projects.push(project);
      }
      this.sortType = 'name-asc';
    },

    dateFormat(date) {
      if (date == null) {
        return null;
      }
      return new Date(date).toISOString().slice(0, 10);
    },
    editProjectStatus(projectStatus) {
      this.projectStatus = projectStatus;

      if (!projectStatus)
        this.loadProjects();
    },

    nameAsc() {
      this.projects = this.projects.sort((b, a) => {
        if (a.title < b.title) {
          return -1;
        }
        if (a.title > b.title) {
          return 1;
        }
        return 0;
      });
    },
    nameDesc() {
      this.projects = this.projects.sort((b, a) => {
        if (b.title < a.title) {
          return -1;
        }
        if (b.title > a.title) {
          return 1;
        }
        return 0;
      });
    },

  },
  watch: {
    sortType: function (newValue) {
      switch (newValue) {
        case "name-asc":
          this.nameAsc()
          break;
        case "name-desc":
          this.nameDesc()
          break;
      }
    }
  },

  computed: {
    resultQuery: function () {
      if (this.searchQ) {
        return this.projects.filter(item => {
            return this.searchQ
                    .toLowerCase()
                    .split(" ")
                    .every(v => item.title.toLowerCase().includes(v));
        })
      } else {
        return this.projects;
      }
    },
  }
}
</script>

<style scoped>

</style>
