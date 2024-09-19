<template>
  <div>
    <div class="forget_view">
      <el-form :model="forgetForm" class="forget_box">
        <div class="forget_title">
          基于Web的交通旅游订票系统{{
            pageType == 1 ? '找回密码' : pageType == 2 ? '输入密保' : '重置密码'
          }}
        </div>
        <div class="tab_view">
          <div
            class="header_number"
            :class="
              pageType > 1
                ? 'header_number2'
                : pageType == 1
                ? 'header_number1'
                : ''
            "
          >
            <div class="number" v-if="pageType < 2">1</div>
            <div class="number" v-else>
              <el-icon><Check /></el-icon>
            </div>
          </div>
          <div
            class="header_number"
            :class="
              pageType > 2
                ? 'header_number2'
                : pageType == 2
                ? 'header_number1'
                : ''
            "
          >
            <div class="number" v-if="pageType < 3">2</div>
            <div class="number" v-else>
              <el-icon><Check /></el-icon>
            </div>
          </div>
          <div
            class="header_number"
            :class="pageType == 3 ? 'header_number1' : ''"
          >
            <div class="number">3</div>
          </div>
        </div>
      </el-form>
    </div>
  </div>
</template>
<script setup>
import { ref, getCurrentInstance, nextTick } from 'vue'
const context = getCurrentInstance()?.appContext.config.globalProperties
const pageType = ref(1)
const forgetForm = ref({})
const userForm = ref({})
//返回登录
const close = () => {
  context?.$router.push({
    path: '/login',
  })
}
</script>

<style lang="scss" scoped>
.forget_view {
  background-repeat: no-repeat;
  flex-direction: column;
  background-size: cover;
  background: url(http://localhost:8080/transportationTicket/file/67e7bc0be6f14fe6964350c99487b3c7.jpg);
  display: flex;
  min-height: 100vh;
  justify-content: center;
  align-items: center;
  position: relative;
  background-position: center center;
  // 表单盒子
  .forget_box {
    border-radius: 0px;
    padding: 0 0 0 600px;
    margin: 0;
    background: url(http://localhost:8080/transportationTicket/file/5333a9813e004bb8a7463aa34fcb11e1.jpg)
      no-repeat left center / 600px 100%;
    display: block;
    width: 1200px;
    min-height: 600px;
    justify-content: center;
    align-items: flex-start;
    flex-wrap: wrap;
    // 标题
    .forget_title {
      padding: 0 0 30px;
      margin: 0 0 0 120px;
      color: #3f3f3f;
      background: none;
      width: calc(100% - 120px);
      font-size: 24px;
      text-align: center;
    }
    // tab
    // 盒子
    .tab_view {
      border: 0px solid #ddd;
      padding: 4px 0;
      margin: 0 0 30px 120px;
      background: none;
      display: flex;
      width: calc(100% - 120px);
      align-items: center;
      // 默认样式
      .header_number {
        display: flex;
        width: 100%;
        font-size: 24px;
        justify-content: center;
        align-items: center;
        .number {
          border: 4px solid #ddd;
          border-radius: 50%;
          color: #aaa;
          display: flex;
          width: 40px;
          justify-content: center;
          align-items: center;
          height: 40px;
        }
      }
      // 当前样式
      .header_number1 {
        .number {
          margin: 0 30px;
          color: #27bacc;
          background: #fff;
          width: 40px;
          font-size: 30px;
          border-color: #27bacc;
          height: 40px;
        }
      }
      // 完成样式
      .header_number2 {
        .number {
          color: rgba(0, 170, 0, 1);
          border-color: rgba(0, 170, 0, 1);
        }
      }
    }
    // item
    .list_item {
      margin: 10px auto 30px;
      display: flex;
      width: 100%;
      justify-content: flex-start;
      align-items: center;
      // label
      .item_label {
        width: 120px;
        font-size: 14px;
        box-sizing: border-box;
        text-align: right;
      }
      // 输入框
      :deep(.list_inp) {
        border: 1px solid #ddd;
        border-radius: 20px;
        padding: 0 10px;
        width: calc(100% - 120px);
        line-height: 40px;
        box-sizing: border-box;
        height: 40px;
        //去掉默认样式
        .el-input__wrapper {
          border: none;
          box-shadow: none;
          background: none;
          border-radius: 0;
          height: 100%;
          padding: 0;
        }
        .is-focus {
          box-shadow: none !important;
        }
      }
      //下拉框样式
      :deep(.list_sel) {
        border: 1px solid #ddd;
        border-radius: 20px;
        padding: 0 10px;
        background: #fff;
        width: calc(100% - 120px);
        line-height: 40px;
        box-sizing: border-box;
        //去掉默认样式
        .select-trigger {
          height: 100%;
          .el-input {
            height: 100%;
            .el-input__wrapper {
              border: none;
              box-shadow: none;
              background: none;
              border-radius: 0;
              height: 100%;
              padding: 0;
            }
            .is-focus {
              box-shadow: none !important;
            }
          }
        }
      }
    }
    // 按钮盒子
    .list_btn {
      margin: 30px 0 0;
      display: flex;
      width: 100%;
      justify-content: center;
      align-items: center;
      flex-wrap: wrap;
      // 获取密保
      :deep(.el-button--success) {
        border: 0;
        cursor: pointer;
        border-radius: 20px;
        padding: 0 30px;
        margin: 0 0px 0 120px;
        outline: none;
        color: #fff;
        background: #27bacc;
        width: calc(100% - 120px);
        font-size: 14px;
        height: 40px;
      }
      // 获取密保悬浮
      :deep(.el-button--success:hover) {
        opacity: 0.8;
      }
      // 确认密保
      :deep(.el-button--primary) {
        border: 0;
        cursor: pointer;
        border-radius: 20px;
        padding: 0 30px;
        margin: 0 0px 0 120px;
        outline: none;
        color: #fff;
        background: #27bacc;
        width: calc(100% - 120px);
        font-size: 14px;
        height: 40px;
      }
      // 确认密保悬浮
      :deep(.el-button--primary:hover) {
      }
      // 重置密码
      :deep(.el-button--warning) {
        border: 0;
        cursor: pointer;
        border-radius: 20px;
        padding: 0 30px;
        margin: 0 0px 0 120px;
        outline: none;
        color: #fff;
        background: #27bacc;
        width: calc(100% - 120px);
        font-size: 14px;
        height: 40px;
      }
      // 重置密码悬浮
      :deep(.el-button--warning:hover) {
      }
      .r-login {
        cursor: pointer;
        padding: 0;
        margin: 20px 0 0 120px;
        color: #999;
        width: calc(100% - 120px);
        font-size: 14px;
        text-align: right;
      }
    }
  }
}
</style>
