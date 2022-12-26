<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card card-xl-stretch mb-5 mb-xl-8">
        <!--begin::Header-->
        <h3 class="card-title align-items-start flex-column">
          <span class="card-label fw-bolder fs-3 mb-1">Programmers</span>
        </h3>
        <div class="card-header border-0 pt-5">
<span class="svg-icon svg-icon-1 position-absolute ms-4 loop" >
												<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
													<rect opacity="0.5" x="17.0365" y="15.1223" width="8.15546" height="2" rx="1" transform="rotate(45 17.0365 15.1223)" fill="currentColor"></rect>
													<path d="M11 19C6.55556 19 3 15.4444 3 11C3 6.55556 6.55556 3 11 3C15.4444 3 19 6.55556 19 11C19 15.4444 15.4444 19 11 19ZM11 5C7.53333 5 5 7.53333 5 11C5 14.4667 7.53333 17 11 17C14.4667 17 17 14.4667 17 11C17 7.53333 14.4667 5 11 5Z" fill="currentColor"></path>
												</svg>
											</span>
          <input type="text" data-kt-ecommerce-order-filter="search"
                 v-model="search"
                 class="form-control form-control-solid w-250px ps-14"
                 placeholder="Search Programmer">
<div class="rightButtons">
  <multiselect class="newSkill" v-model="value" @select="filterBySkill" :options="skills" :searchable="true" :close-on-select="true"
               :show-labels="false"
               placeholder="Search a skill"></multiselect>
  <router-link to="/programmers/add">

    <div class="card-toolbar" data-bs-toggle="tooltip" data-bs-placement="top" data-bs-trigger="hover"
         title="Click to add a programmer">
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
        <!--end::Svg Icon-->New User</a>
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
                <th>Email</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Phone number</th>
                <th>Usertype</th>
              </tr>
              </thead>
              <!--end::Table head-->
              <!--begin::Table body-->
              <tbody>
              <tr v-for="programmer in resultQuery" v-bind:key="programmer">
                <div class="form-check form-check-sm form-check-custom form-check-solid">
                  <input class="form-check-input" type="checkbox" value="1" data-kt-check="true"
                         data-kt-check-target=".widget-9-check"/>
                </div>
                <td>{{ programmer.email }}</td>
                <td>{{ programmer.firstName }}</td>
                <td>{{ programmer.lastName }}</td>
                <td>{{ programmer.phoneNumber }}</td>
                <td>{{ programmer.userType }}</td>

                <div class="d-flex  flex-shrink-0">
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1" @click="editProgrammer()">
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
                  <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm" @click="deleteProgrammer(programmer)">
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

import UserRepository from '../repository/UserRepository'
import Multiselect from "vue-multiselect";


export default {
  components: {Multiselect},
  name: "ProgrammerAdmin.vue",
  props: ['programmers'],
  emits: ['deleteProgrammer', 'editProgrammer'],

  data() {
    return {
      editingProgrammer: null,
      search: null,
      repository: new UserRepository(),
      skills: ["MS Office Access | Front-end", "MS Office Excel | Front-end", "MS Office Access VBA | Front-end",
        "MS Powerpivot | Front-end", "MS Office Word | Front-end", "MS Office Word VBA | Front-end", "MS Office Outlook | Front-end",
        "MS Office Outlook VBA | Front-end", "MS Office VBA | Front-end", "MS SQL-Server | Back-end", "MS SQL-Server Stored Procedures | Back-end"
        , "MS SQL-Server Views | Back-end", "MY SQL | Back-end", "MY SQL Workbench | Back-end", "MS Azure | Back-end", "Oracle | Back-end",
        "Database Filemaker", "Database Filemaker Script", "Database Filemaker Server", "Database MS VB.NET", "Database MS Visual Basic",
        "Database Microsoft Dynamics 365", "Database Microsoft Dynamics 365 for Operations", "Javascript | Web Based Front-end",
        "Java| Web Based Front-end", "PhP | Web Based Front-end", "ASP.NET | Web Based Front-end", "Google Apps | Web Based Front-end"
        , "Google Apps Script | Web Based Front-end", "PowerApps | Web Based Front-end", "Flow | Web Based Front-end", "HTML | Web Based Front-end"
        , "CSS | Web Based Front-end", "Microsoft Dynamics AX | Web Based Front-end", "Database Microsoft Dynamics 365 for Business Applications"
        , "Database Sharepoint", "C# | Web Based Front-end", "C++/CLI (Managed) | Web Based Front-end", "F# | Web Based Front-end"
        , "Q# | Web Based Front-end", "Windows PowerShell (Core) | Web Based Front-end", ".NET Core | Web Based Front-end", "Angular/AngularJS | Web Based Front-end"
        , ".NET Framework | Front-end", "XML - XAML | Front-end", "Bootstrap | Web Based Front-end", "Mendix | Web Based Front-end"
        , "OutSystems | Web Based Front-end", "Power BI Overall", "Power BI DAX", "Power BI M Language", "Power BI Grafisch", "Power BI Power Query"
        , "Power BI Power BI Beheer", "Power BI Datamodellering", "Power BI Data analyse"],
      value: null,
    }
  },
  computed: {
    resultQuery() {
      console.log("UPDATE")
      if (this.search) {
        return this.programmers.filter(item => {
          if ( this.search
              .toLowerCase()
              .split(" ")
              .every(v => item.firstName.toLowerCase().includes(v)))
          {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.firstName.toLowerCase().includes(v));
          }else {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.lastName.toLowerCase().includes(v));
          }

        });
      } else {
        return this.programmers;
      }
    },
  },


  methods: {
    filterBySkill(){
      console.log("WERKT")
      console.log(this.resultQuery)
      if (this.value){
        return  this.resultQuery.filter(item => {
          return(this.value.every(v => item.skills.includes(v)))
        })
      }else{
        return this.resultQuery
      }
    },
    async deleteProgrammer(programmer) {
      await this.repository.deleteUserById(programmer.id);
      location.reload();
    },

    editProgrammer() {
      this.editingProgrammer = true;
      this.$emit('editProgrammer', this.editingProgrammer)
    }
  }
}
</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>
.loop{
  margin-top: 1em;
}
.newSkill{
  width: 15vw;
}
.rightButtons {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}
</style>