<template>
    <div>
        <p>編成の対象者を入力してください</p>
        <InputForm v-for="(name,id) in members" :key='id' :member="name" />
        <InputSplitNum v-on:child-event="observerSplitNum" />
        <ChoiceButton @choice="choice" />
    </div>
</template>

<script>
    import InputForm from './input_form.vue'
    import ChoiceButton from './choice_button.vue'
    import InputSplitNum from './InputSplitNum.vue'

    export default {
        data() {
            return {
                splitNum: 1,
                //TODO: 可変にしたい
                members: [
                    {
                        name: "",
                        id: 0
                    }, {
                        name: "",
                        id: 1
                    }, {
                        name: "",
                        id: 2
                    }, {
                        name: "",
                        id: 3
                    }, {
                        name: "",
                        id: 4
                    }
                ],
                shuffleMembers: []
            }
        },
        components: {
            InputForm,
            ChoiceButton,
            InputSplitNum
        },
        methods: {
            choice() {
            }
        }
    }
</script>