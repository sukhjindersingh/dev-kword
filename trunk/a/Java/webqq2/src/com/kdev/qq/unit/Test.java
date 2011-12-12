/**
 * 
 */
package com.kdev.qq.unit;

import java.io.BufferedReader;
import java.io.InputStreamReader;


import com.kdev.qq.bean.QQuser;
import com.kdev.qq.main.CheckLogin;

/**
 * @author kick.smiles@gmail.com <br />
 *         Date : Dec 7, 2011
 */
public class Test {
//	private static final Log log = LogFactory.getLog(Test.class);

	public static void main(String[] args) {

		// try {
		// QQuser user=new QQuser(280622957,"kick|smiles+show");
		// CheckLogin.checkLogin(user);
		//			
		//			
		// } catch (Exception e) {
		//			
		// QQuser user=new QQuser(280622957,"kick|smiles+show");
		// CheckLogin.checkLogin(user);
		//			
		// }

		try {
			while (true) {
				BufferedReader r = new BufferedReader(new InputStreamReader(
						System.in));
				String qq = r.readLine();
				String pwd = r.readLine();
				r.close();
				// QQuser user = new QQuser(136318508, "nuli2010@163.com");
				QQuser user = new QQuser(Integer.parseInt(qq), pwd);

				if (CheckLogin.checkLogin(user)) {
					System.out.println("登陆成功.....");
				} else {
					System.out.println("登陆失败，重新登录....");
				}

			}

		} catch (Exception e) {

			QQuser user = new QQuser(136318508, "nuli2010@163.com");
			CheckLogin.checkLogin(user);

		}

	}

}
