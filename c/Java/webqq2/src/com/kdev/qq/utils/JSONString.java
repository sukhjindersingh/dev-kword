/**
 * 
 */
package com.kdev.qq.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONObject;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 * 
 */
public class JSONString {
	private static final Log log = LogFactory.getLog(JSONString.class);
	private Map<String, String> result = new HashMap<String, String>();
	JSONObject jObject;

	public JSONString(String obj) {

		try {
			this.jObject = new JSONObject(obj);
			JSONArray array1 = jObject.getJSONArray("result");

			JSONObject jObject2 = new JSONObject(array1.getJSONObject(0).getString("value"));
			JSONArray array2 = jObject2.getJSONArray("content");

			result.put("retcode", jObject.getString("retcode") == null ? "99999" : jObject.getString("retcode"));
			result.put("poll_type", array1.getJSONObject(0).getString("poll_type") == null ? "99999" : array1.getJSONObject(0).getString("poll_type"));
			result.put("msg_id", jObject2.getString("msg_id") == null ? "99999" : jObject2.getString("msg_id"));
			result.put("from_uin", jObject2.getString("from_uin") == null ? "99999" : jObject2.getString("from_uin"));
			result.put("to_uin", jObject2.getString("to_uin") == null ? "99999" : jObject2.getString("to_uin"));
			result.put("msg_id2", jObject2.getString("msg_id2") == null ? "99999" : jObject2.getString("msg_id2"));
			result.put("msg_type", jObject2.getString("msg_type") == null ? "99999" : jObject2.getString("msg_type"));
			result.put("reply_ip", jObject2.getString("reply_ip") == null ? "99999" : jObject2.getString("reply_ip"));
			result.put("time", jObject2.getString("time") == null ? "99999" : jObject2.getString("time"));
			result.put("content", String.valueOf(array2.get(1)) == null ? "99999" : String.valueOf(array2.get(1)));
			result.put("font", String.valueOf(array2.get(0)) == null ? "99999" : String.valueOf(array2.get(0)));

		} catch (Exception e) {
			log.info("解析JSONObjec 异常 【response JSONObject ： 】"+jObject.toString()+"     Exception : " + e);
		}
	}

	/**
	 * @info 处理 Message or group_message Response JSON
	 * 
	 * @param key
	 * @return content retcode time msg_id2 poll_type font msg_type to_uin
	 *         msg_id reply_ip from_uin
	 * 
	 */
	public String getMs(String key) {
		return result.get(key);
	}
}
