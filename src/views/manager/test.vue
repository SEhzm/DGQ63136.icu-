<template>
  <div class="outer">
      <span>时光相册</span><span style="font-size: 16px;">(点击放大图片)</span>
      <em style="font-size: 14px;">如侵权，请右上角联系删除</em>
  </div>
  <div class="image-list">
      <div v-for="(image, index) in outerImg" :key="index" class="image-block">
          <el-image :src="image.url" :preview-src-list="[image.url]" fit="cover" lazy
              style="width: 250px; height: 300px; box-sizing: border-box;">
          </el-image>
          <div style="text-align: center; padding: 5%;">
              <el-button style="width: 100%; font-size: 20px; box-sizing: border-box;">{{ image.date }}</el-button>
          </div>
          <el-button @click="toggleComments(image)" style="margin-top: 10px;">{{ image.showComments ? '隐藏评论' : '显示评论'
              }}</el-button>
          <div v-if="image.showComments && image.comments.length > 0" class="comment-list">
              <div v-for="(comment, cIndex) in image.comments" :key="cIndex" class="comment-item">
                  <span class="comment-content">{{ comment.content }}</span>
                  <span class="comment-date">{{ formatDate(comment.createdAt) }}</span>
              </div>
          </div>
          <el-button @click="addComment(image)" style="margin-top: 10px;">新增评论</el-button>
      </div>
  </div>
</template>

<script>
import AV from 'leancloud-storage';

export default {
  data() {
      return {
          outerImg: [
              {
                  url: 'https://c-yuba.douyucdn.cn/yubavod/b/JW67QrnWRw0O/aafb4451afd5a72a393be582d797c44f.jpeg?i=440325281a9b2dbffeffe0dde9c1330244',
                  date: '2024-2-08',
                  comments: [],
                  showComments: false
              },
              {
                  url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/16/202306161115431313099875994.jpg.webp?i=420167d929dddc3b6f4023d685bac15124',
                  date: '2023-6-16',
                  comments: [],
                  showComments: false
              },
          ],
      };
  },
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
      async addComment(image) {
          const content = prompt('请输入评论内容：');
          if (!content) return;
          try {
              const Comment = AV.Object.extend('Comment');
              const comment = new Comment();
              comment.set('image', image.url);
              comment.set('content', content);
              await comment.save();
              alert('评论成功！');
              this.fetchComments(); // 评论成功后重新获取评论列表
          } catch (error) {
              console.error('保存评论失败：', error);
              alert('保存评论失败！');
          }
      },
      toggleComments(image) {
          image.showComments = !image.showComments;
      }
  },
  created() {
      this.fetchComments();
  },
};
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
  margin-left: 5%;
  margin-right: 5%;
  margin-bottom: 5%;
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