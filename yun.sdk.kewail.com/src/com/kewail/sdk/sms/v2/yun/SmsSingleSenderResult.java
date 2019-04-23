package com.kewail.sdk.sms.v2.yun;

public class SmsSingleSenderResult {
/*
{
    "result": 0,
    "errmsg": "OK", 
    "ext": "", 
    "sid": "xxxxxxx", 
    "fee": 1
}
 */
	public int result;
	public String errMsg = "";
	public String ext = "";
	public String sid = "";
	
	
	public String toString() {
		return String.format(
				"SmsSingleSenderResult\nresult %d\nerrMsg %s\next %s\nsid %s\n",
				result, errMsg, ext, sid);		
	}
}
