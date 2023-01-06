<template>
    <div>
        <h4>Selecteer sepecialist(en)</h4>
        <programmer-select @on-select="onSelect"></programmer-select>
    </div>
</template>

<script>
    import ProgrammerSelect from "../../tables/ProgrammerSelect";

    export default {
        components: {
            ProgrammerSelect
        },

        emits: ['on-select'],
        name: 'FooterMenu',

        methods: {
            onSelect(ids){
                this.$emit('on-select', ids);
            }
        }
    }
</script>

<style scoped>

</style>