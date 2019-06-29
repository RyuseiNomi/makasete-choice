<template>
  <div class="people_name">
      <label>
          <input v-model="message" placeholder="名前を入力"><br>
          <input v-model="message" placeholder="名前を入力"><br>
          <input v-model="message" placeholder="名前を入力"><br>
          <input v-model="message" placeholder="名前を入力"><br>
          <input v-model="message" placeholder="名前を入力"><br>
          <input v-model="message" placeholder="名前を入力"><br>
      </label>
      <p>最大人数を入力してください</p>
      <label>
          <input v-model="message" placeholder="人数を入力">
      </label>
  </div>
</template>

<script>
export default {
  name: 'InputForm'
}
</script>
