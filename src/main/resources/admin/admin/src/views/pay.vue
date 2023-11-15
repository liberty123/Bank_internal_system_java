<template>
  <div class="container"  :style='{"margin":"0 200px 20px"}'>
    <el-alert title="Please verify the order information before confirming payment" type="success" :closable="false"></el-alert>
    <!-- <div class="top-content">
      <span>收款人</span>
      <el-input style="width:300px" v-model="name" placeholder="收款人"></el-input>
      <span style="margin-left:20px">收款account</span>
      <el-input style="width:300px" v-model="account" placeholder="收款account"></el-input>
    </div> -->
    <!-- <div class="price-content">
      <span>amount</span>
      <span>￥99.0</span>
    </div> -->
    <div class="pay-type-content">
      <div class="pay-type-item">
        <el-radio v-model="type" label="WeChat payment"></el-radio>
        <img src="@/assets/img/test/weixin.png" alt>
        <!-- <span>WeChat payment</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="Alipay payment"></el-radio>
        <img src="@/assets/img/test/zhifubao.png" alt>
        <!-- <span>Alipay payment</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="China Construction Bank"></el-radio>
        <img src="@/assets/img/test/jianshe.png" alt>
        <!-- <span>China Construction Bank</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="agricultural bank"></el-radio>
        <img src="@/assets/img/test/nongye.png" alt>
        <!-- <span>agricultural bank</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="Bank of China"></el-radio>
        <img src="@/assets/img/test/zhongguo.png" alt>
        <!-- <span>Bank of China</span> -->
      </div>
      <div class="pay-type-item">
        <el-radio v-model="type" label="Bank of Communications"></el-radio>
        <img src="@/assets/img/test/jiaotong.png" alt>
        <!-- <span>Bank of Communications</span> -->
      </div>
    </div>
    <div class="buton-content">
      <el-button @click="submitTap" type="primary">Confirm Payment</el-button>
      <el-button @click="back()">return</el-button>
    </div>
  </div>
</template>
<script>
// import { Message } from "element-ui";
export default {
  data() {
    return {
      name: "",
      account: "",
      type: "",
      table: "",
      obj: ""
    };
  },
  mounted() {
    let table = this.$storage.get("paytable");
    let obj = this.$storage.getObj("payObject");
    this.table = table;
    this.obj = obj;
  },
  methods: {
    submitTap() {
      // if (!this.name) {
      //   this.$message.error("Enter 收款人full name");
      //   return;
      // }
      // if (!this.account) {
      //   this.$message.error("Enter 收款人account");
      //   return;
      // }
      if (!this.type) {
        this.$message.error("Please select payment method");
        return;
      }
      this.$confirm(`Confirm Payment?`, "tiitle", {
        confirmButtonText: "Confirm",
        cancelButtonText: "cancel",
        type: "warning"
      }).then(() => {
        this.obj.ispay = "已支付";
        this.$http({
          url: `${this.table}/update`,
          method: "post",
          data: this.obj
        }).then(({ data }) => {
          if (data && data.code === 0) {
            this.$message({
              message: "支付成功",
              type: "success",
              duration: 1500,
              onClose: () => {
                this.$router.go(-1);
              }
            });
          } else {
            this.$message.error(data.msg);
          }
        });
      });
    },
    back(){
      this.$router.go(-1);
    }
  }
};
</script>
<style lang="scss" scoped>
.container {
  margin: 10px;
  font-size: 14px;
  span {
    width: 60px;
  }
  .top-content {
    display: flex;
    align-items: center;
    padding: 20px;
  }
  .price-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    padding-bottom: 20px;
    padding: 20px;
    border-bottom: 1px solid #eeeeee;
    font-size: 20px;
    font-weight: bold;
    color: red;
  }
  .pay-type-content {
    display: flex;
    align-items: center;
    margin-top: 20px;
    flex-wrap: wrap;
    span {
      width: 100px;
    }
    .pay-type-item {
      display: flex;
      align-items: center;
      justify-content: space-between;
      width: 300px;
      margin: 20px;
      border: 1px solid #eeeeee;
      padding: 20px;
    }
  }
  .buton-content {
    margin: 20px;
  }
}
</style>
