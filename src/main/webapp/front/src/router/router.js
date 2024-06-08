import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import jiaofeitongzhiList from '../pages/jiaofeitongzhi/list'
import jiaofeitongzhiDetail from '../pages/jiaofeitongzhi/detail'
import jiaofeitongzhiAdd from '../pages/jiaofeitongzhi/add'
import jiaofeixinxiList from '../pages/jiaofeixinxi/list'
import jiaofeixinxiDetail from '../pages/jiaofeixinxi/detail'
import jiaofeixinxiAdd from '../pages/jiaofeixinxi/add'
import xianzhiwupinList from '../pages/xianzhiwupin/list'
import xianzhiwupinDetail from '../pages/xianzhiwupin/detail'
import xianzhiwupinAdd from '../pages/xianzhiwupin/add'
import hubanghuzhuList from '../pages/hubanghuzhu/list'
import hubanghuzhuDetail from '../pages/hubanghuzhu/detail'
import hubanghuzhuAdd from '../pages/hubanghuzhu/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemnoticeList from '../pages/systemnotice/list'
import systemnoticeDetail from '../pages/systemnotice/detail'
import systemnoticeAdd from '../pages/systemnotice/add'
import discussxianzhiwupinList from '../pages/discussxianzhiwupin/list'
import discussxianzhiwupinDetail from '../pages/discussxianzhiwupin/detail'
import discussxianzhiwupinAdd from '../pages/discussxianzhiwupin/add'
import discusshubanghuzhuList from '../pages/discusshubanghuzhu/list'
import discusshubanghuzhuDetail from '../pages/discusshubanghuzhu/detail'
import discusshubanghuzhuAdd from '../pages/discusshubanghuzhu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'jiaofeitongzhi',
					component: jiaofeitongzhiList
				},
				{
					path: 'jiaofeitongzhiDetail',
					component: jiaofeitongzhiDetail
				},
				{
					path: 'jiaofeitongzhiAdd',
					component: jiaofeitongzhiAdd
				},
				{
					path: 'jiaofeixinxi',
					component: jiaofeixinxiList
				},
				{
					path: 'jiaofeixinxiDetail',
					component: jiaofeixinxiDetail
				},
				{
					path: 'jiaofeixinxiAdd',
					component: jiaofeixinxiAdd
				},
				{
					path: 'xianzhiwupin',
					component: xianzhiwupinList
				},
				{
					path: 'xianzhiwupinDetail',
					component: xianzhiwupinDetail
				},
				{
					path: 'xianzhiwupinAdd',
					component: xianzhiwupinAdd
				},
				{
					path: 'hubanghuzhu',
					component: hubanghuzhuList
				},
				{
					path: 'hubanghuzhuDetail',
					component: hubanghuzhuDetail
				},
				{
					path: 'hubanghuzhuAdd',
					component: hubanghuzhuAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemnotice',
					component: systemnoticeList
				},
				{
					path: 'systemnoticeDetail',
					component: systemnoticeDetail
				},
				{
					path: 'systemnoticeAdd',
					component: systemnoticeAdd
				},
				{
					path: 'discussxianzhiwupin',
					component: discussxianzhiwupinList
				},
				{
					path: 'discussxianzhiwupinDetail',
					component: discussxianzhiwupinDetail
				},
				{
					path: 'discussxianzhiwupinAdd',
					component: discussxianzhiwupinAdd
				},
				{
					path: 'discusshubanghuzhu',
					component: discusshubanghuzhuList
				},
				{
					path: 'discusshubanghuzhuDetail',
					component: discusshubanghuzhuDetail
				},
				{
					path: 'discusshubanghuzhuAdd',
					component: discusshubanghuzhuAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
