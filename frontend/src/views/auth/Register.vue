<template>
    <form class="form w-100" @submit="checkForm">
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
            <input class="form-control form-control-lg form-control-solid" v-model="email" type="email" name="email"
                   autocomplete="off">
            <div class="fv-plugins-message-container invalid-feedback"></div>
        </div>
        <div class="fv-row mb-10 fv-plugins-icon-container">
            <div class="d-flex flex-stack mb-2">
                <label class="form-label fw-bold text-dark fs-6 mb-0">Password</label>
            </div>
            <input class="form-control form-control-lg form-control-solid" v-model="password" type="password" name="password">
        </div>
        <div class="text-center">
            <button type="submit" id="kt_sign_in_submit" class="btn btn-lg btn-primary w-100 mb-5">
                <span class="indicator-label">Register</span>
                <span class="indicator-progress">Please wait...
									<span class="spinner-border spinner-border-sm align-middle ms-2"></span></span>
            </button>

        </div>
    </form>
</template>

<script>
    export default {
        // eslint-disable-next-line
        name: "Register",
        data() {
            return {
                errors: [],
                email: null,
                password: null,
            }
        },
        methods: {
            checkForm: function (e) {
                e.preventDefault();

                if (this.email && this.password) {
                  alert('Todo: register')
                    return true;
                }

                this.errors = [];

                if (!this.email) {
                    this.errors.push('Email required.');
                }
                if (!this.password) {
                    this.errors.push('Password required.');
                }
            }
        }
    }
</script>

