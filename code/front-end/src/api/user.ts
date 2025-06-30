import request from './request'

export function login(data: { username: string; password: string }) {
    // 这里模拟请求，实际项目替换接口地址和请求方法
    return request.post('/login', data)
}
