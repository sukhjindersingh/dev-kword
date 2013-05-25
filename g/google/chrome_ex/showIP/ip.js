//show ip and address by city type
// (C) kick.smiles@gmail.com @jeskick
// Made by stp freeen, 2012 sun 10.
// E-Mail: kick.smiles@gmail.com

$(document).ready(function() {
	var gloabalSetPosition;	
	var useRightList		= [];

	useRightList.push( 'http://www.google.com' );
	useRightList.push( 'http://weibo.com/jeskick' );
		
	gloabalSetPosition = ( $.inArray( window.location.host, useRightList ) >= 0 ) ? 'right' : 'left';


	chrome.extension.sendRequest( {}, function(response) {

		if ( response.domainToIP !== null ) { 

				getIpAddressName(response.domainToIP);

		   }
	
	});//// END sendRequest func...
	
	$("#k_ipshow").live("mouseover", function() {
		if ($(this).hasClass('k_ipshow_r')) {
			$(this).removeClass("k_ipshow_r");
			$(this).addClass("k_ipshow_l");
		}
		else {
			$(this).removeClass("k_ipshow_l");
			$(this).addClass("k_ipshow_r");
		}
	});

	 /// 获取IP地址物理地址名称  www.hujuntao.com/api/ip/ip.php?ip?&format=?
	function getIpAddressName(ips){

		$.get("http://www.hujuntao.com/api/ip/ip.php?ip="+ips+"&format=json",function(result){
			console.log(ips);
			var res=eval("("+result+")");

			var type = res.city||"";
            var city = res.province||"";
			var ip   = res.ip||"";

			console.log(res);

			$("body").append("<div id=\"k_ipshow\" class=\"k_ipshow" + gloabalSetPosition + "\"><span id='_k'>by kick </span>"+city+"<br />"+type+"<br />   "+ip+"</div>");

		});
	};//EDN getIpaddressName func...



});
