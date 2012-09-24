// ==UserScript==
// @name       kick.WEBTools
// @namespace  
// @version    0.1
// @description  enter something useful
// @include    *://*/*
// @exclude    *://*.google.com/*
// @require   http://code.jquery.com/jquery-1.7.2.min.js
// @copyright  2011+, kick
// @icon data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAB3RJTUUH2wMOCgIoGUYEAQAAAAlwSFlzAAALEgAACxIB0t1+/AAAAARnQU1BAACxjwv8YQUAAAGSUExURfi/JO/v797e3sbGxq2traWlpZSUlJycnNbW1oyEhIRaWow5OZQhIZwYGKUQEKUICK0ICJQxMYxKSoxzc4x7e4RCQpQYGKUAAK0AALUAAL0AAK0QEIxra5QpKa0YGIxSUsYAAKUhIZR7e87Ozr0ICJRSUr29vYxjY6U5OaUpKa0hIb21tZwAALUICO/Ozu/GxqUxMZSEhLUYGO/W1r0YGKVCQpQQEL0pKffe3vfW1pxra5Q5OcZCQvfn585CQr2trZx7e8ZSUs5SUq05Oc5jY9ZjY84AAKWMjM5zc957e60pKdaMjOelpbWcnLWUlLVCQsYYGMYICNbOzpQICMYhIbV7e5xaWt6cnPfv79bGxt6lpe+9vc5KSs6lpb0xMc6EhM69vbUxMbUhIb1aWs61tcZaWuecnMYxMb1KSsZjY96UlNa1td7W1r17e9a9vZwQEN6trb1jY8YQENZra+fOzr1zc85aWufe3t6MjMY5OdZaWt61tdZ7e+/n5+e9vc6MjMZra+/e3ue1tdalpd7GxrUpKalL4aAAAAABdFJOUwBA5thmAAACxklEQVR42uXX/1/SQBgH8NuAoEQ2ijgbBivJLznBAiUUKiyJSgOVAk0tKZKw75mRRt/7v4MBY8ezjW39Vs8v8rqHz/u1jbvbidC/XL8KmcpOqVT6nSjXjooGw8WfFd+QWGfE4oLbtbr++PdMOy0BDYLjEj/0xevfWIyVAI7b/aIj/9WHsRrA8Yf9bqSexVgD4Lic9kWE/LgPwPGfNfJHDO4P8Iuq+S2M9QD8oUp+nxEAcFCtfgIA/14x/9ElAKDQbNQAwN9VAiYEABy0OgsAWAnB/AcBAtVWawkAfJ4CD0BQADZavYcQgI9h3CCQjpD5PcEgwG+SwLRhIL0vz78SjAPEU3hrHODfyX4I6rUJIP0G3oExoNwFXpoB+HwXmDEFpF9IwKA5YK+Tp9fMAdUOsC6YA553gKcmgdTfAhV1oMQqADndQDmJ0AZLAsFnCIV3VYDHJLAjDkZKciAaFz/lCeBJB1glgXBrNLndBWLJ9uZGAI+keTBLANL8SnWAzWRniAC2pG+6lQF0hfjTqCIBrEvjDwiggFSLuIUoLY0vEwAbUcsnc/LlnO02HGvEz+hXEeJ5Yj+4L2vNkxOJDSnlQzliIq2synr3embiUBjmw0FyU83KX04Ob+9aAK/Ppd5deZloz4HFlCHzt3sX0x2a6LcvQb4ab8r7i+DVdqvnCq/D5ZzqdhfAcr5B9wD0PNwPEu0ZnLwK9oPgNfCQJ2fhhhITJ3E8BjeUOXA+QNQlBh5xLjemVCgKjzgzNIJFjWF4yJoKhafgIWt6VHGmjgR0HvMuTipPdWQJ6AImbBRSE8aY/sC4er5xFx5vHyB4YRRpFWUf0AL4c+dHkHZRFo9TDeB9Aa3Llwjr8FlFwB+wO/rHm0VbPae9mPini/O5h/XGxatw2I6fGHAOuhiGZVxO98lTdgutP94yaIvVdqxZdpvFYTT9X9UfqQQlTXlm8wkAAAAASUVORK5CYII=
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
      //insertKDOM();      
      setBackground();
      setBaidu();

    }

    function setBackground() {

      window.document.body.style.background = "url(data:image/png;base64,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)top fixed  repeat-y ";
      console.log("setBackground by kick...");

    }

    function setBaidu() {

      if (((window.location.href).indexOf("baidu.com")) == -1) return;

      console.log("setBaidu...Logo and  buttom padding....");
      $("a[class=s_logo],a[class=logo],a[id=imgLogo],.logo,#lg,.lg,#ecomAdDiv").css("visibility", "hidden");
      $("#m").css("margin-top", "150px");
      $("#s_wrap").css("margin-top", "195px").css("visibility", "hidden");
      $("#kw,#su,.s_ipt_wr,.s_btn_wr,input[class=s_btn],input[class=btn]").css({
        "background": "#FFF",
        "color": "red",
        "height": "+=20px",
        "font-size": "+=20px",
        "overflow": "hidden"
      });
      $("#su,input[class=s_btn],input[class=btn]").val("谷歌");
      $("#r,#search,.page-nav,#search_bot,#out").css("margin-left", "600px");

    }

    function insertKDOM() {

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
      _css.innerHTML = "#fk_div{position:fixed;top:120px;right:20px;z-index:999;background:#FFC;}" + "#fk_div a{line-height:30px;}" + "#k_drag{position:absolute;width:400px;height:300px;top:20px;right:10px;border:1px solid red;z-index:9999;}"; //拖动 CSS 样式 
      document.getElementsByTagName('head')[0].appendChild(_css);
      $("#k_drag").drag();
    }

    ////////////////////////////////////////////////////////    _dbclick              //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //	function _dbclick(event) { document.body.scrollTop >= 400 ? window.location.href = g + "#top": window.location.href = g + "#_j_buttom"; }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    window.addEventListener('load', init, false);
    //	window.addEventListener("dblclick", _dbclick, false);
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
  } // end Else window.Top
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
