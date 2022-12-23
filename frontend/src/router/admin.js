const adminRoutes = [
    {
        path: "/home",
        name: "Home",
        component: () => import('../views/admin/Home.vue'),
    },
    {
        name: "Specialisten",
        path: '/programmers',
        component: () => import(`../views/admin/programmer/View.vue`),
    },

    {
        name: "Mijn account",
        path: '/profile/view',
        component: () => import(`../views/admin/profile/View.vue`),
    },
    {
        name: "Specialist",
        path: '/programmers/view',
        component: () => import(`../views/admin/profile/View.vue`),
    },
    {
        name: "Specialist aanmaken",
        path: '/programmers/add',
        component: () => import('../views/programmer/AddProgrammer.vue'),
    },

    {
        name: "Projecten",
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
    {
        name: "Opdrachtgevers",
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
]

export default adminRoutes;
