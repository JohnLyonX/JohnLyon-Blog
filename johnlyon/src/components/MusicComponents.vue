<template>
  <section class="px-4">
      <div v-html="posts.url"></div>
  </section>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      posts: [],
    };
  },
  methods: {
    getPosts() {
      axios.post('http://www.lyonjohn.xyz:8081/api/getMusic')
          .then(response => {
            this.posts = response.data;
          })
          .catch(error => {
            console.error(error);
          });
    }
  }
  ,
  created() {
    this.getPosts();
  }
}
</script>

<style scoped>

</style>