<template>
  <table>
    <tr>
      <th>Firstname</th>
      <th>Lastname</th>
      <th>Address</th>
      <th>City</th>
      <th>Knowledge</th>
      <th>Experience</th>
      <th>Availability</th>
      <th>Weekly work hours</th>
      <th>Work space</th>
      <th>Project types</th>
    </tr>
    <tbody>
    <tr v-for="programmer in programmers" v-bind:key="programmer">
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
    </tr>
    </tbody>
  </table>
  <button>Create</button>
  <button>Delete</button>
</template>

<script>
export default {
  name: "ProgrammerManagement.vue",

  data() {
    return {
      programmers: []
    }
  },
  methods: {
    fillProgrammerArray() {
      this.programmers.push()

    },
  }
}
</script>

<style scoped>

</style>