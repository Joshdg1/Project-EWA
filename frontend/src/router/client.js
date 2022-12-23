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
]

export default clientRoutes;
