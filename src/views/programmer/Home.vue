<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->
        <div class="card-header border-0 pt-5">
          <h3 class="card-title align-items-start flex-column">
            <span class="card-label fw-bolder fs-3 mb-1">Programmer</span>
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
                <th>Company</th>
                <th>Hours Worked</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="programmer in programmers" v-bind:key="programmer">

                <td>{{ programmer.firstName }}</td>
                <td>{{ programmer.address }}</td>
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
    <div class="d-flex ms-3">
      <a @click="profilePage()" class="btn background-florijn btn-active-info buttonFloatRight" tooltip="New App" data-bs-toggle="modal"
         data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Edit profile-page</a>
    </div>
  </div>
</template>

<script>

import {project} from '@/models/project.js';
import ProgrammerRepository from "@/assets/Repositories/ProgrammerService";
export default {
  name: "ProgrammerHome",
 async created() {
    const programmer = await this.repository.getAllProgrammers()
    console.log(programmer)

    for (let j = 0; j < 3; j++) {
      this.programmers.push(programmer[j])
      console.log(programmer[j].id)
    }
  },
  data() {
    return {
      projects: [],
      programmers: [],
      repository: new ProgrammerRepository()
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

    },
    profilePage(){
      this.$router.push('/programmers/view');
    }
  }
}

</script>

<style scoped>
/*.buttonFloatRight {*/
/*  display: flex;*/
/*  float: right!important;*/
/*}*/
</style>