<template>
    <div>
        <TopProfileDetails :sample-programmer="sampleProgrammer" @selectedTab="changeSelectedTab"></TopProfileDetails>
        <!--begin::details View-->
        <ProfileInputDetails v-if="this.editProfile === true && currentTab === 1" :sample-programmer="sampleProgrammer"
                             @edit-profile="updateProfile" ></ProfileInputDetails>

        <ProfileDetails v-if="!this.editProfile && currentTab === 1" :sample-programmer="sampleProgrammer"
                        @edit-profile="EditProfileStatus"></ProfileDetails>
        <AvailabilityProgrammer v-if="!this.editProfile && currentTab === 2 "></AvailabilityProgrammer>

        <programmer-skills v-if="!this.editProfile && currentTab === 3 " :skills="skills"
                           @edit-profile="EditProfileStatus" @add-skill="addSkill"></programmer-skills>
    </div>
</template>
<script>

    import ProfileDetails from "@/components/programmerProfile/ProfileDetails";
    import ProfileInputDetails from "@/components/programmerProfile/ProfileInputDetails";
    import TopProfileDetails from "@/components/programmerProfile/TopProfileDetails";
    import AvailabilityProgrammer from "@/components/programmerProfile/AvailabilityProgrammer";
    import ProgrammerSkills from "@/components/programmerProfile/programmerSkills";
    import User from "@/models/user";
    import UserRepository from "@/repository/UserRepository";
    import ProjectRepository from "@/repository/ProjectRepository";
    import SkillRepository from "@/repository/SkillRepository";

    export default {
        name: "AdminProfilePage",

        components: {
            ProgrammerSkills, AvailabilityProgrammer, TopProfileDetails, ProfileInputDetails, ProfileDetails
        },

        data() {
            return {
                sampleProgrammer: new User,
                editProfile: null,
                currentTab: null,
                skills: [],
              userID: null,
                programmers: [],
                projects: [],
                repository: new UserRepository(),
                projectRepository: new ProjectRepository(),
                repositoryGood: new SkillRepository(),
            }
        },

        async created() {
             this.userID = sessionStorage.getItem("id")
            this.sampleProgrammer = await this.repository.findUserById(this.userID)
            const databaseSkills = await this.repositoryGood.findSkillsById(this.userID);
            for (let i = 0; i < databaseSkills.length; i++) {
                this.skills.push(databaseSkills[i]);
            }

            this.sampleProgrammer = await this.repository.findUserById(this.userID)

            this.currentTab = 1;
        },

        methods: {
            EditProfileStatus(profileEditStatus) {
                this.editProfile = profileEditStatus
            },
            async updateProfile(newProfile) {
              this.editProfile = newProfile
                this.sampleProgrammer = await this.repository.findUserById(this.userID)
            },
            changeSelectedTab(selectedTab) {
                this.currentTab = selectedTab;
            },
            deleteSkill(skill) {
                this.skills = this.skills.filter(item => item.skillId !== skill.skillId)
            },
            addSkill(skill) {
                this.skills.push(skill)
            }
        },
    }
</script>

<style scoped>

</style>