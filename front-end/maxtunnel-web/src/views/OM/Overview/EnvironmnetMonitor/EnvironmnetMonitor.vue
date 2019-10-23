<template>
    <div class="environmnetMonitor-wrap">
        <div class="imgBG-wrap">
            <img :src="environmnetMonitorIMG" />
        </div>
        <Button class="btn-return" type="primary">返回</Button>
        <div class="page-title"
            :style="{background: 'url('+ pageTitleIMG +') 100% 100% no-repeat', backgroundSize: '40% 100%', backgroundPositionX: 'center'}"
        >环境监测</div>
        <div class="env-collapse-wrap">
            <div class="title" :style="{background: 'url('+ titleIMG + ') no-repeat', backgroundPositionX: 'center'}">环境监测</div>
            <Collapse v-model="EMData.value" accordion :style="{background: 'url('+ collapseIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
                <Panel :name=item.tunnelKey v-for="(item, index) in EMData.environmnetMonitorInfo" :key="index">
                    <span>
                        <img :src="tunnelIcon" />
                        {{ item.tunnelName }}
                        <Button type="primary" class="status-btn" v-show="item.isNormal===true">正常</Button>
                        <Button type="error" class="status-btn" v-show="item.isNormal===false">故障</Button>
                    </span>
                    <div class="details-wrap" slot="content" v-for="tep in item.tunnelEnvInfo" :key="tep.dataTypeID">
                        <div class="details">{{ tep.keyEnv }}</div>
                        <div class="details" :class="{'unNormal': tep.isNormalMin}">{{ tep.minVal }}{{ tep.unitName }}</div>
                        <div class="details" :class="{'unNormal': tep.isNormalMax}">{{ tep.maxVal }}{{ tep.unitName }}</div>
                    </div>
                </Panel>
            </Collapse>
        </div>
        <div class="sec-collapse-wrap">
            <div class="title" :style="{background: 'url('+ titleIMG + ') no-repeat', backgroundPositionX: 'center'}">安防监测</div>
            <Collapse v-model="SEData.value" accordion :style="{background: 'url('+ collapseIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
                <Panel :name=item.tunnelKey v-for="(item, index) in SEData.securityMonitorInfo" :key="index">
                    <span>
                        <img :src="tunnelIcon" />
                        {{ item.tunnelName }}
                        <Button type="error" class="status-btn" v-show="item.isNormal===false">故障</Button>
                        <Button type="primary" class="status-btn" v-show="item.isNormal===true">正常</Button>
                    </span>
                    <div class="details-wrap" slot="content" v-for="tep in item.tunnelSecInfo" :key="tep.dataTypeID">
                        <div class="details">{{ tep.keySec }}</div>
                        <div class="details">
                            <div>{{ tep.workKey }}：</div>
                            <div>{{ tep.workVal }}</div>
                        </div>
                        <div class="details noWork">
                            <div>{{ tep.noWorKey }}：</div>
                            <div>{{ tep.noWorkVal }}</div>
                        </div>
                        <div class="details fault">    
                            <div>{{ tep.faultKey }}：</div>
                            <div>{{ tep.faultVal }}</div>
                        </div>
                    </div>
                </Panel>
            </Collapse>
        </div>
        <canvas class="canvas-wrap"></canvas>
        <div class="showTunnelEnv"  @click="getMousePos"></div>
        <div v-show="isWithCanvas" class="spot-wrap" :style="{background: 'url('+ environmentSpotIMG +') 100% 100% no-repeat', backgroundSize: '100% 100%'}">
            <div class="spot-line-wrap" v-for="(item ,index) in SpotData" :key="index">
                <div>{{item.spotKey}}</div>
                <div>{{item.spotVal}}</div>
            </div>
        </div>
    </div>
</template>

<script lang="ts" src="./EnvironmnetMonitor.ts"></script>

<style lang="less">
    @import './EnvironmnetMonitor.less';
</style>

