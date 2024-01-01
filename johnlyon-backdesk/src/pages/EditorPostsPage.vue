<script setup>
import Vue3MyEditor from "@/components/Vue3MyEditor.vue";
import {defineEmits, defineProps, onMounted, ref} from 'vue';
import axios from 'axios';

const getDataHandler = (data) => {
  console.log(data);
}

const props = defineProps({
  name: String,
});

const posts = ref([]);
onMounted(() => {
  axios.get(`http://www.lyonjohn.xyz:8081/api/posts?name=${props.name}`)
      .then(response => {
        posts.value = response.data;
        console.log(response.data);
      })
      .catch(error => {
        console.error(error);
      });
});

defineEmits(['update:posts']);
</script>

<template>
  <section v-if="posts[0]">
    <form id="sub" @submit.prevent="handleSubmit">
      <div class="form-group mt-3">
        <label>URL</label>
        <input type="text" class="form-control" placeholder="URL" v-model="posts[0].url">
      </div>
      <div class="form-group my-3">
        <label>Name</label>
        <input type="text" class="form-control" placeholder="Name" v-model="posts[0].name">
      </div>
      <div class="form-group my-3">
        <label>Title</label>
        <input type="text" class="form-control" placeholder="Title" v-model="posts[0].title">
      </div>
      <div class="form-group my-3">
        <label>Date</label>
        <input type="text" class="form-control" placeholder="Date" v-model="posts[0].date">
      </div>
      <div class="form-group my-3">
        <label>Introduction</label>
        <input type="text" class="form-control" placeholder="Introduction" v-model="posts[0].introduction">
      </div>
      <div class="form-group my-3">
        <label>Content</label>
        <Vue3MyEditor @onDataEvent="getDataHandler"/>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </section>
</template>

<style scoped>

</style>