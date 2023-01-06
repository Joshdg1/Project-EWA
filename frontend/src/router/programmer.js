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
        component: () => import(`../views/profile/View.vue`),
    },
    {
        name: "Skills",
        path: '/programmers/view',
        component: () => import(`../views/programmer/profile/View`),
    },
]

export default programmerRoutes;
