<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->

        <h3 class="card-title align-items-start flex-column">
          <span class="card-label fw-bolder fs-3 mb-1" style="margin: 1.5em; padding-left: 1em">Projecten</span>
        </h3>
        <div class="card-header border-0 pt-5">
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
                 v-model="search"
                 class="form-control form-control-solid w-250px ps-14"
                 placeholder="Zoeken...">
          <div class="rightButtons">
            <multiselect class="newSkill" v-model="sortType" :options="sortTypes"
                         :close-on-select="true"
                         :allow-empty="false"
                         :show-labels="false"
                         placeholder="sorteer op hoeveelheid specialisten"></multiselect>
            <router-link to="/projects/create">
              <div class="card-toolbar" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-trigger="hover"
                   title="Click to add a project">
                <a href="#" class="btn btn-sm btn-light-primary" data-bs-toggle="modal"
                   data-bs-target="#kt_modal_invite_friends">
                  <!--begin::Svg Icon | path: icons/duotune/arrows/arr075.svg-->
                  <span class="svg-icon svg-icon-3">
													<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                               fill="none">
														<rect opacity="0.5" x="11.364" y="20.364" width="16" height="2" rx="1"
                                  transform="rotate(-90 11.364 20.364)" fill="black"/>
														<rect x="4.36396" y="11.364" width="16" height="2" rx="1" fill="black"/>
													</svg>
												</span>
                  <!--end::Svg Icon-->Nieuw project</a>
              </div>
            </router-link>
          </div>
        </div>
        <!--end::Header-->
        <!--begin::Body-->
        <div class="card-body py-3">
          <!--begin::Table container-->
          <div class="table-responsive">
            <!--begin::Table-->
            <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
              <!--begin::Table head-->
              <thead>
              <tr class="fw-bolder text-muted">
                <th class="w-25px">
                  <div class="form-check form-check-sm form-check-custom form-check-solid">
                    <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                           data-kt-check-target=".widget-9-check"/>
                  </div>
                </th>
                <th>Id</th>
                <th>Titel</th>
                <th>Beschrijving</th>
                <th>Bedrijf</th>
                <th>Gewerkte uren</th>
                <th>Startdatum</th>
                <th>Einddatum</th>
                <th>Status</th>
                <th>Programmeur(s)</th>
                <th>Acties</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="project in resultQuery" v-bind:key="project.id">
                <div class="form-check form-check-sm form-check-custom form-check-solid">
                  <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                         data-kt-check-target=".widget-9-check"/>
                </div>
                <td>{{ project.id }}</td>
                <td>{{ project.title }}</td>
                <td>{{ project.description }}</td>
                <td>{{ project.company }}</td>
                <td>{{ project.hoursWorked }}</td>
                <td>{{ dateFormat(project.startDate) }}</td>
                <td>{{ dateFormat(project.endDate) }}</td>
                <td>{{ setStatus(project.startDate, project.endDate) }}</td>
                <td v-html="getUserProjects(project.users)"></td>

                <div class="d-flex justify-content-end flex-shrink-0">
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editProject()">
                    <!--begin::Svg Icon | path: icons/duotune/art/art005.svg-->
                    <span class="svg-icon svg-icon-3">
																			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                           fill="none">
																				<path opacity="0.3"
                                              d="M21.4 8.35303L19.241 10.511L13.485 4.755L15.643 2.59595C16.0248 2.21423 16.5426 1.99988 17.0825 1.99988C17.6224 1.99988 18.1402 2.21423 18.522 2.59595L21.4 5.474C21.7817 5.85581 21.9962 6.37355 21.9962 6.91345C21.9962 7.45335 21.7817 7.97122 21.4 8.35303ZM3.68699 21.932L9.88699 19.865L4.13099 14.109L2.06399 20.309C1.98815 20.5354 1.97703 20.7787 2.03189 21.0111C2.08674 21.2436 2.2054 21.4561 2.37449 21.6248C2.54359 21.7934 2.75641 21.9115 2.989 21.9658C3.22158 22.0201 3.4647 22.0084 3.69099 21.932H3.68699Z"
                                              fill="black"/>
																				<path
                                            d="M5.574 21.3L3.692 21.928C3.46591 22.0032 3.22334 22.0141 2.99144 21.9594C2.75954 21.9046 2.54744 21.7864 2.3789 21.6179C2.21036 21.4495 2.09202 21.2375 2.03711 21.0056C1.9822 20.7737 1.99289 20.5312 2.06799 20.3051L2.696 18.422L5.574 21.3ZM4.13499 14.105L9.891 19.861L19.245 10.507L13.489 4.75098L4.13499 14.105Z"
                                            fill="black"/>
																			</svg>
																		</span>
                    <!--end::Svg Icon-->
                  </a>
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="deleteProject(project)">
                    <!--begin::Svg Icon | path: icons/duotune/general/gen027.svg-->
                    <span class="svg-icon svg-icon-3">
																			<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                           fill="none">
																				<path
                                            d="M5 9C5 8.44772 5.44772 8 6 8H18C18.5523 8 19 8.44772 19 9V18C19 19.6569 17.6569 21 16 21H8C6.34315 21 5 19.6569 5 18V9Z"
                                            fill="black"/>
																				<path opacity="0.5"
                                              d="M5 5C5 4.44772 5.44772 4 6 4H18C18.5523 4 19 4.44772 19 5V5C19 5.55228 18.5523 6 18 6H6C5.44772 6 5 5.55228 5 5V5Z"
                                              fill="black"/>
																				<path opacity="0.5"
                                              d="M9 4C9 3.44772 9.44772 3 10 3H14C14.5523 3 15 3.44772 15 4V4H9V4Z"
                                              fill="black"/>
																			</svg>
																		</span>
                  </a>
                </div>

              </tr>
              </tbody>
              <!--end::Table body-->
            </table>
            <!--end::Table-->
          </div>
          <!--end::Table container-->
        </div>
        <!--begin::Body-->
      </div>
      <!--end::Tables Widget 3-->
    </div>
  </div>
</template>

<script>
import ProjectRepository from '../repository/ProjectRepository.js'
import Multiselect from "vue-multiselect";

export default {
  components: {Multiselect},
  name: "ProjectAdmin.vue",
  props: ['projects'],
  emits: ['deleteProject', 'editProject'],

  data() {
    return {
      editingProject: null,
      sortType: "increasing",
      search: null,
      sortTypes: ["increasing", "decreasing"],
      repository: new ProjectRepository(),
    }
  },
  watch: {
    sortType: function (newValue) {
      console.log("NEWVAL" + newValue)
      if (newValue === "increasing") {
        console.log("WORKS")
        this.amountOfProgrammersIncreasing()
      } else if (newValue === "decreasing") {
        console.log("WORKS")
        this.amountOfProgrammersDecreasing()
      } else {
        const newList = this.projects
        console.log(newList)
      }
    }
  },
  computed: {
    resultQuery: function () {
      if (this.search) {
        return this.projects.filter(item => {
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
      } else if (this.value) {
        let skillArray = []
        for (const element of this.projects) {
          for (const item of this.allSkills) {
            if (element.id === item.user.id) {
              skillArray.push(element)
            }
          }
        }
        return this.projects.filter(p => skillArray.includes(p));
      } else {
        return this.projects;
      }
    },


  },

  methods: {

    async deleteProject(project) {
      await this.$swal({
        title: "Wil je dit project verwijderen?", text: "Weet je het zeker?",
        type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
      }).then((result) => {
        if (result.value) {
          this.repository.deleteProjectById(project.id);
          location.reload();
        }
      });
    },

    editProject() {
      this.editingProject = true;
      this.$emit('editProject', this.editingProject)
    },

    dateFormat(date) {
      if (date == null) {
        return null;
      }
      return new Date(date).toLocaleDateString('en-GB');
    },

    getUserProjects(users) {
      if (users.length === 0)
        return "";

      let content = `<div class="symbol-group symbol-hover flex-nowrap">`;
      for (const user of users) {
        content += `<div title="${user.firstName} ${user.lastName}" class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
      data-bs-original-title="Susan Redwood" data-kt-initialized="1">
              <span class="symbol-label bg-primary text-inverse-primary fw-bold">${(user.firstName[0]).toUpperCase()}</span>
              </div>`;
      }
      content += `</div>`;


      return content
    },
    amountOfProgrammersIncreasing() {
      const newList = this.projects
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return a.users.length - b.users.length
      })
      console.log(sortedList)
    },
    amountOfProgrammersDecreasing() {
      const newList = this.projects
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return b.users.length - a.users.length
      })
      console.log(sortedList)
    },
    setStatus(startDate, endDate) {
      if (Date.now() >= Date.parse(startDate) && Date.parse(endDate) >= Date.now()) {
        return "Actief"
      }

      return "Inactief"
    }
  }
}
</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>
.loop {
  margin-top: 1em;
}

.newSkill {
  width: 15vw;
}

.rightButtons {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
</style>