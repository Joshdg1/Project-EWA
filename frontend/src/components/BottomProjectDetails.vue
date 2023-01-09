<template>
  <div  class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <!--begin::Card header-->
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Project informatie</h3>
      </div>
      <!--end::Card title-->
      <!--begin::Action-->

      <!--end::Action-->
    </div>
    <!--begin::Card header-->
    <!--begin::Card body-->
    <div class="card-body p-9">
      <!--begin::Row-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Start datum</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bolder fs-6 text-gray-800">{{ sampleProgrammer.startDate.toString().substring(0,10)}} </span>
        </div>
        <!--end::Col-->
      </div>
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">End datum</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.endDate.toString().substring(0,10)}}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Row-->
      <!--begin::Input group-->
<!--      <div class="row mb-7">-->
<!--        &lt;!&ndash;begin::Label&ndash;&gt;-->
<!--        <label class="col-lg-4 fw-bold text-muted">Email-adres</label>-->
<!--        &lt;!&ndash;end::Label&ndash;&gt;-->
<!--        &lt;!&ndash;begin::Col&ndash;&gt;-->
<!--        <div class="col-lg-8 fv-row">-->
<!--          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.users}}</span>-->
<!--        </div>-->
        <!--end::Col-->
<!--      </div>-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">description</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.description }}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Input group-->
      <!--begin::Input group-->

    </div>
    <!--end::Card body-->
  </div>
</template>

<script>


import UserRepository from "@/repository/UserRepository";

export default {
  name: "BottomProjectDetails",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],


  data(){
    return {
      editingProfile: null,
      repository: new UserRepository()
    }
  },
  methods: {
    setEditProfile(){
      this.editingProfile = true
      this.$emit('edit-profile' , this.editingProfile)
    }
  }
}
</script>

<style scoped>

</style>