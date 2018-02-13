layui.config({
	base: '/mioa/common/lib/'
});
layui.use(['layer','jquery','form', 'table', 'common', 'mioaTool'], function() {
	var $ = layui.$,
		layer =  layui.layer ,
		form = layui.form,
		table = layui.table,
		common = layui.common,
		mioaTool = layui.mioaTool;

	//用户列表表格渲染
	var tableIns = table.render({
		id:'rolesTable',
		elem: '#roleTables',
		cols: [
			[{
				checkbox: true,
				width: "5%",
				fixed: true
			}, {
				field: 'name',
				width: "10%",
				title: '角色名称',
				align: 'center',
			}, {
				field: 'descr',
				width: "15%",
				title: '角色描述',
				align: 'center',
			}, {
				title: '常用操作',
				width: "50%",
				align: 'center',
				toolbar: '#positionbar',
				fixed:"right"
			}]

		],
		url: '/mioa/role/findRole',
		page: true,
		even: true,

	});

	//操作栏监听工具条
	table.on('tool(roleTables)', function(obj) {
		var data = obj.data;
		if (obj.event === 'edit') {
    		mioaTool.openSimpleWin('编辑角色',$("#roleAddOrUpdateContain").html(), 500, 300, '', function(layero, index){
    			//绑定弹出取消按钮点击事件
    			$("#closeWinBtn").click(function(){layer.close(index);});
    			//弹窗赋值
    			copyDataToRoleAddOrUpdateContain(layero,data);
    		});
		}else if (obj.event === 'assign') {
			mioaTool.openWin('权限分配','/mioa/backstage/html/common/permission.html', 800, 650);
		}else if (obj.event === 'del') {
			common.larryCmsConfirm('您确认删除该角色？',function(){
				var ids =[data.id];
	        	mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/role/deleteRole',{'ids':ids},function(){
	        		tableIns.reload();
	        	});
	        });
		}
	});

	$('#role_btn_group .layui-btn').on('click',function(){
         var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
	});

	var active = {
        add:function(){
        	mioaTool.openSimpleWin('新增角色', $("#roleAddOrUpdateContain").html(), 500, 300, '',  function(layero, index){
	   	    	$("#closeWinBtn").click(function(){
	   	    		layer.close(index);
	   	    	});
	   	    });
        },
        del:function(){
        	var checkStatus = table.checkStatus('rolesTable');
	       	var data = checkStatus.data;
	       	if(data.length == 0){
	       		 common.larryCmsalert('请选择需删除的记录');
	       	} else {
	       		common.larryCmsConfirm('您确认删除选中职位？',function(){
	       			var ids =[];
	       			for(var i in data){
	       				ids.push(data[i].id)
	       			}
	         	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/role/deleteRole',{'ids':ids},function(){
	         		  tableIns.reload();
	         	   });
	            });
	       	}
        }
	};
	
	function copyDataToRoleAddOrUpdateContain(layero,obj){
		layero.find("input[type=hidden][name=id]").val(obj.id);
		layero.find("input[type=text][name='name']").val(obj.name);
		layero.find("input[type=text][name='descr']").val(obj.descr);
	}
	
	
	//监听提交
  form.on('submit(editRoleForm)', function(data){
	mioaTool.ajaxSubmit("http://127.0.0.1:8081/mioa/role/addOrUpdateRole", data.field, function(){
		tableIns.reload();
		$("#closeWinBtn").click();
	});
    return false;
  });
  
});