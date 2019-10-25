<template>
    <div class="supermap-wrap">
        <div id="cesiumContainer"></div>
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop } from "vue-property-decorator"
    import { SuperMapData } from '@/types/components/supermap.interface'

    @Component({ 
     })
    export default class About extends Vue {
        // prop
        @Prop({
        required: false,
            default: ''
        }) name!: string

        // data
        data: SuperMapData = {
            componentName: 'supermap'
        }

        mounted() {
            this.loadSuperMap()
        }

        loadSuperMap() {
            let viewer = new Cesium.Viewer('cesiumContainer')
        }

    }
</script>

<style lang="less">

    .supermap-wrap {
        width: 100%;
        height: 100%;
        overflow: hidden;
    }
</style>

