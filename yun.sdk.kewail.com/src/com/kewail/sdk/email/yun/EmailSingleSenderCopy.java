package com.kewail.sdk.email.yun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

import org.json.JSONObject;

public class EmailSingleSenderCopy {

	String accesskey;
	String secretkey;
	String url = "https://live.kewail.com/directmail/v1/singleSendMail";
	public EmailSingleSenderCopy(String accesskey, String secretkey) {
		this.accesskey = accesskey;
		this.secretkey = secretkey;
	}
	EmailSenderUtil util=new EmailSenderUtil();
	public EmailSingleSenderResult send(
			int type,
			String fromEmail,
			String toEmail,
			String fromAlias,
			boolean needToReply,
			String replyEmail,
			String subject,
			String htmlBody,
			String clickTrace,
			String readTrace,
			String ext
			)throws Exception{
		
		if(type<0||type>1) {
			type=0;
		}
		if(ext==null) {
			ext="";
		}
		long curTime=System.currentTimeMillis()/1000;
		int random = util.getRandom();
		JSONObject data=new JSONObject();
		data.put("sig", util.strToHash(String.format("secretkey=%s&random=%d&time=%d&fromEmail=%s",
				secretkey,random,curTime,fromEmail)));
		data.put("time", curTime);
        data.put("type", type);
        data.put("fromEmail", fromEmail);
        data.put("needToReply", needToReply);
        data.put("toEmail", toEmail);
        data.put("fromAlias", fromAlias);
        data.put("subject", subject);
        data.put("htmlBody", htmlBody);
        data.put("clickTrace", clickTrace);
        data.put("readTrace", readTrace);
        
        data.put("ext", ext);
		
        if(needToReply) {
        	
        	data.put("replyEmail", replyEmail);
        	
        }else {
        	data.put("replyEmail", "");
        }
        
        String wholeUrl=String.format("%s?accesskey=%s&random=%d", url, accesskey, random);
        
        HttpURLConnection conn = util.getPostHttpConn(wholeUrl);
        OutputStreamWriter writer=new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
        
        writer.write(data.toString());
        writer.flush();
        writer.close();
        
        StringBuilder sb=new StringBuilder();
        
        int responseCode = conn.getResponseCode();
        
        EmailSingleSenderResult result;
        
        if(responseCode==HttpURLConnection.HTTP_OK) {
        	BufferedReader sr=new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        	String line=null;
        	while((line=sr.readLine())!=null) {
        		sb.append(line);
        	}
        	sr.close();
        	JSONObject json=new JSONObject(sb.toString());
        	result=util.jsonToSmsSingleSenderResult(json);
        }else {
        	result=new EmailSingleSenderResult();
        	result.result=responseCode;
        	result.errmsg=responseCode+conn.getResponseMessage();
        }
        
        
        
        
		return result;
	}
}
