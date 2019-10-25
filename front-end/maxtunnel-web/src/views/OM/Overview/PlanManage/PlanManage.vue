<template>
    <div class="PlanManage-wrap">
        <div class="imgBG-wrap">
            <img :src="planManageIMG" />
        </div>
        <Button class="btn-return" type="primary">返回</Button>
        <div class="page-title" :style="{background: 'url('+ pageTitleIMG +') 100% 100% no-repeat', backgroundSize: '40% 100%', backgroundPositionX: 'center'}">
            预案管理
        </div>
        <!-- 告警统计 -->
        <div class="alarm-statistics-wrap" :style="{background: 'url('+ alarmStatisticsIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
            <div class="title">
                <img :src="guideIcon" class="guide-icon" />
                告警统计：
            </div>
            <div class="details-wrap">
                <div class="details-title">
                    <div>类型</div>
                    <div>正常</div>
                    <div>故障</div>
                    <div>隐患</div>
                    <div>维修</div>
                    <div>其他</div>
                </div>
                <div class="details-info-wrap">
                    <div class="details-info" v-for="(item, index) in AData" :key="index">
                        <div>{{item.eKey}}</div>
                        <div>{{item.normalNum}}</div>
                        <div>{{item.unNormalNum}}</div>
                        <div>{{item.hiddenNum}}</div>
                        <div>{{item.repairNum}}</div>
                        <div>{{item.otherNum}}</div>
                    </div>
                </div>
                <div class="details-total">
                    <div>总计</div>
                    <div>{{TotalNum.totalNormalNum}}</div>
                    <div>{{TotalNum.totalUnNormalNum}}</div>
                    <div>{{TotalNum.totalHiddenNum}}</div>
                    <div>{{TotalNum.totalRepairNum}}</div>
                    <div>{{TotalNum.totalOtherNum}}</div>
                </div>
            </div>
        </div>  
        <div class="simulate-plan-wrap" :style="{background: 'url('+ alarmStatisticsIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
            <div class="title">
                <img :src="guideIcon" class="guide-icon" />
                模拟预案：
            </div>
            <section class="load-plan-wrap">
                <div class="title">加载预案</div>
                <Select v-model="PData.model">
                    <Option v-for="(item, index) in PData.planInfo" :key="index" :value="item.id">{{item.planName}}</Option>
                </Select>
                <div class="load-plan-details">
                    加载预案
                </div>
            </section>
            <section class="plan-simulate-wrap">
                <div class="title">预案模拟</div>
                <ButtonGroup>
                    <Button 
                        v-for="(item, index) in btnInfo" 
                        :key="index"
                        class="plan-simulate-btn" 
                        @click="choosedActivited(index)"
                        :class="{'active': activatedBtn === index}"  
                    >
                        {{item.btnContent}}
                    </Button>
                </ButtonGroup>
                <div class="simulate-speed">
                    模拟速度：
                    <Select v-model="SPData.model">
                        <Option v-for="(item, index) in SPData.speedOption" :key="index" :value="item.id">{{item.speed}}</Option>
                    </Select>
                </div>
            </section>
        </div>  
    </div>
</template>

<script lang="ts" src="./PlanManage.ts"></script>

<style lang="less">
    @import './PlanManage.less';
</style>

