<template>
  <section class="mx-auto border-bottom">
    <div class="post-container p-4">
      <div class="post-img">
        <a href="javascript:void(0)" @click="handleClick">
          <img :src="props.post.url" alt="post image">
        </a>
      </div>
      <div class="post-content">
        <a href="javascript:void(0)" @click="handleClick">
          <h2 class="fs-3 fw-bold">{{ props.post.name }}</h2>
          <h2 class="fs-6 my-2 text-muted fw-normal">{{ props.post.date }}</h2>
          <p class="fs-6 fw-semibold">{{ props.post.introduction }}</p>
        </a>
        <a class="fs-6 text-black text-decoration-underline">Read More</a>
      </div>
    </div>
  </section>
</template>
<script setup>
import {defineProps} from 'vue'
import { useRouter } from 'vue-router';

const props = defineProps({
  post: {
    type: Object,
    default: () => ({})
  }
})
const router = useRouter();
const handleClick = () => {
  if (props.post.name) {
    router.push({ path: '/posts/' + props.post.name });
  }
}
</script>
<style scoped>
a, a:hover {
  color: #2c3e50;
}

.post-container {
  max-width: 1024px;
  display: flex;
  flex-direction: row;
}

.post-img {
  flex-shrink: 0;
}

.post-img img {
  width: 320px;
  height: 180px;
  border-radius: .5rem;
}

.post-content {
  max-width: 656px;
  padding-left: 16px;
}

@media (max-width: 640px) {
  .post-container {
    flex-direction: column;

  }

  .post-img img {
    width: 100%;
    height: 100%;
    border-radius: .5rem;
    object-fit: cover;
  }

  .post-content {
    max-width: 656px;
    padding: 10px 5px;
  }
}
</style>