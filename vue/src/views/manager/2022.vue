<template>
  <div>
    <div class="card" style="margin-bottom: 5px ">
      <el-table stripe :data="data.tableData" empty-text="我还没有加载完喔~~" style="font-size: 18px;">
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
            :total="data.total"
            :page-size="data.pageSize"
            @current-change="handlePageChange"
        ></el-pagination>
      </div>
    </div>
  </div>
</template>

<script setup>
import {ref, reactive} from 'vue'
import request from "@/utils/request";
import {ElMessage} from 'element-plus'

const data = reactive({
  tableData: [],
  total: 0,
  pageSize: 15,
  currentPage: 1,
})

const load = (pageNum = 1) => {
  request.get('/J2022/Page', {
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