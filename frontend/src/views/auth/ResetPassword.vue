<template>
  <form class="form w-100" @submit="checkForm">
    <div class="text-center mb-10">
      <h1 class="text-dark mb-3">Stel je wachtwoord opnieuw in</h1>

      <div v-if="errors.length">
        <b>Corrigeer de volgende fout(en):</b>
        <ul>
          <li v-for="error in errors" v-bind:key="error">{{ error }}</li>
        </ul>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Wachtwoord</label>
        <input class="form-control form-control-lg form-control-solid" id="password" v-model="password" type="password"
               name="password"
               autocomplete="off">
        <div v-if="errors.passwordError" class="text-danger fs-7">{{ errors.passwordError }}</div>
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Wachtwoord herhalen</label>
        <input class="form-control form-control-lg form-control-solid" id="passwordRepeat" v-model="passwordRepeat"
               type="password"
               name="password"
               autocomplete="off">
        <div v-if="errors.passwordRepeatError" class="text-danger fs-7">{{ errors.passwordRepeatError }}</div>
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>
      <div class="text-center">
        <router-link to="/users/login">
          <button type="submit" @click="changePassword()" class="btn btn-lg btn-primary w-100 mb-5">
            <span class="indicator-label">Verander</span>
            <span class="indicator-progress">Wacht alsjeblieft...
									<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
          </button>
        </router-link>
      </div>
    </div>
  </form>
</template>

<script>
import UserRepository from "@/repository/UserRepository";

export default {
  name: "resetPassword",
  data() {
    return {
      userRepository: new UserRepository(),
      password: null,
      passwordRepeat: null,
      errors: {
        passwordError: false,
        passwordRepeatError: false,
      }
    }
  },

  methods: {

    resetErrors() {
      this.errors = {
        passwordError: false,
        passwordRepeatError: false,
      };
    },

    validate() {
      this.resetErrors();
      let isError = false;

      if (this.password === "") {
        isError = true;
        this.errors.passwordError = "Voer je nieuwe wachtwoord in!";
      }

      if (this.passwordRepeat === "") {
        isError = true;
        this.errors.passwordRepeatError = "Herhaal je wachtwoord!";
      }

      else if (this.password !== this.passwordRepeat){
        isError = true;
        this.errors.passwordRepeatError = "Wachtwoorden zijn niet hetzelfde!"
      }

      return !isError;
    },
    async changePassword() {
      const queryString = window.location.search;

      const urlParams = new URLSearchParams(queryString);

      const token = urlParams.get('token')


      await this.userRepository.resetPassword(this.password, token);
    }
  }

}
</script>

<style scoped>

</style>