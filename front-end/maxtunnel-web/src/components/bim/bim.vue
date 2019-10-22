<template>
    <div class="bim-wrap">
        <Button type="primary" @click="change" class="change">切换</Button>
        <bim-face v-if="data.bimState === 1"></bim-face>
        <super-map v-if="data.bimState === 2"></super-map>
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop } from "vue-property-decorator"
    import { BimData } from '@/types/components/bim.interface'
    import BimFace from "@/components/bim/BimFace" // 组件
    import SuperMap from "@/components/bim/SuperMap"

    @Component({ 
        components: {
            BimFace,
            SuperMap
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
            componentName: 'bim',
            bimState: 1
        }

        // mounted() {
        // }
        change(){
            this.data.bimState = this.data.bimState === 2 ? 1 : 2
        }
    }
</script>

<style lang="less">

    .bim-wrap {
        width: 100%;
        height: 100%;
        position: relative;
    }
    .change{
        position: absolute;
        z-index: 1000;
        top: 1vmin;
        right: 2vmin;
        width: 16vmin; 
        height: 5vmin; 
        background: #11DAB7; 
        color: #FFFFFF; 
        border-radius: 3px;
        border: none; 
        cursor: pointer;
    }
</style>

