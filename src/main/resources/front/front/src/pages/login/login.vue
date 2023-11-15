<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230106/58eb0ca95fe94ea3912632230dc4f6d4.jpg) no-repeat center top /  100% 100%,#fff","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"20px  240px 40px  40px","boxShadow":"0 0px 0px rgba(0, 0, 0, .1)","margin":"0","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","outline":"1px solid #eee","borderRadius":"0px","background":"#fff","borderWidth":"8px 16px 8px 16px","width":"800px","position":"relative","borderStyle":"solid","height":"auto"}' :rules="rules">
			<div v-if="true" :style='{"margin":"0 0 4px","color":"#5fa6d0","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"22px","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"boxShadow":"inset 0px 0px 0px 0px #c5f1c0","margin":"0px 0 20px","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","textAlign":"center","background":"#fff","borderWidth":"8px 16px 8px 16px","width":"100%","lineHeight":"44px","fontSize":"16px","borderStyle":"solid","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)"}'>Login to the bank's internal management system</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>account：</div>
				<input :style='{"border":"2px solid #98c6e2","padding":"0 10px","color":"#333","borderRadius":"4px","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.username" placeholder="Enter account">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 auto 10px"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Password：</div>
				<input :style='{"border":"2px solid #98c6e2","padding":"0 10px","color":"#333","borderRadius":"4px","width":"100%","fontSize":"14px","height":"44px"}' v-model="loginForm.password" placeholder="Enter Password" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"80%","margin":"20px auto"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"0","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","bottom":"-125px","display":"inline-block","minWidth":"140px","outline":"none","borderRadius":"4px","left":"160px","background":"#fff","borderWidth":"8px 16px 8px 16px","width":"auto","fontSize":"16px","position":"absolute","borderStyle":"solid","height":"56px"}' @click="submitForm('loginForm')">login</el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","outline":"none","color":"#fff","borderRadius":"4px","background":"rgba(64, 158, 255, 1)","display":"none","width":"auto","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">resetting</el-button>
			</el-form-item>
			<div :style='{"margin":"0 0px 0 0","top":"70px","flexWrap":"wrap","display":"flex","width":"200px","position":"absolute","right":"30px","justifyContent":"flex-end","height":"100%"}'>
			<router-link :style='{"cursor":"pointer","padding":"0 10px","margin":"0 0px 20px 0","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","textDecoration":"none","minWidth":"120px","background":"#f6f6f6","borderWidth":"8px 16px 8px 16px","width":"auto","fontSize":"16px","lineHeight":"36px","borderStyle":"solid","height":"50px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='Y'" v-for="(item, index) in roles" :key="index">register{{item.roleName.replace('register','')}}</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["add","view","modify","del"],"menu":"Bank employees","menuJump":"table","tableName":"bankemployee"}],"menu":"Bank employeesmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["add","view","modify","del"],"menu":"client","menuJump":"table","tableName":"customer"}],"menu":"clientmanage"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["add","view","modify","del"],"menu":"product class","menuJump":"table","tableName":"productclassification"}],"menu":"product classmanage"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["add","view","modify","del"],"menu":"Loan method","menuJump":"table","tableName":"loanmethods"}],"menu":"Loan methodmanage"},{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["add","view","modify","del"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product manage"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","modify","del","Review"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["add","view","modify","del","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product manage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["add","view","modify","del","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmanage"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["add","view","modify","del"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmanage"},{"child":[{"appFrontIcon":"cuIcon-copy","buttons":["add","view","modify","del"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmanage"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["add","view","modify","del"],"menu":"Examination Notice","menuJump":"table","tableName":"examnotice"}],"menu":"Examination Noticemanage"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["view","modify","del","Review"],"menu":"Leave Application","menuJump":"table","tableName":"leaveapplication"}],"menu":"Leave Applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["view","modify","del"],"menu":"order of the day","menuJump":"table","tableName":"workschedule"}],"menu":"order of the daymanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["view","modify","del"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"},{"child":[{"appFrontIcon":"cuIcon-form","buttons":["view","modify"],"menu":"Rotation chart management","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["add","view","modify","del"],"menu":"Notice Announcement","tableName":"news"}],"menu":"System management"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmodule"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmodule"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmodule"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"N","hasFrontRegister":"N","roleName":"administrator","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","Review"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["view"],"menu":"Examination Notice","menuJump":"table","tableName":"examnotice"}],"menu":"Examination Noticemanage"},{"child":[{"appFrontIcon":"cuIcon-clothes","buttons":["add","view","modify","del"],"menu":"Leave Application","menuJump":"table","tableName":"leaveapplication"}],"menu":"Leave Applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["add","view","modify","del"],"menu":"order of the day","menuJump":"table","tableName":"workschedule"}],"menu":"order of the daymanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["add","view","modify","del"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmodule"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmodule"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmodule"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"Y","hasFrontRegister":"N","roleName":"Bank employees","tableName":"bankemployee"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-link","buttons":["view","del"],"menu":"loan application","menuJump":"table","tableName":"loanapplication"}],"menu":"loan applicationmanage"},{"child":[{"appFrontIcon":"cuIcon-attentionfavor","buttons":["view"],"menu":"notification information","menuJump":"table","tableName":"notificationinformation"}],"menu":"notification informationmanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","loan application"],"menu":"Loan product ","menuJump":"table","tableName":"loanproducts"}],"menu":"Loan product module"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["view","View comments"],"menu":"Financial product ","menuJump":"table","tableName":"wealthmanagementproducts"}],"menu":"Financial product module"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["view","View comments"],"menu":"Bank network","menuJump":"table","tableName":"bankoutlet"}],"menu":"Bank networkmodule"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["view"],"menu":"precious metal","menuJump":"table","tableName":"preciousmetals"}],"menu":"precious metalmodule"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["view"],"menu":"legal provisions","menuJump":"table","tableName":"legalterms"}],"menu":"legal provisionsmodule"}],"hasBackLogin":"Y","hasBackRegister":"N","hasFrontLogin":"Y","hasFrontRegister":"Y","roleName":"client","tableName":"customer"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: 'Enter account', trigger: 'blur' }
				],
				password: [
					{ required: true, message: 'Enter Password', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
  components: {
  },
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='Y') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']
			
			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("Please select login用户类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: 'login成功',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230106/58eb0ca95fe94ea3912632230dc4f6d4.jpg) no-repeat center top /  100% 100%,#fff;
		
		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}
		
		.list-item /deep/ .el-input .el-input__inner {
			border: 2px solid #98c6e2;
			border-radius: 4px;
			padding: 0 10px;
			color: #333;
			width: 100%;
			font-size: 14px;
			height: 44px;
		}
		
		.list-code /deep/ .el-input .el-input__inner {
			border: 2px solid #98c6e2;
			border-radius: 4px;
			padding: 0 10px;
			outline: none;
			color: #333;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 114px);
			font-size: 14px;
			height: 44px;
		}
		
		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #5fa6d0;
			border-color: #5fa6d0;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #5fa6d0;
			font-size: 14px;
		}
	}
</style>
