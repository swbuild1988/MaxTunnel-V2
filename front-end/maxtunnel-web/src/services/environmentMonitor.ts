import { get, post, del, put } from '@/utils/http.ts';
const EnvironmentMonitorService = {
    getSecurityData() {
        return new Promise((resolve, reject) => {
            get('http://localhost:8080/data/securityInfoData.json').then((res: any) => {
                let data = res.data
                resolve(data)  
            })
        })
    }
}
export {
    EnvironmentMonitorService
}