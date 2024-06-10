<template>
  <div>
    <div class="card" style="margin-bottom: 5px ">
      <el-button type="primary" style="z-index:100;position:fixed;font-size: 18px;margin-left: 150px"
                 @click="handleAdd">
        投稿弹幕
      </el-button>
      <el-table stripe :data="data.tableData" empty-text="我还没有加载完喔~~" @row-click="copyText(row.barrage)"
                style="font-size: 18px; ">
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

    <el-dialog v-model="data.dialogFormVisible" draggable title="投稿弹幕">
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
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="data.dialogFormVisible = false">关闭</el-button>
          <el-button type="primary" @click="saveBarrage">
            投稿并关闭
          </el-button>
          <el-button type="primary" @click="continuousSaveBarrage">
            连续投稿
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup>
import {ref, reactive} from 'vue'
import request from "@/utils/request";
import {ElNotification} from 'element-plus'

const rules = ({
  table: [
    {required: true, message: '请选择分栏', trigger: 'blur'},
  ],
  barrage: [
    {required: true, message: '请输入弹幕', trigger: 'blur'},
  ]
})

const data = reactive({
  tableData: [],
  total: 0,
  pageSize: 15, //每页个数
  currentPage: 1, //起始页码
  dialogFormVisible: false,
  table: '',
  barrage: '',
})

const load = (pageNum = 1) => {
  request.get('/baizi/Page', {
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
  ElNotification({
    message: '复制成功',
    type: 'success',
  })
};

const open4 = () => {
  ElNotification.error('复制失败，请更换浏览器或手动复制,请勿使用夸克浏览器')
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

//点击新增按钮
const handleAdd = () => {
  ElNotification({
    title: '温馨提醒',
    message: '请注意你的行为，不要上传违反法律的内容，后台能监控到你',
    type: 'warning',
  })
  data.table = ''
  data.barrage = ''
  data.dialogFormVisible = true
}
//提交并关闭
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


</script>

<style scoped>
.pagination-wrapper {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

</style>
