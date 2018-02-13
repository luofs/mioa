//add by luofs
layui.define(['jquery', 'larryElem', 'layer', 'common'], function(exports) {
  var $ = layui.$,
    element = layui.larryElem,
    layer =  layui.layer,
    parentLayer = parent.layer === undefined ? layui.layer : parent.layer,
    common = layui.common;
    module_name = 'mioaTool';
    

    var mioaTool = {
    		 //弹出窗口 add by luofs
    	       openWin:function(title,url,w,h,offset,successCallBack){
    		   	    if(offset==null||offset==''){
    		   	        offset = 100;
    		   	    }
    		   	    if (title == null || title == ''){
    		   	        title=false;
    		   	    };
    		   	    if (url == null || url == '') {
    		   	        url="404.html";
    		   	    };
    		   	    if (w == null || w == '') {
    		   	        w=($(window).width()*0.9);
    		   	    };
    		   	    if (h == null || h == '') {
    		   	        h=($(window).height() - 50);
    		   	    };
    		   	    parentLayer.open({
    		   	        offset:offset +'px',
    		   	        type: 2,
    		   	        area: [w+'px', h +'px'],
    		   	        fix: false, //不固定
    		   	        maxmin: true,
    		   	        shadeClose: true,
    		   	        shade:0.4,
    		   	        title: title,
    		   	        content: url,
	    		   	    success: function(layero, index){
	    		   	    	if(successCallBack){
	    		   	    		successCallBack.call(this,layero, index);
	    		   	    	}
	    		   	    }
    		   	    });
    	   	  },
    	   	openWinWithBtn:function(title,url,btn1,btn2,btn1CallBack,btn2CallBack,successCallBack,w,h,offset){
		   	    if(offset==undefined||offset==null||offset==''){
		   	        offset = 100;
		   	    }
		   	    if (title==undefined || title == null || title == ''){
		   	        title=false;
		   	    };
		   	    if (url==undefined || url == null || url == '') {
		   	        url="404.html";
		   	    };
		   	    if (w==undefined || w == null || w == '') {
		   	        w=($(window).width()*0.9);
		   	    };
		   	    if (h==undefined || h == null || h == '') {
		   	        h=($(window).height() - 50);
		   	    };
		   	    parentLayer.open({
		   	        offset:offset +'px',
		   	        type: 2,
		   	        area: [w+'px', h +'px'],
		   	        fix: false, //不固定
		   	        maxmin: true,
		   	        shadeClose: true,
		   	        shade:0.4,
		   	        title: title,
		   	        content: url,
		   	        btn: [btn1, btn2],
		   	        yes:function(index, layero){
		   	        	if(btn1CallBack){
		   	        		btn1CallBack.call(this,layero, index);
		   	        	}else{
		   	        		return false;
		   	        	}
		   	        },
		   	        btn2: function(index, layero){
		   	        	if(btn2CallBack){
		   	        		btn2CallBack.call(this,layero, index);
		   	        	}else{
		   	        		layer.close(index);
		   	        	}
			   	    },
    		   	    success: function(layero, index){
    		   	    	if(successCallBack){
    		   	    		successCallBack.call(this,layero, index);
    		   	    	}
    		   	    }
		   	    });
	   	  },
    	   	  //弹出html窗
    	   	openSimpleWin:function(title,html,w,h,offset,successCallBack){
		   	    if(offset==undefined || offset==null||offset==''){
		   	        offset = 100;
		   	    }
		   	    if (title==undefined || title == null || title == ''){
		   	        title=false;
		   	    };
		   	    if (html==undefined || html == null || html == '') {
		   	        html="404.html";
		   	    };
		   	    if (w==undefined || w == null || w == '') {
		   	        w=($(window).width()*0.9);
		   	    };
		   	    if (h==undefined || h == null || h == '') {
		   	        h=($(window).height() - 50);
		   	    };
		   	    layer.open({
		   	        offset:offset +'px',
		   	        type: 1,
		   	        area: [w+'px', h +'px'],
		   	        fix: false, //不固定
		   	        maxmin: true,
		   	        shadeClose: true,
		   	        shade:0.4,
		   	        title: title,
		   	        content: html,
    		   	    success: function(layero, index){
    		   	    	if(successCallBack){
    		   	    		successCallBack.call(this,layero, index);
    		   	    	}
    		   	    }
		   	    });
	   	  },
			 //弹出窗口 add by luofs
		     ajaxSubmit:function(url, params, successCallBack, errCallBack){
		    	  $.post(url, params, function (res) {
		    	        if (res.code==0) {
		    	        	if (successCallBack && typeof successCallBack == "function") {
		    	        		successCallBack.call(this);
		    	            } else {
		    	            	var successMsg = "操作成功";
			    	        	if(res.msg && res.msg!=''){
			    	        		successMsg = res.msg;
			    	        	}
			    	        	common.larryCmsSuccess(successMsg, '请求成功', null);
			    	        	var index=parent.layer.getFrameIndex(window.name);
			    	        	parent.layer.close(index);
		    	            }
		    	        }else{
		    	        	if (errCallBack && typeof errCallBack == "function") {
		    	        		errCallBack.call(this);
		    	            } else {
		    	            	var errMsg = "操作失败";
			    	        	if(res.msg && res.msg!=''){
			    	        		errMsg = res.msg;
			    	        	}
			    	        	common.larryCmsSuccess(errMsg, '请求失败', null);
		    	            }
		    	        }
		    	    }, 'json');
		  	  },
		  	  //js拷贝（浅拷贝）
		  	jsCopy:function (p) {
  	　　　　var c = {};
  	　　　　for (var i in p) { 
  	　　　　　　c[i] = p[i];
  	　　　　}
  	　　　　c.uber = p;
  	　　　　return c;
		  	},
		  	//打开职位选择窗口
		  	openPositionSelectWin:function(btn1CallBack, btn2CallBack, successCallBack){
		  		this.openWinWithBtn('职位选择','/mioa/backstage/html/common/selectPosition.html','确定','取消',btn1CallBack,btn2CallBack,successCallBack,800,650,null);
		  	}
    };

  exports(module_name, mioaTool);
});