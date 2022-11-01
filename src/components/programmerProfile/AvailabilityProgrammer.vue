<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Availability</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
        <a @click="setEditProfile()" class="btn background-florijn btn-active-info" tooltip="New App"
           data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Edit profile-page</a>
      </div>
      <!--end::Action-->
    </div>
  </div>
</template>

<script>
export default {
  name: "AvailabilityCardProgrammerProfile",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],
  data() {
    return {
      editingProfile: null
    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = true
      this.$emit('edit-profile', this.editingProfile)
    }
  }
}
</script>

<style scoped>

</style>