package com.kewail.sdk.sms.v1;

import com.kewail.sdk.sms.v1.yun.SmsTemplateSender;

/**
 * 短信模板
 * 添加短信模板，修改短信模板，查询短信模板
 */
public class SmsTemplateDemoV1 {
    public static void main(String[] args) {
    	try {
    		//请根据实际 accesskey 和 secretkey 进行开发，以下只作为演示 sdk 使用
    		String accesskey = "5a4606f90cf288c32bcfb70a";
    		String secretkey = "88c70edb0dca45fe89843d391068af2a";
    		
    		//添加短信模板
    		saveTemplate(accesskey,secretkey);
    		
    		//更新短信模板
    		//updateTemplate(accesskey,secretkey);
    		
    		//查新短信模板
    		findTemplate(accesskey,secretkey);


    	} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    
    ////添加短信模板
    public static void saveTemplate(String accesskey,String secretkey) {
    	try {
    		String url="https://live.kewail.com/sms/v1/saveTemplate";
    		String content="测试模板";
    		   //短信模板
    		SmsTemplateSender templdateSender = new SmsTemplateSender(accesskey, secretkey);
    		String  respResult= templdateSender.saveSmsTemplate(url, content);
        	System.out.println(respResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    
    ////修改短信模板
    public static void updateTemplate(String accesskey,String secretkey) {
    	try {
    		String url="https://live.kewail.com/sms/v1/updateTemplate";
    		String content="测试模板2";
    		String templateId="xxx";
    		   //短信模板
    		SmsTemplateSender templdateSender = new SmsTemplateSender(accesskey, secretkey);
    		String  respResult= templdateSender.updateSmsTemplate(url, templateId, content);
        	System.out.println(respResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    ////查询短信模板
    public static void findTemplate(String accesskey,String secretkey) {
    	try {
    		String url="https://live.kewail.com/sms/v1/findTemplate";
    		String templateId="xxx";
    		   //短信模板
    		SmsTemplateSender templdateSender = new SmsTemplateSender(accesskey, secretkey);
    		String  respResult= templdateSender.findSmsTemplate(url, templateId);
        	System.out.println(respResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    }
    
    
    
}
