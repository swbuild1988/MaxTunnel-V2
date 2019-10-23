<template>
    <div class="TunnelIntroduction-wrap">
        <div class="imgBG-wrap">
            <img :src="tunnelIntroductIMG" />
        </div>
        <Button class="btn-return" type="primary">返回</Button>
        <div class="page-title"
            :style="{background: 'url('+ pageTitleIMG +') 100% 100% no-repeat', backgroundSize: '40% 100%', backgroundPositionX: 'center'}"
        >管廊简介</div>
        <div class="tunnel-collapse-wrap"
            :style="{background: 'url('+ tunnelCollapseIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}"
        >
            <div class="title">
                <img :src="guideIcon" class="guide-icon" />
                管廊简介：
            </div>
            <Collapse v-model="TData.value" accordion>
                <Panel :name=item.val v-for="(item, index) in TData.tunnelInfo" :key="index">
                    <span>
                        <img :src="tunnelIcon" />
                        {{ item.tunnelName }}
                    </span>
                    <div class="details-wrap" slot="content">
                        介绍：<span>{{item.introduction}}</span>
                    </div>
                </Panel>
            </Collapse>
        </div>
    </div>
</template>

<script lang="ts" src="./TunnelIntroduction.ts"></script>

<style lang="less">
    @import './TunnelIntroduction.less';
</style>

