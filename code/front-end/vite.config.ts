// vite.config.ts
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'

export default defineConfig({
  base: './',
  build: {
    outDir: '../back-end/src/main/resources/static', // 相对于项目根目录的路径
    emptyOutDir: true, // 构建前清空输出目录
  },
  server: {
    proxy: {
      '/bms': {
        target: 'http://localhost:8080', // 后端地址
        changeOrigin: true
      }
    }
  },
  plugins: [vue()],
  resolve: {
    alias: {
      '@': path.resolve(__dirname, 'src'),
    },
  },
})
