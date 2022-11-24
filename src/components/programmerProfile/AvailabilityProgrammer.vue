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
      <div class="availableInput">
        <FullCalendar class="calender" :options="calendarOptions" ref="calendar" />
      </div>
    </div>
    <button @click="getAllCurrentDates"></button>
  </div>
</template>

<script>


import '@fullcalendar/core/vdom' // solves problem with Vite
import FullCalendar from "@fullcalendar/vue"
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'



export default {

  components: {
    FullCalendar // make the <FullCalendar> tag available
  },

  name: 'availabilityProgrammer',
  data() {
    return {
      calendarOptions: {
        plugins: [ dayGridPlugin, interactionPlugin ],
        initialView: 'dayGridMonth',
        eventClick: this.handleDateClick,
        editable:true,
        events: [
          { title: 'event 1', start: '2022-11-01',end: '2022-11-22'},

        ]
      }
    }
  },
  methods: {
    handleDateClick: function(arg) {

      alert('date click! ' + arg.dateStr)

    },
    getAllCurrentDates(){
      let calendarApi = this.$refs.calendar.getApi();
      const Avail =  calendarApi.getEvents()
      const avail = Avail[0]
      console.log(avail.start)
      console.log(avail.end)
    }

  }

}
</script>

<style>
.inputBox {
  margin: .5em;
}

.availableInput {
  display: flex;
  /*flex-direction: row;*/
  justify-content: center;
  align-content: center;

}
.calender{
  height: 70vh;
  width: 60vw;
}
.dateInput {
  display: flex;
  flex-direction: column;
  justify-content: center;
  background-color: #E4E6EF;
  border-radius: 20px;
  padding: 1em;
  margin: 2em;
  height: 30vh;
}


</style>
