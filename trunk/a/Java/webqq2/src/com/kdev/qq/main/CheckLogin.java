/**
 * 
 */
package com.kdev.qq.main;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.kdev.qq.bean.QQuser;
import com.kdev.qq.task.MessageThread;
import com.kdev.qq.utils.Conf;
import com.kdev.qq.utils.HttpUtils;
import com.kdev.qq.utils.Utils;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 */
public class CheckLogin {

	public static Logger log = Logger.getLogger(CheckLogin.class);

	/**
	 * 登陆
	 * 
	 * @param user
	 * @return
	 */
	@SuppressWarnings( { "deprecation", "unused" })
	public static boolean checkLogin(QQuser user) {

		String loginUrl = Conf.getLOGIN_URL()+"/check?appid=1003903&uin=" + user.getUin();

		String res = HttpUtils.getURL(loginUrl, user);

		Pattern p = Pattern.compile("\\,\\'([!\\w]+)\\'");
		Matcher m = p.matcher(res);
		String checkType = "";
		if (m.find()) {
			checkType = m.group(1);
		}
		String check = "";
		if (!checkType.startsWith("!")) {
			// 需要输入验证码时的处理
		} else {
			check = checkType;
		}

		// 开始登陆
		String loginUrl2 = Conf.getLOGIN_URL()+"/login?u=" + user.getUin() + "&" + "p=" + Utils.Qweb2MD5(user.getPass(), check) + "&verifycode=" + check + "&remember_uin=1&aid=1003903"
				+ "&u1=http%3A%2F%2Fweb2.qq.com%2Floginproxy.html%3Fstrong%3Dtrue" + "&h=1&ptredirect=0&ptlang=2052&from_ui=1&pttype=1&dumy=&fp=loginerroralert";
		res = HttpUtils.getURL(loginUrl2, user);

		// ptuiCB('0','0','http://web2.qq.com/loginproxy.html?strong=true','0','登录成功！');
		// 第一个参数为 消息状态码 最后一个参数为消息内容
		// ptuiCB('4','0','','0','您输入的验证码有误，请重试。');

		p = Pattern.compile("登录成功！");// 提取最后一个字符串，看看是不是 登录成功！
		m = p.matcher(res);
		if (m.find()) {
			log.info("登陆成功");
		} else {
			// 登陆失败
			log.info(checkType);
			return false;
		}
		// 从cookie中提取ptwebqq,skey
		p = Pattern.compile("ptwebqq=(\\w+);");
		m = p.matcher(user.get_cookie());
		if (m.find()) {
			user.setPtwebqq(m.group(1));
		}
		p = Pattern.compile("skey=(@\\w+);");
		m = p.matcher(user.get_cookie());
		if (m.find()) {
			user.setSkey(m.group(1));
		}
		log.info("ptwebqq=" + user.getPtwebqq() + ",skey=" + user.getSkey());

		// 第二次登陆 第一次获取验证码 腾讯判断异常处理
		String channelLoginUrl = Conf.getLOGIN_2_URL();
		String content = "{\"status\":\"\",\"ptwebqq\":\"" + user.getPtwebqq() + "\",\"passwd_sig\":\"\",\"clientid\":\"" + user.getClientid() + "\"}";
		content = URLEncoder.encode(content);// urlencode
		content = "r=" + content;// post 数据

		res = HttpUtils.postURL(channelLoginUrl, content, user);// post

		// 重要的2个数据 psessionid ,vwebqq， 发送数据到服务器时必须带有这两个参数

		p = Pattern.compile("\"vfwebqq\":\"(\\w+)\"");
		m = p.matcher(res);
		if (m.find()) {
			user.setVfwebqq(m.group(1));
		}
		p = Pattern.compile("\"psessionid\":\"(\\w+)\"");
		m = p.matcher(res);
		if (m.find()) {
			user.setPsessionid(m.group(1));
		}
		log.info("vwebqq=" + user.getVfwebqq() + "," + "psessionid=" + user.getPsessionid());
		// 到此，登陆就算完成了，后面可以调用发送qq信息等接口了

		Conf.setIsrun(true); // 设置接收消息线程启动

		//GetMessagePoll messagePoll = new GetMessagePoll(user);
		//messagePoll.run();
		
		MessageThread messageThread=new MessageThread(user);
		
		messageThread.run();
		

		return true;
	}

}
