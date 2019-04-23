package com.kewail.sdk.sms.v1;

import com.kewail.sdk.sms.v1.yun.SmsSingleSender;
import com.kewail.sdk.sms.v1.yun.SmsSingleSenderResult;
import com.kewail.sdk.sms.v1.yun.SmsVoiceVerifyCodeSender;
import com.kewail.sdk.sms.v1.yun.SmsVoiceVerifyCodeSenderResult;

/**
 * 发送短信
 */
public class SmsSDKDemoV1 {
    public static void main(String[] args) {
    	try {
    		//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
    		//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
    		String accesskey = "5c89d26487b65f7e798bbbc9";
    		String secretkey = "0a24c828e51a40b5b3849823be728a13";
    		//手机号码
    		String phoneNumber = "18665930227";
    		long beginTime=System.currentTimeMillis();
    		 //初始化单发
	    	SmsSingleSender singleSender = new SmsSingleSender(accesskey, secretkey);
	    	SmsSingleSenderResult singleSenderResult;
	
	    	 //普通单发,注意前面必须为【】符号包含，置于头或者尾部。
	    	singleSenderResult = singleSender.send(0, "86", phoneNumber, "【Kewail科技】您注册的验证码：35558有效时间30分钟。", "", "");
	    	System.out.println(singleSenderResult);
	    	long endTime=System.currentTimeMillis();
	    	System.out.println(endTime-beginTime);
	    	
	    	//语音验证码发送
//    		SmsVoiceVerifyCodeSender smsVoiceVerifyCodeSender = new SmsVoiceVerifyCodeSender(accesskey,secretkey);
//    		SmsVoiceVerifyCodeSenderResult smsVoiceVerifyCodeSenderResult = smsVoiceVerifyCodeSender.send("86",phoneNumber, "369865",2,"");
//    		System.out.println(smsVoiceVerifyCodeSenderResult);

    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
