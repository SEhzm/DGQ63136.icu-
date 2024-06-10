<template>
  <div>
    <img src="https://pic.imgdb.cn/item/6607ee969f345e8d03ae656d.png" alt="DG举牌" class="DGjvpai">
    <div class="card" style="line-height: 30px">
      <div>
        <b style="margin-left:25px;font-size:27px;color:red;">🎂🎂🎂🎂生日快乐冬瓜强🎂🎂🎂🎂
<!--          <br>距离丢丢高考还有{{ diudiugaokao }}天-->
          <br>距离冬瓜超哥刘頔钙奶马飞 瓦0：13 一周年还有{{ DaoJiShi }}天，警钟长鸣！
          <img src="https://pic.imgdb.cn/item/6607ee8f9f345e8d03ae39d8.png" alt="捏狗头" class="dog_head"></b>
      </div>

    </div>
    <div class="card" style="line-height: 30px;margin-top: 10px;">
      <div><b><em style="font-size: 17px;color: red;">新增时光相册2015年-2024年(可评论)，新增在线投稿弹幕(可直接查看，不用审核版)</em></b></div>
    </div>

    <div class="card" style="line-height: 30px; margin-top:8px ;">
      <p>你好，各位白字。 <br>
        这是一个收集厕所弹幕的网站: <span style="font-size: 24px; font-weight: bold; ">
          <a href="https://dgq63136.icu" style="color: red;">DGQ63136.icu<img
              src="https://pic.imgdb.cn/item/6607ee8f9f345e8d03ae393c.png" alt="鸡毙你" class="biabiabia"></a></span>
        <br>
      </p>
    </div>

    <div class="card" style="line-height: 50px; margin-top: 8px;">
      <div>
        <el-button type="primary" @click="getRandomItem">点我随机一条弹幕</el-button>
        <el-table v-if="randomlySelectedItem" :data="[randomlySelectedItem]"
                  style="font-family: 微软雅黑; font-size: 20px;">
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

    <div class="card" style="line-height: 50px; margin-top: 10px; margin-bottom: 10px; min-height: 120px;">
      <div>
      <span style="position: absolute; font-size: 30px; margin-top: -20px; color: blue;">
        --------搜索在这，🦐吗---------
      </span>
        <el-input v-model="searchQuery" placeholder="搜索弹幕..." style="font-size: 30px; margin-top: 30px;">
          <template #append>
            <el-button icon="el-icon-search"></el-button>
          </template>
        </el-input>
        <el-table v-if="searchQuery" :data="filteredItems" stripe>
          <el-table-column prop="barrage" label="弹幕"></el-table-column>
          <el-table-column label="" align="center" width="85">
            <template #default="scope">
              <el-button type="primary" @click="copyText(scope.row.barrage)">复制</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>

    <div class="card" style="margin-top: 8px; text-align: center;">

      <div style="width: 700px;">
        <el-form :model="data" label-width="100px" :rules="rules" label-position="right">
          <el-form-item label="分栏" :label-width="100" prop="table">
            <el-select v-model="data.table" placeholder="选择上传的分栏">
              <el-option label="2022年警钟长鸣" value="J2022"/>
              <el-option label="2023年警钟长鸣" value="J2023"/>
              <el-option label="2024年警钟长鸣" value="J2024"/>
              <el-option label="+1" value="p1"/>
              <el-option label="🐘超哥🐘" value="ruibin"/>
              <el-option label="小团体" value="XTT"/>
              <el-option label="DGQ" value="DGQ"/>
              <el-option label="白字" value="baizi"/>
              <el-option label="QUQU" value="QUQU"/>
            </el-select>
          </el-form-item>
          <el-form-item label="弹幕内容" prop="barrage">
            <el-input v-model="data.barrage" autocomplete="off"/>
          </el-form-item>
          <el-button type="primary" @click="saveBarrage" style="font-size: 20px;">
            投稿
          </el-button>
        </el-form>
      </div>

      <img src="https://pic.imgdb.cn/item/6607ee909f345e8d03ae3cc1.png" alt="👍👍👍" class="good">&nbsp;
      </div>
    <div style="text-align: center;font-size: 17px;margin-left: -250px;">
      <a href="https://beian.miit.gov.cn/" target="_blank">本网站基于腾讯云服务器搭建&nbsp;&nbsp;&nbsp;&nbsp; Copyright
        © 2024
        桂ICP备2024022150号</a>
    </div>
  </div>
</template>


<script setup>
import {ref, reactive, computed, onMounted} from 'vue';
import request from "@/utils/request";
import {ElMessage, ElNotification} from 'element-plus';


const searchQuery = ref('');
const randomlySelectedItem = ref(null);

const targetDate = new Date('2041-06-07');
const diudiugaokao = ref(0);

const DaoJiShiDate = new Date('2024-06-29');
const DaoJiShi = ref(0);

const rules = ({
  table: [
    {required: true, message: '请选择分栏', trigger: 'blur'},
  ],
  barrage: [
    {required: true, message: '请输入弹幕', trigger: 'blur'},
  ]
})

//提交
const saveBarrage = () => {
  if (data.table === '' || data.barrage === '') {
    ElNotification.error("请选择分栏或输入弹幕");
  } else {
    request.post('/addBarrage', {
      table: data.table,
      barrage: data.barrage
    }).then(res => {
      load()
      data.dialogFormVisible = false;
      if (res.code === '200') {
        ElNotification.success("投稿成功");
      } else {
        ElNotification.error("请求失败");
      }
    })
  }
}

//连续提交
const continuousSaveBarrage = () => {
  if (data.table === '' || data.barrage === '') {
    ElNotification.error("请选择分栏或输入弹幕");
  } else {
    request.post('/addBarrage', {
      table: data.table,
      barrage: data.barrage
    }).then(res => {
      load()
      data.barrage = ''
      if (res.code === '200') {
        ElNotification.success("投稿成功");
      } else {
        ElNotification.error("请求失败");
      }
    })
  }
}


const data = reactive({
  tableData: [],
  table: '',
  barrage: '',
})

const load = () => {
  request.get('/allBarrage/Page', {})
      .then(res => {
        // console.log(res);
        data.tableData = res.data || [];
        // console.log(data.tableData)
        getRandomItem();
      })
      .catch(err => {
        console.error('加载数据失败:', err);
      });
};

load();

//在数组中随机弹幕
const getRandomItem = () => {
  if (data.tableData.length > 0) {
    const randomIndex = Math.floor(Math.random() * data.tableData.length);
    randomlySelectedItem.value = data.tableData[randomIndex];
  }
};

// 过滤搜索结果
const filteredItems = computed(() => {
  return searchQuery.value
      ? data.tableData.filter(item =>
          item.barrage.toLowerCase().includes(searchQuery.value.toLowerCase())
      )
      : [];
});


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


const calculateCountdown = () => {
  const now = new Date();
  const diffTime1 = targetDate - now;
  const diffTime2 = DaoJiShiDate - now;
  diudiugaokao.value = Math.ceil(diffTime1 / (1000 * 60 * 60 * 24));
  DaoJiShi.value = Math.ceil(diffTime2 / (1000 * 60 * 60 * 24));
};


// 在组件挂载时计算倒计时
onMounted(() => {
  calculateCountdown();
  // 设置一个定时器每天更新一次倒计时
  setInterval(calculateCountdown, 1000 * 60 * 60 * 24);
});

</script>


<style>
.DGjvpai {
  height: 80px;
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
  margin-top: -330px;
  height: 175px;
  margin-left: 300px;
}
</style>