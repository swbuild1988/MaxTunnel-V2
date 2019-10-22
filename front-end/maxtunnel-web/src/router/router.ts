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
        redirect: '/BV/projectSurvey/tunnelInfo'
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
        component: (resolve: any) => require(["@/views/BM/ProjectSurvey/TunnelInfo/TunnelInfo.vue"], resolve),
    },
    {
        path: '/BV/BIM/bim',
        name: '大屏信息展示-BIM',
        // component: () => import('@/views/BM/ProjectSurvey/TunnelInfo/TunnelInfo.vue')
        component: (resolve: any) => require(["@/views/BM/BIM/bim/bim.vue"], resolve),
    } 
]