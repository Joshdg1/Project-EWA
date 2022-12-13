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
        <label class="col-lg-4 fw-bold text-muted">Firstname</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <div class="fullNameInput">
            <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.firstName" data-kt-search-element="input" />
          </div>

        </div>
        <!--end::Col-->
      </div>
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Lastname</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8">
          <div class="fullNameInput">
            <input type="text" class="form-control form-control-solid "  name="search" v-model="editProfile.lastName" data-kt-search-element="input" />
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
        <label class="col-lg-4 fw-bold text-muted">Phone number</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.phoneNumber" data-kt-search-element="input" />
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
    </div>
    <!--end::Card body-->
  </div>
</template>

<script>
import Programmer from "@/models/programmer/programmer";
import UserRepository from "@/repository/UserRepository";


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
      repository: new UserRepository()
    }
  },
  methods: {

  async  setEditProfile(){

      this.editingProfile = false
      this.$emit('edit-profile' , this.editingProfile)
    // this.$emit('save-profile', this.editProfile)


    console.log(this.editProfile)

   await this.repository.updateProgrammerById(20, this.editProfile.email, this.editProfile.firstName, this.editProfile.lastName,
       this.editProfile.phoneNumber)
    }
  }
}

</script>

<style scoped>
.fullNameInput {
  display: flex;
  flex-direction: row;
}

</style>
