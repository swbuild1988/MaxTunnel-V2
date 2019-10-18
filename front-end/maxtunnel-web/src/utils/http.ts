import axios from 'axios'

// 创建axios
const axios_instance = axios.create({
    headers: {
        'Content-Type': 'application/json;charset=utf-8'
    }
})

// request 拦截器
axios_instance.interceptors.request.use(
    (config: any) => {
        if (localStorage.getItem('TOKEN_KEY')) {
            let key = 'Authorization'
            config.headers.common[key] = localStorage.getItem('TOKEN_KEY')
        }
        return config
    },
    (error: any) => {
        Promise.reject( error )
    }
)
// response 拦截器
axios_instance.interceptors.response.use(
    (response: any) => {
        const res = response.data
        if (response.status !== 200) {
            if (res.code === 50008 || res.code === 50012) {
                console.log("调用接口后台返回错误")
            }
        } else {
            if (res.code === 503) {
                console.log("用户未登录")
            } else {
                return response
            }
        }
    },
    (error: any) => {
        return Promise.reject(error)
    }
)

export default axios_instance;

/**
 * get : 请求
 * @param url
 */
export function get( url: string, arraybuffer?: any ) {
    if ( arraybuffer ) {
        return new Promise((resolve, reject) => {
            axios_instance({
                method: 'get',
                url: url,
                responseType: arraybuffer
            })
                .then( response => resolve(response) )
                .catch(err => reject(err))
        })
    } else {
        return new Promise((resolve, reject) => {
            axios_instance.get(url)
                .then( response => resolve(response) )
                .catch(err => reject(err))
        })
    }
}

// export function getUrl( url: string ) {
//     return new Promise((resolve, reject) => {
//         axios_instance.get(url)
//             .then( response => resolve(response) )
//             .catch(err => reject(err))
//     })
// }

/**
 * post : 请求
 * @param url
 * @param data
 */
export function post( url: string, data: any ) {
    return new Promise((resolve, reject) => {
        axios_instance.post(url, data)
            .then( response => resolve( response ) )
            .catch( err => reject( err ) )
    })
}

export function del( url: string ) {
    return new Promise((resolve, reject) => {
        axios_instance.delete(url)
            .then( response => resolve (response) )
            .catch( err => reject( err ) )
    })
}

export function put( url: string, data: any ) {
    return new Promise((resolve, reject) => {
        axios_instance.put(url, data)
            .then( response => resolve( response ) )
            .catch( err => reject( err )  )
    })
}
