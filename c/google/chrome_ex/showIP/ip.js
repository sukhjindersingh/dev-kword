// (C) TEQneers GmbH & Co. KG
// Made by Stephan Ferraro, 2012 Stuttgart, Germany
// E-Mail: support {at} teqneers.de

$(document).ready(function() {
	var gloabalSetPosition;	
	var useRightList		= [];

	useRightList.push( 'plus.google.com' );
	useRightList.push( 'www.facebook.com' );
		
	gloabalSetPosition = ( $.inArray( window.location.host, useRightList ) >= 0 ) ? 'right' : 'left';


	chrome.extension.sendRequest( {}, function(response) {

		if ( response.domainToIP !== null ) { 

				getIpAddressName(response.domainToIP);

		   }
	
	});//// END sendRequest func...
	
	$("#tqShowIP").live("mouseover", function() {
		if ($(this).hasClass('tqShowIP_right')) {
			$(this).removeClass("tqShowIP_right");
			$(this).addClass("tqShowIP_left");
		}
		else {
			$(this).removeClass("tqShowIP_left");
			$(this).addClass("tqShowIP_right");
		}
	});


	 /// 获取IP地址物理地址名称
	function getIpAddressName(ips){

		$.get("http://www.hujuntao.com/api/ip/ip.php?ip="+ips+"&format=json",function(result){
			console.log(ips);
			var res=eval("("+result+")");

			var type = res.city||"";
            var city = res.province||"";
			var ip   = res.ip||"";

			console.log(res);

			$("body").append("<div id=\"tqShowIP\" class=\"tqShowIP_" + gloabalSetPosition + "\">"+city+"<br />"+type+"<br />   "+ip+"</div>");

		});
	};//EDN getIpaddressName func...



});
