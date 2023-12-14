<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  name: 'App',
  components: {}
}
</script>

<style>
@keyframes containerAnimation {
  0% {
    transform: translateX(-100%);
  }
  100% {
    transform: translateX(0);
  }
}

#app {
  color: #2c3e50;
  transition: containerAnimation .2s ease;
}



</style>
