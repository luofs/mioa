layui.config({
	base: '/mioa/common/lib/'
});
layui.use(['layer','jquery','larryElem','common','mioaTool'], function() {
	 var $ = layui.$,
	    element = layui.larryElem,
	    layer = parent.layer === undefined ? layui.layer : parent.layer,
	    common = layui.common,
	    mioaTool = layui.mioaTool;
	 
	 //机构树对象
	var zTree;
	//机构信息，用于展示在页面
	var orgData = {id:'', name:'', abbr:'', parentid:'', parentName:'', telphone:'', fax:'', address:''},
		treeNode = {};
	
	function copyOrgData(treeNode, orgData){
		orgData.id = treeNode.id;
		orgData.name = treeNode.name;
		orgData.abbr = treeNode.abbr;
		orgData.parentName = treeNode.parentName;
		orgData.telphone = treeNode.telphone;
		orgData.fax = treeNode.fax;
		orgData.address = treeNode.address;
		orgData.parentid = treeNode.parentid;
	}
	
	//将div orgmsg绑定到机构信息对象，点击树时联动显示机构信息
	 new Vue({
	 		el: '#orgmsg',
	 		data:orgData
	 });

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
				var zTree = $.fn.zTree.getZTreeObj("orgtree");
				if (treeNode.isParent) {
					copyOrgData(treeNode, orgData)
					zTree.expandNode(treeNode);
					return false;
				} else {
					copyOrgData(treeNode, orgData)
					return true;
				}
			}
		}
	};

	var t = $("#orgtree");
	$.get("/mioa/department/findAllDept",function(resp){
		if(resp.code == 0){
			if(resp.data == ''){
				common.larryCmsError('未找到机构信息','温馨提示您');
				return;
			}
			treeNode = resp.data;
			t = $.fn.zTree.init(t, setting, treeNode);
			var zTree = $.fn.zTree.getZTreeObj("orgtree");
			var rootNode = zTree.getNodeByParam("parentid", 0);
			copyOrgData(rootNode, orgData);
			zTree.selectNode(rootNode);
			zTree.expandNode(rootNode, true, false, false); 
		}else{
			common.larryCmsError(resp.msg,'温馨提示您');
		}
	});
	//机构树加载及对应事件end
	
	
	//机构页面按钮组点击事件
	$('#orgBtnGroup .layui-btn').on('click',function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
	});
	var active = {
      add:function(){
      	mioaTool.openWin('新增机构','/mioa/backstage/html/systemset/orgset/orgAddOrUpdate.html',500,600,'',function(layero, index){
      		var body = layer.getChildFrame('body', index);  
      		body.find('input[name=name]').val(orgData.id);
      		body.find('input[type=hidden][name=parentid]').val(orgData.id);
      		body.find('#parentName').html(orgData.name);
      	});
      },
      edit:function(){
      	mioaTool.openWin('编辑机构','/mioa/backstage/html/systemset/orgset/orgAddOrUpdate.html',500,600,'',function(layero, index){
      		var body = layer.getChildFrame('body', index);    
      		body.find('input[type=hidden][name=id]').val(orgData.id);
      		body.find('input[name=name]').val(orgData.name);
      		body.find('input[name=abbr]').val(orgData.abbr);
      		body.find('input[type=hidden][name=parentid]').val(orgData.parentid);
      		body.find('#parentName').html(orgData.parentName);
      		body.find('input[name=telphone]').val(orgData.telphone);
      		body.find('input[name=fax]').val(orgData.fax);
      		body.find('input[name=address]').val(orgData.address);
      	});
      },
      del:function(){
         common.larryCmsConfirm('您确认删除该机构？',function(){
      	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/department/delDept',{'id':orgData.id});
         });
      }
	};
	
});