import { createRouter, createWebHistory } from 'vue-router'
import { useAuthStore } from '../store/auth'
const routes = [
    {
        path: '/',
        redirect: '/login'  // 添加重定向到/login
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('../views/Login.vue'),
    },
    {
        path: '/home',
        name: 'Home',
        component: () => import('../views/Home.vue'),
        children: [
            { path: 'index', component: () => import('../views/pages/Index.vue') },
            // 其他功能页
        ]
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

// 登录拦截
router.beforeEach((to, _, next) => {
    const store = useAuthStore()
    if (to.path.startsWith('/home') && !store.isLoggedIn) {
        next('/login')
    } else {
        next()
    }
})
export default router
