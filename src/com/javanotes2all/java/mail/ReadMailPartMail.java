package com.javanotes2all.java.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.FlagTerm;

public class ReadMailPartMail {

  public static void main(String args[]) throws Exception 
  {
	  //working fine
	  String host = "smtp.mail.yahoo.com";
	  //String host="smtp.gmail.com";
	  String username = "";
	  String passwoed = "";

	  Properties properties = System.getProperties();
	  Session session = Session.getDefaultInstance(properties);
	  Store store = session.getStore("imaps");
	  store.connect(host, username, passwoed);
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
  }
} 