// TunnelInfo.Data 参数类型
export interface TunnelInfoData {
    value: string,
    tunnelInfoSur: any[]
}

// VUEX TunnelInfo.State 参数类型
export interface TunnelInfoState {
    author?: string
}

export interface BrokenLineData {
    id?: string | number
    dot?: number,
    x?: number,
    y?: number,
    lineColor?: string
}

// GET_DATA_ASYN 接口参数类型
// export interface DataOptions {}

