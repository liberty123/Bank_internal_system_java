<template>
	<div class="addEdit-block" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230329/eff4ea96c952463cb46b9c79d043ce56.gif) fixed,#f6f6f6"}' style="width: 100%;">
		<el-form
			:style='{"padding":"20px","boxShadow":"0 0px 0px #ddd","borderRadius":"0px","background":"none"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="product name" prop="productname">
					<el-input v-model="ruleForm.productname" placeholder="product name" clearable  :readonly="ro.productname"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="product name" prop="productname">
					<el-input v-model="ruleForm.productname" placeholder="product name" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="product class" prop="productclassification">
					<el-select :disabled="ro.productclassification" v-model="ruleForm.productclassification" placeholder="Please select product class" >
						<el-option
							v-for="(item,index) in productclassificationOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="product class" prop="productclassification">
					<el-input v-model="ruleForm.productclassification"
						placeholder="product class" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="product  number" prop="productnumber">
					<el-input v-model="ruleForm.productnumber" placeholder="product  number" clearable  :readonly="ro.productnumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="product  number" prop="productnumber">
					<el-input v-model="ruleForm.productnumber" placeholder="product  number" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.cover" label="cover" prop="cover">
					<file-upload
						tip="Click to upload the cover page"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.cover?ruleForm.cover:''"
						@change="coverUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.cover" label="cover" prop="cover">
					<img v-if="ruleForm.cover.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cover.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cover.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Issuing institution" prop="issuinginstitution">
					<el-input v-model="ruleForm.issuinginstitution" placeholder="Issuing institution" clearable  :readonly="ro.issuinginstitution"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Issuing institution" prop="issuinginstitution">
					<el-input v-model="ruleForm.issuinginstitution" placeholder="Issuing institution" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Term Type" prop="termtype">
					<el-input v-model="ruleForm.termtype" placeholder="Term Type" clearable  :readonly="ro.termtype"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Term Type" prop="termtype">
					<el-input v-model="ruleForm.termtype" placeholder="Term Type" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="operation pattern" prop="operationmode">
					<el-input v-model="ruleForm.operationmode" placeholder="operation pattern" clearable  :readonly="ro.operationmode"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="operation pattern" prop="operationmode">
					<el-input v-model="ruleForm.operationmode" placeholder="operation pattern" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Fundraising method" prop="fundraisingmethod">
					<el-input v-model="ruleForm.fundraisingmethod" placeholder="Fundraising method" clearable  :readonly="ro.fundraisingmethod"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Fundraising method" prop="fundraisingmethod">
					<el-input v-model="ruleForm.fundraisingmethod" placeholder="Fundraising method" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Fundraising currency" prop="fundraisingcurrency">
					<el-input v-model="ruleForm.fundraisingcurrency" placeholder="Fundraising currency" clearable  :readonly="ro.fundraisingcurrency"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Fundraising currency" prop="fundraisingcurrency">
					<el-input v-model="ruleForm.fundraisingcurrency" placeholder="Fundraising currency" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Risk level" prop="risklevel">
					<el-input v-model="ruleForm.risklevel" placeholder="Risk level" clearable  :readonly="ro.risklevel"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Risk level" prop="risklevel">
					<el-input v-model="ruleForm.risklevel" placeholder="Risk level" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Investment nature" prop="investmentnature">
					<el-input v-model="ruleForm.investmentnature" placeholder="Investment nature" clearable  :readonly="ro.investmentnature"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Investment nature" prop="investmentnature">
					<el-input v-model="ruleForm.investmentnature" placeholder="Investment nature" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Actual Days" prop="actualdays">
					<el-input v-model="ruleForm.actualdays" placeholder="Actual Days" clearable  :readonly="ro.actualdays"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Actual Days" prop="actualdays">
					<el-input v-model="ruleForm.actualdays" placeholder="Actual Days" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="Release time" prop="releasetime">
					<el-date-picker
						format="yyyy-MM-dd"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.releasetime" 
						type="date"
						:readonly="ro.releasetime"
						placeholder="Release time"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.releasetime" label="Release time" prop="releasetime">
					<el-input v-model="ruleForm.releasetime" placeholder="Release time" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="type!='info'"  label="product details" prop="productdetails">
					<editor 
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.productdetails" 
						class="editor" 
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.productdetails" label="product details" prop="productdetails">
                    <span :style='{"fontSize":"16px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.productdetails"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"0"}' class="btn">
				<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">submit</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type!='info'" class="btn-close" @click="back()">cancel</el-button>
				<el-button :style='{"border":"0px solid #1b5a90","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' v-if="type=='info'" class="btn-close" @click="back()">return</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，ID card校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("Enter the correct ID number"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("Enter the correct URL address"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("Enter the correct phone number"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("Enter the correct phone number"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("Enter the correct email address"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("Enter number"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("Enter integer"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
			ro:{
				productname : false,
				productclassification : false,
				productnumber : false,
				cover : false,
				issuinginstitution : false,
				termtype : false,
				operationmode : false,
				fundraisingmethod : false,
				fundraisingcurrency : false,
				risklevel : false,
				investmentnature : false,
				actualdays : false,
				releasetime : false,
				productdetails : false,
				clicktime : false,
				clicknum : false,
			},
			
			
			ruleForm: {
				productname: '',
				productclassification: '',
				productnumber: '',
				cover: '',
				issuinginstitution: '',
				termtype: '',
				operationmode: '',
				fundraisingmethod: '',
				fundraisingcurrency: '',
				risklevel: '',
				investmentnature: '',
				actualdays: '',
				releasetime: '',
				productdetails: '',
				clicktime: '',
			},
		
			productclassificationOptions: [],

			
			rules: {
				productname: [
				],
				productclassification: [
				],
				productnumber: [
				],
				cover: [
				],
				issuinginstitution: [
				],
				termtype: [
				],
				operationmode: [
				],
				fundraisingmethod: [
				],
				fundraisingcurrency: [
				],
				risklevel: [
				],
				investmentnature: [
				],
				actualdays: [
				],
				releasetime: [
				],
				productdetails: [
				],
				clicktime: [
				],
				clicknum: [
					{ validator: validateIntNumber, trigger: 'blur' },
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
	},
	methods: {
		
		// download
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='productname'){
							this.ruleForm.productname = obj[o];
							this.ro.productname = true;
							continue;
						}
						if(o=='productclassification'){
							this.ruleForm.productclassification = obj[o];
							this.ro.productclassification = true;
							continue;
						}
						if(o=='productnumber'){
							this.ruleForm.productnumber = obj[o];
							this.ro.productnumber = true;
							continue;
						}
						if(o=='cover'){
							this.ruleForm.cover = obj[o];
							this.ro.cover = true;
							continue;
						}
						if(o=='issuinginstitution'){
							this.ruleForm.issuinginstitution = obj[o];
							this.ro.issuinginstitution = true;
							continue;
						}
						if(o=='termtype'){
							this.ruleForm.termtype = obj[o];
							this.ro.termtype = true;
							continue;
						}
						if(o=='operationmode'){
							this.ruleForm.operationmode = obj[o];
							this.ro.operationmode = true;
							continue;
						}
						if(o=='fundraisingmethod'){
							this.ruleForm.fundraisingmethod = obj[o];
							this.ro.fundraisingmethod = true;
							continue;
						}
						if(o=='fundraisingcurrency'){
							this.ruleForm.fundraisingcurrency = obj[o];
							this.ro.fundraisingcurrency = true;
							continue;
						}
						if(o=='risklevel'){
							this.ruleForm.risklevel = obj[o];
							this.ro.risklevel = true;
							continue;
						}
						if(o=='investmentnature'){
							this.ruleForm.investmentnature = obj[o];
							this.ro.investmentnature = true;
							continue;
						}
						if(o=='actualdays'){
							this.ruleForm.actualdays = obj[o];
							this.ro.actualdays = true;
							continue;
						}
						if(o=='releasetime'){
							this.ruleForm.releasetime = obj[o];
							this.ro.releasetime = true;
							continue;
						}
						if(o=='productdetails'){
							this.ruleForm.productdetails = obj[o];
							this.ro.productdetails = true;
							continue;
						}
						if(o=='clicktime'){
							this.ruleForm.clicktime = obj[o];
							this.ro.clicktime = true;
							continue;
						}
						if(o=='clicknum'){
							this.ruleForm.clicknum = obj[o];
							this.ro.clicknum = true;
							continue;
						}
				}
				
















			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/productclassification/productclassification`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.productclassificationOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `wealthmanagementproducts/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传image后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表All
        this.ruleForm.productdetails = this.ruleForm.productdetails.replace(reg,'../../../springbootc004o809/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // submit
    onSubmit() {








	if(this.ruleForm.cover!=null) {
		this.ruleForm.cover = this.ruleForm.cover.replace(new RegExp(this.$base.url,"g"),"");
	}

























var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "wealthmanagementproducts/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `wealthmanagementproducts/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "operate success",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.wealthmanagementproductsCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `wealthmanagementproducts/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "operate success",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.wealthmanagementproductsCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // return
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.wealthmanagementproductsCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    coverUploadChange(fileUrls) {
	    this.ruleForm.cover = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #666;
	  	  font-weight: 500;
	  	  width: 180px;
	  	  font-size: 16px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 180px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 200px;
	  	  font-size: 16px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 1px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #ccc;
	  	  background: #fff;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  line-height: 100px;
	  	  text-align: center;
	  	  height: 100px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 1px solid #ddd;
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 1px 2px 3px #eee;
	  	  outline: none;
	  	  color: #aaa;
	  	  width: 400px;
	  	  font-size: 16px;
	  	  min-height: 120px;
	  	  height: auto;
	  	}
</style>
