<template>
	<div>
		<div class="home_box">
			<!-- 景点信息推荐 -->
			<div class="recomList_view">
				<div class="recomList_title">景点信息推荐</div>
				<div class="recommend_list_four">
					<div class="recommend_item" v-for="(item,index) in jingdianxinxiRecomList" :key="index" @click="detailClick('jingdianxinxi',item.id)">
						<div class="recommend_img_box">
							<img class="recommend_img" v-if="isHttp(item.jingdiantupian)" :src="item.jingdiantupian.split(',')[0]" alt="">
							<img class="recommend_img" v-else :src="item.jingdiantupian?$config.url + item.jingdiantupian.split(',')[0]:''" alt="">
						</div>
						<div class="recommend_content">
							<div class="recommend_title1">
								{{item.jingdianmingcheng}}
							</div>
							<div class="recommend_title2">
								门票价格：{{item.menpiaojiage}}
							</div>
						</div>
					</div>
				</div>
				<div class="recommend_more_view" @click="moreClick('jingdianxinxi')">
					<span class="recommend_more_text">更多</span>
				</div>
			</div>
			<!-- 机票信息首页展示 -->
			<div class="homeList_view">
				<div class="homeList_title">机票信息展示</div>
				<div class="home_list_one">
					<div class="home_item1 animation_box" v-if="jipiaoxinxiHomeList.length>0" @click="detailClick('jipiaoxinxi',jipiaoxinxiHomeList[0].id)">
						<div class="home_img_box">
							<img class="home_img" v-if="isHttp(jipiaoxinxiHomeList[0].tupian)" :src="jipiaoxinxiHomeList[0].tupian.split(',')[0]" alt="">
							<img class="home_img" v-else :src="jipiaoxinxiHomeList[0].tupian?$config.url + jipiaoxinxiHomeList[0].tupian.split(',')[0]:''" alt="">
						</div>
						<div class="home_content">
							<div class="home_title">
								航班公司：{{jipiaoxinxiHomeList[0].hangbangongsi}}
							</div>
							<div class="home_title">
								出发地：{{jipiaoxinxiHomeList[0].chufadi}}
							</div>
							<div class="home_title">
								目的地：{{jipiaoxinxiHomeList[0].mudedi}}
							</div>
							<div class="home_title">
								票价：{{jipiaoxinxiHomeList[0].piaojia}}
							</div>
						</div>
					</div>
					<div class="home_item2">
						<div class="item2_top animation_box" v-if="jipiaoxinxiHomeList.length>1" @click="detailClick('jipiaoxinxi',jipiaoxinxiHomeList[1].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(jipiaoxinxiHomeList[1].tupian)" :src="jipiaoxinxiHomeList[1].tupian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="jipiaoxinxiHomeList[1].tupian?$config.url + jipiaoxinxiHomeList[1].tupian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									航班公司：{{jipiaoxinxiHomeList[1].hangbangongsi}}
								</div>
								<div class="home_title">
									出发地：{{jipiaoxinxiHomeList[1].chufadi}}
								</div>
								<div class="home_title">
									目的地：{{jipiaoxinxiHomeList[1].mudedi}}
								</div>
								<div class="home_title">
									票价：{{jipiaoxinxiHomeList[1].piaojia}}
								</div>
							</div>
						</div>
						<div class="item2_bottom animation_box" v-if="jipiaoxinxiHomeList.length>2" @click="detailClick('jipiaoxinxi',jipiaoxinxiHomeList[2].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(jipiaoxinxiHomeList[2].tupian)" :src="jipiaoxinxiHomeList[2].tupian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="jipiaoxinxiHomeList[2].tupian?$config.url + jipiaoxinxiHomeList[2].tupian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									航班公司：{{jipiaoxinxiHomeList[2].hangbangongsi}}
								</div>
								<div class="home_title">
									出发地：{{jipiaoxinxiHomeList[2].chufadi}}
								</div>
								<div class="home_title">
									目的地：{{jipiaoxinxiHomeList[2].mudedi}}
								</div>
								<div class="home_title">
									票价：{{jipiaoxinxiHomeList[2].piaojia}}
								</div>
							</div>
						</div>
					</div>
					<div class="home_item3 animation_box" v-if="jipiaoxinxiHomeList.length>3" @click="detailClick('jipiaoxinxi',jipiaoxinxiHomeList[3].id)">
						<div class="home_img_box">
							<img class="home_img" v-if="isHttp(jipiaoxinxiHomeList[3].tupian)" :src="jipiaoxinxiHomeList[3].tupian.split(',')[0]" alt="">
							<img class="home_img" v-else :src="jipiaoxinxiHomeList[3].tupian?$config.url + jipiaoxinxiHomeList[3].tupian.split(',')[0]:''" alt="">
						</div>
						<div class="home_content">
							<div class="home_title">
								航班公司：{{jipiaoxinxiHomeList[3].hangbangongsi}}
							</div>
							<div class="home_title">
								出发地：{{jipiaoxinxiHomeList[3].chufadi}}
							</div>
							<div class="home_title">
								目的地：{{jipiaoxinxiHomeList[3].mudedi}}
							</div>
							<div class="home_title">
								票价：{{jipiaoxinxiHomeList[3].piaojia}}
							</div>
						</div>
					</div>
					<div class="home_item4">
						<div class="item4_top animation_box" v-if="jipiaoxinxiHomeList.length>4" @click="detailClick('jipiaoxinxi',jipiaoxinxiHomeList[4].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(jipiaoxinxiHomeList[4].tupian)" :src="jipiaoxinxiHomeList[4].tupian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="jipiaoxinxiHomeList[4].tupian?$config.url + jipiaoxinxiHomeList[4].tupian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									航班公司：{{jipiaoxinxiHomeList[4].hangbangongsi}}
								</div>
								<div class="home_title">
									出发地：{{jipiaoxinxiHomeList[4].chufadi}}
								</div>
								<div class="home_title">
									目的地：{{jipiaoxinxiHomeList[4].mudedi}}
								</div>
								<div class="home_title">
									票价：{{jipiaoxinxiHomeList[4].piaojia}}
								</div>
							</div>
						</div>
						<div class="item4_bottom animation_box" v-if="jipiaoxinxiHomeList.length>5" @click="detailClick('jipiaoxinxi',jipiaoxinxiHomeList[5].id)">
							<div class="home_img_box">
								<img class="home_img" v-if="isHttp(jipiaoxinxiHomeList[5].tupian)" :src="jipiaoxinxiHomeList[5].tupian.split(',')[0]" alt="">
								<img class="home_img" v-else :src="jipiaoxinxiHomeList[5].tupian?$config.url + jipiaoxinxiHomeList[5].tupian.split(',')[0]:''" alt="">
							</div>
							<div class="home_content">
								<div class="home_title">
									航班公司：{{jipiaoxinxiHomeList[5].hangbangongsi}}
								</div>
								<div class="home_title">
									出发地：{{jipiaoxinxiHomeList[5].chufadi}}
								</div>
								<div class="home_title">
									目的地：{{jipiaoxinxiHomeList[5].mudedi}}
								</div>
								<div class="home_title">
									票价：{{jipiaoxinxiHomeList[5].piaojia}}
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="homeList_more_view" @click="moreClick('jipiaoxinxi')">
					<span class="homeList_more_text">更多</span>
				</div>
			</div>
		</div>
	</div>
</template>

<script setup>
	import {
		ref,
		getCurrentInstance
	} from 'vue';
	import {
		useRouter
	} from 'vue-router';
	const context = getCurrentInstance()?.appContext.config.globalProperties;
	const router = useRouter()
	//机票信息首页展示
	const jipiaoxinxiHomeList = ref([])
	const getjipiaoxinxiHomeList = () => {
		context?.$http({
			url: 'jipiaoxinxi/list',
			method: 'get',
			params: {
				page: 1,
				limit: 3
			}
		}).then(res => {
			jipiaoxinxiHomeList.value = res.data.data.list
		})
	}
	//景点信息推荐
	const jingdianxinxiRecomList = ref([])
	const getjingdianxinxiRecomList = () => {
		let autoSortUrl = 'jingdianxinxi/autoSort'
		context?.$http({
			url: autoSortUrl,
			method: 'get',
			params: {
				page: 1,
				limit: 4
			}
		}).then(res => {
			jingdianxinxiRecomList.value = res.data.data.list
		})
	}
	//判断图片链接是否带http
	const isHttp = (str) => {
        return str && str.substr(0,4)=='http';
    }
	//跳转详情
	const detailClick = (table,id) => {
		router.push(`/index/${table}Detail?id=${id}`)
	}
	const moreClick = (table) => {
		router.push(`/index/${table}List`)
	}
	const init = () => {
		//机票信息首页展示
		getjipiaoxinxiHomeList()
		//景点信息推荐
		getjingdianxinxiRecomList()
	}
	init()
</script>

<style lang="scss">
	.home_box {
		border-radius: 4px;
		padding: 16px;
		margin: 0 auto;
		background: #fff;
		display: flex;
		width: 64%;
		justify-content: space-between;
		align-items: flex-start;
		flex-wrap: wrap;
	}
	
	// 推荐
	.recomList_view {
		padding: 10px 20px 20px;
		margin: 30px 0 20px;
		background: #f9f9f9;
		width: 100%;
		position: relative;
		order: 3;
		.recomList_title {
			margin: 10px 0 0;
			color: #333;
			font-weight: 500;
			width: 100%;
			font-size: 22px;
			text-align: left;
		}
		// list
		.recommend_list_four {
			padding: 0;
			margin: 20px 0 0;
			display: flex;
			width: 100%;
			justify-content: space-between;
			align-items: flex-start;
			flex-wrap: wrap;
			height: auto;
			
			.recommend_item:nth-of-type(2n - 1) {
				border: 1px solid #eee;
				padding: 10px;
				margin: 0;
				background: #fff;
				width: calc(100% / 4 - 40px);
				position: relative;
				
				.recommend_img_box {
					width: 100%;
					font-size: 0;
					height: 240px;
					.recommend_img {
						object-fit: cover;
						width: 100%;
						height: 100%;
					}
				}
				.recommend_content {
					border: 0px solid #eee;
					box-shadow: 0 0px 0px rgba(0,0,0,.3);
					padding: 20px 0;
					overflow: hidden;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: flex-start;
					flex-wrap: wrap;
					transition: all .0s;
					height: auto;
					.recommend_title1 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title2 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title3 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title4 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title5 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_price {
						color: #f00;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_four_bottom {
						margin: 10px 0 0;
						display: flex;
						justify-content: center;
						align-items: center;
						.recommend_like {
							margin: 0 10px 0 0;
							color: #0266b5;
							display: flex;
							font-size: 14px;
							align-items: center;
							.like_icon {
								margin: 0 4px 0 0;
								color: inherit;
							}
							.like_num {
								color: inherit;
							}
						}
						.recommend_collect {
							margin: 0 10px 0 0;
							color: #ee7810;
							display: flex;
							font-size: 14px;
							align-items: center;
							.el-icon {
								margin: 0 4px 0 0;
								color: inherit;
							}
							.collect_num {
								color: inherit;
							}
						}
						.recommend_clickNum {
							margin: 0 10px 0 0;
							color: #4aac26;
							display: flex;
							font-size: 14px;
							align-items: center;
							.el-icon {
								margin: 0 4px 0 0;
								color: inherit;
							}
							.clickNum_num {
								color: inherit;
							}
						}
					}
				}
			}
			.recommend_item:nth-of-type(2n) {
				border: 1px solid #eee;
				padding: 10px;
				margin: 0;
				background: #fff;
				width: calc(100% / 4 - 40px);
				position: relative;
				
				.recommend_img_box {
					width: 100%;
					font-size: 0;
					height: 240px;
					.recommend_img {
						object-fit: cover;
						width: 100%;
						height: 100%;
					}
				}
				.recommend_content {
					border: 0px solid #eee;
					box-shadow: 0 0px 0px rgba(0,0,0,.3);
					padding: 20px 0;
					display: flex;
					width: 100%;
					justify-content: center;
					align-items: flex-start;
					flex-wrap: wrap;
					transition: all 0s;
					height: auto;
					.recommend_title1 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title2 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title3 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title4 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_title5 {
						margin: 0 0 10px;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_price {
						color: #f00;
						width: 100%;
						line-height: 1;
						text-align: center;
					}
					.recommend_four_bottom {
						margin: 10px 0 0;
						display: flex;
						justify-content: center;
						align-items: center;
						.recommend_like {
							margin: 0 10px 0 0;
							color: #0266b5;
							display: flex;
							font-size: 14px;
							align-items: center;
							.like_icon {
								margin: 0 4px 0 0;
								color: inherit;
							}
							.like_num {
								color: inherit;
							}
						}
						.recommend_collect {
							margin: 0 10px 0 0;
							color: #ee7810;
							display: flex;
							font-size: 14px;
							align-items: center;
							.el-icon {
								margin: 0 4px 0 0;
								color: inherit;
							}
							.collect_num {
								color: inherit;
							}
						}
						.recommend_clickNum {
							margin: 0 10px 0 0;
							color: #4aac26;
							display: flex;
							font-size: 14px;
							align-items: center;
							.el-icon {
								margin: 0 4px 0 0;
								color: inherit;
							}
							.clickNum_num {
								color: inherit;
							}
						}
					}
				}
			}
			.recommend_item:nth-of-type(2n - 1):hover {
				cursor: pointer;
				background: #27bacc;
				
				.recommend_img_box {
					.recommend_img {
					}
				}
				.recommend_content {
					color: #fff;
					.recommend_title1 {
						color: inherit;
					}
					.recommend_title2 {
						color: inherit;
					}
					.recommend_title3 {
						color: inherit;
					}
					.recommend_title4 {
						color: inherit;
					}
					.recommend_title5 {
						color: inherit;
					}
					.recommend_price {
						color: inherit;
					}
					.recommend_four_bottom {
						.recommend_like {
							color: inherit;
							.like_icon {
								color: inherit;
							}
							.like_num {
								color: inherit;
							}
						}
						.recommend_collect {
							color: inherit;
							.el-icon {
								color: inherit;
							}
							.collect_num {
								color: inherit;
							}
						}
						.recommend_clickNum {
							color: inherit;
							.el-icon {
								color: inherit;
							}
							.clickNum_num {
								color: inherit;
							}
						}
					}
				}
			}
			.recommend_item:nth-of-type(2n):hover {
				cursor: pointer;
				background: #27bacc;
				
				.recommend_img_box {
					.recommend_img {
					}
				}
				.recommend_content {
					color: #fff;
					.recommend_title1 {
						color: inherit;
					}
					.recommend_title2 {
						color: inherit;
					}
					.recommend_title3 {
						color: inherit;
					}
					.recommend_title4 {
						color: inherit;
					}
					.recommend_title5 {
						color: inherit;
					}
					.recommend_price {
						color: inherit;
					}
					.recommend_four_bottom {
						color: inherit;
						.recommend_like {
							color: inherit;
							.like_icon {
								color: inherit;
							}
							.like_num {
								color: inherit;
							}
						}
						.recommend_collect {
							color: inherit;
							.el-icon {
								color: inherit;
							}
							.collect_num {
								color: inherit;
							}
						}
						.recommend_clickNum {
							color: inherit;
							.el-icon {
								color: inherit;
							}
							.clickNum_num {
								color: inherit;
							}
						}
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.recommend_more_view {
			cursor: pointer;
			border: 0px solid #ddd;
			padding: 0;
			margin: 20px 0 0;
			color: #fff;
			line-height: 34px;
			right: 0;
			border-radius: 0px;
			top: 0;
			background: none;
			width: 89px;
			position: absolute;
			text-align: center;
			.recommend_more_text {
				color: #999;
			}
		}
	}
	// 推荐
	// 新闻资讯
	.newsList_view {
		padding: 10px;
		margin: 20px 0 0;
		background: rgb(249, 249, 249);
		width: 32%;
		position: relative;
		order: 2;
		height: auto;

		.newsList_title {
			padding: 0 0 8px;
			margin: 0 auto 20px;
			color: #666;
			background: none;
			font-weight: 500;
			width: 100%;
			font-size: 22px;
			border-color: #999;
			border-width: 0 0 0px;
			border-style: dashed;
			text-align: left;
		}
		// list
		.news_list_one {
			padding: 20px 10px 10px;
			margin: 20px 0 0;
			background: #fff;
			display: flex;
			width: 100%;
			justify-content: space-between;
			flex-wrap: wrap;
			.news_item {
				cursor: pointer;
				margin: 0 0 20px 0;
				background: #fff;
				display: flex;
				width: calc(100% - 0px);
				align-items: center;
				.news_img_box {
					display: none;
					width: 100px;
					height: 100px;
					.news_img {
						border: 6px solid #ebe9dd;
						object-fit: cover;
						width: 100%;
						height: 100%;
					}
				}
				.news_content {
					margin: 0 0 0 0px;
					display: flex;
					width: calc(100% - 80px);
					flex-wrap: wrap;
					.news_title {
						margin: 0 0 0px;
						overflow: hidden;
						white-space: nowrap;
						font-weight: 500;
						width: 100%;
						font-size: 14px;
						text-overflow: ellipsis;
						text-align: left;
						order: 2;
					}
					.news_text {
						padding: 0 10px 0 0;
						overflow: hidden;
						display: none;
						font-size: 14px;
						line-height: 24px;
						height: 48px;
						order: 3;
					}
					.news_time {
						color: #333;
						font-weight: 600;
						display: none;
						width: 100%;
						text-align: left;
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.news_more_view {
			cursor: pointer;
			border: 0px solid #ddd;
			padding: 0px 0;
			margin: 0;
			color: #999;
			line-height: 34px;
			right: 0px;
			border-radius: 0px;
			top: 6px;
			background: none;
			width: 89px;
			position: absolute;
			text-align: center;
			.news_more_text {
				color: #999;
			}
		}
	}
	// 新闻资讯
	// 首页展示
	.homeList_view {
		padding: 10px 0px;
		margin: 0px 0 0;
		background: none;
		width: 66%;
		position: relative;
		order: 1;

		.homeList_title {
			padding: 0 0 10px;
			margin: 0;
			color: #333;
			background: none;
			font-weight: 500;
			width: 100%;
			font-size: 22px;
			border-color: #eee;
			border-width: 0 0 1px;
			border-style: solid;
			text-align: left;
		}
		// list
		.home_list_one {
			padding: 0;
			margin: 20px auto;
			display: flex;
			width: 100%;
			align-items: flex-start;
			flex-wrap: wrap;
			.home_item1 {
				cursor: pointer;
				border: 1px solid #eee;
				padding: 12px 12px 4px;
				margin: 0 20px 20px 0;
				width: calc(34% - 20px);
				position: relative;
				.home_img_box {
					margin: 0 0 4px;
					width: 100%;
					.home_img {
						object-fit: cover;
						width: 100%;
						height: 220px;
					}
				}
				.home_content {
					color: #000;
					background: rgba(0,0,0,.0);
					width: 100%;
					line-height: 24px;
					text-align: center;
					.home_title {
						font-size: 14px;
					}
				}
			}
			.home_item2 {
				margin: 0;
				width: 66%;
				.item2_top {
					cursor: pointer;
					border: 1px solid #eee;
					padding: 12px 12px 4px;
					margin: 0px;
					width: calc(50% - 10px);
					position: relative;
					float: left;
					.home_img_box {
						margin: 0 0 4px;
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 220px;
						}
					}
					.home_content {
						color: #000;
						background: rgba(0,0,0,.0);
						width: 100%;
						line-height: 24px;
						text-align: center;
						.home_title {
							font-size: 14px;
						}
					}
				}
				.item2_bottom {
					cursor: pointer;
					border: 1px solid #eee;
					padding: 12px 12px 4px;
					width: calc(50% - 10px);
					position: relative;
					float: right;
					.home_img_box {
						margin: 0 0 4px;
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 220px;
						}
					}
					.home_content {
						color: #000;
						background: rgba(0,0,0,.0);
						width: 100%;
						line-height: 24px;
						text-align: center;
						.home_title {
							font-size: 14px;
						}
					}
				}
			}
			.home_item3 {
				cursor: pointer;
				border: 1px solid #ddd;
				padding: 12px 12px 0;
				margin: 0 20px 0 0;
				display: none;
				width: calc(34% - 20px);
				position: relative;
				.home_img_box {
					width: 100%;
					font-size: 0;
					.home_img {
						object-fit: cover;
						width: 100%;
						height: 220px;
					}
				}
				.home_content {
					color: #000;
					background: rgba(0,0,0,.0);
					width: 100%;
					line-height: 30px;
					text-align: center;
					.home_title {
						font-size: 14px;
					}
				}
			}
			.home_item4 {
				margin: 0 0 0 0;
				display: none;
				width: 66%;
				.item4_top {
					cursor: pointer;
					border: 1px solid #ddd;
					padding: 12px 12px 0;
					margin: 0;
					width: calc(50% - 10px);
					position: relative;
					float: left;
					.home_img_box {
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 220px;
						}
					}
					.home_content {
						color: #000;
						background: rgba(0,0,0,.0);
						width: 100%;
						line-height: 30px;
						text-align: center;
						.home_title {
							font-size: 14px;
						}
					}
				}
				.item4_bottom {
					cursor: pointer;
					border: 1px solid #ddd;
					padding: 12px 12px 0;
					width: calc(50% - 10px);
					position: relative;
					float: right;
					.home_img_box {
						width: 100%;
						.home_img {
							object-fit: cover;
							width: 100%;
							height: 220px;
						}
					}
					.home_content {
						color: #000;
						background: rgba(0,0,0,.0);
						width: 100%;
						line-height: 30px;
						text-align: center;
						.home_title {
							font-size: 14px;
						}
					}
				}
			}
		}
		// list
		// animation
		.animation_box {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		.animation_box img {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			z-index: initial;
		}
		.animation_box img:hover {
			transform: rotate(0deg) scale(1) skew(0deg, 0deg) translate3d(0px, 0px, 0px);
			-webkit-perspective: 1000px;
			perspective: 1000px;
			transition: 0.3s;
		}
		// animation
		// 更多
		.homeList_more_view {
			cursor: pointer;
			border: 0px solid #ddd;
			padding: 0;
			margin: 0;
			z-index: 9;
			color: #999;
			line-height: 24px;
			right: 0;
			border-radius: 0px;
			top: 16px;
			background: none;
			width: 89px;
			position: absolute;
			text-align: center;
			.homeList_more_text {
				color: #999;
			}
		}
	}
	// 首页展示
</style>