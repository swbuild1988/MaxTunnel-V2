// PlanManage.Data 参数类型
export interface PlanManageData {
    model: number,
    planInfo: any
}

export interface TotalNumData {
    totalNormalNum: number,
    totalUnNormalNum: number,
    totalHiddenNum: number,
    totalRepairNum: number,
    totalOtherNum: number
}

export interface SimulateSpeed {
    model: number,
    speedOption: any
}

// VUEX PlanManage.State 参数类型
export interface PlanManageState {
    author?: string
}

// GET_DATA_ASYN 接口参数类型
// export interface DataOptions {}

