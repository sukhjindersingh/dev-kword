/**
 * 
 */
package com.kdev.qq.unit;

import java.util.HashMap;
import java.util.Map;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

/**
 * @author 0101
 * 
 */
public class Json {

	public static void main(String[] args) {

		/**
		 * content  retcode time msg_id2 poll_type font msg_type to_uin msg_id
		 * reply_ip from_uin
		 */
		Map<String, String> result = new HashMap<String, String>();
		try {
			JSONObject jObject = new JSONObject(
					"{'retcode':0,"
							+ "'result':[{'poll_type':'message','value':{'msg_id':17054,'from_uin':1841020862,'to_uin':136318508,'msg_id2':788670,'msg_type':9,'reply_ip':176882157,'time':1323266692,"
							+ "'content':[['font',{'size':14,'color':'8080ff','style':[0,0,0],'name':'\u6977\u4F53'}],'\u4E2D\u6587 ']}}]}");

			JSONArray array1 = jObject.getJSONArray("result");

			JSONObject jObject2 = new JSONObject(array1.getJSONObject(0)
					.getString("value"));
			JSONArray array2 = jObject2.getJSONArray("content");

			result.put("retcode", jObject.getString("retcode"));
			result.put("poll_type", array1.getJSONObject(0).getString(
					"poll_type"));
			result.put("msg_id", jObject2.getString("msg_id"));
			result.put("from_uin", jObject2.getString("from_uin"));
			result.put("to_uin", jObject2.getString("to_uin"));
			result.put("msg_id2", jObject2.getString("msg_id2"));
			result.put("msg_type", jObject2.getString("msg_type"));
			result.put("reply_ip", jObject2.getString("reply_ip"));
			result.put("time", jObject2.getString("time"));
			result.put("content", String.valueOf(array2.get(1)));
			result.put("font", String.valueOf(array2.get(0)));

			

		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
