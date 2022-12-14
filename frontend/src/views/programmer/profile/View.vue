<template>
  <div>
    <TopProfileDetails :sample-programmer="sampleProgrammer" @selectedTab="changeSelectedTab"></TopProfileDetails>
    <!--begin::details View-->
    <ProfileInputDetails v-if="this.editProfile === true && currentTab === 1" :sample-programmer="sampleProgrammer"
                         @edit-profile="EditProfileStatus" @save-profile="updateProfile"></ProfileInputDetails>

    <ProfileDetails v-if="!this.editProfile && currentTab === 1" :sample-programmer="sampleProgrammer"
                    @edit-profile="EditProfileStatus" ></ProfileDetails>
    <AvailabilityProgrammer v-if="!this.editProfile && currentTab === 2 "></AvailabilityProgrammer>

    <programmer-skills v-if="!this.editProfile && currentTab === 3 " :skills="skills"
                       @edit-profile="EditProfileStatus" @add-skill="addSkill"></programmer-skills>

    <ProgrammerInputSkills v-if="this.editProfile && currentTab === 3 " :skills="skills"
                           @edit-profile="EditProfileStatus" @delete-skill="deleteSkill" @add-skill="addSkill"></ProgrammerInputSkills>
  </div>
</template>
<script>

import ProfileDetails from "@/components/programmerProfile/ProfileDetails";
import ProfileInputDetails from "@/components/programmerProfile/ProfileInputDetails";
import TopProfileDetails from "@/components/programmerProfile/TopProfileDetails";
import AvailabilityProgrammer from "@/components/programmerProfile/AvailabilityProgrammer";
import ProgrammerSkills from "@/components/programmerProfile/programmerSkills";
import ProgrammerInputSkills from "@/components/programmerProfile/ProgrammerInputSkills";
import Programmer from "@/models/programmer/programmer";
import UserRepository from "@/repository/UserRepository";
import ProjectRepository from "@/repository/ProjectRepository";
import SkillRepository from "@/repository/SkillRepository";


export default {
  name: "ProgrammerProfilePage",
  components: {

    ProgrammerInputSkills,
    ProgrammerSkills, AvailabilityProgrammer, TopProfileDetails, ProfileInputDetails, ProfileDetails},
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
    this.sampleProgrammer = await this.repository.findProgrammerById(userID)
   const databaseSkills = await this.repositoryGood.findSkillsById(userID);
   for (let i = 0; i < databaseSkills.length; i++) {
     this.skills.push(databaseSkills[i]);
   }

    this.sampleProgrammer = await this.repository.findUserById(userID)



    this.currentTab = 1;
  },
  data() {
    return {
      sampleProgrammer: new Programmer,
      editProfile: null,
      currentTab: null,
      skills: [],
      programmers: [],
      projects: [],
      repository: new UserRepository(),
      projectRepository: new ProjectRepository(),
      repositoryGood: new SkillRepository(),
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
    deleteSkill(skill) {
      this.skills = this.skills.filter(item => item.skillId !== skill.skillId)
    },
    addSkill(skill){
      this.skills.push(skill)
    }
  },

}
</script>

<style scoped>

</style>