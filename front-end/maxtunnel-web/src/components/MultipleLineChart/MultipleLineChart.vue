<template>
    <div ref="element" class="MultipleLineChart-wrap" :id="id">
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop, Watch } from "vue-property-decorator"
    import Axios from 'axios'

    @Component({})
    export default class About extends Vue {
        // prop
        // @Prop({ required: false,default: ''}) name!: string
        @Prop({ required: true, default: '1'}) id!: string
        @Prop({ required: true}) data!: any

        options: any = {}
        myChart: any = {}

        @Watch('data', {deep: true})
        onDataChanged(val: any, oldVal: any) {
            this.drawMultiLine()
        }

        mounted() {
            this.drawMultiLine()
        }

        drawMultiLine() {
            this.myChart = (this as any).$echarts.init(document.getElementById(this.id) as HTMLCanvasElement),
            this.options = {
                title: {
                    text: this.data.title,
                    left: 'center',
                    textStyle: {
                        color: '#05d1ff',
                        size: '18px'
                    }
                },
                grid: {
                    left: "4%",
                    right: "3%",
                    bottom: "15%",
                    containLabel: true
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: this.data.legendData,
                    bottom: '5%',
                    textStyle: { 
                        color: '#fff'
                    },
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: true,
                    data: this.data.xData,
                    axisLabel: {
                        show: true,
                        width: '20%',
                        textStyle: {
                            color: '#fff',
                        },                            
                    }
                },
                yAxis: {
                    type: 'value',
                    axisLabel: {
                        show: true,
                        textStyle: {
                            color: '#fff',
                        },                            
                    },
                    splitLine: {
                        show: true,
                        lineStyle: {
                            color: ['#0f3069'],
                        }
                    }
                },
                series: this.data.series,
                color: this.data.lineColors && this.data.lineColors.length ? this.data.lineColors : ['#c45df1', '#1095da']
            },
            // 加载默认参数
            (this as any).myChart.setOption(this.options);
            // 加载新的参数
            // if (this.parameters.option) {
            //     this.myChart.setOption(this.parameters.option);
            // }
            window.addEventListener("resize", (this as any).myChart.resize);
        }

        getFontSize(val: string|number) {
            if ( val as number ) {
                return val
            } else {
                if (( val as string ).indexOf('%') > 0) {
                    let tmp = parseFloat(( val as string ).replace('%', '')) / 100;
                    let height = (this.$refs.basicArea as HTMLDivElement | HTMLCanvasElement).offsetHeight;
                    return Math.round(height * tmp);
                }
            }
		}
    }
</script>

<style lang="less">
    .MultipleLineChart-wrap {
        width: 100%;
        height: 100%;
    }
</style>

