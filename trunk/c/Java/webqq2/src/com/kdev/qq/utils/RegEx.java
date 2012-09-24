/**
 * 
 */
package com.kdev.qq.utils;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 0101
 * 
 */
public class RegEx {

	public static void main(String[] args) {
		
//		String html = "<font face=\"Arial Serif\" size=\"+2\" color=\"red\">";  
//        String regexForTag = "<\\s*font\\s+([^>]*)\\s*>";  
//          
//        Pattern pattern = Pattern.compile(regexForTag, Pattern.CASE_INSENSITIVE);  
//        Matcher matcher = pattern.matcher(html);  
//          
//        boolean find = matcher.find();  
//          
//        String attribute = matcher.group(1);  
//        System.out.println("属性字符串为：" + attribute);  
//          
//        String regexForAttribute = "([a-z]+)\\s*=\\s*\"([^\"]+)\"";  
//        Pattern pattern2 = Pattern.compile(regexForAttribute, Pattern.CASE_INSENSITIVE);  
//        Matcher matcher2 = pattern2.matcher(attribute);  
//          
//        boolean find2 = matcher2.find();  
//          
//        while(find2) {  
//            MatchResult result = matcher2.toMatchResult();  
//            System.out.println(result.group(1) + "=" + result.group(2));  
//            find2 = matcher2.find();  
//        }  
//		
//		String url = "<a href=\"http://192.168.0.1:8080/test/index.jsp#test...\">" + "< a href = \"http://192.168.0.1:8080/test/index.jsp#?hahahaha...\">";
//		String regex = "(<\\s*a\\s+href\\s*=\\s*\"http://192.168.0.1:8080/test/index.jsp[^\"]+\">)";
//		Pattern p1 = Pattern.compile(regex);
//		Matcher m1 = p1.matcher(url);
//		boolean find3 = m1.find();
//		System.out.println("find=>" + find3);
//		while (find) {
//			MatchResult result = m1.toMatchResult();
//			String temp = result.group(1);
//			System.out.println("替换前=>" + temp);
//			temp = temp.replace("192.168.0.1", "localhost");
//			System.out.println("替换后=>" + temp);
//			find = m1.find();
//		}
//
//		//替换
//		String regex2 = "a+";
//		Pattern pattern3 = Pattern.compile(regex2);
//		Matcher matcher3 = pattern.matcher("aaabbced a ccdeaa");
//		System.out.println("replaceFirst=>" + matcher3.replaceFirst("A"));
//		String result = matcher3.replaceAll("A");
//		System.out.println("replaceAll=>" + result);
//		String delete = matcher3.replaceAll("");
//		System.out.println(delete);
//
//		
//		String regEx = "\\#(.+)\\#";
//		String str1 = "阿斯发生大幅#中国# asdfsdfeasdf";
//		Pattern pattern1 = Pattern.compile(regEx);
//		Matcher matcher1 = pattern1.matcher(str1);
//		boolean rs = matcher1.find();
//		if (rs) {
//			System.out.println(matcher1.group(1));
//		}
		
		String str="asdfasdf收~!@#$%^&**())_+}{][|'|:></?.><.,-*/到罚单asdf hello &&**783438(*#*(#(@单asdf hello &&**783438(*#*(#(@*dddds(*!@#*";
		 String regex = "^[\u4e00-\u9fa5]*$";//判断中文正则表达式
	      System.out.println("处理前："+str);
	      str = str.replaceAll("\\W\\D", "").replaceAll("\\d", "");//删除数字、英文字s母或下滑线正则表达式
	      System.out.println("处理1："+str);
	   
		
		
//		String str = "192.168.0.1 - - [26/Feb/2009:14:56:43 -0500]\"GET /lsAlive/ht HTTP/1.0\"200 15\r\n" + "192.168.0.2 - - [25/Feb/2009:14:56:43 -0500]\"GET /lsAlive/ht HTTP/1.0\"200 15";
//
//		String regexp = "([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})\\s-\\s-\\s\\[([^\\]]+)\\]";
//		Pattern pattern = Pattern.compile(regexp);
//		Matcher matcher = pattern.matcher(str);
//
//		boolean find = matcher.find();
//
////		while (find) {
////			MatchResult result = matcher.toMatchResult();
////			System.out.println("IP=>" + result.group(1));
////			System.out.println("Timestamp=>" + result.group(2));
////			find = matcher.find();
////		}
//
//		String regEx = "\\#(.+)\\#";
//		String str1 = "#中国# asdfsdfeasdf";
//		Pattern pattern1 = Pattern.compile(regEx);
//		Matcher matcher1 = pattern1.matcher(str1);
//		boolean rs = matcher1.find();
//		if (rs) {
//			System.out.println(matcher1.group(1));
//		}
//		
//		
//		String regex = "a+";
//        Pattern patte = Pattern.compile(regex);  
//        Matcher matcr = patte.matcher("aaabbced a ccdeaa");  
//        System.out.println( matcr.replaceFirst("A"));  
//        String result = matcr.replaceAll("A");  
//        System.out.println(result);  
//        String delete = matcr.replaceAll("");  
//        System.out.println(delete);
//        System.out.println("替换为空即可达到删除的功能");  
	}

}
