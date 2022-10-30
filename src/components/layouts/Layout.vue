<template>
    <div>
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

<script>
    import HeaderMenu from "../HeaderMenu";
    import FooterMenu from "../FooterMenu";
    import AsideMenu from "../AsideMenu";

    export default {
        name: 'NormalLayout',
        components: {AsideMenu, FooterMenu, HeaderMenu}
    }
</script>
