package com.kdev.qq.utils;

/**
@author kick.smiles@gmail.com
*       <br /> Date : Dec 8, 2011 
 */
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class GoogleTranslate {

    private static HttpPost httppost;
    private static HttpResponse response;
    private static final DefaultHttpClient httpclient = new DefaultHttpClient();

    /*
     * @param text 翻译原文
     * @param lanFrom 源语言
     * @param lanTo 目标语言
     * @return 翻译后的字符串
     */
    public static String translate(String text, String lanFrom, String lanTo) {
        List<NameValuePair> qparams = new ArrayList<NameValuePair>();
        qparams.add(new BasicNameValuePair("hl", "en"));
        qparams.add(new BasicNameValuePair("ie", "UTF-8"));
        qparams.add(new BasicNameValuePair("sl", lanFrom));
        qparams.add(new BasicNameValuePair("text", text));
        qparams.add(new BasicNameValuePair("tl", lanTo));

        //HttpClient提交post请求
        httppost = new HttpPost("http://translate.google.com/translate_t#");
        String cookie = "Cookie	PREF=ID=8daa1f767f10d1fe:U=f5ac701cf7d3f2e0:FF=0:LD=en:CR=2:TM=1277174286:LM=1289370601:S=q7yslRWEZs3uK1H8; NID=39=UO-TWo9HzzjHc-d_wYm7BVR1cH33KpqaN5h5877_i29nERA93FeG1GSuV3ZSvsOx8D-TnHKpB9m0KhZRH8U9uPwoE-arYd0bAyAlILyXZxLO2_TyGQhJpcMiOLVEuCpq; SID=DQAAAHoAAADMlGzeKhnGkbkIJ36tVO0ZPXgmQ6Cth7Oa6geyyE1WJooW8P01uKUHNrsRkjggvFMAWIWB9J5i18z0F6GjC_oV79mSwXEDGuRFGhRnDyJdid3ptjFW0pIyt4_2D6AMIqtOWF71aWdvY7IvAU1AWMNs8fBZHAOgRqtf3aCUkr36ZA; HSID=A6-YJTnhjBdFWukoR";
        httppost.addHeader("Cookie", cookie);

        String responseBody = "";
        String content = "";
        try {
            //将参数封装到post数据包中
            httppost.setEntity(new UrlEncodedFormEntity(qparams, HTTP.UTF_8));
            response = httpclient.execute(httppost);
            responseBody = EntityUtils.toString(response.getEntity());

            //过滤出所需翻译后的内容
            int tmp1 = responseBody.indexOf("result_box");
            int tmp2 = responseBody.indexOf(">", tmp1);
            int tmp3 = responseBody.indexOf("</div>", tmp2);
            //替换换行符和其他网页标签
            content = responseBody.substring(tmp2 + 1, tmp3).replaceAll("<br>", "\n").replaceAll("<[^>]*>", "");
        } catch (Exception e) {
            return content;
        } finally {
            httppost.abort();
        }
        return content;
    }

    /*
     * 重载上面的translate()方法，实现文本数组的翻译
     */
    public static String[] translate(String[] text, String lanFrom, String lanTo) {
        if (text == null || text.length < 1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length; i++) {
            if (i < text.length - 1) {
                sb.append(text[i]).append("BBaaBB");
            } else {
                sb.append(text[i]);
            }
        }
        return translate(sb.toString(), lanFrom, lanTo).split("BBaaBB");
    }

    public static void main(String[] args) {
    	
    //	System.out.println("@Translate asdfsd".indexOf("@Translate"));
        String text = "你们全是大坏蛋";
        String[] arrayText = {"我来自广东梅州。", "我爱你，梅州！"};
        //这里实现多国语言间的翻译，大约支持59种语言，语言代码这里不再列出，有需要可到网上搜索
        //语言字符串为国家或地区语言代码，一般为两位，繁体中文为：zh-TW 法语为：fr
        String tranText = GoogleTranslate.translate(text, "zh-CN", "en");
        
        System.out.println(tranText);
        String[] tranArray = GoogleTranslate.translate(arrayText, "zh-CN", "en");
        System.out.println("tranText=" + tranText);
        for (int i = 0; i < tranArray.length; i++) {
            System.out.println("tranArray[" + i + "]=" + tranArray[i]);
        }
    }
}
