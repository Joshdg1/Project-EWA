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
     this.userId = sessionStorage.getItem("id")

    const availability = await this.availabilityRepository.getAvailabilityById(this.userId)

    for (const element of availability) {
      let calendarApi = this.$refs.calendar.getApi();

      // let start = new Date(element.startDate).getTime()
      // let end = new Date(element.endDate).getTime()
      // const time = ((end - start) / 60 / 60 / 1000)
      // this.totalHours += time
      const hours = await this.hoursRepository.getHoursByProject(element.project)
      const ourUserId = this.userId
      let totalHours = 0;
      hours.forEach(function (entry){
        console.log(typeof entry.user.id)
        console.log(typeof ourUserId)
        if (entry.user.id.toString() === ourUserId){
          totalHours += entry.hours
        }
      })

      this.totalHours = totalHours


      calendarApi.addEvent({
        title: element.project.title,
        start: element.startDate,
        end: element.endDate,
      })
    }
  },

  name: 'availabilityProgrammer',
  emits: ['add-date'],
  data() {
    return {
      hoursRepository: new HourRepository(),
      popupStatusAdd: null,
      popupStatusEdit: null,
      totalHours: 0,
      userId: null,
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
    addDates(dateList){
      for (const responseDate in dateList){
        let calendarApi = this.$refs.calendar.getApi();
        calendarApi.addEvent({
          title: responseDate.project.title,
          start: responseDate.startDate,
          end: responseDate.endDate,
        })
      }
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
