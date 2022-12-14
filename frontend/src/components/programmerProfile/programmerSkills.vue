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
        <a @click="setEditProfile()" class="btn background-florijn btn-active-info editSkill" tooltip="New App"
           data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Edit skills</a>
      </div>
      <!--end::Action-->
    </div>
<!--    <SkillCardPopUp v-if="popupStatus" @close-popup="closePopup" @adding-skill="addSkill">-->

<!--    </SkillCardPopUp>-->
    <addSkill v-if="popupStatus" @close-popup="closePopup"></addSkill>
    <div class="card-body p-11">
      <div class="card"
           v-for="skill in this.skills"
           v-bind:key="skill.skillId"
      >
        <div class="skillContainer">

          <img src="https://cdn.onlinewebfonts.com/svg/img_133326.png" class="code-icon">
          <div class="CardText">
            <div>{{ skill.skillName }}  </div>
            <div> {{skill.skillLevel}}<img src="https://cdn.onlinewebfonts.com/svg/img_561899.png" class="skillStar"> </div>
          </div>

        </div>
      </div>
    </div>
    <button class="btn background-florijn btn-active-info addSkill" @click="(event) => this.popupStatus = true">Add</button>
  </div>
</template>

<script>
import addSkill from "./addSkill";

export default {
  name: "programmerSkills",
  components: {addSkill},
  props: ['skills'],
  emits: ['edit-profile', 'add-skill'],

  data() {
    return {
      editingProfile: null,
      programSkill: null,
      popupStatus: null

    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = true
      this.$emit('edit-profile', this.editingProfile)
    },
    closePopup(newPopupStatus){
      this.popupStatus = newPopupStatus
    },
    addSkill(skill) {
      this.$emit('add-skill',skill)

    }
  }

}
</script>

<style scoped>
.editSkill {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 2em;
}
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
  border-top: 2px solid #EF5722!important;
  text-align: center;
}
.skillStar{
  height: 1em;
}
.addSkill{
  width: 5vw;
  margin: 1em;
}
</style>