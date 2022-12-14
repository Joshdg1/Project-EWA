const programmerRoutes = [
    {
        name: "Projects",
        path: '/projects',
        component: () => import(`../views/programmer/project/View`),
    },
]

export default programmerRoutes;