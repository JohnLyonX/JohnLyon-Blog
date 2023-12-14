<template>
  <section class="header-container px-4 py-4">
    <div class="avatar">
      <img alt="Vue logo" src="@/assets/lyonjohn.png">
    </div>
    <div class="py-4">
      <h2>Hey! <br/><span class="name">I'm Lyon <span class="gradient-text">John</span></span></h2>
      <p>hi, my name is Lyon John, but you can call me Po John! Now I'm a full stack developer...so thank you for the
        love and have a nice day</p>
      <p>Welcome to search my name on Youtube and Github</p>
    </div>

    <img src="https://komarev.com/ghpvc/?username=pojohnx&label=Profile%20views&color=0e75b6&style=flat" alt="pojohnx"/>
  </section>
</template>

<script setup>
</script>

<style scoped>

.avatar {
  width: 180px;
  height: 180px;
  overflow: hidden;
  border-radius: 10rem;
}

.avatar img {
  width: 100%;
}

h2 {
  font-size: 6rem;
  font-weight: bold;
  color: #2c3e50;
  padding: 0;
}

@keyframes gradient {
  0% {
    background-position: 200%;
  }
  50% {
    background-position: 50%;
  }
  100% {
    background-position: 0;
  }
}

.gradient-text {
  background: linear-gradient(to right, orange, #0f76ff, orange);
  background-size: 200% 200%;
  background-clip: text;
  -webkit-background-clip: text;
  color: transparent;
  animation: gradient 5s ease-out infinite forwards;
}

p {
  font-size: 1.4rem;
  font-weight: 500;
  margin: 5px 0;
  color: #2c3e50;
}

p:nth-child(3) {
  font-size: 1.6rem;
  font-weight: 300;
  margin: 5px 0;
  color: #2c3e50;
}
</style>
