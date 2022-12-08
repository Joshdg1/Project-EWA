<template>
  <div  class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <!--begin::Card header-->
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Profile Details</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
        <a @click="setEditProfile()" class="btn background-florijn btn-active-info" tooltip="New App" data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Edit profile-page</a>
      </div>
      <!--end::Action-->
    </div>
    <!--begin::Card header-->
    <!--begin::Card body-->
    <div class="card-body p-9">
      <!--begin::Row-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Full Name</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <span class="fw-bolder fs-6 text-gray-800">{{sampleProgrammer.firstName}} {{sampleProgrammer.lastName}}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Row-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">E-mail address</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.email }}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">City</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <span class="fw-bolder fs-6 text-gray-800">{{ sampleProgrammer.city }}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->

      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Address
          <!--            <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Phone number must be active"></i>-->
        </label>
        <!--end::Label-->

        <!--begin::Col-->
        <div class="col-lg-8 d-flex align-items-center">
          <span class="fw-bolder fs-6 me-2 text-gray-800">{{ sampleProgrammer.address }}</span>
          <!--          <span class="badge badge-success">Verified</span>-->
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Postcode</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <a href="#" class="fw-bold fs-6 text-gray-800 text-hover-primary">{{ sampleProgrammer.postcode }}</a>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Project Type
          <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Programming languages known"></i></label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <span class="fw-bolder fs-6 text-gray-800">{{ sampleProgrammer.projectType }}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-10">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Work preference</label>
        <!--begin::Label-->
        <!--begin::Label-->
        <div class="col-lg-8">
          <span class="fw-bold fs-6">{{ sampleProgrammer.workPreference }}</span>
        </div>
        <!--begin::Label-->
      </div>
      <!--end::Input group-->
    </div>
    <!--end::Card body-->
  </div>
</template>

<script>
import ProgrammerRepository from "@/repository/ProgrammerService";

export default {
  name: "ProfileDetails",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],


  data(){
    return {
      editingProfile: null,
      repository: new ProgrammerRepository()
    }
  },
  methods: {
    setEditProfile(){
      this.editingProfile = true
      this.$emit('edit-profile' , this.editingProfile)
    }
  }
}
</script>

<style scoped>

</style>