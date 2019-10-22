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
        redirect: '/OM/operatManage'
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
        path: '/BV/BIM/bim',
        name: '大屏信息展示-BIM',
        // component: () => import('@/views/BM/ProjectSurvey/TunnelInfo/TunnelInfo.vue')
        component: (resolve: any) => require(["@/views/BM/BIM/bim/bim.vue"], resolve),
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
            }
        ]
    }   
]