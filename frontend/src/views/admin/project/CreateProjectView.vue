<template>
  <div>
    <form>
      <div class="text-center mb-10">
        <h1 class="text-dark mb-3">Create a new Project</h1>
      </div>


      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Project title</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="title">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bold text-dark fs-6 mb-0">Project description</label>
        </div>
        <input class="form-control form-control-lg form-control-solid" type="text"
               name="Type of project" autocomplete="off" v-model="description">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Company name</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="company">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Begin date</label>
        <input class="form-control form-control-lg form-control-solid" type="date"
               autocomplete="off" v-model="startDate">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">End date</label>
        <input class="form-control form-control-lg form-control-solid" type="date"
               autocomplete="off" v-model="endDate">
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
  name: "CreateProjectView",

  data() {
    return {
      title: "",
      description: "",
      company: "",
      startDate: "",
      endDate: ""
    }
  },

  methods: {
    setSession() {
      //clear the session without clearing the user login details.
      localStorage.title = "";
      localStorage.description = "";
      localStorage.company = "";
      localStorage.startDate = "";
      localStorage.endDate = "";

      localStorage.title = this.title;
      localStorage.description = this.description;
      localStorage.company = this.company;
      localStorage.startDate = this.startDate;
      localStorage.endDate = this.endDate;

      this.$router.push("/createNewProject2")
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
