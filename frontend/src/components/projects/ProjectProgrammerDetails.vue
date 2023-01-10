<template>
  <div class="row g-5 g-xl-10 mb-5 mb-xl-10">
    <top-profile-details :sample-programmer="project"  @close-detail="setProjectDetails" @selectedTab="setSelectedTab"></top-profile-details>
    <BottomProjectDetails v-if="displayTypo === 1" :sampleProgrammer="project"></BottomProjectDetails>
</div>
</template>

<script>
import TopProfileDetails from "@/components/projects/topProjectDetails";
import BottomProjectDetails from "@/components/BottomProjectDetails";

export default {
  components: {TopProfileDetails, BottomProjectDetails},
  name: "ProjectProgrammerId",
  props: ['project'],
  emits:['view-project'],
  created() {
    console.log("MAAKT DIE ANDER AAN OFZO")
  },
  methods: {
    setProjectDetails(project){
      console.log(project)
      this.$emit('view-project' , false)
    },
    setSelectedTab(tabId){
      this.displayTypo = tabId
    }
  },
  data() {
    return {
      displayTypo: 1
    }
  }
}
</script>

<style scoped>

</style>