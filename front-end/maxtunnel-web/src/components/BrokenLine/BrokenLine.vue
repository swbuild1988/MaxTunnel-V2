<template>
    <div class="BrokenLine-wrap">
        <canvas></canvas>
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop, Watch } from "vue-property-decorator"
    import { BrokenLineData } from '@/types/components/BrokenLine.interface'

    @Component({})
    export default class About extends Vue {
        @Prop({ required: true})
        brokenLineProp: any = {
            dot: 200,
            x: 200,
            y: 300,
            lineColor: '#fff'
        }

        @Watch('brokenLineProp')
        watchBrokenData(newVal: any, oldVal: any) {
            this.init(newVal.dot, newVal.x, newVal.y, newVal.lineColor)
        }

        // 初始化函数
        init(dot: number, x: number, y: number, lineColor: string) {           
            let c = document.getElementsByTagName('canvas')[0] as HTMLCanvasElement;
            c.setAttribute('height', y + 'px')
            c.setAttribute('width', x + 'px')
            let ctx = c.getContext("2d") as CanvasRenderingContext2D;
            // 绘制点
            ctx.beginPath();
            // 绘制定点
            ctx.arc(Number(dot + 1), Number(dot + 1), dot, 0, 2 * Math.PI)
            ctx.strokeStyle = lineColor;
            ctx.fillStyle = lineColor;
            ctx.fill();
            ctx.stroke();
            ctx.closePath();
            // 绘制折线
            ctx.beginPath();
            // 折线开始位置
            ctx.moveTo(dot / 2, dot);
            // 第一个折
            ctx.lineTo(x / 4, dot);
            // 第二个折
            ctx.lineTo(x / 2, y - 2)
            // 第三个折
            ctx.lineTo(x, y - 1);
            ctx.lineWidth = 2;
            ctx.strokeStyle = lineColor;
            ctx.stroke();
            ctx.closePath();
        }
    }
</script>

<style lang="less">
    .BrokenLine-wrap {
        width: 100%;
    }
</style>

