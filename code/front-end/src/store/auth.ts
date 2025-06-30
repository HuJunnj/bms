import { ref } from 'vue'
import { defineStore } from 'pinia'
import type { UserInfo } from "../model/user.ts";

export const useAuthStore = defineStore('auth', () => {
    const isLoggedIn = ref(false)
    const user = ref<UserInfo>({
        token: null,
        username: null,
        role: null
    })

    function login(userData: UserInfo) {
        isLoggedIn.value = true
        user.value = userData
    }

    // 登出方法
    function logout() {
        isLoggedIn.value = false
        user.value = {} as UserInfo
    }
    return { isLoggedIn, user, login, logout }
})