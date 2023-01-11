<template>
  <div class="card-body py-3">
    <table class="table table-row-dashed table-row-gray-300 align-middle gs-0 gy-4">
      <thead>
      <tr class="fw-bolder text-muted">
        <th>Email</th>
        <th>Voornaam(en)</th>
        <th>Achternaam</th>
        <th>Telefoonnummer</th>
        <th>Vaardigheden</th>
        <th>
          <a v-if="this.programmers.length > 0"
             class="float-end btn btn-icon btn-bg-light btn-active-color-primary btn-sm me-1"
             @click="editProgrammer()">
            <edit-icon></edit-icon>
          </a>
        </th>
      </tr>
      </thead>
      <tbody>
      <tr v-if="this.programmers.length === 0">
        <td class="text-center text-muted fs-4 p-10" colspan="6">
          Geen resultaten
        </td>
      </tr>
      <tr v-else v-for="programmer in this.programmers" v-bind:key="programmer.id">
        <td>{{ programmer.email }}</td>
        <td>{{ programmer.firstName }}</td>
        <td>{{ programmer.lastName }}</td>
        <td>{{ programmer.phoneNumber }}</td>
        <td v-html="renderSkills(programmer.skills)"></td>
        <td>
          <a class="float-end btn btn-icon btn-bg-light btn-active-color-primary btn-sm"
             @click="deleteProgrammer(programmer)">
            <delete-icon></delete-icon>
          </a>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>

import UserRepository from '../../../repository/UserRepository'
import EditIcon from "../../icons/edit";
import DeleteIcon from "../../icons/delete";

export default {
  components: {DeleteIcon, EditIcon},
  name: "ProgrammerAdmin.vue",
  props: ['programmers'],
  emits: ['editProgrammer', 'loadProgrammers'],

  data() {
    return {
      repository: new UserRepository(),
    }
  },
  methods: {
    renderSkills(skills) {
      if (!skills || skills.length === 0)
        return "";

      let content = `<div class="symbol-group symbol-hover flex-nowrap">`;
      for (const skill of skills) {
        content += `<div title="${skill.name}" class="symbol symbol-35px symbol-circle" data-bs-toggle="tooltip"
      data-bs-original-title="Susan Redwood" data-kt-initialized="1">
              <span class="symbol-label bg-primary text-inverse-primary fw-bold">${(skill.name[0]).toUpperCase()}</span>
              </div>`;
      }
      content += `</div>`;


      return content
    },

    async deleteProgrammer(progarmmer) {
      await this.$swal({
        title: "Wil je deze programmeur verwijderen?", text: "Weet je het zeker?",
        type: "warning", showCancelButton: true, confirmButtonColor: "#3085d6",
        confirmButtonText: "Ja, verwijder!", cancelButtonText: "Annuleer"
      }).then((result) => {
        if (result.value) {
          this.postDeleteProgrammer(progarmmer);
        }
      });
    },

    async postDeleteProgrammer(programmer){
      await this.repository.deleteUserById(programmer.id);
      this.$emit('editProgrammer', false)
    },

    editProgrammer() {
      this.$emit('editProgrammer', true)
    },
  }
}
</script>
