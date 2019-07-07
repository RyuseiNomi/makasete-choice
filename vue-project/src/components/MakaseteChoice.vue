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
            },
            observerSplitNum(splitNum){
                this.splitNum = splitNum
            }
        }
    }

    function shuffle(targets) {
        let array = targets;
        for (let i = array.length - 1; i > 0; i--) {
            const r = Math.floor(Math.random() * (i + 1));
            const tmp = array[i];
            array[i] = array[r];
            array[r] = tmp;
        }
        return array
    }
</script>