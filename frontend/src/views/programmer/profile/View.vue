<template>
  <div>
    <TopProfileDetails :sample-programmer="sampleUser" @selectedTab="changeSelectedTab"></TopProfileDetails>
    <!--begin::details View-->
    <ProfileInputDetails v-if="editProfile === true && currentTab === 1" :sample-programmer="sampleUser"
                         @edit-profile="EditProfileStatus" @save-profile="updateProfile"></ProfileInputDetails>

    <ProfileDetails v-if="!editProfile && currentTab === 1" :sample-programmer="sampleUser"
                    @edit-profile="EditProfileStatus"></ProfileDetails>
    <AvailabilityProgrammer v-if="!editProfile && currentTab === 2 "></AvailabilityProgrammer>
    <programmerSkillList v-if="!skillStatus" :skills="skills" @deleteSkill="deleteSkill"
                         @edit-skill="editSkillStatus"></programmerSkillList>
    <edit v-if="skillStatus" :skills="skills" @deleteSkill="deleteSkill"
          @editSkill="editSkillStatus"></edit>
  </div>
</template>
<script>

import ProfileDetails from "@/components/programmerProfile/ProfileDetails";
import ProfileInputDetails from "@/components/programmerProfile/ProfileInputDetails";
import TopProfileDetails from "@/components/programmerProfile/TopProfileDetails";
import AvailabilityProgrammer from "@/components/programmerProfile/AvailabilityProgrammer";
import User from "@/models/user.js";
import UserRepository from "@/repository/UserRepository";
import ProjectRepository from "@/repository/ProjectRepository";
import SkillRepository from "@/repository/SkillRepository";
import programmerSkillList from '../../../components/programmerProfile/programmerSkills.vue'
import edit from '../../../components/programmerProfile/ProgrammerInputSkills.vue'


export default {
  name: "ProgrammerProfilePage",
  components: {
    AvailabilityProgrammer, TopProfileDetails, ProfileInputDetails, ProfileDetails, programmerSkillList, edit
  },
  async created() {

    // let languages = ["PowerBi" , "Flutter" ,"Dart", "C#" , "Rust"]

    // for (let i = 0; i < 5; i++) {
    //   let si = i
    //   const language = languages[i]
    //   this.skills.push(  new ProgrammerSkill(1, si ,language, Math.round(Math.random() * 4 + 1)))
    //   this.skills.skillName = language
    // }
    // for (let i = 0; i < 5; i++) {
    //   let si = i
    //   const language = languages[i]
    //   this.skills.push(  new ProgrammerSkill(1, si ,language, Math.round(Math.random() * 4 + 1)))
    //   this.skills.skillName = language
    // }
    // const allProgrammers = this.repository.getAllProgrammers()
    // console.log(allProgrammers)

    const userID = sessionStorage.getItem("id")
    this.sampleProgrammer = await this.repository.findUserById(userID)
    const databaseSkills = await this.repositoryGood.findSkillsById(userID);
    for (let i = 0; i < databaseSkills.length; i++) {
      this.skills.push(databaseSkills[i]);
    }

    // this.sampleProgrammer = await this.repository.findUserById(userID)


    this.currentTab = 1;
  },
  data() {
    return {
      sampleUser: new User,
      editProfile: null,
      currentTab: null,
      skills: [],
      programmers: [],
      projects: [],
      repository: new UserRepository(),
      projectRepository: new ProjectRepository(),
      repositoryGood: new SkillRepository(),
      skillStatus: null,
    }
  },
  methods: {
    EditProfileStatus(profileEditStatus) {
      this.editProfile = profileEditStatus
    },
    updateProfile(newProfile) {
      this.sampleUser = newProfile
    },
    changeSelectedTab(selectedTab) {
      this.currentTab = selectedTab;
    },
    addSkill(skill) {
      this.skills.push(skill)
    },
    async deleteSkill(skills) {
      console.log("test");
      await this.repositoryGood.deleteSkillsById(skills.id);
      location.reload();
    },

    editSkillStatus(skillStatus) {
      console.log("skillStatus")
      this.skillStatus = skillStatus;
    }
  }


}
</script>

<style scoped>

</style>