<template>
	<div id="app">
		<keep-alive>
            <router-view v-if="$route.meta.keepAlive"/>
        </keep-alive>
        <router-view v-if="!$route.meta.keepAlive"/>
        <div class="theme-wrap">
            <p class="theme-option theme-option-1" @click="changeTheme(1)"></p>
            <p class="theme-option theme-option-2" @click="changeTheme(2)"></p>
            <p class="theme-option theme-option-3" @click="changeTheme(3)"></p>
        </div>
	</div>
</template>

<script lang="ts">
import { Component, Vue } from "vue-property-decorator"

@Component({})
export default class About extends Vue {

    mounted() { 
        this.defaultTheme()
    }

    // 改变主题
    changeTheme(num: number) {
        (document.body as HTMLDivElement).className = 'theme' + num;
        localStorage.setItem('appTheme', (document.body as HTMLDivElement).className)
    }

    // 页面初始化选择主题进行加载
    defaultTheme() {
        if (localStorage.getItem('appTheme')) {
            (document.body as HTMLDivElement).className = (localStorage.getItem('appTheme') as string)
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
    .theme-option {
        width: 10px;
        height: 10px;
        border-radius: 10px;
        display: inline-block;
        margin-right: 2px;
    }
}
.theme-option-1 {
    background-color: red;
}
.theme-option-2 {
    background-color: #652BF5;
}
.theme-option-3 {
    background-color: deepskyblue;
}
</style>
