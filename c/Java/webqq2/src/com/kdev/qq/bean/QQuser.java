/**
 * 
 */
package com.kdev.qq.bean;

import java.util.Map;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 */

public class QQuser {

	private String nick;
	private int uin;
	private String pass;
	private long face;
	private String onlyKey;
	
	
	private int clientid = 1009003;// 这个可以随便写
	private String psessionid = "";

	private String ptwebqq;
	private String vfwebqq;

	private String skey;

	

	private Map<String, Fried> fried;
	private Map<String, Group> group;
	
	private Map<String, String> cookie;
	
	
	
	private String _cookie="";
	
	private Map<String, TenMessage> tenMessage;

	public QQuser(int uin, String pass) {
		this.uin=uin;
		this.pass=pass;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick
	 *            the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the uin
	 */
	public int getUin() {
		return uin;
	}

	/**
	 * @param uin
	 *            the uin to set
	 */
	public void setUin(int uin) {
		this.uin = uin;
	}

	/**
	 * @return the onlyKey
	 */
	public String getOnlyKey() {
		return onlyKey;
	}

	/**
	 * @param onlyKey
	 *            the onlyKey to set
	 */
	public void setOnlyKey(String onlyKey) {
		this.onlyKey = onlyKey;
	}

	/**
	 * @return the tenMessage
	 */
	public Map<String, TenMessage> getTenMessage() {
		return tenMessage;
	}

	/**
	 * @param tenMessage
	 *            the tenMessage to set
	 */
	public void setTenMessage(Map<String, TenMessage> tenMessage) {
		this.tenMessage = tenMessage;
	}

	/**
	 * @return the fried
	 */
	public Map<String, Fried> getFried() {
		return fried;
	}

	/**
	 * @param fried
	 *            the fried to set
	 */
	public void setFried(Map<String, Fried> fried) {
		this.fried = fried;
	}

	/**
	 * @return the group
	 */
	public Map<String, Group> getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(Map<String, Group> group) {
		this.group = group;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}


	/**
	 * @return the _cookie
	 */
	public String get_cookie() {
		return _cookie;
	}

	/**
	 * @param _cookie the _cookie to set
	 */
	public void set_cookie(String _cookie) {
		this._cookie = _cookie;
	}

	/**
	 * @return the clientid
	 */
	public int getClientid() {
		return clientid;
	}

	/**
	 * @param clientid the clientid to set
	 */
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}

	/**
	 * @return the psessionid
	 */
	public String getPsessionid() {
		return psessionid;
	}

	/**
	 * @param psessionid the psessionid to set
	 */
	public void setPsessionid(String psessionid) {
		this.psessionid = psessionid;
	}

	/**
	 * @return the ptwebqq
	 */
	public String getPtwebqq() {
		return ptwebqq;
	}

	/**
	 * @param ptwebqq the ptwebqq to set
	 */
	public void setPtwebqq(String ptwebqq) {
		this.ptwebqq = ptwebqq;
	}

	/**
	 * @return the vfwebqq
	 */
	public String getVfwebqq() {
		return vfwebqq;
	}

	/**
	 * @param vfwebqq the vfwebqq to set
	 */
	public void setVfwebqq(String vfwebqq) {
		this.vfwebqq = vfwebqq;
	}

	/**
	 * @return the skey
	 */
	public String getSkey() {
		return skey;
	}

	/**
	 * @param skey the skey to set
	 */
	public void setSkey(String skey) {
		this.skey = skey;
	}

	/**
	 * @param cookie the cookie to set
	 */
	public void setCookie(Map<String, String> cookie) {
		this.cookie = cookie;
	}

	/**
	 * @return the cookie
	 */
	public Map<String, String> getCookie() {
		return cookie;
	}

	/**
	 * @return the face
	 */
	public long getFace() {
		return face;
	}

	/**
	 * @param face the face to set
	 */
	public void setFace(long face) {
		this.face = face;
	}

}
