<template>
  <div class="d-flex flex-center flex-column flex-column-fluid p-10">
    <div class="mb-12">
      <img alt="Logo" src="/assets/media/logos/logo-default.svg" class="h-60px">
    </div>
    <div id="auth_wrapper" class="w-500px mw-100 bg-body rounded shadow-sm p-10 p-lg-15 mx-auto">
      <router-view/>
    </div>
    <div class="mt-5 w-400px mw-100 text-center">
      <p class="footer text-muted mb-0 mt-md-0 mt-4">Door deze applicatie te gebruiken, gaat u akkoord met onze
        <span class="text-primary">voorwaarden</span> en onze <span class="text-primary">privacybeleid </span>
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AuthLayout'
}
</script>
