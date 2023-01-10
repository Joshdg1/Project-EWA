<template>
    <div class="row">
        <div class="col-lg-12">
            <div class="card card-xl-stretch mb-5 mb-xl-8">
                <div class="card-header border-0 pt-5">
                    <div class="row">
                        <div class="col">
                            <div class="position-relative mb-5 mb-lg-0">
                                <search-icon></search-icon>
                                <input type="text" data-kt-ecommerce-order-filter="search"
                                       v-model="search"
                                       class="form-control form-control-solid w-250px ps-14"
                                       placeholder="Zoeken...">
                            </div>
                        </div>
                        <div class="col">
                            <multiselect class="newSkill" v-model="value" :options="skills" :searchable="true"
                                         :close-on-select="true"
                                         :show-labels="false"
                                         placeholder="Selecteer een Skill"></multiselect>
                        </div>
                    </div>

                    <div class="card-toolbar">
                        <label class="me-3 fs-6">Sorteren: </label>

                        <select class="form-select form-select-sm form-select-solid  me-5 w-200px" v-model="sortType">
                            <option value="skill-asc">Meeste skills eerst</option>
                            <option value="skill-desc">Minste skills eerst</option>
                            <!--                    <option value="programmer-asc">Meeste sepcialisten eerst</option>-->
                            <!--                    <option value="programmer-desc">Minste sepcialisten eerst</option>-->
                        </select>

                        <router-link to="/programmers/add" class="btn btn-sm btn-light-primary">
                            <plus-icon></plus-icon>New User
                        </router-link>
                    </div>
                </div>
                <div class="card-body py-3">
                    <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
                        <thead>
                        <tr class="fw-bolder text-muted">
                            <th>Email</th>
                            <th>Voornaam(en)</th>
                            <th>Achternaam</th>
                            <th>Telefoonnummer</th>
                            <th>Type gebruiker</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr v-for="programmer in resultQuery" v-bind:key="programmer">
                            <td>{{ programmer.email }}</td>
                            <td>{{ programmer.firstName }}</td>
                            <td>{{ programmer.lastName }}</td>
                            <td>{{ programmer.phoneNumber }}</td>
                            <td>{{ programmer.userType }}</td>
                            <td class="d-flex flex-shrink-0">
                                <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1"
                                   @click="editProgrammer()">
                                    <edit-icon></edit-icon>
                                </a>
                                <a class="btn btn-icon btn-bg-light btn-active-color-primary btn-sm"
                                   @click="deleteProgrammer(programmer)">
                                    <delete-icon></delete-icon>
                                </a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

import UserRepository from '../repository/UserRepository'
import Multiselect from "vue-multiselect";
import SkillRepository from "@/repository/SkillRepository";
import SearchIcon from "./icons/search";
import PlusIcon from "./icons/plus";
import EditIcon from "./icons/edit";
import DeleteIcon from "./icons/delete";

export default {
  components: {DeleteIcon, EditIcon, PlusIcon, SearchIcon, Multiselect},
  name: "ProgrammerAdmin.vue",
  props: ['programmers'],
  emits: ['deleteProgrammer', 'editProgrammer'],
  async created() {

    this.allSkills = await this.skillRepository.getAllSkills()
    this.newProgrammers = this.programmers
    for (const element of this.programmers) {
      if (element.amountOfSkills === undefined) element.amountOfSkills = 0
      for (const item of this.allSkills) {
        if (element.id === item.user.id) {
          element.amountOfSkills = element.amountOfSkills + 1
        }
      }
    }

  },
  data() {
    return {
      editingProgrammer: null,
      newProgrammers: [],
      search: null,
      sortType: "skill-asc",
      repository: new UserRepository(),
      skillRepository: new SkillRepository(),
      allSkills: [],
      sortTypes: ["increasing", "decreasing"],
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
  methods: {
    async deleteProgrammer(programmer) {
      await this.$swal({
        title: "Wil je deze programmeur verwijderen?", text: "Weet je het zeker?",
        type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
      }).then((result) => {
        if (result.value) {
          this.repository.deleteUserById(programmer.id);
          location.reload();
        }
      });
    },

    editProgrammer() {
      this.editingProgrammer = true;
      this.$emit('editProgrammer', this.editingProgrammer)
    },
    amountOfSkillsIncreasing() {
      const newList = this.programmers
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return a.amountOfSkills - b.amountOfSkills
      })
      console.log(sortedList)
    },
    amountOfSkillsDecreasing() {
      const newList = this.programmers
      console.log(newList)
      const sortedList = newList.sort((b, a) => {
        return b.amountOfSkills - a.amountOfSkills
      })
      console.log(sortedList)
    },

  },
  watch: {
      sortType: function (newValue) {
          switch (newValue) {
              case "skill-asc":
                  this.amountOfSkillsIncreasing()
                  break;
              case "skill-desc":
                  this.amountOfSkillsDecreasing()
                  break;
          }
      }
  },

  computed: {
    resultQuery: function () {
      if (this.search) {
        return this.programmers.filter(item => {
          if (this.search
              .toLowerCase()
              .split(" ")
              .every(v => item.firstName.toLowerCase().includes(v))) {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.firstName.toLowerCase().includes(v));
          } else {
            return this.search
                .toLowerCase()
                .split(" ")
                .every(v => item.lastName.toLowerCase().includes(v));
          }
        })
      } else if (this.value) {
        let skillArray = []
        for (const element of this.programmers) {
          for (const item of this.allSkills) {
            if (element.id === item.user.id) {
              skillArray.push(element)
            }
          }
        }
        return this.programmers.filter(p => skillArray.includes(p));
      } else {
        return this.programmers;
      }
    },


  }
}
</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
