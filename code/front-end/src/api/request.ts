import axios from 'axios'

const request = axios.create({
    baseURL: '/bms',
    timeout: 5000,
})

// 请求拦截器
request.interceptors.request.use(config => {
    // 添加 token 示例（按需启用）
    const token = localStorage.getItem('token')
    if (token) {
        config.headers.Authorization = `${token}` //
    }
    return config
})

// 响应拦截器
request.interceptors.response.use(
    response => {
       return  response
    },
    error => Promise.reject(error)
)

export default request
