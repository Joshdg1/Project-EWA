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
        component: () => import('../views/Home.vue'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/register",
        component: () => import('../views/auth/Register.vue'),
    },
    {
        meta: {
            isPublic: true,
        },
        path: "/login",
        component: () => import('../views/auth/Login.vue'),
    },

    // === ADMIN PAGES ===
    {
        path: "/home",
        name: "Home",
        component: () => import('../views/admin/AdminHome.vue'),
    },

    {
        name: "Programmers",
        path: '/programmers',
        component: () => import(`../views/programmer/Home.vue`),
    },

    {
        name: "Edit Programmer",
        path: '/programmers/view',
        component: () => import(`../views/programmer/Edit.vue`),
    },
    {
        name: "Create Programmer",
        path: '/programmers/add',
        component: () => import('../views/programmer/AddProgrammer.vue'),
    },

    // === PROGRAMMERS ===
    {
        name: "Projects",
        path: '/programmer/projects',
        component: () => import(`../views/programmer/project/View`),
    },

    // === CLIENTS ===
    {
        name: "Clients",
        path: '/clients',
        component: () => import(`../views/admin/client/ClientAdminView.vue`),
    },
    {
        name: "createNewClient",
        path: "/createNewClient",
        component: () => import('../views/admin/client/CreateClientView.vue')
    },
    {
        name: "CreateClient-2",
        path: "/createNewClient2",
        component: () => import('../views/admin/client/CreateClient-2.vue')
    },


    // === PROJECTS ===
    {
        name: "Projects",
        path: '/projects',
        component: () => import(`../views/admin/project/ProjectAdminView.vue`),
    },

    {
        name: "CreateProjectView",
        path: "/createNewProject",
        component: () => import('../views/admin/project/CreateProjectView.vue')
    },
    {
        name: "CreateProject-2",
        path: "/createNewProject2",
        component: () => import('../views/admin/project/CreateProject-2.vue')
    },

    // === Client-pages ===
    {
        name: "Client Home",
        path: '/c',
        component: () => import(`../views/client/Home.vue`),
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
    if (!loggedIn && !to.meta.isPublic && !from.meta.isPublic) {
        next('/login');
    } else if (loggedIn && to.meta.isPublic) {
        next('/home');
    } else {
        next();
    }
});

export default router;
