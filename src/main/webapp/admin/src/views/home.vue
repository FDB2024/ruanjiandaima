<template>
<div class="content" :style='{"padding":"0 30px 30px","flexWrap":"wrap","display":"flex"}'>
	<!-- notice -->
	<!-- title -->
	<div class="text" :style='{"padding":"50px 0","margin":"10px 0","color":"rgb(51, 51, 51)","borderRadius":"5px","textAlign":"center","background":"#fff","width":"100%","fontSize":"26px","fontWeight":"bold","order":"2"}'>欢迎使用 {{this.$project.projectName}}</div>
	

	
	<!-- echarts -->
</div>
</template>
<script>
//0
import router from '@/router/router-static'
import * as echarts from 'echarts'
export default {
	data() {
		return {
			line: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":15,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"symbol":"emptyCircle","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#333","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"showSymbol":true,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"","shadowBlur":0,"width":2,"type":"solid","opacity":1,"shadowColor":"#000"},"symbolSize":4},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"}},
			bar: {"backgroundColor":"transparent","yAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":12,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(250,250,250,0.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"xAxis":{"axisLabel":{"borderType":"solid","rotate":0,"padding":0,"shadowOffsetX":0,"margin":4,"backgroundColor":"transparent","borderColor":"#000","shadowOffsetY":0,"color":"#333","shadowBlur":0,"show":true,"inside":false,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"width":"","fontSize":12,"lineHeight":24,"shadowColor":"transparent","fontWeight":"normal","height":""},"axisTick":{"show":true,"length":5,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"inside":false},"splitLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":false},"axisLine":{"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"cap":"butt","color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"rgba(0,0,0,.5)"},"show":true},"splitArea":{"show":false,"areaStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"rgba(255,255,255,.3)","opacity":1,"shadowBlur":10,"shadowColor":"rgba(0,0,0,.5)"}}},"color":["#00ff00","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"#333","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"barWidth":"auto","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#333","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"colorBy":"data","barCategoryGap":"20%"},"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"base":{"animate":false,"interval":2000}},
			pie: {"backgroundColor":"transparent","color":["#5470c6","#91cc75","#fac858","#ee6666","#73c0de","#3ba272","#fc8452","#9a60b4","#ea7ccc"],"title":{"borderType":"solid","padding":2,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"shadowBlur":0,"bottom":"auto","show":true,"right":"auto","top":"auto","borderRadius":0,"left":"left","borderWidth":0,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","fontSize":14,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"#ccc","textShadowBlur":0},"shadowColor":"transparent"},"legend":{"padding":5,"itemGap":10,"shadowOffsetX":0,"backgroundColor":"transparent","borderColor":"#ccc","shadowOffsetY":0,"orient":"horizontal","shadowBlur":0,"bottom":"auto","itemHeight":14,"show":true,"icon":"roundRect","itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"inherit","shadowOffsetY":0,"color":"inherit","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"transparent"},"right":"auto","top":"auto","borderRadius":0,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"inherit","shadowBlur":0,"width":"auto","type":"inherit","opacity":1,"shadowColor":"transparent"},"left":"right","borderWidth":0,"width":"auto","itemWidth":25,"textStyle":{"textBorderWidth":0,"color":"#333","textShadowColor":"transparent","ellipsis":"...","overflow":"none","fontSize":12,"lineHeight":24,"textShadowOffsetX":0,"textShadowOffsetY":0,"textBorderType":"solid","fontWeight":500,"textBorderColor":"transparent","textShadowBlur":0},"shadowColor":"rgba(0,0,0,.3)","height":"auto"},"series":{"itemStyle":{"borderType":"solid","shadowOffsetX":0,"borderColor":"#333","shadowOffsetY":0,"color":"","shadowBlur":0,"borderWidth":0,"opacity":1,"shadowColor":"#000"},"label":{"borderType":"solid","rotate":0,"padding":0,"textBorderWidth":0,"backgroundColor":"transparent","borderColor":"#fff","color":"#333","show":true,"textShadowColor":"transparent","distanceToLabelLine":5,"ellipsis":"...","overflow":"none","borderRadius":0,"borderWidth":0,"fontSize":12,"lineHeight":18,"textShadowOffsetX":0,"position":"outside","textShadowOffsetY":0,"textBorderType":"solid","textBorderColor":"#fff","textShadowBlur":0},"labelLine":{"show":true,"length":10,"lineStyle":{"shadowOffsetX":0,"shadowOffsetY":0,"color":"#333","shadowBlur":0,"width":1,"type":"solid","opacity":1,"shadowColor":"#000"},"length2":14,"smooth":false}}},
		};
	},
	mounted(){
		this.init();
	},
	methods:{
		// 词云
		wordclouds(wordcloudData,echartsId) {
			let wordcloud = $template2.back.board.wordcloud
			wordcloud = JSON.parse(JSON.stringify(wordcloud), (k, v) => {
			  if(typeof v == 'string' && v.indexOf('function') > -1){
				return eval("(function(){return "+v+" })()")
			  }
			  return v;
			})
			wordcloud.option.series[0].data=wordcloudData;
			
			this.myChart0 = echarts.init(document.getElementById(echartsId));
			let myChart = this.myChart0
			let img = wordcloud.maskImage
		
			if (img) {
				var maskImage = new Image();
				maskImage.src = img
				maskImage.onload = function() {
					wordcloud.option.series[0].maskImage = maskImage
					myChart.clear()
					myChart.setOption(wordcloud.option)
				}
			} else {
				delete wordcloud.option.series[0].maskImage
				myChart.clear()
				myChart.setOption(wordcloud.option)
			}
		},
		// 统计图动画
		myChartInterval(type, xAxisData, seriesData, myChart) {
			this.$nextTick(() => {
				setInterval(() => {
					let xAxis = xAxisData.shift()
					xAxisData.push(xAxis)
					let series = seriesData.shift()
					seriesData.push(series)
				
					if (type == 1) {
						myChart.setOption({
							xAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
					if (type == 2) {
						myChart.setOption({
							yAxis: [{
								data: xAxisData
							}],
							series: [{
								data: seriesData
							}]
						});
					}
				}, $template2.back.board.bar.base.interval);
			})
		},
		init(){
			if(this.$storage.get('Token')){
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code != 0) {
				router.push({ name: 'login' })
				}
			});
			}else{
				router.push({ name: 'login' })
			}
		},
  }
};
</script>
<style lang="scss" scoped>
    .cardView {
        display: flex;
        flex-wrap: wrap;
        width: 100%;

        .cards {
            display: flex;
            align-items: center;
            width: 100%;
            margin-bottom: 10px;
            justify-content: center;
            .card {
                width: calc(25% - 20px);
                margin: 0 10px;
                /deep/.el-card__body{
                    padding: 0;
                }
            }
        }
    }
	
	// 日历
	.calendar td .text {
				border-radius: 12px;
				flex-direction: column;
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td .text .new {
				color: #000;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td .text .old {
				color: #666;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.festival .text {
				border-radius: 12px;
				flex-direction: column;
				background: transparent;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.festival .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td.festival .text .new {
				color: #000;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td.festival .text .old {
				color: #666;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.other .text {
				border-radius: 12px;
				flex-direction: column;
				background: #fff;
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				opacity: 0.3;
				height: 100%;
			}
	.calendar td.other .text:hover {
				background: rgba(78,110,242,.1);
			}
	.calendar td.other .text .new {
				color: #000;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td.other .text .old {
				color: #666;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	.calendar td.today .text {
				border-radius: 12px;
				flex-direction: column;
				color: #fff;
				background: rgb(64, 158, 255);
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				height: 100%;
			}
	.calendar td.today .text:hover {
				background: rgba(64, 158, 255,.5);
			}
	.calendar td.today .text .new {
				color: inherit;
				font-size: 18px;
				line-height: 1.4;
			}
	.calendar td.today .text .old {
				color: inherit;
				display: none;
				font-size: 16px;
				line-height: 1.4;
			}
	
	// echarts1
	.type1 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0px 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type1 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts2
	.type2 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 10px 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type2 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type2 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type2 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts3
	.type3 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type3 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 10px 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type3 .echarts3 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type3 .echarts3:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts4
	.type4 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type4 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type4 .echarts3 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts3:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type4 .echarts4 {
				border-radius: 5px;
				padding: 20px;
				margin: 10px 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type4 .echarts4:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	// echarts5
	.type5 .echarts1 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0 10px;
				background: rgba(255,255,255,1);
				width: 100%;
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts1:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts2 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts2:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts3 {
				border-radius: 5px;
				padding: 20px;
				margin: 0 0 10px;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts3:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts4 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts4:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	.type5 .echarts5 {
				border-radius: 5px;
				padding: 20px;
				margin: 0;
				background: rgba(255,255,255,1);
				width: calc(50% - 5px);
				position: relative;
				transition: 0.3s;
				height: 400px;
			}
	.type5 .echarts5:hover {
				box-shadow: 1px 1px 20px rgba(255,255,255,.12);
				transform: translate3d(0, -10px, 0);
				z-index: 1;
				background: rgba(255,255,255,.12);
			}
	
	.echarts-flag-2 {
	  display: flex;
	  flex-wrap: wrap;
	  justify-content: space-between;
	  padding: 10px 20px;
	  background: rebeccapurple;
	
	  &>div {
	    width: 32%;
	    height: 300px;
	    margin: 10px 0;
	    background: rgba(255,255,255,.1);
	    border-radius: 8px;
	    padding: 10px 20px;
	  }
	}
</style>
