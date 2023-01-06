<template>
  <div>
    <div class="card">
      <div class="card-header">

      </div>
      <div class="card-body">
        <step1 :d="formData" ref="step1" v-if="step === 0"></step1>
        <step2 @on-select="onStep2Select" v-if="step === 1"></step2>
      </div>
      <div class="card-footer">
        <div class="d-flex flex-stack">
          <div class="mr-2">
            <button @click="back" type="button" class="btn btn-lg btn-light-primary me-3" data-kt-stepper-action="previous">
              <span class="svg-icon svg-icon-4 me-1">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <rect opacity="0.5" x="6" y="11" width="13" height="2" rx="1" fill="currentColor"></rect>
                  <path d="M8.56569 11.4343L12.75 7.25C13.1642 6.83579 13.1642 6.16421 12.75 5.75C12.3358 5.33579 11.6642 5.33579 11.25 5.75L5.70711 11.2929C5.31658 11.6834 5.31658 12.3166 5.70711 12.7071L11.25 18.25C11.6642 18.6642 12.3358 18.6642 12.75 18.25C13.1642 17.8358 13.1642 17.1642 12.75 16.75L8.56569 12.5657C8.25327 12.2533 8.25327 11.7467 8.56569 11.4343Z" fill="currentColor"></path>
                </svg>
              </span>
              Terug</button>
          </div>
          <div>
            <button @click="submit" v-if="canSubmit" type="button" class="btn btn-lg btn-primary me-3" data-kt-indicator="true" data-kt-stepper-action="submit">
              <span class="indicator-label">Opslaan
                <span class="svg-icon svg-icon-3 ms-2 me-0">
                  <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <rect opacity="0.5" x="18" y="13" width="13" height="2" rx="1" transform="rotate(-180 18 13)" fill="currentColor"></rect>
                    <path d="M15.4343 12.5657L11.25 16.75C10.8358 17.1642 10.8358 17.8358 11.25 18.25C11.6642 18.6642 12.3358 18.6642 12.75 18.25L18.2929 12.7071C18.6834 12.3166 18.6834 11.6834 18.2929 11.2929L12.75 5.75C12.3358 5.33579 11.6642 5.33579 11.25 5.75C10.8358 6.16421 10.8358 6.83579 11.25 7.25L15.4343 11.4343C15.7467 11.7467 15.7467 12.2533 15.4343 12.5657Z" fill="currentColor"></path>
                  </svg>
                </span>
               </span>
            </button>
            <button @click="next" v-if="canNext" type="button" class="btn btn-lg btn-primary" data-kt-stepper-action="next">Volgende
              <span class="svg-icon svg-icon-4 ms-1 me-0">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <rect opacity="0.5" x="18" y="13" width="13" height="2" rx="1" transform="rotate(-180 18 13)" fill="currentColor"></rect>
                  <path d="M15.4343 12.5657L11.25 16.75C10.8358 17.1642 10.8358 17.8358 11.25 18.25C11.6642 18.6642 12.3358 18.6642 12.75 18.25L18.2929 12.7071C18.6834 12.3166 18.6834 11.6834 18.2929 11.2929L12.75 5.75C12.3358 5.33579 11.6642 5.33579 11.25 5.75C10.8358 6.16421 10.8358 6.83579 11.25 7.25L15.4343 11.4343C15.7467 11.7467 15.7467 12.2533 15.4343 12.5657Z" fill="currentColor"></path>
                </svg>
              </span>
              </button>
          </div>
        </div>
      </div>
    </div>
    </div>
</template>

<script>
  import Step1 from "../../../components/projects/create/Step1";
  import Step2 from "../../../components/projects/create/Step2";
  import ProjectRepository from "../../../repository/ProjectRepository";

  export default {
    components: {
      Step1,
      Step2
    },

    name: "CreateProjectView",

    data() {
      return {
        repository: new ProjectRepository(),

        step: 0,
        programmer_ids: [],

        formData: {
          name: "",
          description: "",
          client_id: 0,
          start: "",
          end: "",
        },

        get canNext(){
          return this.step < 1;
        },
        get canSubmit(){
          return this.step === 1 && this.programmer_ids.length > 0;
        }
      }
    },

    methods: {
      onStep2Select(ids) {
        this.programmer_ids = ids;
      },
      back() {
        if (this.step < 1) {
          this.$router.push("/projects");
        } else {
          this.step--;
        }
      },
      next() {
        if (this.step === 0){
          if (!this.$refs.step1.validate())
            return false;

          this.formData = this.$refs.step1.formData
          this.programmer_ids = [];
        }

        this.step++;
      },
      async submit() {
        const result = await this.repository.createProject(this.formData.name, this.formData.description, this.formData.client_id, this.formData.start, this.formData.end, this.programmer_ids);

        if (result){
          this.$router.push("/projects");
        } else {
          alert('err');
        }
      }
    }
  }
</script>

<style scoped>

</style>
