import Vue from 'vue'
import VueRouter from 'vue-router'

import adminRoutes from "@/router/admin";
import clientRoutes from "@/router/client";
import programmerRoutes from "@/router/programmer";

Vue.use(VueRouter)

let routes = [
    {
        meta: {
            wide: true,
            isPublic: true,
        },
        path: "/",
        component: () => import('../views/Home.vue'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/users/register",
        component: () => import('../views/auth/Register.vue'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/users/login",
        component: () => import('../views/auth/Login.vue'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/users/ForgotPassword",
        component: () => import('../views/auth/ForgotPassword.vue'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/users/resetPassword",
        component: () => import('../views/auth/ResetPassword'),
    },


    // all user types
    {
        name: "404PageNotFound",
        path: "*",
        component: () => import('../404page.vue')
    },
    {
        path: "/home",
        name: "Home",
        component: () => import('../views/LoginHome.vue'),
    },
    {
        name: "Mijn account",
        path: '/profile/view',
        component: () => import(`../views/profile/View.vue`),
    },
    {
        name: "Projecten",
        path: '/projects',
        component: () => import(`../views/ProjectView`),
    },
];

routes = routes.concat(setType(adminRoutes, 'administrator'));
routes = routes.concat(setType(clientRoutes, 'client'));
routes = routes.concat(setType(programmerRoutes, 'programmer'));

const router = new VueRouter({
    mode: 'hash',
    // eslint-disable-next-line no-undef
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    const loggedIn = sessionStorage.getItem('token');
const user = sessionStorage.user ? JSON.parse(sessionStorage.user) : false;

    // trying to access a restricted page + not logged in
    // redirect to auth page
    if (!loggedIn && !to.meta.isPublic && !from.meta.isPublic) {
        next('/users/login');
    } else if (loggedIn && to.meta.isPublic) {
        next('/home');
    } else {
        if (to.meta.type && to.meta.type !== user.userType) {
            next('/404');
        } else {
            next();
        }
    }
});

function setType(routes, type) {
    for (const route of routes) {
        if (!route.meta)
            route.meta = {};

        route.meta.type = type;
    }

    return routes;
}
export default router;
