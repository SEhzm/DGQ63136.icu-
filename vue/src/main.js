import {
  createApp
} from 'vue'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import zhCn from 'element-plus/dist/locale/zh-cn.mjs'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import '@/assets/css/global.css'

const app = createApp(App)

app.use(router)
app.use(ElementPlus, {
  locale: zhCn,
})

// ����ȫ�ֶ�ʱ��
setInterval(() => {
  location.reload(); // ˢ������ҳ��  
}, 3600000); //����ʱ�䣬ms

app.mount('#app')

for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

import AV from 'leancloud-storage';

const appId = 'G8sstSnHYpUQ8Lj1Y8BRHHb7-MdYXbMMI';
const appKey = '1NOhe8Diw2jD9xzrPHv3r386';
AV.init({ appId, appKey });



//�ٶ�ͳ��API
var _hmt = _hmt || [];
(function () {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?b9634ebcad194c62131c24600b2e1b10";
  var s = document.getElementsByTagName("script")[0];
  s.parentNode.insertBefore(hm, s);
})();