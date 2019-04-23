package com.kewail.sdk.sms.v2;

import java.util.ArrayList;
import java.util.List;

import com.kewail.sdk.sms.v2.yun.SmsSingleSender;
import com.kewail.sdk.sms.v2.yun.SmsSingleSenderResult;
import com.kewail.sdk.sms.v2.yun.SmsVoiceVerifyCodeSender;
import com.kewail.sdk.sms.v2.yun.SmsVoiceVerifyCodeSenderResult;

public class SmsSDKDemoV2 {
    public static void main(String[] args) {
    	try {
    		//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
    		//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
//    		String accesskey = "5a4606f90cf288c32bcfb70a";
//    		String secretkey = "88c70edb0dca45fe89843d391068af2a";
    		String accesskey = "5c9b25eec6e73d5db4bcb4bf";
    		String secretkey = "1a42865d5e73486da7ac1692c222ccef";
    		
    		//type:0普通短信 1营销短信
    		int type=0;
    		//国家区号
    		String nationcode="86";
    		//手机号码
    		String phoneNumber = "15016387583";
    		//短信签名ID (登录后台页面获取)
    		String signId="5aa7ef278475af0e19b05f5b";
    		//模板ID(登录后台页面获取)
    		String templateId="5ca1deb0c6e73d60446d38c6";
    		//短信模板的变量值 ，将短信模板中的变量{0},{1}替换为参数中的值，如果短信模板中没有变量，则这个值填null
    		List<String> params=new ArrayList<String>();
    		//模板中存在多个可变参数，可以添加对应的值。
    		params.add("玉玉");
    		params.add("363665");
    		params.add("及");
    		//自定义字段，用户可以根据自己的需要来使用
    		String ext="";
    		
    		
    		 //初始化单发
	    	SmsSingleSender singleSender = new SmsSingleSender(accesskey, secretkey);
	    	SmsSingleSenderResult singleSenderResult;
	    	 //普通单发,注意前面必须为【】符号包含，置于头或者尾部。
	    	singleSenderResult = singleSender.send(type, nationcode, phoneNumber, signId, templateId, params, ext);
	    	System.out.println(singleSenderResult);
	    	
	    	
	    	//语音验证码发送
//    		SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(accesskey,secretkey);
//    		SmsVoiceVerifyCodeSenderResult smsVoiceVerifyCodeSenderResult = smsVoiceVerifyCodeSender.send("86",phoneNumber, "444144",2,"");
//    		System.out.println(smsVoiceVerifyCodeSenderResult);

    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
