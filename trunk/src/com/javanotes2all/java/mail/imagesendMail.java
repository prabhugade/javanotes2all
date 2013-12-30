package com.javanotes2all.java.mail;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class imagesendMail 
{ 

	public static void main(String[] args) throws Exception
	{
		imagesendMail mail=new imagesendMail();
		String path=mail.downloadImage("http://dl.dropbox.com/u/93882717/occasion/bitrhday.jpg");
		mail.sendemails(path);
	}
	public void sendemails(String path)
	{
		try
		{
			String username="";
			String password="";
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
			String toAddresses = "prabhu@silicaminds.com";
			message.addRecipients(Message.RecipientType.TO, toAddresses);

			message.setSubject("hi");
			String str = "<html><h1>Hello</h1>" +  
					"<img src=\"cid:image_cid\">" +
					"<img border=0 src=http://dl.dropbox.com/u/93882717/occasion/bitrhday.jpg alt=abc width=304 height=228 /></html>";  
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
			DataSource ds = new FileDataSource(path);  
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
	
	//=====================for download the image from url
	public String downloadImage(String urllink)
	{
		InputStream in=null;
		OutputStream out=null;
		String path="/home/prabhu/image.jpg";
		try {
		      URL url = new URL(urllink);
		      // 'in' and 'out' declaration goes here
		      try {
		        byte buf[] = new byte[4 * 1024];  // 4kb buffer
		        int read = -1;
		        in = url.openStream();
		        // create a new File 'f' which the output stream will write to.
		        // Create it at a location of your choice with name as that of the image
		        out = new FileOutputStream(path);
		        while((read = in.read(buf)) != -1) {
		          out.write(buf, 0, read);
		        }
		        out.flush();
		        System.out.println("file downloaded successfully");
		      } finally {
		        if(in != null)  in.close();
		        if(out != null) out.close();
		      }
		    } catch(IOException ioe) {
		      ioe.printStackTrace();
		    }
		return path;
	}

}
