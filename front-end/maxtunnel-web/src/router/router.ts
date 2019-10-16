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
        component: () => import('@/views/VM/Login/Login/Login.vue')
    },
    {
        path: '/BV/projectSurvey/tunnelInfo',
        name: '大屏信息展示-管廊信息',
        component: () => import('@/views/BM/ProjectSurvey/TunnelInfo/TunnelInfo.vue')
    }   
]