package com.meeting.util;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;/**
* 邮件发送操作类
*
*
*/
public class MailOperation {
	/**
	* 发送邮件
	* @param to 接收者邮箱
	* @param subject 邮件主题
	* @param content 邮件内容
	* @return success 发送成功 failure 发送失败
	* @throws Exception
	*/
	private static String fromEmail="690063655@qq.com";//发件人邮箱
	private static  String fromName="690063655@qq.com";//发件人邮箱
	private static String password = "udcihehrndfwbbgc";//授权码
	private static  String host="smtp.qq.com";
	public static String sendMail(String to, String subject, String content)
	throws Exception {
		if (to != null){
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			MailAuthenticator auth = new MailAuthenticator();
			MailAuthenticator.USERNAME = fromEmail;
			MailAuthenticator.PASSWORD = password;
			Session session = Session.getInstance(props, auth);
			session.setDebug(true);
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(fromName));
				if (!to.trim().equals(""))
				message.addRecipient(Message.RecipientType.TO,
				new InternetAddress(to.trim()));
				message.setSubject(subject);
				MimeBodyPart mbp1 = new MimeBodyPart(); // 正文
				mbp1.setContent(content, "text/html;charset=utf-8");
				Multipart mp = new MimeMultipart(); // 整个邮件：正文+附件
				mp.addBodyPart(mbp1);
				// mp.addBodyPart(mbp2);
				message.setContent(mp);
				message.setSentDate(new Date());
				message.saveChanges();
				Transport trans = session.getTransport("smtp");
				trans.send(message);
				System.out.println(message.toString());
			} catch (Exception e){
				e.printStackTrace();
				return "failure";
			}
			return "success";
		}else{
			return "failure";
		}
	}
}
