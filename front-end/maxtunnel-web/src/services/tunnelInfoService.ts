import { get, post, del, put } from '@/utils/http.ts'
const TunnelInfoService = {
    getTunnelInfo() {
        return new Promise((resolve, reject) => {
            get('http://localhost:8080/data/tunnelInfoData.json').then((res: any) => {
                let data = res.data
                resolve(data)          
                // let { code, data, msg } = res.data
                // if ( code === 200 ) {
                //     resolve( data )
                // } else {
                //     reject( msg + "地址：http://localhost:8080/data/tunnelInfoData.json" )
                // }
            })
        })
    }
}
export {
    TunnelInfoService
}