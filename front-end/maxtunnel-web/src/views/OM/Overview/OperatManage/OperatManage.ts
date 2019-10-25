import { Component, Vue } from 'vue-property-decorator'
import { OperatManageData } from '@/types/views/OperatManage.interface'
import { Button } from 'view-design'
import MultiLine from '@/components/MultipleLineChart/MultipleLineChart.vue'
import Axios from 'axios'

Vue.component('Button', Button)
@Component({
    components: { MultiLine }
})
export default class About extends Vue {

    operatManageIMG: string = require("@/assets/images/BV/operatManage-bg.png")
    pageTitleIMG: string = require("@/assets/images/BV/page-title-bg.png")
    energyStatisticsIMG: string = require("@/assets/images/BV/energy-bg.png")
    guideIcon: string = require("@/assets/images/BV/guide-icon.png")
    customerIMG: string = require("@/assets/images/BV/customer-bg.png")

    // data
    data: OperatManageData = {
        customerInfo: [
            {customerName: '上海波汇', pipeNum: 6 },
            { customerName: '山西波汇', pipeNum: 5 },
            { customerName: '中国移动', pipeNum: 2 },
            { customerName: '中国石化', pipeNum: 8 },
            { customerName: '中国联通', pipeNum: 12 }
        ]
    }

    energyLineData: any = {
        title: '晋源东区管廊能耗统计图',
        xData: [],
        legendData: [],
        series: [],
        lineColors: ['#15ff85', '#f89c50', '#9568e9', '#45a4f8', '#e15a61'],
        option: {
            title: {
                text: '',
                padding: 15,
            },
            tooltip: {
                trigger: 'axis'
            },
            toolbox: {
                show: true,
                feature: {
                saveAsImage: {}
                }
            },
            dataZoom: {
                type: 'inside'
            }
        }
    }

    mounted() {
        this.getOperatManage()
    }

    getOperatManage() {
        Axios.get('http://localhost:8080/data/energyData.json').then(res => {
            this.energyLineData.legendData = []
            this.energyLineData.xData = []
            this.energyLineData.series = []
            let{ data } = res
            data.result[0].val.map((type: any) => {
                this.energyLineData.legendData.push(type.key)
                let value = {
                    name: type.key,
                    type: 'line',
                    data: []
                }
                this.energyLineData.series.push(value)
            })
            data.result.forEach((element: any) => {
                this.energyLineData.xData.push(element.key)
                element.val.map((item: any) => {
                    this.energyLineData.series.forEach((value: any) => {
                        if (value.name === item.key) {
                            value.data.push(item.val)
                        }
                    })
                    
                })
            })
        })
    }

    // 初始化函数
    init() {
        //
    }
    
}
