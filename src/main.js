import { createApp } from 'vue'  
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
  
// 设置全局定时器
setInterval(() => {  
  location.reload(); // 刷新整个页面  
}, 3600000); //设置时间，ms
  
app.mount('#app')  
  
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {  
  app.component(key, component)  
}


//百度统计API
var _hmt = _hmt || [];
(function() {
  var hm = document.createElement("script");
  hm.src = "https://hm.baidu.com/hm.js?b9634ebcad194c62131c24600b2e1b10";
  var s = document.getElementsByTagName("script")[0];
  s.parentNode.insertBefore(hm, s);
})();


