<template>
  <div class="row">
    <div class="col-lg-12">
      <div class="card ">
        <div class="card-header border-0 pt-5">
          <div class="row">
            <div class="col">
              <div class="position-relative mb-5 mb-lg-0">
                <search-icon></search-icon>
                <input type="text" data-kt-ecommerce-order-filter="search"
                       v-model="searchQ"
                       class="form-control form-control-solid w-250px ps-14"
                       placeholder="Zoeken...">
              </div>
            </div>
            <div class="col">
              <multiselect class="newSkill" v-model="searchSkill" :options="skills" :searchable="true"
                           :close-on-select="true"
                           :show-labels="false"
                           placeholder="Selecteer een vaardigheid"></multiselect>
            </div>
          </div>

          <div class="card-toolbar">
            <label class="me-3 fs-6">Sorteren op: </label>
            <select class="form-select form-select-sm form-select-solid  me-5 w-200px" v-model="sortType">
              <option value="skill-asc">Meeste vaardigheden</option>
              <option value="skill-desc">Minste vaardigheden</option>
            </select>
            <router-link to="/programmers/create" class="btn btn-sm btn-light-primary">
              <plus-icon></plus-icon>Nieuwe specialist
            </router-link>
          </div>
        </div>

        <programmersList v-if="!this.programmerStatus" :programmers="resultQuery"
                         @deleteProgrammer="deleteProgrammer"
                         @editProgrammer="editProgrammerStatus"></programmersList>
        <edit v-if="this.programmerStatus" :programmers="resultQuery" @deleteProgrammer="deleteProgrammer"
              @editProgrammer="editProgrammerStatus"></edit>
      </div>
    </div>
  </div>
</template>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>

<script>
  import Multiselect from "vue-multiselect";
import programmersList from '../../../components/ProgrammerAdmin'
import edit from '../../../components/ProgrammerAdminEdit'
import UserRepository from '../../../repository/UserRepository'
import PlusIcon from "../../../components/icons/plus";
import SearchIcon from "../../../components/icons/search";

export default {
  name: "AdminProgrammerView",
  components: {
    SearchIcon,
    PlusIcon,
    programmersList,
    edit,
    Multiselect
  },

  async created() {
    await this.loadProgrammers();
  },

  data() {
    return {
      sortType: "skill-asc",
      searchQ: null,
      searchSkill: null,
      programmers: [],
      programmerStatus: null,
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
    }
  },

  methods: {
    async loadProgrammers(){
      console.log('loadProgrammers');
      this.programmers = await this.repository.getAllProgrammers();
    },

    async deleteProgrammer(programmer) {
      await this.$swal({     title: "Wil je deze programmeur verwijderen?",     text: "Weet je het zeker?",
        type: "warning",     showCancelButton: true,     confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer" }).then((result) => { if (result.value) {
          this.repository.deleteUserById(programmer.id); location.reload();} });
    },

    editProgrammerStatus(programmerStatus) {
      this.programmerStatus = programmerStatus;

      if (!programmerStatus)
        this.loadProgrammers();
    },

    amountOfSkillsIncreasing() {
      this.programmers = this.programmers.sort((b, a) => {
        return a.skills.length - b.skills.length
      });
    },
    amountOfSkillsDecreasing() {
      this.programmers = this.programmers.sort((b, a) => {
        return b.skills.length - a.skills.length
      });
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
      if (this.searchQ) {
        return this.programmers.filter(item => {
          if (this.searchQ
                  .toLowerCase()
                  .split(" ")
                  .every(v => item.firstName.toLowerCase().includes(v))) {
            return this.searchQ
                    .toLowerCase()
                    .split(" ")
                    .every(v => item.firstName.toLowerCase().includes(v));
          } else {
            return this.searchQ
                    .toLowerCase()
                    .split(" ")
                    .every(v => item.lastName.toLowerCase().includes(v));
          }
        })
      } else if (this.searchSkill) {
        return this.programmers.filter(
                p => p.skills.findIndex((skill) => {return skill.name === this.searchSkill}) > -1
        );
      } else {
        return this.programmers;
      }
    },
  },
}
</script>

<style scoped>

</style>