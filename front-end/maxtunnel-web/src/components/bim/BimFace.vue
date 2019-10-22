<template>
    <div class="bimface-wrap">
        <div class='buttons' >
            <button type="button" class="button" @click="hideComponents">隐藏构件</button>
            <button type="button" class="button" @click="showComponents">显示构件</button>
            <button type="button"  class="button"  @click="addkey">增加帧(至少2个)</button>
            <button type="button"  class="button"  @click="playkey(10)">播放</button>
        </div>
        <!-- 定义DOM元素，用于在该DOM元素中显示模型或图纸 -->
        <div class='model' id="domId"></div>
    </div>
</template>

<script lang="ts">
    import { Component, Vue, Prop } from "vue-property-decorator"
    import { BimFaceData } from '@/types/components/bimface.interface'
    // import {  } from "@/components" // 组件
    
    @Component({})
    export default class About extends Vue {
        // prop
        @Prop({
        required: false,
            default: ''
        }) name!: string

        // data
        data: BimFaceData = {
            componentName: 'BimFace',
            viewer3D: null,
            app: null,
            wt: null,
            viewToken: 'ab3b4e6c3cad4d3395ed654e1d6547ad'
        }

        mounted() {
            this.loadBIM()
        }

        loadBIM() {
            let options = new BimfaceSDKLoaderConfig();
            options.viewToken = this.data.viewToken;
			BimfaceSDKLoader.load(options, this.successCallback, this.failureCallback);
        }

        successCallback(viewMetaData: any) {
            if (viewMetaData.viewType === "3DView") {
                let domShow = document.getElementById('domId');
                let viewConfig = new Glodon.Bimface.Viewer.Viewer3DConfig();
                viewConfig.domElement = domShow;    
                this.data.viewer3D = new Glodon.Bimface.Viewer.Viewer3D(viewConfig); 
                // 添加待显示的模型
				this.data.viewer3D.addView(this.data.viewToken);
				let config = new Glodon.Bimface.Plugins.Walkthrough.WalkthroughConfig();
				config.viewer = this.data.viewer3D;
                this.data.wt = new Glodon.Bimface.Plugins.Walkthrough.Walkthrough(config);
                
                this.data.viewer3D.addEventListener(Glodon.Bimface.Viewer.Viewer3DEvent.ComponentsSelectionChanged,(componentData: any) => {

					if (componentData && componentData.objectId) {
						console.log(componentData);
						console.log(componentData.objectId);
					}})
				// 监听添加view完成的事件
				this.data.viewer3D.addEventListener(Glodon.Bimface.Viewer.Viewer3DEvent.ViewAdded, () => {
                //自适应屏幕大小
                    let _this = this
                    window.onresize = function(){
                        _this.data.viewer3D.resize(document.documentElement.clientWidth,document.documentElement.clientHeight-40)
                }
				// 调用viewer3D对象的Method，可以继续扩展功能
				// 渲染3D模型
				this.data.viewer3D.render();
				}); 
            }
        }

        failureCallback(error: any) {
            console.log(error);
        }

        hideComponents() {
            this.data.viewer3D.hideComponentsById(["559707",
            // "579959","578196","607550","607549","579968","606066",
            // "579977","578228","603162","603060","579985","581014","579101","580935"
            ]);
            this.data.viewer3D.render();
        }

		showComponents() {
            this.data.viewer3D.showComponentsById(["559707",
            // "579959","578196","607550","607549","579968","606066",
            // "579977","578228","603162","603060","579985","581014","579101","580935"
        ]);
            this.data.viewer3D.render();
        }
        //增加关键帧，大于1个
        addkey() {
            // 记录视角
            this.data.wt.addKeyFrame(); 
        }
			//播放
		playkey(time: number) {
			//设置时间
			this.data.wt.setWalkthroughTime(time)
			//获取关键帧列表
			let list = this.data.wt.getKeyFrames()
			//从哪一个关键帧开始，关键帧id
			this.data.wt.play(list[0].id);
		}

    }
</script>

<style lang="less">

    .bimface-wrap {
        display: flex; 
        flex-direction: column; 
        overflow: hidden;
        height: 100%; 
        width: 100%; 
        position: relative;
        border: 1px solid black;
    }
    .model {flex: 1}
    .button {
        margin: 1vmin auto; 
        width: 16vmin; 
        height: 5vmin; 
        background: #11DAB7; 
        color: #FFFFFF; 
        border-radius: 3px;
        border: none; 
        cursor: pointer;
        margin-right: 2vmin;
    }
    .buttons{
        position: absolute;
        z-index: 1000;
        top: 0;
        left: 0;
    }
</style>

