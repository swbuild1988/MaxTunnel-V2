import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import echarts from 'echarts';
import 'amfe-flexible';
import '@/assets/less/common.less';
import '@/assets/less/theme.less';
import 'view-design/dist/styles/iview.css';
import '@/utils/common.ts'

// Vue.use(formatDate)

// 将方法挂载到Vue原型上
// Vue.prototype.get = get;
// Vue.prototype.post = post;
// Vue.prototype.del = del;
// Vue.prototype.put = put;

Vue.prototype.$echarts = echarts;
Vue.config.productionTip = false;

async function main_init() {
    console.log("------------开始初始化------------")
    try {
        return "success"
    } catch (error) {
        throw new Error(error)
    }
}

main_init().then( res => {
    new Vue({
        router,
        store,
        render: (h) => h(App),
    }).$mount('#app');
} ).catch(err => {
    console.log("初始化异常", err)
})

console.log("main.ts运行结束")

