package com.javanotes2all.java.dropbox;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.net.URL;

import javax.swing.JOptionPane;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.RequestTokenPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.WebAuthSession.WebAuthInfo;


 public class DropBoxkeys {
	 private static final String APP_KEY = "tzfva9ntlvp3584";
	 private static final String APP_SECRET = "o76jlzqdeyiy7wz";
	// String reauth_key="fs853riix19tnjd";
	// String reauth_secret="64nd0d6xf5i5ybg";
    private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
    private static DropboxAPI<WebAuthSession> mDBApi;
 
    public static void main(String[] args) throws Exception {
    	try
    	{
    		System.out.println("start");	
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        System.out.println("start");	
        WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
        System.out.println("start");	
        WebAuthInfo authInfo = session.getAuthInfo();
        System.out.println("start");	
 
        RequestTokenPair pair = authInfo.requestTokenPair;
        System.out.println("start");	
        String url = authInfo.url;
        System.out.println("start");	
 
        Desktop.getDesktop().browse(new URL(url).toURI());
        JOptionPane.showMessageDialog(null, "Press ok to continue once you have authenticated.");
        session.retrieveWebAccessToken(pair);
 
        AccessTokenPair tokens = session.getAccessTokenPair();
        System.out.println("Use this token pair in future so you don't have to re-authenticate each time:");
        System.out.println("Key token: " + tokens.key);
        System.out.println("Secret token: " + tokens.secret);
 
        mDBApi = new DropboxAPI<WebAuthSession>(session);
 
        System.out.println();
        System.out.print("Uploading file...");
        String fileContents = "Hello World!";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(fileContents.getBytes());
        Entry newEntry = mDBApi.putFile("/testing.txt", inputStream, fileContents.length(), null, null);
        System.out.println("Done. \nRevision of file: " + newEntry.rev);
        
        
        
    	}catch(Exception e)
    	{
    		System.out.println(e.getMessage());	
    	}
         
    }
}