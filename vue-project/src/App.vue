<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <h2>まかせて☆チョイス</h2>
    <MakaseteChoice/>
  </div>
</template>

<script>
  import MakaseteChoice from './components/MakaseteChoice.vue'

  export default {
    name: 'app',
    components: {
      MakaseteChoice
    }
  }
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
