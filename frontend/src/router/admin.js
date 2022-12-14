const adminRoutes = [
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
]

export default adminRoutes;