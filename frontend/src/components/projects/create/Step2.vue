<template>
    <div>
        <div class="mb-5">
            <div class="notice d-flex bg-light-primary rounded border-primary border border-dashed p-6">
                <div class="d-flex flex-stack flex-grow-1">
                    <div class="fw-semibold">
                        <div class="fs-6 text-gray-700">Selecteer sepecialist(en)</div>
                    </div>
                </div>
            </div>
        </div>
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