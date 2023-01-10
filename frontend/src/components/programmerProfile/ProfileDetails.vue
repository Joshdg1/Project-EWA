<template>

  <div  class="card mb-5 mb-xl-10" id="kt_profile_details_view">
    <!--begin::Card header-->
    <div class="card-header cursor-pointer">
      <!--begin::Card title-->
      <div class="card-title m-0">
        <h3 class="fw-bolder m-0">Profiel details</h3>
      </div>
      <form ref="uploadForm" @submit.prevent="submit">
        <input type="file" ref="uploadFile" @change="onFileUpload()" class="form-control" required>
        <input type="button" @click="startUpload()" name="Upload" value="Upload">
      </form>
      <!--end::Card title-->
      <!--begin::Action-->
      <div class="d-flex ms-3">
        <div style="margin-top: 20px">
          <a @click="setEditProfile()" class="mb-2 btn btn-sm bg-primary btn-active-info" tooltip="New App" data-bs-toggle="modal"
             data-bs-target="#kt_modal_create_app" id="kt_toolbar_primary_button">Wijzig profiel-pagina</a>
        </div>
      </div>
      <!--end::Action-->
    </div>

    <!--begin::Card header-->
    <!--begin::Card body-->
    <div class="card-body p-9">
      <!--begin::Row-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Voornaam(en)</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bolder fs-6 text-gray-800">{{sampleProgrammer.firstName}} </span>
        </div>
        <!--end::Col-->
      </div>
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Achternaam</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{sampleProgrammer.lastName}}</span>
        </div>
        <!--end::Col-->
      </div>
      <!--end::Row-->
      <!--begin::Input group-->
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Email-adres</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.email }}</span>
        </div>
        <!--end::Col-->
      </div>
      <div class="row mb-7">
        <!--begin::Label-->
        <label class="col-lg-4 fw-bold text-muted">Telefoonnummer</label>
        <!--end::Label-->
        <!--begin::Col-->
        <div class="col-lg-8 fv-row">
          <span class="fw-bold fs-6 text-gray-800">{{ sampleProgrammer.phoneNumber }}</span>
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

import UserRepository from "../../repository/UserRepository";
import axios from 'axios';

export default {
  name: "ProfileDetails",
  props: ['sampleProgrammer'],
  emits: ['edit-profile'],


  data() {
    return {
      editingProfile: null,
      repository: new UserRepository(),
      formData: null
    }
  },
  methods: {
    setEditProfile() {
      this.editingProfile = true
      this.$emit('edit-profile', this.editingProfile)
    },
    // onFileSelected(){
    //   const userId = sessionStorage.getItem("id")
    //     this.selectedFile = this.$refs.file.files[0];
    //     const formData = new FormData();
    //     formData.append('file', this.selectedFile);
    //     formData.append("userId", userId)
    //     // const headers = { 'Content-Type': 'multipart/form-data' };
    //
    //
    //     console.log(this.$refs.file + "wioefghoi")
    //     console.log(formData)
    //
    //   this.repository.sendFile(formData)
    // },

    onFileUpload() {
      // const userId = sessionStorage.getItem("id")
      let file = this.$refs.uploadFile.files[0]
      this.formData = new FormData();
      this.formData.append("file", file)
    },

    startUpload() {
      axios({
        url: 'http://localhost:8081/files/uploadFile',
        method:'POST',
        data: this.formData,
        headers: {
          Accept: 'application/json',
          'Content-Type': 'multipart/form-data'
        },
      }).then(response => {
        console.log(JSON.stringify(response.data))
      })
    }

  }
}
</script>

<style scoped>


</style>