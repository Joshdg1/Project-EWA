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
        <a @click="editSkill()" class="btn background-florijn btn-active-info editSkill" tooltip="New App"
           data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Edit skills</a>
        <a @click="(event) => this.popupStatus = true" class="btn background-florijn btn-active-info editSkill"
           tooltip="New App"
           data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Add skill</a>
      </div>
    </div>
    <addSkill v-if="popupStatus" @close-popup="closePopup"></addSkill>
    <div class="card-body p-11">
      <div class="card"
           v-for="skill in this.skills"
           v-bind:key="skill.skillId">
        <div class="modal-dialog mw-650px">
          <!--begin::Modal content-->
          <div class="modal-content backgroundCard">
            <!--begin::Modal header-->
            <div class="modal-header pb-0 border-0 justify-content-end">
              <!--begin::Close-->
              <div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
              </div>
              <!--end::Close-->
            </div>
            <!--begin::Modal header-->
            <!--begin::Modal body-->
            <div class="backgroundTextName">{{ skill.name }}</div>
            <input type="number" class="backgroundText inputLevelSkill" v-model="skill.level">
            <img src="../../assets/florijnster.png" class="skillStar">
            <div class="modal-body scroll-y mx-5 mx-xl-18 pt-0 pb-15">
              <!--end::Modal body-->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import SkillRepository from '../../../repository/SkillRepository.js'

export default {
  name: "programmerInputSkills",
  props: ['skills'],
  emits: ['edit-profile', 'add-skill', 'deleteClient', 'editClient'],


  data() {
    return {
      editingProfile: null,
      programSkill: null,
      currentId: null,
      selectedSkill: null,
      popupStatus: null,
      editingSkill: null,
      repository: new SkillRepository,
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

    closePopup(newPopupStatus) {
      this.popupStatus = newPopupStatus
    },
    addSkill(skill) {
      this.$emit('add-skill', skill)
    },

    async editSkill(skill) {
      this.editingSkill = false;
      this.$emit('editSkill', this.editingSkill)

      await this.repository.updateProgrammerSkillById(this.id, skill.id, skill.level);
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
  flex-wrap: wrap;
}

.code-icon {
  height: 2em;
  margin: 2em;

}

.CardText {
  border-top: 2px solid #EF5722 !important;
  text-align: center;
}

.skillStar {
  height: 2em;
}

.backgroundCard {
  background-color: #192440 !important;
}

.backgroundText {
  /*color: white !important;*/
  margin-left: 5px;
  margin-right: 5px;
  font-family: Poppins, Helvetica, "sans-serif";
  font-size: 15px;
  text-align: center;
}

.backgroundTextName {
  color: white !important;
  margin-left: 5px;
  margin-right: 5px;
  font-family: Poppins, Helvetica, "sans-serif";
  font-size: 15px;
  text-align: center;
}


.skillStar {
  color: #ec5a29;
  align-content: center;
}
</style>