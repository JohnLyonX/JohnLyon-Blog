<template>
  <section v-if="posts.length > 0">
    <NavbarComponents/>
    <div class="px-4 py-2 mx-auto" id="container">
      <header class="pb-4">
        <div class="posts-url">
          <img :src="posts[0].url" alt="posts image">
        </div>
      </header>
      <h2 class="fs-1 fw-bold">{{ posts[0].name }}</h2>
      <div class="fs-6 fw-semibold date my-3 py-1">Published: {{ posts[0].date }}</div>
      <h2 class="fs-3 fw-b py-2">{{ posts[0].title }}</h2>
      <div class="fs-6 py-2">{{ posts[0].content }}</div>
      <FooterComponents/>
    </div>
  </section>
  <section v-else>
  </section>
</template>
<script>
import NavbarComponents from '@/components/NavbarComponents.vue'
import FooterComponents from '@/components/FooterComponents.vue'

import axios from 'axios';

export default {
  components: {
    NavbarComponents,
    FooterComponents
  },
  data() {
    return {
      posts: []
    }
  },
  created() {
    const PostsName = this.$route.params.name;
    axios.get('http://www.lyonjohn.xyz:8081/api/posts?name=' + PostsName)
        .then(response => {
          this.posts = response.data;
        })
        .catch(error => {
          console.error(error);
        });
  }
}
</script>
<style scoped>
#container {
  max-width: 1024px;
}

.posts-url {
  max-width: 500px;
  height: auto;
}

.posts-url img {
  width: 100%;
  height: 100%;
  border-radius: .5rem;
}

@media (max-width: 640px) {
  .posts-url {
    max-width: 100%;
  }
}

.date {
  display: inline-block;
  border-top: 1px solid rgba(0, 0, 0, 0.29);
}
</style>