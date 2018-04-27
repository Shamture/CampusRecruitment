package com.controller;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	

	/**
	 * @param args
	 */
	   public  static void postMail(String to, String sub){
		      //  String fileAttachment ="C:/Documents and Settings/idealabs/workspace/JavaMail/files/arrexcp.java";
		        Properties props = new Properties();
		        props.put("mail.smtp.host", "smtp.gmail.com");
		        props.put("mail.smtp.socketFactory.port", "465");
		        props.put("mail.smtp.socketFactory.class",
		        "javax.net.ssl.SSLSocketFactory");
		        props.put("mail.smtp.auth", "true");
		        props.put("mail.smtp.port", "465");

		        Session session = Session.getDefaultInstance(props,
		        new javax.mail.Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() 
		{
		        return new PasswordAuthentication("campusrecruitmentportal@gmail.com","campus@123");
		        }
		        });

		        try {
		        Message message = new MimeMessage(session);
		        message.setFrom(new InternetAddress("campusrecruitmentportal@gmail.com"));
		        message.setRecipients(Message.RecipientType.TO,
		        InternetAddress.parse(to));
		        message.setSubject("password ");
		        message.setText("your password is"+sub);
		        /* Multipart multipart = new MimeMultipart();
		    hi friends this commented code for file attachment .....at the begining one more line is also for file attachment only
		        MimeBodyPart messageBodyPart = 
		              new MimeBodyPart();
		        //messageBodyPart = new MimeBodyPart();
		         multipart.addBodyPart(messageBodyPart);
		        DataSource source = 
		              new FileDataSource(fileAttachment);
		        
		            messageBodyPart.setDataHandler(
		              new DataHandler(source));
		            messageBodyPart.setFileName(fileAttachment);
		            multipart.addBodyPart(messageBodyPart);
		            message.setContent(multipart);*/

		        Transport.send(message);

		        System.out.println("Done");
		        } catch (MessagingException e) {
		        throw new RuntimeException(e);
		        }

		        }

	

}
