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

	
	
	//监听提交
  form.on('submit(selectMenuPossitionForm)', function(data){
	mioaTool.ajaxSubmit("http://127.0.0.1:8081/mioa/role/addOrUpdateRole", data.field, function(){
		tableIns.reload();
		$("#closeWinBtn").click();
	});
    return false;
  });
  
});