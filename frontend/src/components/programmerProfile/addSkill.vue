<template>
  <div class="modal-dialog mw-650px">
    <!--begin::Modal content-->
    <div class="modal-content">
      <!--begin::Modal header-->
      <div class="modal-header pb-0 border-0 justify-content-end">
        <!--begin::Close-->
        <div class="btn btn-sm btn-icon btn-active-color-primary" data-bs-dismiss="modal">
          <!--begin::Svg Icon | path: icons/duotune/arrows/arr061.svg-->
          <span class="svg-icon svg-icon-1" @click="closePopup">
								<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none">
									<rect opacity="0.5" x="6" y="17.3137" width="16" height="2" rx="1" transform="rotate(-45 6 17.3137)" fill="black" />
									<rect x="7.41422" y="6" width="16" height="2" rx="1" transform="rotate(45 7.41422 6)" fill="black" />
								</svg>
							</span>
          <!--end::Svg Icon-->
        </div>
        <!--end::Close-->
      </div>
      <!--begin::Modal header-->
      <!--begin::Modal body-->
      <div class="modal-body scroll-y mx-5 mx-xl-18 pt-0 pb-15">
        <!--begin::Heading-->
        <div class="text-center mb-13">
          <!--begin::Title-->
          <h1 class="mb-3">Add a skill</h1>
          <!--end::Title-->
        </div>
        <!--end::Heading-->
        <div>
          <label class="typo__label">Single select</label>
          <multiselect v-model="value" :options="skills" :searchable="false" :close-on-select="false" :show-labels="false" placeholder="Pick a value"></multiselect>
          <pre class="language-json"><code>{{ value  }}</code></pre>
        </div>
        <!--begin::Textarea-->
        <!--end::Textarea-->
      </div>
      <!--end::Modal body-->
    </div>
  </div>

</template>

<script>
import Multiselect from 'vue-multiselect';
import SkillRepository from "@/repository/SkillRepository";
export default {
  components: {Multiselect},
  name: "addSkill",
  emits: ['close-popup'],
  data() {
    return {
      popupStatus: null,
      skills: [],
      repository: new SkillRepository(),
      value: null,
    }
  },
  async created() {
    const data = await this.repository.getAllSkills();

    for (let i = 0; i < data.length; i++) {
      this.skills.push(data[i]);
    }
  },
  methods: {
    closePopup(){
      this.popupStatus = false;
      this.$emit('close-popup', this.popupStatus)
    },
    addSkill(skill) {
      this.$emit('add-skill',skill)

    }
  }
}
</script>

<style scoped>

</style>