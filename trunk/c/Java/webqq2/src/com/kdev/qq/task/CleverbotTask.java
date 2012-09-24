/**
 * 
 */
package com.kdev.qq.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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


/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 9, 2011
 * 
 */
public class CleverbotTask {

	private static final Log log = LogFactory.getLog(CleverbotTask.class);

	String postURL = "http://cleverbot.com/webservicemin"; //http://d.web2.qq.com/channel/send_buddy_msg2
//	String postURL = "http://d.web2.qq.com/channel/send_buddy_msg2"; //
	String contents = "";

	String url = "";

	Map<String, String> param = new HashMap<String, String>();
	Map<String, String> userCookie = new HashMap<String, String>();
	ArrayList<Header> headersList = new ArrayList<Header>();

	public String postCleverBot() {

		// 设置头信息
		headersList.add(new BasicHeader("Accept", "*/*"));
		headersList.add(new BasicHeader("Cache-Control", "no-cache"));
		headersList.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));
		headersList.add(new BasicHeader("Accept-Encoding", "gzip, deflate,sdch"));
		headersList.add(new BasicHeader("Accept-Language", "en-us"));
		headersList.add(new BasicHeader("Accept-Charset", "utf-8"));
		headersList.add(new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET "
				+ "CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C;InfoPath.3; BOIE9;ZHCN)"));
		headersList.add(new BasicHeader("Referer", "http://cleverbot.com"));
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

		param.put("stimulus", "5566");
		param.put("start", "y");
		param.put("sessionid", "");
		param.put("vText8", "");
		param.put("vText7", "");
		param.put("vText6", "");
		param.put("vText5", "");
		param.put("vText4", "");
		param.put("vText3", "");
		param.put("vText2", "");
		param.put("icognoid", "wsf");
		param.put("icognocheck", "");
		param.put("fno", "0");
		param.put("prevref", "UJ002754380");
		param.put("emotionaloutput", "");
		param.put("emotionalhistory", "");
		param.put("asbotname", "");
		param.put("ttsvoice", "");
		param.put("typing", "!02");
		param.put("lineref", "");
		param.put("sub", "Say");
		param.put("islearning", "1");
		param.put("cleanslate", "fals");

		DefaultHttpClient client = new DefaultHttpClient();

		HttpResponse response;

		try {

			response = client.execute(PostMethod(postURL, param));

			String result = EntityUtils.toString(response.getEntity(), "utf-8");

			List<Cookie> cookieList = client.getCookieStore().getCookies();

			for (Cookie cookie : cookieList) {
				log.info("Cookie : " + cookie.getName() + "  " + cookie.getValue());
			}
			System.out.println(result);
			log.info("response : " + result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

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

	public static void main(String[] args) {
		CleverbotTask cleverbotTask = new CleverbotTask();
		cleverbotTask.postCleverBot();

	}
}
