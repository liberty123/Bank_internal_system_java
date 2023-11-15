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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="product image" v-if="type!='cross' || (type=='cross' && !ro.productimage)" prop="productimage">
            <file-upload
            tip="Click to upload product image"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.productimage?ruleForm.productimage:''"
            @change="productimageUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' class="upload" v-else label="product image" prop="productimage">
                <img v-if="ruleForm.productimage.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.productimage.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.productimage.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Product Properties" prop="productnature">
            <el-input v-model="ruleForm.productnature" 
                placeholder="Product Properties" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="Loan method" prop="loanmethod">
            <el-select v-model="ruleForm.loanmethod" placeholder="Please select Loan method"  >
              <el-option
                  v-for="(item,index) in loanmethodOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="lending rate" prop="loaninterestrate">
            <el-input v-model="ruleForm.loaninterestrate" 
                placeholder="lending rate" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Available loan amount" prop="loanamount">
            <el-input v-model="ruleForm.loanamount" 
                placeholder="Available loan amount" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Release Date" prop="releasedate" >
              <el-date-picker
                  format="yyyy-MM-dd"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.releasedate" 
                  type="date"
                  placeholder="Release Date">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Branch name" prop="branchname">
            <el-input v-model="ruleForm.branchname" 
                placeholder="Branch name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="node address" prop="branchaddress">
            <el-input v-model="ruleForm.branchaddress" 
                placeholder="node address" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Product Introduction" prop="productintroduction">
            <editor 
                :style='{"border":"1px solid #d2e5fd","minHeight":"300px","padding":"0","margin":"0","backgroundColor":"#fff","borderRadius":"0","width":"100%","height":"auto"}'
                v-model="ruleForm.productintroduction" 
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
            productimage : false,
            productnature : false,
            loanmethod : false,
            loaninterestrate : false,
            loanamount : false,
            releasedate : false,
            branchname : false,
            branchaddress : false,
            productintroduction : false,
            clicktime : false,
            clicknum : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          productname: '',
          productclassification: '',
          productimage: '',
          productnature: '',
          loanmethod: '',
          loaninterestrate: '',
          loanamount: '',
          releasedate: '',
          branchname: '',
          branchaddress: '',
          productintroduction: '',
          clicktime: '',
          clicknum: '',
        },
        productclassificationOptions: [],
        loanmethodOptions: [],


        rules: {
          productname: [
            { required: true, message: 'product nameCannot be empty', trigger: 'blur' },
          ],
          productclassification: [
            { required: true, message: 'product classCannot be empty', trigger: 'blur' },
          ],
          productimage: [
          ],
          productnature: [
          ],
          loanmethod: [
          ],
          loaninterestrate: [
          ],
          loanamount: [
          ],
          releasedate: [
          ],
          branchname: [
          ],
          branchaddress: [
          ],
          productintroduction: [
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
      this.ruleForm.releasedate = this.getCurDate()
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
            if(o=='productimage'){
              this.ruleForm.productimage = obj[o].split(",")[0];
              this.ro.productimage = true;
              continue;
            }
            if(o=='productnature'){
              this.ruleForm.productnature = obj[o];
              this.ro.productnature = true;
              continue;
            }
            if(o=='loanmethod'){
              this.ruleForm.loanmethod = obj[o];
              this.ro.loanmethod = true;
              continue;
            }
            if(o=='loaninterestrate'){
              this.ruleForm.loaninterestrate = obj[o];
              this.ro.loaninterestrate = true;
              continue;
            }
            if(o=='loanamount'){
              this.ruleForm.loanamount = obj[o];
              this.ro.loanamount = true;
              continue;
            }
            if(o=='releasedate'){
              this.ruleForm.releasedate = obj[o];
              this.ro.releasedate = true;
              continue;
            }
            if(o=='branchname'){
              this.ruleForm.branchname = obj[o];
              this.ro.branchname = true;
              continue;
            }
            if(o=='branchaddress'){
              this.ruleForm.branchaddress = obj[o];
              this.ro.branchaddress = true;
              continue;
            }
            if(o=='productintroduction'){
              this.ruleForm.productintroduction = obj[o];
              this.ro.productintroduction = true;
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
        this.$http.get('option/loanmethods/loanmethod', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.loanmethodOptions = res.data.data;
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info(id) {
        this.$http.get('loanproducts/detail/${id}', {emulateJSON: true}).then(res => {
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
                 this.$http.get('loanproducts/list', {
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


                          this.$http.post('loanproducts/add', this.ruleForm).then(res => {
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


                  this.$http.post('loanproducts/add', this.ruleForm).then(res => {
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
      productimageUploadChange(fileUrls) {
          this.ruleForm.productimage = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
