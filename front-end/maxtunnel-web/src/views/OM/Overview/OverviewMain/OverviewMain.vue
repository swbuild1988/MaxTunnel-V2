<template>
    <div class="OverviewMain-wrap"
        :style="{background: 'url('+ backgroundIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}"
    >
    <router-view />
    </div>
</template>

<script lang="ts" src="./OverviewMain.ts"></script>

<style lang="less">
    @import './OverviewMain.less';
</style>

