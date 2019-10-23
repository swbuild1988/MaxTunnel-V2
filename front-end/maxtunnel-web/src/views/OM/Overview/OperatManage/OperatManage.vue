<template>
    <div class="OperatManage-wrap">
        <div class="imgBG-wrap">
            <img :src="operatManageIMG" />
        </div>
        <Button class="btn-return" type="primary">返回</Button>
        <div class="page-title"
            :style="{background: 'url('+ pageTitleIMG +') 100% 100% no-repeat', backgroundSize: '40% 100%', backgroundPositionX: 'center'}"
        >运营管理</div>
        <div class="energy-statistics-wrap"
            :style="{background: 'url('+ energyStatisticsIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}"
        >
            <div class="title">
                <img :src="guideIcon" class="guide-icon" />
                能耗统计
            </div>
            <div style="height: 435px">
                <MultiLine id='energyLine':data='energyLineData' />
            </div>
        </div>
        <div class="customer-wrap"
            :style="{background: 'url('+ customerIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}"
        >
            <div class="title">
                <img :src="guideIcon" class="guide-icon" />
                客户信息
            </div>
            <div class="customer-info-wrap">
                <div class="customer-title">
                    <div>公司名称</div>
                    <div>管线数</div>
                </div>
                <section>
                    <div class="customer-info" v-for="(item, index) in data.customerInfo" :key="index">
                        <div>{{item.customerName}}</div>
                        <div>{{item.pipeNum}}</div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./OperatManage.ts"></script>

<style lang="less">
    @import './OperatManage.less';
</style>

