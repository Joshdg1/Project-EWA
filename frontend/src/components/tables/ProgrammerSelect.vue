<template>
  <div class="row">
    <div class="col-lg-12">
        <div class="table-responsive">
            <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
              <thead>
              <tr class="fw-bolder text-muted">
                <th class="w-25px"></th>
                <th>Email</th>
                <th>Voornaam(en)</th>
                <th>Achternaam</th>
              </tr>
              </thead>
              <tbody>
              <tr v-for="programmer in programmers" v-bind:key="programmer.id">
                <td>
                <div class="form-check form-check-sm form-check-custom form-check-solid">
                  <input class="form-check-input" type="checkbox" v-bind:value="programmer.id" v-model="selectedIds" @change="onSelect"/>
                </div>
                </td>
                <td>{{ programmer.email }}</td>
                <td>{{ programmer.firstName }}</td>
                <td>{{ programmer.lastName }}</td>
                <td>{{ programmer.phoneNumber }}</td>
              </tr>
              </tbody>
            </table>
        </div>
      </div>
    </div>
</template>

<script>

import UserRepository from "../../repository/UserRepository";

export default {
  name: "ProgrammerSelect.vue",
  emits: ['on-select'],

  async created() {
    this.programmers = await this.repository.getAllProgrammers();
  },

  data() {
    return {
      repository: new UserRepository(),
      programmers: null,
      selectedIds: [],
    }
  },

  methods: {
    onSelect(){
      this.$emit('on-select', this.selectedIds);
    },
  },
}
</script>
<style scoped>

</style>