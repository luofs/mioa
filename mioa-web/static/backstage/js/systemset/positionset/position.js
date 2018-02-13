layui.config({
	base: '/mioa/common/lib/'
});
layui.use(['layer','jquery','form', 'table', 'common', 'mioaTool'], function() {
	var $ = layui.$,
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		form = layui.form,
		table = layui.table,
		common = layui.common,
		mioaTool = layui.mioaTool;

	//用户列表表格渲染
	var tableIns = table.render({
		id:'positionsTable',
		elem: '#positionTables',
		cols: [
			[{
				checkbox: true,
				width: "5%",
				fixed: true
			}, {
				field: 'name',
				width: "10%",
				title: '岗位名称',
				align: 'center',
			}, {
				field: 'positdesc',
				width: "15%",
				title: '岗位描述',
				align: 'center',
			}, {
				field: 'depts',
				width: "20%",
				title: '所属部门',
				align: 'center',
			}, {
				title: '常用操作',
				width: "50%",
				align: 'center',
				toolbar: '#positionbar',
				fixed:"right"
			}]

		],
		url: '/mioa/position/findPosition',
		page: true,
		even: true,

	});

	//监听工具条
	table.on('tool(positionTables)', function(obj) {
		var data = obj.data;
		if (obj.event === 'edit') {
			mioaTool.openWin('编辑用户','/mioa/backstage/html/systemset/positionset/positionAddOrUpdate.html',500,300,'',function(layero, index){
          		var body = layer.getChildFrame('body', index);    
          		body.find('input[type=hidden][name=id]').val(data.id);
          		body.find('input[name=name]').val(data.name);
          		body.find('input[name=positdesc]').val(data.positdesc);
          	});
		}else if (obj.event === 'assign') {
			mioaTool.openWin('职位分配','/mioa/backstage/html/systemset/positionset/positionAssign.html',500,300,'',function(layero, index){
          		var body = layer.getChildFrame('body', index);    
          		body.find('input[type=hidden][name=positid]').val(data.id);
          		body.find('#positName').html(data.name);
          	});
		}else if (obj.event === 'disable') {
			common.larryCmsConfirm('您确认禁用该用户？',function(){
	        	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/user/disableOrEnableUser',{'id':data.id,'flag':1});
	        });
		}else if (obj.event === 'del') {
			common.larryCmsConfirm('您确认删除该职位？',function(){
				var ids =[data.id];
	        	mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/position/deletePosition',{'ids':ids});
	        });
		}
	});

	$('#position_btn_group .layui-btn').on('click',function(){
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
	});

	var active = {
        add:function(){
        	mioaTool.openWin('新增职位','/mioa/backstage/html/systemset/positionset/positionAddOrUpdate.html',500,300);
        },
        edit:function(){
        	 var checkStatus = table.checkStatus('positionsTable');
        	 var data = checkStatus.data;
        	 if(data.length == 0){
        		 common.larryCmsalert('请选择需编辑记录');
        	} else if(data.length > 1){
        		 common.larryCmsalert('不可重复编辑多条记录，请选择一条需编辑的记录');
        	} else {
        		mioaTool.openWin('编辑用户','/mioa/backstage/html/systemset/positionset/positionAddOrUpdate.html',500,300,'',function(layero, index){
              		var body = layer.getChildFrame('body', index);
              		body.find('input[type=hidden][name=id]').val(data[0].id);
              		body.find('input[name=name]').val(data[0].name);
              		body.find('input[name=positdesc]').val(data[0].positdesc);
              	});
        	}
        },
        del:function(){
        	var checkStatus = table.checkStatus('positionsTable');
	       	var data = checkStatus.data;
	       	if(data.length == 0){
	       		 common.larryCmsalert('请选择需删除的记录');
	       	} else {
	       		common.larryCmsConfirm('您确认删除选中职位？',function(){
	       			var ids =[];
	       			for(var i in data){
	       				ids.push(data[i].id)
	       			}
	         	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/position/deletePosition',{'ids':ids});
	            });
	       	}
        }
	};
});