import { Component, Vue } from 'vue-property-decorator'
import { TunnelIntroductionData, Day } from '@/types/views/TunnelIntroduction.interface'
import { Collapse, Button } from 'view-design'
import Panel from 'view-design/src/components/collapse/panel.vue'
import { formatDate, getFormatTime } from '@/utils/common.ts'

Vue.component('Button', Button)
Vue.component('Collapse', Collapse)
Vue.component('Panel', Panel)

@Component({})
export default class About extends Vue {

    tunnelIntroductIMG: string = require('@/assets/images/BV/operatManage-bg.png')
    pageTitleIMG: string = require("@/assets/images/BV/page-title-bg.png")
    tunnelCollapseIMG: string = require("@/assets/images/BV/energy-bg.png")
    guideIcon: string = require("@/assets/images/BV/guide-icon.png")
    tunnelIcon: string = require("@/assets/images/BV/tunnel-icon.png")
    equipmentIcon: string = require("@/assets/images/BV/equipment-icon.png")
    timeIMG: string = require("@/assets/images/BV/time-bg.png")
    timeIcon: string = require("@/assets/images/BV/time-icon.png")

    // data
    TData: TunnelIntroductionData = {
        value: "1",
        tunnelInfo: [
            { id: 1, val: "1", tunnelName: '古城大街', introduction: '太原市古城大街（K1+480-滨河西路），长2.39公里，宽50米，共有13个管舱，26个区' },
            { id: 2, val: "2", tunnelName: '实验路', introduction: '太原市实验路（纬三路—古城大街），全长0.84公里，宽50米，共有13个管舱，26个区' },
            { id: 3, val: "3", tunnelName: '纬三路', introduction: '太原市纬三路（新晋祠路-滨河西路），全长3.75公里，宽30米，共有13个管舱，26个区' },
            { id: 4, val: "4", tunnelName: '经二路', introduction: '太原市经二路（古城大街 -迎宾路），全长1.48公里，宽30米，共有13个管舱，26个区' },
            { id: 5, val: "5", tunnelName: '经三路', introduction: '太原市经三路（古城大街-迎宾路），全长1.49公里，宽20米，共有13个管舱，26个区' }
        ]
    }
    EData: any = [
        { eKey: '压力计', eVal: 17 },
        { eKey: '流量计', eVal: 29 },
        { eKey: '高频压力计', eVal: 15 },
        { eKey: '应力监测仪', eVal: 26 },
        { eKey: '应变计', eVal: 18 },
        { eKey: '温度', eVal: 64 },
        { eKey: '湿度', eVal: 55 },
        { eKey: '车辆荷载', eVal: 9 },
        { eKey: '风速仪', eVal: 3 }
    ]

    totalEquipment: Number = 0
    time: string = ''
    data: string = ''
    safeOperatNum: Number = 0
    Day: Day = {
        nowDate: '',
        nowTime: '',
        nowWeek: '',
        safeOperatDay: 66
    }

    mounted() {
        this.init()
        this.getTime()
        console.log(formatDate(new Date(), 'yyyy-MM-dd'))
    }

    // 初始化函数
    init() {
        (this.EData as any[]).forEach(item => {
            this.totalEquipment += item.eVal 
        });
    }
    getTime() {
        let _this = this
        setInterval(function(){ 
            let date = new Date();
            let year = formatDate(date, 'yyyy');
            let Month = formatDate(date, 'MM');
            let day1 = formatDate(date, 'dd');
            _this.Day.nowDate = year + '年' + Month + '月' + day1 + '日';
            let hour = formatDate(date, 'HH');
            let minute = formatDate(date, 'mm');
            let second = formatDate(date, 'ss');
            _this.Day.nowTime = hour + ':' + minute + ':' + second;
            _this.Day.nowWeek = getFormatTime();
         }, 1000);
    }
    
}
