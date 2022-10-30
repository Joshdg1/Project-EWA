import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: "/",
        name: "home",
        component: () =>  import('../views/Home'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/register",
        component: () =>  import('../auth/Register'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/login",
        component: () => import('../auth/Login'),
    },
];

const router = new VueRouter({
    mode: 'history',
    // eslint-disable-next-line no-undef
    base: process.env.BASE_URL,
    routes
})

router.beforeEach((to, from, next) => {
    const loggedIn = localStorage.getItem('user');

    // trying to access a restricted page + not logged in
    // redirect to auth page
    if (!loggedIn && !to.meta.isPublic) {
        next('/login');
    } else if (loggedIn && to.meta.isPublic) {
        next('/');
    } else {
        next();
    }
});

export default router;