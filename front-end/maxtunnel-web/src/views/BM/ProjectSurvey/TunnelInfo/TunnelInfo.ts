import { Component, Vue } from "vue-property-decorator"
import { TunnelInfoData, BrokenLineData } from '@/types/views/TunnelInfo.interface'
import { Collapse, Button } from 'view-design'
import Panel from 'view-design/src/components/collapse/panel.vue'
import BrokenLine from '@/components/BrokenLine/BrokenLine.vue'
import { TunnelInfoService } from '@/services/tunnelInfoService.ts'

Vue.component('Collapse', Collapse)
Vue.component('Panel', Panel)
Vue.component('Button', Button)

@Component({
	components: {
		BrokenLine
	}
})
export default class About extends Vue {

	// data
	data: TunnelInfoData = {
		value: "1",
		tunnelInfoSur: []
	}

	brokenLineData: BrokenLineData = {
		dot: 4,
		x: 200,
		y: 100,
		lineColor: "#118AC9"
	}

	created() {
		this.init()	
		
	}
	// mounted() {	
	// 	this.init()
	// }

	init() {
		TunnelInfoService.getTunnelInfo().then(
			(result: any) => {
				this.data.tunnelInfoSur = result
			},
			(error: any) => {
				console.log(error)
			}
		)
	}
}
