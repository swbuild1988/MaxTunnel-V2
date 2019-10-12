import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import "@/assets/less/common.less";
import "@/assets/less/theme.less";
import echarts from 'echarts';
import 'amfe-flexible';
import 'iview/dist/styles/iview.css';

Vue.prototype.$echarts = echarts;
Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
