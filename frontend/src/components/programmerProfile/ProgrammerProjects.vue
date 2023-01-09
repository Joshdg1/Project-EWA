<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">

    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Projecten</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">

      </div>
      <!--      end::Action-->
    </div>
            <div class="card-body p-11">
              <div class="projectCardBody"
              v-for="project in this.projects"
                   v-bind:key = project.id
              >
                <div class="skillContainer">

                  <img src="/assets/project-management-icon-to-do-list-symbol-vector-id1175727223-287105119-removebg-preview.png" class="projectIcon">
                  <div class="CardText">
                    <div>{{ project.title }}  </div>
                    <div> {{project.description}} </div>
                  </div>

                </div>
              </div>
            </div>

  </div>
</template>

<script>
import {Project} from "@/models/project";
import ProjectRepository from "@/repository/ProjectRepository";

export default {

  name: "ProgrammerProjects",
  created() {

  },
  data() {
    return {
      projects: [],
      repository: new ProjectRepository()
    }
  },

}

</script>

<style scoped>
.card-body {
  display: flex;

  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.CardText {
  border-top: 2px solid #EF5722 !important;
  text-align: center;
}

.skillContainer {
  display: flex;
  flex-direction: column;
  background-color: #E4E6EF;

  height: 15em;
  width: 15em;
  align-items: center;
  justify-content: center;
  border-radius: 20px !important;
  margin-right: 2em
}

.projectIcon {
  height: 2em;
  margin: 2em;

}
.card-header{
  display: flex;
  flex-direction: column;
  margin: 1em;
  justify-content: center;
padding: .25em;
}
</style>