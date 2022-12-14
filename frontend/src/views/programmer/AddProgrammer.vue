<template>
  <div>
    <form>
      <div class="text-center mb-10">
        <h1 class="text-dark mb-3">Create a new Programmer</h1>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bold text-dark fs-6 mb-0">email</label>
        </div>
        <input class="form-control form-control-lg form-control-solid" type="text"
               name="Email" autocomplete="off" v-model="email">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Firstname</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="firstname">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Lastname</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="lastname">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Password</label>
        <input class="form-control form-control-lg form-control-solid" type="password" name="text"
               autocomplete="off" v-model="password">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Phone number</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="phoneNumber">
      </div>


    </form>

    <div class="d-flex flex-shrink-0">
      <div class="d-flex ms-3">
        <router-link to="/projects" class="btn background-florijn btn-active-info">
          Cancel
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn background-florijn btn-active-info" @click="createProgrammer">Create</button>
      </div>
    </div>
  </div>
</template>

<script>

import UserRepository from '../../repository/UserRepository'
export default {
  // eslint-disable-next-line
  name: "CreateProgrammerProjectView",

  data() {
    return {
      UserRepository: new UserRepository(),
      email: "",
      firstname: "",
      lastname: "",
      password: "",
      phoneNumber: "",
    }
  },

  methods: {
    async createProgrammer() {

      const usertype = "programmer";

      await this.UserRepository.createUser(this.email, this.firstname, this.lastname, this.password, this.phoneNumber, usertype);

      this.$router.push("/programmers");
    },
  }
}
</script>

<style scoped>
.descriptionHeight {
  height: auto;
}

.form-control.form-control-solid {
  background-color: lightgray;
  border-color: #F5F8FA;
  color: #5E6278;
  transition: color 0.2s ease, background-color 0.2s ease;
}
</style>
