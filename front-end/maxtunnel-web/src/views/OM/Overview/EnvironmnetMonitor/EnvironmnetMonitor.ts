import { Component, Vue, Watch } from "vue-property-decorator"
import { EnvironmnetMonitorData, SecurityMonitorData } from '@/types/views/EnvironmnetMonitor.interface'
import { Collapse, Button } from 'view-design'
import Panel from 'view-design/src/components/collapse/panel.vue'
import { EnvironmentMonitorService } from '@/services/environmentMonitor.ts'
import BrokenLine from '@/components/BrokenLine/BrokenLine.vue'
import { init } from 'echarts'

Vue.component('Collapse', Collapse)
Vue.component('Panel', Panel)
Vue.component('Button', Button)

@Component({
    components: { BrokenLine }
})
export default class About extends Vue {

    environmnetMonitorIMG: string = require("@/assets/images/BV/tunnel-bg.png")
    collapseIMG: string = require("@/assets/images/BV/env-info-bg.png") 
    titleIMG: string = require("@/assets/images/BV/info-title.png")
    pageTitleIMG: string = require("@/assets/images/BV/page-title-bg.png")
    environmentSpotIMG: string = require("@/assets/images/BV/spot-bg.png")
    tunnelIcon: string = require("@/assets/images/BV/tunnel-icon.png")

    // data
    data: EnvironmnetMonitorData = {
        pageName: 'environmnetMonitor',
    }
    
    EMData: EnvironmnetMonitorData = {
        value: '1',
        environmnetMonitorInfo: [
            {
                id: 1,
                tunnelKey: '1',
                tunnelName: '古城大街',
                isNormal: true,
                tunnelEnvInfo: [
                    { dataTypeID: "1-1", keyEnv: '温度', minVal: -20, maxVal: 30, unitName: '℃', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "1-2", keyEnv: '湿度', minVal: 2, maxVal: 100, unitName: '%RH', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "1-3", keyEnv: '氧气', minVal: 0, maxVal: 10, unitName: '%', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "1-4", keyEnv: '甲烷', minVal: 0, maxVal: 36, unitName: 'LEF', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "1-5", keyEnv: '硫化氢', minVal: 1, maxVal: 6, unitName: 'ppm', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "1-6", keyEnv: '一氧化碳', minVal: 0, maxVal: 12, unitName: 'ppm', isNormalMin: false, isNormalMax: false }
                ]
            },
            {
                id: 2,
                tunnelKey: '2',
                tunnelName: '实验路',
                isNormal: true,
                tunnelEnvInfo: [
                    { dataTypeID: "2-1", keyEnv: '温度', minVal: -2, maxVal: 30, unitName: '℃', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "2-2", keyEnv: '湿度', minVal: 5, maxVal: 56, unitName: '%RH', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "2-3", keyEnv: '氧气', minVal: 17, maxVal: 20, unitName: '%', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "2-4", keyEnv: '甲烷', minVal: 0, maxVal: 36, unitName: 'LEF', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "2-5", keyEnv: '硫化氢', minVal: 1, maxVal: 6, unitName: 'ppm', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "2-6", keyEnv: '一氧化碳', minVal: 0, maxVal: 12, unitName: 'ppm', isNormalMin: false, isNormalMax: false }
                ]
            },
            {
                id: 3,
                tunnelKey: '3',
                tunnelName: '经二路',
                isNormal: true,
                tunnelEnvInfo: [
                    { dataTypeID: "3-1", keyEnv: '温度', minVal: -20, maxVal: 30, unitName: '℃', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "3-2", keyEnv: '湿度', minVal: 2, maxVal: 56, unitName: '%RH', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "3-3", keyEnv: '氧气', minVal: 0, maxVal: 10, unitName: '%', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "3-4", keyEnv: '甲烷', minVal: 0, maxVal: 36, unitName: 'LEF', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "3-5", keyEnv: '硫化氢', minVal: 1, maxVal: 6, unitName: 'ppm', isNormalMin: false, isNormalMax: false },
                    { dataTypeID: "3-6", keyEnv: '一氧化碳', minVal: 0, maxVal: 12, unitName: 'ppm', isNormalMin: false, isNormalMax: false }
                ]
            }
        ]
        
    }
    SEData: SecurityMonitorData = {
        value: '1',
        securityMonitorInfo: [
            // {
            //     id: 1,
            //     tunnelKey: '1',
            //     tunnelName: '古城大街',
            //     isNormal: true,
            //     tunnelSecInfo: [
            //         { dataTypeID: '1-1', keySec: '井盖', workKey: '开', workVal: 20, noWorKey: '关', noWorkVal: 10, faultKey: '故障', faultVal: 10 },
            //         { dataTypeID: '1-2', keySec: '联动', workKey: '开', workVal: 6, noWorKey: '关', noWorkVal: 3, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '1-3', keySec: '红外', workKey: '触发', workVal: 6, noWorKey: '未触发', noWorkVal: 3, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '1-4', keySec: '声光报警', workKey: '开', workVal: 6, noWorKey: '关', noWorkVal: 3, faultKey: '故障', faultVal: 10 }
            //     ]
            // },
            // {
            //     id: 2,
            //     tunnelKey: '2',
            //     tunnelName: '实验路',
            //     isNormal: true,
            //     tunnelSecInfo: [
            //         { dataTypeID: '2-1', keySec: '井盖', workKey: '开', workVal: 20, noWorKey: '关', noWorkVal: 10, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '2-2', keySec: '联动', workKey: '开', workVal: 6, noWorKey: '关', noWorkVal: 3, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '2-3', keySec: '红外', workKey: '触发', workVal: 6, noWorKey: '未触发', noWorkVal: 3, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '2-4', keySec: '声光报警', workKey: '开', workVal: 6, noWorKey: '关', noWorkVal: 3, faultKey: '故障', faultVal: 0 }
            //     ]
            // },
            // {
            //     id: 3,
            //     tunnelKey: '3',
            //     tunnelName: '经三路',
            //     isNormal: true,
            //     tunnelSecInfo: [
            //         { dataTypeID: '3-1', keySec: '井盖', workKey: '开', workVal: 20, noWorKey: '关', noWorkVal: 10, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '3-2', keySec: '联动', workKey: '开', workVal: 6, noWorKey: '关', noWorkVal: 3, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '3-3', keySec: '红外', workKey: '触发', workVal: 6, noWorKey: '未触发', noWorkVal: 3, faultKey: '故障', faultVal: 0 },
            //         { dataTypeID: '3-4', keySec: '声光报警', workKey: '开', workVal: 6, noWorKey: '关', noWorkVal: 3, faultKey: '故障', faultVal: 2 }
            //     ]
            // }
        ]
    }

    SpotData: any[] = [
        { spotKey: '温度', spotVal: '30℃' },
        { spotKey: '湿度', spotVal: '13%RH' },
        { spotKey: '氧气', spotVal: '13%' },
        { spotKey: '甲烷', spotVal: '36LEL' },
        { spotKey: '硫化氢', spotVal: '3ppm' },
        { spotKey: '一氧化碳', spotVal: '3ppm' }
    ]

    canvasPos: any = {
        position: 'absolute',
        left: '',
        top: ''
    }

    isWithCanvas: boolean = false

    objType: any[] = [
        { id: 1, typeName: '温度', normalMin: -15, mormalMax: 40 },
        { id: 2, typeName: '湿度', normalMin: 5, normalMax: 95 },
        { id: 3, typeName: '氧气', normalMin: 15, normalMax: 28 },
        { id: 5, typeName: '甲烷', normalMin: 0, normalMax: 50 },
        { id: 4, typeName: '硫化氢', normalMin: 0, normalMax: 50 },
        { id: 6, typeName: '一氧化碳', normalMin: 0, normalMax: 100 }
    ]
    
    getMousePos(event: any) {             
        let e = event || window.event;  
        let c = document.getElementsByTagName('canvas')[0] as HTMLCanvasElement
        let widthNum = 100
        let heightNum = 100
        let dot = 8
        c.setAttribute('height', heightNum + 'px')
        c.setAttribute('width', widthNum + 'px')
        c.style.left = e.pageX + 'px'
        c.style.top = e.pageY + 'px'
        let ctx = c.getContext("2d") as CanvasRenderingContext2D;
        // 绘制点
        ctx.beginPath();
        // 绘制定点
        ctx.arc(widthNum / 2, dot, dot, 0, 2 * Math.PI)
        ctx.strokeStyle = "#00f0ff";
        ctx.fillStyle = "#00f0ff";
        ctx.fill();
        ctx.stroke();
        ctx.closePath();
        // 绘制折线
        ctx.beginPath();
        // 折线开始位置
        ctx.moveTo(widthNum / 2, dot);
        // 第一个折
        ctx.lineTo( dot, heightNum / 2 );
        // 第二个折
        ctx.lineTo( dot, heightNum )
        ctx.lineWidth = 2;
        ctx.strokeStyle = "#00f0ff";
        ctx.stroke();
        ctx.closePath();
        this.isWithCanvas = true
        let s = document.getElementsByClassName('spot-wrap')[0] as HTMLDivElement
        s.style.left = Number(e.pageX) - 100 + 'px'
        s.style.top = Number(e.pageY) + Number(heightNum) + 'px'
    }
    
    mounted() {
        EnvironmentMonitorService.getSecurityData().then(
            (result: any) => {
                result.forEach((item: any) => {
                    item.tunnelSecInfo.forEach((a: any) => {
                        if (a.faultVal !== 0) {
                            item.isNormal = false
                        } else {
                            item.isNormal = true

                        }
                    })
                });
                this.SEData.securityMonitorInfo = result
            },
            (error: any) => {
                console.log(error)
            }
        )
        this.init()
    }
    
    init() {
        (this.EMData.environmnetMonitorInfo as any[]).forEach((item: any) => {
            item.tunnelEnvInfo.forEach((tep: any) => {
                (this.objType as any[]).forEach((a: any) => {
                    if (tep.keyEnv === a.typeName) {
                        if (tep.maxVal > a.normalMax || tep.maxVal < a.normalMin) {
                            tep.isNormalMax = true
                            item.isNormal = false
                        }
                        if (tep.minVal < a.normalMin || tep.minVal > a.normalMax) {
                            tep.isNormalMin = true
                            item.isNormal = false
                        }
                    }
                })
            })
        })
    }
}
