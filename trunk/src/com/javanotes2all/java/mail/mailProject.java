package com.javanotes2all.java.mail;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
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

public class mailProject 
{

	public static void main(String[] args) throws Exception
	{
		mailProject mproj=new mailProject();
		System.out.println("menu");
		System.out.println("1.read mail");
		System.out.println("2. reply");
		System.out.println("3. farward mail");
		System.out.println("4. delete mail");
		System.out.println("5. send email");
		System.out.println("6. send attachment");
		System.out.println("exit. to exit");
		BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
		boolean check=true;
		while(check)
		{
			System.out.println("enter option number");
			String option=breader.readLine().trim();
			if(option.equalsIgnoreCase("1"))
				mproj.readmail();
			else if(option.equalsIgnoreCase("2"))
				mproj.reply();
			else if(option.equalsIgnoreCase("3"))
				mproj.fwdmail();
			else if(option.equalsIgnoreCase("4"))
				mproj.deletemail();
			else if(option.equalsIgnoreCase("5"))
				mproj.sendemails();
			else if(option.equalsIgnoreCase("6"))
				mproj.sendAttachments();
			else if(option.equalsIgnoreCase("exit"))
				mproj.sendAttachments();
			else
				System.out.println("enter corect option");
		}

	}
	public void readmail() 
	{
		try
		{
			//working fine
			String host = "smtp.gmail.com";
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter from email");
			String username=breader.readLine().trim();
			System.out.println("enter password");
			String password=breader.readLine().trim();

			Properties properties = System.getProperties();
			Session session = Session.getDefaultInstance(properties);
			Store store = session.getStore("imaps");
			store.connect(host, username, password);
			Folder folder = store.getFolder("inbox");
			if (!folder.exists()) {
				System.out.println("No INBOX...");
				System.exit(0);
			}
			folder.open(Folder.READ_WRITE);
			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message msg[] = folder.search(ft);

			for (int i = 0; i < msg.length; i++) {
				System.out.println("------------ Message " + (i + 1) + " ------------");
				String from = InternetAddress.toString(msg[i].getFrom());
				if (from != null) {
					System.out.println("From: " + from);
				}

				String replyTo = InternetAddress.toString(
						msg[i].getReplyTo());
				if (replyTo != null) {
					System.out.println("Reply-to: " + replyTo);
				}
				String to = InternetAddress.toString(
						msg[i].getRecipients(Message.RecipientType.TO));
				if (to != null) {
					System.out.println("To: " + to);
				}

				String subject = msg[i].getSubject();
				if (subject != null) {
					System.out.println("Subject: " + subject);
				}
				Date sent = msg[i].getSentDate();
				if (sent != null) {
					System.out.println("Sent: " + sent);
				}

				System.out.println();
				System.out.println("Message : ");

				Multipart multipart = (Multipart) msg[i].getContent();

				for (int x = 0; x < multipart.getCount(); x++) 
				{
					BodyPart bodyPart = multipart.getBodyPart(x);

					String disposition = bodyPart.getDisposition();

					if (disposition != null && (disposition.equals(BodyPart.ATTACHMENT))) {
						System.out.println("Mail have some attachment : ");

						DataHandler handler = bodyPart.getDataHandler();
						System.out.println("file name : " + handler.getName());
					} else {
						System.out.println(bodyPart.getContent());
					}
				}
				System.out.println();
			}
			System.out.println("no mails");
			folder.close(true);
			store.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	//send email for with html image
	public void sendemails()
	{
		try
		{
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter from email");
			String username=breader.readLine().trim();
			System.out.println("enter password");
			String password=breader.readLine().trim();
			System.out.println("enter to email");
			String to=breader.readLine().trim();
			System.out.println("enter image path");
			String url=breader.readLine().trim();
			System.out.println("enter subject");
			String subject=breader.readLine().trim();
			System.out.println("enter body");
			String body=breader.readLine().trim();
			String servername="smtp.gmail.com";
			Properties props = System.getProperties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", servername);
			props.put("mail.smtp.user", username);
			props.put("mail.smtp.password", password);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");
			//props.put("mail.debug", "true");

			Session sessions = Session.getInstance(props,  new GMailAuthenticator(username, password));
			MimeMessage message = new MimeMessage(sessions);
			Address fromAddress = new InternetAddress(username);
			//Address toAddress = new InternetAddress(emailTo);

			message.setFrom(fromAddress);
			message.addRecipients(Message.RecipientType.TO, to);

			message.setSubject(subject);
			String str = "<html><h1>Hello</h1></br>  <h6>"+body+"</h6>" + 
					"<img src=\"cid:image_cid\">" +
					"<img border=0 src="+url+" alt=abc width=304 height=228 /></html>";  
			MimeMultipart multipart = new MimeMultipart();  

			// Create bodypart.  
			BodyPart bodyPart = new MimeBodyPart();  
			// Set the MIME-type to HTML.  
			bodyPart.setContent(str, "text/html");  

			// Add the HTML bodypart to the multipart.  
			multipart.addBodyPart(bodyPart);  

			// Create another bodypart to include the image attachment.  
			bodyPart = new MimeBodyPart();  

			// Read image from file system.  
			DataSource ds = new FileDataSource("/home/prabhu/image.jpg");  
			bodyPart.setDataHandler(new DataHandler(ds));  

			// Set the content-ID of the image attachment.  
			// Enclose the image CID with the lesser and greater signs.  
			bodyPart.setHeader("Content-ID", "<image_cid>");  

			// Add image attachment to multipart.  
			multipart.addBodyPart(bodyPart);  

			// Add multipart content to message.  
			message.setContent(multipart);
			Transport transport = sessions.getTransport("smtp");
			transport.connect(servername, username, password);
			message.saveChanges();
			Transport.send(message);
			transport.close();
			System.out.println("send email successfully");

		} catch (MessagingException mex) {
			mex.printStackTrace();
			Exception ex = null;
			if ((ex = mex.getNextException()) != null) {
				ex.printStackTrace();
			}
		} catch (Exception ioex) {
			ioex.printStackTrace();
		}


	}
	//send attachments
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
			// String filename="/home/prabhu/projects/javaEE1/narmaljava.zip";
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
			msg.setFrom(new InternetAddress(username));
			msg.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
			BodyPart msgBP=new MimeBodyPart();
			msgBP.setText("Take a look at this\n");
			Multipart mPart=new MimeMultipart();
			mPart.addBodyPart(msgBP);
			msgBP=new MimeBodyPart();
			DataSource src=new FileDataSource(filename);
			msgBP.setDataHandler(new DataHandler(src));
			msgBP.setFileName(filename);
			mPart.addBodyPart(msgBP);
			msg.setContent(mPart);
			Transport.send(msg);
			System.out.println("mail sent");
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}
	//reply to mail
	public void reply()
	{
		try
		{
			String host = "smtp.gmail.com";
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter from email");
			String username=breader.readLine().trim();
			System.out.println("enter password");
			String password=breader.readLine().trim();
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
	//forward the email
	public void fwdmail()
	{
		//working fine
		try
		{
			boolean deleteStatus=false;
			String host = "smtp.gmail.com";
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter from email");
			String username=breader.readLine().trim();
			System.out.println("enter password");
			String password=breader.readLine().trim();
			System.out.println("enter forward to email");
			String to=breader.readLine().trim();
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
			folder.open(Folder.READ_WRITE);
			//for getting unread messages only
			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message message[] = folder.search(ft);
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

			//for all messages 
			//Message[] message = folder.getMessages();
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
						fwd.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
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
	//for deleting the mail
	public void deletemail()
	{
		//working fine
		try
		{
			boolean deleteStatus=false;
			String host = "smtp.gmail.com";
			BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter from email");
			String username=breader.readLine().trim();
			System.out.println("enter password");
			String password=breader.readLine().trim();
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
					System.out.println(i+"  :  "+message[i].getFrom()[0] +message[i].getSubject());
					System.out.println("Do u want to delete message :[y/n]");
					String line=reader.readLine();
					if("Y".equalsIgnoreCase(line))
					{
						message[i].setFlag(Flags.Flag.DELETED,true);
						deleteStatus=true;
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
