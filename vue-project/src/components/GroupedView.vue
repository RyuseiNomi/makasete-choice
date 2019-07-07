<template>
    <div id="grouped_view">
        <div v-for="(member, index) in groupedMember" :key="index">
            {{member}}
        </div>
    </div>
</template>

<script>
    export default {
        name: "GroupedView",
        props: {
            groupedMember: {
                type: Array,
                required: true
            },
        }
    }
</script>