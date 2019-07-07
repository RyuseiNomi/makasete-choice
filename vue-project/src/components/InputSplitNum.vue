<template>
  <div class="split_num">
    <p>組み分け数を入力してください</p>
    <label>
      <input type="number"
             placeholder="組み分け数を入力"
             v-model.number="splitNum"
             v-on:input="observeSplitNum"
      />
    </label>
  </div>
</template>

<script>
  export default {
    name: "InputSplitNum",
    data() {
      return {
        splitNum: 1
      }
    },
    methods: {
      observeSplitNum() {
        this.$emit('child-event', this.splitNum)
      }
    }

  }
</script>