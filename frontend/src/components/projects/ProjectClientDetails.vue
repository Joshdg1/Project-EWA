<template>
  <div class="row g-5 g-xl-10 mb-5 mb-xl-10">
    <top-profile-details :sample-programmer="project"></top-profile-details>
  </div>
</template>

<script>
import TopProfileDetails from "@/components/projects/topProjectDetails";
export default {
  name: "projectClientDetail",
  components: {TopProfileDetails},
  props: ['project'],
  emits:['view-project'],
  created() {
    console.log("MAAKT DIE ANDER AAN OFZO")
  },
  methods: {
    SetProjectDetails(){
      this.$emit('view-project' , false)
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