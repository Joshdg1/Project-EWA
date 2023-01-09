<template>
  <div class="row g-5 g-xl-10 mb-5 mb-xl-10">
    <top-profile-details :sample-programmer="project"  @close-detail="setProjectDetails" @selectedTab="setSelectedTab"></top-profile-details>
    <BottomProjectDetails v-if="displayTypo === 1" :sampleProgrammer="project"></BottomProjectDetails>
    <BottomHourConformation  v-if="displayTypo === 2" :sampleProgrammer="project"></BottomHourConformation>
  </div>
</template>

<script>
import TopProfileDetails from "@/components/projects/topProjectDetails";
import BottomProjectDetails from "@/components/BottomProjectDetails";
import BottomHourConformation from "@/components/BottomHourConfermation";
export default {
  name: "projectClientDetail",
  components: {TopProfileDetails, BottomProjectDetails, BottomHourConformation},
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
.startDate{
  width: 40vw!important;
  height: 9vh;
}
.hours {
  width: 40vw!important;
  height: 9vh;
}
</style>