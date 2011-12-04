/**
 * 
 */
package com.k.test;

/**
 *@author kick.smiles@gmail.com
*       <br /> Date : Dec 1, 2011 
 * 
 */
public class Unicode {

	/**
	 * 字符 Unicode 编码 \u0000  16进制 4 位数字表示
	 * @param args
	 */
	public static void main(String[] args) {
		
		//System.out.println(0xFFF);

		String s = "1234+中文";		
		String as[] = new String[s.length()];
		String s1 = "";
		
		for (int i = 0; i < s.length(); i++) {
			as[i] = Integer.toHexString(s.charAt(i) & 0xFFFF);
			s1 = s1 + "\\u" + as[i];
		}		
		
		System.out.println(0x2EEEF);
		System.out.println(2*16*16*16*16 + 14*16*16*16 + 14*16*16 +14*16 +15);
		System.out.println(9&5);
		//十六进制转10进制 基数×16的多少位次方+ N
		System.out.println("--------------------------------------------------");
		
		System.out.println(s1);
		System.out.println("\u0031\u0032\u0033\u0034\u002b\u4e2d\u6587");
		System.out.println("\u00310010");
		
		
		//   转自HTML unicode 输出  中 \u4e2d  &#x4e2d；  使用 x 占位
		//   BYTE data_utf8[] = {0xE6, 0xB1, 0x89, 0xE5, 0xAD, 0x97};   // UTF-8编码
		//　　WORD data_utf16[] = {0x6c49, 0x5b57};                     // UTF-16编码
		//　　DWORD data_utf32[] = {0x6c49, 0x5b57};                    // UTF-32编码
	}

}
