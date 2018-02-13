layui.config({
	base: '/mioa/common/lib/'
});
layui.use(['layer', 'form', 'table', 'common', 'mioaTool'], function() {
	var $ = layui.$,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		form = layui.form,
		table = layui.table,
		common = layui.common,
		mioaTool = layui.mioaTool;

	var selectOrg = [];
	var setting = {
			check: {
				enable: true,
				chkboxType: {"Y":"", "N":""}
			},
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true,
					idKey: "id",
					pIdKey: "parentid",
					rootPId: ""
				}
			},
			callback: {
				beforeClick: function(treeId, treeNode){
					var zTree = $.fn.zTree.getZTreeObj("orgtree");
					zTree.checkNode(treeNode, !treeNode.checked, null, true);
					return false;
				},
				onCheck: function(e, treeId, treeNode){
					selectOrg = [];
					var zTree = $.fn.zTree.getZTreeObj("orgtree"),
					nodes = zTree.getCheckedNodes(true),
					v = "";
					for (var i=0, l=nodes.length; i<l; i++) {
						v += nodes[i].name + ",";
						selectOrg.push(nodes[i].id);
					}
					if (v.length > 0 ) v = v.substring(0, v.length-1);
					var cityObj = $("#orgSel");
					cityObj.attr("value", v);
				}
			}
		};

	var treeNode = {};
	var t = $("#orgtree");
	$.get("/mioa/department/findAllDept",function(resp){
		if(resp.code == 0){
			if(resp.data == ''){
				common.larryCmsError('未找到机构信息','温馨提示您');
				return;
			}
			treeNode = resp.data;
			$.get("/mioa/position/findDeptid?id=1", function(resp){
				if(resp.code == 0){
					if(resp.data != ''){
						for(var i=0; i<resp.data.length; i++){
							for(var j=0; j<treeNode.length; j++){
								if(resp.data[i] == treeNode[j].id){
									treeNode[j].checked = true;
								}
							}
						}
					}
					t = $.fn.zTree.init(t, setting, treeNode);
					var zTree = $.fn.zTree.getZTreeObj("orgtree");
					var rootNode = zTree.getNodeByParam("parentid", 0);
					zTree.selectNode(rootNode);
					zTree.expandNode(rootNode, true, false, false); 
				}else{
					common.larryCmsError(resp.msg,'温馨提示您');
				}
			});
		}else{
			common.larryCmsError(resp.msg,'温馨提示您');
		}
	});
	
	$("#orgSel").bind("click",function(){
		var cityObj = $("#orgSel");
		var cityOffset = $("#orgSel").offset();
		$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
		$("body").bind("mousedown", onBodyDown);
	});
	
	function hideMenu() {
		$("#menuContent").fadeOut("fast");
		$("body").unbind("mousedown", onBodyDown);
	}
	function onBodyDown(event) {
		if (!(event.target.id == "menuBtn" || event.target.id == "orgSel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
			hideMenu();
		}
	}
	
  //监听提交
  form.on('submit(positAssignForm)', function(data){
	  if(selectOrg.length == 0){
		 common.larryCmsalert('您还未将该职位分配给任何机构',function(){});
	  }else{
		  var param = $.extend(data.field,{'orgids':selectOrg}); 
		  mioaTool.ajaxSubmit("http://127.0.0.1:8081/mioa/position/assignPosition", param);
	  }
    return false;
  });


});