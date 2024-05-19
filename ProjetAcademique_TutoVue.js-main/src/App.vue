<template>
  <h1>Meymoun Boualaoui</h1>
  <p>Creative Developper</p>
  <NavBar />
  <Intros />
  <div class="trait"></div>
  <router-view />
  <br>
  <div class="trait"></div>
  <br>
  <footer>
    <NavBar />
  </footer>
</template>

<script>
import NavBar from "./components/NavBar.vue";
import Intros from "./components/MyIntros.vue";

export default {
  name: "app",
  components: {
    NavBar,
    Intros,
  },
};
</script>

<style>
/* .disappear {
  display: none;
} */

#app {
  text-align: center;
  color: #2c3e50;
}

nav {
  display: flex;
  flex-direction: row;
  gap: 20px;
  justify-content: center;

  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.mainContent {
  margin: 0 100px;
}

p {
  font-size: large;
  text-align: center;
}

main>div>p:first-child {
  margin-bottom: 0;
}

p:nth-child(2) {
  margin: 0;
}

@media screen and (max-width: 1080px) {
  .mainContent {
    padding: 20px 60px 10px;
  }
}

.trait {
  margin: 0 100px;
  height: 1px;
  background-color: black;
}

footer {
  display: flex;
  flex-direction: row;
  justify-content: center;
  justify-items: center;
  align-items: center;
  align-content: center;
  flex-wrap: nowrap;
  gap: 20px;
}
</style>
