import { Component, Vue } from "vue-property-decorator"
import { BimData } from '@/types/views/bim.interface'
import Bim from "@/components/bim/bim.vue" // 组件

@Component({
    components: {
        Bim
    }
})
export default class About extends Vue {

    // data
    data: BimData = {
        pageName: 'bim'
    }

    mounted() {
        //
    }

    // 初始化函数
    init() {
        //
    }
    
}
