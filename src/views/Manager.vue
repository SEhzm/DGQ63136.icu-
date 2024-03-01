<template>
  <div>
    <div
        style="height: 55px; background-color: #fff; display: flex; align-items: center; border-bottom: 1px solid #ddd">
      <div style="flex: 1">
        <div style="padding-left: 20px; display: flex; align-items: center">

          <a class="index-logo-text" href="https://www.douyu.com/63136" target="_blank" style="color: #ff552e;">
            <img src="@/assets/imgs/logo.png" alt="大狗头" style="width: 35px ; margin-top: -1px">
            DY63136共享厕纸
          </a>
          
          <div style="display: flex; justify-content: flex-end;margin-left: auto;">
           
            <a href="https://yuba.douyu.com/user/main/lOdEpeOJzwnR" target="_blank">
              <img src="@/assets/imgs/douyu.jpg" alt="douyu" style="margin-right: 15px;">
            </a>
            <a href="https://github.com/SEhzm/DGQ63136.icu-" target="_blank">
              <img src="@/assets/imgs/github.png" alt="github" style="margin-right: 15px;">
            </a>
            <a href="https://www.123pan.com/s/wwFKjv-4RijH.html" target="_blank">
              <img src="https://img.alicdn.com/tfs/TB1qEwuzrj1gK0jSZFOXXc7GpXa-32-32.ico" alt="支持我求求了~~"
                   style="margin-right: 15px;">
            </a>
          </div>
        </div>
      </div>
    </div>

    <div style="display: flex">
      <div style="width: auto; border-right: 0px solid #ddd; min-height: calc(100vh - 60px)">
        <el-menu
            router
            style="border: none;margin-right: auto;"
            :default-active="$route.path"
            :default-openeds="['/home', '2']"
            :collapse="isCollapse"
        >
        <el-button type="primary" @click="toggleCollapse" style="margin-top: 10px;align-content: center;">折叠</el-button>
          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>首页</span>
          </el-menu-item>

          <el-sub-menu index="2">
            <template #title>
              <el-icon>
                <notebook/>
              </el-icon>
              <span>警钟长鸣</span>
            </template>
            
            <el-menu-item index="/JZCM">    <!-- ====一级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px;">
              <span>全部警钟长鸣</span>
            </el-menu-item>

            <el-menu-item index="/2022">    <!-- ====二级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px;">
              <span>2022年警钟长鸣</span>
            </el-menu-item>

            <el-menu-item index="/2023">    <!-- ====三级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px;">
              <span>2023年警钟长鸣</span>
            </el-menu-item>
            <el-menu-item index="/2024">    <!-- ====四级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px;">
              <span>2024年警钟长鸣</span>
            </el-menu-item>
          </el-sub-menu>

          <el-menu-item index="/interesting"> 
              <el-icon>
                <Sugar/>
              </el-icon>
              <span>一些有趣的弹幕</span>
            </el-menu-item>

          <el-menu-item index="/XTT">
            <el-icon>
              🏃 
            </el-icon>
            <span>小团体</span>
          </el-menu-item>

          <el-menu-item index="/DGQ">
              <img src="@/assets/imgs/dog.png" alt="DGQ" style="height: 18px; margin-right: 10px;">
            <span> DGQ</span>
          </el-menu-item>

          <el-menu-item index="/baizi">
            <el-icon>
              <User/>
            </el-icon>
            <span>白字</span>
          </el-menu-item>

          <el-menu-item index="l+1">
            <el-icon>
              <plus/>
            </el-icon>
            <span>+1弹幕</span>
          </el-menu-item>

          <el-menu-item index="/QUQU">
              <img src="@/assets/imgs/Z.png" alt="Z!!" style="height: 18px;">
            <span>QUQU弹幕</span>
          </el-menu-item>

        </el-menu>
        <div class="her">
          <el-row class="mb-4">
            <el-button type="primary" @click="complaintButton">
              建议/提交BUG
            </el-button>
          </el-row>
        </div>
      </div>
      <div style="flex: 1; width: 0; background-color: #f8f8ff; padding: 10px">
        <router-view/>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  methods: {
    complaintButton() {
      window.open("https://www.wjx.cn/vm/QmBulzI.aspx# ");
    },
  },
  data() {
            return {
                isCollapse: false
            }
        },
        
methods: {
    toggleCollapse () {
        this.isCollapse = !this.isCollapse
    }
},
};



</script>


<script setup>
import {useRoute} from 'vue-router'

const $route = useRoute()
console.log($route.path)

</script>

<style scoped>
.index-logo-text {
  font-weight: bold;
  font-size: 30px;
  margin-left: -5px;
  height: auto;
}


.el-menu-item.is-active {
  background-color: #dcede9 !important;
}

.el-menu-item:hover {
  color: #11A983;
}



.her {
  position: relative;
  display: inline-block;
  position:fixed;
  left:30px;
  /*bottom:0px;*/
  height:50px;
  
}


</style>