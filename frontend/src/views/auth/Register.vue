<template>
    <form class="form w-100">
        <div class="text-center mb-10">
            <h1 class="text-dark mb-3">Register to Florijn</h1>
            <div class="text-gray-400 fw-semibold fs-4">Already have an account?
                <router-link to="/login" class="link-primary fw-bold">Login</router-link>
            </div>
        </div>

        <div v-if="errors.length">
            <b>Please correct the following error(s):</b>
            <ul>
                <li v-for="error in errors" v-bind:key="error">{{ error }}</li>
            </ul>
        </div>

        <div class="fv-row mb-10 fv-plugins-icon-container">
            <label class="form-label fs-6 fw-bold text-dark">Email</label>
            <input id="email" class="form-control form-control-lg form-control-solid" v-model="email" type="email" name="email"
                   autocomplete="off">
            <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">First Name</label>
        <input id="firstName" class="form-control form-control-lg form-control-solid" v-model="first_name" type="text" name="First name"
               autocomplete="off">
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Last Name</label>
        <input id="lastName" class="form-control form-control-lg form-control-solid" v-model="last_name"  type="text" name="Last name"
               autocomplete="off">
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Password</label>
        <input id="password" class="form-control form-control-lg form-control-solid"  v-model="password"  type="text" name="Password"
               autocomplete="off">
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">Phone Number</label>
        <input id="phoneNumber" class="form-control form-control-lg form-control-solid"  v-model="phoneNumber"  type="text" name="Phone number"
               autocomplete="off">
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>

      <div class="fv-row mb-10 fv-plugins-icon-container">
        <label class="form-label fs-6 fw-bold text-dark">User type</label>
        <input id="userType" class="form-control form-control-lg form-control-solid"  v-model="userType" type="text" name="User type"
               autocomplete="off">
        <div class="fv-plugins-message-container invalid-feedback"></div>
      </div>


        <div class="text-center">
            <button type="submit" @click="saveUser()" id="kt_sign_in_submit" class="btn btn-lg btn-primary w-100 mb-5">
                <span class="indicator-label">Register</span>
                <span class="indicator-progress">Please wait...
									<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
            </button>

        </div>
    </form>
</template>

<script>
import UserRepository from "@/repository/UserRepository";

    export default {
        // eslint-disable-next-line
        name: "Register",
        data() {
            return {
              userRepository: new UserRepository(),
                errors: [],
                email: '',
                first_name: '',
                last_name: '',
                password: null,
                phoneNumber: '',
                userType: '',
            }
        },
        methods: {
           async saveUser(){
              await this.userRepository.createProgrammers(this.email, this.first_name, this.last_name,
                  this.password, this.phoneNumber, this.userType)
          }
        }
    }
</script>

