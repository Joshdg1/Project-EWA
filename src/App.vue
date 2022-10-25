<template>
  <div id="app">
    <AsideMenu/>
    <div class="wrapper d-flex flex-column flex-row-fluid" id="kt_wrapper">
      <HeaderMenu/>


      <div class="content d-flex flex-column flex-column-fluid" id="kt_content">
        <div class="container-xxl" id="kt_content_container">
        <router-view/>
        </div>
      </div>

      <FooterMenu/>
    </div>
  </div>
</template>

<style>

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
<script>
  import HeaderMenu from "./components/HeaderMenu";
  import FooterMenu from "./components/FooterMenu";
  import AsideMenu from "./components/AsideMenu";

  export default {
    components: {AsideMenu, FooterMenu, HeaderMenu}
  }
</script>