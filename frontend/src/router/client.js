const clientRoutes = [
    {
        name: "Client Home",
        path: '/home',
        component: () => import(`../views/client/Home.vue`),
    },
]

export default clientRoutes;