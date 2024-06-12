<template>
  <div class="outer">
    <span>时光相册</span><span style="font-size: 16px;">(点击放大图片)</span>
    <em style="font-size: 14px;">如侵权，请右上角联系删除</em>
  </div>
  <div class="image-list">
    <div v-for="(image, index) in image.outerImg" :key="index" class="image-block">
      <el-image :zoom-rate="1.2" :max-scale="7" :min-scale="0.2" :hide-on-click-modal="true" :src="image.url"
                :preview-src-list="[image.url]" fit="cover" lazy
                style="width: 250px; height: 300px; box-sizing: border-box;">
      </el-image>
      <div style="text-align: center; padding: 5%;">
        <el-button style="width: 100%; font-size: 20px; box-sizing: border-box;">{{ image.date }}</el-button>
      </div>
      <el-button @click="toggleComments(image)" style=" font-size: 18px; margin-left: 15px; box-sizing: border-box;">{{
          image.showComments ? '隐藏评论' : '显示评论'
        }}
      </el-button>
      <div v-if="image.showComments && image.comments.length > 0" class="comment-list">
        <div v-for="(comment, cIndex) in image.comments" :key="cIndex" class="comment-item">
          <span class="comment-content">{{ comment.content }}</span>
          <span class="comment-date">{{ formatDate(comment.createdAt) }}</span>
        </div>
      </div>
      <el-button type="success" plain @click="addComment(image)"
                 style=" font-size: 18px; box-sizing: border-box;">新增评论
      </el-button>
    </div>
  </div>
</template>


<script>
import AV from 'leancloud-storage';

export default {

  methods: {
    async fetchComments() {
      try {
        const query = new AV.Query('Comment');
        const comments = await query.find();
        this.outerImg.forEach(image => {
          image.comments = comments.filter(comment => comment.get('image') === image.url).map(comment => ({
            content: comment.get('content'),
            createdAt: comment.createdAt
          }));
        });
      } catch (error) {
        console.error('获取评论失败：', error);
      }
    },
    formatDate(date) {
      return new Date(date).toLocaleString();
    },


  },
  created() {
    this.fetchComments();
  },
};
</script>

<script setup>
import {ref, reactive} from 'vue'
import request from "@/utils/request";
import {ElNotification} from 'element-plus'

const image = reactive({
  outerImg: [],

})

const load = () => {
  request.get('/showImage', {
  }).then(res => {
    // console.log(res)
    image.outerImg = res.data || []
    console.log(image.outerImg)
  }).catch(err => {
    console.error('加载数据失败:', err)
  })
}
load()
//图片打开/关闭评论
const toggleComments = (image) => {
  image.showComments = !image.showComments;
}

const formatDate = (date) => {
  return new Date(date).toLocaleString();
}
</script>


<style scoped>
.outer {
  margin-top: 2%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 30px;
}

.image-block {
  margin-left: 1%;
  margin-right: 1%;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
}

.demo-image__preview {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0;
  overflow: auto;
}

.demo-image__error .image-slot {
  font-size: 30px;
}

.demo-image__error .image-slot .el-icon {
  font-size: 30px;
}

.demo-image__error .el-image {
  width: 100%;
  height: 200px;
}

.outer {
  text-align: center;
  margin-bottom: 20px;
}

.image-list {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.image-block {
  margin-right: 20px;
  margin-bottom: 20px;
}

.comment-list {
  margin-top: 10px;
}

.comment-item {
  margin-bottom: 5px;
}

.comment-content {
  font-weight: bold;
}

.comment-date {
  font-size: 12px;
  color: #999;
}
</style>