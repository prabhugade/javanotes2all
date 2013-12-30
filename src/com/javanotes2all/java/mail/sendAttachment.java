package com.javanotes2all.java.mail;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class sendAttachment
{
  public static void main(String args[])throws Exception
  {
	  sendAttachment att=new sendAttachment();
	  att.sendAttachments();
  }
  public void sendAttachments()
  {
	  //working fine
	  try
	  {
	    String host = "smtp.gmail.com";
		String username = "";
		String password = ""; 	
		String from=username;
		String to="kumarprabhug@gmail.com";
		String filename="/home/prabhu/Desktop/pdftest/test/pdf.pdf";
		Properties props = System.getProperties();
	    props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		//props.put("mail.debug", "true");
		Session session = Session.getInstance(props,  new GMailAuthenticator(username, password));
	    
		Message msg=new MimeMessage(session);
		msg.setSubject("Photo Attached");
		msg.setFrom(new InternetAddress(from));
		msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		BodyPart msgBP=new MimeBodyPart();
		msgBP.setText("Take a look at this\n");
		Multipart mPart=new MimeMultipart();
		mPart.addBodyPart(msgBP);
		msgBP=new MimeBodyPart();
		DataSource src=new FileDataSource(filename);
	    msgBP.setDataHandler(new DataHandler(src));
	    msgBP.setFileName("bill.pdf");
		mPart.addBodyPart(msgBP);
	    msg.setContent(mPart);
	    Transport.send(msg);
		System.out.println("mail sent");
	  }catch(Exception e)
	  {
		  System.out.println(e);
	  }

  }
  class GMailAuthenticator extends Authenticator 
	{
	    String user;
	    String pw;
	    public GMailAuthenticator (String username, String password)
	    {
	       super();
	       this.user = username;
	       this.pw = password;
	    }
	   public PasswordAuthentication getPasswordAuthentication()
	   {
	      return new PasswordAuthentication(user, pw);
	   }
	}
}