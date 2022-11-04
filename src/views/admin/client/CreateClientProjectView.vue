<template>
  <div>
    <form>
      <div class="text-center mb-10">
        <h1 class="text-dark mb-3">Create a new project</h1>
      </div>


      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Project name</label>
        <input class="form-control form-control-lg form-control-solid"  type="text" name="text"
               autocomplete="off">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bold text-dark fs-6 mb-0">Type of project</label>
        </div>

        <input class="form-control form-control-lg form-control-solid" type="text"
               name="Type of project" autocomplete="off">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Client Name</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Project Duration</label>
        <input class="form-control form-control-lg form-control-solid" type="number"
               autocomplete="off">
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Description</label>
        <input class="form-control form-control-lg form-control-solid descriptionHeight" type="text" name="text"
               autocomplete="off">
      </div>
    </form>

    <div class="d-flex flex-shrink-0">
      <div class="d-flex ms-3">
        <router-link to="/adminProject" class="btn background-florijn btn-active-info">
          Cancel
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <router-link to="/createProject-2" class="btn background-florijn btn-active-info">
          Next
        </router-link>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line
  name: "CreateClientProjectView"
}
</script>

<style scoped>
.descriptionHeight{
  height: auto;
}
.form-control.form-control-solid {
  background-color: lightgray;
  border-color: #F5F8FA;
  color: #5E6278;
  transition: color 0.2s ease, background-color 0.2s ease;
}
</style>
