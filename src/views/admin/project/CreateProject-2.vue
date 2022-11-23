<template>

  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->
        <div class="card-header border-0 pt-5">
          <h3 class="card-title align-items-start flex-column">
            <span class="card-label fw-bolder fs-3 mb-1">Add programmers to the project</span>
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
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Address</th>
                <th>City</th>
                <th>Postcode</th>
                <th>Knowledge</th>
                <th>Experience</th>
                <th>Availability</th>
                <th>Weekly work hours</th>
                <th>Work space</th>
                <th>Project types</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="programmer in programmers" v-bind:key="programmer">
                <div class="form-check form-check-sm form-check-custom form-check-solid">
                  <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                         data-kt-check-target=".widget-9-check"/>
                </div>
                <td>{{ programmer.firstname }}</td>
                <td>{{ programmer.lastname }}</td>
                <td>{{ programmer.address }}</td>
                <td>{{ programmer.city }}</td>
                <td>{{ programmer.postcode }}</td>
                <td>{{ programmer.knowledge }}</td>
                <td>{{ programmer.experience }}</td>
                <td>{{ programmer.availability }}</td>
                <td>{{ programmer.hours }}</td>
                <td>{{ programmer.workPreference }}</td>
                <td>{{ programmer.projectType }}</td>


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
        <router-link to="/createNewProject" class="btn background-florijn btn-active-info">
          Back
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn background-florijn btn-active-info" @click="createProject">create</button>
      </div>
    </div>
  </div>
</template>

<script>
import Programmer from '../../../models/programmer/programmer.js'
import ProjectRepository from '../../../repository/ProjectRepository'

export default {
  name: "CreateProject-2",

  created() {
    for (let i = 0; i < 8; i++) {
      this.programmers.push(Programmer.createProgrammer());
    }

  },

  data() {
    return {
      programmers: [],
      repository: new ProjectRepository()
    }
  },

  methods: {
    async createProject() {
      const title = localStorage.getItem('title');
      const description = localStorage.getItem('description');
      const company = localStorage.getItem('company');
      const hoursWorked = localStorage.getItem('hoursWorked');

      //@todo add programmers

      await this.repository.createProject(title, description, company, hoursWorked)

      this.$router.push("/");
    }
  }
}
</script>

<style scoped>

</style>
