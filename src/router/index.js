import {createRouter, createWebHistory} from 'vue-router'
const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'Manager',
            component: () => import('@/views/Manager.vue'),
            redirect: '/home',
            children: [// 路由映射
                {path: 'home', name: 'Home', component: () => import('@/views/manager/Home.vue')},
                {path: 'JZCM', name: 'JZCM', component: () => import('@/views/manager/JZCM.vue')},
                {path: 'interesting', name: 'interesting', component: () => import('@/views/manager/interesting.vue')},
                {path: '2022', name: '2022', component: () => import('@/views/manager/2022.vue')},
                {path: '2023', name: '2023', component: () => import('@/views/manager/2023.vue')},
                {path: '2024', name: '2024', component: () => import('@/views/manager/2024.vue')},
                {path: 'QUQU', name: 'QUQU', component: () => import('@/views/manager/QUQU.vue')},
                {path: 'XTT', name: 'XTT', component: () => import('@/views/manager/XTT.vue')},
                {path: 'DGQ', name: 'DGQ', component: () => import('@/views/manager/DGQ.vue')},
                {path: 'baizi', name: 'baizi', component: () => import('@/views/manager/baizi.vue')},
                {path: 'l+1', name: '+1', component: () => import('@/views/manager/l+1.vue')},
                
            ]
        },
        // {
        //     path: '/home',
        //     name: 'home',
        //     component: () => import('@/views/manager/home.vue'),
        //   }
    ]
})

export default router
