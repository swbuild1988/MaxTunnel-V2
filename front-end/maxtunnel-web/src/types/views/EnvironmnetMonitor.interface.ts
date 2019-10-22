// environmnetMonitor.Data 参数类型
export interface EnvironmnetMonitorData {
    pageName?: string,
    environmnetMonitorInfo?: any[],
    value?: string
}

export interface SecurityMonitorData {
    securityMonitorInfo?: any[],
    value?: string
}

// VUEX environmnetMonitor.State 参数类型
export interface EnvironmnetMonitorState {
    author?: string
}

// GET_DATA_ASYN 接口参数类型
// export interface DataOptions {}

