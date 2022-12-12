<template>
  <div class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Availability</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
      </div>
      <!--end::Action-->
    </div>
    <div class="card-body p-9">
      <div class="hours">
        {{ totalHours }} aantal uren
      </div>
      <div class="availableInput">
        <FullCalendar
            class="calender"
            :options="calendarOptions"
            ref="calendar"/>
      </div>
    </div>
    <AddDatePopUp
        v-if="popupStatus"
        :selectedDate="selectedDate"
        @close-popup="closePopup">

    </AddDatePopUp>
  </div>
</template>

<script>

import '@fullcalendar/core/vdom' // solves problem with Vite
import AddDatePopUp from "./AddDatePopUp";
import FullCalendar from "@fullcalendar/vue"
import timeGridPlugin from '@fullcalendar/timegrid'
import interactionPlugin from '@fullcalendar/interaction'
import AvailabilityRepository from "@/repository/AvailabilityRepository";
import ProgrammerRepository from "@/repository/ProgrammerService";

export default {

  components: {
    AddDatePopUp, FullCalendar // make the <FullCalendar> tag available
  },
  async created() {

    const availability = await this.availabilityRepository.getAvailabilityById(20)
    console.log(availability)
    for (let i = 0; i < availability.length; i++) {
      let calendarApi = this.$refs.calendar.getApi();
      availability[i].title = "KREK"

      calendarApi.addEvent({
        title: availability[i].title,
        start: availability[i].startDate,
        end: availability[i].endDate,
      })
    }





  },

  name: 'availabilityProgrammer',
  emits: ['add-date'],
  data() {
    return {
      popupStatus: null,
      totalHours: 0,
      selectedDate: null,
      programmerRepository: new ProgrammerRepository(),
      availabilityRepository: new AvailabilityRepository(),

      calendarOptions: {
        plugins: [timeGridPlugin, interactionPlugin],
        initialView: 'timeGridWeek',
        dateClick: this.dateClick,
        eventClick: this.editEvent,
        editable: true,
        events: [
          {title: 'event 1', date: '2022-12-11 10:30'},
          {title: 'event 2', date: '2022-12-12 16:15'}]
      }
    }
  },
  methods: {
    dateClick: function (arg) {
      this.selectedDate = arg.date
      console.log(arg)
      this.popupStatus = true
    },

    closePopup(newPopupStatus) {
      this.popupStatus = newPopupStatus
    },
    // async addDate(date) {
    //   let calendarApi = this.$refs.calendar.getApi();
    //
    //   let calendarData = await this.availabilityRepository.createAvailability(1, date.start, date.end)
    //   calendarApi.addEvent({
    //     title: date.title,
    //     start: calendarData.start,
    //     end: calendarData.end,
    //   })
    //
    // },

    editEvent() {
      alert("JEMOER")
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
