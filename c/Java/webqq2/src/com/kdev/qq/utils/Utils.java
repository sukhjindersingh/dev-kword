/**
 * 
 */
package com.kdev.qq.utils;

import java.io.File;
import java.io.FileReader;
import java.util.Date;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util;

import atg.taglib.json.util.JSONArray;
import atg.taglib.json.util.JSONException;
import atg.taglib.json.util.JSONObject;

/**
 * @author 0101
 * 
 */
public class Utils {
	private static final Log log=LogFactory.getLog(Util.class);
	
	public static int threadNum=0;
	@SuppressWarnings("deprecation")
	public static String getDate() {
		return "[ " + new Date().toGMTString() + " ] ";
	}

	public static JSONArray getFont() {
		try {
			JSONArray font = new JSONArray();
			font.add("font");
			JSONArray style = new JSONArray();
			style.add(0);
			style.add(0);
			style.add(0);
			JSONObject fontObject = new JSONObject();
			fontObject.put("name", "宋体");
			fontObject.put("size", "12");
			fontObject.put("style", style);
			fontObject.put("color", "FF0022");
			font.add(fontObject);
			return font;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String Qweb2MD5(String p, String code) {
		try {
			ScriptEngineManager m = new ScriptEngineManager();
			ScriptEngine se = m.getEngineByName("javascript");
			se.eval(new FileReader(new File("d:\\1.js")));
			Object t = se.eval("md5(md5_3(\"" + p + "\")+\"" + code.toUpperCase() + "\");");
			return t.toString();
		} catch (Exception e) {
			log.debug("读取加密JS处理异常  :  "+e);
		}
		return null;

	}

}
