// ==UserScript==
// @name      kick.taobao.Thred.tools.user.js
// @namespace  
// @version    0.1
// @description  enter something useful
// @include    http://upload.taobao.com/auction/publish/publish.htm
// @require   http://code.jquery.com/jquery-1.7.2.min.js
// @copyright  2011+, kick kick.smiles@gmail.com
// ==/UserScript==
/* ****
   ****
   ****  if(window != window.top) return;       //The return not main ifreame..
   ****
   **** */

(function(window, document) {
  if (window != window.top) {
    return null;
  } else { //The return not main ifreame..
    var _D = function(_obj) {
      document.body.appendChild(_obj);
    }
    var LOG = function(e) {
      console.error(new Date() + " : " + e);
    }
    var g = window.location.href;
    eval(function(p, a, c, k, e, r) {
      e = function(c) {
        return c.toString(36)
      };
      if ('0'.replace(0, e) == 0) {
        while (c--) r[e(c)] = k[c];
        k = [function(e) {
          return r[e] || e
        }];
        e = function() {
          return '[0-9a-j]'
        };
        c = 1
      };
      while (c--) if (k[c]) p = p.replace(new RegExp('\\b' + e(c) + '\\b', 'g'), k[c]);
      return p
    } ('jQuery.fn.drag=2(){e 3.each(2(){0 4=8;0 9,a;0 b,c;$(3).d(\'cursor\',\'move\');$(3).mousedown(2(1){0 5=$(3).5();9=5.6;a=5.7;b=1.f;c=1.g;4=true}).mousemove(2(1){if(4==8)e;0 h=1.f-b;0 i=1.g-c;0 6=9+h;0 7=a+i;$(3).d(\'6\',6+\'j\').d(\'7\',7+\'j\')}).mouseup(2(1){4=8})})}', [], 20, 'var|event|function|this|draging|offset|left|top|false|startLeft|startTop|startX|startY|css|return|clientX|clientY|deltaX|deltaY|px'.split('|'), 0, {}))
    function init() {
     insertKDOM();      
     
    } 
    function insertKDOM() {
  var _d = document.createElement('div');
      _d.setAttribute('id', 'fk_div_num');
      _d.innerHTML = "<input  id='k-num'/ value='888' style='width:50px;'><button id='k-seta'>设置数量</button><br/>" +
          "<input  id='k-pnum'/ value='888' style='width:50px;color:rgb(255,0,0)'><button id='k-pseta' style='color:rgb(255,0,0)'>设置价格</button><br/>";
      
      _D(_d);     
      var _css = document.createElement("style");
      _css.setAttribute('id', '_css');
      _css.setAttribute('type', 'text/css');
        _css.innerHTML = "#fk_div_num{position:fixed;width:135px;padding:10px 5px; top:420px;right:340px;z-index:9999;background:#FFC;padding:10px 5px; }" +	 
					   "#fk_div_num button{ margin:5px 5px; font-size:14px; padding:4px 4px;cursor:pointer; }"+
            "#fk_div_num input{text-align:center;}"+
	                   "#k_drag{position:absolute;width:400px;height:300px;top:20px;right:10px;border:1px solid red;z-index:9999;}"; //拖动 CSS 样式						   
					    
      document.getElementsByTagName('head')[0].appendChild(_css);
	
	  
	  
	  
	  $("#k-seta").dblclick(function(){$(".sku-mapwrapper .quantity .J_MapQuantity").val($('#k-num').val()||888);});
      $("#k-pseta").dblclick(function(){$(".sku-mapwrapper .quantity .J_MapPrice").val($('#k-pnum').val()||888);});
        
        
      //$("#k_drag").drag();
        
        
        
        
    }
   
    window.addEventListener('load', init, false);
    
  } // end Else window.Top
})(window, document);
