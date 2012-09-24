package com.kdev.qq.utils;

import java.io.PrintWriter;

public class Base64 {

	private static byte	codes[];
	private static char	alphabet[]	= "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="
											.toCharArray();

	public static byte[] decode(char ac[]) throws Exception {
		int i = ac.length;
		@SuppressWarnings("unused")
		boolean flag = false;
		for (int j = 0; j < ac.length; j++) {
			byte byte0 = codes[ac[j] & 0xff];
			if (byte0 < 0 && ac[j] != '=') {
				i--;
			}
		}

		int k = ((i + 3) / 4) * 3;
		if (i > 0 && ac[i - 1] == '=') {
			k--;
		}
		if (i > 1 && ac[i - 2] == '=') {
			k--;
		}
		byte abyte0[] = new byte[k];
		int l = 0;
		int i1 = 0;
		int j1 = 0;
		for (int k1 = 0; k1 < ac.length; k1++) {
			byte byte1 = codes[ac[k1] & 0xff];
			if (byte1 < 0) {
				continue;
			}
			i1 <<= 6;
			l += 6;
			i1 |= byte1;
			if (l >= 8) {
				l -= 8;
				abyte0[j1++] = (byte) (i1 >> l & 0xff);
			}
		}

		if (j1 != abyte0.length) {
			throw new Exception("Decoding error! no EOF found");
		} else {
			return abyte0;
		}
	}

	public static byte[] decodeToBytes(String s) {
		byte abyte0[] = null;
		try {
			char ac[] = s.toCharArray();
			abyte0 = decode(ac);
		} catch (Exception exception) {}
		return abyte0;
	}

	/**
	 * 将编码过的Base64字符串 还原
	 * 
	 * @param s
	 * @return
	 */
	public static String decode(String s) {
		String s1 = s;
		try {
			char ac[] = s.toCharArray();
			byte abyte0[] = decode(ac);
			s1 = new String(abyte0);
		} catch (Exception exception) {
			System.out.println(exception);
		}
		return s1;
	}

	public static char[] encode(byte abyte0[]) {
		char ac[] = new char[((abyte0.length + 2) / 3) * 4];
		int i = 0;
		for (int j = 0; i < abyte0.length; j += 4) {
			boolean flag = false;
			boolean flag1 = false;
			int k = 0xff & abyte0[i];
			k <<= 8;
			if (i + 1 < abyte0.length) {
				k |= 0xff & abyte0[i + 1];
				flag1 = true;
			}
			k <<= 8;
			if (i + 2 < abyte0.length) {
				k |= 0xff & abyte0[i + 2];
				flag = true;
			}
			ac[j + 3] = alphabet[flag ? k & 0x3f : 64];
			k >>= 6;
			ac[j + 2] = alphabet[flag1 ? k & 0x3f : 64];
			k >>= 6;
			ac[j + 1] = alphabet[k & 0x3f];
			k >>= 6;
			ac[j + 0] = alphabet[k & 0x3f];
			i += 3;
		}

		return ac;
	}

	public static char[] encode(byte abyte0[], int i, int j) {
		char ac[] = new char[((j + 2) / 3) * 4];
		int k = i;
		for (int l = 0; k < j; l += 4) {
			boolean flag = false;
			boolean flag1 = false;
			int i1 = 0xff & abyte0[k];
			i1 <<= 8;
			if (k + 1 < abyte0.length) {
				i1 |= 0xff & abyte0[k + 1];
				flag1 = true;
			}
			i1 <<= 8;
			if (k + 2 < abyte0.length) {
				i1 |= 0xff & abyte0[k + 2];
				flag = true;
			}
			ac[l + 3] = alphabet[flag ? i1 & 0x3f : 64];
			i1 >>= 6;
			ac[l + 2] = alphabet[flag1 ? i1 & 0x3f : 64];
			i1 >>= 6;
			ac[l + 1] = alphabet[i1 & 0x3f];
			i1 >>= 6;
			ac[l + 0] = alphabet[i1 & 0x3f];
			k += 3;
		}

		return ac;
	}

	/**
	 * 将字符串进行Base64编码
	 * 
	 * @param s
	 * @return
	 */
	public static  String encode(String s) {
		byte abyte0[] = s.getBytes();
		char ac[] = encode(abyte0);
		return new String(ac);
	}

	public static char[] MagicDump(PrintWriter printwriter, byte abyte0[])
			throws Exception {
		char ac[] = encode(abyte0);
		byte byte0 = 72;
		for (int i = 0; i < ac.length; i += byte0) {
			String s = null;
			if (i + byte0 >= ac.length) {
				s = new String(ac, i, ac.length - i);
			} else {
				s = new String(ac, i, byte0);
			}
			printwriter.println(s);
		}

		return ac;
	}

	public Base64() {}

	static {
		codes = new byte[256];
		for (int i = 0; i < 256; i++) {
			codes[i] = -1;
		}

		for (int j = 65; j <= 90; j++) {
			codes[j] = (byte) (j - 65);
		}

		for (int k = 97; k <= 122; k++) {
			codes[k] = (byte) ((26 + k) - 97);
		}

		for (int l = 48; l <= 57; l++) {
			codes[l] = (byte) ((52 + l) - 48);
		}

		codes[43] = 62;
		codes[47] = 63;
	}

//	public static void main(String[] args) {
//		Base64 b = new Base64();
//		String s = "YmFzZTY016rC67LiytQ=";
//		String ss = "base64转码测试";
//		System.out.println(b.encode(ss));
//		System.out.println(b.decode(s));
//		System.out
//				.println(b
//						.decode("cmVnSVA9MTI3LjAuMC4xO3NpZD05OUNEMjc0OUM1QzlGQkFGOTAyNDM3NkQyM0U4MDYzQjt0aW1lPTIwMTAtMDEtMTQ7dWlkPTUxOw=="));
//
//	}

}
