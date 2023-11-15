<template>
	<div class="main-containers">
		<div class="top-container" :style='{"padding":"0 30px","overflow":"hidden","top":"0","alignItems":"center","left":"0","background":"url(http://codegen.caihongy.cn/20230106/a539c2eae5fc494c8c437927bc4dec2c.jpg) no-repeat center top","display":"flex","width":"100%","position":"relative","justifyContent":"space-between","height":"64px","zIndex":"1002"}'>
			<img v-if='true' :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
			<div v-if="true" :style='{"width":"calc(100% - 760px)","margin":"0 0 0 380px","fontSize":"22px","color":"#fff","textAlign":"center","background":"none"}'>The bank's internal management system</div>
			<div>
				<div v-if="false" :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}'></div>
				<div v-if="Token" :style='{"color":"#fff","fontSize":"16px","display":"inline-block"}'>{{username}}</div>
				<el-button v-if="!Token" @click="toLogin()" :style='{"border":"1px solid #b0def4","padding":"0 12px","margin":"0 0 0 10px","color":"#333","borderRadius":"2px","background":"#c6eafc","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>login/register</el-button>
                <el-button v-if="Token" @click="logout" :style='{"padding":"0 12px","margin":"0 30px 0 10px","color":"#666","borderRadius":"2px","background":"#f4f4f5","display":"inline-block","fontSize":"14px","lineHeight":"32px","height":"32px"}'>Out</el-button>
			</div>
		</div>
		
		
		<div class="body-containers" :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","width":"100%","padding":"0 0 20px","margin":"0 auto","position":"relative","background":"url(http://codegen.caihongy.cn/20230107/664d2f6d96b441dfbc3d46a0079ec838.jpg) no-repeat center top,url(http://codegen.caihongy.cn/20230107/fe8ecd9b07d64921ad101fde1642ea9d.jpg) repeat-y center 90% / 100% auto,#f1f1f3"}'>
			<div class="menu-preview" :style='{"padding":"0 20px","borderColor":"#efefef","background":"none","borderWidth":"0 0 1px 0","width":"100%","borderStyle":"solid","height":"auto"}'>
				<el-menu class="el-menu-horizontal-demo" :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","background":"none","display":"flex","position":"relative","justifyContent":"center"}' :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true" @select="handleSelect">
					<el-image v-if="false" :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" fit="cover"></el-image>
					<el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' :class="iconArr[index]"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>{{menu.name}}</span>
					</el-menu-item>
					<el-menu-item @click="goBackend">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-box"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>Background management</span>
					</el-menu-item>
					<el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
						<i v-if="false" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"14px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-user"></i>
						<span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"14px","color":"inherit","height":"60px"}'>Personal Center</span>
					</el-menu-item>
				</el-menu>
			</div>
			
			<div class="banner-preview" :style='{"width":"100%","height":"auto"}'>
				<el-carousel :style='{"width":"85%","margin":"10px auto"}' trigger="click" indicator-position="inside" arrow="always" type="card" direction="horizontal" height="400px" :autoplay="true" :interval="5000" :loop="true">
					<el-carousel-item :style='{"borderRadius":"10px","width":"50%","height":"100%"}' v-for="item in carouselList" :key="item.id">
						<el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value" fit="cover"></el-image>
					</el-carousel-item>
				</el-carousel>
			</div>
			
			<router-view></router-view>
			
			<div class="bottom-preview" :style='{"padding":"50px 50px 0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230106/fcc83ea04fae4a0e9b51402430234441.png) no-repeat center top / 100% auto,#f1f1f3","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center","height":"320px"}'>
			    <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" >
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			    <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
			</div>
		</div>
		
	</div>
</template>

<script>
import Vue from 'vue'
export default {
    data() {
		return {
            activeIndex: '0',
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["add","view","modify","del"],"menu":"Bank employees","menuJump":"table","tableName":"bankemployee"}],"menu":"Bank employeesmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["add","view","modify","del"],"menu":"client","menuJump":"table","tableName":"customer"}],"menu":"clientmanage"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["add","view","modify","del"],"menu":"product class","menuJump":"table","tableName":"productclassification"}],"menu":"product classmanage"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["add","view","modify","del"],"menu":"Loan method","menuJump":"table","tableName":"loanmethods"}],"menu":"Loan methodmanage"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["add","view","modify","del"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product manage"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","modify","del","Review"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["add","view","modify","del","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product manage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["add","view","modify","del","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmanage"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["add","view","modify","del"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmanage"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["add","view","modify","del"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmanage"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["add","view","modify","del"],"menu":"Examination Notice","menuJump":"table","tableName":"examnotice"}],"menu":"Examination Noticemanage"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["view","modify","del","Review"],"menu":"Leave Application","menuJump":"table","tableName":"leaveapplication"}],"menu":"Leave Applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["view","modify","del"],"menu":"order of the day","menuJump":"table","tableName":"workschedule"}],"menu":"order of the daymanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["view","modify","del"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["view","modify"],"menu":"Rotation chart management","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["add","view","modify","del"],"menu":"Notice Announcement","tableName":"news"}],"menu":"System management"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmodule"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmodule"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmodule"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"N","hasFrontRegister":"N","roleName":"administrator","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","Review"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["view"],"menu":"Examination Notice","menuJump":"table","tableName":"examnotice"}],"menu":"Examination Noticemanage"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["add","view","modify","del"],"menu":"Leave Application","menuJump":"table","tableName":"leaveapplication"}],"menu":"Leave Applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["add","view","modify","del"],"menu":"order of the day","menuJump":"table","tableName":"workschedule"}],"menu":"order of the daymanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["add","view","modify","del"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmodule"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmodule"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmodule"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"Y","hasFrontRegister":"N","roleName":"Bank employees","tableName":"bankemployee"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","del"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["view"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmodule"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmodule"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmodule"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"Y","hasFrontRegister":"Y","roleName":"client","tableName":"customer"}],
			baseUrl: '',
			carouselList: [],
			menuList: [],
			form: {
				ask: '',
				userid: localStorage.getItem('userid')
			},
			Token: localStorage.getItem('Token'),
            username: localStorage.getItem('username'),
            notAdmin: localStorage.getItem('sessionTable')!='"users"',
			timer: '',
			iconArr: [
				'el-icon-star-off',
				'el-icon-goods',
				'el-icon-warning',
				'el-icon-question',
				'el-icon-info',
				'el-icon-help',
				'el-icon-picture-outline-round',
				'el-icon-camera-solid',
				'el-icon-video-camera-solid',
				'el-icon-video-camera',
				'el-icon-bell',
				'el-icon-s-cooperation',
				'el-icon-s-order',
				'el-icon-s-platform',
				'el-icon-s-operation',
				'el-icon-s-promotion',
				'el-icon-s-release',
				'el-icon-s-ticket',
				'el-icon-s-management',
				'el-icon-s-open',
				'el-icon-s-shop',
				'el-icon-s-marketing',
				'el-icon-s-flag',
				'el-icon-s-comment',
				'el-icon-s-finance',
				'el-icon-s-claim',
				'el-icon-s-opportunity',
				'el-icon-s-data',
				'el-icon-s-check'
			],	
		}
    },
    created() {
		this.baseUrl = this.$config.baseUrl;
		this.menuList = this.$config.indexNav;
		this.getCarousel();
    },
    mounted() {
        this.activeIndex = localStorage.getItem('keyPath') || '0';
    },
    watch: {
        $route(newValue) {
            let that = this
            let url = window.location.href
            let arr = url.split('#')
            for (let x in this.menuList) {
                if (newValue.path == this.menuList[x].url) {
                    this.activeIndex = x
                }
            }
            this.Token = localStorage.getItem('Token')
            window.scrollTo( 0, 100 )
        },
    },
    methods: {
        handleSelect(keyPath) {
            if (keyPath) {
                localStorage.setItem('keyPath', keyPath)
            }
        },
		toLogin() {
		  this.$router.push('/login');
		},
        logout() {
            localStorage.clear();
            Vue.http.headers.common['Token'] = "";
            this.$router.push('/index/home');
            this.activeIndex = '0'
            localStorage.setItem('keyPath', this.activeIndex)
            this.Token = ''
            this.$forceUpdate()
            this.$message({
                message: 'Successfully logged out',
                type: 'success',
                duration: 1000,
            });
        },
		getCarousel() {
			this.$http.get('config/list', {params: { page: 1, limit: 3 }}).then(res => {
				if (res.data.code == 0) {
					this.carouselList = res.data.data.list;
				}
			});
		},
		goBackend() {
			window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
		},
		goMenu(path) {
            if (!localStorage.getItem('Token')) {
                this.toLogin();
            } else {
                this.$router.push(path);
            }
		},
    }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.menu-preview {
	  .el-scrollbar {
	    height: 100%;
	
	    & /deep/ .scrollbar-wrapper {
	      overflow-x: hidden;
	    }
	  }
	}
	
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #fff;
		white-space: nowrap;
		display: flex;
		font-size: 14px;
		line-height: 60px;
		background: none;
		align-items: center;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #ff0;
		white-space: nowrap;
		background: none;
		font-size: 14px;
		line-height: 60px;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
		cursor: pointer;
		border: 0;
		padding: 0 10px;
		color: #ff0;
		white-space: nowrap;
		background: none;
		font-size: 14px;
		line-height: 60px;
		position: relative;
		list-style: none;
		height: 60px;
	}
	
	.banner-preview {
	  .el-carousel /deep/ .el-carousel__indicator button {
	    width: 0;
	    height: 0;
	    display: none;
	  }
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
		background: red;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
		width: 36px;
		font-size: 12px;
		height: 36px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
		background: red;
	}

	.banner-preview .el-carousel /deep/ .el-carousel__indicators {
		padding: 0;
		margin: 0;
		z-index: 2;
		position: absolute;
		list-style: none;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
		border-radius: 100px;
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 12px;
		opacity: 0.4;
		transition: 0.3s;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 0.7;
		height: 12px;
	}
	
	.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
		padding: 0;
		margin: 0 4px;
		background: #fff;
		display: inline-block;
		width: 24px;
		opacity: 1;
		height: 12px;
	}

    .chat-content {
        padding-bottom: 20px;
        width: 100%;
        margin-bottom: 10px;
        max-height: 300px;
        height: 300px;
        overflow-y: scroll;
        border: 1px solid #eeeeee;
        background: #fff;

        .left-content {
            float: left;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }

        .right-content {
            float: right;
            margin-bottom: 10px;
            padding: 10px;
            max-width: 80%;
        }
    }

    .clear-float {
        clear: both;
    }
</style>
