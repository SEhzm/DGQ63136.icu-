<template>
  <div><img src="https://pic.imgdb.cn/item/6607ee969f345e8d03ae656d.png" alt="DG举牌" class="DGjvpai">

    <div class="card" style="line-height: 30px">
      <div>
        <b style="margin-left:25px;font-size:27px;color:red;">🏮🏮🏮🏮2024年3月26日下午15:12，恭喜丢丢出生。🏮🏮🏮🏮
          <br>距离丢丢高考还有{{ diudiugaokao }}天
          <br>距离冬瓜超哥刘頔钙奶马飞 瓦0：13 一周年还有{{ DaoJiShi }}天，警钟长鸣！
          <img src="https://pic.imgdb.cn/item/6607ee8f9f345e8d03ae39d8.png" alt="捏狗头" class="dog_head"></b>
      </div>

    </div>
    <div class="card" style="line-height: 30px;margin-top: 10px;">
      <div><b>鉴于流量，后续不定时更新。<em style="font-size: 17px;color: red;">新增时光相册2015年-2024年</em></b></div>
    </div>

    <div class="card" style="line-height: 30px; margin-top:8px ;">
      <p>你好，各位白字。 <br>
        这是一个收集厕所弹幕的网站: <span style="font-size: 24px; font-weight: bold; ">
          <a href="https://dgq63136.icu" style="color: red;">DGQ63136.icu<img
              src="https://pic.imgdb.cn/item/6607ee8f9f345e8d03ae393c.png" alt="鸡毙你" class="biabiabia"></a></span>
        <br>
      </p>
    </div>

    <div class="card" style="line-height: 50px ;margin-top: 8px;">
      <div>
        <el-button type="primary" @click="getRandomItem">点我随机一条弹幕</el-button>
        <el-table v-if="randomlySelectedItem" :data="[randomlySelectedItem]" style="font-family: 微软雅黑;font-size: 20px;">
          <el-table-column prop="barrage" label="弹幕"></el-table-column>
          <el-table-column label="" align="center" width="85">
            <template #default="scope">
              <el-button type="primary" @click="copyText(scope.row.barrage)">复制</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div v-else>
          <p>未选择随机项</p>
        </div>
      </div>
    </div>
    <div class="card" style="line-height: 50px ;margin-top: 10px ;margin-bottom: 10px; min-height: 120px;">
      <div>
        <span
          style="position: absolute;font-size: 30px;margin-top: -20px;color: blue ;">--------搜索在这，🦐吗---------</span>
        <el-input v-model="searchQuery" placeholder="搜索弹幕..." style="font-size: 30px;margin-top: 30px;">
          <template>
            <el-button icon="el-icon-search"></el-button>
          </template>
        </el-input>
        <el-table v-if="searchQuery" :data="filteredItems" stripe>
          <el-table-column prop="barrage" label="弹幕" display:none></el-table-column>
          <el-table-column label="" align="center" width="85">
            <template #default="scope">
              <el-button type="primary" @click="copyText(scope.row.barrage)">复制</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
    <div class="card" style="line-height: 100px ;margin-top: 8px; text-align: center;">
      <a href="https://www.wjx.cn/vm/P9UjaRI.aspx# " target="_blank" style="font-size: 25px;"> <img
          src="https://pic.imgdb.cn/item/6607ee909f345e8d03ae3cc1.png" alt="👍👍👍" class="good">我有更好的弹幕！点击投稿！！</a>
    </div>
    <div style="text-align: center;font-size: 17px;margin-left: -250px;">
      <a href="https://beian.miit.gov.cn/" target="_blank">本网站基于腾讯云服务器搭建&nbsp;&nbsp;&nbsp;&nbsp; Copyright © 2024
        桂ICP备2024022150号</a>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: '',
      randomlySelectedItem: null,
      targetDate: new Date('2041-06-07'),
      DaoJiShiDate: new Date('2024-06-29'),

    };

  },
  methods: {
    getRandomItem() {
      if (this.items.length > 0) {
        const randomIndex = Math.floor(Math.random() * this.items.length);
        this.randomlySelectedItem = this.items[randomIndex];
      }
    }
  },
  created() {
    this.getRandomItem();
  },
  computed: {
    filteredItems() {
      return this.searchQuery ? this.items.filter(item =>
        item.barrage.toLowerCase().includes(this.searchQuery.toLowerCase())
      ) : [];
    },
    diudiugaokao() {
      const now = new Date();
      const diffTime = this.targetDate - now;
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
      return diffDays;
    },
    DaoJiShi() {
      const now1 = new Date();
      const TimeGap = this.DaoJiShiDate - now1;
      const DJS_Date = Math.ceil(TimeGap / (1000 * 60 * 60 * 24));
      return DJS_Date;
    }
  },


};

</script>

<script setup>
import {reactive} from 'vue'
import request from "@/utils/request";
import {ElMessage} from 'element-plus'

const data = reactive({
  tableData: [],
  total: 0,
  pageSize: 15,
  currentPage: 1,
})

const load = (pageNum = 1) => {
  request.get('/allBarrage/Page', {
    params: {
      pageNum: pageNum,
      pageSize: data.pageSize
    }
  }).then(res => {
    // console.log(res)
    data.tableData = res.data?.list || []
    data.total = res.data?.total || 0
  }).catch(err => {
    console.error('加载数据失败:', err)
  })
}

load(data.currentPage)

const handlePageChange = (page) => {
  data.currentPage = page
  load(page)
}


const open2 = () => {
  ElMessage({
    message: '复制成功',
    type: 'success',
  })
};

const open4 = () => {
  ElMessage.error('复制失败，请检查浏览器是否禁用navigator.clipboard对象或手动复制,请勿使用夸克浏览器')
};

const copyText = (text) => {
  navigator.clipboard.writeText(text)
    .then(() => {
      // 复制成功，可以显示提示信息  
      open2();
      console.log('内容已复制到剪贴板');
    })
    .catch((err) => {
      // 复制失败，可以显示错误信息  
      console.error('复制失败:', err);
      open4()
    });
};

</script>

<style>
.DGjvpai {
  height: 100px;
  margin-bottom: -11px;
  display: flex;
  align-items: center;
}

.dog_head {
  margin-top: -10px;
  height: 70px;
  position: absolute;
}

.biabiabia {
  margin-top: -56px;
  height: 115px;
  position: absolute;
  margin-left: 10px;
}

.good {
  margin-top: -61px;
  height: 175px;
  position: absolute;
  margin-left: -200px;
}
</style>