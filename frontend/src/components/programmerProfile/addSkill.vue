<template>
  <div class="modal-dialog mw-650px">
    <!--begin::Modal content-->
    <div class="modal-content">
      <!--begin::Modal header-->
      <div class="modal-header pb-0 border-0 justify-content-end">
        <!--begin::Close-->
        <div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
          <!--begin::Svg Icon | path: icons/duotune/arrows/arr061.svg-->
          <span class="svg-icon svg-icon-1" @click="closePopup">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
									<rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)"
                        fill="black"/>
									<rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="black"/>
								</svg>
							</span>
          <!--end::Svg Icon-->
        </div>
        <!--end::Close-->
      </div>
      <!--begin::Modal header-->
      <!--begin::Modal body-->
      <div class="modal-body scroll-y mx-5 mx-xl-18 pt-0 pb-15">
        <!--begin::Heading-->
        <div class="text-center mb-13">
          <!--begin::Title-->
          <h1 v-if="!editSkill.id" class="mb-3">Voeg een vaardigheid toe</h1>
          <h1 v-if="editSkill.id > 0" class="mb-3">Wijzig een vaardigheid</h1>
          <!--end::Title-->
        </div>
        <!--end::Heading-->
        <div class="addASkill">
          <label class="typo__label">Selecteer een vaardigheid:</label>
          <multiselect class="newSkill" v-model="editSkill.name" :options="skills" :searchable="true"
                       :close-on-select="true"
                       :show-labels="false"
                       placeholder="Pick a value"></multiselect>
          <label class="typo__label">Geef een cijfer van 1-5:</label> <br>
          <input type="number" step="1" min="1" max="5" class="levelSkill" v-model="editSkill.level">
        </div>
        <button v-if="!editSkill.id" class="btn bg-primary btn-active-info addSkill" @click="addSkill">Voeg toe</button>
        <button v-if="editSkill.id > 0" class="btn bg-primary btn-active-info addSkill" @click="addSkill">Wijzig</button>
      </div>
      <!--end::Modal body-->
    </div>
  </div>

</template>

<script>
import Multiselect from 'vue-multiselect';
import SkillRepository from "@/repository/SkillRepository";
import {UserSkill} from "@/models/userSkill";

export default {
  components: {Multiselect},
  name: "addSkill",
  props: ["skill"],
  emits: ['close-popup'],
  data() {
    return {
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
      repository: new SkillRepository(),
      editSkill: null,
      userID: 0,
    }
  },
  async created() {
    this.userID = sessionStorage.getItem("id")
    if (this.skill) {
      this.editSkill = this.skill;
    } else {
      this.editSkill = new UserSkill();
    }
  },
  methods: {
    closePopup() {
      this.$emit('close-popup')
    },

    async addSkill() {
      const currentSkill = await this.repository.findSkillsById(this.userID);
      this.addCheck = false;
      this.$emit('addCheck', this.addCheck)

      // check empty
      if (!this.editSkill.level || !this.editSkill.name)
        return alert("Vul de velden in")

      // check if user already has skill
      for (const element of currentSkill) {
        if (element.id === this.editSkill.id)
          continue;

        if (element.name === this.editSkill.name) {
          alert("Deze skill bezit u al.")
          return
        }
      }

      this.editSkill.user_id = this.userID;

      if (this.editSkill.id > 0) {
        await this.repository.updateSkill(this.editSkill)
      } else {
        await this.repository.createSkill(this.editSkill)
        location.reload();
      }

      this.closePopup();
    }
  }
}
</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>
.addASkill {
  width: 400px;
  height: 300px;
}

.typo__label {
  margin-top: 40px;
}
</style>