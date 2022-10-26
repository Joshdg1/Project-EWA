import Vue from 'vue'
import VueRouter from 'vue-router'

// General
import ProgrammerPage from '../views/programmer/Home.vue'

import Home from '../views/Home.vue'

// Programmer
import ProgrammerEdit from "../views/programmer/Edit.vue";
import ProgrammerHome from "../views/programmer/Home.vue";

// Client
import ClientHomePage from "../views/client/Home.vue"

// Admin
import AdminProgrammerView from "../views/admin/programmer/View.vue";
import AdminProjectView from "../views/admin/project/ProjectAdminView.vue";
import AdminClientView from "../views/admin/client/ClientAdminView.vue";
import HomeAdmin from "@/views/admin/HomeAdmin";
import Login from "@/login/Login";
import Register from "@/login/Register";

Vue.use(VueRouter)

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: Login
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/programmerProfile',
        name: 'ProgrammerProfile',
        component: ProgrammerEdit
    },
    {
        path: '/programmerHomePage',
        name: 'programmerHomePage',
        component: ProgrammerPage
    },
    {
        path: '/',
        name: 'HomeAdmin',
        component: HomeAdmin
    },
    {
        path: '/adminClient',
        name: 'ProjectAdminView',
        component: AdminClientView
    },
    {
        path: '/adminProject',
        name: 'ProjectAdminView',
        component: AdminProjectView
    },
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/adminProgrammer',
        name: 'AdminHome',
        component: AdminProgrammerView,
        children: [
            {
                path: 'programmer',
                name: 'AdminProgrammerHome',
                children: [
                    {
                        path: 'view',
                        name: 'AdminProgrammerView',
                        component: AdminProgrammerView,
                    }
                ]
            },
        ]
    },
    {
        path: '/programmer',
        name: 'ProgrammerHome',
        component: ProgrammerHome,
        children: [
            {
                path: '/edit',
                name: 'ProgrammerEdit',
                component: ProgrammerEdit,
            },
        ]
    },
    {
        path: '/ClientHomePage',
        name: 'ClientHomePage',
        component: ClientHomePage
    },
]

const router = new VueRouter({
    mode: 'history',
    // eslint-disable-next-line no-undef
    base: process.env.BASE_URL,
    routes
})

export default router
