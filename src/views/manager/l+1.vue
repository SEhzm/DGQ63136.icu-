<template>
  <div>
    <div class="card" style="margin-bottom: 5px ">
      <el-table stripe :data="currentPageData" style="font-size: 18px;">
        <el-table-column type="index" width="60" label="序号" align="center"></el-table-column>
        <el-table-column prop="barrage" label="弹幕"></el-table-column>
        <el-table-column label="" align="center" width="160">
          <template #default="scope">
            <el-button type="primary" @click="copyText(scope.row.barrage)">复制</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <div class="pagination-wrapper">
      <!-- 分页 -->

      <div>
        <el-pagination
            background
            layout="prev, pager, next, jumper"
            :total="tableData.length"
            :page-size="pageSize"
            @current-change="handlePageChange"
        ></el-pagination>
      </div>
      <div class="pagination-text">--------最新弹幕在后面的页号中---------</div>
    </div>
  </div>
</template>

<script setup>
import {ref, computed} from 'vue';
import request from "@/utils/request";
import {ElMessage} from 'element-plus'

request.get('/').then(res => {
  console.log(res)
})
//原始数据
const tableData = ref([

  {barrage: '+1可以，但是请你们+1的时候标注+1的是谁的弹幕，请尊重弹幕著作'},
  {barrage: 'α这是阿尔法，β这是贝塔，γ这是伽玛，δ这是德尔塔，ε这是我亲瓜瓜的小嘴巴'},
  {barrage: '🤖机器人测试弹幕，请机器人🤖自行+1，+1的都是机器人🤖'},
  {barrage: '此弹幕用于统计原神玩家，请原神玩家看到此弹幕后+1'},
  {barrage: '加一！爽！加一！爽！加一！爽！加一！爽！加一！爽！加一！爽！加一！爽！加一！爽！'},
  {barrage: '老子真想把设计这个加一过快，请稍后再试的b一刀杀了！'},
  {barrage: '您的账号在另一地点登录，弹幕连接已断开 点击重新连接弹幕'},
  {barrage: '天天这几句尬逼语录复制粘贴，脑壳里装的是脑浆我觉得就做不出来这种事，尬逼一群'},
  {barrage: '我在“不骂冬瓜强”活动中坚持了60秒，获得称号《是没键盘还是没手》，你也来试试吧。'},
  {barrage: '我在“世界养猪大赛”中养出了猪王“椰汁糕冬瓜强”，点击+1'},
  {barrage: '卧槽哥们你装啥b装的太像了，把大伙都骗了，弹幕都在喷你是啥b，我tm以为你真是啥'},
  {barrage: '系统提示：您在不骂冬瓜强的活动中坚持了一分钟，获得称号“没键盘还是没手。”'},
  {barrage: '有人复制一下我的弹幕吗，我也想躲在被子里偷笑'},
  {barrage: '原创弹幕也是有知识产权的 我辛苦想出的弹幕 你+1就变成你的了 小心我告你侵权'},
  {barrage: '这弹幕不是俺偷嘞，是俺看别人发出来俺复制嘞，俺以为没人要嘞'},


]);

// 每页显示的数据量
const pageSize = ref(15);
// 当前页码
const currentPage = ref(1);
// 计算当前页应该显示的数据
const currentPageData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  const end = start + pageSize.value;
  return tableData.value.slice(start, end);
});

// 处理页码改变的事件
const handlePageChange = (newPage) => {
  currentPage.value = newPage;
};


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

<style scoped>
.pagination-wrapper {
  display: flex;
  align-items: center;
}

.pagination-text {
  margin-left: 50px;
  color: red;
}
</style>