import { Component, Vue } from "vue-property-decorator"
import { TunnelInfoData } from '@/types/views/TunnelInfo.interface'
import { Collapse } from 'view-design'
import Panel from 'view-design/src/components/collapse/panel.vue'

Vue.component('Collapse', Collapse)
Vue.component('Panel', Panel)

@Component({})
export default class About extends Vue {

    // data
    data: TunnelInfoData = {
        value: '1',
        tunnelInfoSur: [
            { 
				id: "1", 
				tunnelName: '古城大街', 
				tunnelLength: '3.68', 
				beginLocal: 'XXXX', 
				endLocal: 'XXXX', 
				storeNum: '36', 
				areaNum: '56' 
			},
            { 
				id: "2", 
				tunnelName: '经二路', 
				tunnelLength: '3.68', 
				beginLocal: 'XXXX', 
				endLocal: 'XXXX', 
				storeNum: '36', 
				areaNum: '56' 
			},
            { 
				id: "3", 
				tunnelName: '经三路', 
				tunnelLength: '3.68', 
				beginLocal: 'XXXX', 
				endLocal: 'XXXX', 
				storeNum: '36', 
				areaNum: '56' 
			}
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
