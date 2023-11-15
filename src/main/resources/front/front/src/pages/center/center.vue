<template>
<div class="center-preview" :style='{"width":"90%","margin":"10px auto","position":"relative","background":"none"}'>
	<div class="title" :style='{"margin":"10px 0","fontSize":"20px","lineHeight":"54px","color":"#333","textAlign":"center","background":"none"}'>{{ title }}</div>

    <el-tabs tab-position="left" :style='{"background":"none"}' @tab-click="handleClick">
      <el-tab-pane label="Personal Center">
        <el-form class="center-preview-pv" ref="sessionForm" :model="sessionForm" :rules="rules" label-width="120px">
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="Employee ID" prop="employeeid">
            <el-input v-model="sessionForm.employeeid" placeholder="Employee ID" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="Employee Name" prop="employeename">
            <el-input v-model="sessionForm.employeename" placeholder="Employee Name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="Password" prop="password">
            <el-input type="password" v-model="sessionForm.password" placeholder="Password"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="department" prop="department">
            <el-input v-model="sessionForm.department" placeholder="department" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="Professional title" prop="professionaltitle">
            <el-input v-model="sessionForm.professionaltitle" placeholder="Professional title" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="gender">
            <el-select v-model="sessionForm.gender" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.gender" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="Telephone" prop="contactphone">
            <el-input v-model="sessionForm.contactphone" placeholder="Telephone" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='bankemployee'" label="network" prop="branch">
            <el-input v-model="sessionForm.branch" placeholder="network" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="client number" prop="customernumber">
            <el-input v-model="sessionForm.customernumber" placeholder="client number" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="full name" prop="name">
            <el-input v-model="sessionForm.name" placeholder="full name" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="Password" prop="password">
            <el-input type="password" v-model="sessionForm.password" placeholder="Password"></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="gender">
            <el-select v-model="sessionForm.gender" placeholder="Please select gender" >
              <el-option v-for="(item, index) in dynamicProp.gender" :key="index" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="phone" prop="phonenumber">
            <el-input v-model="sessionForm.phonenumber" placeholder="phone" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="head sculpture">
            <el-upload
              class="avatar-uploader"
              :action="uploadUrl"
              :headers="headers"
              :show-file-list="false"
              :on-success="customertouxiangHandleAvatarSuccess">
              <img :style='{"border":"1px solid #d2e5fd","cursor":"pointer","color":"#333","borderRadius":"6px","textAlign":"center","width":"100px","fontSize":"32px","lineHeight":"100px","height":"100px"}' v-if="sessionForm.touxiang" :src="baseUrl + sessionForm.touxiang" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="ID card" prop="idcard">
            <el-input v-model="sessionForm.idcard" placeholder="ID card" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="intention" prop="intention">
            <el-input v-model="sessionForm.intention" placeholder="intention" ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px","background":"none"}' v-if="userTableName=='customer'" label="deposit" prop="deposit">
            <el-input v-model="sessionForm.deposit" placeholder="deposit" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
            <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"#f8e0e0","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onSubmit('sessionForm')">Update information</el-button>
            <el-button :style='{"border":"0px solid rgba(64, 158, 255, 1)","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"4px","background":"#d6d6d6","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="danger" @click="logout">Outlogin</el-button>
          </el-form-item>
        </el-form>
		
        <el-dialog title="User recharge" :visible.sync="dialogFormVisibleMoney" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="Rechargeamount" label-width="120px">
              <el-input type="number" v-model="chongzhiForm.money" autocomplete="off" placeholder="Rechargeamount"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="WeChat payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">WeChat payment</span>
                </el-radio>
                <el-radio label="Alipay payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">Alipay payment</span>
                </el-radio>
                <el-radio label="China Construction Bank Payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Agricultural Bank of China">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Bank of China">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Bank of Communications">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleMoney = false">Cancel</el-button>
            <el-button type="primary" @click="chongzhi">confirmRecharge</el-button>
          </div>
        </el-dialog>
        <el-dialog title="Member purchase" :visible.sync="dialogFormVisibleVip" width="726px" center>
          <el-form :model="chongzhiForm">
            <el-form-item label="membership card" label-width="120px">
              <el-input readonly autocomplete="off" value="￥199/year"></el-input>
            </el-form-item>
            <el-form-item label-width="120px">
              <el-radio-group v-model="chongzhiForm.radio">
                <el-radio style="margin-bottom: 30px" label="WeChat payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/weixin.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">WeChat payment</span>
                </el-radio>
                <el-radio label="Alipay payment">
                  <el-image
                    style="width: 60px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhifubao.png')"
                    fit="fill"></el-image>
                    <span style="display: inline-block;margin-left: 10px">Alipay payment</span>
                </el-radio>
                <el-radio label="China Construction Bank Payment">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jianshe.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Agricultural Bank of China">
                  <el-image
                    style="width: 126px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/nongye.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Bank of China">
                  <el-image
                    style="width: 140px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/zhongguo.png')"
                    fit="fill"></el-image>
                </el-radio>
                <el-radio label="Payment by Bank of Communications">
                  <el-image
                    style="width: 120px; height: 60px;vertical-align: middle;"
                    :src="require('@/assets/jiaotong.png')"
                    fit="fill"></el-image>
                </el-radio>
              </el-radio-group>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="dialogFormVisibleVip = false">Cancel</el-button>
            <el-button type="primary" @click="chongzhivip">Confirm Payment</el-button>
          </div>
        </el-dialog>
      </el-tab-pane>
      <el-tab-pane label="My Collection"></el-tab-pane>
    </el-tabs>
</div>
</template>

<script>
  import config from '@/config/config'
  import Vue from 'vue'
  export default {
    //数据集合
    data() {
      return {
        title: 'Personal Center',
        baseUrl: config.baseUrl,
        sessionForm: {},
        rules: {},
        chongzhiForm: {
          money: '',
          radio: ''
        },
        disabled: false,
        dialogFormVisibleMoney: false,
        dialogFormVisibleVip: false,
        uploadUrl: config.baseUrl + 'file/upload',
        imageUrl: '',
        headers: {Token: localStorage.getItem('Token')},
        userTableName: localStorage.getItem('UserTableName'),
        dynamicProp: {}
      }
    },
    created() {
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'employeeid', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'employeename', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'password', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'department', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'professionaltitle', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'gender', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'contactphone', null);
      }
      if ('bankemployee' == this.userTableName) {
        this.$set(this.sessionForm, 'branch', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'customernumber', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'name', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'password', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'gender', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'phonenumber', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'touxiang', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'idcard', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'intention', null);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.sessionForm, 'deposit', null);
      }

			if ('bankemployee' == this.userTableName) {
        this.$set(this.rules, 'contactphone', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.rules, 'customernumber', [{ required: true, message: 'Enter client number', trigger: 'blur' }]);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.rules, 'name', [{ required: true, message: 'Enter full name', trigger: 'blur' }]);
      }
      if ('customer' == this.userTableName) {
        this.$set(this.rules, 'password', [{ required: true, message: 'Enter Password', trigger: 'blur' }]);
      }
			if ('customer' == this.userTableName) {
        this.$set(this.rules, 'phonenumber', [{ required: false, validator: this.$validate.isMobile, trigger: 'blur' }]);
      }
			if ('customer' == this.userTableName) {
        this.$set(this.rules, 'idcard', [{ required: false, validator: this.$validate.isIdCard, trigger: 'blur' }]);
      }

      this.init();
      this.getSession();
    },
    //方法集合
    methods: {
      init() {
        if ('bankemployee' == this.userTableName) {
          this.dynamicProp.gender = 'Male, female'.split(',');
        }
        if ('customer' == this.userTableName) {
          this.dynamicProp.gender = 'Male, female'.split(',');
        }
      },
      getSession() {
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.sessionForm = res.data.data;
            localStorage.setItem('userid', res.data.data.id);
            if(res.data.data.vip) {
                localStorage.setItem('vip', res.data.data.vip);
            }
            if(res.data.data.touxiang) {
                localStorage.setItem('headportrait', res.data.data.touxiang);
            } else if(res.data.data.headportrait) {
                localStorage.setItem('headportrait', res.data.data.headportrait);
            }
          }
        });
      },
      onSubmit(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
              if (res.data.code == 0) {
                this.$message({
                  message: 'update success',
                  type: 'success',
                  duration: 1500
                });
              }
            });
          } else {
            return false;
          }
        });
      },
      customertouxiangHandleAvatarSuccess(res, file) {
        if (res.code == 0) {
          if ('customer' == this.userTableName) {
            this.sessionForm.touxiang = 'upload/' + res.file;
          }
        }
      },
      chongzhi() {
        if (this.chongzhiForm.money == '') {
          this.$message({
            message: 'Enter Rechargeamount',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.money <= 0) {
          this.$message({
            message: 'Enter the correct Rechargeamount',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: 'Please select Recharge method',
            type: 'error',
            duration: 1500
          });
          return;
        }
        this.sessionForm.money = parseFloat(this.sessionForm.money) + parseFloat(this.chongzhiForm.money);
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: 'Recharge successful',
              type: 'success',
              duration: 1500,
              onClose: () => {
                this.dialogFormVisibleMoney = false;
              }
            });
          }
        });
      },
      chongzhivip() {
        this.chongzhiForm.money == 199;
        if (this.chongzhiForm.radio == '') {
          this.$message({
            message: 'Please select payment method',
            type: 'error',
            duration: 1500
          });
          return;
        }
        if(this.sessionForm.vip == 'Y') {
          this.$message({
            message: '您已是我们的尊贵会员。',
            type: 'success',
            duration: 1500
          });
          return;
        }
        
        this.sessionForm.vip = "Y"
        this.$http.post(this.userTableName + '/update', this.sessionForm).then(res => {
          if (res.data.code == 0) {
            this.$message({
              message: 'Member purchase成功',
              type: 'success',
              duration: 1500,
              onClose: () => {
                localStorage.setItem('vip', this.sessionForm.vip);
                this.dialogFormVisibleVip = false;
              }
            });
          }
        });
      },
      handleClick(tab, event) {
        switch(event.target.outerText) {
          case 'Personal Center':
            tab.$router.push('/index/center');
            break;
          case 'My Collection':
            localStorage.setItem('storeupType', 1);
            tab.$router.push('/index/storeup');
            break;
        }

        this.title = event.target.outerText;
      },
      logout() {
        localStorage.clear();
        Vue.http.headers.common['Token'] = "";
        this.$router.push('/index/home');
        this.activeIndex = '0'
        localStorage.setItem('keyPath', this.activeIndex)
        this.$forceUpdate()
        this.$message({
            message: 'Successfully logged out',
            type: 'success',
            duration: 1500,
        });
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .center-preview {
  
    .el-tabs {
      & /deep/ .el-tabs__header {
        .el-tabs__nav-wrap {
          margin: 0;
  
          &::after {
            content: none;
          }
        }
  
        .el-tabs__active-bar {
          display: none !important;
        }
      }
  
      .center-preview-pv {
        .el-date-editor.el-input {
          width: auto;
        }
  
        .balance {
          .el-input {
            width: auto;
          }
        }
      }
    }
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header {
	padding: 00px 0px 0px 50px;
	margin: 20px 0 0;
	background: rgba(255,255,255,.0);
	width: 340px;
	border-color: #eee;
	border-width: 0;
	position: relative;
	float: right;
	border-style: solid;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item {
  	border: 1px solid #ddd;
  	padding: 0 10px;
  	margin: 0 0 24px;
  	color: #333;
  	background: #f5f5f5;
  	font-weight: 500;
  	width: 250px;
  	font-size: 14px;
  	line-height: 50px;
  	position: relative;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item:hover {
  	border: 1px solid #fff;
  	padding: 0 10px;
  	color: #fff;
  	background: linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 80%, rgba(48,134,185,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	position: relative;
  	text-align: center;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__header .el-tabs__item.is-active {
  	border: 1px solid #fff;
  	padding: 0 10px;
  	color: #fff;
  	background: linear-gradient(320deg, rgba(48,134,185,1) 0%, rgba(197,230,250,1) 80%, rgba(48,134,185,1) 100%);
  	font-weight: 500;
  	font-size: 14px;
  	line-height: 50px;
  	position: relative;
  	text-align: center;
  	height: 50px;
  }
  
  .center-preview .el-tabs /deep/ .el-tabs__content .el-tab-pane {
  	border: 10px inset #98c6e2;
  	padding: 20px 0;
  	background: #fff;
  }
  
  .center-preview-pv .el-form-item /deep/ .el-form-item__label {
  	padding: 0 10px 0 0;
  	color: #666;
  	font-weight: 500;
  	width: 120px;
  	font-size: 14px;
  	line-height: 40px;
  	text-align: right;
  }
  
  .center-preview-pv .el-form-item .el-form-item__content {
    margin-left: 120px;
  }
  
  .center-preview-pv .el-input /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-select /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	width: 400px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv .el-date-editor /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 10px 0 30px;
  	outline: none;
  	color: #333;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
  
  .center-preview-pv /deep/ .avatar-uploader-icon {
  	border: 1px solid #d2e5fd;
  	cursor: pointer;
  	border-radius: 6px;
  	color: #333;
  	width: 100px;
  	font-size: 32px;
  	line-height: 100px;
  	text-align: center;
  	height: 100px;
  }
  
  .center-preview-pv .el-form-item.balance /deep/ .el-input__inner {
  	border: 1px solid #d2e5fd;
  	border-radius: 4px;
  	padding: 0 12px;
  	outline: none;
  	color: #333;
  	display: inline-block;
  	width: 200px;
  	font-size: 14px;
  	height: 40px;
  }
</style>
