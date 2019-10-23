import { Component, Vue } from 'vue-property-decorator'
import { TunnelIntroductionData } from '@/types/views/TunnelIntroduction.interface'
import { Collapse, Button } from 'view-design'
import Panel from 'view-design/src/components/collapse/panel.vue'

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

    mounted() {
        //
    }

    // 初始化函数
    init() {
        //
    }
    
}
