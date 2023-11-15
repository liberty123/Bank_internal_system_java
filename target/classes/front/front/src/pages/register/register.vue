<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230106/58eb0ca95fe94ea3912632230dc4f6d4.jpg) no-repeat center top /  100% 100%,#fff","display":"flex","width":"100%","backgroundSize":"cover","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"10px 80px 20px  80px","boxShadow":"0 0px 0px rgba(0, 0, 0, .1)","margin":"0 auto","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","borderRadius":"0px","background":"#fff","borderWidth":"8px 16px 8px 16px","width":"800px","position":"relative","borderStyle":"solid","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"margin":"0 0 10px 0","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","textAlign":"center","borderWidth":"8px 16px 8px 16px","width":"100%","lineHeight":"44px","fontSize":"16px","borderStyle":"solid"}'>The bank's internal management systemregister</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="employeeid">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Employee ID：</div>
				<el-input v-model="registerForm.employeeid"  placeholder="Enter Employee ID" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="employeename">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Employee Name：</div>
				<el-input v-model="registerForm.employeename"  placeholder="Enter Employee Name" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Password：</div>
				<el-input v-model="registerForm.password" type="password" placeholder="Enter Password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>confirmPassword：</div>
				<el-input v-model="registerForm.password2" type="password" placeholder="Please enter the Password again" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="department">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>department：</div>
				<el-input v-model="registerForm.department"  placeholder="Enter department" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="professionaltitle">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Professional title：</div>
				<el-input v-model="registerForm.professionaltitle"  placeholder="Enter Professional title" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="gender">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>gender：</div>
                <el-select v-model="registerForm.gender" placeholder="Please select gender" >
                  <el-option
                      v-for="(item,index) in bankemployeegenderOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="contactphone">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Telephone：</div>
				<el-input v-model="registerForm.contactphone"  placeholder="Enter Telephone" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='bankemployee'" prop="branch">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>network：</div>
				<el-input v-model="registerForm.branch"  placeholder="Enter network" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="customernumber">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>client number：</div>
				<el-input v-model="registerForm.customernumber"  placeholder="Enter client number" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="name">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>full name：</div>
				<el-input v-model="registerForm.name"  placeholder="Enter full name" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Password：</div>
				<el-input v-model="registerForm.password" type="password" placeholder="Enter Password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>confirmPassword：</div>
				<el-input v-model="registerForm.password2" type="password" placeholder="Please enter the Password again" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="gender">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>gender：</div>
                <el-select v-model="registerForm.gender" placeholder="Please select gender" >
                  <el-option
                      v-for="(item,index) in customergenderOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="phonenumber">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>phone：</div>
				<el-input v-model="registerForm.phonenumber"  placeholder="Enter phone" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>head sculpture：</div>
                <file-upload
					tip="Click to uploadhead sculpture"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="customertouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="idcard">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>ID card：</div>
				<el-input v-model="registerForm.idcard"  placeholder="Enter ID card" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="intention">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>intention：</div>
				<el-input v-model="registerForm.intention"  placeholder="Enter intention" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 30px","height":"auto"}' v-if="tableName=='customer'" prop="deposit">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>deposit：</div>
				<el-input v-model="registerForm.deposit" readonly placeholder="Enter deposit" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","display":"inline-block","outline":"none","borderRadius":"8px","background":"#fdf6f6","borderWidth":"8px 16px 8px 16px","width":"120px","fontSize":"16px","borderStyle":"solid","height":"50px"}' type="primary" @click="submitForm('registerForm')">register</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px auto 5px","borderColor":"#98c6e2 #5fa6d0 #98c6e2 #5fa6d0","color":"#333","display":"inline-block","outline":"none","borderRadius":"8px","background":"#fdf6f6","borderWidth":"8px 16px 8px 16px","width":"120px","fontSize":"16px","borderStyle":"solid","height":"50px"}' @click="resetForm('registerForm')">resetting</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0 10%","color":"#333","display":"inline-block","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">Existing account login</router-link>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                gender: '',
                gender: '',
            },
			rules: {},
            bankemployeegenderOptions: [],
            customergenderOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
        this.bankemployeegenderOptions = "Male, female".split(',');
      if ('bankemployee' == this.tableName) {
        this.rules.contactphone = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('customer' == this.tableName) {
        this.rules.customernumber = [{ required: true, message: 'Enter client number', trigger: 'blur' }];
      }
      if ('customer' == this.tableName) {
        this.rules.name = [{ required: true, message: 'Enter full name', trigger: 'blur' }];
      }
      if ('customer' == this.tableName) {
        this.rules.password = [{ required: true, message: 'Enter Password', trigger: 'blur' }];
      }
        this.customergenderOptions = "Male, female".split(',');
      if ('customer' == this.tableName) {
        this.rules.phonenumber = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('customer' == this.tableName) {
        this.rules.idcard = [{ required: true, validator: this.$validate.isIdCard, trigger: 'blur' }];
      }
    },
    //方法集合
    methods: {
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      customertouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
               if(`bankemployee` == this.tableName && this.registerForm.password!=this.registerForm.password2) {
                this.$message.error(`The two password inputs are inconsistent`);
                return
               }
               if(`customer` == this.tableName && this.registerForm.password!=this.registerForm.password2) {
                this.$message.error(`The two password inputs are inconsistent`);
                return
               }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: 'Register successful',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
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

		.el-date-editor.el-input {
			width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #333;
						width: 100%;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px;
						outline: none;
						color: #333;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #333;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 2px solid #98c6e2;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						outline: none;
						color: #333;
						width: 288px;
						font-size: 14px;
						height: 44px;
					}
		
		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}
		
		.rgs-form /deep/ .upload .upload-img {
		  		  border: 2px solid #98c6e2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 2px solid #98c6e2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 2px solid #98c6e2;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #999;
		  		  width: 80px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
