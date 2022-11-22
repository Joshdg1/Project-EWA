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
            <input type="text" class="form-control form-control-solid " id="fullNameLeft" name="search" v-model="editProfile.firstName" data-kt-search-element="input" />
            <input type="text" class="form-control form-control-solid " id="fullNameRight" name="search" v-model="editProfile.lastName" data-kt-search-element="input" />
          </div>

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
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.email" data-kt-search-element="input" />
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
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.city" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Address

        </label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 d-flex align-items-center">
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.address" data-kt-search-element="input" />
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
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.postcode" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Type of Project
          <em class="fas fa-exclamation-circle ms-1 fs-7" data-bs-toggle="tooltip" title="Programming Languages Known"></em></label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.projectType" data-kt-search-element="input" />
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
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.workPreference" data-kt-search-element="input" />
        </div>
        <!--begin::Label-->
      </div>
      <!--end::Input group-->
    </div>
    <!--end::Card body-->
  </div>
</template>

<script>
import Programmer from "@/models/programmer/programmer";


export default {
  name: "ProfileInputDetails",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],
  created() {
    this.editProfile = Programmer.copyConstructor(this.sampleProgrammer)
  },
  data(){
    return{
      editProfile: new Programmer,
      editingProfile: null,
    }
  },
  methods: {
  async  setEditProfile(){
      this.editingProfile = false
      this.$emit('edit-profile' , this.editingProfile)

    console.log(this.editProfile.firstName)
   await this.repository.updateProgrammerById(1,this.editProfile.firstName, this.editProfile.lastName,
       this.editProfile.email, this.editProfile.address,
        this.editProfile.city, this.editProfile.postcode, this.editProfile.availability, this.editProfile.workPreference,
        this.editProfile.projectType,this.editProfile.skills)
    }
  }
}

</script>

<style scoped>
.fullNameInput {
  display: flex;
  flex-direction: row;
}

#fullNameLeft {
  width: 15vw !important;
  margin-right: .5em;
}

#fullNameRight {
  width: 15vw !important;
}
</style>