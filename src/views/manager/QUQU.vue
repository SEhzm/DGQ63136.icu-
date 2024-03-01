<template>
  <div>
    <div class="card" style="margin-bottom: 5px ">
      <el-table stripe :data="currentPageData" style="font-size: 18px;">
        <el-table-column type="index" width="60" label="序号" align="center"></el-table-column>
        <el-table-column prop="barrage" label="弹幕"></el-table-column>
        <el-table-column label="" align="center" width="85">
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

  {barrage: '！闹胡是就直简起一我带不，吧了思意够不太也这，瓜冬啊Z我：UQUQ丶鸟反'},
  {barrage: '@狂鸟丶QUQU：我Z啊冬瓜，这关你都不会啊？一个单向烟一个提溜闪不就过去了？'},
  {barrage: '@日鸟丶QUQU：私はZああ、とても面白い、冬瓜は私を連れて遊びに行かないでまるででたらめだ'},
  {barrage: '@偷鸟、ququ:我Z 啊，冬瓜，我都没偷你东西，干嘛打我，给你个Z，真是胡~~闹！'},
  {barrage: '@灣鳥丶QUQU：靠北啦，掛牆！醬紫好玩的遊戲不叫我是要怎樣吼！簡直就是胡！鬧！'},
  {barrage: '官鸟丶ququ：坚决落实一天一玩，一户一玩，应玩尽玩。让老百姓喜欢玩，爱上玩，怕不玩'},
  {barrage: '桀鸟丶ququ：我嬲咧，这么好的包点不埋我的金河田，简直就是瞎！装！机！'},
  {barrage: '京鸟丶QUQU：八套！北京我有八套房子！你敢跟我作对？我买你命啊！'},
  {barrage: '狂鸟丶ququ：我z啊冬瓜，这么好的比赛居然不叫我看，简直就是胡闹'},
  {barrage: '馒鸟丶QUQU：（喘）这么好玩的游戏不叫我，你们玩，我歇了，真没生气，哎哟（喘）'},
  {barrage: '我在＃给主播请神 活动中请到了qu神，获得了神之赐z！dgq加冕为椰“Z”膏！你也来试试吧～'},
  {barrage: '小仙鸟丶QUQU：集美们，咱就是说这么好的游戏，竟然不带我玩？整个一个胡闹的大动作！'},
  {barrage: '哑鸟丶QUQU：'},
  {barrage: '豫鸟丶QUQU：噫，老翔，不中嘞，恁好玩嘞游戏咋不叫俺啊，去球吧。'},
  {barrage: '粤鸟丶QUQU：叼你滷味，尼個直播間真係好閪撚正，可以係咁叼柒主播，好鸠过瘾'},
  {barrage: '如果是ququ的话一定会垫底roll把刀'},
  {barrage: '我在＃给主播请神 活动中请到了qu神，获得了神之赐z！dgq加冕为椰“Z”膏！你也来试试吧～'},
  {barrage: '嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟嘟'},
  


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