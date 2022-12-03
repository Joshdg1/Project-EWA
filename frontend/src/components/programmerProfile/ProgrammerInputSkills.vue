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
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Save skills</a>
      </div>
      <!--end::Action-->
    </div>
    <SkillCardPopUp v-if="popupStatus" @close-popup="closePopup" @adding-skill="addSkill">

    </SkillCardPopUp>

    <div class="card-body p-9">
      <div class="card"
           v-for="skill in this.skills"
           v-bind:key="skill.skillId"

           @click="setCurrentId(skill.skillId)"
      >
        <div :id="skill.skillId" class="skillContainer" @click="selectSkill(skill)"
             :style="{backgroundColor: (skill.skillId === currentId ? 'lightgrey' : '#E4E6EF')}">

          <img src="https://cdn.onlinewebfonts.com/svg/img_133326.png" class="code-icon">
          <div class="CardText">
            <input v-model="skill.skillName" class="cardInput">
            <div class="SkillLevel">
              <input v-model="skill.skillLevel" class="cardInput">
              <img src="https://cdn.onlinewebfonts.com/svg/img_561899.png" class="skillStar">
            </div>
          </div>

        </div>
      </div>
    </div>
    <div class="bottomButtons">
      <button class="btn background-florijn btn-active-info addSkill" @click="(event) => this.popupStatus = true">Add</button>
      <button class="btn background-florijn btn-active-info addSkill" @click="DeleteSkill">Delete</button>
    </div>

  </div>
</template>

<script>
import SkillCardPopUp from "./SkillCardPopUp";
export default {
  name: "programmerInputSkills",
  components: {SkillCardPopUp},
  props: ['skills'],
  emits: ['edit-profile', 'delete-skill','add-skill'],

  data() {
    return {
      editingProfile: null,
      programSkill: null,
      currentId: null,
      selectedSkill: null,
      popupStatus: null
    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = false
      this.$emit('edit-profile', this.editingProfile)
    },
    setCurrentId(id) {
      if (id === this.currentId) {
        this.currentId = null
        this.selectedSkill = null
      } else {
        this.currentId = id;
      }
    },
    selectSkill(skill) {
      if (skill !== null) {
        this.selectedSkill = skill
      }
    },
    closePopup(newPopupStatus){
      this.popupStatus = newPopupStatus
    },
    DeleteSkill() {
      if (this.selectedSkill === null){
        alert("There is no skill selected")
      }else{
        this.$emit('delete-skill', this.selectedSkill)
        this.selectedSkill = null;
      }
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
  border-radius: 20px !important;
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
.skillStar {
  height: 1em;
}
.CardText {
  display: flex;
  flex-direction: column;
  border-top: 2px solid #EF5722 !important;
  justify-content: center;
  align-items: center;
}



.cardInput {
  background: none;
  border-width: 0 0 1px 0;
  border-style: solid;
  border-color: lightblue;
  width: 5vw;
  text-align: center;
}

.SkillLevel {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}

input:focus {
  outline: none;
}

.bottomButtons {
  display: flex;
  flex-direction: row;
}

.addSkill {
  width: 5vw;
  margin: 1em;
}

</style>