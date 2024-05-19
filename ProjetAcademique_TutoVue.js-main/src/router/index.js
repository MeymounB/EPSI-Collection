import { createRouter, createWebHistory } from 'vue-router'

const routes = [
	{
		path: '/projets',
		name: 'projets',
		component: () => import('../views/ProjetView.vue')
	},
	{
		path: '/contact',
		name: 'contact',
		// route level code-splitting
		// this generates a separate chunk (contact.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import(/* webpackChunkName: "contact" */ '../views/ContactView.vue')
	},
	{
		path: '/history',
		name: 'my_history',
		component: () => import('../views/MyHistory.vue')
	},
	{
		path: '/clock',
		name: 'my_clock',
		component: () => import('../views/MyClock.vue')
	},
]

const router = createRouter({
	history: createWebHistory(process.env.BASE_URL),
	routes
})

export default router
