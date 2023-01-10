const adminRoutes = [
    // === PROGRAMMERS ===
    {
        name: "Specialisten",
        path: '/programmers',
        component: () => import(`../views/admin/programmer/View.vue`),
    },
    {
        name: "Specialist",
        path: '/programmers/view',
        component: () => import(`../views/profile/View.vue`),
    },
    {
        name: "Specialist aanmaken",
        path: '/programmers/create',
        component: () => import('../views/programmer/AddProgrammer.vue'),
    },

    // === PROJECTS ===
    {
        name: "Project aanmaken",
        path: "/projects/create",
        component: () => import('../views/admin/project/Create.vue')
    },

    // === CLIENTS ===
    {
        name: "Cliënten",
        path: '/clients',
        component: () => import(`../views/admin/client/View.vue`),
    },
    {
        name: "Cliënt aanmaken",
        path: "/clients/create",
        component: () => import('../views/admin/client/Create.vue')
    },
]

export default adminRoutes;
