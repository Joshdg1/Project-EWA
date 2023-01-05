import Vue from 'vue'
import VueRouter from 'vue-router'

import adminRoutes from "@/router/admin";
import clientRoutes from "@/router/client";
import programmerRoutes from "@/router/programmer";

Vue.use(VueRouter)

const user = sessionStorage.user ? JSON.parse(sessionStorage.user) : false;

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
        path: "/users/asd",
        component: () => import('../views/auth/ForgotPassword.vue'),
    },
    {
        name: "404PageNotFound",
        path: "*",
        component: () => import('../404page.vue')
    }
];

if (user) {
    switch (user.userType) {
        case 'administrator':
            routes = routes.concat(adminRoutes);
            break;
        case 'client':
            routes = routes.concat(clientRoutes);
            break;
        case 'programmer':
            routes = routes.concat(programmerRoutes);
            break;
    }
}

const router = new VueRouter({
    mode: 'history',
    // eslint-disable-next-line no-undef
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    const loggedIn = sessionStorage.getItem('token');

    // trying to access a restricted page + not logged in
    // redirect to auth page
    if (!loggedIn && !to.meta.isPublic && !from.meta.isPublic) {
        next('/users/login');
    } else if (loggedIn && to.meta.isPublic) {
        next('/home');
    } else {
        next();
    }
});

export default router;
