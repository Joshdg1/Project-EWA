<template>
  <div>
    <div class="mb-5">
      <label class="form-label mb-3">Naam</label>
      <input type="text" class="form-control form-control-lg form-control-solid" v-model="formData.name" placeholder=""
             value="">
      <div v-if="errors.name" class="text-danger fs-7">{{ errors.name }}</div>
    </div>
    <div class="mb-5">
      <label class="form-label mb-3">Beschrijving</label>
      <textarea class="form-control form-control-lg form-control-solid" v-model="formData.description" placeholder=""
                value="">
            </textarea>
      <div v-if="errors.description" class="text-danger fs-7">{{ errors.description }}</div>
    </div>
    <div class="mb-5">
      <label class="form-label mb-3">Bedrijf</label>
      <table><td v-html="setCompanySelectbox">
      </td></table>
      <!--            <input type="number" class="form-control form-control-lg form-control-solid" v-model="formData.client_id" placeholder="" value="1">-->
      <!--            <div v-if="errors.client" class="text-danger fs-7">{{errors.client}}</div>-->
    </div>
    <div class="mb-5">
      <label class="form-label mb-3">Start Datum</label>
      <input type="date" class="form-control form-control-lg form-control-solid" v-model="formData.start" placeholder=""
             value="">
      <div v-if="errors.start" class="text-danger fs-7">{{ errors.start }}</div>
    </div>
    <div class="mb-5">
      <label class="form-label mb-3">Deadline</label>
      <input type="date" class="form-control form-control-lg form-control-solid" v-model="formData.end" placeholder=""
             value="">
      <div v-if="errors.end" class="text-danger fs-7">{{ errors.end }}</div>
    </div>
  </div>
</template>

<script>
import Multiselect from 'vue-multiselect';
import UserRepository from "@/repository/UserRepository";


export default {
  // eslint-disable-next-line vue/no-unused-components
  components: {Multiselect},
  name: 'FooterMenu',
  props: ['d'],

  created() {
    this.formData = this.d;
  },

  data() {
    return {
      formData: null,
      errors: {
        name: false,
        description: false,
        client: false,
        start: false,
        end: false,
        UserRepository: new UserRepository(),
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
    async setCompanySelectbox(){
      let companies = await this.UserRepository.getAllCompanies();
      console.log(companies)
      let content = `<multiselect class="optionCompany" :searchable="true"
                    :close-on-select="true"
                    :show-labels="false">`;
      // eslint-disable-next-line no-unused-vars
      for (const company of companies) {
        content += `<options>company</options>`
      }
      content += `</multiselect>`;


      return content
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
<style src="vue-multiselect/dist/vue-multiselect.min.css"></style>
<style scoped>


</style>