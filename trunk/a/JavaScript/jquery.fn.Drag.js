jQuery.fn.drag = function(){  
    return this.each(function(){  
        var draging = false;  
        var startLeft,startTop;  
        var startX,startY;
          
        $(this).css('cursor','move');
        $(this).mousedown(function(event){
            var offset = $(this).offset();  
            startLeft = offset.left;  
            startTop = offset.top;  
            startX = event.clientX;  
            startY = event.clientY;  
            draging = true;
			
        }).mousemove(function(event){  
            if (draging == false)return;  
            var deltaX = event.clientX - startX;  
            var deltaY = event.clientY - startY;  
            var left = startLeft + deltaX;  
            var top = startTop + deltaY;  
            $(this).css('left',left+'px').css('top',top+'px');  
        }).mouseup(function(event){  
            draging = false;
		});
    });  
} 


//

/* Ñ¹Ëõ°æ*/
/*
eval(function(p,a,c,k,e,r){e=function(c){return c.toString(36)};if('0'.replace(0,e)==0){while(c--)r[e(c)]=k[c];k=[function(e){return r[e]||e}];e=function(){return'[0-9a-j]'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('jQuery.fn.drag=2(){e 3.each(2(){0 4=8;0 9,a;0 b,c;$(3).d(\'cursor\',\'move\');$(3).mousedown(2(1){0 5=$(3).5();9=5.6;a=5.7;b=1.f;c=1.g;4=true}).mousemove(2(1){if(4==8)e;0 h=1.f-b;0 i=1.g-c;0 6=9+h;0 7=a+i;$(3).d(\'6\',6+\'j\').d(\'7\',7+\'j\')}).mouseup(2(1){4=8})})}',[],20,'var|event|function|this|draging|offset|left|top|false|startLeft|startTop|startX|startY|css|return|clientX|clientY|deltaX|deltaY|px'.split('|'),0,{})) 
*/