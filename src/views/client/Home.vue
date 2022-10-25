<template>
  <div>
    <!--  v-on:click="projectSelector(project)-->
    <div class="card" :style="''" v-bind:id="project.id" v-for="project in projects"
         v-bind:key="project.project">
      <p class="card-text" id="id">{{ project.id }}</p>
      <p class="card-text" id="title">{{ project.title }}</p>
      <p class="card-text" id="description">{{ project.description }}</p>
    </div>
  </div>
</template>

<script>

import {project} from "../../models/project";

export default {
  name: "ClientHomePage",
  created() {
    this.fake();
    this.fake();
    this.fake();
  },
  data() {
    return {
      projects: [],
    }
  },

  methods:{
    createProject()
    {
      this.projects.push("alle project ophalen en hier neerzettten")
      "project moet in array worden gezet."
    },
    fake(){
      project.fakeData()
      this.projects.push(project.fakeData())
    }
  }
}

</script>

<style scoped>

</style>