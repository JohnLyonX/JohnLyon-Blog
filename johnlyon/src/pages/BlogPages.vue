<template>
  <div id="home">
    <NavbarComponents/>
    <div id="container" class="mx-auto">
      <IntroductionComponents/>

      <section class="py-2">
        <BlogPosts/>
        <div>
          <PostsComponents v-for="(post, index) in posts" :key="index" :post="post"/>
        </div>
      </section>

      <FooterComponents/>
    </div>
  </div>
</template>
<script>
import NavbarComponents from '@/components/NavbarComponents.vue'
import IntroductionComponents from '@/components/IntroductionComponents.vue'
import BlogPosts from '@/components/BlogPosts.vue'
import PostsComponents from '@/components/PostsComponents.vue'
import FooterComponents from '@/components/FooterComponents.vue'

import axios from "axios";

export default {
  name: 'BlogPage',
  components: {
    NavbarComponents,
    IntroductionComponents,
    BlogPosts,
    PostsComponents,
    FooterComponents
  },


  data() {
    return {
      posts: [],
    };
  },
  methods: {
    getPosts() {
      axios.post('/getPosts')
          .then(response => {
            this.posts = response.data.sort((a, b) => b.pin - a.pin);
          })
          .catch(error => {
            console.error(error);
          });
    }
  },
  created() {
    this.getPosts();
  }
}
</script>

<style>
#container {
  max-width: 1024px;
}
</style>
