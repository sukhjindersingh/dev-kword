// ==UserScript==
// @name       kick.WEBTools
// @namespace  
// @version    0.1
// @description  enter something useful
// @include    http://*/*
// @require    http://code.jquery.com/jquery-1.6.min.js
// @copyright  2011+, kick
// @icon data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAB3RJTUUH2wMOCgIoGUYEAQAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAAGSUExURfi/JO/v797e3sbGxq2traWlpZSUlJycnNbW1oyEhIRaWow5OZQhIZwYGKUQEKUICK0ICJQxMYxKSoxzc4x7e4RCQpQYGKUAAK0AALUAAL0AAK0QEIxra5QpKa0YGIxSUsYAAKUhIZR7e87Ozr0ICJRSUr29vYxjY6U5OaUpKa0hIb21tZwAALUICO/Ozu/GxqUxMZSEhLUYGO/W1r0YGKVCQpQQEL0pKffe3vfW1pxra5Q5OcZCQvfn585CQr2trZx7e8ZSUs5SUq05Oc5jY9ZjY84AAKWMjM5zc957e60pKdaMjOelpbWcnLWUlLVCQsYYGMYICNbOzpQICMYhIbV7e5xaWt6cnPfv79bGxt6lpe+9vc5KSs6lpb0xMc6EhM69vbUxMbUhIb1aWs61tcZaWuecnMYxMb1KSsZjY96UlNa1td7W1r17e9a9vZwQEN6trb1jY8YQENZra+fOzr1zc85aWufe3t6MjMY5OdZaWt61tdZ7e+/n5+e9vc6MjMZra+/e3ue1tdalpd7GxrUpKalL4aAAAAABdFJOUwBA5thmAAACxklEQVR42uXX/1/SQBgH8NuAoEQ2ijgbBivJLznBAiUUKiyJSgOVAk0tKZKw75mRRt/7v4MBY8ezjW39Vs8v8rqHz/u1jbvbidC/XL8KmcpOqVT6nSjXjooGw8WfFd+QWGfE4oLbtbr++PdMOy0BDYLjEj/0xevfWIyVAI7b/aIj/9WHsRrA8Yf9bqSexVgD4Lic9kWE/LgPwPGfNfJHDO4P8Iuq+S2M9QD8oUp+nxEAcFCtfgIA/14x/9ElAKDQbNQAwN9VAiYEABy0OgsAWAnB/AcBAtVWawkAfJ4CD0BQADZavYcQgI9h3CCQjpD5PcEgwG+SwLRhIL0vz78SjAPEU3hrHODfyX4I6rUJIP0G3oExoNwFXpoB+HwXmDEFpF9IwKA5YK+Tp9fMAdUOsC6YA553gKcmgdTfAhV1oMQqADndQDmJ0AZLAsFnCIV3VYDHJLAjDkZKciAaFz/lCeBJB1glgXBrNLndBWLJ9uZGAI+keTBLANL8SnWAzWRniAC2pG+6lQF0hfjTqCIBrEvjDwiggFSLuIUoLY0vEwAbUcsnc/LlnO02HGvEz+hXEeJ5Yj+4L2vNkxOJDSnlQzliIq2synr3embiUBjmw0FyU83KX04Ob+9aAK/Ppd5deZloz4HFlCHzt3sX0x2a6LcvQb4ab8r7i+DVdqvnCq/D5ZzqdhfAcr5B9wD0PNwPEu0ZnLwK9oPgNfCQJ2fhhhITJ3E8BjeUOXA+QNQlBh5xLjemVCgKjzgzNIJFjWF4yJoKhafgIWt6VHGmjgR0HvMuTipPdWQJ6AImbBRSE8aY/sC4er5xFx5vHyB4YRRpFWUf0AL4c+dHkHZRFo9TDeB9Aa3Llwjr8FlFwB+wO/rHm0VbPae9mPini/O5h/XGxatw2I6fGHAOuhiGZVxO98lTdgutP94yaIvVdqxZdpvFYTT9X9UfqQQlTXlm8wkAAAAASUVORK5CYII=
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
// add Jquery jar demo1 
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

// add Jquery jar demo2 
// ///////////////////////////////////////////////////  Add jQuery
//var GM_JQ = document.createElement('script');
//GM_JQ.src = 'http://cache.soso.com/post/js/jquery.js';
//GM_JQ.type = 'text/javascript';
//document.getElementsByTagName('head')[0].appendChild(GM_JQ);
// Check if jQuery's loaded
//function GM_wait() {
//        if(typeof unsafeWindow.jQuery == 'undefined') { window.setTimeout(GM_wait,100); }
//        else { $ = unsafeWindow.jQuery; letsJQuery(); }
//}
//GM_wait();
// All your GM code must be inside this function
//   /////////////////////////////////////////////////////////////Add Jquery End 

