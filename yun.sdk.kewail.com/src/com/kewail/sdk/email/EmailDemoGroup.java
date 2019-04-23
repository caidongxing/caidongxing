package com.kewail.sdk.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.kewail.sdk.email.yun.EmailSingleSender;
import com.kewail.sdk.email.yun.EmailSingleSenderCopy;
import com.kewail.sdk.email.yun.EmailSingleSenderResult;

public class EmailDemoGroup implements Runnable{
	 
	 @SuppressWarnings("resource")
	public static void main(String[] args) {
		 
		 new Thread(new EmailDemoGroup()).start();
		 
		 /* 读入TXT文件 */  
        			// 使用ArrayList来存储每行读取到的字符串
        			/*ArrayList<String> arrayList = new ArrayList<>();
        			try {
        				String pathname = "c:\\Users\\walki\\Desktop\\test.txt";
        				File name = new File(pathname);
        				FileReader fr = new FileReader(name);
        				BufferedReader bf = new BufferedReader(fr);
        				String str;
        				// 按行读取字符串
        				while ((str = bf.readLine()) != null) {
        					arrayList.add(str);
        				}
        				bf.close();
        				fr.close();
        				Iterator<String> iterator = arrayList.iterator();
        				while (iterator.hasNext()) {
        					String next = iterator.next();
        					sendEmail(next);
						}
        				String pathName="c:\\Users\\walki\\Desktop\\test.txt";
        				File fileName=new File(pathName);
        				FileReader fileReader=new FileReader(fileName);
        				BufferedReader bufferedReader=new BufferedReader(fileReader);
        				String str;
        				while((str=bufferedReader.readLine())!=null) {
        					arrayList.add(str);
        				}
        				Iterator<String> iterator = arrayList.iterator();
        				int remark=1;
        				while(iterator.hasNext()) {
        					String iteratorValue=iterator.next();
        					sendEmail(iteratorValue);
        					System.out.println("发送了===============================>>"+remark++);
        				}
        			} catch (IOException e) {
        				e.printStackTrace();
        			}*/
	}
	 
	 public static void sendEmail(String s) {
		 try {
			
			String accesskey="5c27553387b65f2bc9a04137";
			String secretkey="980cf4abb40742e7855955f381b0f561";
			EmailSingleSenderCopy singleSender=new EmailSingleSenderCopy(accesskey, secretkey);
			// 邮件类型，0 事务投递，其他的为商业投递量
			int type=1;
			String fromEmail="service@caidongxing.online";
			/*String toEmail="caidongxing8888@163.com";*/
			String toEmail=s;
			String fromAlias="caidongxing.online";
			boolean needToReply=true;
			String replyEmail="caidongxing8888@163.com";
			String subject="邮件测试";
			String htmlBody="2019年首届自动化与人工智能前沿峰会<br/>\r\n" + 
					"会议通知\r\n" + 
					"首届自动化与人工智能前沿峰会由东北大学流程工业综合自动化国家重点实验室主办，定于2019年7月22日—25日在“一朝发祥地，两代帝王都”的历史名城——沈阳举行。谨代表大会总主席柴天佑院士，热忱欢迎您参会。\r\n" + 
					"自动化技术一直推动着科技和社会进步。随着近年大数据技术发展与计算能力提升，人工智能取得迅猛发展。世界各国都把人工智能作为推动各行业发展的新引擎和加速器。随着大数据的涌现、人工智能的崛起，自动化技术已经进入万物互联、高度智能的新格局。智能化和自动化的深度融合成为解决行业困境的主要途径，其基础理论和关键技术支撑就是信息物理融合系统。数据和信息在人类社会、物理空间和信息空间的交叉融合和相互作用，使得人工智能的基本理论和方法产生了新的变化，这些变化促使人工智能在传感与执行、数据与网络、控制与优化、安全与可靠、物流与商务、设计与制造等层面展现出强大的威力。\r\n" + 
					"为了推动自动化与人工智能的融合发展及其在各行业的应用，特举办自动化与人工智能前沿峰会。本次会议以“信息系统与物理系统融合、深化自动化与人工智能融合”为主题，为海内外自动化与人工智能领域的专家、学者、研究生及工程技术人员提供一个学术交流、研讨和报告最新研究成果和技术方向的平台。\r\n" + 
					"若您多次收到此邮件，我们深表歉意！\r\n" + 
					"\r\n" + 
					"自动化与人工智能前沿峰会由三部分组成：\r\n" + 
					" \r\n" + 
					"1. 首届工业人工智能国际会议（1st International Conference on Industrial Artificial Intelligence, IAI 2019）\r\n" + 
					"首届工业人工智能国际会议是由东北大学流程工业综合自动化国家重点实验室主办，IEEE Computational Intelligence Society、IEEE Industrial Electronics Society、中国自动化学会大数据专业委员会协办的国际会议。主题包含但不限于：智能感知与建模、计算智能、智能控制与数据驱动控制、运行优化决策、故障诊断与预测、动态性能评估与预测维护、工业应用。\r\n" + 
					" \r\n" + 
					"2. 自动化与人工智能前沿论坛\r\n" + 
					"第四届中国非线性系统与控制研讨会\r\n" + 
					"非线性系统动态优化与控制论坛\r\n" + 
					"新一代人工智能论坛\r\n" + 
					"大数据科学论坛\r\n" + 
					"神经网络论坛\r\n" + 
					"进化计算论坛\r\n" + 
					"时滞系统控制论坛\r\n" + 
					"流程工业智能优化制造论坛\r\n" + 
					"未来自动化发展方向论坛\r\n" + 
					"更多论坛正在筹划中 \r\n" + 
					"";
			String clickTrace="1";
			String readTrace="1";
			String ext="这是扩展的东西";
			long beginTime=System.currentTimeMillis();
			EmailSingleSenderResult singleSenderResult = singleSender.send(type, fromEmail, toEmail, fromAlias, needToReply, replyEmail, subject, htmlBody, clickTrace, readTrace, ext);
			 long endTime=System.currentTimeMillis();
			System.out.println(endTime-beginTime);
			System.out.println(singleSenderResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	 
		  
	 public  String readFileAsString(String filePath) throws IOException {
		// 获取file
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException(filePath);
		}
		// 限制大小
		if (file.length() > 1024 * 1024 * 1024) {
			throw new IOException("File is too large");
		}
		StringBuilder sb = new StringBuilder((int) (file.length()));
		FileInputStream fis = new FileInputStream(filePath);
		byte[] bbuf = new byte[10240];
		int hasRead = 0;
		while ((hasRead = fis.read(bbuf)) > 0) {
			sb.append(new String(bbuf, 0, hasRead));
		}
		fis.close();
		return sb.toString();
	 }

	@Override
	public void run() {
		ArrayList<String> arrayList = new ArrayList<>();
		try {
			/*String pathname = "c:\\Users\\walki\\Desktop\\test.txt";
			File name = new File(pathname);
			FileReader fr = new FileReader(name);
			BufferedReader bf = new BufferedReader(fr);
			String str;
			// 按行读取字符串
			while ((str = bf.readLine()) != null) {
				arrayList.add(str);
			}
			bf.close();
			fr.close();
			Iterator<String> iterator = arrayList.iterator();
			while (iterator.hasNext()) {
				String next = iterator.next();
				sendEmail(next);
			}*/
			String pathName="c:\\Users\\walki\\Desktop\\test.txt";
			File fileName=new File(pathName);
			FileReader fileReader=new FileReader(fileName);
			BufferedReader bufferedReader=new BufferedReader(fileReader);
			String str;
			while((str=bufferedReader.readLine())!=null) {
				arrayList.add(str);
			}
			Iterator<String> iterator = arrayList.iterator();
			int remark=1;
			while(iterator.hasNext()) {
				String iteratorValue=iterator.next();
				for(int i=0;i<10;i++) {
				sendEmail(iteratorValue);
				System.out.println("发送了===============================>>"+remark++);
				System.out.println("等待===");
			
				try {
					if(remark>5) {
					remark=1;
					Thread.sleep(1000*60);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	 }
	 
