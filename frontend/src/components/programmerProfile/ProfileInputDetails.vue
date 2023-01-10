<template>
  <div  class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Algemeen</h3>
      </div>
      <div class="d-flex ms-3">
          <div style="margin-top: 20px">
            <a @click="setEditProfile()" class="btn btn-sm bg-primary btn-active-info">Opslaan</a>
        </div>
      </div>
    </div>
    <div class="card-body p-9">
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Voornaam(en)</label>
        <div class="col-lg-8">
          <div class="fullNameInput">
            <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.firstName" data-kt-search-element="input" />
          </div>
        </div>
      </div>
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Achternaam</label>
        <div class="col-lg-8">
          <div class="fullNameInput">
            <input type="text" class="form-control form-control-solid "  name="search" v-model="editProfile.lastName" data-kt-search-element="input" />
          </div>
        </div>
      </div>
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Email-adres</label>
        <div class="col-lg-8 fv-row">
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.email" data-kt-search-element="input" />
        </div>
      </div>
      <div class="row mb-7">
        <label class="col-lg-4 fw-bold text-muted">Telefoonnummer</label>
        <div class="col-lg-8 fv-row">
          <input type="text" class="form-control form-control-solid " name="search" v-model="editProfile.phoneNumber" data-kt-search-element="input" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import User from "@/models/user";
  import UserRepository from "@/repository/UserRepository";


  export default {
    name: "ProfileInputDetails",
    props: ['sampleProgrammer'],
    emits: ['edit-profile'],
    created() {
      this.editProfile = User.copyConstructor(this.sampleProgrammer)
    },
    data() {
      return {
        editProfile: new User,
        editingProfile: null,
        repository: new UserRepository()
      }
    },
    methods: {
      async setEditProfile() {
        this.editingProfile = false
        this.$emit('edit-profile', this.editingProfile)
        const userID = sessionStorage.getItem("id")
        await this.repository.updateUserById(userID, this.editProfile.email, this.editProfile.firstName, this.editProfile.lastName, this.editProfile.phoneNumber)
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
