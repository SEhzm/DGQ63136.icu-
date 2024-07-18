<template>
  <div>
    <div style="
				height: 55px;
				background-color: #fff;
				display: flex;
				align-items: center;
				border-bottom: 1px solid #ddd;
			">
      <div style="flex: 1">
        <div style="
						padding-left: 20px;
						display: flex;
						align-items: center;
					">
          <a href="https://www.douyu.com/63136" target="_blank" style="display: block; width: 370px;height: 50px;">
            <img src="https://pic.imgdb.cn/item/6607ee8f9f345e8d03ae3a77.png" alt="大狗头"
                 style="height: 40px; float: left; margin: 5px;"/>

            <p style="color: #ff552e;font-size: 35px;align-items: center;">斗鱼63136弹幕收集</p>
          </a>
          <div style="
							display: flex;
							justify-content: flex-end;
							margin-left: auto;
						">

            <el-button type="primary" @click="complaintButton"
                       style="margin-right: 10px"><span>上传照片<br>建议/提交BUG</span></el-button>
            <a href="https://gitee.com/hzming1/dgq63136-vue3-springboot" target="_blank">
              <img src="@/assets/imgs/gitee.png" alt="gitee" style="width: 31px;margin-right: 15px"/>
            </a>
            <a href="https://yuba.douyu.com/user/main/lOdEpeOJzwnR" target="_blank">
              <img src="@/assets/imgs/douyu.jpg" alt="douyu" style="margin-right: 15px"/>
            </a>
            <a href="https://github.com/SEhzm/DGQ63136.icu-" target="_blank">
              <img src="@/assets/imgs/github.png" alt="github" style="margin-right: 15px"/>
            </a>

            <div class="demo-image__preview">
              <el-image style="
									width: 31px;
									height: 31px;
									margin-right: 15px;
									border-radius: 5px;
								" :src="url" :zoom-rate="1.2" :max-scale="7" lazy :min-scale="0.2" :preview-src-list="['zfb.jpg']"
                        :initial-index="4" fit="cover"/>
            </div>
            <div class="demo-image__preview">
              <el-image style="
									width: 31px;
									height: 31px;
									margin-right: 15px;
									border-radius: 5px;
								" :src="wxurl" :zoom-rate="1.2" lazy :max-scale="7" :min-scale="0.2" :preview-src-list="['wx.jpg']"
                        :initial-index="4" fit="cover"/>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div style="display: flex">
      <div style="
					width: auto;
					border-right: 0px solid #ddd;
					min-height: calc(100vh - 60px);
				">
        <el-menu router style="border: none; margin-right: auto" :default-active="$route.path"
                 :default-openeds="['/home', '2']" :collapse="isCollapse">
          <el-button type="primary" @click="toggleCollapse" style="
							margin-top: 2%;
							align-content: center;
							width: 96%;
							margin-left: 2%;
						">折叠
          </el-button>

          <el-menu-item index="/home">
            <el-icon>
              <HomeFilled/>
            </el-icon>
            <span>首页</span>
          </el-menu-item>

          <el-menu-item index="/AllBarrage">
            <el-icon>
              <List/>
            </el-icon>
            <span>全部弹幕</span>
          </el-menu-item>

          <el-menu-item index="/image">
            <el-icon>
              <Camera/>
            </el-icon>
            <span>时光相册</span>
          </el-menu-item>

          <el-sub-menu index="2">
            <template #title>
              <el-icon>
                <notebook/>
              </el-icon>
              <span>警钟长鸣</span>
            </template>

            <el-menu-item index="/JZCM">
              <!-- ====一级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px"/>
              <span>全部警钟长鸣</span>
            </el-menu-item>

            <el-menu-item index="/2022">
              <!-- ====二级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px"/>
              <span>2022年警钟长鸣</span>
            </el-menu-item>

            <el-menu-item index="/2023">
              <!-- ====三级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px"/>
              <span>2023年警钟长鸣</span>
            </el-menu-item>
            <el-menu-item index="/2024">
              <!-- ====四级长鸣==== -->
              <img src="@/assets/imgs/jz.jpg" alt="警钟" style="height: 18px"/>
              <span>2024年警钟长鸣</span>
            </el-menu-item>
          </el-sub-menu>

          <!-- <el-menu-item index="/interesting"> 
              <el-icon>
                <Sugar/>
              </el-icon>
              <span>一些有趣的弹幕</span>
            </el-menu-item> -->

          <el-menu-item index="p1">
            <el-icon>
              <plus/>
            </el-icon>
            <span>+1弹幕</span>
          </el-menu-item>

          <el-menu-item index="ruibin">
            <el-icon> 🐘</el-icon>
            <span>😍袁瑞斌😍</span>
          </el-menu-item>

          <el-menu-item index="/XTT">
            <el-icon> 🏃</el-icon>
            <span>小团体</span>
          </el-menu-item>

          <el-menu-item index="/DGQ">
            <img src="@/assets/imgs/dog.png" alt="DGQ" style="height: 18px; margin-right: 10px"/>
            <span> DGQ</span>
          </el-menu-item>

          <el-menu-item index="/baizi">
            <el-icon>
              <User/>
            </el-icon>
            <span>白字</span>
          </el-menu-item>

          <el-menu-item index="/QUQU">
            <img src="@/assets/imgs/Z.png" alt="Z!!" style="height: 18px"/>
            <span>QUQU弹幕</span>
          </el-menu-item>
        </el-menu>
      </div>
      <div style="
					flex: 1;
					width: 0;
					background-color: #f8f8ff;
					padding: 10px;
				">
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    complaintButton() {
      window.open("https://www.wjx.cn/vm/rQUgnS0.aspx#");
    },
    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
    },
  },

  data() {
    return {
      isCollapse: false,
    };
  },
};
</script>

<script setup>
import {useRoute} from "vue-router";

const $route = useRoute();
console.log($route.path);
const url = "https://pic.imgdb.cn/item/66992905d9c307b7e9f0136e.png";
const wxurl =
    "https://newres.wechat.com/t/fed_upload/08b92997-2415-408f-b706-442ed4ede518/OTE0YTAw.png";
</script>

<style scoped>
.el-menu-item.is-active {
  background-color: #dcede9 !important;
}

.el-menu-item:hover {
  color: #11a983;
}

.her {
  position: relative;
  display: inline-block;
  position: fixed;
  left: 30px;
  /*bottom:0px;*/
  height: 50px;
}
</style>