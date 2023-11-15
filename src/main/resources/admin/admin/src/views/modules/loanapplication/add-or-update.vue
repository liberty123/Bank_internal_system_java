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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="loan number" prop="loannumber">
					<el-input v-model="ruleForm.loannumber" placeholder="loan number" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.loannumber" label="loan number" prop="loannumber">
					<el-input v-model="ruleForm.loannumber" placeholder="loan number" readonly></el-input>
				</el-form-item>
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
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Product Properties" prop="productnature">
					<el-input v-model="ruleForm.productnature" placeholder="Product Properties" clearable  :readonly="ro.productnature"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Product Properties" prop="productnature">
					<el-input v-model="ruleForm.productnature" placeholder="Product Properties" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="Loan method" prop="loanmethod">
					<el-select :disabled="ro.loanmethod" v-model="ruleForm.loanmethod" placeholder="Please select Loan method" >
						<el-option
							v-for="(item,index) in loanmethodOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Loan method" prop="loanmethod">
					<el-input v-model="ruleForm.loanmethod"
						placeholder="Loan method" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="lending rate" prop="loaninterestrate">
					<el-input v-model="ruleForm.loaninterestrate" placeholder="lending rate" clearable  :readonly="ro.loaninterestrate"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="lending rate" prop="loaninterestrate">
					<el-input v-model="ruleForm.loaninterestrate" placeholder="lending rate" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="loanamount" prop="loanpaymentamount">
					<el-input v-model="ruleForm.loanpaymentamount" placeholder="loanamount" clearable  :readonly="ro.loanpaymentamount"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="loanamount" prop="loanpaymentamount">
					<el-input v-model="ruleForm.loanpaymentamount" placeholder="loanamount" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="Branch name" prop="branchname">
					<el-input v-model="ruleForm.branchname" placeholder="Branch name" clearable  :readonly="ro.branchname"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="Branch name" prop="branchname">
					<el-input v-model="ruleForm.branchname" placeholder="Branch name" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="node address" prop="branchaddress">
					<el-input v-model="ruleForm.branchaddress" placeholder="node address" clearable  :readonly="ro.branchaddress"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="node address" prop="branchaddress">
					<el-input v-model="ruleForm.branchaddress" placeholder="node address" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="client number" prop="customernumber">
					<el-input v-model="ruleForm.customernumber" placeholder="client number" clearable  :readonly="ro.customernumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="client number" prop="customernumber">
					<el-input v-model="ruleForm.customernumber" placeholder="client number" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="full name" prop="name">
					<el-input v-model="ruleForm.name" placeholder="full name" clearable  :readonly="ro.name"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="full name" prop="name">
					<el-input v-model="ruleForm.name" placeholder="full name" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="phone" prop="phonenumber">
					<el-input v-model="ruleForm.phonenumber" placeholder="phone" clearable  :readonly="ro.phonenumber"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="phone" prop="phonenumber">
					<el-input v-model="ruleForm.phonenumber" placeholder="phone" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="ID card" prop="idcard">
					<el-input v-model="ruleForm.idcard" placeholder="ID card" clearable  :readonly="ro.idcard"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="ID card" prop="idcard">
					<el-input v-model="ruleForm.idcard" placeholder="ID card" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="upload" v-if="type!='info'&& !ro.relatedinformation" label="Related information" prop="relatedinformation">
					<file-upload
						tip="Click to uploadRelated information"
						action="file/upload"
						:limit="1"
						:multiple="true"
						:fileUrls="ruleForm.relatedinformation?ruleForm.relatedinformation:''"
						@change="relatedinformationUploadChange"
					></file-upload>
				</el-form-item>  
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="ruleForm.relatedinformation" label="Related information" prop="relatedinformation">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small" @click="download($base.url+ruleForm.relatedinformation)">download</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else-if="!ruleForm.relatedinformation" label="Related information" prop="relatedinformation">
					<el-button :style='{"border":"0px solid #47afce","cursor":"pointer","padding":"0 35px","margin":"0 20px 0 0","outline":"none","color":"#fff","borderRadius":"0px","background":"#339933","width":"auto","lineHeight":"40px","fontSize":"16px","height":"40px"}' type="text" size="small">none</el-button>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="applicationtime" prop="applicationtime">
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.applicationtime" 
						type="datetime"
						:readonly="ro.applicationtime"
						placeholder="applicationtime"
					></el-date-picker>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.applicationtime" label="applicationtime" prop="applicationtime">
					<el-input v-model="ruleForm.applicationtime" placeholder="applicationtime" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="shhf" prop="shh">
					<el-input v-model="ruleForm.shh" placeholder="shhf" clearable  :readonly="ro.shh"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="shhf" prop="shh">
					<el-input v-model="ruleForm.shh" placeholder="shhf" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="loan_amnt" prop="loanamnt">
					<el-input v-model="ruleForm.loanamnt" placeholder="loan_amnt" clearable  :readonly="ro.loanamnt"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="loan_amnt" prop="loanamnt">
					<el-input v-model="ruleForm.loanamnt" placeholder="loan_amnt" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="term" prop="term">
					<el-input v-model="ruleForm.term" placeholder="term" clearable  :readonly="ro.term"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="term" prop="term">
					<el-input v-model="ruleForm.term" placeholder="term" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="intrate" prop="intrate">
					<el-input v-model="ruleForm.intrate" placeholder="intrate" clearable  :readonly="ro.intrate"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="intrate" prop="intrate">
					<el-input v-model="ruleForm.intrate" placeholder="intrate" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="installment" prop="installment">
					<el-input v-model="ruleForm.installment" placeholder="installment" clearable  :readonly="ro.installment"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="installment" prop="installment">
					<el-input v-model="ruleForm.installment" placeholder="installment" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="grade" prop="grade">
					<el-input v-model="ruleForm.grade" placeholder="grade" clearable  :readonly="ro.grade"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="grade" prop="grade">
					<el-input v-model="ruleForm.grade" placeholder="grade" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="sub_grade" prop="sub_grade">
					<el-input v-model="ruleForm.sub_grade" placeholder="sub_grade" clearable  :readonly="ro.sub_grade"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="sub_grade" prop="sub_grade">
					<el-input v-model="ruleForm.sub_grade" placeholder="sub_grade" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="sub_gradehip" prop="subgradehip">
					<el-input v-model="ruleForm.subgradehip" placeholder="sub_gradehip" clearable  :readonly="ro.subgradehip"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="sub_gradehip" prop="subgradehip">
					<el-input v-model="ruleForm.subgradehip" placeholder="sub_gradehip" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="annual_inc" prop="annualinc">
					<el-input v-model="ruleForm.annualinc" placeholder="annual_inc" clearable  :readonly="ro.annualinc"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="annual_inc" prop="annualinc">
					<el-input v-model="ruleForm.annualinc" placeholder="annual_inc" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="verification_status" prop="verificationstatus">
					<el-input v-model="ruleForm.verificationstatus" placeholder="verification_status" clearable  :readonly="ro.verificationstatus"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="verification_status" prop="verificationstatus">
					<el-input v-model="ruleForm.verificationstatus" placeholder="verification_status" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="issue_d" prop="issued">
					<el-input v-model="ruleForm.issued" placeholder="issue_d" clearable  :readonly="ro.issued"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="issue_d" prop="issued">
					<el-input v-model="ruleForm.issued" placeholder="issue_d" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="loan_status" prop="loanstatus">
					<el-input v-model="ruleForm.loanstatus" placeholder="loan_status" clearable  :readonly="ro.loanstatus"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="loan_status" prop="loanstatus">
					<el-input v-model="ruleForm.loanstatus" placeholder="loan_status" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="purpose" prop="purpose">
					<el-input v-model="ruleForm.purpose" placeholder="purpose" clearable  :readonly="ro.purpose"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="purpose" prop="purpose">
					<el-input v-model="ruleForm.purpose" placeholder="purpose" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="dti" prop="dti">
					<el-input v-model="ruleForm.dti" placeholder="dti" clearable  :readonly="ro.dti"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="dti" prop="dti">
					<el-input v-model="ruleForm.dti" placeholder="dti" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="earliest_cr_line" prop="earliestcrline">
					<el-input v-model="ruleForm.earliestcrline" placeholder="earliest_cr_line" clearable  :readonly="ro.earliestcrline"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="earliest_cr_line" prop="earliestcrline">
					<el-input v-model="ruleForm.earliestcrline" placeholder="earliest_cr_line" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="open_acc" prop="open">
					<el-input v-model="ruleForm.open" placeholder="open_acc" clearable  :readonly="ro.open"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="open_acc" prop="open">
					<el-input v-model="ruleForm.open" placeholder="open_acc" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="pub_rec" prop="pub">
					<el-input v-model="ruleForm.pub" placeholder="pub_rec" clearable  :readonly="ro.pub"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="pub_rec" prop="pub">
					<el-input v-model="ruleForm.pub" placeholder="pub_rec" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="revol_bal" prop="revolbal">
					<el-input v-model="ruleForm.revolbal" placeholder="revol_bal" clearable  :readonly="ro.revolbal"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="revol_bal" prop="revolbal">
					<el-input v-model="ruleForm.revolbal" placeholder="revol_bal" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="revol_util" prop="revolutil">
					<el-input v-model="ruleForm.revolutil" placeholder="revol_util" clearable  :readonly="ro.revolutil"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="revol_util" prop="revolutil">
					<el-input v-model="ruleForm.revolutil" placeholder="revol_util" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="total_acc" prop="totalacc">
					<el-input v-model="ruleForm.totalacc" placeholder="total_acc" clearable  :readonly="ro.totalacc"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="total_acc" prop="totalacc">
					<el-input v-model="ruleForm.totalacc" placeholder="total_acc" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="initial_list_status" prop="initialliststatus">
					<el-input v-model="ruleForm.initialliststatus" placeholder="initial_list_status" clearable  :readonly="ro.initialliststatus"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="initial_list_status" prop="initialliststatus">
					<el-input v-model="ruleForm.initialliststatus" placeholder="initial_list_status" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="application_type" prop="applicationtype">
					<el-input v-model="ruleForm.applicationtype" placeholder="application_type" clearable  :readonly="ro.applicationtype"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="application_type" prop="applicationtype">
					<el-input v-model="ruleForm.applicationtype" placeholder="application_type" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="pub_rec_bankruptcies" prop="pubrecbankruptcies">
					<el-input v-model="ruleForm.pubrecbankruptcies" placeholder="pub_rec_bankruptcies" clearable  :readonly="ro.pubrecbankruptcies"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="pub_rec_bankruptcies" prop="pubrecbankruptcies">
					<el-input v-model="ruleForm.pubrecbankruptcies" placeholder="pub_rec_bankruptcies" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="mort_acc" prop="mortacc">
					<el-input v-model="ruleForm.mortacc" placeholder="mort_acc" clearable  :readonly="ro.mortacc"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 20px 0"}' v-else class="input" label="mort_acc" prop="mortacc">
					<el-input v-model="ruleForm.mortacc" placeholder="mort_acc" readonly></el-input>
				</el-form-item>
			</template>
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
				shhf: '',
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
			}
		};
	},
	props: ["parent"],
	computed: {



	},
    components: {
    },
	created() {
		this.ruleForm.applicationtime = this.getCurDateTime()
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
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
					if(this.$storage.get("role")!="administrator") {
						this.ro.productname = true;
					}
					if(this.$storage.get("role")!="administrator") {
						this.ro.productclassification = true;
					}
					if(this.$storage.get("role")!="administrator") {
						this.ro.productnature = true;
					}
					if(this.$storage.get("role")!="administrator") {
						this.ro.loanmethod = true;
					}
					if(((json.customernumber!=''&&json.customernumber) || json.customernumber==0) && this.$storage.get("role")!="administrator"){
						this.ruleForm.customernumber = json.customernumber
						this.ro.customernumber = true;
					}
					if(((json.name!=''&&json.name) || json.name==0) && this.$storage.get("role")!="administrator"){
						this.ruleForm.name = json.name
						this.ro.name = true;
					}
					if(((json.phonenumber!=''&&json.phonenumber) || json.phonenumber==0) && this.$storage.get("role")!="administrator"){
						this.ruleForm.phonenumber = json.phonenumber
						this.ro.phonenumber = true;
					}
					if(((json.idcard!=''&&json.idcard) || json.idcard==0) && this.$storage.get("role")!="administrator"){
						this.ruleForm.idcard = json.idcard
						this.ro.idcard = true;
					}
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
            this.$http({
				url: `option/loanmethods/loanmethod`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.loanmethodOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
			
		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `loanapplication/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传image后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表All
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // submit
    onSubmit() {
		if(this.ruleForm.loannumber) {
			this.ruleForm.loannumber = String(this.ruleForm.loannumber)
		}




























	if(this.ruleForm.relatedinformation!=null) {
		this.ruleForm.relatedinformation = this.ruleForm.relatedinformation.replace(new RegExp(this.$base.url,"g"),"");
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
				url: "loanapplication/page", 
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
					   url: `loanapplication/${!this.ruleForm.id ? "save" : "update"}`,
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
						 this.parent.loanapplicationCrossAddOrUpdateFlag = false;
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
			   url: `loanapplication/${!this.ruleForm.id ? "save" : "update"}`,
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
				 this.parent.loanapplicationCrossAddOrUpdateFlag = false;
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
      this.parent.loanapplicationCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    relatedinformationUploadChange(fileUrls) {
	    this.ruleForm.relatedinformation = fileUrls;
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
