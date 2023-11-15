<template>
	<div class="main-content" :style='{"minHeight":"100vh","padding":"30px","background":"url(http://codegen.caihongy.cn/20230329/eff4ea96c952463cb46b9c79d043ce56.gif) fixed,#f6f6f6"}'>
		<!-- table页 -->
		<template v-if="showFlag">
			<el-form class="center-form-pv" :style='{"margin":"0 0 0px"}' :inline="true" :model="searchForm">
				<el-row :style='{"padding":"0px","margin":"0 auto 20px","borderRadius":"3px","textAlign":"center","background":"none","display":"block"}' >
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">product name</label>
						<el-input v-model="searchForm.productname" placeholder="product name" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select" label="product class" prop="productclassification">
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">product class</label>
						<el-select  @change="productclassificationChange" clearable v-model="searchForm.productclassification" placeholder="Please select product class">
							<el-option v-for="(item,index) in productclassificationOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select" label="Loan method" prop="loanmethod">
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">Loan method</label>
						<el-select  @change="loanmethodChange" clearable v-model="searchForm.loanmethod" placeholder="Please select Loan method">
							<el-option v-for="(item,index) in loanmethodOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">Branch name</label>
						<el-input v-model="searchForm.branchname" placeholder="Branch name" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}'>
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">full name</label>
						<el-input v-model="searchForm.name" placeholder="full name" clearable></el-input>
					</div>
					<div :style='{"margin":"0 10px 0 0","display":"inline-block"}' class="select">
						<label :style='{"margin":"0 10px 0 0","color":"#666","display":"inline-block","lineHeight":"50px","fontSize":"16px","fontWeight":"500","height":"50px"}' class="item-label">Passed or not</label>
						<el-select  @change="sfshChange" clearable v-model="searchForm.sfsh" placeholder="Passed or not">
							<el-option v-for="(item,index) in sfshOptions" v-bind:key="index" :label="item" :value="item"></el-option>
						</el-select>
					</div>
					<el-button :style='{"border":"0px solid #f2cd41","cursor":"pointer","padding":"0 34px","outline":"none","margin":"0 0px 0 10px","color":"#333","borderRadius":"0px","background":"#FFCC33","width":"auto","fontSize":"16px","minWidth":"100px","height":" 50px"}' type="success" @click="search()">search</el-button>
				</el-row>

				<el-row :style='{"padding":"16px 12px 10px","margin":"0 0 0px","borderColor":"#e2f0e2","flexWrap":"wrap","background":"#fff","borderWidth":"1px 1px 0 1px","display":"flex","width":"auto","borderStyle":"solid","justifyContent":"flex-end","zIndex":"999"}'>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#666","color":"#333","outline":"none","borderRadius":"0px","background":"#f9c535","borderWidth":"0 0 0px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('loanapplication','add')" type="success" @click="addOrUpdateHandler()">add</el-button>
					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#666","color":"#333","outline":"none","borderRadius":"0px","background":"#f9c535","borderWidth":"0 0 0px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('loanapplication','del')" :disabled="dataListSelections.length <= 0" type="danger" @click="deleteHandler()">del</el-button>


					<el-button :style='{"border":"0","cursor":"pointer","padding":"0 16px","margin":"0 10px 6px 0","borderColor":"#666","color":"#333","outline":"none","borderRadius":"0px","background":"#f9c535","borderWidth":"0 0 0px","width":"auto","fontSize":"16px","borderStyle":"solid","height":"36px"}' v-if="isAuth('loanapplication','Review')" :disabled="dataListSelections.length <= 0" type="danger" @click="shBatchDialog()">batchReview</el-button>


				</el-row>
			</el-form>
			
			<!-- <div> -->
				<el-table class="tables"
					:stripe='true'
					:style='{"padding":"0","borderColor":"#e2f0e2","margin":"0 0 20px","borderRadius":"5px","borderWidth":"1px 0 0 1px","background":"#fff","width":"calc(100% - 0px)","borderStyle":"solid"}' 
					v-if="isAuth('loanapplication','view')"
					:data="dataList"
					v-loading="dataListLoading"
				@selection-change="selectionChangeHandler">
					<el-table-column :resizable='true' type="selection" align="center" width="50"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' label="No." type="index" width="50" />
					<el-table-column :resizable='true' :sortable='true'  
						prop="loannumber"
					label="loan number">
						<template slot-scope="scope">
							{{scope.row.loannumber}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="productname"
					label="product name">
						<template slot-scope="scope">
							{{scope.row.productname}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="productclassification"
					label="product class">
						<template slot-scope="scope">
							{{scope.row.productclassification}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="productnature"
					label="Product Properties">
						<template slot-scope="scope">
							{{scope.row.productnature}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="loanmethod"
					label="Loan method">
						<template slot-scope="scope">
							{{scope.row.loanmethod}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="loaninterestrate"
					label="lending rate">
						<template slot-scope="scope">
							{{scope.row.loaninterestrate}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="loanpaymentamount"
					label="loanamount">
						<template slot-scope="scope">
							{{scope.row.loanpaymentamount}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="branchname"
					label="Branch name">
						<template slot-scope="scope">
							{{scope.row.branchname}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="branchaddress"
					label="node address">
						<template slot-scope="scope">
							{{scope.row.branchaddress}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="customernumber"
					label="client number">
						<template slot-scope="scope">
							{{scope.row.customernumber}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="name"
					label="full name">
						<template slot-scope="scope">
							{{scope.row.name}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="phonenumber"
					label="phone">
						<template slot-scope="scope">
							{{scope.row.phonenumber}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="idcard"
					label="ID card">
						<template slot-scope="scope">
							{{scope.row.idcard}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="relatedinformation" label="Related information">
						<template slot-scope="scope">
							<el-button v-if="scope.row.relatedinformation" type="text" size="small" @click="download($base.url+scope.row.relatedinformation)">download</el-button>
                            <span v-else >none</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true'  
						prop="applicationtime"
					label="applicationtime">
						<template slot-scope="scope">
							{{scope.row.applicationtime}}
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="shhf" label="Reviewreply"></el-table-column>
					<el-table-column :resizable='true' :sortable='true' prop="sfsh" label="Review status">
						<template slot-scope="scope">
							<span style="margin-right:10px" v-if="scope.row.sfsh=='Y'">pass</span>
							<span style="margin-right:10px" v-if="scope.row.sfsh=='N'">fail</span>
							<span style="margin-right:10px" v-if="scope.row.sfsh=='To be reviewed'">To be reviewed</span>
						</template>
					</el-table-column>
					<el-table-column :resizable='true' :sortable='true' v-if="isAuth('loanapplication','Review')" prop="sfsh" label="Review">
						<template slot-scope="scope">
							<el-button  type="text" size="small" @click="shDialog(scope.row)">Review</el-button>
						</template>
					</el-table-column>
					<el-table-column width="300" label="operate">
						<template slot-scope="scope">
							<el-button :style='{"border":"0px solid #1e98f5","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#1e98f5","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/38553f099fa74a2d86e2206c373a9539.png) no-repeat left center / 20px","width":"auto","fontSize":"15px","height":"32px"}' v-if=" isAuth('loanapplication','view')" type="success" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">details</el-button>
							<el-button :style='{"border":"0px solid #06d5dd","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#15a4aa","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/99f867042acb4c4aae637c8bfcf6714a.png) no-repeat left center","width":"auto","fontSize":"15px","height":"32px"}' v-if=" isAuth('loanapplication','modify')" type="primary" size="mini" @click="addOrUpdateHandler(scope.row.id)">modify</el-button>





							<el-button :style='{"border":"0px solid #c00","cursor":"pointer","padding":"0 10px 0 24px","margin":"0 5px 6px","outline":"none","color":"#c00","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20230329/c5ea125f385740a3a3b9aed07f5dfe2c.png) no-repeat left 6px / 20px","width":"auto","fontSize":"14px","height":"32px"}' v-if="isAuth('loanapplication','del') " type="danger" size="mini" @click="deleteHandler(scope.row.id)">del</el-button>
						</template>
					</el-table-column>
				</el-table>
				<el-pagination
					@size-change="sizeChangeHandle"
					@current-change="currentChangeHandle"
					:current-page="pageIndex"
					background
					:page-sizes="[10, 20, 30, 50]"
					:page-size="pageSize"
					:layout="layouts.join()"
					:total="totalPage"
					prev-text="previous page "
					next-text="next page "
					:hide-on-single-page="false"
					:style='{"width":"calc(100% - 370px)","padding":"0","margin":"0 170px 0px 200px","whiteSpace":"nowrap","color":"#333","fontWeight":"500"}'
				></el-pagination>
			<!-- </div> -->
		</template>
		
		<!-- add/modify页面  将父组件的search方法传递给子组件-->
		<add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>


		<el-dialog title="Review" :visible.sync="sfshVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="Review status">
					<el-select v-model="shForm.sfsh" placeholder="Review status">
						<el-option label="pass" value="Y"></el-option>
						<el-option label=" fail" value="N"></el-option>
						<el-option label="To be reviewed" value="To be reviewed"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="content">
					<el-input type="textarea" :rows="8" v-model="shForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="shDialog">Cancel</el-button>
				<el-button type="primary" @click="shHandler">Confirm</el-button>
			</span>
		</el-dialog>
		<el-dialog title="batchReview" :visible.sync="sfshBatchVisiable" width="50%">
			<el-form ref="form" :model="form" label-width="80px">
				<el-form-item label="Review status">
					<el-select v-model="shBatchForm.sfsh" placeholder="Review status">
						<el-option label="pass" value="Y"></el-option>
						<el-option label=" fail" value="N"></el-option>
						<el-option label="To be reviewed" value="To be reviewed"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="content">
					<el-input type="textarea" :rows="8" v-model="shBatchForm.shhf"></el-input>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="shBatchDialog">Cancel</el-button>
				<el-button type="primary" @click="shBatchHandler">Confirm</el-button>
			</span>
		</el-dialog>



	</div>
</template>

<script>
//$graphType1
//$buttonName1
//$subNameList1
import axios from 'axios'
import AddOrUpdate from "./add-or-update";
export default {
  data() {
    return {
      productclassificationOptions: [],
      loanmethodOptions: [],
      searchForm: {
        key: ""
      },
      form:{},
      dataList: [],
      pageIndex: 1,
      pageSize: 10,
      totalPage: 0,
      dataListLoading: false,
      dataListSelections: [],
      showFlag: true,
      sfshVisiable: false,
      shForm: {},
      sfshBatchVisiable: false,
      shBatchForm: {
        sfsh:'',
        shhf:''
      },
      batchIds:[], 
      chartVisiable: false,
      chartVisiable1: false,
      chartVisiable2: false,
      chartVisiable3: false,
      chartVisiable4: false,
      chartVisiable5: false,
      addOrUpdateFlag:false,
      layouts: ["total","prev","pager","next","sizes","jumper"],

    };
  },
  created() {
    this.init();
    this.getDataList();
    this.contentStyleChange()
  },
  mounted() {
  },
  filters: {
    htmlfilter: function (val) {
      return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
    }
  },
  components: {
    AddOrUpdate,
  },
  methods: {

    contentStyleChange() {
      this.contentPageStyleChange()
    },
    // 分页
    contentPageStyleChange(){
      let arr = []

      // if(this.contents.pageTotal) arr.push('total')
      // if(this.contents.pageSizes) arr.push('sizes')
      // if(this.contents.pagePrevNext){
      //   arr.push('prev')
      //   if(this.contents.pagePager) arr.push('pager')
      //   arr.push('next')
      // }
      // if(this.contents.pageJumper) arr.push('jumper')
      // this.layouts = arr.join()
      // this.contents.pageEachNum = 10
    },








    init () {
        this.sfshOptions = "是,否,To be reviewed".split(',');
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
    search() {
      this.pageIndex = 1;
      this.getDataList();
    },

    // 获取数据table
    getDataList() {
      this.dataListLoading = true;
      let params = {
        page: this.pageIndex,
        limit: this.pageSize,
        sort: 'id',
        order: 'desc',
      }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.productname!='' && this.searchForm.productname!=undefined){
            params['productname'] = '%' + this.searchForm.productname + '%'
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.productclassification!='' && this.searchForm.productclassification!=undefined){
            params['productclassification'] = this.searchForm.productclassification
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.loanmethod!='' && this.searchForm.loanmethod!=undefined){
            params['loanmethod'] = this.searchForm.loanmethod
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.branchname!='' && this.searchForm.branchname!=undefined){
            params['branchname'] = '%' + this.searchForm.branchname + '%'
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
           if(this.searchForm.name!='' && this.searchForm.name!=undefined){
            params['name'] = '%' + this.searchForm.name + '%'
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
    params['sort'] = 'applicationtime';
    params['order'] = 'desc';
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
          if(this.searchForm.sfsh!='' && this.searchForm.sfsh!=undefined){
            params['sfsh'] = this.searchForm.sfsh
          }
      this.$http({
        url: "loanapplication/page",
        method: "get",
        params: params
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.dataList = data.data.list;
          this.totalPage = data.data.total;
        } else {
          this.dataList = [];
          this.totalPage = 0;
        }
        this.dataListLoading = false;
      });
    },
    // 每页数
    sizeChangeHandle(val) {
      this.pageSize = val;
      this.pageIndex = 1;
      this.getDataList();
    },
    // 当前页
    currentChangeHandle(val) {
      this.pageIndex = val;
      this.getDataList();
    },
    // 多选
    selectionChangeHandler(val) {
      this.dataListSelections = val;
    },
    // add/modify
    addOrUpdateHandler(id,type) {
      this.showFlag = false;
      this.addOrUpdateFlag = true;
      this.crossAddOrUpdateFlag = false;
      if(type!='info'){
        type = 'else';
      }
      this.$nextTick(() => {
        this.$refs.addOrUpdate.init(id,type);
      });
    },
    // Review窗口
    shDialog(row){
      this.sfshVisiable = !this.sfshVisiable;
      if(row){
        this.shForm = {
          loannumber: row.loannumber,
          productname: row.productname,
          productclassification: row.productclassification,
          productnature: row.productnature,
          loanmethod: row.loanmethod,
          loaninterestrate: row.loaninterestrate,
          loanpaymentamount: row.loanpaymentamount,
          branchname: row.branchname,
          branchaddress: row.branchaddress,
          customernumber: row.customernumber,
          name: row.name,
          phonenumber: row.phonenumber,
          idcard: row.idcard,
          relatedinformation: row.relatedinformation,
          applicationtime: row.applicationtime,
          loannumber: row.loannumber,
          productname: row.productname,
          productclassification: row.productclassification,
          productnature: row.productnature,
          loanmethod: row.loanmethod,
          loaninterestrate: row.loaninterestrate,
          loanpaymentamount: row.loanpaymentamount,
          branchname: row.branchname,
          branchaddress: row.branchaddress,
          customernumber: row.customernumber,
          name: row.name,
          phonenumber: row.phonenumber,
          idcard: row.idcard,
          relatedinformation: row.relatedinformation,
          applicationtime: row.applicationtime,
          shh: row.shh,
          loanamnt: row.loanamnt,
          term: row.term,
          intrate: row.intrate,
          installment: row.installment,
          grade: row.grade,
          sub_grade: row.sub_grade,
          subgradehip: row.subgradehip,
          annualinc: row.annualinc,
          verificationstatus: row.verificationstatus,
          issued: row.issued,
          loanstatus: row.loanstatus,
          purpose: row.purpose,
          dti: row.dti,
          earliestcrline: row.earliestcrline,
          open: row.open,
          pub: row.pub,
          revolbal: row.revolbal,
          revolutil: row.revolutil,
          totalacc: row.totalacc,
          initialliststatus: row.initialliststatus,
          applicationtype: row.applicationtype,
          pubrecbankruptcies: row.pubrecbankruptcies,
          mortacc: row.mortacc,
          sfsh: row.sfsh,
          shhf: row.shhf,
          id: row.id
        }
      }
    },
    // Review
    shHandler(){
      this.$confirm(`Confirmoperate?`, "tiitle", {
        confirmButtonText: "Confirm",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "loanapplication/update",
          method: "post",
          data: this.shForm
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "operate success",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    //batchReview窗口
    shBatchDialog(){
      this.sfshBatchVisiable = !this.sfshBatchVisiable;
      this.batchIds = this.dataListSelections.map(item => {
            return Number(item.id);
          });
    },
    //batchReview
    shBatchHandler(){
      this.$confirm(`Confirm一键Reviewoperate?`, "tiitle", {
        confirmButtonText: "Confirm",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "loanapplication/shBatch?sfsh="+this.shBatchForm.sfsh+"&shhf="+this.shBatchForm.shhf,
          method: "post",
          data: this.batchIds
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "operate success",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.getDataList();
                this.shBatchDialog()
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    // download
    download(file){
      window.open(`${file}`)
    },
    // del
    deleteHandler(id) {
      var ids = id
        ? [Number(id)]
        : this.dataListSelections.map(item => {
            return Number(item.id);
          });
      this.$confirm(`Are you sure to proceed with[${id ? "del" : "batchdel"}]operate?`, "tiitle", {
        confirmButtonText: "Confirm",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.$http({
          url: "loanapplication/delete",
          method: "post",
          data: ids
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "operate success",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.search();
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },


  }

};
</script>
<style lang="scss" scoped>
	
	.center-form-pv {
	  .el-date-editor.el-input {
	    width: auto;
	  }
	}
	
	.el-input {
	  width: auto;
	}
	
	// form
	.center-form-pv .el-input /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 0px;
				padding: 0 12px;
				box-shadow: 0 0px 0px #ccc;
				outline: none;
				color: #999;
				width: 170px;
				font-size: 16px;
				height: 50px;
			}
	
	.center-form-pv .el-select /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 0px;
				padding: 0 10px;
				box-shadow: 0 0px 0px #ccc;
				outline: none;
				color: #999;
				width: 170px;
				font-size: 16px;
				line-height: 30px;
				height: 50px;
			}
	
	.center-form-pv .el-date-editor /deep/ .el-input__inner {
				border: 1px solid #eee;
				border-radius: 0px;
				padding: 0 10px 0 30px;
				box-shadow: 0 0px 0px #ccc;
				outline: none;
				color: #999;
				width: 170px;
				font-size: 16px;
				height: 50px;
			}
	
	// table
	.el-table /deep/ .el-table__header-wrapper thead {
				color: #999;
				font-weight: 500;
				width: 100%;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr {
				background: #fff;
			}
	
	.el-table /deep/ .el-table__header-wrapper thead tr th {
				padding: 10px;
				color: #000;
				background: #e4f9e4;
				border-color: #e2f0e2;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__header-wrapper thead tr th .cell {
				padding: 0 10px;
				word-wrap: normal;
				word-break: break-all;
				white-space: normal;
				font-weight: bold;
				display: inline-block;
				vertical-align: middle;
				width: 100%;
				line-height: 24px;
				position: relative;
				text-overflow: ellipsis;
			}

	
	.el-table /deep/ .el-table__body-wrapper tbody {
				width: 100%;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr {
				background: none;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 2px 10px;
				color: #666;
				background: none;
				border-color: #e2f0e2;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
		.el-table /deep/ .el-table__body-wrapper tbody tr.el-table__row--striped td {
		background: rgba(246,254,246,.5);
	}
		
	.el-table /deep/ .el-table__body-wrapper tbody tr:hover td {
				padding: 2px 10px;
				color: #999;
				background: rgba(228,249,228,.6);
				border-color: #e2f0e2;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}
	
	.el-table /deep/ .el-table__body-wrapper tbody tr td {
				padding: 2px 10px;
				color: #666;
				background: none;
				border-color: #e2f0e2;
				border-width: 0 1px 1px 0;
				border-style: solid;
				text-align: left;
			}

	.el-table /deep/ .el-table__body-wrapper tbody tr td .cell {
				padding: 0 10px;
				overflow: hidden;
				word-break: break-all;
				white-space: normal;
				line-height: 24px;
				text-overflow: ellipsis;
			}
	
	// pagination
	.main-content .el-pagination /deep/ .el-pagination__total {
				margin: 0 10px 0 0;
				color: #666;
				font-weight: 400;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev {
				border: none;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next {
				border: none;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #666;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				min-width: 35px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-prev:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .btn-next:disabled {
				border: none;
				cursor: not-allowed;
				border-radius: 30px;
				padding: 0;
				margin: 0 5px;
				color: #C0C4CC;
				background: #f4f4f5;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}

	.main-content .el-pagination /deep/ .el-pager {
				padding: 0;
				margin: 0;
				display: inline-block;
				vertical-align: top;
			}

	.main-content .el-pagination /deep/ .el-pager .number {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #666;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				background: #f4f4f5;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number:hover {
				cursor: pointer;
				padding: 0 4px;
				margin: 0 5px;
				color: #333;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				background: #e8e6d4;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pager .number.active {
				cursor: default;
				padding: 0 4px;
				margin: 0 5px;
				color: #333;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				background: #e8e6d4;
				text-align: center;
				min-width: 30px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes {
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input {
				margin: 0 5px;
				width: 100px;
				position: relative;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 25px 0 8px;
				color: #606266;
				display: inline-block;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input span.el-input__suffix {
				top: 0;
				position: absolute;
				right: 0;
				height: 100%;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__sizes .el-input .el-input__suffix .el-select__caret {
				cursor: pointer;
				color: #C0C4CC;
				width: 25px;
				font-size: 14px;
				line-height: 28px;
				text-align: center;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump {
				margin: 0 0 0 24px;
				color: #606266;
				display: inline-block;
				vertical-align: top;
				font-size: 16px;
				line-height: 28px;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input {
				border-radius: 3px;
				padding: 0 2px;
				margin: 0 2px;
				display: inline-block;
				width: 50px;
				font-size: 16px;
				line-height: 18px;
				position: relative;
				text-align: center;
				height: 28px;
			}
	
	.main-content .el-pagination /deep/ .el-pagination__jump .el-input .el-input__inner {
				border: 1px solid #DCDFE6;
				cursor: pointer;
				padding: 0 3px;
				color: #606266;
				display: inline-block;
				font-size: 16px;
				line-height: 28px;
				border-radius: 30px;
				outline: 0;
				background: #FFF;
				width: 100%;
				text-align: center;
				height: 28px;
			}
</style>
