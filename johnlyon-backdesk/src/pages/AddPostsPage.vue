<template>
  <section class="container pb-5">
    <h2>Add Posts</h2>
    <form ref="postForm" @submit.prevent="handleSubmit">
      <div class="form-group mt-3">
        <label for="url">URL</label>
        <input type="text" id="url" name="url" class="form-control" placeholder="URL" ref="urlInput">
      </div>
      <div class="form-group my-3">
        <label for="name">Name</label>
        <input type="text" id="name" name="name" class="form-control" placeholder="Name" ref="nameInput">
      </div>
      <div class="form-group my-3">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" class="form-control" placeholder="Title" ref="titleInput">
      </div>
      <div class="form-group my-3">
        <label for="date">Date</label>
        <input type="text" id="date" name="date" class="form-control" placeholder="Date" v-model="date" readonly>
      </div>
      <div class="form-group my-3">
        <label for="introduction">Introduction</label>
        <input type="text" id="introduction" name="introduction" class="form-control" placeholder="Introduction"
               ref="introductionInput">
      </div>
      <div class="form-group my-3">
        <label for="editor">Content</label>
        <EditorComponents id="content" name="content" ref="editorContent"/>
      </div>
      <div class="form-group my-3">
        <label for="pin">Pin</label>
        <br/>
        <select id="pin" name="pin" class="mt-1" ref="pinInput">
          <option value="0">No</option>
          <option value="1">Yes</option>
        </select>
      </div>
      <button type="submit" class="btn btn-primary" :disabled="isSubmitting">Submit</button>
    </form>
  </section>
</template>
<script>
import axios from 'axios';
import EditorComponents from "@/components/EditorComponents.vue";

export default {
  components: {
    EditorComponents
  },
  data() {
    return {
      url: '',
      name: '',
      title: '',
      introduction: '',
      pin: 0,
      editorContent: '',
      date: '',
      isSubmitting: false, // Add this line
    };
  },
  mounted() {
    this.updateDate();
  },
  methods: {
    updateDate() {
      const now = new Date();
      this.date = now.toLocaleDateString('en-US', {month: 'long', day: 'numeric', year: 'numeric'});
    },
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
        date: this.date,
        introduction: this.$refs.introductionInput.value,
        content: this.$refs.editorContent.valueHtml,
        pin: parseInt(this.$refs.pinInput.value) // Convert pin to an integer
      };

      // Convert formData to URLSearchParams
      const params = new URLSearchParams(formData);

      axios.post(`/writePosts?${params.toString()}`)
          .then(response => {
            this.$router.push('/'); // Modify this line
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
  }
};
</script>
<style scoped>
select {
  width: 100px;
}
</style>
