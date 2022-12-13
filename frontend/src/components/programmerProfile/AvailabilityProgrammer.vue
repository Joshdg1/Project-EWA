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
        {{ totalHours }}  uren
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
        @close-popup="closePopup">

    </AddDatePopUp>
    <EditDatePopUp
    v-if="popupStatusEdit"
    :selected-event="selectedDate"
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
import ProgrammerRepository from "@/repository/ProgrammerService";
import EditDatePopUp from "@/components/programmerProfile/EditDatePopUp.vue";
import programmerDate from "@/models/programmer/programmerDate";

export default {

  components: {
    EditDatePopUp,
    AddDatePopUp, FullCalendar // make the <FullCalendar> tag available
  },
  async created() {
    const userID = sessionStorage.getItem("id")
    const availability = await this.availabilityRepository.getAvailabilityById(userID)

      for (let i = 0; i < availability.length; i++) {
      let calendarApi = this.$refs.calendar.getApi();

      let start = new Date( availability[i].startDate).getTime()
      let end = new Date( availability[i].endDate).getTime()
     const time = ((end - start)/60/60/1000)
      console.log(time)
      this.totalHours+=time
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
      popupStatusAdd: null,
      popupStatusEdit: null,
      totalHours: 0,
      selectedDate: null,
      eventStart: null,
      eventEnd: null,
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

      console.log(hoursStart)
      this.selectedDate = new programmerDate(info.event.title,this.eventStart,this.eventEnd,hoursStart,hoursEnd)

      this.popupStatusEdit = true
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
