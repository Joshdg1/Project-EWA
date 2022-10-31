<template>
  <div class="container-xxl" id="kt_content_container">
    <TopProfileDetails :sample-programmer="sampleProgrammer" @selectedTab="changeSelectedTab"></TopProfileDetails>
    <!--begin::details View-->
    <ProfileInputDetails v-if="this.editProfile === true && currentTab === 1" :sample-programmer="sampleProgrammer"
                         @edit-profile="saveProfile" @save-profile="updateProfile"></ProfileInputDetails>

    <ProfileDetails v-if="!this.editProfile && currentTab === 1" :sample-programmer="sampleProgrammer"
                    @edit-profile="toEditProfile"></ProfileDetails>
    <AvailabilityProgrammer v-if="!this.editProfile && currentTab === 2 "></AvailabilityProgrammer>
    <programmer-skills  v-if="!this.editProfile && currentTab === 3 " :skills="skills"></programmer-skills>
  </div>
</template>

<script>
import {Programmer} from "@/models/programmer/programmer";
import ProfileDetails from "@/components/programmerProfile/ProfileDetails";
import ProfileInputDetails from "@/components/programmerProfile/ProfileInputDetails";
import {ProgrammerSkill} from "@/models/programmer/ProgrammerSkill"
import TopProfileDetails from "@/components/programmerProfile/TopProfileDetails";
import AvailabilityProgrammer from "@/components/programmerProfile/AvailabilityProgrammer";
import ProgrammerSkills from "@/components/programmerProfile/programmerSkills";

export default {
  name: "ProgrammerProfilePage",
  components: {ProgrammerSkills, AvailabilityProgrammer, TopProfileDetails, ProfileInputDetails, ProfileDetails},
  created() {
    this.sampleProgrammer = new Programmer(0, "John", "Doe", "JohnDoe@HvA.nl", "wiboutStraat", "Amsterdam", "Rust",
        40, 12, 20, "On location", "Full stack")
    let langues = ["PowerBI", "Flutter","Dart","PowerApps","C#"]

    for (let i = 0; i < 5; i++) {
      this.skills[i] = [new ProgrammerSkill(1, langues[i], i)]
    }
    this.currentTab = 1;
  },
  data() {
    return {
      sampleProgrammer: null,
      editProfile: null,
      currentTab: null,
      skills: []
    }
  },
  methods: {
    toEditProfile(profileEditStatus) {
      this.editProfile = profileEditStatus
    },
    saveProfile(profileEditStatus) {
      this.editProfile = profileEditStatus
    },
    updateProfile(newProfile) {
      this.sampleProgrammer = newProfile
    },
    changeSelectedTab(selectedTab) {
      this.currentTab = selectedTab;
    }
  }
}
</script>

<style scoped>

</style>