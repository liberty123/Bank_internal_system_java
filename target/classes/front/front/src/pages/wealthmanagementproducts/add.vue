<template>
<div :style='{"width":"90%","padding":"30px 0px 40px","margin":"10px auto","position":"relative","background":"rgba(255,255,255,.0)"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="product name" prop="productname">
            <el-input v-model="ruleForm.productname" 
                placeholder="product name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="product class" prop="productclassification">
            <el-select v-model="ruleForm.productclassification" placeholder="Please select product class"  >
              <el-option
                  v-for="(item,index) in productclassificationOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="product  number" prop="productnumber">
            <el-input v-model="ruleForm.productnumber" 
                placeholder="product  number" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="cover" v-if="type!='cross' || (type=='cross' && !ro.cover)" prop="cover">
            <file-upload
            tip="Click to upload the cover page"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.cover?ruleForm.cover:''"
            @change="coverUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' class="upload" v-else label="cover" prop="cover">
                <img v-if="ruleForm.cover.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cover.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cover.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Issuing institution" prop="issuinginstitution">
            <el-input v-model="ruleForm.issuinginstitution" 
                placeholder="Issuing institution" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Term Type" prop="termtype">
            <el-input v-model="ruleForm.termtype" 
                placeholder="Term Type" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="operation pattern" prop="operationmode">
            <el-input v-model="ruleForm.operationmode" 
                placeholder="operation pattern" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Fundraising method" prop="fundraisingmethod">
            <el-input v-model="ruleForm.fundraisingmethod" 
                placeholder="Fundraising method" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Fundraising currency" prop="fundraisingcurrency">
            <el-input v-model="ruleForm.fundraisingcurrency" 
                placeholder="Fundraising currency" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Risk level" prop="risklevel">
            <el-input v-model="ruleForm.risklevel" 
                placeholder="Risk level" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Investment nature" prop="investmentnature">
            <el-input v-model="ruleForm.investmentnature" 
                placeholder="Investment nature" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Actual Days" prop="actualdays">
            <el-input v-model="ruleForm.actualdays" 
                placeholder="Actual Days" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Release time" prop="releasetime" >
              <el-date-picker
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.releasetime" 
                  type="date"
                  placeholder="Release time">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="product details" prop="productdetails">
            <editor 
                :style='{"border":"1px solid #d2e5fd","minHeight":"300px","padding":"0","margin":"0","backgroundColor":"#fff","borderRadius":"0","width":"100%","height":"auto"}'
                v-model="ruleForm.productdetails" 
                class="editor" 
                action="file/upload">
            </editor>
          </el-form-item>

      <el-form-item :style='{"padding":"0","textAlign":"center","margin":"0"}'>
        <el-button :style='{"border":"5px outset #6eb9ff","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"#333","borderRadius":"4px","background":"#fff","width":"128px","lineHeight":"40px","fontSize":"14px","height":"46px"}'  type="primary" @click="onSubmit">submit</el-button>
        <el-button :style='{"border":"5px outset #d1d1d1","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#333","borderRadius":"4px","background":"rgba(255, 255, 255, 1)","width":"128px","lineHeight":"40px","fontSize":"14px","height":"46px"}' @click="back()">return</el-button>
      </el-form-item>
    </el-form>
</div>
</template>

<script>
  export default {
    data() {
      return {
        id: '',
        baseUrl: '',
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
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
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
          clicknum: '',
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
            { validator: this.$validate.isIntNumer, trigger: 'blur' },
          ],
        },
      };
    },
    computed: {



    },
    components: {
    },
    created() {
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // download
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
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
              this.ruleForm.cover = obj[o].split(",")[0];
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
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/productclassification/productclassification', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.productclassificationOptions = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('wealthmanagementproducts/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // submit
      onSubmit() {

        //更新跨表属性
        var crossuserid;
        var crossrefid;
        var crossoptnum;
        this.$refs["ruleForm"].validate(valid => {
          if(valid) {
            if(this.type=='cross'){
                 var statusColumnName = localStorage.getItem('statusColumnName');
                 var statusColumnValue = localStorage.getItem('statusColumnValue');
                 if(statusColumnName && statusColumnName!='') {
                     var obj = JSON.parse(localStorage.getItem('crossObj'));
                     if(!statusColumnName.startsWith("[")) {
                         for (var o in obj){
                             if(o==statusColumnName){
                                 obj[o] = statusColumnValue;
                             }
                         }
                         var table = localStorage.getItem('crossTable');
                         this.$http.post(table+'/update', obj).then(res => {});
                     } else {
                            crossuserid=Number(localStorage.getItem('userid'));
                            crossrefid=obj['id'];
                            crossoptnum=localStorage.getItem('statusColumnName');
                            crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                     }
                 }
            }
            if(crossrefid && crossuserid) {
                 this.ruleForm.crossuserid=crossuserid;
                 this.ruleForm.crossrefid=crossrefid;
                 var params = {
                     page: 1,
                     limit: 10,
                     crossuserid:crossuserid,
                     crossrefid:crossrefid,
                 }
                 this.$http.get('wealthmanagementproducts/list', {
                  params: params
                 }).then(res => {
                     if(res.data.data.total>=crossoptnum) {
                         this.$message({
                          message: localStorage.getItem('tips'),
                          type: 'success',
                          duration: 1500,
                         });
                          return false;
                     } else {
                         // 跨表计算


                          this.$http.post('wealthmanagementproducts/add', this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: 'operate success',
                                      type: 'success',
                                      duration: 1500,
                                      onClose: () => {
                                          this.$router.go(-1);
                                      }
                                  });
                              } else {
                                  this.$message({
                                      message: res.data.msg,
                                      type: 'error',
                                      duration: 1500
                                  });
                              }
                          });
                     }
                 });
             } else {


                  this.$http.post('wealthmanagementproducts/add', this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: 'operate success',
                              type: 'success',
                              duration: 1500,
                              onClose: () => {
                                  this.$router.go(-1);
                              }
                          });
                      } else {
                          this.$message({
                              message: res.data.msg,
                              type: 'error',
                              duration: 1500
                          });
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
        this.$router.go(-1);
      },
      coverUploadChange(fileUrls) {
          this.ruleForm.cover = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
      },
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  padding: 0 10px 0 0;
	  color: #3d74c0;
	  font-weight: 500;
	  width: 120px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 0 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 0 10px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 0 10px 0 30px;
	  outline: none;
	  color: #333;
	  width: 200px;
	  font-size: 14px;
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
	  border: 1px solid #d2e5fd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #ddd;
	  background: #fff;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  border: 1px solid #d2e5fd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #ddd;
	  background: #fff;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  border: 1px solid #d2e5fd;
	  cursor: pointer;
	  border-radius: 6px;
	  color: #ddd;
	  background: #fff;
	  width: 100px;
	  font-size: 32px;
	  line-height: 100px;
	  text-align: center;
	  height: 100px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 1px solid #d2e5fd;
	  border-radius: 4px;
	  padding: 12px;
	  outline: none;
	  color: #333;
	  width: 400px;
	  font-size: 14px;
	  height: 120px;
	}
</style>
