import { Component, Vue } from "vue-property-decorator"
import { TunnelInfoData, BrokenLineData } from '@/types/views/TunnelInfo.interface'
import { Collapse } from 'view-design'
import Panel from 'view-design/src/components/collapse/panel.vue'
import BrokenLine from '@/components/BrokenLine/BrokenLine.vue'

Vue.component('Collapse', Collapse)
Vue.component('Panel', Panel)

@Component({
	components: {
		BrokenLine
	}
})
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
			},
			{
				id: "4",
				tunnelName: '实验路',
				tunnelLength: '5.2',
				beginLocal: 'XXXX',
				endLocal: 'VVVV',
				storeNum: '15',
				areaNum: '42'
			}
		]
	}

	brokenLineData: BrokenLineData = {
		dot: 4,
		x: 500,
		y: 100,
		lineColor: "#118AC9"
	}
}
