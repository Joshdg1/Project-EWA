<template>
  <div class="container-xxl" id="kt_content_container">
    <TopProfileDetails :sample-programmer="sampleProgrammer"></TopProfileDetails>
    <!--begin::details View-->
    <ProfileInputDetails v-if="this.editProfile === true" :sample-programmer="sampleProgrammer"  @edit-profile="saveProfile" @save-profile="updateProfile"></ProfileInputDetails>

    <ProfileDetails v-if="!this.editProfile" :sample-programmer="sampleProgrammer" @edit-profile="toEditProfile" ></ProfileDetails>

  </div>
</template>

<script>
import {Programmer} from "@/models/programmer";
import ProfileDetails from "@/components/ProfileDetails";
import ProfileInputDetails from "@/components/ProfileInputDetails";
import TopProfileDetails from "@/components/TopProfileDetails";

export default {
  name: "ProgrammerProfilePage",
  components: {TopProfileDetails, ProfileInputDetails, ProfileDetails},
  created() {
    this.sampleProgrammer = new Programmer(0,"John", "Doe", "wiboutStraat", "Amsterdam", "Rust",
        40, 12, 20, "On location", "Full stack")

  },
  data() {
    return {
      sampleProgrammer: null,
      editProfile: null


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
    }
  }
}

</script>

<style scoped>


.parent-div input[type=file] {
  left: 0;
  top: 0;
  opacity: 0;
  position: absolute;
  font-size: 90px;
}



</style>