<template>
  <div class="wrapper">

    <div class="initialInfo">
      <img class="profilePic" src="../assets/dummy-avatar-2772343867.png">
      <div class="TextProgrammerInitialInfo">
        <h5> {{ sampleProgrammer.Firstname }} {{ sampleProgrammer.lastname }}</h5>
        <p>Programmer</p>
      </div>
    </div>

    <div>
      <div class="uploadBox">
        <div class="parent-div">
          <button class="btn-upload">upload CV</button>
          <input type="file" name="upfile">
        </div>
      </div>
    </div>

    <div>
      <div class="inputBoxesProgrammerProfile">
        <div class="topInputBoxes">
          <div class="leftInputBoxes">
            <div class="editProfileText">
              <h4> Edit your profile</h4>
            </div>

            <div class="inputProgrammer">
              <label class="InputLabel"> Adres:</label>
              <input v-model="sampleProgrammer.Address" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Experience:</label>
              <input v-model="sampleProgrammer.Experience" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Availability:</label>
              <input v-model="sampleProgrammer.Availability" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Current Project:</label>
              <input v-model="sampleProgrammer.CurrentProject" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Total Hours</label>
              <input v-model="sampleProgrammer.TotalHours" class="ProgrammerProfileInputBox">
            </div>
          </div>

          <div class="rightInputBoxes">
            <div style="opacity: 0">----</div>
            <div class="inputProgrammer">
              <label class="InputLabel">Work Preference:
                <button class="workPreferencebutton" @click="workPreferenceHome()" >Work from home</button>
                <button class="workPreferencebutton" @click="workPreferenceLoc()"> Work on location</button>
              </label>
              <input v-model="sampleProgrammer.WorkPreference" class="ProgrammerProfileInputBox">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="submitBox">
      <button class="submitChanges" @click="submit()">Submit changes</button>
    </div>

  </div>

</template>

<script>
import {Programmer} from "@/models/programmer";

export default {
  name: "ProgrammerProfilePage",

  created() {
    this.sampleProgrammer = new Programmer("John", "Doe", "wiboutStraat", 12, 40, "EWA", 20, "On location")

  },
  data() {
    return {
      sampleProgrammer: null
    }
  },
  methods: {
    submit(){
      console.log("twekrt")
      alert(
        "Firstname: "+   this.sampleProgrammer.Firstname + "\n"+
          "lastname: "+    this.sampleProgrammer.lastname + "\n"+
          "Address: "+   this.sampleProgrammer.Address + "\n"+
          "Experience: "+    this.sampleProgrammer.Experience + "\n"+
          "Availability: "+    this.sampleProgrammer.Availability + "\n"+
          "CurrentProject: "+    this.sampleProgrammer.CurrentProject + "\n"+
          "TotalHours: "+    this.sampleProgrammer.TotalHours + "\n"+
          "WorkPreference: "+    this.sampleProgrammer.WorkPreference + "\n"
      )
    },
    workPreferenceHome(){
      this.sampleProgrammer.WorkPreference = "From home"

    },
    workPreferenceLoc(){
      this.sampleProgrammer.WorkPreference = "On location"
    },
  }
}

</script>

<style scoped>
.wrapper {
  margin-bottom: 5vh; 
}
.initialInfo {
  display: flex;
  justify-content: center;
  align-items: center;
}

.TextProgrammerInitialInfo {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: 3vw;
}

.profilePic {
  border-radius: 50%;
  height: 15vh
}

.uploadBox {
  margin: 3em;
  display: flex;
  justify-content: center;
  align-items: center;
}

.parent-div {
  display: inline-block;
  position: relative;
  overflow: hidden;
}

.parent-div input[type=file] {
  left: 0;
  top: 0;
  opacity: 0;
  position: absolute;
  font-size: 90px;
}

.btn-upload {
  background-color: #EF5722;
  color: #000;
  padding: 10px 25px;
  border-radius: 20px;
  font-size: 13px;

}

.inputBoxesProgrammerProfile {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.inputBoxesProgrammerProfile h4 {
  color: #EF5722;
}

.inputProgrammer {
  display: flex;
  flex-direction: column;
}

.topInputBoxes {
  display: flex;
  flex-direction: row;
}

.leftInputBoxes {
  margin-right: 2vw;
}

.InputLabel {
  padding: .5em;
}

.ProgrammerProfileInputBox {
  width: 20vw;
  height: 3em;
  border-radius: 20px;
}

.editProfileText {
  display: flex;
  justify-content: center;
}

.submitBox {
  display: flex;
  justify-content: right;
  margin-right: 3vw;
}

.workPreferencebutton {
  background-color: #EF5722;
  border-radius: 1em;
}

.submitChanges {
  display: flex;
  align-items: center;
  background-color: #EF5722;
  border-radius: 20px;
  padding: 1.5em;
  height: 3em;

}
</style>