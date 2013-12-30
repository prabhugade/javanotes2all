package com.javanotes2all.java.mail;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
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

public class SendFilesInDirectory 
{
public static void main(String[] args) 
{
	SendFilesInDirectory send=new SendFilesInDirectory();
	send.sendAttachments();
}
public void sendAttachments()
{
	//working fine
	try
	{
		String host = "smtp.gmail.com";
		BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter from email");
		String username=breader.readLine().trim();
		System.out.println("enter password");
		String password=breader.readLine().trim();
		System.out.println("enter to email");
		String to=breader.readLine().trim();
		System.out.println("enter attach file path");
		String filename=breader.readLine().trim();
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", username);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(props,  new GMailAuthenticator(username, password));

		Message msg=new MimeMessage(session);
		msg.setSubject("File Attached");
		msg.setFrom(new InternetAddress(username));
		msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		BodyPart msgBP=new MimeBodyPart();
		msgBP.setText("Take a look at this\n");
		Multipart mPart=new MimeMultipart();
		mPart.addBodyPart(msgBP);
		addAttachments(mPart,filename,0);
		msg.setContent(mPart);
		Transport.send(msg);
		System.out.println("mail sent");
	}catch(Exception e)
	{
		System.out.println(e);
	}

}
public void addAttachments(Multipart mPart,String filepath,long size)
{
	try
	{
		File dir=new File(filepath);
		if(dir.isDirectory())
		{
			for (File file : dir.listFiles()) 
			{
				if (file.isFile()) 
				{
					BodyPart msgBP=new MimeBodyPart();
					DataSource src=new FileDataSource(file.getPath());
					msgBP.setDataHandler(new DataHandler(src));
					msgBP.setFileName(file.getName());
					mPart.addBodyPart(msgBP);
					size += file.length();
				}
				else
					addAttachments(mPart,file.getName(),size);
			}
		}else if(dir.isFile())
		{
			size += dir.length();
		}

		double sizeInMB =(double)size / 1024 / 1024;
		String s="MB";
		if(sizeInMB<1)
		{
			sizeInMB=(double)size / 1024;
			s="KB";
		}
		System.out.println("file size"+sizeInMB+" "+s);

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
