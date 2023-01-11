<template>
  <div class="popup">
    <div class="popup-inner">
      <div class="close">
        <span class="svg-icon svg-icon-1 " @click="cancel">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
									<rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="black" />
									<rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="black" />
								</svg>
							</span>
      </div>

      <img src="https://clipground.com/images/date-symbol-clipart.jpg" class="code-icon">
      <div class="CardText">
        <multiselect class="projectsList"
                     v-model=" newDate.project"
                     :options="allProjects"
                     :show-labels="false"
                     placeholder="projecten"
                     :close-on-select="true">
        </multiselect>
        <input v-model="newDate.hoursPerDayStart" type="time"  placeholder="hours per day"  class="cardInput">
        <input v-model="newDate.hoursPerDayEnd" type="time"  placeholder="hours per day"  class="cardInput">
        <div class="SkillLevel">
          <input v-model="newDate.start" type="date"  class="cardInput">
        </div>

        <input v-model="newDate.end" type="date"   class="cardInput">

      </div>
      <div class="buttons">
        <button class="btn bg-primary btn-active-info addSkill" @click="addSkill">Voeg datum toe</button>
      </div>

      <slot/>
    </div>
  </div>
</template>

<script>
import AvailabilityRepository from "@/repository/AvailabilityRepository";
import UserDate from "../../models/userDate";
import Multiselect from "vue-multiselect";
import ProjectRepository from "@/repository/ProjectRepository";
import HourRepository from "@/repository/HourRepository";


export default {
  components: {    Multiselect,
  },
  name: "AddDatePopUp",
  props: ['selectedDate', 'userId'],
  emits: ['close-popup', 'response-list'],
  async created() {
    this.newDate = new UserDate()
    this.newDate.start = new Date(this.selectedDate);

     this.Projects = await this.projectRepository.getAllProjects()
    for (const element of this.Projects) {

      for (let j = 0; j < element.users.length; j++) {
        if ((element.users[j].id) === this.user.id) {
          this.allProjects.push(element.title)
        }
      }
    }

  },
  data(){
    return {
      popupStatus: null,
      Projects: null,
      newDate: [],
      totalHours: 0,
      user: JSON.parse(sessionStorage.user),
      allProjects: [],
      responseList:[],
      hoursRepository: new HourRepository(),
      projectRepository: new ProjectRepository(),
      repository: new AvailabilityRepository()
    }
  },
  methods:{
    closingPopup(){
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
    },
    addHoursToDate(objDate, intHours) {
      const numberOfMlSeconds = objDate.getTime();
      const addMlSeconds = (intHours * 60) * 60 * 1000;
      return new Date(numberOfMlSeconds + addMlSeconds);
    },
  async  addSkill(){
     const allDates = this.betweenDates(this.newDate.start, this.newDate.end)

    const hours = await this.hoursRepository.getHoursById(this.userId)

      for (const element of allDates) {
        //setting the hours, seconds and minutes to null so we can set them later
        element.setHours(0)
        element.setMinutes(0)
        element.setMilliseconds(0)

        //calculating the hours and minutes of the input
        const startHours = ((this.newDate.hoursPerDayStart.substring(0, 2) * 1) + (this.newDate.hoursPerDayStart.substring(3, 5) / 60)  + 1)
        const endHours = ((this.newDate.hoursPerDayEnd.substring(0, 2) * 1) + (this.newDate.hoursPerDayEnd.substring(3, 5) / 60) + 1)
        //setting the hours and minutes
        const startDate = this.addHoursToDate(element, startHours)
        const endDate = this.addHoursToDate(element, endHours)

        //selecting the project
        let Project = null
        const currentProject = this.newDate.project
        this.Projects.forEach(function (entry) {
          if (entry.title === currentProject) {
            Project = entry
          }
        })

       const response  = await this.repository.createAvailability(Project, startDate, endDate, this.userId)
        this.responseList.push(response)

        // calculating time between dates
        let start = new Date(startDate).getTime()
        let end = new Date(endDate).getTime()

        const time = ((end - start) / 60 / 60 / 1000)

        this.totalHours += time
      }

    let Project = null
    const currentProject = this.newDate.project
    this.Projects.forEach(function (entry) {
      if (entry.title === currentProject) {
        Project = entry
      }
    })

    if (hours.length === 0) {
      await this.hoursRepository.createHours(Project, this.totalHours , this.userId)
    }
        this.popupStatus = false
        this.$emit('close-popup', this.popupStatus)
        this.$emit('response-list', this.responseList)
      },

    cancel(){
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
    },
    betweenDates(from, to) {

      const getDaysArray = function (start, end) {

        let dt = new Date(start);
        for (var arr=[]; dt <= new Date(end); dt.setDate(dt.getDate() + 1)) {
          arr.push(new Date(dt));
        }
        return arr;
      };
      const daylist = getDaysArray(new Date(from), new Date(to));
      daylist.map((v)=>v.toISOString().slice(0,10)).join("")
      return daylist
    },
  }
}
</script>
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>
.close{
  display: flex;
  justify-content: right;
  width: 100%;
  cursor: pointer;
}
.popup {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  background-color: rgba(0,0,0 ,0.2);

  display: flex;
  align-items: center;
  justify-content: center;
}
.popup-inner{
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  background-color: #E4E6EF;
  padding: 3em;
  border-radius: 20px;
}
.code-icon {
  height: 2em;
  margin: 2em;
}
.projectsList{
  width: 8.5vw;
  background: none!important;
}
.CardText {
  display: flex;
  flex-direction: column;
  border-top: 2px solid #EF5722 !important;
  justify-content: center;
  align-items: center;
}
.cardInput {
  background: none;
  border-width: 0 0 1px 0;
  border-style: solid;
  border-color: lightblue;
  width: 10vw;
  text-align: center;
}
.SkillLevel {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
}
input:focus {
  outline: none;
}
.addSkill {
  width: 5vw;
  height: 5vh;
  margin: 1em;
  padding: .3em !important;
  font-size: .8em;
}
.buttons{
  margin-top: 2em;
  display: flex;
  flex-direction: row;
  height: 7em;

}
</style>