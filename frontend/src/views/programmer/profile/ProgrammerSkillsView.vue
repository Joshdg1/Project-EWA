<template>
  <div>
    <programmerSkillList v-if="!this.skillStatus" :skills="this.skills" @deleteSkill="deleteSkill"
                         @editSkill="editSkillStatus"></programmerSkillList>
    <edit v-if="this.skillStatus" :skills="this.skills" @deleteSkill="deleteSkill"
          @editSkill="editSkillStatus"></edit>
  </div>
</template>

<script>
import programmerSkillList from '../../../components/programmerProfile/programmerSkills.vue'
import edit from '../../../components/programmerProfile/ProgrammerInputSkills.vue'
import SkillRepository from "@/repository/SkillRepository";

export default {
  name: "ProgrammerSkillsView",
  components: {
    programmerSkillList,
    edit
  },

  data() {
    return {
      skills: [],
      skillStatus: null,
      repository: new SkillRepository()
    }
  },

  async created() {
    const data = await this.repository.getAllSkills();

    for (let i = 0; i < data.length; i++) {
      this.skills.push(data[i]);
    }
  },

  methods: {
    async deleteSkill(skills) {
      await this.repository.deleteSkillsById(skills.id);
      location.reload();
    },

    editSkillStatus(skillStatus) {
      console.log("skill")
      this.skillStatus = skillStatus;
    }
  }

}

</script>

<style scoped>

</style>