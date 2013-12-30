package com.javanotes2all.java.mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
public class forwardEmail
{
  public static void main(String args[])throws Exception
  {
	  forwardEmail email=new forwardEmail();
	  email.fwdmail();
  }
  public void fwdmail()
	{
	  //working fine
		try
		{
		boolean deleteStatus=false;
		String host = "smtp.gmail.com";
		String username = "";
		String password = "";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		//props.put("mail.debug", "true");
		Session session = Session.getInstance(props,  new GMailAuthenticator(username, password));

		Store store = session.getStore("imaps");
		store.connect(host, username, password);

		Folder folder = store.getFolder("Inbox");
		if (!folder.exists()) {
			System.out.println("inbox not found");
			System.exit(0);
		}
		folder.open(Folder.READ_WRITE);
		//for getting unread messages only
		FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
    Message message[] = folder.search(ft);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//for all messages 
		//Message[] message = folder.getMessages();
		System.out.println("message length"+message.length);
		if (message.length != 0) 
		{
			System.out.println("no. From \t\tSubject \t\tDate");
			 for(int i=0,n=message.length;i<n;i++)
			  {
				 System.out.println(i+"  :  "+message[i].getFrom()[0] +"\t"+message[i].getSubject());
				  System.out.println("Do u want to forward the message :[y/n]");
				  String line=reader.readLine();
				  if("Y".equalsIgnoreCase(line))
					{
					  Message fwd=new MimeMessage(session);
					  fwd.setSubject("Fwd  : "+message[i].getSubject());
					  fwd.setFrom(new InternetAddress(username));
					  fwd.addRecipient(Message.RecipientType.TO,new InternetAddress("kumarprabhug@gmail.com"));
					  BodyPart msgBP=new MimeBodyPart();
					  msgBP.setText("Your message goes here \n");
					  Multipart mPart=new MimeMultipart();
					  mPart.addBodyPart(msgBP);
					  msgBP=new MimeBodyPart();
					  msgBP.setDataHandler(message[i].getDataHandler());
					  mPart.addBodyPart(msgBP);
					  fwd.setContent(mPart);
					  Transport.send(fwd);
					}
			 	  
			  }
			  System.out.println("no messages");
			  folder.close(deleteStatus);
			  store.close();
			System.out.println("messages completed");

		} else {
			System.out.println("There is no msg....");
		}
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
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