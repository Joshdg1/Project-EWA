<template>
  <div>
    <div class="row g-5 g-xl-10 mb-5 mb-xl-10">
      <div>

       <span class="svg-icon svg-icon-1 position-absolute ms-4 loop">
												<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
													<rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1"
                                transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
													<path
                              d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z"
                              fill="currentColor"></path>
												</svg>
											</span>
      <input type="text" data-kt-ecommerce-order-filter="search"
             style="width: 30vw!important;"
             v-model="search"
             class="form-control form-control-solid w-250px ps-14"
             placeholder="Zoeken...">
      </div>
      <div v-for="project in resultQuery" v-bind:key="project.id" class="col-lg-6">
        <!--begin::Card widget 18-->
        <div class="card card-flush h-md-100">
          <!--begin::Body-->
          <div class="card-body">
            <!--begin::Row-->
            <div class="d-flex flex-column h-100">
              <!--begin::Header-->
              <div class="mb-7">
                <!--begin::Headin-->
                <div class="d-flex flex-stack mb-6">
                  <!--begin::Title-->
                  <div class="flex-shrink-0 me-5">
                    <span class="text-gray-400 fs-7 fw-bold me-2 d-block lh-1 pb-1">#{{ project.id }}</span>
                    <span class="text-gray-800 fs-1 fw-bold">{{ project.title }}</span>
                  </div>
                  <!--end::Title-->
                  <span
                      class="badge badge-light-success flex-shrink-0 align-self-center py-3 px-4 fs-7">In Behandeling</span>
                </div>
                <!--end::Heading-->
                <!--begin::Items-->
                <div class="d-flex align-items-center flex-wrap d-grid gap-2">
                  <!--begin::Item-->
                  <div class="d-flex align-items-center me-5 me-xl-13">
                    <!--begin::Symbol-->
                    <div class="symbol symbol-30px symbol-circle me-3">
                      <span class="symbol-label bg-primary text-inverse-primary fw-bold">C</span>
                    </div>
                    <!--end::Symbol-->
                    <!--begin::Info-->
                    <div class="m-0">
                      <span class="fw-semibold text-gray-400 d-block fs-8">Bedrijf</span>
                      <a href="/seven-html-pro/?page=pages/user-profile/overview"
                         class="fw-bold text-gray-800 text-hover-primary fs-7">{{ project.company }}</a>
                    </div>
                    <!--end::Info-->
                  </div>
                </div>
                <!--end::Items-->
              </div>
              <!--end::Header-->
              <!--begin::Body-->
              <div class="mb-6">
                <!--begin::Text-->
                <span class="fw-semibold text-gray-600 fs-6 mb-8 d-block">{{ project.description }}</span>
                <!--end::Text-->
                <!--begin::Stats-->
                <div class="d-flex">
                  <!--begin::Stat-->
                  <div class="border border-gray-300 border-dashed rounded min-w-100px w-100 py-2 px-4 me-6 mb-3">
                    <!--begin::Date-->
                    <span class="fs-6 text-gray-700 fw-bold">{{  project.startDate.toString().substring(0,10) }}</span>
                    <!--end::Date-->
                    <!--begin::Label-->
                    <div class="fw-semibold text-gray-400">Startdatum</div>
                    <!--end::Label-->
                  </div>
                  <!--end::Stat-->
                  <!--begin::Stat-->
                  <div class="border border-gray-300 border-dashed rounded min-w-100px w-100 py-2 px-4 mb-3">
                    <!--begin::Number-->
                    <span class="fs-6 text-gray-700 fw-bold">{{project.hoursWorked }}</span>
                    <!--end::Number-->
                    <!--begin::Label-->
                    <div class="fw-semibold text-gray-400">Uren gewerkt</div>
                    <!--end::Label-->
                  </div>
                  <!--end::Stat-->
                </div>
                <!--end::Stats-->
              </div>
              <!--end::Body-->
              <!--begin::Footer-->
              <span class="fw-semibold text-gray-400 d-block fs-8 mb-2">Toegewezen specialist(en)</span>
              <div class="Specialists">
              <div class="symbol-group symbol-hover flex-nowrap specialist" v-bind:key="user.id" v-for="user in project.users">
                <div v-bind:title="user.firstName + user.lastName" class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
                     data-bs-original-title="Susan Redwood" data-kt-initialized="1">
                  <span class="symbol-label bg-primary text-inverse-primary fw-bold ">{{(user.firstName[0]).toUpperCase()}}</span>
                </div>
              </div>
              </div>
              <!--end::Users group-->
              <!--begin::Actions-->
              <a @click=" setProjectDetails(project)"
                 class="text-dark opacity-75-hover fs-6 fw-semibold">Meer details
                <!--begin::Svg Icon | path: icons/duotune/arrows/arr095.svg-->
                <span class="svg-icon svg-icon-4 svg-icon-primary ms-1">
																<svg width="24" height="24" viewBox="0 0 24 24"
                                     fill="none" xmlns="http://www.w3.org/2000/svg">
																	<path opacity="0.3"
                                        d="M4.7 17.3V7.7C4.7 6.59543 5.59543 5.7 6.7 5.7H9.8C10.2694 5.7 10.65 5.31944 10.65 4.85C10.65 4.38056 10.2694 4 9.8 4H5C3.89543 4 3 4.89543 3 6V19C3 20.1046 3.89543 21 5 21H18C19.1046 21 20 20.1046 20 19V14.2C20 13.7306 19.6194 13.35 19.15 13.35C18.6806 13.35 18.3 13.7306 18.3 14.2V17.3C18.3 18.4046 17.4046 19.3 16.3 19.3H6.7C5.59543 19.3 4.7 18.4046 4.7 17.3Z"
                                        fill="currentColor"></path>
																	<rect x="21.9497" y="3.46448" width="13" height="2"
                                        rx="1" transform="rotate(135 21.9497 3.46448)"
                                        fill="currentColor"></rect>
																	<path
                                      d="M19.8284 4.97161L19.8284 9.93937C19.8284 10.5252 20.3033 11 20.8891 11C21.4749 11 21.9497 10.5252 21.9497 9.93937L21.9497 3.05029C21.9497 2.498 21.502 2.05028 20.9497 2.05028L14.0607 2.05027C13.4749 2.05027 13 2.52514 13 3.11094C13 3.69673 13.4749 4.17161 14.0607 4.17161L19.0284 4.17161C19.4702 4.17161 19.8284 4.52978 19.8284 4.97161Z"
                                      fill="currentColor"></path>
																</svg>
															</span>
                <!--end::Svg Icon--></a>
              <!--end::Actions-->
            </div>
            <!--end::Footer-->
          </div>
          <!--end::Wrapper-->

          <!--end::Row-->
        </div>
        <!--end::Body-->
      </div>
      <!--end::Card widget 18-->
    </div>

  </div>

</template>

<script>
import ProjectRepository from '../repository/ProjectRepository.js'
import HourRepository from "@/repository/HourRepository";
import UserRepository from "@/repository/UserRepository";
import {Project} from "@/models/project";


export default {

  name: "ProjectAdmin.vue",
  emits: ['selecting-project'],
 async created() {
    // getting the user id from the session and converting to an Integer so its comparable with database data
   this.userID = parseInt(sessionStorage.getItem("id"))

   const data = await this.repository.getAllProjects();
   // getting all the data and filtering for projects that the cliebt is attached to.
   for (const element of data) {
     if (element.client.id === this.userID){
       const ProjectHours  = await this.hourRepository.getHoursByProject(element)
       element.hoursWorked = 0
       ProjectHours.forEach(p => element.hoursWorked += p.hours)
       const newProject  = new Project(element.id, element.title, element.description, element.company, element.startDate,element.endDate,element.users, element.hoursWorked)
       this.programmerProjects.push(newProject)
       continue
     }
     // getting all the data and filtering for projects that the user is attached to.
     for (let j = 0; j < element.users.length; j++) {
       if ((element.users[j].id) === this.userID) {
         const ProjectHours  = await this.hourRepository.getHoursByProject(element)
         element.hoursWorked = 0
         ProjectHours.forEach(p => element.hoursWorked += p.hours)
         const newProject  = new Project(element.id, element.title, element.description, element.company, element.startDate,element.endDate,element.users, element.hoursWorked)
         this.programmerProjects.push(newProject)
         continue
       }
     }
   }


 },
  data() {
    return {
      users: [],
      programmerProjects: [],
      projects: [],
      newList: [],
      search: null,
      userRepository: new UserRepository(),
      userID: null,
      hourRepository: new HourRepository(),
      repository: new ProjectRepository(),
    }
  },
  computed: {
    resultQuery: function () {
      if (this.search) {
        return this.programmerProjects.filter(item => {
          if (this.search
              .toLowerCase()
              .split(" ")
              .every(v => item.title.toLowerCase().includes(v))) {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.title.toLowerCase().includes(v));
          } else {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.company.toLowerCase().includes(v));
          }
        })
      } else {
        return this.programmerProjects;
      }
  },
  },
  methods: {

    async deleteProject(project) {
      await this.repository.deleteProjectById(project.id);
      location.reload();
    },


    editProject() {
      this.$emit('editProject', true)
    },
    setProjectDetails(project){
      this.$emit('selecting-project' , project)
    }
  }
}
</script>

<style scoped>
.specialist {
  display: flex;
  width: 1.5vw;
  margin: 0;
  flex-direction: row!important;
}
.Specialists {
  display: flex;
  flex-direction: row!important;
}
</style>