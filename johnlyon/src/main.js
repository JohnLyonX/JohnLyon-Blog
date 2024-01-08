import {createApp} from 'vue'
import App from './App.vue'
import axios from 'axios';
import {createRouter, createWebHistory} from "vue-router";

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.min.js'
import 'bulma/css/bulma.css'

import HomePage from "@/pages/BlogPages.vue";
import PostsPage from "@/pages/PostsPage.vue";

axios.defaults.baseURL = 'https://www.iamjohnlyon.com:8082/api';

// 引入要加载的路由配置
const routes = [
    {
        path: '',
        component: HomePage,
        meta: {
            title: 'John Lyon'
        }
    },
    {
        path: '/posts/:name',
        component: PostsPage,
        meta: {
            title: (route) => {
                // 从路由参数中获取文章的 name
                const name = route.params.name;
                return name ? `${name}` : 'Posts - John Lyon';
            }
        }
    }
]

// 创建路由对象
const router = createRouter({
    routes,
    mode: 'history',
    history: createWebHistory(),
})

router.beforeEach((to, from, next) => {
    document.title = typeof to.meta.title === 'function'
        ? to.meta.title(to)
        : to.meta.title || 'Lyon John';
    next()
})

const app = createApp(App)
app.use(router)

app.mount('#app')