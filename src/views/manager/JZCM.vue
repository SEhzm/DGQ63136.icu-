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
import {ElMessage} from 'element-plus'

//原始数据
const tableData = ref([

  {barrage: '2022年11月16日晚20:40分冬瓜强5EPL0.17rating'},
  {barrage: '2024年1月10日23点29分  冬瓜强警长一刀带走五个好人 警钟长鸣'},
  {barrage: '2023.11.28晚十一点二十分，冬瓜强引爆地雷炸死京爷阿乐自己共三人，警钟长鸣！'},
  {barrage: '2023年10月23日04:07分，冬瓜强自爆爆皮过长，警钟长鸣'},
  {barrage: '2023年11月15日01:39:35 冬瓜 刘頔 超哥 被小夹子美人计一石三杀，警钟长鸣'},
  {barrage: '2023年12月22日1:59，冬瓜强搂喜欢算，差3块葬送8千存款，警钟长鸣！'},
  {barrage: '2023年12月26日22点53分35秒，冬瓜强身为连环杀手一刀没出反而进入狼坑，警钟长鸣！'},
  {barrage: '2023年12月29日22:08冬瓜强加拿大鹅在14个人中报身份给刺客XF，警钟长鸣'},
  {barrage: '2023年12月29日22:59，老叶发出感叹：这么蠢的刺客吗？（冬瓜强-刺客-饮弹自尽）'},
  {barrage: '2023年1月11号2点46分阿胖锐评冬瓜强是软香蕉🍌警钟长鸣'},
  {barrage: '2023年1月4日0点16分27秒，苏迪、刘頓、冬瓜决赛圈三打一荣获第二名，警钟长鸣！'},
  {barrage: '2023年2月17号17点45分 阿胖锐评冬瓜强因为阿胖不陪他打针半夜一两点掉小珍珠'},
  {barrage: '2023年3月18日2点29分 冬瓜 茄子 lisa jee 决赛圈四打一被反杀，警钟长鸣'},
  {barrage: '2023年3月23日23点26分刘頔《尿我身上吧》 警钟长鸣！'},
  {barrage: '2023年5月7日19:51分HHJ选用貂蝉获得2.5分！警钟长鸣'},
  {barrage: '2023年6月29日2:28 冬瓜超哥刘頔钙奶马飞 瓦0：13 警钟长鸣'},
  {barrage: '2023年9月17日00:04:17 批高户外看女主播流哈喇子，并表示独占63136'},
  {barrage: '2024年1月8日19：52冬瓜发誓再骂超哥就抽自己脸警钟长鸣'},
  {barrage: '2024年2月24日凌晨1:06分，冬瓜强和超哥拍摄《重生真妙》上中下三集，警钟长鸣'},
  {barrage: '2024年3月10日0点19分 冬瓜强偷拿别人外卖 警钟长鸣'},
  {barrage: '2024年3月14日22：37分冬瓜强踩在ququ的头上！瓜派胜利！！'},

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
  ElMessage.error('复制失败，请检查浏览器是否禁用navigator.clipboard对象或手动复制')
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

<script>


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