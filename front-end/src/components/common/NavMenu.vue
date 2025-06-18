<template>
  <div class="nav-container">
    <el-menu
      :default-active="activeIndex"
      class="nav-menu"
      mode="horizontal"
      background-color="#2c3e50"
      text-color="#f0f5f9"
      active-text-color="#42b983"
      @select="handleSelect"
    >
      
      <el-menu-item index="1">
        <el-icon><HomeFilled /></el-icon>
        <span>主页</span>
      </el-menu-item>
      
      <el-sub-menu index="2">
        <template #title>
          <el-icon><Grid /></el-icon>
          <span>示例一</span>
        </template>
        <el-menu-item index="2-1">
          <el-icon><Document /></el-icon>
          <span>1</span>
        </el-menu-item>
        <el-menu-item index="2-2">
          <el-icon><Calendar /></el-icon>
          <span>2</span>
        </el-menu-item>
        <el-menu-item index="2-3">
          <el-icon><Star /></el-icon>
          <span>3</span>
        </el-menu-item>
        <el-sub-menu index="2-4">
          <template #title>
            <el-icon><Setting /></el-icon>
            <span>4</span>
          </template>
          <el-menu-item index="2-4-1">1.1</el-menu-item>
          <el-menu-item index="2-4-2">1.2</el-menu-item>
          <el-menu-item index="2-4-3">1.3</el-menu-item>
        </el-sub-menu>
      </el-sub-menu>
      
      <el-menu-item index="3" disabled>
        <el-icon><Lock /></el-icon>
        <span>敬请期待</span>
      </el-menu-item>
      
      <el-menu-item index="4">
        <el-icon><QuestionFilled /></el-icon>
        <span>帮助</span>
      </el-menu-item>
    </el-menu>
      
      <div class="settings-container" @click="toggleSettingsSidebar">
      <div class="settings-button-inner">
        <el-icon><Setting /></el-icon>
        <span>设置</span>
      </div>
    </div>
    
    
    <div class="logout-container" @click="showLogoutDialog" :class="{ 'logout-pulse': showPulse }">
      <div class="logout-button-inner">
        <el-icon><SwitchButton /></el-icon>
        <span>登出</span>
      </div>
    </div>
  </div>
  
<!-- 登出的弹窗相关 -->
  <el-dialog
    v-model="logoutDialogVisible"
    width="360px"
    class="logout-dialog"
    center
    :destroy-on-close="true"
  >
    <div class="logout-dialog-content">
      <el-icon class="logout-icon"><WarningFilled /></el-icon>
      <span>确定要退出登录吗？</span>
    </div>
    
    <template #footer>
      <div class="dialog-footer">
        <el-button 
          @click="cancelLogout" 
          class="cancel-btn"
          :plain="true"
        >
          取消
        </el-button>
        <el-button 
          type="danger" 
          @click="handleLogout" 
          class="confirm-btn"
          :loading="logoutLoading"
        >
          确认
        </el-button>
      </div>
    </template>
  </el-dialog>
  
  <!-- 设置侧栏相关 -->
  <div class="settings-sidebar" :class="{ 'open': settingsSidebarVisible }">
    <div class="settings-sidebar-header">
      <h2>设置</h2>
      <el-button 
        @click="toggleSettingsSidebar" 
        class="close-sidebar-btn" 
        :icon="Close" 
        circle
      />
    </div>
    <!-- 这里是设置侧栏相关 -->
    <div class="settings-sidebar-content">
      <el-divider content-position="left">界面设置</el-divider>
      
      <div class="settings-item">
        <span>主题模式</span>
        <el-switch
          v-model="darkMode"
          active-text="深色"
          inactive-text="浅色"
          @change="changeTheme"
        />
      </div>
      
      <div class="settings-item">
        <span>字体大小</span>
        <el-slider
          v-model="fontSize"
          :min="12"
          :max="20"
          :step="1"
          show-stops
        />
      </div>
      
      <el-divider content-position="left">通知设置</el-divider>
      
      <div class="settings-item">
        <span>消息通知</span>
        <el-switch v-model="notifications" />
      </div>
      
      
      
      <el-divider content-position="left">个性化</el-divider>
      
      <div class="settings-item">
        <el-button type="primary" @click="saveSettings">保存设置</el-button>
      </div>
    </div>
  </div>
  

  <!-- 遮罩层，点击时关闭侧栏 -->
  <div 
    class="sidebar-overlay" 
    v-show="settingsSidebarVisible" 
    @click="toggleSettingsSidebar"
  ></div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { 
  WarningFilled, 
  SwitchButton, 
  HomeFilled, 
  Grid, 
  Document, 
  Calendar, 
  Star, 
  Setting, 
  Lock, 
  QuestionFilled,
  Close
} from '@element-plus/icons-vue'
import { ElMessage } from 'element-plus'

const activeIndex = ref('1')
const logoutDialogVisible = ref(false)
const logoutLoading = ref(false)
const showPulse = ref(false)

// 设置侧栏状态
const settingsSidebarVisible = ref(false)

// 设置选项
const darkMode = ref(false)
const fontSize = ref(14)
const notifications = ref(true)

// 初始化时添加按钮动画效果
onMounted(() => {
  setTimeout(() => {
    showPulse.value = true
    setTimeout(() => {
      showPulse.value = false
    }, 2000)
  }, 3000)
})

const handleSelect = (key, keyPath) => {
  console.log(key, keyPath)
}

// 显示登出弹窗框
const showLogoutDialog = () => {
  logoutDialogVisible.value = true
}

// 取消登出
const cancelLogout = () => {
  logoutDialogVisible.value = false
}

// 处理登出逻辑
const handleLogout = () => {
  logoutLoading.value = true
  
  // 模拟登出过程
  setTimeout(() => {
    // 这里实现登出逻辑
    console.log('用户已登出')
    
    // 关闭对话框
    logoutLoading.value = false
    logoutDialogVisible.value = false
  }, 600)
}

// 切换设置侧栏显示状态
const toggleSettingsSidebar = () => {
  settingsSidebarVisible.value = !settingsSidebarVisible.value
}

// 切换主题
const changeTheme = (value) => {
  console.log('主题切换为:', value ? '深色' : '浅色')
  // 这里实现主题切换逻辑
}

// 保存设置
const saveSettings = () => {
  ElMessage({
    message: '设置已保存',
    type: 'success',
    duration: 2000
  })
}
</script>

<style>
.nav-container {
  position: relative;
  display: flex;
  align-items: center;
  background-color: #2c3e50;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.15);
}

/* 菜单样式 */
.el-menu {
  margin-top: 0;
  font-size: 16px;
  border-right: none !important;
  flex-grow: 1;
  box-shadow: none;
  border-bottom: none !important;
}

.el-menu--horizontal > .el-menu-item,
.el-menu--horizontal > .el-sub-menu .el-sub-menu__title {
  height: 60px;
  line-height: 60px;
  padding: 0 20px;
  border-bottom: 2px solid transparent;
  transition: all 0.3s;
}

.el-menu--horizontal > .el-menu-item.is-active,
.el-menu--horizontal > .el-sub-menu.is-active .el-sub-menu__title {
  border-bottom: 2px solid #42b983;
  color: #42b983 !important;
  font-weight: 500;
}

.el-menu--horizontal > .el-menu-item:hover,
.el-menu--horizontal > .el-sub-menu:hover .el-sub-menu__title {
  background-color: rgba(255, 255, 255, 0.08) !important;
  color: #ffffff !important;
}

.el-menu--horizontal .el-menu .el-menu-item, 
.el-menu--horizontal .el-menu .el-sub-menu__title {
  background-color: #ffffff;
  color: #303133;
}

.el-menu--horizontal .el-menu .el-menu-item:hover, 
.el-menu--horizontal .el-menu .el-sub-menu__title:hover {
  background-color: #f5f7fa;
}

.el-menu--horizontal .el-menu .el-menu-item.is-active {
  color: #42b983;
}

.el-menu-item [class^="el-icon-"],
.el-sub-menu [class^="el-icon-"] {
  vertical-align: middle;
  margin-right: 5px;
  width: 24px;
  text-align: center;
}

.el-menu-item .el-icon,
.el-sub-menu .el-icon {
  vertical-align: middle;
  margin-right: 8px;
  width: 18px;
  font-size: 18px;
}

.el-menu--horizontal .el-menu--popup {
  min-width: 160px;
  padding: 8px 0;
  border-radius: 4px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.el-menu--popup .el-menu-item {
  height: 40px;
  line-height: 40px;
  font-size: 14px;
  padding: 0 16px;
}

/* 登出按钮容器 */
.logout-container {
  height: 60px;
  position: relative;
  cursor: pointer;
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  overflow: hidden;
  border-left: 1px solid rgba(255, 255, 255, 0.08);
}

.logout-button-inner {
  height: 100%;
  display: flex;
  align-items: center;
  padding: 0 22px;
  color: #f0f5f9;
  font-size: 16px;
  font-weight: 500;
  gap: 8px;
  background-color: transparent;
  transition: all 0.3s;
}

.logout-container:hover .logout-button-inner {
  color: #ff6b6b;
  background-color: rgba(255, 255, 255, 0.08);
}

.logout-container:active .logout-button-inner {
  transform: scale(0.96);
}

.logout-container::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 50%;
  width: 0;
  height: 3px;
  background: linear-gradient(90deg, #ff9a9e 0%, #fad0c4 99%, #fad0c4 100%);
  transition: all 0.3s ease;
  opacity: 0;
}

.logout-container:hover::after {
  width: 100%;
  left: 0;
  opacity: 1;
}

/* 登出按钮脉冲动画 */
@keyframes pulse {
  0% {
    box-shadow: 0 0 0 0 rgba(255, 107, 107, 0.4);
  }
  70% {
    box-shadow: 0 0 0 10px rgba(255, 107, 107, 0);
  }
  100% {
    box-shadow: 0 0 0 0 rgba(255, 107, 107, 0);
  }
}

.logout-pulse {
  animation: pulse 1.5s infinite;
}

.logout-container .el-icon {
  font-size: 18px;
  transition: transform 0.3s;
}

.logout-container:hover .el-icon {
  transform: rotate(180deg);
}

/* 弹窗样式 */
.logout-dialog :deep(.el-dialog) {
  border-radius: 12px;
  overflow: hidden;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  max-width: 90%;
}

.logout-dialog :deep(.el-dialog__header) {
  display: none;
}

.logout-dialog :deep(.el-dialog__body) {
  padding: 30px 24px 20px;
}

.logout-dialog :deep(.el-dialog__footer) {
  padding: 0 24px 24px;
  border-top: none;
}

.logout-dialog-content {
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 12px;
  font-size: 16px;
  margin-bottom: 10px;
}

.logout-icon {
  font-size: 22px;
  color: #f56c6c;
}

.dialog-footer {
  display: flex;
  justify-content: center;
  gap: 16px;
  width: 100%;
}

.cancel-btn {
  width: 90px;
  border-radius: 6px;
  transition: all 0.2s;
}

.confirm-btn {
  width: 90px;
  border-radius: 6px;
  transition: all 0.2s;
  background-color: #f56c6c;
  border-color: #f56c6c;
}

.confirm-btn:hover {
  background-color: #f78989;
  border-color: #f78989;
}

/* 设置侧栏样式 */
.settings-sidebar {
  position: fixed;
  top: 0;
  left: -320px;
  width: 320px;
  height: 100vh;
  background-color: #fff;
  box-shadow: 2px 0 8px rgba(0, 0, 0, 0.15);
  z-index: 2000;
  overflow-y: auto;
  transition: left 0.3s ease;
}

.settings-sidebar.open {
  left: 0;
}

.settings-sidebar-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px 20px;
  border-bottom: 1px solid #ebeef5;
  background-color: #f8f8f8;
}

.settings-sidebar-header h2 {
  margin: 0;
  font-size: 18px;
  font-weight: 600;
  color: #303133;
}

.close-sidebar-btn {
  padding: 6px;
}

.settings-sidebar-content {
  padding: 20px;
}

.settings-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
  padding: 10px 0;
}

.sidebar-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.3);
  z-index: 1999;
  transition: opacity 0.3s ease;
}

/* 深色模式样式（为后续实现主题切换做准备） */
.dark-mode .settings-sidebar {
  background-color: #1e1e1e;
  color: #f0f0f0;
  border-color: #333;
}

.dark-mode .settings-sidebar-header {
  background-color: #2c2c2c;
  border-color: #333;
}

.dark-mode .settings-sidebar-header h2 {
  color: #f0f0f0;
}

.el-divider {
  margin: 20px 0;
}


/* 设置按钮样式 */
.settings-container {
  height: 60px;
  position: relative;
  cursor: pointer;
  transition: all 0.3s cubic-bezier(0.25, 0.8, 0.25, 1);
  overflow: hidden;
  border-left: 1px solid rgba(255, 255, 255, 0.08);
}

.settings-button-inner {
  height: 100%;
  display: flex;
  align-items: center;
  padding: 0 22px;
  color: #f0f5f9;
  font-size: 16px;
  font-weight: 500;
  gap: 8px;
  background-color: transparent;
  transition: all 0.3s;
}

.settings-container:hover .settings-button-inner {
  color: #42b983;
  background-color: rgba(255, 255, 255, 0.08);
}

.settings-container:active .settings-button-inner {
  transform: scale(0.96);
}

.settings-container::after {
  content: '';
  position: absolute;
  bottom: 0;
  left: 50%;
  width: 0;
  height: 3px;
  background: linear-gradient(90deg, #42b983 0%, #8fd3b6 99%, #8fd3b6 100%);
  transition: all 0.3s ease;
  opacity: 0;
}

.settings-container:hover::after {
  width: 100%;
  left: 0;
  opacity: 1;
}

.settings-container .el-icon {
  font-size: 18px;
  transition: transform 0.3s;
}

.settings-container:hover .el-icon {
  transform: rotate(90deg);
}

</style>