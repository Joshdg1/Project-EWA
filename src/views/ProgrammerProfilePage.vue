<template>
  <div class="container-xxl" id="kt_content_container">
    <TopProfileDetails :sample-programmer="sampleProgrammer" @selectedTab = "changeSelectedTab"></TopProfileDetails>
    <!--begin::details View-->
    <ProfileInputDetails v-if="this.editProfile === true && currentTab === 1" :sample-programmer="sampleProgrammer"  @edit-profile="saveProfile" @save-profile="updateProfile"></ProfileInputDetails>

    <ProfileDetails v-if="!this.editProfile && currentTab === 1" :sample-programmer="sampleProgrammer" @edit-profile="toEditProfile" ></ProfileDetails>
    <AvailabilityProgrammer v-if="currentTab === 2 && this.editProfile === false"></AvailabilityProgrammer>
  </div>
</template>

<script>
import {Programmer} from "@/models/programmer";
import ProfileDetails from "@/components/ProfileDetails";
import ProfileInputDetails from "@/components/ProfileInputDetails";
import TopProfileDetails from "@/components/TopProfileDetails";
import AvailabilityProgrammer from "@/components/AvailabilityProgrammer";

export default {
  name: "ProgrammerProfilePage",
  components: {AvailabilityProgrammer, TopProfileDetails, ProfileInputDetails, ProfileDetails},
  created() {
    this.sampleProgrammer = new Programmer(0,"John", "Doe","JohnDoe@HvA.nl", "wiboutStraat", "Amsterdam", "Rust",
        40, 12, 20, "On location", "Full stack")
    this.currentTab = 1;
  },
  data() {
    return {
      sampleProgrammer: null,
      editProfile: null,
      currentTab: null
    }
  },
  methods: {
    toEditProfile(profileEditStatus) {
      this.editProfile = profileEditStatus
    },
    saveProfile(profileEditStatus) {
      this.editProfile = profileEditStatus
    },
    updateProfile(newProfile){
      this.sampleProgrammer = newProfile
    },
    changeSelectedTab(selectedTab){
      this.currentTab = selectedTab;

    }
  }
}
</script>

<style scoped>

</style>