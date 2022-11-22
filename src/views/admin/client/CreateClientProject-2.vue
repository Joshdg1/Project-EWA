<template>

  <div>
    <div class="row">
      <div class="col-lg-12">
        <div class="card card-xl-stretch mb-5 mb-xl-8">
          <!--begin::Header-->
          <div class="card-header border-0 pt-5">
            <h3 class="card-title align-items-start flex-column">
              <span class="card-label fw-bolder fs-3 mb-1">Add programmers to the project</span>
            </h3>

            <div class="d-flex flex-row">
              <input class="form-control m-2" v-model="programmerNameFilter" v-on:keyup="FilterFn()"
                     placeholder="Name filter">
            </div>

            <div class="d-flex flex-row">
              <input class="form-control m-2" v-model="skillNameFilter" v-on:keyup="FilterFn()"
                     placeholder="Knowledge filter">
            </div>

            <div class="d-flex flex-row">
              <input class="form-control m-2" v-model="workSpaceFilter" v-on:keyup="FilterFn()"
                     placeholder="Workspace">
            </div>

            <div class="d-flex flex-row">
              <input class="form-control m-2" v-model="projectTypeFilter" v-on:keyup="FilterFn()"
                     placeholder="Project type filter">
            </div>

<!--             <multiselect-->
<!--                  v-model="skillNameFilter"-->
<!--                  :options="options"-->
<!--                  :multiple="true"-->
<!--                  :close-on-select="true"-->
<!--                  placeholder="Pick some"-->
<!--                  label="name"-->
<!--                  track-by="name"-->
<!--                  >-->
<!--              </multiselect>-->
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
                  <th>Actions</th>
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
                  <td>
                    <button class="btn background-florijn btn-active-info">Add</button>
                  </td>
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
          <router-link to="/" class="btn background-florijn btn-active-info">
            Submit
          </router-link>
        </div>

      </div>

    </div>
  </div>
</template>

<script>
import Programmer from '../../../models/programmer/programmer.js'
// import Multiselect from 'vue-multiselect'
// import Vue from "vue";
//
// Vue.component('multi-select', Multiselect)

export default {
  // components: {Multiselect},
  name: "CreateClientProject-2",

  created() {
    for (let i = 0; i < 8; i++) {
      this.programmers.push(Programmer.createProgrammer());
      this.skillWithoutFilter.push(Programmer.createProgrammer());
    }
  },

  data() {
    return {
      programmers: [],
      skillWithoutFilter: [],
      projectTypeFilter: "",
      skillNameFilter: "",
      workSpaceFilter:"",
      programmerNameFilter: "",
      options: [
        {name: 'JAVA', language: 'JavaScript'},
        {name: 'HTML', language: 'JavaScript'},
        {name: 'CSS', language: 'CSS'},
        {name: 'C#', language: 'C#'},
        {name: 'PHP', language: 'PHP'},
      ],
      isActive: false
    }
  },
  methods: {
    FilterFn() {
      let skillNameFilter = this.skillNameFilter;
      let projectTypeFilter = this.projectTypeFilter;
      let workSpaceFilter = this.workSpaceFilter;
      let programmerNameFilter = this.programmerNameFilter;

      this.programmers = this.skillWithoutFilter.filter(
          function (el) {
            return el.knowledge.toString().toLowerCase().includes(
                skillNameFilter.toString().trim().toLowerCase()
            )&&
                el.projectType.toString().toLowerCase().includes(
                projectTypeFilter.toString().trim().toLowerCase()
            )&&
                el.workPreference.toString().toLowerCase().includes(
                    workSpaceFilter.toString().trim().toLowerCase()
                )&&
                el.firstname.toString().toLowerCase().includes(
                    programmerNameFilter.toString().trim().toLowerCase()
                )
          }
      )

    },
    tgl(){
      this.isActive = !this.isActive
    }
  },

  computed: {},
}

</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>

</style>