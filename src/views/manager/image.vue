<template>
  <div class="outer">
    <span>时光相册</span>
    <em style="font-size: 14px;">如侵权，请右上角联系删除</em>
  </div>
  <div style="display: flex; flex-wrap: wrap; width: 100%; padding: 3%; box-sizing: border-box;">
    <div v-for="(fit) in outerImg" :key="fit.index" class="image-block" style="margin-right: -20px;margin-bottom: 2%;"
      @click="setPreviewSrcList(fit.url)">
      <el-image :zoom-rate="1.2" :max-scale="7" :min-scale="0.2" :hide-on-click-modal="true"
        :preview-src-list="previewSrcList" fit="cover" lazy style="width: 250px; height: 300px; box-sizing: border-box;"
        :src="fit.url">
      </el-image>
      <div style="text-align: center; padding: 5%;">
        <el-button style="width: 100%; font-size: 20px; box-sizing: border-box;">{{ fit.date }}</el-button>
      </div>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      previewSrcList: [], // 存储预览图片链接的数组
      outerImg:
        [
          {
            url: 'https://c-yuba.douyucdn.cn/yubavod/b/JW67QrnWRw0O/aafb4451afd5a72a393be582d797c44f.jpeg?i=440325281a9b2dbffeffe0dde9c1330244',
            date: '2024-2-08',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/16/202306161115431313099875994.jpg.webp?i=420167d929dddc3b6f4023d685bac15124',
            date: '2023-6-16',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/14/202306142311492243817849127.jpg.webp?i=414408f9ef9a59b1ccbbaecd59c9119204',
            date: '2023-6-14',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/14/202306142311503900454823108.jpg.webp?i=41512a2a2c24b33fccc5ecd25476720164',
            date: '2023-6-14',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/14/202306142311513912209918231.jpg.webp?i=414407bb9e803b340280c58c6a83119204',
            date: '2023-6-14',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/14/202306142311546242222297960.jpg.webp?i=3909ec2f88d369f5b336678d8cc4e66503',
            date: '2023-6-14',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/06/12/202306122326319418920289226.jpg.webp?i=41078ccf58b0e675cd787fe57892411114',
            date: '2023-6-12',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/05/09/202305090117058757417132160.jpg.webp?i=41080fcf140c1ca970a33f9c2edae19204',
            date: '2023-5-9',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4c6fd9c307b7e962aec0.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4c6fd9c307b7e962aee0.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4c6fd9c307b7e962aef0.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4c6fd9c307b7e962af3c.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4c6fd9c307b7e962af5c.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4ca6d9c307b7e962e6d3.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4ca6d9c307b7e962e6ee.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4ca6d9c307b7e962e704.jpg',
            date: '2023-4-22',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/04/19/202304190144096706464315541.jpg.webp?i=41170f71936800b8d3c890d60782d25324',
            date: '2023-4-19',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2023/04/10/202304100107056378117467591.jpg.webp?i=4136684a7e51c3a18d6216683c65d20484',
            date: '2023-4-10',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2022/10/14/202210141623056483449584544.jpg.webp?i=415121ed9ebfb1767e7da75104c2c20164',
            date: '2022-10-14',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2022/08/20/202208201649265900805599688.jpg.webp?i=41442b9def20049f093c4af4f0fb614424',
            date: '2022-8-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccbed9c307b7e9063ecc.jpg',
            date: '2022-8-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccbed9c307b7e9063ee8.jpg',
            date: '2022-8-30',
          },{
            url: 'https://pic.imgdb.cn/item/664cccdad9c307b7e9065e2d.jpg',
            date: '2022-8-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccbfd9c307b7e9063f07.jpg',
            date: '2022-8-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccbed9c307b7e9063e98.jpg',
            date: '2022-8-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccf2d9c307b7e906731b.jpg',
            date: '2022-6-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccdad9c307b7e9065e59.jpg',
            date: '2022-6-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccdbd9c307b7e9065e83.jpg',
            date: '2022-6-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccdbd9c307b7e9065eaa.jpg',
            date: '2022-6-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccdbd9c307b7e9065ed5.jpg',
            date: '2022-6-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccbfd9c307b7e9063f24.jpg',
            date: '2022-6-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccf1d9c307b7e906728d.jpg',
            date: '2022-6-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccf2d9c307b7e90672d4.jpg',
            date: '2022-6-24',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2022/06/24/202206242105193479285098469.jpg.webp?i=411587d295a507f567a11204ea64715444',
            date: '2022-6-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664cccf1d9c307b7e9067268.jpg',
            date: '2022-6-23',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd73d9c307b7e907088a.jpg',
            date: '2022-6-8',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd73d9c307b7e9070858.jpg',
            date: '2022-5-4',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdb3d9c307b7e907564f.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdb3d9c307b7e90755d2.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdb2d9c307b7e9075524.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd8bd9c307b7e90726d8.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd8bd9c307b7e9072652.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd8ad9c307b7e9072567.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd8ad9c307b7e90724ed.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd73d9c307b7e9070814.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd72d9c307b7e90707b7.jpg',
            date: '2022-5-29',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2022/02/27/202202271740208553361628792.jpg.webp?i=41158922aac38e8c18f5e5b12156d11584',
            date: '2022-2-27',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2022/02/21/202202211431512524462614266.jpg.webp?i=412760d9b6082fe1361f25f76482c12764',
            date: '2022-2-21',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4d3ed9c307b7e9636e02.jpg',
            date: '2022-1-8',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2021/12/30/202112300016489407394196768.jpg.webp?i=412769e0f1995bf3132ce1d261d1d12764',
            date: '2021-12-30',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2021/12/27/202112270112306472592465415.jpg.webp?i=4151295eef0c59a35a9ddc25c4c3e20164',
            date: '2021-12-27',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/weibo/2021/06/30/202106301607554355550588625.jpg.webp?i=42160f22acaba1c2dea3e7929eeaf28804',
            date: '2021-6-30',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2021/02/24/202102240006515642035933081.jpg.webp?i=41915f9ba52f9bcb5deaadff8081214364',
            date: '2021-2-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdb2d9c307b7e907540d.jpg',
            date: '2021-2-23',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd15d9c307b7e90696f5.jpg',
            date: '2021-1-19',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd15d9c307b7e906972b.jpg',
            date: '2021-1-19',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd15d9c307b7e9069749.jpg',
            date: '2021-1-19',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd16d9c307b7e90697dc.jpg',
            date: '2021-1-19',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd15d9c307b7e9069790.jpg',
            date: '2021-1-19',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd25d9c307b7e906abf5.jpg',
            date: '2021-1-7',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd25d9c307b7e906aba6.jpg',
            date: '2020-12-27',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd25d9c307b7e906ab5c.jpg',
            date: '2020-11-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdb1d9c307b7e907536b.jpg',
            date: '2020-10-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdd1d9c307b7e9077821.jpg',
            date: '2020-10-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d3e10d9c307b7e95719a1.jpg',
            date: '2020-10-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd24d9c307b7e906ab24.jpg',
            date: '2020-10-10',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd25d9c307b7e906ab43.jpg',
            date: '2020-10-10',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd3dd9c307b7e906c2c8.jpg',
            date: '2020-9-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd3dd9c307b7e906c29b.jpg',
            date: '2020-9-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd3dd9c307b7e906c2e0.jpg',
            date: '2020-9-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4d77d9c307b7e963a2b1.jpg',
            date: '2020-9-26',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4dced9c307b7e963e911.jpg',
            date: '2020-9-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4dd6d9c307b7e963ef56.jpg',
            date: '2020-9-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd3dd9c307b7e906c25f.jpg',
            date: '2020-8-22',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2020/05/04/202005041719363295919107861.jpg.webp?i=41080b4f0fa16dd7dc1e8067d120e10804',
            date: '2020-5-4',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2020/05/04/20200504171938769727562926.jpg.webp?i=41240dc8469d80f88635f02ac33d989303',
            date: '2020-5-4',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2020/05/04/202005041719418073444068493.jpg.webp?i=42016305d0d8b11c8470f9c01daea15124',
            date: '2020-5-4',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd3cd9c307b7e906c209.jpg',
            date: '2020-2-8',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2019/10/27/201910271914155503606416596.jpg.webp?i=41080455bd3915b50105b67449cc910804',
            date: '2019-10-27',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdd0d9c307b7e90777b9.jpg',
            date: '2019-11-3',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2019/08/08/201908082255062705427616221.jpg.webp?i=410809c1a5893b4f0442b0c7a2ccb10804',
            date: '2019-8-8',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2019/07/22/201907221747353094483343645.jpg.webp?i=41080631f501ef9821deb9f503f0c19204',
            date: '2019-7-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd52d9c307b7e906de45.jpg',
            date: '2019-4-1',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdd1d9c307b7e90777ee.jpg',
            date: '2019-2-14',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2019/01/31/20190131095748394991297366.jpg.webp?i=414406b9c1acbbcbcf737ca0e043c10804',
            date: '2019-1-31',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdd0d9c307b7e907777d.jpg',
            date: '2019-1-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd52d9c307b7e906de19.jpg',
            date: '2019-1-1',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd52d9c307b7e906ddcd.jpg',
            date: '2018-12-25',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd52d9c307b7e906dd53.jpg',
            date: '2018-11-20',
          },
          {
            url: 'https://img.douyucdn.cn/data/yuba/default/2018/10/03/201810030346136748238685326.jpg.webp?i=4144056735ae50897317fd17a8f2314404',
            date: '2018-10-3',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccdd0d9c307b7e9077715.jpg',
            date: '2018-9-23',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccde3d9c307b7e9078e58.jpg',
            date: '2018-8-2',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccde3d9c307b7e9078f17.jpg',
            date: '2018-8-2',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccde3d9c307b7e9078ffe.jpg',
            date: '2018-8-2',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccde3d9c307b7e907903e.jpg',
            date: '2018-8-2',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd52d9c307b7e906dcd8.jpg',
            date: '2018-5-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd61d9c307b7e906f206.jpg',
            date: '2018-5-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd61d9c307b7e906f1e9.jpg',
            date: '2018-4-7',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd61d9c307b7e906f167.jpg',
            date: '2018-4-7',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd60d9c307b7e906f10d.jpg',
            date: '2018-4-7',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d405dd9c307b7e958aba0.jpg',
            date: '2018-3-28',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd60d9c307b7e906f0be.jpg',
            date: '2018-3-10',
          },
          {
            url: 'https://pic.imgdb.cn/item/664ccd73d9c307b7e90708d8.jpg',
            date: '2018-1-13',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d418dd9c307b7e95976d7.jpg',
            date: '2017-12-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d418cd9c307b7e95976cb.jpg',
            date: '2017-12-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a1d9c307b7e95981f0.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a1d9c307b7e95981e1.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a1d9c307b7e95981d2.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a1d9c307b7e95981ab.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a1d9c307b7e95981ab.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a0d9c307b7e959817f.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d418cd9c307b7e95976b5.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d418cd9c307b7e95976a6.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d418cd9c307b7e9597698.jpg',
            date: '2017-12-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a6d9c307b7e9598586.jpg',
            date: '2017-12-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d41a6d9c307b7e959859c.jpg',
            date: '2017-12-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d425dd9c307b7e959f847.jpg',
            date: '2017-12-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42aed9c307b7e95a2cb9.jpg',
            date: '2017-11-25',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42add9c307b7e95a2ca3.jpg',
            date: '2017-11-16',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42add9c307b7e95a2c91.jpg',
            date: '2017-11-11',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42aed9c307b7e95a2ce8.jpg',
            date: '2017-11-11',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42aed9c307b7e95a2d05.jpg',
            date: '2017-11-11',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42f9d9c307b7e95a6260.jpg',
            date: '2017-10-29',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d42f9d9c307b7e95a624f.jpg',
            date: '2017-9-30',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d43a9d9c307b7e95bfba1.jpg',
            date: '2017-8-28',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d43a9d9c307b7e95bfb52.jpg',
            date: '2017-8-21',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d43a9d9c307b7e95bfb1b.jpg',
            date: '2017-8-18',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d43a9d9c307b7e95bfada.jpg',
            date: '2017-8-15',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d43add9c307b7e95c029e.jpg',
            date: '2017-8-12',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d43a9d9c307b7e95bfada.jpg',
            date: '2017-8-12',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d44b8d9c307b7e95cd00c.jpg',
            date: '2017-7-2',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d44b8d9c307b7e95ccfa2.jpg',
            date: '2017-6-3',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d44b7d9c307b7e95ccf84.jpg',
            date: '2017-5-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d44b7d9c307b7e95ccf4d.jpg',
            date: '2017-5-5',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4523d9c307b7e95d17f5.jpg',
            date: '2017-4-26',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4523d9c307b7e95d17d6.jpg',
            date: '2017-4-15',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4523d9c307b7e95d17b2.jpg',
            date: '2017-3-17',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4523d9c307b7e95d179b.jpg',
            date: '2017-3-10',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4580d9c307b7e95d592e.jpg',
            date: '2017-2-25',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4580d9c307b7e95d590e.jpg',
            date: '2017-2-25',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4580d9c307b7e95d5902.jpg',
            date: '2017-2-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d457fd9c307b7e95d58d7.jpg',
            date: '2017-1-27',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d457fd9c307b7e95d58f1.jpg',
            date: '2017-1-1',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d461fd9c307b7e95dc7c0.jpg',
            date: '2016-12-26',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d461ed9c307b7e95dc721.jpg',
            date: '2016-12-26',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d461fd9c307b7e95dc79a.jpg',
            date: '2016-12-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d461ed9c307b7e95dc6f2.jpg',
            date: '2016-12-16',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d461ed9c307b7e95dc73e.jpg',
            date: '2016-12-12',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4687d9c307b7e95e0fa7.jpg',
            date: '2016-11-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4687d9c307b7e95e0f5b.jpg',
            date: '2016-10-24',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d476dd9c307b7e95ea571.jpg',
            date: '2016-10-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4743d9c307b7e95e8a25.jpg',
            date: '2016-10-7',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4743d9c307b7e95e8a08.jpg',
            date: '2016-10-5',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4743d9c307b7e95e89d4.jpg',
            date: '2016-10-1',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d47ead9c307b7e95f0139.jpg',
            date: '2016-9-23',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d47e9d9c307b7e95f00bc.jpg',
            date: '2016-9-20',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d47e8d9c307b7e95f0060.jpg',
            date: '2016-9-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4837d9c307b7e95f391d.jpg',
            date: '2016-8-26',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4836d9c307b7e95f38d3.jpg',
            date: '2016-8-19',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4836d9c307b7e95f38c3.jpg',
            date: '2016-8-15',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4836d9c307b7e95f389d.jpg',
            date: '2016-8-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4876d9c307b7e95f6857.jpg',
            date: '2016-7-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4876d9c307b7e95f681b.jpg',
            date: '2016-7-21',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4875d9c307b7e95f6802.jpg',
            date: '2016-7-11',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d48edd9c307b7e95fb860.jpg',
            date: '2016-6-27',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d48ecd9c307b7e95fb852.jpg',
            date: '2016-6-27',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d48ecd9c307b7e95fb843.jpg',
            date: '2016-6-15',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d48ecd9c307b7e95fb823.jpg',
            date: '2016-5-21',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d48ecd9c307b7e95fb814.jpg',
            date: '2016-5-3',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d499cd9c307b7e9604af6.jpg',
            date: '2016-4-26',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d499cd9c307b7e9604ae0.jpg',
            date: '2016-4-23',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d499cd9c307b7e9604acb.jpg',
            date: '2016-4-23',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d499cd9c307b7e9604aaf.jpg',
            date: '2016-3-16',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d499cd9c307b7e9604a8d.jpg',
            date: '2016-2-5',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d49fad9c307b7e960a022.jpg',
            date: '2016-1-3',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d49fad9c307b7e960a000.jpg',
            date: '2015-12-31',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4a7bd9c307b7e9610a1f.jpg',
            date: '2015-12-16',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4a7bd9c307b7e9610a3a.jpg',
            date: '2015-12-14',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4adcd9c307b7e961647e.jpg',
            date: '2015-11-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4adcd9c307b7e9616471.jpg',
            date: '2015-11-22',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4adcd9c307b7e961645f.jpg',
            date: '2015-11-21',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4adcd9c307b7e961644e.jpg',
            date: '2015-11-21',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4b22d9c307b7e9619d83.jpg',
            date: '2015-11-11',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4b22d9c307b7e9619d70.jpg',
            date: '2015-11-11',
          },
          {
            url: 'https://pic.imgdb.cn/item/664d4b21d9c307b7e9619d5a.jpg',
            date: '2015-9-10',
          },
        ],
    };
  },
  methods: {
    setPreviewSrcList(url) {
      this.previewSrcList = [url];
    }
  }
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
</style>
