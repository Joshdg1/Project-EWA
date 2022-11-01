<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Skills</h3>
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
    <div class="card-body p-9">

      <div class="skillCard"
           v-for="skill in skills"
          v-bind:key="skill"
      >
        <div class="container">
          <h3>{{ skill.name }}</h3>
          <h3>{{ skill.level }}</h3>
        </div>
      </div>
      
    </div>
  </div>
</template>

<script>
export default {
  name: "programmerSkills",
  props: ['skills'],
  emits: ['edit-profile'],
  created(){
    alert(this.skills)
  },
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