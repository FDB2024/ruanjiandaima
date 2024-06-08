<template>
	<div class="addEdit-block" :style='{"padding":"30px","margin":"0 30px","background":"#fff"}'>
		<el-form
			:style='{"padding":"30px","boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","borderRadius":"6px","flexWrap":"wrap","display":"flex"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="80px"
		>
			<template >
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="select" v-if="type!='info'" label="用户账号" prop="yonghuzhanghao">
					<el-select :disabled="ro.yonghuzhanghao" @change="yonghuzhanghaoChange" v-model="ruleForm.yonghuzhanghao" placeholder="请选择用户账号">
						<el-option
							v-for="(item,index) in yonghuzhanghaoOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.yonghuzhanghao" label="用户账号" prop="yonghuzhanghao">
					<el-input v-model="ruleForm.yonghuzhanghao" placeholder="用户账号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用户姓名" prop="yonghuxingming">
					<el-input  v-model="ruleForm.yonghuxingming" placeholder="用户姓名" clearable  :readonly="ro.yonghuxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="用户姓名" prop="yonghuxingming">
					<el-input v-model="ruleForm.yonghuxingming" placeholder="用户姓名" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="手机号" prop="shoujihao">
					<el-input  v-model="ruleForm.shoujihao" placeholder="手机号" clearable  :readonly="ro.shoujihao"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="手机号" prop="shoujihao">
					<el-input v-model="ruleForm.shoujihao" placeholder="手机号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="身份证" prop="shenfenzheng">
					<el-input  v-model="ruleForm.shenfenzheng" placeholder="身份证" clearable  :readonly="ro.shenfenzheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="身份证" prop="shenfenzheng">
					<el-input v-model="ruleForm.shenfenzheng" placeholder="身份证" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="家庭住址" prop="jiatingzhuzhi">
					<el-input  v-model="ruleForm.jiatingzhuzhi" placeholder="家庭住址" clearable  :readonly="ro.jiatingzhuzhi"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="家庭住址" prop="jiatingzhuzhi">
					<el-input v-model="ruleForm.jiatingzhuzhi" placeholder="家庭住址" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="年月" prop="nianyue">
					<el-input  v-model="ruleForm.nianyue" placeholder="年月" clearable  :readonly="ro.nianyue"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="年月" prop="nianyue">
					<el-input v-model="ruleForm.nianyue" placeholder="年月" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="upload" v-if="type!='info' && !ro.fapiao" label="发票" prop="fapiao">
					<file-upload
						tip="点击上传发票"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.fapiao?ruleForm.fapiao:''"
						@change="fapiaoUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="upload" v-else-if="ruleForm.fapiao" label="发票" prop="fapiao">
					<img v-if="ruleForm.fapiao.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.fapiao.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.fapiao.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用水量" prop="yongshuiliang">
					<el-input  v-model="ruleForm.yongshuiliang" placeholder="用水量" clearable  :readonly="ro.yongshuiliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="用水量" prop="yongshuiliang">
					<el-input v-model="ruleForm.yongshuiliang" placeholder="用水量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="水费" prop="shuifei">
					<el-input type="number" v-model.number="ruleForm.shuifei" placeholder="水费" clearable  :readonly="ro.shuifei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="水费" prop="shuifei">
					<el-input v-model="ruleForm.shuifei" placeholder="水费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="用电量" prop="yongdianliang">
					<el-input  v-model="ruleForm.yongdianliang" placeholder="用电量" clearable  :readonly="ro.yongdianliang"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="用电量" prop="yongdianliang">
					<el-input v-model="ruleForm.yongdianliang" placeholder="用电量" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="电费" prop="dianfei">
					<el-input type="number" v-model.number="ruleForm.dianfei" placeholder="电费" clearable  :readonly="ro.dianfei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="电费" prop="dianfei">
					<el-input v-model="ruleForm.dianfei" placeholder="电费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="暖气费" prop="nuanqifei">
					<el-input type="number" v-model.number="ruleForm.nuanqifei" placeholder="暖气费" clearable  :readonly="ro.nuanqifei"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="暖气费" prop="nuanqifei">
					<el-input v-model="ruleForm.nuanqifei" placeholder="暖气费" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'" label="应缴费用" prop="yingjiaofeiyong">
					<el-input v-model="yingjiaofeiyong" placeholder="应缴费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.yingjiaofeiyong" label="应缴费用" prop="yingjiaofeiyong">
					<el-input v-model="ruleForm.yingjiaofeiyong" placeholder="应缴费用" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="select" v-if="type!='info'"  label="缴费状态" prop="jiaofeizhuangtai">
					<el-select :disabled="ro.jiaofeizhuangtai" v-model="ruleForm.jiaofeizhuangtai" placeholder="请选择缴费状态" >
						<el-option
							v-for="(item,index) in jiaofeizhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="缴费状态" prop="jiaofeizhuangtai">
					<el-input v-model="ruleForm.jiaofeizhuangtai"
						placeholder="缴费状态" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="date" v-if="type!='info'" label="通知日期" prop="tongzhiriqi">
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.tongzhiriqi" 
						type="date"
						:readonly="ro.tongzhiriqi"
						placeholder="通知日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-else-if="ruleForm.tongzhiriqi" label="通知日期" prop="tongzhiriqi">
					<el-input v-model="ruleForm.tongzhiriqi" placeholder="通知日期" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' class="input" v-if="type!='info'"  label="通知备注" prop="tongzhibeizhu">
					<el-input  v-model="ruleForm.tongzhibeizhu" placeholder="通知备注" clearable  :readonly="ro.tongzhibeizhu"></el-input>
				</el-form-item>
				<el-form-item :style='{"width":"50%","margin":"0 0 20px 0"}' v-else class="input" label="通知备注" prop="tongzhibeizhu">
					<el-input v-model="ruleForm.tongzhibeizhu" placeholder="通知备注" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}' class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-tijiao04" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					CONFIRM
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-quxiao19" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					CANCEL
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-fanhui" :style='{"margin":"0 2px","fontSize":"14px","color":"#fff","height":"40px"}'></span>
					BACK
				</el-button>
			</el-form-item>
		</el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("请输入正确的身份证号码"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("请输入正确的URL地址"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("请输入正确的手机号码"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("请输入正确的电话号码"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("请输入正确的邮箱地址"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("请输入数字"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("请输入整数"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',
			
			
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
					{ validator: validateNumber, trigger: 'blur' },
				],
				yongdianliang: [
				],
				dianfei: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				nuanqifei: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				yingjiaofeiyong: [
					{ validator: validateNumber, trigger: 'blur' },
				],
				jiaofeizhuangtai: [
				],
				tongzhiriqi: [
				],
				tongzhibeizhu: [
				],
			}
		};
	},
	props: ["parent"],
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
		this.ruleForm.tongzhiriqi = this.getCurDate()
	},
	methods: {
		
		// 下载
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
							this.ruleForm.fapiao = obj[o];
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
				














				this.ruleForm.jiaofeizhuangtai='未缴费'


			}
			
			
			// 获取用户信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {
					
					var json = data.data;
				} else {
					this.$message.error(data.msg);
				}
			});
			
            this.$http({
				url: `option/yonghu/yonghuzhanghao`,
				method: "get"
            }).then(({ data }) => {
				if (data && data.code === 0) {
					this.yonghuzhanghaoOptions = data.data;
				} else {
					this.$message.error(data.msg);
				}
            });
            this.jiaofeizhuangtaiOptions = "已缴费,未缴费".split(',')
			
		},
			// 下二随
			yonghuzhanghaoChange () {
				this.$http({
					url: `follow/yonghu/yonghuzhanghao?columnValue=`+ this.ruleForm.yonghuzhanghao,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						if(data.data.yonghuxingming){
							this.ruleForm.yonghuxingming = data.data.yonghuxingming
						}
						if(data.data.shoujihao){
							this.ruleForm.shoujihao = data.data.shoujihao
						}
						if(data.data.shenfenzheng){
							this.ruleForm.shenfenzheng = data.data.shenfenzheng
						}
						if(data.data.jiatingzhuzhi){
							this.ruleForm.jiatingzhuzhi = data.data.jiatingzhuzhi
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jiaofeitongzhi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片后台不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {
        this.ruleForm.yingjiaofeiyong = this.yingjiaofeiyong














	if(this.ruleForm.fapiao!=null) {
		this.ruleForm.fapiao = this.ruleForm.fapiao.replace(new RegExp(this.$base.url,"g"),"");
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
				url: "jiaofeitongzhi/page", 
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
					   url: `jiaofeitongzhi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jiaofeitongzhiCrossAddOrUpdateFlag = false;
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
			   url: `jiaofeitongzhi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jiaofeitongzhiCrossAddOrUpdateFlag = false;
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
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jiaofeitongzhiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    fapiaoUploadChange(fileUrls) {
	    this.ruleForm.fapiao = fileUrls;
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
	  	  color: #9E9E9E;
	  	  font-weight: 500;
	  	  width: 80px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: center;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 80px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px dashed #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px dashed #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 200px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px dashed #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
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
	  	  border: 2px dashed #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #C8C8C8;
	  	  width: 60px;
	  	  font-size: 32px;
	  	  line-height: 60px;
	  	  text-align: center;
	  	  height: 60px;
	  	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #C8C8C8;
	  	  width: 60px;
	  	  font-size: 32px;
	  	  line-height: 60px;
	  	  text-align: center;
	  	  height: 60px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #C8C8C8;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #C8C8C8;
	  	  width: 60px;
	  	  font-size: 32px;
	  	  line-height: 60px;
	  	  text-align: center;
	  	  height: 60px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px dashed #C8C8C8;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
	
	.add-update-preview .btn .btn1 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				float: left;
				height: 40px;
			}
	
	.add-update-preview .btn .btn1:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn2 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #000000;
				width: auto;
				font-size: 14px;
				float: left;
				height: 40px;
			}
	
	.add-update-preview .btn .btn2:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn3 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				float: right;
				height: 40px;
			}
	
	.add-update-preview .btn .btn3:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn4 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				float: right;
				height: 40px;
			}
	
	.add-update-preview .btn .btn4:hover {
				opacity: 0.5;
			}
	
	.add-update-preview .btn .btn5 {
				border: 0;
				cursor: pointer;
				border-radius: 5px;
				padding: 0 14px;
				margin: 4px;
				outline: none;
				color: #fff;
				background: #0E9BD3;
				width: auto;
				font-size: 14px;
				float: right;
				height: 40px;
			}
	
	.add-update-preview .btn .btn5:hover {
				opacity: 0.5;
			}
</style>
