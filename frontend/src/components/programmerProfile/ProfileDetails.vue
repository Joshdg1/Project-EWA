<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Algemeen</h3>
      </div>
      <div class="d-flex ms-3">
        <div style="margin-top: 20px">
        <a @click="setEditProfile()" class="mb-2 btn btn-sm bg-primary btn-active-info">Wijzigen</a>
        </div>
      </div>
    </div>
    <div class="card-body p-9">
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Voornaam(en)</label>
        <div class="col-lg-8 fv-row">
          <span class="fw-bolder fs-6 text-gray-800">{{sampleProgrammer.firstName}} </span>
        </div>
      </div>
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Achternaam</label>
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{sampleProgrammer.lastName}}</span>
        </div>
      </div>
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Email-adres</label>
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.email }}</span>
        </div>
      </div>
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Telefoonnummer</label>
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.phoneNumber }}</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

import UserRepository from "../../repository/UserRepository";

export default {
  name: "ProfileDetails",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],


  data(){
    return {
      editingProfile: null,
      repository: new UserRepository()
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