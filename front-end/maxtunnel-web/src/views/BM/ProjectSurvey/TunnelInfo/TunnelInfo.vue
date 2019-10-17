<template>
    <div class="TunnelInfo-wrap">
        <div class="collapse-wrap">
            <Collapse v-model="data.value" accordion>
                <Panel :name=item.id v-for="(item, index) in data.tunnelInfoSur" :key="index">
                    {{ item.tunnelName }}
                    <p slot="content">
                        介绍：长{{ item.tunnelLength }}公里，
                    </p>
                    <p slot="content">
                        开始至{{ item.beginLocal }}，结束至{{ item.endLocal }}，
                    </p>
                    <p slot="content">
                        廊内有管舱{{ item.storeNum }}个，区间{{ item.areaNum }}个
                    </p>
                </Panel>
            </Collapse>
        </div>
        <BrokenLine :brokenLineData = "brokenLineData" />
    </div>
</template>

<script lang="ts" src="./TunnelInfo.ts"></script>

<style lang="less">
    @import './TunnelInfo.less';
</style>

