import { resolve } from 'url';

/**
 * meta 可配置参数
 * @param {boolean} icon 页面icon
 * @param {boolean} keepAlive 是否缓存页面
 * @param {string} title 页面标题
 */
export default [
    {
        path: '/',
        redirect: '/OM/PlanManage'
    },
    {
        path: '/login',
        name: 'login',
        // component: () => import('@/views/VM/Login/Login/Login.vue')
        component: (resolve: any) => require(["@/views/VM/Login/Login/Login.vue"], resolve)
    },
    {
        path: '/BV/projectSurvey/tunnelInfo',
        name: '大屏信息展示-管廊信息',
        // component: () => import('@/views/BM/ProjectSurvey/TunnelInfo/TunnelInfo.vue')
        component: (resolve: any) => 
            require(["@/views/BM/ProjectSurvey/TunnelInfo/TunnelInfo.vue"], resolve),
    },
    {
        path: '/OM',
        name: 'OM',
        component: (resolve: any) => 
            require(["@/views/OM/Overview/OverviewMain/OverviewMain.vue"], resolve),
        children: [
            {
                path: '/OM/environment',
                name: '环境监测',
                component: (resolve: any) => 
                    require(["@/views/OM/Overview/EnvironmnetMonitor/EnvironmnetMonitor.vue"], resolve)
            },
            {
                path: '/OM/operatManage',
                name: '运营管理',
                component: (resolve: any) => 
                    require(["@/views/OM/Overview/OperatManage/OperatManage.vue"], resolve)
            },
            {
                path: '/OM/tunnelIntroduct',
                name: '管廊简介',
                component: (resolve: any) => 
                    require(["@/views/OM/Overview/TunnelIntroduction/TunnelIntroduction.vue"], resolve) 
            },
            {
                path: '/OM/PlanManage',
                name: '预案管理',
                component: (resolve: any) => 
                    require(["@/views/OM/Overview/PlanManage/PlanManage.vue"], resolve) 
            }
        ]
    }   
]