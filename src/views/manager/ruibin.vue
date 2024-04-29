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
                <el-pagination background layout="prev, pager, next, jumper" :total="tableData.length"
                    :page-size="pageSize" @current-change="handlePageChange"></el-pagination>
            </div>
            <div class="pagination-text">--------最新弹幕在后面的页号中---------</div>
        </div>
    </div>
</template>

<script setup>
import { ref, computed } from 'vue';
import request from "@/utils/request";
import { ElMessage } from 'element-plus'

request.get('/').then(res => {
    console.log(res)
})
//原始数据
const tableData = ref([
    { barrage: '没有' },
    { barrage: '不是' },
    { barrage: '你知道吗' },
    { barrage: '袁瑞斌就是那种会哭着打奶嗝，眼睛会泛着水光的小奶狗一枚呀，软软的，浑身奶香' },
    { barrage: '机械仿生人袁瑞斌 代号M3 根据你本次战役的“优良表现”请自觉前往报废站执行报废程序' },
    { barrage: '士兵2640出列！' },
    { barrage: '仿生机器人袁瑞斌 代号M3 几点开始执行刺杀任务？' },
    { barrage: '这要是馒头报的点我都不敢想象冬瓜会说什么污言秽语' },
    { barrage: '玉溪市税务局： 已经受理您对【袁瑞斌】的举报，后续结果将通过短信通知，感谢您的监督' },
    { barrage: '@CSGO馒头:冬瓜强你大主播，你了不起，你清高，你就打压我吧，我就是要一步一步一步一步爬到最高' },
    { barrage: '꧁✨❤瑞斌瑞斌，直击我心❤✨꧂꧁✨❤瑞斌瑞斌，直击我心❤✨꧂꧁✨❤瑞斌瑞斌，直击我心❤✨꧂' },
    { barrage: '超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭超哥😭' },
    { barrage: '馒头平时打得多好，发多少枪，多么奉献。只要在冬瓜眼里失误一次，那就要被说一晚上' },
    { barrage: '小团体一个京✌🏻八套房，一个云南大象王，就你是个余姚讲述人' },
    { barrage: '不怕渣女玩暧昧，就怕瑞斌三十岁，识大体 懂进退 撒娇卖萌全都会 解风情有韵味让人迷恋又沉醉' },
    { barrage: '叶先生您好，您购买的真人比例馒头90kg【私密发货】【新型硅胶】已经到达驿站，请及时取走' },
    { barrage: '馒鸟丶QUQU：（喘）这么好玩的游戏不叫我，你们玩，我歇了，真没生气，哎哟（喘）' },
    { barrage: 'MD，我真受不了了，能不能给这超哥弄个AI变声器，天天啊啊嗷嗷的还喘' },



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