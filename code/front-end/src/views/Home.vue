<template>
  <el-container class="layout-container-demo" >
    <el-header>
      <div class="title" style="width: 200px; height: 100%; display: flex; justify-content: center; align-items: center;background-color: #0e0e35d1;"> 融资租赁业务管理系统 </div>
      <div class="toolbar">
        <el-dropdown>
          <el-icon style="margin-right: 6px; margin-top: 1px">
            <UserCircleIcon class="w-10 h-10 text-green-600"  />
          </el-icon>
          <template #dropdown>
            <el-dropdown-menu>
              <el-dropdown-item  @click="showProfile">个人中心</el-dropdown-item>
              <el-dropdown-item>布局设置</el-dropdown-item>
              <el-dropdown-item @click="logout">退出登录</el-dropdown-item>
            </el-dropdown-menu>
          </template>
        </el-dropdown>
        <span>{{auth.user.username}}</span>
      </div>
    </el-header>
    <!-- 个人中心弹窗 -->
    <el-dialog
        v-model="profileVisible"
        title="个人中心"
        width="30%"
    >
      <el-descriptions :column="1" border>
        <el-descriptions-item label="用户名">{{auth.user.username}}</el-descriptions-item>
        <el-descriptions-item label="角色">{{auth.user.role}}</el-descriptions-item>
      </el-descriptions>
      <template #footer>
        <el-button @click="profileVisible = false">关闭</el-button>
      </template>
    </el-dialog>
    <el-container>
      <el-aside width="200px">
        <el-scrollbar>
          <el-menu :default-openeds="['1']">
            <el-sub-menu index="1">
              <template #title>
                <el-icon><HomeIcon /></el-icon>首页
              </template>
              <el-menu-item index="1-1">Option 1</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon><BuildingOfficeIcon /></el-icon>我的办公
              </template>
              <el-menu-item-group>
                <template #title>Group 1</template>
                <el-menu-item index="2-1">Option 1</el-menu-item>
                <el-menu-item index="2-2">Option 2</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="Group 2">
                <el-menu-item index="2-3">Option 3</el-menu-item>
              </el-menu-item-group>
              <el-sub-menu index="2-4">
                <template #title>Option 4</template>
                <el-menu-item index="2-4-1">Option 4-1</el-menu-item>
              </el-sub-menu>
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>
                <el-icon><UsersIcon /></el-icon>客户管理
              </template>
            </el-sub-menu>
            <el-sub-menu index="4">
              <template #title>
                <el-icon><BookOpenIcon /></el-icon>项目管理
              </template>
            </el-sub-menu>
            <el-sub-menu index="5">
              <template #title>
                <el-icon><CalculatorIcon /></el-icon>清算管理
              </template>
            </el-sub-menu>
            <el-sub-menu index="6">
              <template #title>
                <el-icon><CreditCardIcon /></el-icon>贷后管理
              </template>
            </el-sub-menu>
            <el-sub-menu index="7">
              <template #title>
                <el-icon><Bars4Icon /></el-icon>流程菜单
              </template>
            </el-sub-menu>
            <el-sub-menu index="8">
              <template #title>
                <el-icon><EyeIcon /></el-icon>历史流程
              </template>
            </el-sub-menu>
            <el-sub-menu index="9">
              <template #title>
                <el-icon><AdjustmentsHorizontalIcon /></el-icon>配置管理
              </template>
            </el-sub-menu>
            <el-sub-menu index="10">
              <template #title>
                <el-icon><Cog8ToothIcon /></el-icon>系统管理
              </template>
            </el-sub-menu>
            <el-sub-menu index="11">
              <template #title>
                <el-icon><ComputerDesktopIcon /></el-icon>系统监控
              </template>
            </el-sub-menu>
            <el-sub-menu index="12">
              <template #title>
                <el-icon><WrenchScrewdriverIcon /></el-icon>系统工具
              </template>
            </el-sub-menu>
          </el-menu>
        </el-scrollbar>
      </el-aside>
      <el-main>
      </el-main>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>

import {UserCircleIcon, HomeIcon, BuildingOfficeIcon, UsersIcon, BookOpenIcon, ComputerDesktopIcon, CreditCardIcon, Bars4Icon, CalculatorIcon, EyeIcon, AdjustmentsHorizontalIcon ,WrenchScrewdriverIcon, Cog8ToothIcon } from '@heroicons/vue/24/solid'
import { useRouter } from 'vue-router'
import { useAuthStore } from "../store/auth.js";
import {ref} from "vue";
const auth = useAuthStore()
const router = useRouter()

const profileVisible = ref(false)
// 显示个人中心
const showProfile = () => {
  profileVisible.value = true
}
function logout() {
  auth.logout()
  router.push('/login')
}
</script>

<style scoped>
.layout-container-demo .el-header {
  background: #304156;
  color: white;
  position: relative;
  padding-left: 0;
  display: flex;
  justify-content: space-between; /* 两边对齐 */
  align-items: center;            /* 垂直居中（可选） */
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  .el-menu {
    border-right: none;
    background-color: transparent;
    .el-sub-menu {
      background-color: #304156;
    }
  }
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
  right: 20px;
}
</style>
