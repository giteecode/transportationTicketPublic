import { createRouter, createWebHashHistory } from 'vue-router'
import index from '../views'
import home from '../views/pages/home.vue'
import login from '../views/pages/login.vue'
import yonghuList from '@/views/pages/yonghu/list'
import yonghuDetail from '@/views/pages/yonghu/formModel'
import yonghuAdd from '@/views/pages/yonghu/formAdd'
import yonghuRegister from '@/views/pages/yonghu/register'
import yonghuCenter from '@/views/pages/yonghu/center'
import jipiaoxinxiList from '@/views/pages/jipiaoxinxi/list'
import jipiaoxinxiDetail from '@/views/pages/jipiaoxinxi/formModel'
import jipiaoxinxiAdd from '@/views/pages/jipiaoxinxi/formAdd'
import huochexinxiList from '@/views/pages/huochexinxi/list'
import huochexinxiDetail from '@/views/pages/huochexinxi/formModel'
import huochexinxiAdd from '@/views/pages/huochexinxi/formAdd'
import qichexinxiList from '@/views/pages/qichexinxi/list'
import qichexinxiDetail from '@/views/pages/qichexinxi/formModel'
import qichexinxiAdd from '@/views/pages/qichexinxi/formAdd'
import jipiaodinggouList from '@/views/pages/jipiaodinggou/list'
import jipiaodinggouDetail from '@/views/pages/jipiaodinggou/formModel'
import jipiaodinggouAdd from '@/views/pages/jipiaodinggou/formAdd'
import huochepiaodinggouList from '@/views/pages/huochepiaodinggou/list'
import huochepiaodinggouDetail from '@/views/pages/huochepiaodinggou/formModel'
import huochepiaodinggouAdd from '@/views/pages/huochepiaodinggou/formAdd'
import qichedingpiaoList from '@/views/pages/qichedingpiao/list'
import qichedingpiaoDetail from '@/views/pages/qichedingpiao/formModel'
import qichedingpiaoAdd from '@/views/pages/qichedingpiao/formAdd'
import jingdianxinxiList from '@/views/pages/jingdianxinxi/list'
import jingdianxinxiDetail from '@/views/pages/jingdianxinxi/formModel'
import jingdianxinxiAdd from '@/views/pages/jingdianxinxi/formAdd'
import storeupList from '@/views/pages/storeup/list'

const routes = [{
		path: '/',
		redirect: '/index/home'
	},
	{
		path: '/index',
		component: index,
		children: [{
			path: 'home',
			component: home
		}
		, {
			path: 'yonghuList',
			component: yonghuList
		}, {
			path: 'yonghuDetail',
			component: yonghuDetail
		}, {
			path: 'yonghuAdd',
			component: yonghuAdd
		}
		, {
			path: 'yonghuCenter',
			component: yonghuCenter
		}
		, {
			path: 'jipiaoxinxiList',
			component: jipiaoxinxiList
		}, {
			path: 'jipiaoxinxiDetail',
			component: jipiaoxinxiDetail
		}, {
			path: 'jipiaoxinxiAdd',
			component: jipiaoxinxiAdd
		}
		, {
			path: 'huochexinxiList',
			component: huochexinxiList
		}, {
			path: 'huochexinxiDetail',
			component: huochexinxiDetail
		}, {
			path: 'huochexinxiAdd',
			component: huochexinxiAdd
		}
		, {
			path: 'qichexinxiList',
			component: qichexinxiList
		}, {
			path: 'qichexinxiDetail',
			component: qichexinxiDetail
		}, {
			path: 'qichexinxiAdd',
			component: qichexinxiAdd
		}
		, {
			path: 'jipiaodinggouList',
			component: jipiaodinggouList
		}, {
			path: 'jipiaodinggouDetail',
			component: jipiaodinggouDetail
		}, {
			path: 'jipiaodinggouAdd',
			component: jipiaodinggouAdd
		}
		, {
			path: 'huochepiaodinggouList',
			component: huochepiaodinggouList
		}, {
			path: 'huochepiaodinggouDetail',
			component: huochepiaodinggouDetail
		}, {
			path: 'huochepiaodinggouAdd',
			component: huochepiaodinggouAdd
		}
		, {
			path: 'qichedingpiaoList',
			component: qichedingpiaoList
		}, {
			path: 'qichedingpiaoDetail',
			component: qichedingpiaoDetail
		}, {
			path: 'qichedingpiaoAdd',
			component: qichedingpiaoAdd
		}
		, {
			path: 'jingdianxinxiList',
			component: jingdianxinxiList
		}, {
			path: 'jingdianxinxiDetail',
			component: jingdianxinxiDetail
		}, {
			path: 'jingdianxinxiAdd',
			component: jingdianxinxiAdd
		}
		, {
			path: 'storeupList',
			component: storeupList
		}
		]
	},
	{
		path: '/login',
		component: login
	}
	,{
		path: '/yonghuRegister',
		component: yonghuRegister
	}
]

const router = createRouter({
  history: createWebHashHistory(process.env.BASE_URL),
  routes
})

export default router
