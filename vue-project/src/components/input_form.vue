<template>
  <div class="people_name">
      <label>
          <input placeholder="名前を入力" v-model="member.name">
      </label>
  </div>
</template>

<script>
export default {
  name: 'InputForm',
    props: {
        member: {
            type: Object,
            required: true
        }
    }
}
</script>
