package com.entity.model;

import com.entity.LoanapplicationEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * loan application
 * @author
 * @email 
 * @date 2023-11-10 11:38:26
 */
public class LoanapplicationModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * product name
	 */
	
	private String productname;
		
	/**
	 * product class
	 */
	
	private String productclassification;
		
	/**
	 * Product Properties
	 */
	
	private String productnature;
		
	/**
	 * Loan method
	 */
	
	private String loanmethod;
		
	/**
	 * lending rate
	 */
	
	private String loaninterestrate;
		
	/**
	 * loanamount
	 */
	
	private String loanpaymentamount;
		
	/**
	 * Branch name
	 */
	
	private String branchname;
		
	/**
	 * node address
	 */
	
	private String branchaddress;
		
	/**
	 * client number
	 */
	
	private String customernumber;
		
	/**
	 * full name
	 */
	
	private String name;
		
	/**
	 * phone
	 */
	
	private String phonenumber;
		
	/**
	 * ID card
	 */
	
	private String idcard;
		
	/**
	 * Related information
	 */
	
	private String relatedinformation;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date applicationtime;
		
	/**
	 * loannumber
	 */
	
	private String loannumber;

		
	/**
	 * shhf
	 */
	
	private String shh;
		
	/**
	 * loan_amnt
	 */
	
	private String loanamnt;
		
	/**
	 * term
	 */
	
	private String term;
		
	/**
	 * intrate
	 */
	
	private String intrate;
		
	/**
	 * installment
	 */
	
	private String installment;
		
	/**
	 * grade
	 */
	
	private String grade;
		
	/**
	 * sub_grade
	 */
	
	private String subGrade;
		
	/**
	 * sub_gradehip
	 */
	
	private String subgradehip;
		
	/**
	 * annual_inc
	 */
	
	private String annualinc;
		
	/**
	 * verification_status
	 */
	
	private String verificationstatus;
		
	/**
	 * issue_d
	 */
	
	private String issued;
		
	/**
	 * loan_status
	 */
	
	private String loanstatus;
		
	/**
	 * purpose
	 */
	
	private String purpose;
		
	/**
	 * dti
	 */
	
	private String dti;
		
	/**
	 * earliest_cr_line
	 */
	
	private String earliestcrline;
		
	/**
	 * open_acc
	 */
	
	private String open;
		
	/**
	 * pub_rec
	 */
	
	private String pub;
		
	/**
	 * revol_bal
	 */
	
	private String revolbal;
		
	/**
	 * revol_util
	 */
	
	private String revolutil;
		
	/**
	 * total_acc
	 */
	
	private String totalacc;
		
	/**
	 * initial_list_status
	 */
	
	private String initialliststatus;
		
	/**
	 * application_type
	 */
	
	private String applicationtype;
		
	/**
	 * pub_rec_bankruptcies
	 */
	
	private String pubrecbankruptcies;
		
	/**
	 * mort_acc
	 */
	
	private String mortacc;
		

	private String sfsh;
		
	/**
	 * Reviewreply
	 */
	
	private String shhf;
				
	
	/**
	 * setting:product name
	 */
	 
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	/**
	 *get:product name
	 */
	public String getProductname() {
		return productname;
	}
				
	
	/**
	 * setting:product class
	 */
	 
	public void setProductclassification(String productclassification) {
		this.productclassification = productclassification;
	}
	
	/**
	 *get:product class
	 */
	public String getProductclassification() {
		return productclassification;
	}
				
	
	/**
	 * setting:Product Properties
	 */
	 
	public void setProductnature(String productnature) {
		this.productnature = productnature;
	}
	
	/**
	 *get:Product Properties
	 */
	public String getProductnature() {
		return productnature;
	}
				
	
	/**
	 * setting:Loan method
	 */
	 
	public void setLoanmethod(String loanmethod) {
		this.loanmethod = loanmethod;
	}
	
	/**
	 *get:Loan method
	 */
	public String getLoanmethod() {
		return loanmethod;
	}
				
	
	/**
	 * setting:lending rate
	 */
	 
	public void setLoaninterestrate(String loaninterestrate) {
		this.loaninterestrate = loaninterestrate;
	}
	
	/**
	 *get:lending rate
	 */
	public String getLoaninterestrate() {
		return loaninterestrate;
	}
				
	
	/**
	 * setting:loanamount
	 */
	 
	public void setLoanpaymentamount(String loanpaymentamount) {
		this.loanpaymentamount = loanpaymentamount;
	}
	
	/**
	 *get:loanamount
	 */
	public String getLoanpaymentamount() {
		return loanpaymentamount;
	}
				
	
	/**
	 * setting:Branch name
	 */
	 
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	
	/**
	 *get:Branch name
	 */
	public String getBranchname() {
		return branchname;
	}
				
	
	/**
	 * setting:node address
	 */
	 
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	
	/**
	 *get:node address
	 */
	public String getBranchaddress() {
		return branchaddress;
	}
				
	
	/**
	 * setting:client number
	 */
	 
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	
	/**
	 *get:client number
	 */
	public String getCustomernumber() {
		return customernumber;
	}
				
	
	/**
	 * setting:full name
	 */
	 
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 *get:full name
	 */
	public String getName() {
		return name;
	}
				
	
	/**
	 * setting:phone
	 */
	 
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	/**
	 *get:phone
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
				
	
	/**
	 * setting:ID card
	 */
	 
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	/**
	 *get:ID card
	 */
	public String getIdcard() {
		return idcard;
	}
				
	
	/**
	 * setting:Related information
	 */
	 
	public void setRelatedinformation(String relatedinformation) {
		this.relatedinformation = relatedinformation;
	}
	
	/**
	 *get:Related information
	 */
	public String getRelatedinformation() {
		return relatedinformation;
	}
				
	
	/**
	 * setting:申请时间
	 */
	 
	public void setApplicationtime(Date applicationtime) {
		this.applicationtime = applicationtime;
	}
	
	/**
	 *get:申请时间
	 */
	public Date getApplicationtime() {
		return applicationtime;
	}
				
	
	/**
	 * setting:loannumber
	 */
	 
	public void setloannumber(String loannumber) {
		this.loannumber = loannumber;
	}
	
	/**
	 *get:loannumber
	 */
	public String getloannumber() {
		return loannumber;
	}
				
	
	/**
	 * setting:productname
	 */
	 
	public void setproductname(String productname) {
		this.productname = productname;
	}
	
	/**
	 *get:productname
	 */
	public String getproductname() {
		return productname;
	}
				
	
	/**
	 * setting:productclassification
	 */
	 
	public void setproductclassification(String productclassification) {
		this.productclassification = productclassification;
	}
	
	/**
	 *get:productclassification
	 */
	public String getproductclassification() {
		return productclassification;
	}
				
	
	/**
	 * setting:productnature
	 */
	 
	public void setproductnature(String productnature) {
		this.productnature = productnature;
	}
	
	/**
	 *get:productnature
	 */
	public String getproductnature() {
		return productnature;
	}
				
	
	/**
	 * setting:loanmethod
	 */
	 
	public void setloanmethod(String loanmethod) {
		this.loanmethod = loanmethod;
	}
	
	/**
	 *get:loanmethod
	 */
	public String getloanmethod() {
		return loanmethod;
	}
				
	
	/**
	 * setting:loaninterestrate
	 */
	 
	public void setloaninterestrate(String loaninterestrate) {
		this.loaninterestrate = loaninterestrate;
	}
	
	/**
	 *get:loaninterestrate
	 */
	public String getloaninterestrate() {
		return loaninterestrate;
	}
				
	
	/**
	 * setting:loanpaymentamount
	 */
	 
	public void setloanpaymentamount(String loanpaymentamount) {
		this.loanpaymentamount = loanpaymentamount;
	}
	
	/**
	 *get:loanpaymentamount
	 */
	public String getloanpaymentamount() {
		return loanpaymentamount;
	}
				
	
	/**
	 * setting:branchname
	 */
	 
	public void setbranchname(String branchname) {
		this.branchname = branchname;
	}
	
	/**
	 *get:branchname
	 */
	public String getbranchname() {
		return branchname;
	}
				
	
	/**
	 * setting:branchaddress
	 */
	 
	public void setbranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	
	/**
	 *get:branchaddress
	 */
	public String getbranchaddress() {
		return branchaddress;
	}
				
	
	/**
	 * setting:customernumber
	 */
	 
	public void setcustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}
	
	/**
	 *get:customernumber
	 */
	public String getcustomernumber() {
		return customernumber;
	}
				
	
	/**
	 * setting:name
	 */
	 
	public void setname(String name) {
		this.name = name;
	}
	
	/**
	 *get:name
	 */
	public String getname() {
		return name;
	}
				
	
	/**
	 * setting:phonenumber
	 */
	 
	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	/**
	 *get:phonenumber
	 */
	public String getphonenumber() {
		return phonenumber;
	}
				
	
	/**
	 * setting:idcard
	 */
	 
	public void setidcard(String idcard) {
		this.idcard = idcard;
	}
	
	/**
	 *get:idcard
	 */
	public String getidcard() {
		return idcard;
	}
				
	
	/**
	 * setting:relatedinformation
	 */
	 
	public void setrelatedinformation(String relatedinformation) {
		this.relatedinformation = relatedinformation;
	}
	
	/**
	 *get:relatedinformation
	 */
	public String getrelatedinformation() {
		return relatedinformation;
	}

	
	/**
	 * setting:shhf
	 */
	 
	public void setShh(String shh) {
		this.shh = shh;
	}
	
	/**
	 *get:shhf
	 */
	public String getShh() {
		return shh;
	}
				
	
	/**
	 * setting:loan_amnt
	 */
	 
	public void setLoanamnt(String loanamnt) {
		this.loanamnt = loanamnt;
	}
	
	/**
	 *get:loan_amnt
	 */
	public String getLoanamnt() {
		return loanamnt;
	}
				
	
	/**
	 * setting:term
	 */
	 
	public void setTerm(String term) {
		this.term = term;
	}
	
	/**
	 *get:term
	 */
	public String getTerm() {
		return term;
	}
				
	
	/**
	 * setting:intrate
	 */
	 
	public void setIntrate(String intrate) {
		this.intrate = intrate;
	}
	
	/**
	 *get:intrate
	 */
	public String getIntrate() {
		return intrate;
	}
				
	
	/**
	 * setting:installment
	 */
	 
	public void setInstallment(String installment) {
		this.installment = installment;
	}
	
	/**
	 *get:installment
	 */
	public String getInstallment() {
		return installment;
	}
				
	
	/**
	 * setting:grade
	 */
	 
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	/**
	 *get:grade
	 */
	public String getGrade() {
		return grade;
	}
				
	
	/**
	 * setting:sub_grade
	 */
	 
	public void setSubGrade(String subGrade) {
		this.subGrade = subGrade;
	}
	
	/**
	 *get:sub_grade
	 */
	public String getSubGrade() {
		return subGrade;
	}
				
	
	/**
	 * setting:sub_gradehip
	 */
	 
	public void setSubgradehip(String subgradehip) {
		this.subgradehip = subgradehip;
	}
	
	/**
	 *get:sub_gradehip
	 */
	public String getSubgradehip() {
		return subgradehip;
	}
				
	
	/**
	 * setting:annual_inc
	 */
	 
	public void setAnnualinc(String annualinc) {
		this.annualinc = annualinc;
	}
	
	/**
	 *get:annual_inc
	 */
	public String getAnnualinc() {
		return annualinc;
	}
				
	
	/**
	 * setting:verification_status
	 */
	 
	public void setVerificationstatus(String verificationstatus) {
		this.verificationstatus = verificationstatus;
	}
	
	/**
	 *get:verification_status
	 */
	public String getVerificationstatus() {
		return verificationstatus;
	}
				
	
	/**
	 * setting:issue_d
	 */
	 
	public void setIssued(String issued) {
		this.issued = issued;
	}
	
	/**
	 *get:issue_d
	 */
	public String getIssued() {
		return issued;
	}
				
	
	/**
	 * setting:loan_status
	 */
	 
	public void setLoanstatus(String loanstatus) {
		this.loanstatus = loanstatus;
	}
	
	/**
	 *get:loan_status
	 */
	public String getLoanstatus() {
		return loanstatus;
	}
				
	
	/**
	 * setting:purpose
	 */
	 
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	/**
	 *get:purpose
	 */
	public String getPurpose() {
		return purpose;
	}
				
	
	/**
	 * setting:dti
	 */
	 
	public void setDti(String dti) {
		this.dti = dti;
	}
	
	/**
	 *get:dti
	 */
	public String getDti() {
		return dti;
	}
				
	
	/**
	 * setting:earliest_cr_line
	 */
	 
	public void setEarliestcrline(String earliestcrline) {
		this.earliestcrline = earliestcrline;
	}
	
	/**
	 *get:earliest_cr_line
	 */
	public String getEarliestcrline() {
		return earliestcrline;
	}
				
	
	/**
	 * setting:open_acc
	 */
	 
	public void setOpen(String open) {
		this.open = open;
	}
	
	/**
	 *get:open_acc
	 */
	public String getOpen() {
		return open;
	}
				
	
	/**
	 * setting:pub_rec
	 */
	 
	public void setPub(String pub) {
		this.pub = pub;
	}
	
	/**
	 *get:pub_rec
	 */
	public String getPub() {
		return pub;
	}
				
	
	/**
	 * setting:revol_bal
	 */
	 
	public void setRevolbal(String revolbal) {
		this.revolbal = revolbal;
	}
	
	/**
	 *get:revol_bal
	 */
	public String getRevolbal() {
		return revolbal;
	}
				
	
	/**
	 * setting:revol_util
	 */
	 
	public void setRevolutil(String revolutil) {
		this.revolutil = revolutil;
	}
	
	/**
	 *get:revol_util
	 */
	public String getRevolutil() {
		return revolutil;
	}
				
	
	/**
	 * setting:total_acc
	 */
	 
	public void setTotalacc(String totalacc) {
		this.totalacc = totalacc;
	}
	
	/**
	 *get:total_acc
	 */
	public String getTotalacc() {
		return totalacc;
	}
				
	
	/**
	 * setting:initial_list_status
	 */
	 
	public void setInitialliststatus(String initialliststatus) {
		this.initialliststatus = initialliststatus;
	}
	
	/**
	 *get:initial_list_status
	 */
	public String getInitialliststatus() {
		return initialliststatus;
	}
				
	
	/**
	 * setting:application_type
	 */
	 
	public void setApplicationtype(String applicationtype) {
		this.applicationtype = applicationtype;
	}
	
	/**
	 *get:application_type
	 */
	public String getApplicationtype() {
		return applicationtype;
	}
				
	
	/**
	 * setting:pub_rec_bankruptcies
	 */
	 
	public void setPubrecbankruptcies(String pubrecbankruptcies) {
		this.pubrecbankruptcies = pubrecbankruptcies;
	}
	
	/**
	 *get:pub_rec_bankruptcies
	 */
	public String getPubrecbankruptcies() {
		return pubrecbankruptcies;
	}
				
	
	/**
	 * setting:mort_acc
	 */
	 
	public void setMortacc(String mortacc) {
		this.mortacc = mortacc;
	}
	
	/**
	 *get:mort_acc
	 */
	public String getMortacc() {
		return mortacc;
	}
				
	
	/**
	 * setting:是否Review
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 *get:是否Review
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * setting:Reviewreply
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 *get:Reviewreply
	 */
	public String getShhf() {
		return shhf;
	}
			
}
