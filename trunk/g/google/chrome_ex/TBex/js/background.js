//auto backgroun function  后台自动执行代码

//auto backgroun function for notifications action  后台自动执行代码|桌面通知

function notifications_show(){
  var time = /(..)(:..)/.exec(new Date());     
  var hour = time[1] % 12 || 12;               
  var period = time[1] < 12 ? 'a.m.' : 'p.m.'; 
  var notification = window.webkitNotifications.createNotification(
    'icons/icon_048.png',                      
    hour + time[2] + ' ' + period,
    'Time to make the toast.'
  );
  notification.show();
}

// 初始化 选项属性 不存在 重新设置初始默认值
if (!localStorage.isInitialized) {
  localStorage.isActivated = true;   
  localStorage.frequency = 1;        
  localStorage.isInitialized = true; 
}

// 判断通知事件属性是否存在
if (window.webkitNotifications) {
	// 获取设置值 转换成json格式 
  if (JSON.parse(localStorage.isActivated)) { show(); }

  var interval = 0; 

  setInterval(function() {
    interval++;
    if (
      JSON.parse(localStorage.isActivated) &&
        localStorage.frequency <= interval
    ) {
      show();
      interval = 0;
    }
  }, 60000);
}