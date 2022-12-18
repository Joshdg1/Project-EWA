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
        <a @click="(event) => this.popupStatus = true" class="btn background-florijn btn-active-info editSkill"
           tooltip="New App"
           data-bs-toggle="modal"
           data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Add skill</a>
      </div>
      <!--end::Action-->
    </div>
    <addSkill v-if="popupStatus" @close-popup="closePopup"></addSkill>
    <div class="card-body p-11">
      <div class="card"
           v-for="skill in this.skills"
           v-bind:key="skill.skillId">
        <div class="modal-dialog mw-650px m-2">
          <!--begin::Modal content-->
          <div class="modal-content backgroundCard">
            <div class="d-flex justify-content-end flex-shrink-0">
              <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editSkill()">
                <!--begin::Svg Icon | path: icons/duotune/art/art005.svg-->
                <span class="svg-icon svg-icon-3">
																			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                           fill="none">
																				<path opacity="0.3"
                                              d="M21.4 8.35303L19.241 10.511L13.485 4.755L15.643 2.59595C16.0248 2.21423 16.5426 1.99988 17.0825 1.99988C17.6224 1.99988 18.1402 2.21423 18.522 2.59595L21.4 5.474C21.7817 5.85581 21.9962 6.37355 21.9962 6.91345C21.9962 7.45335 21.7817 7.97122 21.4 8.35303ZM3.68699 21.932L9.88699 19.865L4.13099 14.109L2.06399 20.309C1.98815 20.5354 1.97703 20.7787 2.03189 21.0111C2.08674 21.2436 2.2054 21.4561 2.37449 21.6248C2.54359 21.7934 2.75641 21.9115 2.989 21.9658C3.22158 22.0201 3.4647 22.0084 3.69099 21.932H3.68699Z"
                                              fill="black"/>
																				<path
                                            d="M5.574 21.3L3.692 21.928C3.46591 22.0032 3.22334 22.0141 2.99144 21.9594C2.75954 21.9046 2.54744 21.7864 2.3789 21.6179C2.21036 21.4495 2.09202 21.2375 2.03711 21.0056C1.9822 20.7737 1.99289 20.5312 2.06799 20.3051L2.696 18.422L5.574 21.3ZM4.13499 14.105L9.891 19.861L19.245 10.507L13.489 4.75098L4.13499 14.105Z"
                                            fill="black"/>
																			</svg>
																		</span>
                <!--end::Svg Icon-->
              </a>
              <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="deleteSkill(skill)">
                <!--begin::Svg Icon | path: icons/duotune/general/gen027.svg-->
                <span class="svg-icon svg-icon-3">
																			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                           fill="none">
																				<path
                                            d="M5 9C5 8.44772 5.44772 8 6 8H18C18.5523 8 19 8.44772 19 9V18C19 19.6569 17.6569 21 16 21H8C6.34315 21 5 19.6569 5 18V9Z"
                                            fill="black"/>
																				<path opacity="0.5"
                                              d="M5 5C5 4.44772 5.44772 4 6 4H18C18.5523 4 19 4.44772 19 5V5C19 5.55228 18.5523 6 18 6H6C5.44772 6 5 5.55228 5 5V5Z"
                                              fill="black"/>
																				<path opacity="0.5"
                                              d="M9 4C9 3.44772 9.44772 3 10 3H14C14.5523 3 15 3.44772 15 4V4H9V4Z"
                                              fill="black"/>
																			</svg>
																		</span>
              </a>

            </div>
            <!--begin::Modal header-->
            <div class="modal-header pb-0 border-0 justify-content-end">
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
import addSkill from "./addSkill";
import SkillRepository from "@/repository/SkillRepository";

export default {
  name: "programmerSkills",
  components: {addSkill},
  props: ['skills'],
  emits: ['edit-profile', 'add-skill', 'editSkill', 'deleteSkill'],


  data() {
    return {
      editingProfile: null,
      programSkill: null,
      popupStatus: null,
      editingSkill: null,
      repository: new SkillRepository(),

    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = true
      this.$emit('edit-profile', this.editingProfile)
    },
    closePopup(newPopupStatus) {
      this.popupStatus = newPopupStatus
    },
    addSkill(skill) {
      this.$emit('add-skill', skill)

    },
    async deleteSkill(skill) {
      await this.repository.deleteSkillsById(skill.id);
      location.reload();
    },

    editSkill() {
      this.editingSkill = true;
      this.$emit('editSkill', this.editingSkill)
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