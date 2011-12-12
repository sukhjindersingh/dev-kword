/**
 * 
 */
package com.kdev.qq.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 */
public class Conf {

	private Log log = LogFactory.getLog(Conf.class);

	private static final String LOGIN_URL = "http://ptlogin2.qq.com";
	private static final String LOGIN_2_URL = "http://d.web2.qq.com/channel/login2";
	private static final String SEND_MESSAGE_URL = "http://d.web2.qq.com/channel/send_buddy_msg2";
	private static final String SEND_GROUP_URL = "http://d.web2.qq.com/channel/send_qun_msg2";
	private static final String GET_MESSAGE_URL = "http://d.web2.qq.com/channel/poll2";

	private static final String REFER = "http://d.web2.qq.com/proxy.html";

	public static boolean isRobot = true;

	public static String msg = "";

	private static boolean isrun = false;

	public static final String HELP_MSG = "1. #搜索信息#\r\n 2. @kd UPS 888888\r\n 3. @cn-en 翻译中文-英文 \r\n 4. @en-cn translate english to chinese\r\n 5. @BASE64 编码 \r\n 6. @off-group @on-group 自动跟话开关 \r\n author: kick.smiles@gmail.com";

	Conf() {
		log.info("加载系统配置文件.....");
	}

	/**
	 * @return the lOGIN_URL
	 */
	public static String getLOGIN_URL() {
		return LOGIN_URL;
	}

	/**
	 * @return the lOGIN_2_URL
	 */
	public static String getLOGIN_2_URL() {
		return LOGIN_2_URL;
	}

	/**
	 * @return the sEND_MESSAGE_URL
	 */
	public static String getSEND_MESSAGE_URL() {
		return SEND_MESSAGE_URL;
	}

	/**
	 * @return the gET_MESSAGE_URL
	 */
	public static String getGET_MESSAGE_URL() {
		return GET_MESSAGE_URL;
	}

	/**
	 * @return the refer
	 */
	public static String getRefer() {
		return REFER;
	}

	/**
	 * @return the isrun
	 */
	public static boolean isIsrun() {
		return isrun;
	}

	/**
	 * @param isrun
	 *            the isrun to set
	 */
	public static void setIsrun(boolean isrun) {
		Conf.isrun = isrun;
	}

	/**
	 * @return the sEND_GROUP_URL
	 */
	public static String getSEND_GROUP_URL() {
		return SEND_GROUP_URL;
	}

}
