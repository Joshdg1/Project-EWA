const programmerRoutes = [
    {
        name: "Home",
        path: '/home',
        component: () => import(`../views/programmer/Home.vue`),
    },
    {
        name: "Projecten",
        path: '/projects',
        component: () => import(`../views/programmer/project/View`),
    },
    {
        name: "Mijn account",
        path: '/profile/view',
        component: () => import(`../views/programmer/profile/View.vue`),
    },
    {
        name: "404PageNotFound",
        path: "*",
        component: () => import('../404page.vue')
    },
]

export default programmerRoutes;
