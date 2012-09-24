/**
 * 
 */
package com.kdev.qq.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import com.kdev.qq.bean.QQuser;
import com.kdev.qq.utils.Conf;
import com.kdev.qq.utils.HttpUtils;
import com.kdev.qq.utils.JSONString;
import com.kdev.qq.utils.Utils;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONObject;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 */
public class GetMessagePoll extends Thread {
	public static Logger log = Logger.getLogger(GetMessagePoll.class);

	private QQuser user;
	private Map<String, String> userCookie;
	private List<Header> headersList;

	public GetMessagePoll(QQuser user) {
		this.user = user;
		this.userCookie = user.getCookie();

		headersList = new ArrayList<Header>();

		// 设置头信息
		headersList.add(new BasicHeader("Accept", "*/*"));
		headersList.add(new BasicHeader("Accept-Encoding", "gzip, deflate"));
		headersList.add(new BasicHeader("Accept-Language", "zh-cn"));
		headersList.add(new BasicHeader("Accept-Charset", "UTF-8"));
		headersList.add(new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windo" + "ws NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET "
				+ "CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C;" + " InfoPath.3; BOIE9;ZHCN)"));
		headersList.add(new BasicHeader("Referer", Conf.getRefer() + "?v=20110331002&callback=2"));
		headersList.add(new BasicHeader("Connection", "Keep-Alive"));

		try { // 添加Cookie

			Set<String> keySet = userCookie.keySet();
			String cookie = "";
			for (String str : keySet) {
				cookie += str + "=" + userCookie.get(str) + ";";
			}

			headersList.add(new BasicHeader("Cookie", cookie));
		} catch (Exception e) {
			log.info("设置cookic 失败");
		}

	}

	@Override
	public void run() {
		String url = Conf.getGET_MESSAGE_URL() + "?clientid=" + user.getClientid() + "&psessionid=" + user.getPsessionid();

		while (Conf.isIsrun()) { // 线程一直等待服务器有返回数据
			String res = HttpUtils.getURL(url, user);

			JSONString json = new JSONString(res);
			if (Integer.valueOf(json.getMs("retcode")) == 0) {
				log.info("消息类型 : " + json.getMs("poll_type"));
				if ("message".equals(json.getMs("poll_type")) || "group_message".equals(json.getMs("poll_type"))) { // 判断消息类型
					// 个人消息和群消息处理
					log.info("收到来自：" + json.getMs("from_uin") + ":" + json.getMs("content"));

					if ("group_message".equals(json.getMs("poll_type"))) {
						SendQunMset(json.getMs("content"), json.getMs("from_uin"));
					} else {
						sendMset(json.getMs("content"), json.getMs("from_uin"));
					}
				}
				log.info("  系统消息");

			}
		}

	}

	private void sendMset(String message, String to_uin) {
		String sendUrl = Conf.getSEND_MESSAGE_URL();
		Map<String, String> param = new HashMap<String, String>();
		try {
			JSONObject jsonObject = new JSONObject();

			log.info("to_uin : " + to_uin);
			jsonObject.put("to", to_uin);
			jsonObject.put("face", "525");
			JSONArray jsonArray = new JSONArray();
			jsonArray.add("尼玛中文................" + message);

			jsonArray.add(Utils.getFont()); // 设置消信息字体

			jsonObject.put("content", jsonArray.toString());
			jsonObject.put("msg_id", UUID.randomUUID());// new
			// Random().nextInt(10000000)
			jsonObject.put("clientid", this.user.getClientid());
			jsonObject.put("psessionid", this.user.getPsessionid());

			param.put("r", jsonObject.toString());
			param.put("clientid", String.valueOf(this.user.getClientid()));
			param.put("psessionid", this.user.getPsessionid());
		} catch (Exception e) {
			log.info("发送消息失败" + e);
		}

		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response;

		try {

			response = client.execute(PostMethod(sendUrl, param));

			String result = EntityUtils.toString(response.getEntity(), "UTF-8");

			List<Cookie> cookieList = client.getCookieStore().getCookies();

			for (Cookie cookie : cookieList) {
				log.info("Cookie : " + cookie.getName() + "  " + cookie.getValue());
			}
			log.info(result);

		} catch (Exception e) {
			e.printStackTrace();
			log.info("发送失败 ");
		} finally {
			client.getConnectionManager().shutdown();
		}
	}

	public void SendQunMset(String message, String qun_uin) {
		String qunSendUrl = Conf.getSEND_GROUP_URL();
		Map<String, String> param = new HashMap<String, String>();
		// {"group_uin":382325257,"content":"[\"\",[\"font\",{\"name\":\"宋体\",\"size\":\"10\",\"style\":[0,0,0],\"color\":\"000000\"}]]","msg_id":4850001,"clientid":"12485420","psessionid":"8368046764001e636f6e6e7365727665725f77656271714031302e3133332e34312e32303200002da000000053026e0400571bac5b6d0000000a406a3932584c41336c556d0000002808f6de7c0a9aba4344db27ca580534627c5b9aa103d32d2fdda0eeea8ea91b91d87a7f075d4b3751"}
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("group_uin", qun_uin);
			JSONArray jsonArray = new JSONArray();
			jsonArray.add("qun_uin:" + message);
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
		HttpResponse response;

		try {

			response = client.execute(PostMethod(qunSendUrl, param));

			String result = EntityUtils.toString(response.getEntity(), "UTF-8");

			List<Cookie> cookieList = client.getCookieStore().getCookies();

			for (Cookie cookie : cookieList) {

				log.info("Cookie : " + cookie.getName() + "  " + cookie.getValue());
			}

			log.info("发送群消息 response : " + result);

		} catch (Exception e) {
			log.info("发送群消息失败 ： " + e);
		}
	}

	public HttpPost PostMethod(String url, Map<String, String> param) {
		HttpPost post = new HttpPost(url);
		// 设置头文件
		for (int i = 0; i < headersList.size(); i++) {
			post.setHeader(headersList.get(i));
		}
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Set<String> keySet = param.keySet();
		for (String key : keySet) {
			list.add(new BasicNameValuePair(key, param.get(key)));
		}
		try {
			post.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
		} catch (Exception e) {
			log.info("发送POST 请求异常 :" + e);
		}
		return post;

	}

}
