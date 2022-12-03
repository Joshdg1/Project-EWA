<template>
    <div id="app">
        <NormalLayout v-if="!this.$router.resolve(this.$route.path).route.meta.isPublic"/>
        <AuthLayout v-else/>
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
    import NormalLayout from "./components/layouts/Layout";
    import AuthLayout from "./components/layouts/AuthLayout";

    export default {
        components: {NormalLayout, AuthLayout}
    }
</script>