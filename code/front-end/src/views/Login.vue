<template>
  <el-card class="login-card">
    <h2 class="title">登录</h2>
    <el-form :model="form" :rules="rules" ref="loginForm" label-position="top">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="form.username" placeholder="请输入用户名" />
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input
            v-model="form.password"
            type="password"
            placeholder="请输入密码"
            show-password
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitLogin" style="width: 100%">
          登录
        </el-button>
      </el-form-item>
    </el-form>
  </el-card>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { login } from '../api/user'
import { useAuthStore } from '../store/auth.ts'
const auth = useAuthStore()
const router = useRouter()
const loginForm = ref()
const form = reactive({
  username: '',
  password: '',
})

const rules = {
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
}

function submitLogin() {
  loginForm.value.validate(async (valid: boolean) => {
    if (!valid) return

    try {
      // 模拟登录请求
      const res = await login(form)
      if (res.data.code !== 200) {
        ElMessage.error(res.data.message)
        return
      }
      ElMessage.success('登录成功！')
      auth.login(res.data.data)
      router.push('/home')
    } catch (error) {
      ElMessage.error('登录失败，请检查用户名和密码')
    }
  })
}
</script>

<style scoped>
.login-card {
  width: 360px;
  margin: 100px auto;
  padding: 40px 30px;
  border-radius: 16px;
  box-shadow: 0 12px 24px rgb(0 0 0 / 0.1);
  background-color: #fff;
}
.title {
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 24px;
  text-align: center;
}
</style>
