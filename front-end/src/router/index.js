import Home from '@/components/home/Home.vue'
import Index from '@/components/Index.vue'
import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  
  {
    path: '/',
    name: 'Index',
    component:Index,
    redirect: '/home',
    children: [
      {
        path: '/home',
        name: 'Home',
        component: Home,
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router