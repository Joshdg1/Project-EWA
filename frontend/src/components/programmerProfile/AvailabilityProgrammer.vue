<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Beschikbaarheid</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
      </div>
      <!--end::Action-->
    </div>
    <div class="card-body p-9">
      <div class="hours">
        {{ totalHours }}  Uren
      </div>
      <div class="availableInput">
        <FullCalendar
            class="calender"
            :options="calendarOptions"
            ref="calendar"/>
      </div>
    </div>
    <AddDatePopUp
        v-if="popupStatusAdd"
        :selectedDate="selectedDate"
        :user-id="userId"
        @response-list="addDates"
        @close-popup="closePopup">


    </AddDatePopUp>
    <EditDatePopUp
    v-if="popupStatusEdit"
    :selected-event="selectedDate"
    :current-hours="totalHours"
    @close-popup="closeEditPopup"
    >

    </EditDatePopUp>
  </div>
</template>

<script>

import '@fullcalendar/core/vdom' // solves problem with Vite
import AddDatePopUp from "./AddDatePopUp";
import FullCalendar from "@fullcalendar/vue"
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'
import AvailabilityRepository from "@/repository/AvailabilityRepository";
import EditDatePopUp from "@/components/programmerProfile/EditDatePopUp.vue";
import UserDate from "../../models/userDate";
import HourRepository from "@/repository/HourRepository";

export default {

  components: {
    EditDatePopUp,
    AddDatePopUp, FullCalendar // make the <FullCalendar> tag available
  },

  async created() {
    // setting the userId
     this.userId = sessionStorage.getItem("id")

    //getting all availabilities from a user
    const availability = await this.availabilityRepository.getAvailabilityById(this.userId)
    let currentProject = null
    for (const element of availability) {
      let calendarApi = this.$refs.calendar.getApi();



      // calculating time between dates
      currentProject = element.project
      let start = new Date(element.startDate).getTime()
      let end = new Date(element.endDate).getTime()

      const time = ((end - start) / 60 / 60 / 1000)

      this.totalHours += time


      // adding the dates to the calendar
      calendarApi.addEvent({
        title: element.project.title,
        start: element.startDate,
        end: element.endDate,
      })
    }
    //updating the total hours hours
    const hours = await this.hoursRepository.getHoursByProject(currentProject)
    await  this.hoursRepository.updateHoursById(hours[0].id,currentProject, this.totalHours,this.userId,hours[0].isApproved)
  },

  name: 'availabilityProgrammer',
  emits: ['add-date'],
  data() {
    return {
      hoursRepository: new HourRepository(),
      popupStatusAdd: null,
      popupStatusEdit: null,
      totalHours: 0,
      user: JSON.parse(sessionStorage.user),
      selectedDate: null,
      eventStart: null,
      eventEnd: null,
      availabilityRepository: new AvailabilityRepository(),

      calendarOptions: {
        plugins: [timeGridPlugin, interactionPlugin],
        initialView: 'timeGridWeek',
        dateClick: this.dateClick,
        eventClick: this.editEvent,
        editable: true,
        events: []
      }
    }
  },
  methods: {
    dateClick: function () {
      this.popupStatusAdd = true
    },
    closeEditPopup(newPopupStatus){
      this.popupStatusEdit = newPopupStatus
    },
    closePopup(newPopupStatus) {
      this.popupStatusAdd = newPopupStatus
    },


    editEvent: function (info) {
      this.eventStart = info.event.start
      this.eventEnd = info.event.end

      const hoursStart = this.eventStart.toString().substring(16,21)
      const hoursEnd = this.eventEnd.toString().substring(16,21)

      this.selectedDate = new UserDate(info.event.title,this.eventStart,this.eventEnd,hoursStart,hoursEnd)

      this.popupStatusEdit = true
    },
   async addDates(){
    // cleaning all calendar events
     let calendarApi = this.$refs.calendar.getApi();
     let eventSources = calendarApi.getEventSources();
     let len = eventSources.length;
     for (let i = 0; i < len; i++) {
       eventSources[i].remove();
     }

    // getting all availabilities
      const dates = await this.availabilityRepository.getAllAvials()
     let ourDates = []
     const ourUser =  JSON.parse(sessionStorage.user)
     dates.forEach( function (entry){
       if (entry.user.id === ourUser.id){

         ourDates.push(entry)
       }
     })
      let totalHours = 0
     // adding our dates to the calendar
     ourDates.forEach( function (responseDate){
       let start = new Date(responseDate.startDate).getTime()
       let end = new Date(responseDate.endDate).getTime()

       const time = ((end - start) / 60 / 60 / 1000)

       totalHours += time


       calendarApi.addEvent({
         title: responseDate.project.title,
         start: responseDate.startDate,
         end: responseDate.endDate,
       })
     })

    this.totalHours =totalHours
    }
  }
}
</script>

<style>
.availableInput {
  display: flex;
  justify-content: center;
  align-content: center;
}

.calender {
  height: 70vh;
  width: 60vw;
}

.hours {
  display: flex;
  justify-content: right;
  font-size: 1.7em;
  margin-bottom: 1em;
}
</style>
