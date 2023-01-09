<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->
        <div class="card-header border-0 pt-5">
          <h3 class="card-title align-items-start flex-column">
            <span class="card-label fw-bolder fs-3 mb-1">Projecten</span>
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
                <th>Titel</th>
                <th>Beschrijving</th>
                <th>Bedrijf</th>
                <th>Gewerkte uren</th>
                <th>Begindatum</th>
                <th>Einddatum</th>
                <th>Gebruiker(s)</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="project in projects" v-bind:key="project.id">
                <div class="form-check form-check-sm form-check-custom form-check-solid">
                  <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                         data-kt-check-target=".widget-9-check"/>
                </div>
                <td>{{ project.id }}</td>
                <td>{{ project.title }}</td>
                <td>{{ project.description }}</td>
                <td>{{ project.company }}</td>
                <td>{{ project.hoursWorked }}</td>
                <td>{{ dateFormat(project.startDate) }}</td>
                <td>{{ dateFormat(project.endDate) }}</td>
                <td v-html="getUserProjects(project.users)"></td>

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
        <router-link to="/createNewClient" class="btn bg-primary btn-active-info">
          Terug
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn bg-primary btn-active-info" @click="createClient">Creëer</button>
      </div>
    </div>

  </div>
</template>


<script>


//{project} import is for fake data.
// import {project} from '../../../models/project.js'
import ProjectRepository from '../../../repository/ProjectRepository'
import UserRepository from '../../../repository/UserRepository'


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
      UserRepository: new UserRepository()
    }
  },

  methods: {

    async createClient() {
      const email = localStorage.getItem('email');
      const firstname = localStorage.getItem('firstname');
      const lastname = localStorage.getItem('lastname');
      const password = localStorage.getItem('password');
      const phoneNumber = localStorage.getItem('phoneNumber');
      const companyName = localStorage.getItem('companyName');
      const usertype = "client";
      console.log(firstname, password)

      await this.UserRepository.createUser(email, firstname, lastname, password, phoneNumber, companyName, usertype);

      this.$router.push("/clients");
    },

    dateFormat(date) {
      if (date == null) {
        return null;
      }
      return new Date(date).toLocaleDateString('en-GB');
    },

    getUserProjects(users) {
      console.log(users)
      if (users.length === 0)
        return "";

      let content = `<div class="symbol-group symbol-hover flex-nowrap">`;
      for (const user of users) {
        content += `<div title="${user.firstName} ${user.lastName}" class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
      data-bs-original-title="Susan Redwood" data-kt-initialized="1">
              <span class="symbol-label bg-primary text-inverse-primary fw-bold">${(user.firstName[0]).toUpperCase()}</span>
              </div>`;
      }
      content += `</div>`;


      return content
    }
  }
}
</script>

<style scoped>

</style>
