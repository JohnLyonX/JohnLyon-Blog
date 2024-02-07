<template>
  <section class="header-container px-4 py-4">
    <div class="avatar">
      <img alt="Vue logo" src="https://defgec.oss-cn-guangzhou.aliyuncs.com/JohnLyon-Blog/avatar/johnlyon.png">
    </div>
    <div class="py-4">
      <h2>Hey! <br/> I'm
        <div class="name" ref="nameContainer">John <span class="gradient-text">Lyon</span>
        </div>
      </h2>
      <p>hi, my name is 梁展波, but you can call me john lyon or po john! Now I'm a full stack developer...so thank you
        for the
        love and have a nice day</p>
      <p>Welcome to search my name on <a href="https://www.youtube.com/@JohnLyon0611" class="text-dark fw-bolder">Youtube</a>
        and <a
            href="https://github.com/JohnLyonX" class="text-dark fw-bolder"> Github </a></p>

    </div>

    <img src="https://komarev.com/ghpvc/?username=johnlyonx&label=Profile%20views&color=0e75b6&style=flat" alt="pojohnx"/>
  </section>
</template>

<script>
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


@media (max-width: 500px) {
  .name {
    font-size: 4.5rem;
  }
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
