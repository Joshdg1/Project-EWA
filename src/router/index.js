import Vue from 'vue'
import VueRouter from 'vue-router'

// General

import Home from '../views/Home.vue'

// Programmer
import ProgrammerEdit from "../views/programmer/Edit";
import ProgrammerHome from "../views/programmer/Home";

// Client
import ClientHomePage from "../views/client/Home"

// Admin
import AdminProgrammerView from "../views/admin/programmer/View.vue";
import AdminProjectView from "../views/admin/project/ProjectAdminView.vue";
import AdminClientView from "../views/admin/client/ClientAdminView.vue";

Vue.use(VueRouter)

const routes = [
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
