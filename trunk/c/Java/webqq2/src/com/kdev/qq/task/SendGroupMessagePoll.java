/**
 * 
 */
package com.kdev.qq.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONObject;

import com.kdev.qq.bean.QQuser;
import com.kdev.qq.utils.BaikeSearch;
import com.kdev.qq.utils.Base64;
import com.kdev.qq.utils.Conf;
import com.kdev.qq.utils.ExpressUtils;
import com.kdev.qq.utils.HttpUtils;
import com.kdev.qq.utils.Utils;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 8, 2011
 */
public class SendGroupMessagePoll extends Thread {

	private static final Log log = LogFactory.getLog(SendGroupMessagePoll.class);

	QQuser user = null;
	String content = "";
	String qun_uin = "";

	public SendGroupMessagePoll(QQuser user, String content, String qun_uin) {
		this.user = user;
		this.content = content;
		this.qun_uin = qun_uin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		log.info("Thread Numers  :  " + Utils.threadNum++);

		@SuppressWarnings("unused")
		boolean isSend = false;

		String sendTextMessage = "";
		String qunSendUrl = Conf.getSEND_GROUP_URL();
		Map<String, String> param = new HashMap<String, String>();
		// {"group_uin":382325257,"content":"[\"\",[\"font\",{\"name\":\"宋体\",\"size\":\"10\",\"style\":[0,0,0],\"color\":\"000000\"}]]","msg_id":4850001,"clientid":"12485420","psessionid":"8368046764001e636f6e6e7365727665725f77656271714031302e3133332e34312e32303200002da000000053026e0400571bac5b6d0000000a406a3932584c41336c556d0000002808f6de7c0a9aba4344db27ca580534627c5b9aa103d32d2fdda0eeea8ea91b91d87a7f075d4b3751"}
		try {

			// 处理命令消息
			sendTextMessage = content;
			System.out.println("USER GEt MEssage ：" + sendTextMessage);
			;
			if (content.indexOf("@帮助") >= 0) {
				sendTextMessage = Conf.HELP_MSG;
			} else {

				if (content.indexOf("[\"face\",") != -1 || content.indexOf("[\"cface\",{\"") != -1) {
					content = "系统不允许你发图片";
				}

				if (content.indexOf("@off-group") == 0) {
					Conf.isRobot = false;
				}
				if (content.indexOf("@on-group") == 0) {
					Conf.isRobot = true;
				}

				if (content.indexOf("@") == 0) { // 处理@命令
					if (content != "" && content.indexOf("@cn-en") == 0 || content.indexOf("@中文") == 0) { // 处理@Translate@ByGoogle
						//
						RobotPoll robotPoll = new RobotPoll();
						sendTextMessage = robotPoll.Translate(content.replaceFirst("@cn-en", ""), "zh-en");
					}
					if (content != "" && content.indexOf("@en-cn") == 0 || content.indexOf("@英文") == 0) { // 处理@Translate@ByGoogle
						//
						RobotPoll robotPoll = new RobotPoll();
						sendTextMessage = robotPoll.Translate(content.replaceFirst("@en-cn", ""), "en-zh");
					}
					if (content != "" && content.indexOf("@BASE64") == 0) { // 处理
						sendTextMessage = Base64.encode(content.replaceFirst("@BASE64", ""));
					}
					if (content != "" && content.indexOf("@KD") == 0 || content.indexOf("@kd") == 0 || content.indexOf("@快递") == 0) { // 处理
						ExpressUtils exp = new ExpressUtils();
						sendTextMessage = exp.getExp(content);
					}
				} else if (content.indexOf("#") != -1 && content.trim().length() >= 3) {// 处理#命令
					sendTextMessage = BaikeSearch.BaiKe(content);

				} else if (Conf.isRobot) {
					log.info("发送跟话消息");					
				} else {
					this.interrupt();
					log.info("不发送群消息线程自动结束");
					return;
				}
			}

			JSONObject jsonObject = new JSONObject();
			jsonObject.put("group_uin", qun_uin);
			jsonObject.put("face", "98");
			JSONArray jsonArray = new JSONArray();

			jsonArray.add(sendTextMessage); // 发送的消息

			jsonArray.add(Utils.getFont());// 设置消信息字体

			jsonObject.put("content", jsonArray.toString());
			jsonObject.put("msg_id", UUID.randomUUID());
			jsonObject.put("clientid", this.user.getClientid());
			jsonObject.put("psessionid", this.user.getPsessionid());

			param.put("r", jsonObject.toString());
			param.put("clientid", String.valueOf(this.user.getClientid()));
			param.put("psessionid", this.user.getPsessionid());
		} catch (Exception e) {
			log.info("发送群消息失败 ： " + e);
		}

		
		DefaultHttpClient client = new DefaultHttpClient();

		HttpUtils httpUtils = new HttpUtils(this.user);

		HttpResponse response;

		try {
			
			this.sleep(600);
			
			response = client.execute(httpUtils.PostMethod(qunSendUrl, param));

			String result = EntityUtils.toString(response.getEntity(), "UTF-8");

			List<Cookie> cookieList = client.getCookieStore().getCookies();

			for (Cookie cookie : cookieList) {
				log.info("Cookie : " + cookie.getName() + "  " + cookie.getValue());
			}
			log.info("发送群消息 response : " + result);

		} catch (Exception e) {
			log.info("发送群消息失败 ： ");
			this.interrupt();
		}

	}

}
