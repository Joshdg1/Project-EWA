<template>
  <div>
    <h1 class="ms-8 mb-5">
      Welkom {{ this.user.firstName }} {{ this.user.lastName }}
    </h1>
    <div class="row">
      <div class="col-lg-12">
        <div class="card card-xl-stretch mb-5 mb-xl-8">
          <div class="card-header border-0 pt-5">
            <div v-if="this.user.userType === 'programmer'">
              <br>
              <p>Je bevindt je momenteel op de homepagina van een specialist!</p>
              <br>
              <h3>Inzien en beheren</h3>
              <p>Als specialist kan je je eigen
                <router-link to="/projects" class="link-primary fs-6 fw-bold">projecten</router-link> inzien.
              </p>
              <br>
              <h3>Profiel</h3>
              <p>Als specialist heb je ook je eigen
                <router-link to="/profile/view" class="link-primary fs-6 fw-bold">profiel</router-link> dat je kan bewerken.
                Hier kan je ook je vaardigheden en urenregistratie inzien, aanmaken of verwijderen.
              </p>
              <br>
              <br>
              <br>
              <p class="mb-10">Wij als Florijn hopen dat u een fijne ervaring zult beleven op onze website!</p>
            </div>
            <div v-else-if="this.user.userType === 'client'">
              <br>
              <p>Je bevindt je momenteel op de homepagina van een client!</p>
              <br>
              <h3>Projecten inzien</h3>
              <p>Als client kan je je eigen
                <router-link to="/projects" class="link-primary fs-6 fw-bold">projecten</router-link> inzien.
              </p>
              <br>
              <h3>Profiel</h3>
              <p>Als client heb je ook je eigen
                <router-link to="/profile/view" class="link-primary fs-6 fw-bold">profiel</router-link> dat je kan bewerken.
              </p>
              <br>
              <br>
              <br>
              <p class="mb-10">Wij als Florijn hopen dat u een fijne ervaring zult beleven op onze website!</p>
            </div>
            <div v-else-if="this.user.userType === 'administrator'">
              <br>
              <p>Je bevindt je momenteel op de homepagina van een admin!</p>
              <br>
              <h3>Inzien en beheren</h3>
              <p>Als admin kan je de
                <router-link to="/projects" class="link-primary fs-6 fw-bold">projecten</router-link>,
                <router-link to="/clients" class="link-primary fs-6 fw-bold">clienten</router-link> en
                <router-link to="/programmers" class="link-primary fs-6 fw-bold">specialisten</router-link> inzien en beheren.
              </p>
              <br>
              <h3>Aanmaken</h3>
              <p>Als admin is het ook mogelijk om nieuwe
                <router-link to="/projects/create" class="link-primary fs-6 fw-bold">projecten</router-link>,
                <router-link to="/clients/create" class="link-primary fs-6 fw-bold">clienten</router-link> en
                <router-link to="/programmers/create" class="link-primary fs-6 fw-bold">specialisten</router-link> aan te maken.
              </p>
              <br>
              <h3>Profiel</h3>
              <p>Als admin heb je ook je eigen
                <router-link to="/profile/view" class="link-primary fs-6 fw-bold">profiel</router-link> dat je kan bewerken.
              </p>
              <br>
              <br>
              <br>
              <p class="mb-10">Wij als Florijn hopen dat u een fijne ervaring zult beleven op onze website!</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  // eslint-disable-next-line
  name: "Home",
  created() {
    this.user = sessionStorage.user ? JSON.parse(sessionStorage.user) : false;
  },

  data() {
    return {
      user: null,
    }
  }
}


</script>
