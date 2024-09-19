const config = {
    get() {
        return {
            url : process.env.VUE_APP_BASE_API_URL + process.env.VUE_APP_BASE_API + '/',
            name: process.env.VUE_APP_BASE_API,
			menuList:[
				{
					name: '旅游景点',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'景点信息',
							url:'/index/jingdianxinxiList'
						},
					]
				},
				{
					name: '机票信息',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'机票信息',
							url:'/index/jipiaoxinxiList'
						},
					]
				},
				{
					name: '火车信息',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'火车信息',
							url:'/index/huochexinxiList'
						},
					]
				},
				{
					name: '汽车信息',
					icon: '${frontMenu.fontClass}',
					child:[
						{
							name:'汽车信息',
							url:'/index/qichexinxiList'
						},
					]
				},
			]
        }
    },
    getProjectName(){
        return {
            projectName: "基于Web的交通旅游订票系统"
        } 
    }
}
export default config
