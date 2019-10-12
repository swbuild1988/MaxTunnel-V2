<template>
	<div id="app">
		111
		<keep-alive>
            <router-view v-if="$route.meta.keepAlive"/>
        </keep-alive>
        <router-view v-if="!$route.meta.keepAlive"/>
		<Button>121212</Button>
        <div class="theme-wrap">
            <p @click="changeTheme(1)"></p>
            <p @click="changeTheme(2)"></p>
            <p @click="changeTheme(3)"></p>
        </div>
	</div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator"
import { Button, Table } from 'view-design'
Vue.component('Button', Button);
Vue.component('Table', Table);
@Component({})
export default class About extends Vue {

    mounted() { 
        this.defaultTheme()
    }

    // 改变主题
    changeTheme(num: number) {
        (document.getElementById('app') as HTMLDivElement).className = 'theme' + num;
        localStorage.setItem('appTheme', (document.getElementById('app') as HTMLDivElement).className)
    }

    // 页面初始化选择主题进行加载
    defaultTheme() {
        if (localStorage.getItem('appTheme')) {
            (document.getElementById('app') as HTMLDivElement).className = (localStorage.getItem('appTheme') as string)
        } else {
            this.changeTheme(1)
        }
    }
}
</script>

<style lang="less">
.theme-wrap {
    position: absolute;
    top: 0;
    right: 0;
    z-index: 999;
    p {
        width: 10px;
        height: 10px;
        border-radius: 10px;
        display: inline-block;
        margin-right: 2px;
    }
}
p:first-child {
    background-color: red;
}
p:nth-child(2) {
    background-color: #652BF5;
}
p:last-child {
    background-color: deepskyblue;
}
</style>
