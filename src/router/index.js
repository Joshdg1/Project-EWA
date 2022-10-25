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
import AdminProgrammerView from "../views/programmer/Edit";

Vue.use(VueRouter)




const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/admin',
        name: 'AdminHome',
        children: [
            {
                path: '/programmer',
                name: 'AdminProgrammerHome',
                children: [
                    {
                        path: '/view',
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
