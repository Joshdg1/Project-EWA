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
import dayGridPlugin from '@fullcalendar/daygrid'
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
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: 'dayGridMonth',
        dateClick: this.dateClick,
        editable: true,
        events: []
      }
    }
  },
  methods: {


    datediff(first, second) {
      return Math.round((second - first) / (1000 * 60 * 60 * 24));
    },
    // eventClick: function () {
    // let deleteEvent =  confirm("wil je " + arg)
    //  let deletingEvent = this.calendarApi.getEventById()
    //  this.events.filter()
    // },
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

      const hoursOfEvent = this.datediff(start.getTime(), end.getTime()) * date.hoursPerDay

      this.totalHours = this.totalHours + hoursOfEvent
    },

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
