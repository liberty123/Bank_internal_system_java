<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230329/d97879eb2f4d4671b6bf9d276374adef.jpg) no-repeat center center / 100% 100%","justifyContent":"center","display":"flex"}'>
			<el-form v-if="pageFlag=='register'" :style='{"padding":"0px 0px 20px","margin":"0","borderColor":"#fff","display":"flex","float":"right","justifyContent":"center","borderRadius":"0px","flexWrap":"wrap","background":"rgba(220,220,220,.96)","borderWidth":"4px","width":"650px","position":"relative","borderStyle":"solid","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"padding":"10px 0","margin":"0 0 20px 0","borderColor":"#ddd","color":"#fff","textAlign":"center","borderRadius":"0px","background":"#339933","borderWidth":"0px","width":"100%","fontSize":"22px","borderStyle":"solid","textShadow":"0px 0px 0px rgba(64, 158, 255, .5)","height":"50px"}' class="title">The bank's internal management systemregister</div>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">Employee ID</div>
					<el-input  v-model="ruleForm.employeeid"  autocomplete="off" placeholder="Employee ID"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">Employee Name</div>
					<el-input  v-model="ruleForm.employeename"  autocomplete="off" placeholder="Employee Name"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">Password</div>
					<el-input  v-model="ruleForm.password"  autocomplete="off" placeholder="Password"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">confirmPassword</div>
					<el-input  v-model="ruleForm.password2" autocomplete="off" placeholder="confirmPassword" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">department</div>
					<el-input  v-model="ruleForm.department"  autocomplete="off" placeholder="department"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">Professional title</div>
					<el-input  v-model="ruleForm.professionaltitle"  autocomplete="off" placeholder="Professional title"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">gender</div>
                    <el-select v-model="ruleForm.gender" placeholder="Please select gender" >
                        <el-option
                            v-for="(item,index) in bankemployeegenderOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">Telephone</div>
					<el-input  v-model="ruleForm.contactphone"  autocomplete="off" placeholder="Telephone"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='bankemployee'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">network</div>
					<el-input  v-model="ruleForm.branch"  autocomplete="off" placeholder="network"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">client number</div>
					<el-input  v-model="ruleForm.customernumber"  autocomplete="off" placeholder="client number"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">full name</div>
					<el-input  v-model="ruleForm.name"  autocomplete="off" placeholder="full name"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">Password</div>
					<el-input  v-model="ruleForm.password"  autocomplete="off" placeholder="Password"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">confirmPassword</div>
					<el-input  v-model="ruleForm.password2" autocomplete="off" placeholder="confirmPassword" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">gender</div>
                    <el-select v-model="ruleForm.gender" placeholder="Please select gender" >
                        <el-option
                            v-for="(item,index) in customergenderOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">phone</div>
					<el-input  v-model="ruleForm.phonenumber"  autocomplete="off" placeholder="phone"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">head sculpture</div>
                    <file-upload
                        tip="Click to uploadhead sculpture"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="customertouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">ID card</div>
					<el-input  v-model="ruleForm.idcard"  autocomplete="off" placeholder="ID card"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">intention</div>
					<el-input  v-model="ruleForm.intention"  autocomplete="off" placeholder="intention"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"60%","padding":"0","margin":"0 auto 15px","position":"relative","height":"auto"}' class="list-item" v-if="tableName=='customer'">
					<div v-if="true" :style='{"color":"#333","left":"-160px","textAlign":"right","width":"150px","lineHeight":"44px","fontSize":"16px","position":"absolute","fontWeight":"500"}' class="lable">deposit</div>
					<el-input  v-model="ruleForm.deposit" readonly autocomplete="off" placeholder="deposit"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0px 0px 0px #f9d7b5","margin":"0px auto 10px","color":"#fff","display":"block","outline":"none","borderRadius":"50px","background":"#339933","width":"60%","fontSize":"18px","height":"40px"}' type="button" class="r-btn" @click="login()">register</button>
				<div :style='{"cursor":"pointer","padding":"0","color":"#666","textAlign":"right","display":"inline-block","width":"60%","lineHeight":"1","fontSize":"14px","textDecoration":"underline"}' class="r-login" @click="close()">Existing account, direct login</div>
			</el-form>
			
		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                gender: '',
                gender: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            bankemployeegenderOptions: [],
            customergenderOptions: [],
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.bankemployeegenderOptions = "Male, female".split(',')
        this.customergenderOptions = "Male, female".split(',')
	},
	created() {
    
	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        customertouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


		// register
		login() {
			var url=this.tableName+"/register";
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.password!=this.ruleForm.password2) && `bankemployee` == this.tableName){
						this.$message.error(`The two password inputs are inconsistent`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`bankemployee` == this.tableName && this.ruleForm.contactphone&&(!this.$validate.isMobile(this.ruleForm.contactphone))){
						this.$message.error(`Telephone should enter phone format`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
					if((!this.ruleForm.customernumber) && `customer` == this.tableName){
						this.$message.error(`client numberCannot be empty`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.name) && `customer` == this.tableName){
						this.$message.error(`full nameCannot be empty`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((!this.ruleForm.password) && `customer` == this.tableName){
						this.$message.error(`PasswordCannot be empty`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					if((this.ruleForm.password!=this.ruleForm.password2) && `customer` == this.tableName){
						this.$message.error(`The two password inputs are inconsistent`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`customer` == this.tableName && this.ruleForm.phonenumber&&(!this.$validate.isMobile(this.ruleForm.phonenumber))){
						this.$message.error(`Phone should enter phone format`);
						return
					}
					
					
					
					
            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					if(`customer` == this.tableName && this.ruleForm.idcard&&(!this.$validate.checkIdCard(this.ruleForm.idcard))){
						this.$message.error(`ID card should be entered in ID card format`);
						return
					}
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				
			
			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "Register successful",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20230329/d97879eb2f4d4671b6bf9d276374adef.jpg) no-repeat center center / 100% 100%;

		.el-date-editor.el-input {
		  width: 100%;
		}
		
		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 30px;
						padding: 0 10px;
						margin: 0px 0px 0px  0px;
						color: #333;
						width: 100%;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 288px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 288px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
					}
		
		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 0;
						border-radius: 30px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 288px;
						font-size: 14px;
						border-color: #ddd;
						border-width: 1px;
						border-style: solid;
						height: 40px;
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
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  margin: 10px 0px 10px 10px;
		  		  color: #ccc;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  margin: 10px 0px 10px 10px;
		  		  color: #ccc;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
		
		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px solid #ddd;
		  		  cursor: pointer;
		  		  border-radius: 20px;
		  		  margin: 10px 0px 10px 10px;
		  		  color: #ccc;
		  		  background: #fff;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
