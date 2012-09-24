/**
 * 
 */
package com.kdev.qq.task;

import com.kdev.qq.utils.GoogleTranslate;

/**
 * @author kick.smiles@gmail.com
*       <br /> Date : Dec 8, 2011 
 *
 */
public class RobotPoll  extends Thread{
	private String translateText="I am Sorry !!! ";
	private GoogleTranslate translate=new GoogleTranslate();
	
	
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		
	}
	
	@SuppressWarnings("static-access")
	public  String Translate(String obj,String loc){
		
		System.out.println(obj);
		
		this.translateText=obj!=null?obj.replaceAll("\r\n", ""):this.translateText;
		String tem="";
			
			if(loc=="en-zh"){
				tem=translateText=translate.translate(translateText, "en", "zh-CN");
			}else if(loc=="zh-en") {
				tem=translateText=translate.translate(translateText, "zh-CN", "en");
			}
		
			
			System.out.println("@Translate Google : "+tem);
		return tem;
	}
}
