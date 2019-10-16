import { Component, Vue } from "vue-property-decorator"
import { LoginData, LoginInfo } from '@/types/views/Login.interface'
import { Button, Form, FormItem, Input } from 'view-design'
Vue.component('Button', Button);
Vue.component('Form', Form);
Vue.component('FormItem', FormItem)
Vue.component('Input', Input)

@Component({})
export default class About extends Vue {

    // data
    data: LoginData = {
        pageName: 'Login'
    }
    loginInfo: LoginInfo = {
        username: '',
        password: ''
    }

    login() {
        this.$router.push('/BV/projectSurvey/tunnelInfo')
    }
    
}
