<template>
  <div class="container">
    <div class="header px-4">
      <h2>Posts Manage</h2>
      <span><a href="/Add" class="btn btn-primary fw-bold">Add Posts</a></span>
    </div>
    <section class="py-2">
      <div>
        <PostsComponents v-for="(post, index) in posts" :key="index" :post="post"/>
      </div>
    </section>

  </div>
</template>
<script setup>
import PostsComponents from "@/components/PostsComponents.vue";
import axios from "axios";
import {onMounted, ref} from 'vue';

const posts = ref([]);

const getPosts = () => {
  axios.post('/getPosts')
      .then(response => {
        posts.value = response.data.sort((a, b) => b.pin - a.pin);
      })
      .catch(error => {
        console.error(error);
      });
}

onMounted(getPosts);
</script>
<style scoped>
.container {
  max-width: 1024px;
}

.header{
  display: flex;
  justify-content: space-between;
}
</style>