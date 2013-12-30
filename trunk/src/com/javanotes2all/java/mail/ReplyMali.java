package com.javanotes2all.java.mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

public class ReplyMali 
{

	public static void main(String args[]) throws Exception 
	{
		//working fine
		ReplyMali m=new ReplyMali();
		m.reply();
	}
	public void reply()
	{
		try
		{
		String host = "smtp.gmail.com";
		String username = "";
		String password = "";
		Date date = null;
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
		folder.open(Folder.READ_ONLY);
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
			for (int i = 0, n = message.length; i < n; i++) 
			{
				date = message[i].getSentDate();

				System.out.println(" " + (i + 1) + ": " + message[i].getFrom()[0] + "\t" +
						message[i].getSubject() + "  \t" + date.getDate() + "/" +
						date.getMonth() + "/" + (date.getYear() + 1900));
				System.out.print("Do you want to reply [y/n] : ");
				String ans = reader.readLine();
				if ("Y".equals(ans) || "y".equals(ans))
				{

					// Create a reply message
					MimeMessage reply = (MimeMessage) message[i].reply(false);

					// Set the from field
					reply.setFrom(message[i].getFrom()[0]);
					reply.setSubject("Reply message");
					// Create the reply content
					// Create the reply content, copying over the original if text
					MimeMessage orig = (MimeMessage) message[i];
					StringBuffer buffer = new StringBuffer("Thanks \n Prabhukumar Gade \n 9533051699 ");
					if (orig.isMimeType("text/plain")) {
						String content = (String) orig.getContent();
						StringReader contentReader = new StringReader(content);
						BufferedReader br = new BufferedReader(contentReader);
						String contentLine;
						while ((contentLine = br.readLine()) != null) {
							buffer.append("> ");
							buffer.append(contentLine);
							buffer.append("\r\n");
						}
					}
					// Set the content
					reply.setText(buffer.toString());

					// Send the message
					Transport.send(reply);
					System.out.println("message send successfully");
				} else if ("n".equals(ans)) 
				{
					//break;
				}
			}
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
