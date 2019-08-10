package com.bridgelabz.fundoo.utility;

import java.util.Date;
import java.util.Properties;
import java.util.Queue;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundoo.user.dto.Userdto;

import lombok.experimental.UtilityClass;


@Component
public class Utility{

	@Autowired
	private TokenGenerator tokenUtil;
	
	@Autowired
	private static SimpleMailMessage simpleMailMessage;
//	
//	@Autowired
//	private static JavaMailSender javaMailSender;
//	   @Autowired
//	    public static JavaMailSender emailSender;
// 
//	
//	public  void send(String emailId, String subject, Long id) {
//		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//		JavaMailSender javaMailSender = new JavaMailSenderImpl();
//		System.out.println("EmaiId"+emailId+"subject"+subject+"UserId"+id);
//
//	   simpleMailMessage.setTo(emailId);
//		simpleMailMessage.setSubject(subject);
//		simpleMailMessage.setFrom("dhanappa94@gmail.com");
//		simpleMailMessage.setText(getUrl(id));
//		System.out.println("SMM"+simpleMailMessage);
//		emailSender.send(simpleMailMessage);
//		System.out.println("Email Sent SuccessFully");
//	}

	public static  void send(String toEmail, String subject, Long body) {
		final String fromEmail = "dhanappa94@gmail.com"; // requires valid gmail id
		final String password = "Dhanu@123"; // correct password for gmail id

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// to check email sender credentials are valid or not
	Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		javax.mail.Session session = Session.getInstance(props, auth);
	try {
		MimeMessage msg = new MimeMessage(session);

			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");

			msg.setFrom(new InternetAddress("dhanu@gmail.com", "FundooAPI"));

			msg.setReplyTo(InternetAddress.parse("dhanappa94@gmail.com", false));

			msg.setSubject(subject, "UTF-8");

			msg.setText(getUrl(body), "UTF-8");

			msg.setSentDate(new Date());

			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
			Transport.send(msg);

			System.out.println("Email Sent Successfully.........");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	 private JmsTemplate jmsTemplate;
//	    private Queue queue;
//	 
//	    // setters for jmsTemplate & queue
//	 
//	    public void simpleSend() {
//	        jmsTemplate.send(queue, s -> s.createTextMessage("hello queue world"));
//	    }
//
//	    public void sendMessage(Userdto userDto) { 
//	        System.out.println("Jms Message Sender : " +userDto); 
//	        Map<String, Object> map = new HashMap<>(); 
//	        map.put("name", userDto.getFirstName()); map.put("EmailId", userDto.getEmailId()); 
//	        jmsTemplate.convertAndSend(map); 
//	    }

	public static String getUrl(Long id) {

		TokenGenerator tokenUtil = new TokenGenerator();

		return "http://localhost:8080/user/" + tokenUtil.createToken(id);
	}

}