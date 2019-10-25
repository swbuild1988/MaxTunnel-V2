<template>
    <div class="TunnelIntroduction-wrap">
        <div class="imgBG-wrap">
            <img :src="tunnelIntroductIMG" />
        </div>
        <Button class="btn-return" type="primary">返回</Button>
        <div class="page-title" :style="{background: 'url('+ pageTitleIMG +') 100% 100% no-repeat', backgroundSize: '40% 100%', backgroundPositionX: 'center'}">
            管廊简介
        </div>
        <!-- 管廊简介 -->
        <div class="tunnel-collapse-wrap" :style="{background: 'url('+ tunnelCollapseIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
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
        <!-- 廊内设备统计 -->
        <div class="equipment-statistics-wrap" :style="{background: 'url('+ tunnelCollapseIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
            <div class="title">
                <img :src="guideIcon" class="guide-icon" />
                廊内设备统计：
            </div>
            <section class="equipment-statistics-info-wrap">
                <div class="explain">
                    <img :src="equipmentIcon" />
                    晋源东区一共有设备{{totalEquipment}}个：
                </div>
                <div class="equipment-statistics-info" >
                    <div v-for="(item, index) in EData" :key="index">
                        {{index+1}}、{{item.eKey}}：{{item.eVal}}个
                    </div>
                </div>
            </section>
        </div>
        <!-- 时间 -->
        <div class="time-wrap" :style="{background: 'url('+timeIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
            <div class="hms-wrap">
                <img :src="timeIcon">
                {{Day.nowTime}}
            </div>
            <div class="ymd-wrap">
                {{Day.nowDate}}{{Day.nowWeek}}
            </div>
            <div class="safe-operat-wrap">
                系统已安全运行&nbsp;<span class="safe-days">{{Day.safeOperatDay}}</span>&nbsp;天
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./TunnelIntroduction.ts"></script>

<style lang="less">
    @import './TunnelIntroduction.less';
</style>

