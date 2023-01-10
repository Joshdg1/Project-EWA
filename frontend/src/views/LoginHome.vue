<template>
  <h1>
    Welkom {{this.user.firstName}} {{this.user.lastName}}
  </h1>
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
