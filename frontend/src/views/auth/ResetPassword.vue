<template>
    <div class="text-center">
      <h1 class="text-dark mb-5">Stel je wachtwoord opnieuw in</h1>

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
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>
      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Wachtwoord herhalen</label>
        <input class="form-control form-control-lg form-control-solid" id="passwordRepeat" v-model="passwordRepeat"
               type="password"
               name="password"
               autocomplete="off">
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>
      <div class="text-center">
        <button type="submit" @click="changePassword()" class="btn btn-lg btn-primary w-100 mb-5">
          Verander
        </button>
      </div>
    </div>
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
      errors: []
    }
  },
  methods: {
    checkForm: function () {
      this.errors = [];

      if (!this.password) {
        this.errors.push('Wachtwoord invoeren is verplicht');
      }
      if (!this.passwordRepeat) {
        this.errors.push('Wachtwoord herhalen is verplicht');
      }
      if (this.password !== this.passwordRepeat) {
        this.errors.push('Wachtwoord en herhaal wachtwoord zijn niet hetzelfde')
      }

      return this.errors.length === 0;
    },
    async changePassword(){
      console.log('check');
      if (this.checkForm()) {
        const queryString = this.$route.query.token

        await this.userRepository.resetPassword(this.password, queryString);
        this.$router.push("/users/login")
      }
    }
  }

}
</script>

<style scoped>

</style>