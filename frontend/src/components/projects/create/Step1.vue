<template>
  <div>
    <div class="mb-5">
      <label class="form-label mb-3">Naam</label>
      <input type="text" class="form-control form-control-lg " id="fullName" v-model="formData.name" placeholder=""
             value="">
      <div v-if="errors.name" class="text-danger fs-7">{{ errors.name }}</div>
    </div>
    <div class="mb-5">
      <label class="form-label mb-3">Beschrijving</label>
      <textarea class="form-control form-control-lg " id="description" v-model="formData.description" placeholder=""
                value="">
            </textarea>
      <div v-if="errors.description" class="text-danger fs-7">{{ errors.description }}</div>
    </div>

    <div class="mb-5">
      <label class="form-label mb-3">Bedrijf</label>
      <select class="form-select form-select-lg " id="company" v-model="formData.client_id">
        <option value="0">Selecteer een bedrijf</option>
        <option v-for="client in this.clients" v-bind:key="client.id" v-bind:value="client.id">
          {{ client.companyName }}
        </option>
      </select>
      <div v-if="errors.client" class="text-danger fs-7">{{ errors.client }}</div>
    </div>

    <div class="mb-5">
      <label class="form-label mb-3">Start Datum</label>
      <input type="date" class="form-control form-control-lg " id="startDate" v-model="formData.start" placeholder=""
             value="">
      <div v-if="errors.start" class="text-danger fs-7">{{ errors.start }}</div>
    </div>
    <div class="mb-5">
      <label class="form-label mb-3">Deadline</label>
      <input type="date" class="form-control form-control-lg " id="endDate" v-model="formData.end" placeholder=""
             value="">
      <div v-if="errors.end" class="text-danger fs-7">{{ errors.end }}</div>
    </div>
  </div>
</template>

<script>
import UserRepository from "@/repository/UserRepository";


export default {
  name: 'FooterMenu',
  props: ['d'],

  async created() {
    this.formData = this.d;
    this.clients = await this.userRepository.getAllClients();
    this.clients = this.clients.filter(client => client.companyName)
  },

  data() {
    return {
      formData: null,
      userRepository: new UserRepository(),
      clients: null,

      errors: {
        name: false,
        description: false,
        client: false,
        start: false,
        end: false,
      }
    }
  },

  methods: {
    resetErrors() {
      this.errors = {
        name: false,
        description: false,
        client: false,
        start: false,
        end: false,
      };
    },
    validate() {
      this.resetErrors();
      let isError = false;

      if (this.formData.name === "") {
        isError = true;
        this.errors.name = "Vul een naam in";
      }

      if (this.formData.description === "") {
        isError = true;
        this.errors.description = "Vul een beschrijving in";
      }

      if (isNaN(this.formData.client_id) || this.formData.client_id < 1) {
        isError = true;
        this.errors.client = "Selecteer een bedrijf";
      }

      if (this.formData.start === "") {
        isError = true;
        this.errors.start = "Selecteer een start datum";
      }

      if (this.formData.end === "") {
        isError = true;
        this.errors.end = "Selecteer een deadline";
      }

      return !isError;
    }
  }
}
</script>
<style scoped>


</style>