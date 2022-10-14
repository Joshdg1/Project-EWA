import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import ProgrammerProfilePage from "@/views/ProgrammerProfilePage";
import ProgrammerHomePage from "@/views/ProgrammerHomePage";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {path: '/programmerProfile', name: 'ProgrammerProfilePage', component: ProgrammerProfilePage},
    {
        path: '/ProgrammerHomePage',
        name: 'ProgrammerHomePage',
        component: ProgrammerHomePage
    },
]

const router = new VueRouter({
    mode: 'history',
    // eslint-disable-next-line no-undef
    base: process.env.BASE_URL,
    routes
})

export default router
