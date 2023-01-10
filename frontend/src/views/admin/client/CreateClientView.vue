<template>
  <div>
    <form>
      <div class="text-center mb-10">
        <h1 class="text-dark mb-3">Creëer een cliënt</h1>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <div class="d-flex flex-stack mb-2">
          <label class="form-label fw-bold text-dark fs-6 mb-0">Email</label>
        </div>
        <input class="form-control form-control-lg form-control-solid" type="text"
               name="Email" autocomplete="off" v-model="email">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Voornaam(en)</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="firstname">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Achternaam</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="lastname">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Wachtwoord</label>
        <input class="form-control form-control-lg form-control-solid" type="password" name="text"
               autocomplete="off" v-model="password">
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Telefoonnummer</label>
        <input class="form-control form-control-lg form-control-solid" type="text" name="text"
               autocomplete="off" v-model="phoneNumber">
      </div>

    </form>

    <div class="d-flex flex-shrink-0">
      <div class="d-flex ms-3">
        <router-link to="/projects" class="btn bg-primary btn-active-info">
          Annuleer
        </router-link>
      </div>
      <div class="d-flex ms-3">
        <button class="btn bg-primary btn-active-info" @click="createClient">Creëer</button>
      </div>
    </div>
  </div>
</template>

<script>
import UserRepository from '../../../repository/UserRepository'

export default {
  // eslint-disable-next-line
  name: "CreateClientProjectView",

  data() {
    return {
      UserRepository: new UserRepository(),
    }
  },

  methods: {
    async createClient() {
      const usertype = "client";

      await this.UserRepository.createUser(this.email, this.firstname, this.lastname, this.password, this.phoneNumber, usertype);

      this.$router.push("/clients");
    },
  }
}
</script>

<style scoped>
.descriptionHeight {
  height: auto;
}

.form-control.form-control-solid {
  background-color: lightgray;
  border-color: #F5F8FA;
  color: #5E6278;
  transition: color 0.2s ease, background-color 0.2s ease;
}
</style>
