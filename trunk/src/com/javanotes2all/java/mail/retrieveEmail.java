package com.javanotes2all.java.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;
public class retrieveEmail
{
	//working fine
	public static void main(String args[]) {
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
       
            try {
            	 BufferedReader breader=new BufferedReader(new InputStreamReader(System.in));
            	 System.out.println("enter from email");
            	 String uname=breader.readLine().trim();
            	 System.out.println("enter password");
            	 String pwd=breader.readLine().trim();
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");
                store.connect("smtp.gmail.com", uname, pwd);
                System.out.println(store);
                Folder inbox = store.getFolder("Inbox");
                inbox.open(Folder.READ_ONLY);
                //Message messages[] = inbox.getMessages();
                FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
                Message messages[] = inbox.search(ft);
                System.out.println(messages.length);
                for(int i=0;i<messages.length;i++) 
                {
                	
                    Multipart mp = (Multipart)messages[i].getContent();  
                    System.out.println("body parts count"+mp.getCount());
                     System.out.println("subject: "+ messages[i].getSubject()+ " \n");
                     for(int l=0;l<messages[i].getFrom().length;l++)
                     {
                    	 System.out.println("\nfrom :"+messages[i].getFrom()[l]); 
                     }
                     
                     System.out.println("\nfrom :"+messages[i].getReceivedDate()+"  "+messages[i].getSentDate());
                     for(int k=0;k<mp.getCount();k++)
                     {
                    	 Object p = mp.getBodyPart(k).getContent();  
                    	 String q = p.toString();//object has the body content  
                    	 System.out.println("\nbody: "+q);//prints the body  
                     }
                     System.out.println("=======================================\n\n\n");
               }
                if(messages.length==0)
                	System.out.println("no mails");

                    } catch (NoSuchProviderException e) {
                        e.printStackTrace();
                        System.exit(1);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        System.exit(2);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

    }
}
