<template>
  <div>
    <form>
      <div class="text-center mb-10">
        <h1 class="text-dark mb-3">Create a new Client</h1>
      </div>


      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">name</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="name">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bold text-dark fs-6 mb-0">email</label>
        </div>
        <input class="form-control form-control-lg form-control-solid" type="text"
               name="Email" autocomplete="off" v-model="email">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">address</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="address">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">city</label>
        <input class="form-control form-control-lg form-control-solid" type="text"
               autocomplete="off" v-model="city">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">postcode</label>
        <input class="form-control form-control-lg form-control-solid" type="text"
               autocomplete="off" v-model="postcode">
      </div><div class="fv-row mb-10 fv-plugins-icon-container">
      <label class="form-label fs-6 fw-bold text-dark">projecttype</label>
      <input class="form-control form-control-lg form-control-solid" type="text"
             autocomplete="off" v-model="projectType">
    </div>

    </form>

    <div class="d-flex flex-shrink-0">
      <div class="d-flex ms-3">
        <router-link to="/projects" class="btn background-florijn btn-active-info">
          Cancel
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn background-florijn btn-active-info" @click="setSession">Next</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line
  name: "CreateClientProjectView",

  data() {
    return {
      name: "",
      email: "",
      address: "",
      city: "",
      postcode: "",
      projectType: ""
    }
  },

  methods: {
    setSession() {
      //clear the session without clearing the user login details.
      localStorage.name = "";
      localStorage.email = "";
      localStorage.address = "";
      localStorage.city = "";
      localStorage.postcode = "";
      localStorage.projectType = "";

      localStorage.name = this.name;
      localStorage.email = this.email;
      localStorage.address = this.address;
      localStorage.city = this.city;
      localStorage.postcode = this.postcode;
      localStorage.projectType = this.projectType;

      this.$router.push("/createNewClient2")
    }
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
