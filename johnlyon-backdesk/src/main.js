// main.js

import {createApp} from 'vue';
import App from './App.vue';
import {createRouter, createWebHistory} from 'vue-router';

import 'bootstrap/dist/css/bootstrap.css';

import HomePage from '@/pages/HomePage.vue';
import EditorPage from '@/pages/EditorPostsPage.vue';
import AddPage from '@/pages/AddPostsPage.vue';
import axios from "axios";

axios.defaults.baseURL = 'http://localhost:8081/api';

const routes = [
    {
        path: '/',
        component: HomePage,
        meta: {
            title: 'Eidetic - Home'
        }
    },
    {
        path: '/Add',
        component: AddPage,
        meta: {
            title: 'Add Posts'
        }
    },
    {
        path: '/posts/:name',
        component: EditorPage,
        meta: {
            title: (route) => {
                // 从路由参数中获取文章的 name
                const name = route.params.name;
                return name ? `${name}` : 'Posts - Lyon John';
            }
        }
    }
];

const router = createRouter({
    routes,
    history: createWebHistory(),
});

router.beforeEach((to, from, next) => {
    document.title = typeof to.meta.title === 'function'
        ? to.meta.title(to)
        : to.meta.title || 'Lyon John';
    next()
})

const app = createApp(App);
app.use(router);
app.mount('#app');