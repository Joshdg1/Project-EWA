const clientRoutes = [
    {
        name: "Home",
        path: '/home',
        component: () => import(`../views/client/Home.vue`),
    },
    {
        name: "Mijn account",
        path: '/profile/view',
        component: () => import(`../views/profile/View.vue`),
    },
    {
        name: "projects",
        path: "/projects",
        component: () => import('../views/client/project/View'),
    }
]

export default clientRoutes;
