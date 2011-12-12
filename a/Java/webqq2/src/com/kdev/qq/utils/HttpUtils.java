/**
 * 
 */
package com.kdev.qq.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.http.Header;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.log4j.Logger;

import com.kdev.qq.bean.QQuser;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 * 
 */
public class HttpUtils {

	public static Logger log = Logger.getLogger(HttpUtils.class);
	
	@SuppressWarnings("unused")
	private QQuser user;
	private Map<String, String> userCookie;
	private List<Header> headersList;
	
	public HttpUtils(QQuser user){
		this.user = user;
		this.userCookie = user.getCookie();
		headersList = new ArrayList<Header>();
		// 设置头信息
		headersList.add(new BasicHeader("Accept", "*/*"));
		headersList.add(new BasicHeader("Accept-Encoding", "gzip, deflate"));
		headersList.add(new BasicHeader("Accept-Language", "zh-cn"));
		headersList.add(new BasicHeader("Accept-Charset", "UTF-8"));
		headersList.add(new BasicHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; WOW64; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET "
				+ "CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; .NET4.0C;InfoPath.3; BOIE9;ZHCN)"));
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
	
	/**
	 * 发送请求 GET
	 * 
	 * @param url
	 * @param user
	 * @return
	 */
	public static String getURL(String url, QQuser user) {

		String cookie = user.get_cookie();

		try {

			log.info("[GET]请求地址 : " + url);

			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl
					.openConnection();
			conn.setRequestMethod("GET");// "POST" ,"GET"
			// conn.setDoOutput(true);
			if (Conf.getRefer() != null) {

				conn.addRequestProperty("Referer", Conf.getRefer());

			}
			conn.addRequestProperty("Cookie", cookie);

			conn.addRequestProperty("Accept-Charset", "UTF-8;");// GB2312,
			conn
					.addRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
			conn.connect();

			if (conn.getHeaderFields().get("Set-Cookie") != null) {
				for (String s : conn.getHeaderFields().get("Set-Cookie")) {
					cookie += s;
				}
				user.set_cookie(cookie);
			}
			InputStream ins = conn.getInputStream();

			String charset = "UTF-8";
			InputStreamReader inr = new InputStreamReader(ins, charset);
			BufferedReader bfr = new BufferedReader(inr);

			String line = "";
			StringBuffer res = new StringBuffer();
			do {
				res.append(line);
				line = bfr.readLine();
			} while (line != null);

			log.debug("[GET]请求返回数据 response : " +res);

			return res.toString();

		} catch (Exception e) {
			log.info("发送请求失败 : " +e);
			return "";
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
	

	/**
	 * 发送请求 POST
	 * 
	 * @param url
	 * @param content
	 * @param user
	 * @return
	 */
	public static String postURL(String url, String content, QQuser user) {

		String cookie = user.get_cookie();
		
		try {

			log.info("[POST]请求地址 : " + url);

			URL serverUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) serverUrl
					.openConnection();
			conn.setRequestMethod("POST");// "POST" ,"GET"

			if (Conf.getRefer() != null) {
				conn.addRequestProperty("Referer", Conf.getRefer());
			}
			conn.addRequestProperty("Cookie", cookie);
			conn.addRequestProperty("Accept-Charset", "UTF-8;");// GB2312,
			conn
					.addRequestProperty("User-Agent",
							"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.8) Firefox/3.6.8");
			conn.setDoOutput(true);
			conn.connect();

			conn.getOutputStream().write(content.getBytes());

			if (conn.getHeaderFields().get("Set-Cookie") != null) {
				for (String s : conn.getHeaderFields().get("Set-Cookie")) {
					cookie += s;
				}
				user.set_cookie(cookie);
			}

			InputStream ins = conn.getInputStream();

			String charset = "UTF-8";
			InputStreamReader inr = new InputStreamReader(ins, charset);
			BufferedReader bfr = new BufferedReader(inr);

			String line = "";
			StringBuffer res = new StringBuffer();
			do {
				res.append(line);
				line = bfr.readLine();
			} while (line != null);

			log.info("[POST]请求返回数据 response" + res);

			return res.toString();
		} catch (Exception e) {
			log.info("发送POST 请求异常 :" + e);
			return null;
		}

	}
}
