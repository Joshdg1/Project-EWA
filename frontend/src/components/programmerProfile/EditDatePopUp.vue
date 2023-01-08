<template>
  <div class="popup">

    <div class="popup-inner">
      <div class="close">

        <span class="svg-icon svg-icon-1 " @click="cancel">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
									<rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)"
                        fill="black"/>
									<rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="black"/>
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
        <input v-model="newDate.hoursPerDayStart" type="time" class="cardInput">
        <input v-model="newDate.hoursPerDayEnd" type="time" class="cardInput">
        <div class="SkillLevel">
          <input v-model="newDate.start" type="date" class="cardInput">
        </div>
        
        <input v-model="newDate.end" type="date" class="cardInput">

      </div>
      <div class="buttons">
        <!--        <button class="btn bg-primary btn-active-info addSkill" @click="cancel">anuleren</button>-->
        <button class="btn bg-primary btn-active-info addSkill" @click="deleteAvail">Verwijderen</button>
        <button class="btn bg-primary btn-active-info addSkill" @click="updateDate">Sla datum op</button>
      </div>

      <slot/>
    </div>
  </div>
</template>

<script>

import AvailabilityRepository from "@/repository/AvailabilityRepository";
import ProjectRepository from "@/repository/ProjectRepository";


export default {
  name: "EditDatePopUp",
  props: ['selectedEvent'],
  emits: ['close-popup'],
 async created() {
    this.newDate = this.selectedEvent;
    this.userID = sessionStorage.getItem("id")

    const Projects = await this.projectRepository.getAllProjects()
    Projects.forEach(p  => this.allProjects.push(p.title))
    console.log(this.allProjects)
  },
  data() {
    return {
      userID: null,
      popupStatus: null,
      newDate: null,
      allProjects: [],
      projectRepository: new ProjectRepository(),
      repository: new AvailabilityRepository(),
      currentId: null,
    }
  },
  methods: {
    closingPopup() {
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
    },
    addHoursToDate(objDate, intHours) {
      console.log(intHours)
      const numberOfMlSeconds = objDate.getTime();
      console.log("time" + numberOfMlSeconds)
      const addMlSeconds = (intHours * 60) * 60 * 1000;

      return new Date(numberOfMlSeconds + addMlSeconds);
    },
    async updateDate() {

      const allAvailabilitys = await this.repository.getAvailabilityById(this.userID)

      for (const element of allAvailabilitys) {
        if ((element.startDate).toString().substring(0, 10) === (this.selectedEvent.start)) {
          if ((element.endDate).toString().substring(0, 10) === (this.selectedEvent.end)) {
            this.currentId = element.id
            break;
          }
        }
      }
      const newStartDate = new Date(this.newDate.start)
      const newEndDate = new Date(this.newDate.end)
      newStartDate.setHours(0)
      newStartDate.setMinutes(0)
      newStartDate.setMilliseconds(0)

      newEndDate.setHours(0)
      newEndDate.setMinutes(0)
      newEndDate.setMilliseconds(0)

      const startHours = ((this.newDate.hoursPerDayStart.substring(0, 2) * 1) + (this.newDate.hoursPerDayStart.substring(3, 5) / 60))
      const endHours = ((this.newDate.hoursPerDayEnd.substring(0, 2) * 1) + (this.newDate.hoursPerDayEnd.substring(3, 5) / 60))

      const startDate = this.addHoursToDate(newStartDate, startHours)
      const endDate = this.addHoursToDate(newEndDate, endHours)

      const starting = new Date(startDate)
      const ending = new Date(endDate)

      await this.repository.updateAvailabilityById(this.currentId, this.newDate.project, starting, ending, this.userID)

      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
      location.reload()
    },
    cancel() {
      this.popupStatus = false
      this.$emit('close-popup', this.popupStatus)
    },
    betweenDates(from, to) {
      const getDaysArray = function (start, end) {

        let dt = new Date(start);
        for (var arr = []; dt <= new Date(end); dt.setDate(dt.getDate() + 1)) {
          arr.push(new Date(dt));
        }
        return arr;
      };
      const daylist = getDaysArray(new Date(from), new Date(to));
      daylist.map((v) => v.toISOString().slice(0, 10)).join("")
      return daylist
    },
    async deleteAvail() {

      if (confirm("Wil je deze datum verwijderen?") === true) {
        const allAvailabilitys = await this.repository.getAvailabilityById(this.userID)

        const start = new Date(this.selectedEvent.start).toLocaleDateString()
        const end = new Date(this.selectedEvent.end).toLocaleDateString()

        for (const element of allAvailabilitys) {
          if (new Date((element.startDate)).toLocaleDateString() === (start)) {
            if (new Date((element.endDate)).toLocaleDateString() === (end)) {
              this.currentId = element.id
              break;
            }
          }
        }
        await this.repository.deleteAvailability(this.currentId)
      }
      location.reload()
    }
  }
}
</script>

<style scoped>
.close {
  display: flex;
  justify-content: right;
  width: 100%;
}

.popup {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 99;
  background-color: rgba(0, 0, 0, 0.2);

  display: flex;
  align-items: center;
  justify-content: center;
}

.popup-inner {
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

.buttons {
  margin-top: 2em;
  display: flex;
  flex-direction: row;
  height: 7em;

}
</style>