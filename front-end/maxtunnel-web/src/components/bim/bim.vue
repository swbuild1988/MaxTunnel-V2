<template>
    <div class="bim-wrap">
        <bim-face></bim-face>
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop } from "vue-property-decorator"
    import { BimData } from '@/types/components/bim.interface'
    import BimFace from "@/components/bim/BimFace" // 组件

    @Component({ 
        components: {
            BimFace
        }
     })
    export default class About extends Vue {
        // prop
        @Prop({
        required: false,
            default: ''
        }) name!: string

        // data
        data: BimData = {
            componentName: 'bim'
        }

        // mounted() {
        // }

    }
</script>

<style lang="less">

    .bim-wrap {
        width: 100%;
        height: 100%;
    }
</style>

