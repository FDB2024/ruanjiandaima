import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import forum from '@/views/modules/forum/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import jiaofeixinxi from '@/views/modules/jiaofeixinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import hubanghuzhu from '@/views/modules/hubanghuzhu/list'
    import discusshubanghuzhu from '@/views/modules/discusshubanghuzhu/list'
    import jiaofeitongzhi from '@/views/modules/jiaofeitongzhi/list'
    import xianzhiwupin from '@/views/modules/xianzhiwupin/list'
    import systemnotice from '@/views/modules/systemnotice/list'
    import discussxianzhiwupin from '@/views/modules/discussxianzhiwupin/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/forum',
        name: '社区论坛',
        component: forum
      }
      ,{
	path: '/news',
        name: '公告信息',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/jiaofeixinxi',
        name: '缴费信息',
        component: jiaofeixinxi
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/hubanghuzhu',
        name: '互帮互助',
        component: hubanghuzhu
      }
      ,{
	path: '/discusshubanghuzhu',
        name: '互帮互助评论',
        component: discusshubanghuzhu
      }
      ,{
	path: '/jiaofeitongzhi',
        name: '缴费通知',
        component: jiaofeitongzhi
      }
      ,{
	path: '/xianzhiwupin',
        name: '闲置物品',
        component: xianzhiwupin
      }
      ,{
	path: '/systemnotice',
        name: '系统公告',
        component: systemnotice
      }
      ,{
	path: '/discussxianzhiwupin',
        name: '闲置物品评论',
        component: discussxianzhiwupin
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
