<template>
<div :style='{"width":"100%","padding":"30px 7% 40px","margin":"0px auto","position":"relative","background":"none"}'>
    <el-form
	  :style='{"border":"0px solid #28890b30","width":"100%","padding":"30px","position":"relative","background":"none"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
    >
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户账号" prop="yonghuzhanghao">
            <el-select  @change="yonghuzhanghaoChange" v-model="ruleForm.yonghuzhanghao" placeholder="请选择用户账号">
              <el-option
                  v-for="(item,index) in yonghuzhanghaoOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用户姓名" prop="yonghuxingming">
            <el-input  v-model="ruleForm.yonghuxingming" 
                placeholder="用户姓名" clearable :readonly=" false  ||ro.yonghuxingming"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="手机号" prop="shoujihao">
            <el-input  v-model="ruleForm.shoujihao" 
                placeholder="手机号" clearable :readonly=" false  ||ro.shoujihao"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="身份证" prop="shenfenzheng">
            <el-input  v-model="ruleForm.shenfenzheng" 
                placeholder="身份证" clearable :readonly=" false  ||ro.shenfenzheng"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="家庭住址" prop="jiatingzhuzhi">
            <el-input  v-model="ruleForm.jiatingzhuzhi" 
                placeholder="家庭住址" clearable :readonly=" false  ||ro.jiatingzhuzhi"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="年月" prop="nianyue">
            <el-input  v-model="ruleForm.nianyue" 
                placeholder="年月" clearable :readonly=" false  ||ro.nianyue"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="发票" v-if="type!='cross' || (type=='cross' && !ro.fapiao)" prop="fapiao">
            <file-upload
            tip="点击上传发票"
            action="file/upload"
            :limit="3"
            :multiple="true"
            :fileUrls="ruleForm.fapiao?ruleForm.fapiao:''"
            @change="fapiaoUploadChange"
            ></file-upload>
          </el-form-item>
            <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' class="upload" v-else label="发票" prop="fapiao">
                <img v-if="ruleForm.fapiao.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fapiao.split(',')[0]" width="100" height="100">
                <img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fapiao.split(',')" :src="baseUrl+item" width="100" height="100">
            </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用水量" prop="yongshuiliang">
            <el-input  v-model="ruleForm.yongshuiliang" 
                placeholder="用水量" clearable :readonly=" false  ||ro.yongshuiliang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="水费" prop="shuifei">
            <el-input type="number" v-model.number="ruleForm.shuifei" 
                placeholder="水费" clearable :readonly=" false  ||ro.shuifei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="用电量" prop="yongdianliang">
            <el-input  v-model="ruleForm.yongdianliang" 
                placeholder="用电量" clearable :readonly=" false  ||ro.yongdianliang"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="电费" prop="dianfei">
            <el-input type="number" v-model.number="ruleForm.dianfei" 
                placeholder="电费" clearable :readonly=" false  ||ro.dianfei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="暖气费" prop="nuanqifei">
            <el-input type="number" v-model.number="ruleForm.nuanqifei" 
                placeholder="暖气费" clearable :readonly=" false  ||ro.nuanqifei"></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="应缴费用" prop="yingjiaofeiyong">
              <el-input v-model="yingjiaofeiyong" placeholder="应缴费用" readonly></el-input>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}'  label="缴费状态" prop="jiaofeizhuangtai">
            <el-select v-model="ruleForm.jiaofeizhuangtai" placeholder="请选择缴费状态"  >
              <el-option
                  v-for="(item,index) in jiaofeizhuangtaiOptions"
                  :key="index"
                  :label="item"
                  :value="item">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="通知日期" prop="tongzhiriqi">
              <el-date-picker
				  :disabled=" false  ||ro.tongzhiriqi"
                  format="yyyy 年 MM 月 dd 日"
                  value-format="yyyy-MM-dd"
                  v-model="ruleForm.tongzhiriqi" 
                  type="date"
                  placeholder="通知日期">
              </el-date-picker> 
          </el-form-item>
          <el-form-item :style='{"width":"auto","padding":"10px","margin":"0 0 10px","background":"none","display":"inline-block"}' label="通知备注" prop="tongzhibeizhu">
            <el-input  v-model="ruleForm.tongzhibeizhu" 
                placeholder="通知备注" clearable :readonly=" false  ||ro.tongzhibeizhu"></el-input>
          </el-form-item>

      <el-form-item :style='{"padding":"0","margin":"0"}'>
        <el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"6px","background":"#1e3c4f","width":"128px","lineHeight":"36px","fontSize":"14px","height":"36px"}'  type="primary" @click="onSubmit">提交</el-button>
        <el-button :style='{"border":"1px solid #1e3c4f","cursor":"pointer","padding":"0","margin":"0","outline":"none","color":"#1e3c4f","borderRadius":"6px","background":"none","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' @click="back()">返回</el-button>
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
            yonghuzhanghao : false,
            yonghuxingming : false,
            shoujihao : false,
            shenfenzheng : false,
            jiatingzhuzhi : false,
            nianyue : false,
            fapiao : false,
            yongshuiliang : false,
            shuifei : false,
            yongdianliang : false,
            dianfei : false,
            nuanqifei : false,
            yingjiaofeiyong : false,
            jiaofeizhuangtai : false,
            tongzhiriqi : false,
            tongzhibeizhu : false,
        },
        type: '',
        userTableName: localStorage.getItem('UserTableName'),
        ruleForm: {
          yonghuzhanghao: '',
          yonghuxingming: '',
          shoujihao: '',
          shenfenzheng: '',
          jiatingzhuzhi: '',
          nianyue: '',
          fapiao: '',
          yongshuiliang: '',
          shuifei: '',
          yongdianliang: '',
          dianfei: '',
          nuanqifei: '',
          yingjiaofeiyong: '',
          jiaofeizhuangtai: '未缴费',
          tongzhiriqi: '',
          tongzhibeizhu: '',
        },
        yonghuzhanghaoOptions: [],
        jiaofeizhuangtaiOptions: [],


        rules: {
          yonghuzhanghao: [
          ],
          yonghuxingming: [
          ],
          shoujihao: [
          ],
          shenfenzheng: [
          ],
          jiatingzhuzhi: [
          ],
          nianyue: [
          ],
          fapiao: [
          ],
          yongshuiliang: [
          ],
          shuifei: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          yongdianliang: [
          ],
          dianfei: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          nuanqifei: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          yingjiaofeiyong: [
            { validator: this.$validate.isNumber, trigger: 'blur' },
          ],
          jiaofeizhuangtai: [
          ],
          tongzhiriqi: [
          ],
          tongzhibeizhu: [
          ],
        },
		centerType: false,
      };
    },
    computed: {
        yingjiaofeiyong: {
            get: function () {
                return 0+parseFloat(this.ruleForm.shuifei==""?0:this.ruleForm.shuifei)+parseFloat(this.ruleForm.dianfei==""?0:this.ruleForm.dianfei)+parseFloat(this.ruleForm.nuanqifei==""?0:this.ruleForm.nuanqifei) || 0
            }
        },



    },
    components: {
    },
    created() {
		if(this.$route.query.centerType){
			this.centerType = true
		}
	  //this.bg();
      let type = this.$route.query.type ? this.$route.query.type : '';
      this.init(type);
      this.baseUrl = this.$config.baseUrl;
      this.ruleForm.tongzhiriqi = this.getCurDate()
    },
    methods: {
      getMakeZero(s) {
          return s < 10 ? '0' + s : s;
      },
      // 下载
      download(file){
        window.open(`${file}`)
      },
      // 初始化
      init(type) {
        this.type = type;
        if(type=='cross'){
          var obj = JSON.parse(localStorage.getItem('crossObj'));
          for (var o in obj){
            if(o=='yonghuzhanghao'){
              this.ruleForm.yonghuzhanghao = obj[o];
              this.ro.yonghuzhanghao = true;
              continue;
            }
            if(o=='yonghuxingming'){
              this.ruleForm.yonghuxingming = obj[o];
              this.ro.yonghuxingming = true;
              continue;
            }
            if(o=='shoujihao'){
              this.ruleForm.shoujihao = obj[o];
              this.ro.shoujihao = true;
              continue;
            }
            if(o=='shenfenzheng'){
              this.ruleForm.shenfenzheng = obj[o];
              this.ro.shenfenzheng = true;
              continue;
            }
            if(o=='jiatingzhuzhi'){
              this.ruleForm.jiatingzhuzhi = obj[o];
              this.ro.jiatingzhuzhi = true;
              continue;
            }
            if(o=='nianyue'){
              this.ruleForm.nianyue = obj[o];
              this.ro.nianyue = true;
              continue;
            }
            if(o=='fapiao'){
              this.ruleForm.fapiao = obj[o].split(",")[0];
              this.ro.fapiao = true;
              continue;
            }
            if(o=='yongshuiliang'){
              this.ruleForm.yongshuiliang = obj[o];
              this.ro.yongshuiliang = true;
              continue;
            }
            if(o=='shuifei'){
              this.ruleForm.shuifei = obj[o];
              this.ro.shuifei = true;
              continue;
            }
            if(o=='yongdianliang'){
              this.ruleForm.yongdianliang = obj[o];
              this.ro.yongdianliang = true;
              continue;
            }
            if(o=='dianfei'){
              this.ruleForm.dianfei = obj[o];
              this.ro.dianfei = true;
              continue;
            }
            if(o=='nuanqifei'){
              this.ruleForm.nuanqifei = obj[o];
              this.ro.nuanqifei = true;
              continue;
            }
            if(o=='yingjiaofeiyong'){
              this.ruleForm.yingjiaofeiyong = obj[o];
              this.ro.yingjiaofeiyong = true;
              continue;
            }
            if(o=='jiaofeizhuangtai'){
              this.ruleForm.jiaofeizhuangtai = obj[o];
              this.ro.jiaofeizhuangtai = true;
              continue;
            }
            if(o=='tongzhiriqi'){
              this.ruleForm.tongzhiriqi = obj[o];
              this.ro.tongzhiriqi = true;
              continue;
            }
            if(o=='tongzhibeizhu'){
              this.ruleForm.tongzhibeizhu = obj[o];
              this.ro.tongzhibeizhu = true;
              continue;
            }
          }
        }else if(type=='edit'){
			this.info()
		}
        // 获取用户信息
        this.$http.get(this.userTableName + '/session', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            var json = res.data.data;
          }
        });
        this.$http.get('option/yonghu/yonghuzhanghao', {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.yonghuzhanghaoOptions = res.data.data;
          }
        });
        this.jiaofeizhuangtaiOptions = "已缴费,未缴费".split(',')
      },
      // 下二随
      yonghuzhanghaoChange () {
        this.$http.get('follow/yonghu/yonghuzhanghao?columnValue=' + this.ruleForm.yonghuzhanghao, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            if(res.data.data.yonghuxingming){
              this.ruleForm.yonghuxingming = res.data.data.yonghuxingming
            }
            if(res.data.data.shoujihao){
              this.ruleForm.shoujihao = res.data.data.shoujihao
            }
            if(res.data.data.shenfenzheng){
              this.ruleForm.shenfenzheng = res.data.data.shenfenzheng
            }
            if(res.data.data.jiatingzhuzhi){
              this.ruleForm.jiatingzhuzhi = res.data.data.jiatingzhuzhi
            }
          }
        });
      },

    // 多级联动参数
      // 多级联动参数
      info() {
        this.$http.get(`jiaofeitongzhi/detail/${this.$route.query.id}`, {emulateJSON: true}).then(res => {
          if (res.data.code == 0) {
            this.ruleForm = res.data.data;
          }
        });
      },
      // 提交
      onSubmit() {

          this.ruleForm.yingjiaofeiyong = this.yingjiaofeiyong
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
                 this.$http.get('jiaofeitongzhi/list', {
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


                          this.$http.post(`jiaofeitongzhi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                              if (res.data.code == 0) {
                                  this.$message({
                                      message: '操作成功',
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


                  this.$http.post(`jiaofeitongzhi/${this.ruleForm.id?'update':this.centerType?'save':'add'}`, this.ruleForm).then(res => {
                     if (res.data.code == 0) {
                          this.$message({
                              message: '操作成功',
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
      // 返回
      back() {
        this.$router.go(-1);
      },
      fapiaoUploadChange(fileUrls) {
          this.ruleForm.fapiao = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");;
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
	  color: #666;
	  font-weight: 500;
	  width: 80px;
	  font-size: 14px;
	  line-height: 40px;
	  text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  padding: 0 12px;
	  color: #666;
	  font-size: 14px;
	  border-color: #ddd;
	  border-radius: 30px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
	  height: 40px;
	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  border-radius: 30px;
	  padding: 0 10px 0 30px;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  border-color: #28890b30;
	  border-width: 0px;
	  border-style: solid;
	  min-width: 500px;
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
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 30px;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 30px;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  cursor: pointer;
	  color: #333;
	  font-weight: 600;
	  font-size: 24px;
	  border-color: #28890b30;
	  line-height: 54px;
	  border-radius: 30px;
	  background: #fff;
	  width: auto;
	  border-width: 0px;
	  border-style: solid;
	  text-align: center;
	  min-width: 200px;
	  height: 54px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  border: 0px solid #eee;
	  border-radius: 0px;
	  padding: 12px;
	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  outline: none;
	  color: #666;
	  background: #fff;
	  width: auto;
	  font-size: 14px;
	  min-width: 800px;
	  height: 120px;
	}
</style>
