
$(document).ready(function() {
	
	$("#number").focus();
	
	$("#query").click(query);
	
	
	$("#number").keydown(function(event){ 
	
		console.log(event.keyCode); 
		
		if(event.keyCode==13){
			$("#query").focus();
			query();
		}
		
	}); 
	
});

function  query(){
	
	$("#result_content").html("<br />&nbsp;<br /><font color=red>正在查询.......</font>");
	
	var opt=$("#opt").val();;
	var number=$("#number").val();
	
	$.get("http://api.kuaidi100.com/api?id=gmbd9ksf96412ac3&com="+opt+"&nu="+number+"&valicode=&show=2&muti=&order=desc",function(result){

		
		$("#result_content").html("<hr id='hr' />"
		
		+
			result
		);
		
		if(result.indexOf("errordiv")>-1){
			setTimeout(function(){$("#result_content").html(" ");$("#number").focus();},1800)
		}
		
	})
	
}