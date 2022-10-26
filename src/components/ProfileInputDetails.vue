<template>
  <div v-if="this.editProfile === true" class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <!--begin::Card header-->
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Profile Details</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
        <a @click="toProfileDetails()" class="btn background-florijn btn-active-info" tooltip="New App" data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Save profile-page</a>
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
          <div class="fullNameInput">
            <input type="text" class="form-control form-control-solid " id="fullNameLeft" name="search" v-model="sampleProgrammer.firstname" data-kt-search-element="input" />
            <input type="text" class="form-control form-control-solid " id="fullNameRight" name="search" v-model="sampleProgrammer.lastname" data-kt-search-element="input" />
          </div>

        </div>
        <!--end::Col-->
      </div>
      <!--end::Row-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Availability</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.availability" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Address
          <!--          <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Phone number must be active"></i>-->
        </label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 d-flex align-items-center">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.address" data-kt-search-element="input" />
          <!--          <span class="badge badge-success">Verified</span>-->
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Type of Projects</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.projectTypes" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Knowledge
          <i class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Programming Languages Known"></i></label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.knowledge" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Experience</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.experience" data-kt-search-element="input" />
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
          <input type="text" class="form-control form-control-solid " name="search" v-model="sampleProgrammer.workPreference" data-kt-search-element="input" />
        </div>
        <!--begin::Label-->
      </div>
      <!--end::Input group-->
      <!--begin::Notice-->
      <!--      <div class="notice d-flex bg-light-warning rounded border-warning border border-dashed p-6">-->
      <!--        &lt;!&ndash;begin::Icon&ndash;&gt;-->
      <!--        &lt;!&ndash;begin::Svg Icon | path: icons/duotune/general/gen044.svg&ndash;&gt;-->
      <!--        <span class="svg-icon svg-icon-2tx svg-icon-warning me-4">-->
      <!--											<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">-->
      <!--												<rect opacity="0.3" x="2" y="2" width="20" height="20" rx="10" fill="black" />-->
      <!--												<rect x="11" y="14" width="7" height="2" rx="1" transform="rotate(-90 11 14)" fill="black" />-->
      <!--												<rect x="11" y="17" width="2" height="2" rx="1" transform="rotate(-90 11 17)" fill="black" />-->
      <!--											</svg>-->
      <!--										</span>-->
      <!--        &lt;!&ndash;end::Svg Icon&ndash;&gt;-->
      <!--        &lt;!&ndash;end::Icon&ndash;&gt;-->
      <!--        &lt;!&ndash;begin::Wrapper&ndash;&gt;-->
      <!--        <div class="d-flex flex-stack flex-grow-1">-->
      <!--          &lt;!&ndash;begin::Content&ndash;&gt;-->
      <!--          <div class="fw-bold">-->
      <!--            <h4 class="text-gray-900 fw-bolder">We need your attention!</h4>-->
      <!--            <div class="fs-6 text-gray-700">Your payment was declined. To start using tools, please-->
      <!--              <a class="fw-bolder" href="#">Add Payment Method</a>.</div>-->
      <!--          </div>-->
      <!--          &lt;!&ndash;end::Content&ndash;&gt;-->
      <!--        </div>-->
      <!--        &lt;!&ndash;end::Wrapper&ndash;&gt;-->
      <!--      </div>-->
      <!--end::Notice-->
    </div>
    <!--end::Card body-->
  </div>
</template>

<script>
import {Programmer} from "@/models/programmer";

export default {
  name: "ProfileInputDetails",
  props: ['sampleProgrammer'],
  emits: ['saveProfile'],
  created() {
    this.editProgrammer = Programmer.coppyConstructor()
  }
}

</script>

<style scoped>

</style>