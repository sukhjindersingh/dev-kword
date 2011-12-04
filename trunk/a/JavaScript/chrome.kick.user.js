// ==UserScript==
// @name       kick
// @namespace   
// @version    0.1
// @description  enter something useful
// @include    http://*/*
// @require    http://code.jquery.com/jquery-1.6.min.js
// @copyright  2011+, kick
// ==/UserScript==

(function(window, document) {
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
		var _a = document.createElement('a');
		_a.setAttribute('id', '_j_buttom');
		_a.setAttribute('href', '#');
		_a.innerHTML = "@kick";
		_a.style.visibility = 'hidden';
		document.body.appendChild(_a);

		var _d = document.createElement('div');
		_d.setAttribute('id', 'fk_div');
		_d.innerHTML = "<a target=\"_block\" href=\"tencent://message?uin=136318508\"><img border=\"0\" src=\"http://wpa.qq.com/pa?p=2:136318508:46\"></a> Danger <br /><br /><a target=\"_block\" href=\"tencent://message?uin=80805588\"><img border=\"0\" src=\"http://wpa.qq.com/pa?p=2:80805588:46\"></a>林家小少";
		//_D(_d);
		var _drag = document.createElement('div');
		_drag.setAttribute('id', 'k_drag');
		_drag.innerHTML = "   Drag  @kick  ";
		_D(_drag);

		var _css = document.createElement("style");
		_css.setAttribute('id', '_css');
		_css.setAttribute('type', 'text/css');
		_css.innerHTML = "#fk_div{position:fixed;top:120px;right:20px;z-index:999;background:#FFC;}" + 
                                 "#fk_div a{line-height:30px;}" +
                                 "#k_drag{position:absolute;width:400px;height:300px;top:20px;right:10px;border:1px solid red;z-index:9999;}"; //拖动 CSS 样式 
		document.getElementsByTagName('head')[0].appendChild(_css);

		$("#k_drag").drag();

	}

	function _dbclick(event) { document.body.scrollTop >= 400 ? window.location.href = g + "#top": window.location.href = g + "#_j_buttom"; }
    
	window.addEventListener('load', init, false);
	window.addEventListener("dblclick", _dbclick, false);
})(window, document);

//	var GM_JQ = document.createElement('script');  
//	GM_JQ.src = 'http://jquery.com/src/jquery-latest.js';  
//	GM_JQ.type = 'text/javascript';  
//	document.getElementsByTagName('head')[0].appendChild(GM_JQ);
//	function wait(){
//		if(typeof unsafeWindow.jQuery == 'undefined'){
//			window.setTimeout(wait(),100);
//		}else{
//			Gstart();
//			}
//	}