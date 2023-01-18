<template>
  <div>
    <div class="card">
      <div class="card-body">
        <step1 :d="formData" ref="step1" v-if="step === 0"></step1>
        <step2 @on-select="onStep2Select" v-if="step === 1"></step2>
      </div>
      <div class="card-footer">
        <div class="d-flex flex-stack">
          <div class="mr-2">
            <button @click="back" type="button" class="btn btn-lg btn-light-primary me-3" data-kt-stepper-action="previous">
              <back-icon></back-icon>Terug
            </button>
          </div>
          <div>
            <button @click="submit" v-if="canSubmit" type="button" class="btn btn-lg btn-primary me-3">
              Opslaan<next-icon></next-icon>
            </button>
            <button @click="next" v-if="canNext" id="next" type="button" class="btn btn-lg btn-primary">
              Volgende<next-icon></next-icon>
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
  import BackIcon from "../../../components/icons/back";
  import NextIcon from "../../../components/icons/next";

  export default {
    components: {
      NextIcon,
      BackIcon,
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
        this.$toasted.show("Project aangemaakt", {
          theme: "bubble",
          position: "bottom-right",
          duration : 5000
        });
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
