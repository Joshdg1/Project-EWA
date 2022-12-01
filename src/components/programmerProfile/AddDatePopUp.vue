<template>
  <div class="popup">
    <div class="popup-inner">

      <img src="https://cdn.onlinewebfonts.com/svg/img_133326.png" class="code-icon">
      <div class="CardText">
        <input v-model="newDate.title" placeholder="title" class="cardInput">
        <div class="SkillLevel">
          <input v-model="newDate.start" type="date"  placeholder="start"  class="cardInput">
        </div>
        <input v-model="newDate.end" type="date"  placeholder="end"  class="cardInput">
      </div>
      <div class="buttons">
        <button  class="btn background-florijn btn-active-info addSkill" @click="cancel">anuleren</button>
        <button class="btn background-florijn btn-active-info addSkill" @click="addSkill">Voeg Datum toe</button>
      </div>

      <slot/>
    </div>
  </div>
</template>

<script>

import programmerDate from "@/models/programmer/programmerDate";

export default {
  name: "AddDatePopUp",
  emits: ['close-popup', 'adding-date'],
  created() {
    this.newDate = new programmerDate()
  },
  data(){
    return {
      popupStatus: null,
      newDate: null
    }
  },
  methods:{
    closingPopup(){
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
    },
    addSkill(){
      // if (!(this.newDate.start).type === DateTime || !isNaN(this.newDate.end)) {
        alert(this.newDate.start)
        this.$emit('adding-date', this.newDate)
        this.popupStatus = false
        this.$emit('close-popup', this.popupStatus)
    },
    cancel(){
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
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
  width: 10vw;
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
  height: 5vh;
  margin: 1em;
  padding: .3em !important;
  font-size: .8em;
}
.buttons{
  margin-top: 2em;
  display: flex;
  flex-direction: row;
  height: 7em;

}
</style>