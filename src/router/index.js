import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)


const routes = [
    {
        meta: {
            wide: true,
            isPublic: true,
        },
        path: "/",
        component: () =>  import('../views/Home'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/register",
        component: () =>  import('../views/auth/Register'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/login",
        component: () => import('../views/auth/Login'),
    },

    // === ADMIN PAGES ===
    {
        path: "/home",
        name: "Home",
        component: () =>  import('../views/admin/AdminHome'),
    },


    // === PROGRAMMERS ===
    {
        name: "Programmers",
        path: '/programmers',
        component: () => import(`../views/programmer/Home`),
    },

    {
        name: "Edit Programmer",
        path: '/programmers/view',
        component: () => import(`../views/programmer/Edit`),
    },

    // === CLIENTS ===
    {
        name: "Clients",
        path: '/clients',
        component: () => import(`../views/admin/client/ClientAdminView`),
    },


    // === PROJECTS ===
    {
        name: "Projects",
        path: '/projects',
        component: () => import(`../views/admin/project/ProjectAdminView`),
    },
    {
        name: "CreateClientProjectView",
        path: "/createNewProject",
        component: () => import('../views/admin/client/CreateClientProjectView')
    },
    {
        name: "CreateClientProject-2",
        path: "/createNewProject2",
        component: () => import('../views/admin/client/CreateClientProject-2')
    }
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
    if (!loggedIn && !to.meta.isPublic && !from.meta.isPublic) {
        next('/login');
    } else if (loggedIn && to.meta.isPublic) {
        next('/home');
    } else {
        next();
    }
});

export default router;