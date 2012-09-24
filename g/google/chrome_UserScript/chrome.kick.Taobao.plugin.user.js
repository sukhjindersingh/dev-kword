// ==UserScript==
// @name       chrome.kick.Taobao.plugin
// @namespace  
// @version    0.1
// @description  enter something useful
// @include    http*://design.taobao.com/*
// @require    http://code.jquery.com/jquery-1.6.min.js
// @copyright  2011+, kick
// @link       https://code.google.com/p/dev-kword/
// ==/UserScript==

(function(window,document){	 
	var _D = function(_obj) {document.getElementsByTagName("body").appendChild(_obj);}
	var _R = function(r){return Math.random();}
	 
	function init(){
	if(window != window.top) return;
	
        try{
            $(".ui-dialog-dd").css({'width':'95%','left':'3%','height':'90%','top':'5%'});
            $(".ui-dialog-bd,.setting ").css({'width':'99%','height':'98%'});
        }catch(e){
        }
        

	}
	
window.addEventListener("load",init,false);	

})(window,document)
