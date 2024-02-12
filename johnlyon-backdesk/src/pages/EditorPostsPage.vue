<template>
  <section class="container pb-5" v-if="posts[0]">
    <form id="sub" @submit.prevent="handleSubmit">
      <div class="form-group mt-3">
        <label>URL</label>
        <input type="text" name="url" class="form-control" placeholder="URL" v-model="posts[0].url" ref="urlInput">
      </div>
      <div class="form-group my-3">
        <label>Name</label>
        <input type="text" name="name" class="form-control" placeholder="Name" v-model="posts[0].name" ref="nameInput">
      </div>
      <div class="form-group my-3">
        <label>Title</label>
        <input type="text" name="title" class="form-control" placeholder="Title" v-model="posts[0].title" ref="titleInput">
      </div>
      <div class="form-group my-3">
        <label>Date</label>
        <input type="text" name="date" class="form-control" placeholder="Date" v-model="posts[0].date" ref="date">
      </div>
      <div class="form-group my-3">
        <label>Introduction</label>
        <input type="text" name="introduction" class="form-control" placeholder="Introduction"
               v-model="posts[0].introduction" ref="introductionInput">
      </div>
      <div class="form-group my-3">
        <label for="editor">Content</label>
        <EditorComponents name="content" ref="editorContent" :content="posts[0].content"/>
      </div>
      <div class="form-group my-3">
        <label for="pin">Pin</label>
        <br/>
        <select name="pin" class="mt-1" ref="pinInput" v-model="selectedPin">
          <option value="0">No</option>
          <option value="1">Yes</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </section>
</template>
<script>
import axios from 'axios';
import EditorComponents from "@/components/EditorComponents.vue";


export default {
  components: {EditorComponents},
  data() {
    return {
      posts: [],
      selectedPin: null,
      isSubmitting: false
    }
  },
  methods: {
    handleSubmit() {
      if (this.isSubmitting) {
        alert('请稍后再提交');
        return;
      }
      this.isSubmitting = true;

      const formData = {
        url: this.$refs.urlInput.value,
        name: this.$refs.nameInput.value,
        title: this.$refs.titleInput.value,
        date: this.$refs.date.value,
        introduction: this.$refs.introductionInput.value,
        content: this.$refs.editorContent.valueHtml,
        pin: parseInt(this.$refs.pinInput.value) // Convert pin to an integer
      };

      const params = new URLSearchParams(formData);

      axios.post(`/editPosts?${params.toString()}`)
          .then(response => {
            this.$router.push('/');
            alert(response.data);
          })
          .catch(error => {
            console.error(error);
          })
          .finally(() => {
            setTimeout(() => {
              this.isSubmitting = false;
            }, 10000);
          });
    }
  },
  created() {

    const PostsName = this.$route.params.name;
    axios.get('/getEditorPosts?name=' + PostsName.toString())
        .then(response => {
          this.posts = response.data;
          this.selectedPin = this.posts[0].pin;
        })
        .catch(error => {
          console.error(error);
        });

  }
}

</script>
<style scoped>
select {
  width: 100px;
}
</style>