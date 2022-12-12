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
        @close-popup="closePopup"
        @adding-date="addDate">
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
  async created(){
    console.log("CREATED")

    const availability = await this.availabilityRepository.getAvailabilityById(1)
    availability.title = "KREK"
    console.log(this.betweenDates(availability.st, availability.endDate))

    let calendarApi = this.$refs.calendar.getApi();
    calendarApi.addEvent({
      title: availability.title,
      start: availability.startDate,
      end: availability.endDate,
    })

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
        events: []
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
    async addDate(date) {
      let calendarApi = this.$refs.calendar.getApi();

      let calendarData = await this.availabilityRepository.createAvailability(1, date.start, date.end)
      calendarApi.addEvent({
        title: date.title,
        start: calendarData.start,
        end: calendarData.end,
      })

      // To calculate the time difference of two dates
      const start = new Date(date.start)

      const end = new Date(date.end)

      const hoursOfEvent = this.betweenDates(start.getTime(), end.getTime())
      console.log(hoursOfEvent)
    },
   betweenDates(from, to ){
     const addDays = (date, days = 1) => {
       const result = new Date(date);
       result.setDate(result.getDate() + days);
       return result;
     };

     const dateRange = (start, end, range = []) => {
       if (start > end) return range;
       const next = addDays(start, 1);
       return dateRange(next, end, [...range, start]);
     };

     return dateRange(from,to);
   },
    editEvent(){
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
