<template>
  <div :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230329/eff4ea96c952463cb46b9c79d043ce56.gif) fixed,#f6f6f6"}'>
    <el-form
	  :style='{"padding":"20px","boxShadow":"0 0px 0px #ddd","borderRadius":"0px","background":"none"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="180px"
    >  
     <el-row>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='bankemployee'"  label="Employee ID" prop="employeeid">
          <el-input v-model="ruleForm.employeeid" readonly              placeholder="Employee ID" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='bankemployee'"  label="Employee Name" prop="employeename">
          <el-input v-model="ruleForm.employeename"               placeholder="Employee Name" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='bankemployee'"  label="department" prop="department">
          <el-input v-model="ruleForm.department"               placeholder="department" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='bankemployee'"  label="Professional title" prop="professionaltitle">
          <el-input v-model="ruleForm.professionaltitle"               placeholder="Professional title" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='bankemployee'"  label="gender" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="Please select gender">
            <el-option
                v-for="(item,index) in bankemployeegenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='bankemployee'"  label="Telephone" prop="contactphone">
          <el-input v-model="ruleForm.contactphone"               placeholder="Telephone" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='bankemployee'"  label="network" prop="branch">
          <el-input v-model="ruleForm.branch"               placeholder="network" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='customer'"  label="client number" prop="customernumber">
          <el-input v-model="ruleForm.customernumber" readonly              placeholder="client number" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='customer'"  label="full name" prop="name">
          <el-input v-model="ruleForm.name"               placeholder="full name" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='customer'"  label="gender" prop="gender">
          <el-select v-model="ruleForm.gender"  placeholder="Please select gender">
            <el-option
                v-for="(item,index) in customergenderOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='customer'"  label="phone" prop="phonenumber">
          <el-input v-model="ruleForm.phonenumber"               placeholder="phone" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='customer'" label="head sculpture" prop="touxiang">
          <file-upload
          tip="Click to uploadhead sculpture"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="customertouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='customer'"  label="ID card" prop="idcard">
          <el-input v-model="ruleForm.idcard"               placeholder="ID card" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='customer'"  label="intention" prop="intention">
          <el-input v-model="ruleForm.intention"               placeholder="intention" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"margin":"0 0 20px 0"}'   v-if="flag=='customer'"  label="deposit" prop="deposit">
          <el-input v-model="ruleForm.deposit" readonly              placeholder="deposit" clearable></el-input>
        </el-form-item>
		<el-form-item :style='{"margin":"0 0 20px 0"}' v-if="flag=='users'" label="Username" prop="username">
			<el-input v-model="ruleForm.username" placeholder="Username"></el-input>
		</el-form-item>
		<el-form-item :style='{"padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"128px","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="primary" @click="onUpdateHandler">Modify</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，ID card校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      bankemployeegenderOptions: [],
      customergenderOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.bankemployeegenderOptions = "Male, female".split(',')
    this.customergenderOptions = "Male, female".split(',')
  },
  methods: {
    customertouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    onUpdateHandler() {














      if( 'bankemployee' ==this.flag && this.ruleForm.contactphone&&(!isMobile(this.ruleForm.contactphone))){
        this.$message.error(`Telephone should enter phone format`);
        return
      }


      if((!this.ruleForm.customernumber)&& 'customer'==this.flag){
        this.$message.error('client numberCannot be empty');
        return
      }


      if((!this.ruleForm.name)&& 'customer'==this.flag){
        this.$message.error('full nameCannot be empty');
        return
      }


      if((!this.ruleForm.password)&& 'customer'==this.flag){
        this.$message.error('PasswordCannot be empty');
        return
      }






      if( 'customer' ==this.flag && this.ruleForm.phonenumber&&(!isMobile(this.ruleForm.phonenumber))){
        this.$message.error(`Phone should enter phone format`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }


      if( 'customer' ==this.flag && this.ruleForm.idcard&&(!checkIdCard(this.ruleForm.idcard))){
        this.$message.error(`ID card should be entered in ID card format`);
        return
      }




      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`UsernameCannot be empty`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "Modify information successfully",
            type: "success",
            duration: 1500,
            onClose: () => {
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
