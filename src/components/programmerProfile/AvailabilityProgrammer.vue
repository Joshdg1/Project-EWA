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
        {{totalHours}} aantal uren
      </div>
      <div class="availableInput">
        <FullCalendar class="calender" :options="calendarOptions" ref="calendar"/>
      </div>
    </div>
    <AddDatePopUp v-if="popupStatus" :selectedDate = "selectedDate" @close-popup="closePopup" @adding-date="addDate"></AddDatePopUp>
  </div>
</template>

<script>


import '@fullcalendar/core/vdom' // solves problem with Vite
import AddDatePopUp from "@/components/programmerProfile/AddDatePopUp";
import FullCalendar from "@fullcalendar/vue"
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'


export default {

  components: {
    AddDatePopUp, FullCalendar // make the <FullCalendar> tag available
  },

  name: 'availabilityProgrammer',
  emits: ['add-date'],
  data() {
    return {
      popupStatus: null,
      totalHours: 0,
      selectedDate: null,

      calendarOptions: {
        plugins: [dayGridPlugin, interactionPlugin],
        initialView: 'dayGridMonth',
        dateClick: this.dateClick,
        editable: true,
        events: [

        ]
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
    addDate(date){
      let calendarApi = this.$refs.calendar.getApi();
      calendarApi.addEvent({
        title: date.title,
        start: date.start,
        end: date.end,
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
  /*flex-direction: row;*/
  justify-content: center;
  align-content: center;

}

.calender {
  height: 70vh;
  width: 60vw;
}


.hours{
  display: flex;
  justify-content: right;
  font-size: 1.7em;
  margin-bottom: 1em;
}


</style>
