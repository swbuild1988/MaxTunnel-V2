import { Component, Vue } from "vue-property-decorator"
import { PlanManageData, TotalNumData, SimulateSpeed } from '@/types/views/PlanManage.interface'
import { Button, Select, Option, ButtonGroup } from 'view-design'

Vue.component('Button', Button)
Vue.component('Select', Select)
Vue.component('Option', Option)
Vue.component('ButtonGroup', ButtonGroup)
@Component({})
export default class About extends Vue {

    planManageIMG: string = require('@/assets/images/BV/plan-bg.png')
    pageTitleIMG: string = require('@/assets/images/BV/page-title-bg.png')
    alarmStatisticsIMG: string = require('@/assets/images/BV/energy-bg.png')
    guideIcon: string = require('@/assets/images/BV/guide-icon.png')

    AData: any[] = [
        { eKey: '温度检测仪', normalNum: 9, unNormalNum: 2, hiddenNum: 0, repairNum: 2, otherNum: 0 }, 
        { eKey: '湿度检测仪', normalNum: 6, unNormalNum: 8, hiddenNum: 0, repairNum: 1, otherNum: 2 }, 
        { eKey: '氧气检测仪', normalNum: 8, unNormalNum: 6, hiddenNum: 5, repairNum: 1, otherNum: 1 }, 
        { eKey: '压力计', normalNum: 8, unNormalNum: 2, hiddenNum: 1, repairNum: 3, otherNum: 1 }, 
        { eKey: '风速仪', normalNum: 8, unNormalNum: 6, hiddenNum: 0, repairNum: 2, otherNum: 2 }, 
        { eKey: '流量计', normalNum: 9, unNormalNum: 2, hiddenNum: 0, repairNum: 2, otherNum: 1 }, 
        { eKey: '高频压力计', normalNum: 10, unNormalNum: 2, hiddenNum: 1, repairNum: 3, otherNum: 2 }, 
        { eKey: '应力监测仪', normalNum: 9, unNormalNum: 2, hiddenNum: 0, repairNum: 2, otherNum: 3 }
    ]
    TotalNum: TotalNumData = {
        totalNormalNum: 0,
        totalUnNormalNum: 0,
        totalHiddenNum: 0,
        totalRepairNum: 0,
        totalOtherNum: 0
    }

    PData: PlanManageData = {
        model: 1,
        planInfo: [
            { id: 1, planName: '通风预案' },
            { id: 2, planName: '排水预案' }
        ]
    }

    btnInfo: any[] = [
        { btnContent: '模拟' },
        { btnContent: '停止' },
        { btnContent: '暂停' }
    ]
    activatedBtn: number = 999

    SPData: SimulateSpeed = {
        model: 1,
        speedOption: [
            { id: 1, speed: '正常x1.0' },
            { id: 2, speed: '加速x1.25' },
            { id: 3, speed: '加速x1.5' },
            { id: 4, speed: '加速x1.75' },
            { id: 5, speed: '加速x2.0' }
        ]
    }


    mounted() {
        this.init()
    }

    // 初始化函数
    init() {
        this.AData.forEach(item => {
            this.TotalNum.totalNormalNum += item.normalNum
            this.TotalNum.totalUnNormalNum += item.unNormalNum
            this.TotalNum.totalHiddenNum += item.hiddenNum
            this.TotalNum.totalRepairNum += item.repairNum
            this.TotalNum.totalOtherNum += item.otherNum
        })
    }

    choosedActivited(index: number) {
        this.activatedBtn = index
    }
    
}
