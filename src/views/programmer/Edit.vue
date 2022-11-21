<template>
  <div>
    <TopProfileDetails :sample-programmer="sampleProgrammer" @selectedTab="changeSelectedTab"></TopProfileDetails>
    <!--begin::details View-->
    <ProfileInputDetails v-if="this.editProfile === true && currentTab === 1" :sample-programmer="sampleProgrammer"
                         @edit-profile="EditProfileStatus" @save-profile="updateProfile"></ProfileInputDetails>

    <ProfileDetails v-if="!this.editProfile && currentTab === 1" :sample-programmer="sampleProgrammer"
                    @edit-profile="EditProfileStatus"></ProfileDetails>
    <AvailabilityProgrammer v-if="!this.editProfile && currentTab === 2 "></AvailabilityProgrammer>

    <programmer-skills v-if="!this.editProfile && currentTab === 3 " :skills="skills"
                    @edit-profile="EditProfileStatus"></programmer-skills>

<ProgrammerInputSkills  v-if="this.editProfile && currentTab === 3 " :skills="skills"
                        @edit-profile="EditProfileStatus"></ProgrammerInputSkills>
  </div>
</template>

<script>

import ProfileDetails from "@/components/programmerProfile/ProfileDetails";
import ProfileInputDetails from "@/components/programmerProfile/ProfileInputDetails";
import {ProgrammerSkill} from "@/models/programmer/programmerSkill"
import TopProfileDetails from "@/components/programmerProfile/TopProfileDetails";
import AvailabilityProgrammer from "@/components/programmerProfile/AvailabilityProgrammer";
import ProgrammerSkills from "@/components/programmerProfile/programmerSkills";
import ProgrammerInputSkills from "@/components/programmerProfile/ProgrammerInputSkills";
import ProgrammerRepository from "@/assets/Repositories/ProgrammerService";
import Programmer from "@/models/programmer/programmer";

export default {
  name: "ProgrammerProfilePage",
  components: {
    ProgrammerInputSkills,
    ProgrammerSkills, AvailabilityProgrammer, TopProfileDetails, ProfileInputDetails, ProfileDetails},
  created() {
    // this.sampleProgrammer = new Programmer(0, "John", "Doe", "JohnDoe@HvA.nl", "wiboutStraat", "Amsterdam", "Rust",
    //     40, 12, 20, "On location", "Full stack")

    let languages = ["PowerBi" , "Flutter" ,"Dart", "C#" , "Rust"]

    for (let i = 0; i < 5; i++) {
      let si = i
      const language = languages[i]
      this.skills.push(  new ProgrammerSkill(1, si ,language, Math.round(Math.random() * 4 + 1)))
      this.skills.skillName = language
    }
    // const allProgrammers = this.repository.getAllProgrammers()
    // console.log(allProgrammers)
    const data = this.repository.findProgrammerById(1)
    console.log(data)

    this.currentTab = 1;
  },
  data() {
    return {
      sampleProgrammer: new Programmer(),
      editProfile: null,
      currentTab: null,
      skills: [],
      repository: new ProgrammerRepository(),
    }
  },
  methods: {
    EditProfileStatus(profileEditStatus) {
      this.editProfile = profileEditStatus
    },
    updateProfile(newProfile) {
      this.sampleProgrammer = newProfile
    },
    changeSelectedTab(selectedTab) {
      this.currentTab = selectedTab;
    },
  },

  // async get() {
  //   const data = await this.repository.updateProgrammer();
  //
  //   console.log(data)
  //
  // }
}
</script>

<style scoped>

</style>