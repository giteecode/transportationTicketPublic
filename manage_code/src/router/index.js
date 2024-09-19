	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import huochepiaodinggou from '@/views/huochepiaodinggou/list'
	import yonghu from '@/views/yonghu/list'
	import huochexinxi from '@/views/huochexinxi/list'
	import discussjingdianxinxi from '@/views/discussjingdianxinxi/list'
	import jingdianxinxi from '@/views/jingdianxinxi/list'
	import qichexinxi from '@/views/qichexinxi/list'
	import jipiaoxinxi from '@/views/jipiaoxinxi/list'
	import storeup from '@/views/storeup/list'
	import config from '@/views/config/list'
	import users from '@/views/users/list'
	import jipiaodinggou from '@/views/jipiaodinggou/list'
	import qichedingpiao from '@/views/qichedingpiao/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/huochepiaodinggou',
			name: '火车票订购',
			component: huochepiaodinggou
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/huochexinxi',
			name: '火车信息',
			component: huochexinxi
		}
		,{
			path: '/discussjingdianxinxi',
			name: '景点信息评论',
			component: discussjingdianxinxi
		}
		,{
			path: '/jingdianxinxi',
			name: '景点信息',
			component: jingdianxinxi
		}
		,{
			path: '/qichexinxi',
			name: '汽车信息',
			component: qichexinxi
		}
		,{
			path: '/jipiaoxinxi',
			name: '机票信息',
			component: jipiaoxinxi
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		,{
			path: '/jipiaodinggou',
			name: '机票订购',
			component: jipiaodinggou
		}
		,{
			path: '/qichedingpiao',
			name: '汽车订票',
			component: qichedingpiao
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
