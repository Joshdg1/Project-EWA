<template>
  <div class="wrapper">
    <div class="initialInfo">
      <img class="profilePic" src="../assets/dummy-avatar-2772343867.png">
      <div class="TextProgrammerInitialInfo">
        <h5> Firstname Lastname</h5>
        <p>Programmer</p>
      </div>
    </div>
    <div>
      <div class="uploadBox">
        <button class="uploadCVButton">Upload CV</button>
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
              <input placeholder="Value" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Experience:</label>
              <input placeholder="Value" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Availability:</label>
              <input placeholder="Value" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Current Project:</label>
              <input placeholder="Value" class="ProgrammerProfileInputBox">
            </div>
            <div class="inputProgrammer">
              <label class="InputLabel">Total Hours</label>
              <input placeholder="Value" class="ProgrammerProfileInputBox">
            </div>
          </div>


          <div class="rightInputBoxes">
            <div style="opacity: 0%">----</div>
            <div class="inputProgrammer">
              <label class="InputLabel">Work Preference: <button class="workPreferencebutton">Work from home</button>
                <button class="workPreferencebutton">Work on location</button> </label>
              <input placeholder="Value" class="ProgrammerProfileInputBox">
            </div>
          </div>


        </div>

      </div>
    </div>
    <div class="submitBox">
      <button class="submitChanges">Submit changes</button>
    </div>

  </div>

</template>

<script>
export default {
  name: "ProgrammerProfilePage"
}
</script>

<style scoped>
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
.uploadBox{
  margin: 3em;
  display: flex;
  justify-content: center;
  align-items: center;
}
.uploadCVButton {
  display: flex;
  align-items: center;
  background-color: #EF5722;
  border-radius: 20px;
  padding: 1.5em;
  height: 3em;
}

.inputBoxesProgrammerProfile {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
.inputBoxesProgrammerProfile h4{
  color: #EF5722;
}
.inputProgrammer{
  display: flex;
  flex-direction: column;
}
.topInputBoxes{
  display: flex;
  flex-direction: row;
}
.leftInputBoxes {
  margin-right: 2vw;
}
.InputLabel{
  padding: .5em;
}
.ProgrammerProfileInputBox{
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