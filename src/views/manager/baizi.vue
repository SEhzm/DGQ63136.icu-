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

  {barrage: '“虽然彩字踩在了我的头上，但反过来我也用舌头弄脏了他的鞋底”———白字'},
  {barrage: '①白字说话要加敬语，特别是对彩字②白字每条弹幕限制在3个字以内③彩字和彩字对话时白字不能插嘴'},
  {barrage: '🧹清理白字🧹清理白字🧹清理白字🧹清理白字🧹清理白字🧹清理白字'},
  {barrage: '红色是危险，蓝色是冷漠，绿色是伪装，紫色是神秘，橙色是愤怒，黑色是归宿,黄色发给我'},
  {barrage: '没有人一出生就是彩字，出生都是白字'},
  {barrage: '新来的白字不会编段子 可以先从简单的人身攻击开始 不要什么都不做 直播间不养闲人'},
  {barrage: '白字别太跳，表现好点，我可以带ID复制你弹幕，让你体验一次彩字的感觉'},
  {barrage: '谁急？谁破？谁BT？谁被杀了猛逼逼？谁的戒烟废火机？谁的房管是原批？谁的白字只加一'},


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