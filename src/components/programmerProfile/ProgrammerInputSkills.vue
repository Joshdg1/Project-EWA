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
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Save skills</a>
      </div>
      <!--end::Action-->
    </div>
    <div class="card-body p-9">
      <div class="card"
           v-for="skill in this.skills"
           v-bind:key="skill.skillId"
      >
        <div class="skillContainer">

          <img src="https://cdn.onlinewebfonts.com/svg/img_133326.png" class="code-icon">
          <div class="CardText">
            <input v-model="skill.skillName"  class="cardInput">
            <input v-model="skill.skillLevel" class="cardInput"> <img src="https://cdn.onlinewebfonts.com/svg/img_561899.png" class="skillStar">
          </div>

        </div>
      </div>

    </div>
  </div>
</template>

<script>


export default {
  name: "programmerInputSkills",
  props: ['skills'],
  emits: ['edit-profile'],

  data() {
    return {
      editingProfile: null,
      programSkill: null
    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = false
      this.$emit('edit-profile', this.editingProfile)
    }
  }

}
</script>

<style scoped>
.skillContainer {
  display: flex;
  flex-direction: column;
  background-color: #E4E6EF;

  height: 15em;
  width: 12.5em;
  align-items: center;
  justify-content: center;
  border-radius: 20px!important;
  margin-right: 2em
}
.card-body {
  display: flex;

  flex-direction: row;
  justify-content: center;
  align-items: center;
}
.code-icon {
  height: 2em;
  margin: 2em;

}
.CardText {
  display: flex;
  flex-direction: column;
  border-top: 2px solid #EF5722!important;
  justify-content: center;
  align-items: center;
}
.skillStar{
  height: 1em;
}
.cardInput{
  background: none;
  border-width:  0 0 1px 0;
  border-style: solid;
  border-color: lightblue;
  width: 5vw;
  text-align: center;
}
</style>