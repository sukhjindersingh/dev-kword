/**
 * 
 */
package com.kdev.qq.task;

import org.apache.log4j.Logger;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

import com.kdev.qq.bean.QQuser;
import com.kdev.qq.utils.Conf;
import com.kdev.qq.utils.HttpUtils;
import com.kdev.qq.utils.JSONString;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 8, 2011
 * 
 */
public class MessageThread extends Thread {
	public static Logger log = Logger.getLogger(GetMessagePoll.class);

	private QQuser user;

	// private SendMessageSwitch sendMessageSwitch;

	MessageThread() {
	}

	public MessageThread(QQuser user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {

		// sendMessageSwitch = new SendMessageSwitch(user);

		String url = Conf.getGET_MESSAGE_URL() + "?clientid=" + user.getClientid() + "&psessionid=" + user.getPsessionid();

		try {
			while (Conf.isIsrun()) { // 线程一直等待服务器有返回数据

				String res = HttpUtils.getURL(url, user);

				JSONObject _json = new JSONObject(res);

				log.info("\r\n Response ObjectText  :" + _json.toString());
				// 'retcode' code is response Message status
				if (_json.getInt("retcode") == 0) {// 这里处理个人消息和群消息

					JSONArray array1 = _json.getJSONArray("result");
					System.out.println(_json.getString("retcode"));
					System.out.println(array1.getJSONObject(0).getString("poll_type"));

					JSONString json = new JSONString(res);

					if ("message".equals(json.getMs("poll_type"))) { // 判断消息类型
						SendUserMessagePoll sendUserMessagePoll = new SendUserMessagePoll(user, json.getMs("content"), json.getMs("from_uin"));
						sendUserMessagePoll.start();
						// sendMessageSwitch.sendUserMset(json.getMs("content"),
						// json.getMs("from_uin"));
						continue;
					}
					if ("group_message".equals(json.getMs("poll_type"))) {

						SendGroupMessagePoll sendGroupMessagePoll = new SendGroupMessagePoll(user, json.getMs("content"), json.getMs("from_uin"));
						sendGroupMessagePoll.start();
						// sendMessageSwitch.sendGroupMset(json.getMs("content"),
						// json.getMs("from_uin")); // else

						continue;

					}

				} else { // 处理系统及其它消息
					log.info("【系统消息】  消息级别 ： " + _json.toString());
				}

			}// end while

		} catch (JSONException e) {
			log.info("处理消息异常 ：");
		}
	}
}
