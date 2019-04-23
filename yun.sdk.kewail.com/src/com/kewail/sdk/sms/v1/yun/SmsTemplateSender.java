package com.kewail.sdk.sms.v1.yun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

// org.json 第三方库请自行下载编译，或者在以下链接下载使用 jdk 1.7 的版本
// http://share.weiyun.com/630a8c65e9fd497f3687b3546d0b839e
import org.json.JSONObject;
 
public class SmsTemplateSender {
	
	String accesskey;
	String secretkey;
	//同时支持http和https两种协议，具体根据自己实际情况使用。
   // String url = "https://live.kewail.com/sms/v1/sendsinglesms";
    //String url = "http://127.0.0.1:8080/live.kewail.com/sms/v1/sendsinglesms";
	
	SmsSenderUtil util = new SmsSenderUtil();

	public SmsTemplateSender(String accesskey, String secretkey) throws Exception {
		this.accesskey = accesskey;
		this.secretkey = secretkey;
	}

	
	public String saveSmsTemplate(String url,String content) throws Exception {

		// 按照协议组织 post 请求包体
        long random = util.getRandom();
        long curTime = System.currentTimeMillis()/1000;

		JSONObject data = new JSONObject();

        data.put("sig", util.strToHash(String.format(
        		"secretkey=%s&random=%d&time=%d",
        		secretkey, random, curTime)));
        data.put("content", content);
        data.put("time", curTime);

        // 与上面的 random 必须一致
		String wholeUrl = String.format("%s?accesskey=%s&random=%d", url, accesskey, random);
        HttpURLConnection conn = util.getPostHttpConn(wholeUrl);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
        System.out.println(data.toString());
        wr.write(data.toString());
        wr.flush();
        
        System.out.println(data.toString());

        // 显示 POST 请求返回的内容
        StringBuilder sb = new StringBuilder();
        int httpRspCode = conn.getResponseCode();
        String result;
        if (httpRspCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            System.out.println(sb.toString());
            result = sb.toString();
        } else {
        	//result = new SmsSingleSenderResult();
        	result = httpRspCode +"http error " + httpRspCode + " " + conn.getResponseMessage();
        }
        return result;
	}
	
	
	
	public String updateSmsTemplate(String url,String templateId,String content) throws Exception {

		// 按照协议组织 post 请求包体
        long random = util.getRandom();
        long curTime = System.currentTimeMillis()/1000;

		JSONObject data = new JSONObject();

        data.put("sig", util.strToHash(String.format(
        		"secretkey=%s&random=%d&time=%d",
        		secretkey, random, curTime)));
        data.put("content", content);
        data.put("templateId", templateId);
        data.put("time", curTime);

        // 与上面的 random 必须一致
		String wholeUrl = String.format("%s?accesskey=%s&random=%d", url, accesskey, random);
        HttpURLConnection conn = util.getPostHttpConn(wholeUrl);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
        System.out.println(data.toString());
        wr.write(data.toString());
        wr.flush();
        
        System.out.println(data.toString());

        // 显示 POST 请求返回的内容
        StringBuilder sb = new StringBuilder();
        int httpRspCode = conn.getResponseCode();
        String result;
        if (httpRspCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            System.out.println(sb.toString());
            result = sb.toString();
        } else {
        	//result = new SmsSingleSenderResult();
        	result = httpRspCode +"http error " + httpRspCode + " " + conn.getResponseMessage();
        }
        return result;
	}
	
	public String findSmsTemplate(String url,String templateId) throws Exception {

		// 按照协议组织 post 请求包体
        long random = util.getRandom();
        long curTime = System.currentTimeMillis()/1000;

		JSONObject data = new JSONObject();

        data.put("sig", util.strToHash(String.format(
        		"secretkey=%s&random=%d&time=%d",
        		secretkey, random, curTime)));
        data.put("templateId", templateId);
        data.put("time", curTime);

        // 与上面的 random 必须一致
		String wholeUrl = String.format("%s?accesskey=%s&random=%d", url, accesskey, random);
        HttpURLConnection conn = util.getPostHttpConn(wholeUrl);

        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "utf-8");
        System.out.println(data.toString());
        wr.write(data.toString());
        wr.flush();
        
        System.out.println(data.toString());

        // 显示 POST 请求返回的内容
        StringBuilder sb = new StringBuilder();
        int httpRspCode = conn.getResponseCode();
        String result;
        if (httpRspCode == HttpURLConnection.HTTP_OK) {
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            System.out.println(sb.toString());
            result = sb.toString();
        } else {
        	//result = new SmsSingleSenderResult();
        	result = httpRspCode +"http error " + httpRspCode + " " + conn.getResponseMessage();
        }
        return result;
	}
	

}
