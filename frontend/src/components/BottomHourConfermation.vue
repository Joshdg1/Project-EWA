<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <!--begin::Card header-->
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">uren acceptatie</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->

      <!--end::Action-->
    </div>
    <!--begin::Card header-->
    <!--begin::Card body-->
    <div class="card-body p-9">
      <!--begin::Row-->
      <div class="table-responsive">
        <!--begin::Table-->
        <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
          <!--begin::Table head-->
          <thead>
          <tr class="fw-bolder text-muted">
            <th class="w-25px">
              <div class="form-check form-check-sm form-check-custom form-check-solid">

              </div>
            </th>

            <th>Naam</th>
            <th>Project</th>
            <th>Email</th>
            <th>Uren</th>
            <th>geaccepteerd</th>

          </tr>
          </thead>
          <!--end::Table head-->
          <!--begin::Table body-->
          <tbody>
          <tr v-for="project in userHours" v-bind:key="project.id">
            <div class="form-check form-check-sm form-check-custom form-check-solid">

            </div>
            <td>{{ project.user.firstName }}</td>
            <td>{{ project.project.title }}</td>
            <td>{{ project.user.email }}</td>
            <td>{{ project.hours }}</td>
            <td v-html="checkForApproved(project)"></td>


            <div class="d-flex justify-content-end flex-shrink-0" >
              <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="approveHours(project)">
                <!--begin::Svg Icon | path: icons/duotune/art/art005.svg-->
                <span class="svg-icon svg-icon-3">
                <svg width="800px" height="800px" viewBox="0 0 32 32" xmlns="http://www.w3.org/2000/svg">
                <path class="cls-1"
                      d="M12.16,28a3,3,0,0,1-2.35-1.13L3.22,18.62a1,1,0,0,1,1.56-1.24l6.59,8.24A1,
                     1,0,0,0,13,25.56L27.17,4.44a1,1,0,1,1,1.66,1.12L14.67,26.67A3,3,0,0,1,12.29,28Z"/>
                </svg>
                </span>
                <!--end::Svg Icon-->
              </a>
              <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="rejectHours(project)">
                <!--begin::Svg Icon | path: icons/duotune/general/gen027.svg-->
                <span class="svg-icon svg-icon-3">
																			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                           fill="none">
																				<path
                                            d="M5 9C5 8.44772 5.44772 8 6 8H18C18.5523 8 19 8.44772 19 9V18C19 19.6569 17.6569 21 16 21H8C6.34315 21 5 19.6569 5 18V9Z"
                                            fill="black"/>
																				<path opacity="0.5"
                                              d="M5 5C5 4.44772 5.44772 4 6 4H18C18.5523 4 19 4.44772 19 5V5C19 5.55228 18.5523 6 18 6H6C5.44772 6 5 5.55228 5 5V5Z"
                                              fill="black"/>
																				<path opacity="0.5"
                                              d="M9 4C9 3.44772 9.44772 3 10 3H14C14.5523 3 15 3.44772 15 4V4H9V4Z"
                                              fill="black"/>
																			</svg>
																		</span>
              </a>
            </div>

          </tr>
          </tbody>
          <!--end::Table body-->
        </table>
        <!--end::Table-->
      </div>

    </div>
    <!--end::Card body-->
  </div>
</template>

<script>


import UserRepository from "@/repository/UserRepository";
import HourRepository from "@/repository/HourRepository";


export default {
  name: "BottomHourConformation",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],
  async created() {
    this.userHours = await this.hoursRepository.getHoursByProject(this.sampleProgrammer)
    console.log(this.userHours)

  },
  data() {
    return {
      editingProfile: null,
      userHours: [],
      repository: new UserRepository(),
      hoursRepository: new HourRepository(),
    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = true
      this.$emit('edit-profile', this.editingProfile)
    },
    checkForApproved(project) {
      console.log("KOMT BINNEN")
      console.log(project.isApproved)
      let content = null
      if (project.isApproved === null) {
        content = '<span class="badge badge-light-warning">Lopend</span>'
      } else if (project.isApproved === "rejected") {
        content = '<span class="badge badge-light-danger">Afgewezen</span>'
      } else if (project.isApproved === "approved") {
        content = '<span class="badge badge-light-success">Goedgekeurd</span>'
      }
      console.log(content)
      return content
    },
    async rejectHours(project) {
      project.isApproved = "rejected"
      await this.hoursRepository.updateHoursById(project.id, project.project, project.hours, project.user.id, project.isApproved)
      this.userHours = await this.hoursRepository.getHoursByProject(this.sampleProgrammer)
    },
    async approveHours(projectsr) {
      projectsr.isApproved = "approved"
      await this.hoursRepository.updateHoursById(projectsr.id, projectsr.project, projectsr.hours, projectsr.user.id, projectsr.isApproved)
      this.userHours = await this.hoursRepository.getHoursByProject(this.sampleProgrammer)
    }
  }
}
</script>

<style scoped>

</style>