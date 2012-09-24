// A generic onclick callback function.

//console log func....


var pageed     = chrome.contextMenus.create({"title": "快递查询选项", "contexts":["page"],"onclick": genericOnClick});
var selected   = chrome.contextMenus.create({"title": "快递查新", "contexts":["selection"],"onclick": KQueryonClick});
var linked     = chrome.contextMenus.create({"title": "转到连接", "contexts":["link"],"onclick": genericOnClick});
var imageed    = chrome.contextMenus.create({"title": "查看图片", "contexts":["image"],"onclick": genericOnClick});
var videoed    = chrome.contextMenus.create({"title": "查看视频", "contexts":["video"],"onclick": genericOnClick});
var audioed    = chrome.contextMenus.create({"title": "查看音频", "contexts":["audio"],"onclick": genericOnClick});


function genericOnClick(info, tab) {
  console.log("item " + info.menuItemId + " was clicked");
  console.log("info: " + JSON.stringify(info));
  console.log("tab: " + JSON.stringify(tab));
}
// kuaidi query func
function KQueryonClick(info,tab){
		
		var url="query.html?v="+JSON.stringify(info);
		
		window.open("http://api.kuaidi100.com/api?id=gmbd9ksf96412ac3&com=yuantong&nu="+info.selectionText+"&valicode=&show=2&muti=&order=desc", "new", "width=550px, height=600px,top=200px,left=300px,alwaysRaised=yes,z-look=yes,screenX=500,toolbar=1,scrollbars=1,location=1,statusbar=0,menubar=1,resizable=1");

    
		
	
  var  div=document.createElement("div");
       div.style.height="80px";
	   div.style.width="230px";
	   div.style.backgroundColor="red";
	   div.innerHTML=JSON.stringify(info);
	
  console.log("item " + info.menuItemId + " was clicked");
  console.log("info: " + JSON.stringify(info));
  console.log("tab: " + JSON.stringify(tab));
}