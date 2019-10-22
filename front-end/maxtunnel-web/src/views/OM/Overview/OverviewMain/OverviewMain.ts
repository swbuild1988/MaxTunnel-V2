import { Component, Vue } from "vue-property-decorator"
import { OverviewMainData } from '@/types/views/OverviewMain.interface'


@Component({})
export default class About extends Vue {

    backgroundIMG = require('@/assets/images/BV/main-bg.png')

    // data
    data: OverviewMainData = {
        pageName: 'OverviewMain'
    }

    mounted() {
        //
    }

    // 初始化函数
    init() {
        //
    }
    
}
