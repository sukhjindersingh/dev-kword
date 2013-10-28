// ==UserScript==
// @name       chrome.kick.Taobao.plugin
// @namespace  
// @version    0.1
// @description  enter something useful
// @include    http://trade.taobao.com/trade/itemlist/list_sold_items.htm*
// @include    http://trade.taobao.com/*
// @include    http://item.taobao.com/*19307394785* 
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
       //     $(".ui-dialog-dd").css({'width':'95%','left':'3%','height':'90%','top':'5%'});
       //     $(".ui-dialog-bd,.setting ").css({'width':'99%','height':'98%'});
            
       //     $("#order435425975525939,#order434096712765020,#order437387020201391").css("display","none");
            
       //     $("a.tb-tab-anchor .J_TDealCount").val(0);
            
         
            
            
            //隐藏 交易关闭的订单
            $("#J_ListTable tr td a strong").each(function(i){
				
            
                console.log("KK:"+$(this).text());
                if($(this).text()=="交易关闭"){
                   console.log( $(this).parent().parent().parent().parent().css("display","none"));
                }
                
                
            })
            
            
        }catch(e){
        }
        

	}
	
    function aa(){
        
        setTimeout(function(){
            $("table.tb-list").find("a").text();
            $("table.tb-list tr").eq(2).css("display","none");
            //$("table.tb-list tr").eq(2).css("display","none");
        },600);
    }
    
window.addEventListener("load",init,false);	

})(window,document)
