<template>
  <div class="decide">
    <input type="button" value="チョイス☆する" @click="$emit('choice')">
  </div>
</template>

<script>
  export default {
    name: 'ChoiceButton'
  }
</script>
