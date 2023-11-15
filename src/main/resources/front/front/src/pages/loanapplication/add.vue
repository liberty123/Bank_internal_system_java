<template>
<div :style='{"width":"90%","padding":"30px 0px 40px","margin":"10px auto","position":"relative","background":"rgba(255,255,255,.0)"}'>
    <el-form
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="120px"
    >
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loan number" prop="loannumber">
              <el-input v-model="ruleForm.loannumber" placeholder="loan number" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="product name" prop="productname">
            <el-input v-model="ruleForm.productname" 
                placeholder="product name" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="product class" prop="productclassification">
            <el-select v-model="ruleForm.productclassification" placeholder="Please select product class" disabled >
              <el-option
                  v-for="(item,index) in productclassificationOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Product Properties" prop="productnature">
            <el-input v-model="ruleForm.productnature" 
                placeholder="Product Properties" clearable readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}'  label="Loan method" prop="loanmethod">
            <el-select v-model="ruleForm.loanmethod" placeholder="Please select Loan method" disabled >
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
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loanamount" prop="loanpaymentamount">
            <el-input v-model="ruleForm.loanpaymentamount" 
                placeholder="loanamount" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Branch name" prop="branchname">
            <el-input v-model="ruleForm.branchname" 
                placeholder="Branch name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="node address" prop="branchaddress">
            <el-input v-model="ruleForm.branchaddress" 
                placeholder="node address" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="client number" prop="customernumber">
            <el-input v-model="ruleForm.customernumber" 
                placeholder="client number" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="full name" prop="name">
            <el-input v-model="ruleForm.name" 
                placeholder="full name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="phone" prop="phonenumber">
            <el-input v-model="ruleForm.phonenumber" 
                placeholder="phone" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="ID card" prop="idcard">
            <el-input v-model="ruleForm.idcard" 
                placeholder="ID card" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="Related information" prop="relatedinformation">
            <file-upload
            tip="Click to uploadRelated information"
            action="file/upload"
            :limit="1"
            :multiple="true"
            :fileUrls="ruleForm.relatedinformation?ruleForm.relatedinformation:''"
            @change="relatedinformationUploadChange"
            ></file-upload>
          </el-form-item>  
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="applicationtime" prop="applicationtime" >
              <el-date-picker
                  value-format="yyyy-MM-dd HH:mm:ss"
                  v-model="ruleForm.applicationtime" 
                  type="datetime"
                  placeholder="applicationtime">
              </el-date-picker>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loannumber" prop="loannumber">
            <el-input v-model="ruleForm.loannumber"
                placeholder="loannumber" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="productname" prop="productname">
            <el-input v-model="ruleForm.productname"
                placeholder="productname" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="productclassification" prop="productclassification">
            <el-input v-model="ruleForm.productclassification"
                placeholder="productclassification" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="productnature" prop="productnature">
            <el-input v-model="ruleForm.productnature"
                placeholder="productnature" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loanmethod" prop="loanmethod">
            <el-input v-model="ruleForm.loanmethod"
                placeholder="loanmethod" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loaninterestrate" prop="loaninterestrate">
            <el-input v-model="ruleForm.loaninterestrate"
                placeholder="loaninterestrate" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loanpaymentamount" prop="loanpaymentamount">
            <el-input v-model="ruleForm.loanpaymentamount"
                placeholder="loanpaymentamount" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="branchname" prop="branchname">
            <el-input v-model="ruleForm.branchname"
                placeholder="branchname" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="branchaddress" prop="branchaddress">
            <el-input v-model="ruleForm.branchaddress"
                placeholder="branchaddress" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="customernumber" prop="customernumber">
            <el-input v-model="ruleForm.customernumber"
                placeholder="customernumber" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="name" prop="name">
            <el-input v-model="ruleForm.name"
                placeholder="name" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="phonenumber" prop="phonenumber">
            <el-input v-model="ruleForm.phonenumber"
                placeholder="phonenumber" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="idcard" prop="idcard">
            <el-input v-model="ruleForm.idcard"
                placeholder="idcard" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="relatedinformation" prop="relatedinformation">
            <el-input v-model="ruleForm.relatedinformation"
                placeholder="relatedinformation" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="applicationtime" prop="applicationtime">
            <el-input v-model="ruleForm.applicationtime"
                placeholder="applicationtime" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="shhf" prop="shh">
            <el-input v-model="ruleForm.shh" 
                placeholder="shhf" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loan_amnt" prop="loanamnt">
            <el-input v-model="ruleForm.loanamnt" 
                placeholder="loan_amnt" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="term" prop="term">
            <el-input v-model="ruleForm.term" 
                placeholder="term" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="intrate" prop="intrate">
            <el-input v-model="ruleForm.intrate" 
                placeholder="intrate" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="installment" prop="installment">
            <el-input v-model="ruleForm.installment" 
                placeholder="installment" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="grade" prop="grade">
            <el-input v-model="ruleForm.grade" 
                placeholder="grade" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="sub_grade" prop="sub_grade">
            <el-input v-model="ruleForm.sub_grade" 
                placeholder="sub_grade" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="sub_gradehip" prop="subgradehip">
            <el-input v-model="ruleForm.subgradehip" 
                placeholder="sub_gradehip" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="annual_inc" prop="annualinc">
            <el-input v-model="ruleForm.annualinc" 
                placeholder="annual_inc" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="verification_status" prop="verificationstatus">
            <el-input v-model="ruleForm.verificationstatus" 
                placeholder="verification_status" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="issue_d" prop="issued">
            <el-input v-model="ruleForm.issued" 
                placeholder="issue_d" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="loan_status" prop="loanstatus">
            <el-input v-model="ruleForm.loanstatus" 
                placeholder="loan_status" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="purpose" prop="purpose">
            <el-input v-model="ruleForm.purpose" 
                placeholder="purpose" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="dti" prop="dti">
            <el-input v-model="ruleForm.dti" 
                placeholder="dti" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="earliest_cr_line" prop="earliestcrline">
            <el-input v-model="ruleForm.earliestcrline" 
                placeholder="earliest_cr_line" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="open_acc" prop="open">
            <el-input v-model="ruleForm.open" 
                placeholder="open_acc" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="pub_rec" prop="pub">
            <el-input v-model="ruleForm.pub" 
                placeholder="pub_rec" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="revol_bal" prop="revolbal">
            <el-input v-model="ruleForm.revolbal" 
                placeholder="revol_bal" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="revol_util" prop="revolutil">
            <el-input v-model="ruleForm.revolutil" 
                placeholder="revol_util" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="total_acc" prop="totalacc">
            <el-input v-model="ruleForm.totalacc" 
                placeholder="total_acc" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="initial_list_status" prop="initialliststatus">
            <el-input v-model="ruleForm.initialliststatus" 
                placeholder="initial_list_status" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="application_type" prop="applicationtype">
            <el-input v-model="ruleForm.applicationtype" 
                placeholder="application_type" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="pub_rec_bankruptcies" prop="pubrecbankruptcies">
            <el-input v-model="ruleForm.pubrecbankruptcies" 
                placeholder="pub_rec_bankruptcies" clearable ></el-input>
          </el-form-item>
          <el-form-item :style='{"padding":"10px","margin":"0 0 10px"}' label="mort_acc" prop="mortacc">
            <el-input v-model="ruleForm.mortacc" 
                placeholder="mort_acc" clearable ></el-input>
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
            loannumber : false,
            productname : false,
            productclassification : false,
            productnature : false,
            loanmethod : false,
            loaninterestrate : false,
            loanpaymentamount : false,
            branchname : false,
            branchaddress : false,
            customernumber : false,
            name : false,
            phonenumber : false,
            idcard : false,
            relatedinformation : false,
            applicationtime : false,
            loannumber : false,
            productname : false,
            productclassification : false,
            productnature : false,
            loanmethod : false,
            loaninterestrate : false,
            loanpaymentamount : false,
            branchname : false,
            branchaddress : false,
            customernumber : false,
            name : false,
            phonenumber : false,
            idcard : false,
            relatedinformation : false,
            applicationtime : false,
            shh : false,
            loanamnt : false,
            term : false,
            intrate : false,
            installment : false,
            grade : false,
            sub_grade : false,
            subgradehip : false,
            annualinc : false,
            verificationstatus : false,
            issued : false,
            loanstatus : false,
            purpose : false,
            dti : false,
            earliestcrline : false,
            open : false,
            pub : false,
            revolbal : false,
            revolutil : false,
            totalacc : false,
            initialliststatus : false,
            applicationtype : false,
            pubrecbankruptcies : false,
            mortacc : false,
            sfsh : false,
            shhf : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          loannumber: this.getUUID(),
          productname: '',
          productclassification: '',
          productnature: '',
          loanmethod: '',
          loaninterestrate: '',
          loanpaymentamount: '',
          branchname: '',
          branchaddress: '',
          customernumber: '',
          name: '',
          phonenumber: '',
          idcard: '',
          relatedinformation: '',
          applicationtime: '',
          loannumber: '',
          productname: '',
          productclassification: '',
          productnature: '',
          loanmethod: '',
          loaninterestrate: '',
          loanpaymentamount: '',
          branchname: '',
          branchaddress: '',
          customernumber: '',
          name: '',
          phonenumber: '',
          idcard: '',
          relatedinformation: '',
          applicationtime: '',
          shh: '',
          loanamnt: '',
          term: '',
          intrate: '',
          installment: '',
          grade: '',
          sub_grade: '',
          subgradehip: '',
          annualinc: '',
          verificationstatus: '',
          issued: '',
          loanstatus: '',
          purpose: '',
          dti: '',
          earliestcrline: '',
          open: '',
          pub: '',
          revolbal: '',
          revolutil: '',
          totalacc: '',
          initialliststatus: '',
          applicationtype: '',
          pubrecbankruptcies: '',
          mortacc: '',
        },
        productclassificationOptions: [],
        loanmethodOptions: [],


        rules: {
          loannumber: [
          ],
          productname: [
            { required: true, message: 'product nameCannot be empty', trigger: 'blur' },
          ],
          productclassification: [
            { required: true, message: 'product classCannot be empty', trigger: 'blur' },
          ],
          productnature: [
          ],
          loanmethod: [
          ],
          loaninterestrate: [
          ],
          loanpaymentamount: [
          ],
          branchname: [
          ],
          branchaddress: [
          ],
          customernumber: [
          ],
          name: [
          ],
          phonenumber: [
          ],
          idcard: [
          ],
          relatedinformation: [
          ],
          applicationtime: [
          ],
          loannumber: [
          ],
          productname: [
          ],
          productclassification: [
          ],
          productnature: [
          ],
          loanmethod: [
          ],
          loaninterestrate: [
          ],
          loanpaymentamount: [
          ],
          branchname: [
          ],
          branchaddress: [
          ],
          customernumber: [
          ],
          name: [
          ],
          phonenumber: [
          ],
          idcard: [
          ],
          relatedinformation: [
          ],
          applicationtime: [
          ],
          shh: [
          ],
          loanamnt: [
          ],
          term: [
          ],
          intrate: [
          ],
          installment: [
          ],
          grade: [
          ],
          sub_grade: [
          ],
          subgradehip: [
          ],
          annualinc: [
          ],
          verificationstatus: [
          ],
          issued: [
          ],
          loanstatus: [
          ],
          purpose: [
          ],
          dti: [
          ],
          earliestcrline: [
          ],
          open: [
          ],
          pub: [
          ],
          revolbal: [
          ],
          revolutil: [
          ],
          totalacc: [
          ],
          initialliststatus: [
          ],
          applicationtype: [
          ],
          pubrecbankruptcies: [
          ],
          mortacc: [
          ],
          sfsh: [
          ],
          shhf: [
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
      this.ruleForm.applicationtime = this.getCurDateTime()
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
            if(o=='loannumber'){
              this.ruleForm.loannumber = obj[o];
              this.ro.loannumber = true;
              continue;
            }
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
            if(o=='loanpaymentamount'){
              this.ruleForm.loanpaymentamount = obj[o];
              this.ro.loanpaymentamount = true;
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
            if(o=='customernumber'){
              this.ruleForm.customernumber = obj[o];
              this.ro.customernumber = true;
              continue;
            }
            if(o=='name'){
              this.ruleForm.name = obj[o];
              this.ro.name = true;
              continue;
            }
            if(o=='phonenumber'){
              this.ruleForm.phonenumber = obj[o];
              this.ro.phonenumber = true;
              continue;
            }
            if(o=='idcard'){
              this.ruleForm.idcard = obj[o];
              this.ro.idcard = true;
              continue;
            }
            if(o=='relatedinformation'){
              this.ruleForm.relatedinformation = obj[o];
              this.ro.relatedinformation = true;
              continue;
            }
            if(o=='applicationtime'){
              this.ruleForm.applicationtime = obj[o];
              this.ro.applicationtime = true;
              continue;
            }
            if(o=='loannumber'){
              this.ruleForm.loannumber = obj[o];
              this.ro.loannumber = true;
              continue;
            }
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
            if(o=='loanpaymentamount'){
              this.ruleForm.loanpaymentamount = obj[o];
              this.ro.loanpaymentamount = true;
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
            if(o=='customernumber'){
              this.ruleForm.customernumber = obj[o];
              this.ro.customernumber = true;
              continue;
            }
            if(o=='name'){
              this.ruleForm.name = obj[o];
              this.ro.name = true;
              continue;
            }
            if(o=='phonenumber'){
              this.ruleForm.phonenumber = obj[o];
              this.ro.phonenumber = true;
              continue;
            }
            if(o=='idcard'){
              this.ruleForm.idcard = obj[o];
              this.ro.idcard = true;
              continue;
            }
            if(o=='relatedinformation'){
              this.ruleForm.relatedinformation = obj[o];
              this.ro.relatedinformation = true;
              continue;
            }
            if(o=='applicationtime'){
              this.ruleForm.applicationtime = obj[o];
              this.ro.applicationtime = true;
              continue;
            }
            if(o=='shh'){
              this.ruleForm.shh = obj[o];
              this.ro.shh = true;
              continue;
            }
            if(o=='loanamnt'){
              this.ruleForm.loanamnt = obj[o];
              this.ro.loanamnt = true;
              continue;
            }
            if(o=='term'){
              this.ruleForm.term = obj[o];
              this.ro.term = true;
              continue;
            }
            if(o=='intrate'){
              this.ruleForm.intrate = obj[o];
              this.ro.intrate = true;
              continue;
            }
            if(o=='installment'){
              this.ruleForm.installment = obj[o];
              this.ro.installment = true;
              continue;
            }
            if(o=='grade'){
              this.ruleForm.grade = obj[o];
              this.ro.grade = true;
              continue;
            }
            if(o=='sub_grade'){
              this.ruleForm.sub_grade = obj[o];
              this.ro.sub_grade = true;
              continue;
            }
            if(o=='subgradehip'){
              this.ruleForm.subgradehip = obj[o];
              this.ro.subgradehip = true;
              continue;
            }
            if(o=='annualinc'){
              this.ruleForm.annualinc = obj[o];
              this.ro.annualinc = true;
              continue;
            }
            if(o=='verificationstatus'){
              this.ruleForm.verificationstatus = obj[o];
              this.ro.verificationstatus = true;
              continue;
            }
            if(o=='issued'){
              this.ruleForm.issued = obj[o];
              this.ro.issued = true;
              continue;
            }
            if(o=='loanstatus'){
              this.ruleForm.loanstatus = obj[o];
              this.ro.loanstatus = true;
              continue;
            }
            if(o=='purpose'){
              this.ruleForm.purpose = obj[o];
              this.ro.purpose = true;
              continue;
            }
            if(o=='dti'){
              this.ruleForm.dti = obj[o];
              this.ro.dti = true;
              continue;
            }
            if(o=='earliestcrline'){
              this.ruleForm.earliestcrline = obj[o];
              this.ro.earliestcrline = true;
              continue;
            }
            if(o=='open'){
              this.ruleForm.open = obj[o];
              this.ro.open = true;
              continue;
            }
            if(o=='pub'){
              this.ruleForm.pub = obj[o];
              this.ro.pub = true;
              continue;
            }
            if(o=='revolbal'){
              this.ruleForm.revolbal = obj[o];
              this.ro.revolbal = true;
              continue;
            }
            if(o=='revolutil'){
              this.ruleForm.revolutil = obj[o];
              this.ro.revolutil = true;
              continue;
            }
            if(o=='totalacc'){
              this.ruleForm.totalacc = obj[o];
              this.ro.totalacc = true;
              continue;
            }
            if(o=='initialliststatus'){
              this.ruleForm.initialliststatus = obj[o];
              this.ro.initialliststatus = true;
              continue;
            }
            if(o=='applicationtype'){
              this.ruleForm.applicationtype = obj[o];
              this.ro.applicationtype = true;
              continue;
            }
            if(o=='pubrecbankruptcies'){
              this.ruleForm.pubrecbankruptcies = obj[o];
              this.ro.pubrecbankruptcies = true;
              continue;
            }
            if(o=='mortacc'){
              this.ruleForm.mortacc = obj[o];
              this.ro.mortacc = true;
              continue;
            }
          }
        }
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
            if((json.customernumber!=''&&json.customernumber) || json.customernumber==0){
                this.ruleForm.customernumber = json.customernumber
            }
            if((json.name!=''&&json.name) || json.name==0){
                this.ruleForm.name = json.name
            }
            if((json.phonenumber!=''&&json.phonenumber) || json.phonenumber==0){
                this.ruleForm.phonenumber = json.phonenumber
            }
            if((json.idcard!=''&&json.idcard) || json.idcard==0){
                this.ruleForm.idcard = json.idcard
            }
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
        this.$http.get('loanapplication/detail/${id}', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // submit
      onSubmit() {

		  if(this.ruleForm.loannumber){
			  this.ruleForm.loannumber = String(this.ruleForm.loannumber)
		  }
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
                 this.$http.get('loanapplication/list', {
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


                          this.$http.post('loanapplication/add', this.ruleForm).then(res => {
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


                  this.$http.post('loanapplication/add', this.ruleForm).then(res => {
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
      relatedinformationUploadChange(fileUrls) {
          this.ruleForm.relatedinformation = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
