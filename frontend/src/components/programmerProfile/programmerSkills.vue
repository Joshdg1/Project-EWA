<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Vaardigheden</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3" v-if="this.addCheck">
        <a @click= "onAddSkillClick" class="mb-2 btn btn-sm bg-primary btn-active-info editSkill"
           tooltip="New App"
           data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Voeg een vaardigheid toe</a>
      </div>
      <!--end::Action-->
    </div>

    <addSkill :skill="selectedSkill" v-if="popupStatus" @close-popup="closePopup"></addSkill>

    <div class="card-body p-11">
      <div class="card"
           v-for="skill in this.allSkills"
           v-bind:key="skill.skillId">
        <div class="modal-dialog mw-650px m-2">
          <!--begin::Modal content-->
          <div class="modal-content backgroundCard">
            <div id="editDeleteSkill" class="d-flex justify-content-end flex-shrink-0">
              <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editSkill(skill)">
                <edit-icon></edit-icon>
              </a>
              <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="deleteSkill(skill)">
                <delete-icon></delete-icon>
              </a>
            </div>
            <!--begin::Modal header-->
            <div id="removeSpace" class="modal-header pb-0 border-0 justify-content-end">
              <!--begin::Close-->
              <div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
              </div>
              <!--end::Close-->
            </div>
            <!--begin::Modal header-->
            <!--begin::Modal body-->
            <div class="backgroundText">{{ skill.name }}</div>
            <div class="backgroundText"> {{ skill.level }}
              <img src="../../assets/florijnster.png" class="skillStar">
            </div>
            <div id="removeSpace" class="modal-body scroll-y mx-5 mx-xl-18 pt-0 pb-15">
              <!--end::Modal body-->
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import addSkill from "./addSkill";
import SkillRepository from "@/repository/SkillRepository";
import DeleteIcon from "@/components/icons/delete";
import EditIcon from "@/components/icons/edit";

export default {
  name: "programmerSkills",
  components: {EditIcon, DeleteIcon, addSkill},
  props: ['skills'],
  emits: ['edit-profile', 'add-skill', 'edit-skill', 'deleteSkill'],
 async created() {
    this.allSkills = await this.repository.findSkillsById(this.user.id);
  },

  data() {
    return {
      selectedSkill: null,
      allSkills: [],
      editingProfile: null,
      programSkill: null,
      popupStatus: null,
      user: JSON.parse(sessionStorage.user),
      repository: new SkillRepository(),
      addCheck: true,
    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = true
      this.$emit('edit-profile', this.editingProfile)
    },

   async closePopup() {
     this.allSkills = await this.repository.findSkillsById(this.user.id);

      this.popupStatus = false
      this.addCheck = true;
      this.$emit('addCheck', this.addCheck)
    },

    addSkill(skill) {
      this.$emit('add-skill', skill)
      this.addCheck = true;
      this.$emit('addCheck', this.addCheck)
    },

    async deleteSkill(skill) {
      await this.repository.deleteSkillById(skill.id);
      this.allSkills = await this.repository.findSkillsById(this.user.id);
    },

    editSkill(skill) {
      this.addCheck = false;
      this.$emit('addCheck', this.addCheck)
      this.popupStatus = true;
      this.selectedSkill = skill;
    },

    onAddSkillClick(){
      this.popupStatus = true;
      this.selectedSkill = null;
    },
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
  background-color: #192440;
}

.backgroundCard:hover {
  background-color: #ec5a29;
}

.backgroundText {
  color: white !important;
  margin-left: 5px;
  margin-right: 5px;
  font-family: Poppins, Helvetica, "sans-serif";
  font-size: 15px;
  text-align: center;
  padding-bottom: 12px;
}

.skillStar {
  color: #ec5a29;
  align-content: center;
  padding-bottom: 3px;
}

#editDeleteSkill {
  padding-right: 4px;
  padding-top: 4px;
  padding-bottom: 15px;
}

#removeSpace {
  display:none;
}

</style>