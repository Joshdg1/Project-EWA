const clientRoutes = [
    {
        name: "Home",
        path: '/home',
        component: () => import(`../views/client/Home.vue`),
    },
    {
        name: "Mijn account",
        path: '/profile/view',
        component: () => import(`../views/client/profile/View.vue`),
    },
]

export default clientRoutes;