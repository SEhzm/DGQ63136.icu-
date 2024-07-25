<template>
  <div class="tab">
    <div :class="`tab1 ${item.path === route.path ? 'selected' : 'none'}`" v-for="item in tabEle" :key="item.path"
         @click="navigateTo(item.path)"> {{ item.text }}
    </div>
  </div>
</template>

<script setup lang="ts">
import {useRoute, useRouter} from 'vue-router';

const tabEle = [
  {text: '首页', path: '/home'},
  {text: '全部弹幕', path: '/AllBarrage'},
  {text: '时光相册', path: '/image'},
  {text: '警钟长鸣', path: '/JZCM'},
  {text: '2022', path: '/2022'},
  {text: '2023', path: '/2023'},
  {text: '2024', path: '/2024'},
  {text: '+1', path: '/image'},
  {text: '袁瑞斌', path: '/ruibin'},
  {text: '小团体', path: '/XTT'},
  {text: 'DGQ', path: '/DGQ'},
  {text: '白字', path: '/baizi'},
  {text: 'QUQU', path: '/QUQU'}
];
const route = useRoute();
const router = useRouter();

function navigateTo(path: string): void {
  console.log('路由', path);
  router.push(path);
}
</script>

<style lang="scss" scoped>
.tab {
  display: flex;
  overflow-x: auto;
  white-space: nowrap;
  //关掉滑动条
  //scrollbar-width: none;
  //-ms-overflow-style: none;
  //
  //&::-webkit-scrollbar { /* Webkit browsers (Chrome, Safari) */
  //  width: 8px;
  //}

  &::-webkit-scrollbar-track {
    background: transparent;
  }

  &::-webkit-scrollbar-thumb {
    background-color: rgba(0, 0, 0, 0.2);
    border-radius: 10px;
  }

  & > div {
    position: relative;
    white-space: nowrap;
    padding: 10px 15px;
    margin-right: 10px;
    border-radius: 15px 15px 0 0;
    transition: all 0.3s ease;
    font-size: 15px;
    color: #000000;
    background-color: #fff;

    &::before {
      content: '';
      position: absolute;
      left: 0;
      bottom: -2px;
      width: 100%;
      background-color: transparent;
      transition: all 0.3s ease;
    }
  }

  .none {
    background-color: #93a2b9;
    padding: 10px;
  }

  & > div:hover,
  & > .selected {
    color: #fff;
    background-color: #007BFF;

    &::before {
      background-color: #007BFF;
    }

  }
}
</style>

