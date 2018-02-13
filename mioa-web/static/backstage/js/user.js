layui.use(['layer', 'form', 'table', 'common', 'mioaTool'], function() {
	var $ = layui.$,
		layer = layui.layer,
		form = layui.form,
		table = layui.table,
		common = layui.common,
		mioaTool = layui.mioaTool;

	//用户列表表格渲染
	var tableIns = table.render({
		id:'id',
		elem: '#userTables',
		cols: [
			[{
				checkbox: true,
				width: "5%",
				fixed: true
			}, {
				field: 'realname',
				width: "10%",
				title: '姓名',
				align: 'center',
			}, {
				field: 'name',
				width: "10%",
				title: '账号',
				align: 'center',
			}, {
				field: 'group',
				width: "10%",
				title: '用户组',
				align: 'center',
			}, {
				field: 'mobile',
				width: "10%",
				title: '手机号',
				align: 'center',
			}, {
				field: 'disable',
				width: "10%",
				title: '状态',
				align: 'center',
			    templet: function(d){
			          return d.disable == 0 ? "正常":"禁用"
			    }
			}, {
				field: 'lastloginip',
				width: "15%",
				title: '最后一次登录ip',
				align: 'center',
			}, {
				field: 'lastlogintime',
				width: "10%",
				title: '上一次登录时间',
				align: 'center',
			}, {
				title: '常用操作',
				width: "20%",
				align: 'center',
				toolbar: '#userbar',
				fixed:"right"
			}]

		],
		url: '/mioa/user/findUserList',
		where:{"domain":"fs.com"},
		page: true,
		even: true,

	});

	//监听工具条
	table.on('tool(userTables)', function(obj) {
		var data = obj.data;
		if (obj.event === 'edit') {
			layer.alert('编辑行：<br>' + JSON.stringify(data))
		}else if (obj.event === 'shouquan') {
			layer.alert('授权行：<br>' + JSON.stringify(data))
		}else if (obj.event === 'disable') {
			common.larryCmsConfirm('您确认禁用该用户？',function(){
	        	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/user/disableOrEnableUser',{'id':data.id,'flag':1});
	        });
		}else if (obj.event === 'del') {
			common.larryCmsConfirm('您确认删除该用户？',function(){
	        	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/user/delUser',{'id':data.id});
	        });
		}
	});

	$('#larry_group .layui-btn').on('click',function(){
          var type = $(this).data('type');
          active[type] ? active[type].call(this) : '';
	});

	var active = {
        add:function(){
        	mioaTool.openWin('新增用户','/mioa/backstage/html/systemset/userAddOrUpdate.html',500,600);
        },
        edit:function(){
        	mioaTool.openWin('编辑用户','/mioa/backstage/html/systemset/userAddOrUpdate.html',500,600);
        },
        del:function(){
           common.larryCmsConfirm('您确认删除该用户？',function(){
        	   mioaTool.ajaxSubmit('http://127.0.0.1:8081/mioa/user/delUser',{'id':1});
           });
        }
	};
});