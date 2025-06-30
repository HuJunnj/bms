<template>
  <el-config-provider>
    <router-view />
  </el-config-provider>
</template>

<script setup lang="ts">
// 无需引入 Home.vue，Vue Router 会根据路径自动加载视图组件
</script>

<style>
/* 可添加全局样式 */
body {
  margin: 0;
  font-family: 'Helvetica Neue', sans-serif;
}
</style>