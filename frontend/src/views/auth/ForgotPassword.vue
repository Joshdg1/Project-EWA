<template>
  <form class="form w-100" @submit="checkForm">
    <div class="text-center mb-10">
      <h1 class="text-dark mb-3">Wachtwoord vergeten?</h1>

      <h2 class="link-primary fw-bold">Vul hier je email in</h2>
    </div>

    <div v-if="errors.length">
      <b>Corrigeer de volgende fout(en):</b>
      <ul>
        <li v-for="error in errors" v-bind:key="error">{{ error }}</li>
      </ul>
    </div>
    <div class="fv-row mb-10 fv-plugins-icon-container">
      <label class="form-label fs-6 fw-bold text-dark">Email</label>
      <input class="form-control form-control-lg form-control-solid" id="email" v-model="email" type="email"
             name="email"
             autocomplete="off">
      <div class="fv-plugins-message-container invalid-feedback"></div>
    </div>
    <div class="text-center">
      <button id="send" type="submit" @click="sendEmailFunction()" class="btn btn-lg btn-primary w-100 mb-5">
        <span class="indicator-label">Stuur email</span>
        <span class="indicator-progress">Wacht alsjeblieft...
									<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
      </button>

      <router-link to="/users/login" class="link-primary fs-6 fw-bold">Terug naar login</router-link>
    </div>

  </form>
</template>

<script>
import UserRepository from "@/repository/UserRepository";

export default {
  name: "ForgotPassword",
  data() {
    return {
      userRepository: new UserRepository(),
      email: null,
      errors: []
    }
  },
  methods: {
    async sendEmailFunction() {
      await this.userRepository.sendEmail(this.email);
      alert("email is verstuurt")
      await this.$router.push("/")
    },
    checkForm: function (e) {
      e.preventDefault();

      this.errors = [];

      if (!this.email) {
        this.errors.push('Email invoeren is verplicht');
      }
    }
  }
}

</script>

<style scoped>

</style>