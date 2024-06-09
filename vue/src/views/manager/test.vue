<template>
  <div>
    <div class="card" style="margin-bottom: 5px ">
      <el-table stripe :data="data.tableData" empty-text="我还没有加载完喔~~" style="font-size: 18px;">
        <el-table-column type="index" width="60" label="序号" align="center"></el-table-column>
        <el-table-column prop="barrage" label="弹幕"/>
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
    <el-button plain @click="handleAdd">
      新增
    </el-button>
    <el-dialog v-model="data.dialogFormVisible" title="投稿弹幕" >
      <el-form :model="data.form" label-width="100px" label-position="right">
        <el-form-item label="分栏" :label-width="formLabelWidth">
          <el-select v-model="data.form.region" placeholder="选择上传的分栏">
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
        <el-form-item label="弹幕内容">
          <el-input v-model="data.form.name" autocomplete="off"/>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="data.dialogFormVisible = false">关闭</el-button>
          <el-button type="primary" @click="data.dialogFormVisible = false">
            提交
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import {ref, reactive} from 'vue'
import request from "@/utils/request";
import {ElMessage} from 'element-plus'

const data = reactive({
  name: '',
  tableData: [],
  total: 0,
  pageSize: 15, //每页个数
  currentPage: 1, //起始页码
  dialogFormVisible: false,
  form: {},
})

const load = (pageNum = 1) => {
  request.get('/QUQU/Page', {
    params: {
      pageNum: pageNum,
      pageSize: data.pageSize
    }
  }).then(res => {
    // console.log(res)
    data.tableData = res.data?.list || []
    data.total = res.data?.total || 0
    console.log(data.tableData)
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

const dialogFormVisible = ref(false)
const handleAdd = () => {
  data.form = {}
  data.dialogFormVisible = true
}
</script>

<style scoped>
.pagination-wrapper {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

</style>
