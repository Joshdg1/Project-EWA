<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->
        <div class="card-header border-0 pt-5">
          <h3 class="card-title align-items-start flex-column">
            <span class="card-label fw-bolder fs-3 mb-1">Projects</span>
          </h3>
          <div class="card-toolbar" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-trigger="hover"
               title="Click to add a user">
          </div>
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
                <th>Title</th>
                <th>Description</th>
                <th>Hours Worked By Programmer</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="project in projects" v-bind:key="project">
                <td>{{ project.title }}</td>
                <td>{{ project.description }}</td>
                <td>{{ project.hoursWorked }}</td>
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
  </div>
</template>

<script>

import {project} from "../../models/project";

export default {
  name: "ClientHomePage",
  created() {
    this.fake();
    this.fake();
    this.fake();
  },
  data() {
    return {
      projects: [],
    }
  },

  methods:{
    // createProject()
    // {
    //   this.projects.push("alle project ophalen en hier neerzettten")
    //   "project moet in array worden gezet."
    // },
    fake(){
      project.fakeData()
      this.projects.push(project.fakeData())

    }
  }
}

</script>

<style scoped>

</style>