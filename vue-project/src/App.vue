<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <InputForm msg="まかせて☆チョイス"/>
    <ChoiceButton />
  </div>
</template>

<script>
import InputForm from './components/input_form.vue'
import ChoiceButton from './components/choice_button.vue'

export default {
  name: 'app',
  components: {
    InputForm,
    ChoiceButton
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
