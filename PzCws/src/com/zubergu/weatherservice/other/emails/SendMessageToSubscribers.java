package com.zubergu.weatherservice.other.emails;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.zubergu.weatherservice.persistence.entities.Subscriber;

public class SendMessageToSubscribers {
    
    public void execute(List<Subscriber> subscribers, String msg) {
	final String from = "cws.konto@gmail.com";
	String host = "smtp.gmail.com";
	final String password = "CwsAdmin123";
	
	
	Properties props = new Properties();
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");
	
	Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		  });
	System.out.println("session created");
	
	for(Subscriber s: subscribers) {
	    String to = s.getEmail();
	    
	    try{
	         
	         MimeMessage message = new MimeMessage(session);

	         message.setFrom(new InternetAddress(from));

	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         message.setSubject("Message from Cracow Weather Station");

	         message.setText(msg);
	         System.out.println("...ASDFB");
	         Transport.send(message);
	         System.out.println("Message send succesfully");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	    
	}
    }
}
