import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import echarts from 'echarts';
import 'amfe-flexible';
import '@/assets/less/common.less';
import '@/assets/less/theme.less';
import 'view-design/dist/styles/iview.css';

// 将方法挂载到Vue原型上
// Vue.prototype.get = get;
// Vue.prototype.post = post;
// Vue.prototype.del = del;
// Vue.prototype.put = put;

Vue.prototype.$echarts = echarts;
Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount('#app');
