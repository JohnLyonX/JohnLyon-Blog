<template>
  <div class="container">
    <h1>Login</h1>
    <small>John Lyon Posts</small>
    <form id="sub" v-on:submit.prevent="submitForm">
      <div class="form-group mt-3">
        <input type="text" class="form-control" id="exampleInputEmail1" v-model="username" placeholder="username">
      </div>
      <div class="form-group my-3">
        <input type="password" class="form-control" id="exampleInputPassword1" v-model="password" placeholder="password">
      </div>
      <button type="submit" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';
import Cookies from 'js-cookie'

export default {
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    submitForm() {
      axios.post('http://localhost:8081/api/login', {
        username: this.username,
        password: this.password,
      }).then(response => {
        // 保存服务器发来的Cookie
        document.cookie = `session=${response.data.session}; path=/`;
        Cookies.get('userToken')
        alert(Cookies.get('userToken'))
        // 跳转到首页
        this.$router.push('/');
      }).catch(error => {
        console.error(error);
      });
    },
  },
};
</script>

<style scoped>
.container {
  max-width: 420px;
}
</style>