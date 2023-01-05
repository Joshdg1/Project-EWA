<!--<template>-->
<!--  <form class="form w-100" @submit="checkForm">-->
<!--    <div class="text-center mb-10">-->
<!--      <h1 class="text-dark mb-3">Wachtwoord vergeten?</h1>-->

<!--      <router-link to="/users/register" class="link-primary fw-bold">Vul hier je nieuw wachtwoord in</router-link>-->
<!--    </div>-->

<!--    <div class="fv-row mb-10 fv-plugins-icon-container">-->
<!--      <label class="form-label fs-6 fw-bold text-dark">Wachtwoord</label>-->
<!--      <input class="form-control form-control-lg form-control-solid" id="password" v-model="password" type="password" name="password"-->
<!--             autocomplete="off">-->
<!--      <div class="fv-plugins-message-container invalid-feedback"></div>-->
<!--    </div>-->
<!--    <div class="fv-row mb-10 fv-plugins-icon-container">-->
<!--      <div class="d-flex flex-stack mb-2">-->
<!--        <label class="form-label fw-bold text-dark fs-6 mb-0">Wachtwoord herhalen</label>-->
<!--      </div>-->
<!--      <input class="form-control form-control-lg form-control-solid" id="passwordRepeat" v-model="passwordRepeat" type="password"-->
<!--             name="password" autocomplete="off">-->
<!--      <div class="fv-plugins-message-container invalid-feedback"></div>-->
<!--    </div>-->
<!--    <div class="text-center">-->
<!--      <button type="submit" @click="login()" class="btn btn-lg btn-primary w-100 mb-5">-->
<!--        <span class="indicator-label">Verander</span>-->
<!--        <span class="indicator-progress">Wacht alsjeblieft...-->
<!--									<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>-->
<!--      </button>-->
<!--    </div>-->
<!--  </form>-->
<!--</template>-->

<!--<script>-->
<!--export default {-->
<!--  name: "resetPassword"-->
<!--}-->
<!--// function isEmpty(str){-->
<!--//   return (!str || 0 === str.trim().length);-->
<!--// }-->
<!--// function saveNewPassword(){-->
<!--//   var urlParams = new URLSearchParams(location.search);-->
<!--//-->
<!--//   if (!urlParams.has('token') || isEmpty(urlParams.get("token"))){-->
<!--//     alert("Missing token")-->
<!--//   }-->
<!--//-->
<!--//   var tokenValue = urlParams.get('token');-->
<!--//   var password = document.getElementById("password").value;-->
<!--//   var passwordRepeat = document.getElementById("passwordRepeat").value;-->
<!--//-->
<!--//   if (isEmpty(password)){alert("Wachtwoord mag niet leeg zijn")-->
<!--//   }-->
<!--//   if (isEmpty(passwordRepeat)){-->
<!--//     alert("Wachtwoord herhaal mag niet leeg zijn")-->
<!--//   }-->
<!--//-->
<!--//   if (password !== passwordRepeat){-->
<!--//     alert("Wachtwoorden komen niet overeen")-->
<!--//   }-->
<!--//-->
<!--// }-->
<!--</script>-->

<!--<style scoped>-->

<!--</style>-->