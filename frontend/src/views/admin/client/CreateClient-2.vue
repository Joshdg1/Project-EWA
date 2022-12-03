<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->
        <div class="card-header border-0 pt-5">
          <h3 class="card-title align-items-start flex-column">
            <span class="card-label fw-bolder fs-3 mb-1">Projects</span>
          </h3>
        </div>
        <!--end::Header-->
        <!--begin::Body-->
        <div class="card-body py-3">
          <!--begin::Table container-->
          <div class="table-responsive">
            <!--begin::Table-->
            <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
              <!--begin::Table head-->
              <thead>
              <tr class="fw-bolder text-muted">
                <th class="w-25px">
                  <div class="form-check form-check-sm form-check-custom form-check-solid">
                    <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                           data-kt-check-target=".widget-9-check"/>
                  </div>
                </th>
                <th>Id</th>
                <th>Title</th>
                <th>Description</th>
                <th>Company</th>
                <th>Hours worked</th>
                <th>Programmer(s)</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="project in projects" v-bind:key="project">
                <div class="form-check form-check-sm form-check-custom form-check-solid">
                  <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                         data-kt-check-target=".widget-9-check"/>
                </div>
                <td>{{ project.id }}</td>
                <td>{{ project.title }}</td>
                <td>{{ project.description }}</td>
                <td>{{ project.company }}</td>
                <td>{{ project.hoursWorked }}</td>
                <td>{{ project.programmers }}</td>

              </tr>
              </tbody>
              <!--end::Table body-->
            </table>
            <!--end::Table-->
          </div>
          <!--end::Table container-->
        </div>
        <!--begin::Body-->
      </div>
      <!--end::Tables Widget 3-->
    </div>
    <div class="d-flex flex-shrink-0">
      <div class="d-flex ms-3">
        <router-link to="/createNewClient" class="btn background-florijn btn-active-info">
          Back
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn background-florijn btn-active-info" @click="createClient">create</button>
      </div>
    </div>

  </div>
</template>


<script>


//{project} import is for fake data.
// import {project} from '../../../models/project.js'
import ProjectRepository from '../../../repository/ProjectRepository'
import ClientRepository from '../../../repository/ClientRepository'


export default {
  name: "CreateClient-2",

  async created() {
    const data = await this.ProjectRepository.getAllProjects();

    for (let i = 0; i < data.length; i++) {
      this.projects.push(data[i]);
    }
  },

  data() {
    return {
      projects: [],
      ProjectRepository: new ProjectRepository(),
      ClientRepository: new ClientRepository()
    }
  },

  methods: {

    async createClient() {
      const name = localStorage.getItem('name');
      const email = localStorage.getItem('email');
      const address = localStorage.getItem('address');
      const city = localStorage.getItem('city');
      const postcode = localStorage.getItem('postcode');
      const projectType = localStorage.getItem('projectType');

      await this.ClientRepository.createClient(name, email, address, city, postcode, projectType);

      this.$router.push("/clients");
    }
  }
}
</script>

<style scoped>

</style>
