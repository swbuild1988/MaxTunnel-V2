import { Component, Vue } from "vue-property-decorator"
import { LoginData } from '@/types/views/Login.interface'
// import {  } from "@/components" // 组件

@Component({})
export default class About extends Vue {

    // data
    data: LoginData = {
        pageName: 'Login'
    }

    mounted() {
        //
    }

    // 初始化函数
    init() {
        //
    }
    
}
