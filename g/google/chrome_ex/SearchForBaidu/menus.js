

var translate   = chrome.contextMenus.create({"title": "Search For Baidu  @Kick ", "contexts":["selection"],"onclick": search});


//translate google
function search(info,tab){

var font=info.selectionText;


var w=window.open();


setTimeout(function(){

	w.location="http://www.baidu.com/s?wd="+font;

	//if (escape(font).indexOf( "%u" )<0)
	//{
	//	w.location="http://translate.google.cn/?hl=en#en/zh-CN/"+font;

	//} else {

	//	w.location="http://translate.google.cn/?hl=en#zh-CN/en/"+font;

	//}

},500);


}


chrome.contextMenus.create({"title": "Oops", "parentId":999}, function() {
  if (chrome.extension.lastError) {
    console.log("Got expected error: " + chrome.extension.lastError.message);
  }
});
