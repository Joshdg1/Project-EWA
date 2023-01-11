<template>
    <div>
        <div class="card">
            <div class="card-body">
              <div class="mb-5">
                <div class="notice d-flex bg-light-primary rounded border-primary border border-dashed p-6">
                  <div class="d-flex flex-stack flex-grow-1">
                    <div class="fw-semibold">
                      <div class="fs-6 text-gray-700">Na het opslaan van de specialist wordt er automatisch een email verstuurd naar het ingevulde adres. Via deze email krijgt de specialist de mogelijkheid om een wachtwoord in te stellen.</div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="mb-5">
                <label class="form-label mb-3">Email adres</label>
                <input type="email" class="form-control" v-model="formData.email" placeholder="example@example.com">
                <div v-if="errors.email" class="text-danger fs-7">{{ errors.email }}</div>
              </div>
              <div class="mb-5">
                <label class="form-label mb-3">Voornaam(en)</label>
                <input type="text" class="form-control" v-model="formData.firstname">
                <div v-if="errors.firstname" class="text-danger fs-7">{{ errors.firstname }}</div>
              </div>
              <div class="mb-5">
                <label class="form-label mb-3">Achternaam</label>
                <input type="text" class="form-control" v-model="formData.lastname">
                <div v-if="errors.lastname" class="text-danger fs-7">{{ errors.lastname }}</div>
              </div>
              <div class="mb-5">
                <label class="form-label mb-3">Telefoonnummer</label>
                <input type="text" class="form-control" v-model="formData.phoneNumber">
                <div v-if="errors.phoneNumber" class="text-danger fs-7">{{ errors.phoneNumber }}</div>
              </div>
            </div>
          <div class="card-footer">
            <div class="d-flex flex-stack">
              <div class="mr-2">
                <router-link to="/programmers" type="button" class="btn btn-lg btn-light-primary">
                  <back-icon></back-icon>Terug
                </router-link>
              </div>
              <div>
                <button class="btn btn-primary" @click="createProgrammer">Aanmaken</button>
              </div>
            </div>
          </div>
        </div>
    </div>
</template>

<script>
    import UserRepository from '../../../repository/UserRepository'
    import BackIcon from "../../../components/icons/back";


    export default {
      // eslint-disable-next-line
      name: "CreateProgrammerProjectView",
      components: {BackIcon},
      data() {
        return {
          UserRepository: new UserRepository(),
          errors: {
            email: false,
            firstname: false,
            lastname: false,
            phoneNumber: false,
          },
          formData: {
            email: "",
            firstname: "",
            lastname: "",
            phoneNumber: "",
          },
        }
      },

      methods: {
        resetErrors() {
          this.errors = {
            email: false,
            firstname: false,
            lastname: false,
            phoneNumber: false,
          };
        },

        validate(){
          this.resetErrors();
          let isError = false;

          if (this.formData.email === "" || !this.formData.email.includes('@')) {
            isError = true;
            this.errors.email = "Vul een email adres in";
          }

          if (this.formData.firstname === "") {
            isError = true;
            this.errors.firstname = "Vul een voornaam in";
          }

          if (this.formData.lastname === "") {
            isError = true;
            this.errors.lastname = "Vul een achternaam in";
          }

          if (this.formData.phoneNumber === "") {
            isError = true;
            this.errors.phoneNumber = "Vul een telefoonnummer in";
          }

          return !isError;
        },

        async createProgrammer() {
          if (!this.validate())
            return;

          const usertype = "programmer";

          await this.UserRepository.createUser(this.formData.email, this.formData.firstname, this.formData.lastname, false, this.formData.phoneNumber, '', usertype);

          this.$toasted.show("Specialist aangemaakt", {
            theme: "bubble",
            position: "bottom-right",
            duration : 1000
          });
          this.$router.push("/programmers", );
        },
      }
    }
</script>

<style scoped>
    .descriptionHeight {
        height: auto;
    }

    .form-control.form-control-solid {
        background-color: lightgray;
        border-color: #F5F8FA;
        color: #5E6278;
        transition: color 0.2s ease, background-color 0.2s ease;
    }
</style>
