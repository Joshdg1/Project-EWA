<template>
  <div class="popup">
    <div class="popup-inner">

      <img src="https://cdn.onlinewebfonts.com/svg/img_133326.png" class="code-icon">
      <div class="CardText">
        <input v-model="newSkill.skillName" placeholder="name" class="cardInput">
        <div class="SkillLevel">
          <input v-model="newSkill.skillLevel" placeholder="level"  class="cardInput">
          <img src="https://cdn.onlinewebfonts.com/svg/img_561899.png" class="skillStar">
        </div>
      </div>
      <button class="btn bg-primary btn-active-info addSkill" @click="addSkill">Add Skill</button>
      <slot/>
    </div>
  </div>
</template>

<script>
import {ProgrammerSkill} from "../../models/programmer/programmerSkill";

export default {
  name: "SkillCardPopUp",
  emits: ['close-popup', 'adding-skill'],
  created() {
    this.newSkill = new ProgrammerSkill(1)
  },
  data(){
    return {
      popupStatus: null,
      newSkill: null
    }
  },
  methods:{
    closingPopup(){
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
    },
    addSkill(){
      if (this.newSkill.skillName !== null && this.newSkill.skillLevel !== null){
        this.$emit('adding-skill', this.newSkill)
        this.popupStatus = false
        this.$emit('close-popup', this.popupStatus)
      }

    }
  }
}
</script>

<style scoped>

.popup {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  background-color: rgba(0,0,0 ,0.2);

  display: flex;
  align-items: center;
  justify-content: center;
}
.popup-inner{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #E4E6EF;
  padding: 5em;
  border-radius: 20px;
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
.addSkill {
  width: 5vw;
  margin: 1em;
}
</style>