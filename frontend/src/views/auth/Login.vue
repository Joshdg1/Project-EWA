<template>
    <form class="form w-100" @submit="checkForm">
        <div class="text-center mb-10">
            <h1 class="text-dark mb-3">Login bij Florijn</h1>
        </div>

        <div v-if="errors.length">
            <b>Corrigeer de volgende fout(en):</b>
            <ul>
                <li v-for="error in errors" v-bind:key="error">{{ error }}</li>
            </ul>
        </div>

        <div class="fv-row mb-10 fv-plugins-icon-container">
            <label class="form-label fs-6 fw-bold text-dark">Email</label>
            <input class="form-control form-control-lg form-control-solid" v-model="email" type="email" name="email"
                   autocomplete="off">
            <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>
        <div class="fv-row mb-10 fv-plugins-icon-container">
            <div class="d-flex flex-stack mb-2">
                <label class="form-label fw-bold text-dark fs-6 mb-0">Wachtwoord</label>
                <router-link to="/users/ForgotPassword" class="link-primary fs-6 fw-bold">Wachtwoord vergeten?</router-link>
            </div>
            <input class="form-control form-control-lg form-control-solid" v-model="password" type="password"
                   name="password" autocomplete="off">
            <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>
        <div class="text-center">
            <button type="submit" @click="login()" class="btn btn-lg btn-primary w-100 mb-5">
                <span class="indicator-label">Login</span>
                <span class="indicator-progress">Wacht alsjeblieft...
									<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
            </button>
        </div>
    </form>
</template>

<script>
import UserRepository from "@/repository/UserRepository";
    export default {
        // eslint-disable-next-line
        name: "Login",
        data() {
            return {
                userRepository: new UserRepository(),
                errors: [],
                email: null,
                password: null,
            }
        },
        methods: {
            checkForm: function (e) {
                e.preventDefault();

                this.errors = [];

                if (!this.email) {
                    this.errors.push('Email required.');
                }
                if (!this.password) {
                    this.errors.push('Password required.');
                }


            },
          async login() {
            this.userRepository.loginUser(this.email, this.password).then((response) => {
              // if response status 500, then user does not exist
              if (response.status === 400) {
                this.errors = []
                this.errors.push("Username or password is incorrect");
              } else {
                sessionStorage.setItem("id", response.user["id"],)
                sessionStorage.user = JSON.stringify({
                  id: response.user.id,
                  firstName: response.user.firstName,
                  lastName: response.user.lastName,
                  email: response.user.email,
                  userType: response.user.userType,
                });

                console.log(response["token"])
                let token = response["token"];

                sessionStorage.setItem("token", token)

                this.$router.push("/home")
              }
            })
          }
        }

    }
</script>
