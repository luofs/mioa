layui.config({
	base: '/mioa/common/lib/'
});
layui.use(['layer','jquery','larryElem','form','common','mioaTool'], function() {
	 var $ = layui.$,
	    element = layui.larryElem,
	    layer = parent.layer === undefined ? layui.layer : parent.layer,
	    common = layui.common,
	    mioaTool = layui.mioaTool,
	    form = layui.form;
	 
	 //机构树对象
	var zTree;
	//机构信息，用于展示在页面
	var treeNode = {};
	window.selectPosit = [];

	 //机构树加载及对应事件start
	var setting = {
		view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
		},
		data: {
			simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "parentid",
				rootPId: ""
			}
		},
		callback: {
			beforeClick: function(treeId, treeNode) {
				getDeptPosit(treeNode.id);
				return true;
			}
		}
	};
	//点击机构树加载对应岗位
	function getDeptPosit(id){
		$.get("/mioa/department/findDeptPost",{'id':id},function(resp){
			if(resp.code == 0){
				$("#orgPositionListDiv").html('');
				if(resp.data == ''){
					$("#orgPositionListDiv").html('该机构下无岗位');
					return;
				}else{
					var selectOrgName = zTree.getSelectedNodes()[0].name;
					for(var i in resp.data){
						var checkBoxValue = id+":"+resp.data[i].id;
						var checked = '';
						var posname = selectOrgName+"-"+resp.data[i].name;
						var obj = new Object();
						obj.selectPositId = checkBoxValue;
						obj.selectPositName = posname;
						if(checkPositInArray(/*checkBoxValue*/obj,selectPosit) >=0){
							checked = 'checked';
						}
						$("#orgPositionListDiv").append("<input name='selectPost["+resp.data[i].id+"]' title='"+resp.data[i].name+"'  type='checkbox' "+checked+" lay-filter='selectPostCheckbox'  value='"+checkBoxValue+"' >");
					}
					form.render('checkbox');
				}
			}else{
				common.larryCmsError(resp.msg,'温馨提示您');
			}
		});
	}

	//初始化左侧机构树
	var t = $("#orgtree");
	$.get("/mioa/department/findAllDept",function(resp){
		if(resp.code == 0){
			if(resp.data == ''){
				common.larryCmsError('未找到机构信息','温馨提示您');
				return;
			}
			treeNode = resp.data;
			t = $.fn.zTree.init(t, setting, treeNode);
			zTree = $.fn.zTree.getZTreeObj("orgtree");
			var rootNode = zTree.getNodeByParam("parentid", 0);
			getDeptPosit(rootNode.id);
			zTree.selectNode(rootNode);
			zTree.expandNode(rootNode, true, false, false); 
		}else{
			common.larryCmsError(resp.msg,'温馨提示您');
		}
	});
	//机构树加载及对应事件end
	
	//监听复选框选中事件
	form.on('checkbox(selectPostCheckbox)', function(data){
		var posname = zTree.getSelectedNodes()[0].name+"-"+data.elem.title;
		var obj = new Object();
		obj.selectPositId = data.value;
		obj.selectPositName = posname;
		
		if(data.elem.checked){
			/*selectPosit.push(data.value);*/
			selectPosit.push(obj);
			$("#selectedPostListDiv").append("<button class='layui-btn layui-btn-radius layui-btn-xs layui-btn-disabled' filterId='"+data.value+"'>"+posname+"</button>");
		}else{
			selectPosit.splice(checkPositInArray(/*data.value*/obj,selectPosit),1);
			$("button[filterId='"+data.value+"']").remove();
		}
	});
	
	function checkPositInArray(obj, selectPosit){
		var i = -1;
		$(selectPosit).each(function (index, arrObj) {
           if(obj.selectPositId == arrObj.selectPositId && obj.selectPositName == arrObj.selectPositName){
        	   i = index;
        	   return false;
           }
        });
		return i;
	}
	
});