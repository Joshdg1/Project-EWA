<template>
  <div>
    <form>
      <div class="text-center mb-10">
        <h1 class="text-dark mb-3">Create a new project</h1>
      </div>


      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Name</label>
        <div class="namebox">
          <input class="form-control form-control-lg form-control-solid name" type="text" name="text"
                 autocomplete="off" v-model="this.programmer.firstName">
          <input class="form-control form-control-lg form-control-solid name" type="text" name="text"
                 autocomplete="off" v-model="this.programmer.lastName">
        </div>

      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bold text-dark fs-6 mb-0">E-Mail</label>
        </div>
        <input class="form-control form-control-lg form-control-solid" type="text"
               name="Type of project" autocomplete="off" v-model="this.programmer.email">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Address</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="this.programmer.address">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">City</label>
        <input class="form-control form-control-lg form-control-solid" type="text"
               autocomplete="off" v-model="this.programmer.city">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Postcode</label>
        <input class="form-control form-control-lg form-control-solid" type="text"
               autocomplete="off" v-model="this.programmer.postcode">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">WorkPreference</label>
        <input class="form-control form-control-lg form-control-solid" type="text"
               autocomplete="off" v-model="this.programmer.workPreference">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">ProjectType</label>
        <input class="form-control form-control-lg form-control-solid" type="text"
               autocomplete="off" v-model="this.programmer.projectType">
      </div>
    </form>

    <div class="d-flex flex-shrink-0">
      <div class="d-flex ms-3">
        <router-link to="/programmers" class="btn background-florijn btn-active-info">
          Cancel
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn background-florijn btn-active-info"  @click="createProgrammer" href="/programmers">Create</button>
      </div>

    </div>
  </div>
</template>

<script>

import Programmer from "@/models/programmer/programmer";
import ProgrammerRepository from "@/repository/ProgrammerService";

export default {
  // eslint-disable-next-line
  name: "AddProgrammer",

  data() {
    return {
      programmer: new Programmer(),
      repository: new ProgrammerRepository()
    }
  },

  methods: {
  async  createProgrammer() {
   await this.repository.createProgrammers(this.programmer.firstName,this.programmer.lastName,this.programmer.email,
          this.programmer.address,this.programmer.city,this.programmer.postcode,   this.programmer.projectType,this.programmer.workPreference,this.programmer.availability
       )

    this.$router.push("/programmers");
    }

  }
}
</script>

<style scoped>
.namebox {
  display: flex;
  flex-direction: row;
}

.form-control.form-control-solid {
  background-color: lightgray;
  border-color: #F5F8FA;
  color: #5E6278;
  transition: color 0.2s ease, background-color 0.2s ease;
}

.name {
  width: 50vw;
}
</style>
