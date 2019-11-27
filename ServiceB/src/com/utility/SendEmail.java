package com.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport; 

public class SendEmail {
	
	public void prepareAndSendEmail(String stockSymbolAndTimeStamp){
		// email ID of Recipient. 
	      String recipientTO = "jairai.wipro@gmail.com"; 
	      String recipientCC = "jprai.job@gmail.com"; 
	  
	      // email ID of  Sender. 
	      String sender = "jprai.bits@gmail.com"; 
	      String password="Bitskeba@3";
	  
	      // using host as smpt 
	      String host = "smtp.gmail.com"; 
	  
	      // Getting system properties 
	      Properties properties = System.getProperties(); 
	  
	      // Setting up mail server 
	      properties.setProperty("mail.smtp.host", host); 
	      properties.put("mail.smtp.auth", "true");
	      properties.put("mail.smtp.starttls.enable", "true");
	      properties.put("mail.smtp.port", "25"); // default port 587

	  
	      // creating session object to get properties 
	     // Session session = Session.getDefaultInstance(properties); 
	      Session session = Session.getDefaultInstance(properties,  
	    		    new javax.mail.Authenticator() {
	    		       protected PasswordAuthentication getPasswordAuthentication() {  
	    		       return new PasswordAuthentication(sender,password);  
	    		   }  
	    		   });  
	  
	      try 
	      { 
	         // MimeMessage object. 
	         MimeMessage message = new MimeMessage(session); 
	  
	         // Set From Field: adding senders email to from field. 
	         message.setFrom(new InternetAddress(sender)); 
	  
	         // Set To Field: adding recipient's email to from field. 
	         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientTO, false));
	         message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(recipientCC, false)); 
	  
	         // Set Subject: subject of the email 
	         message.setSubject("Stock Update"); 
	  
	         // set body of the email. 
	         message.setText(stockSymbolAndTimeStamp); 
	  
	         // Send email. 
	         //Transport.send(message); 
	         
	      // Get SMTPTransport
	            SMTPTransport transport = (SMTPTransport) session.getTransport("smtp");
	         // connect
	            transport.connect(host, sender,password);
				
				// send
	            transport.sendMessage(message, message.getAllRecipients());
	      } 
	      catch (Exception mex)  
	      { 
	         mex.printStackTrace(); 
	      } 
	   } 
	

}
