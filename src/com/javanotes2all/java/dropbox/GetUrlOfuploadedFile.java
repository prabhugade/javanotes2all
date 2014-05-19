package com.javanotes2all.java.dropbox;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.DropboxLink;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;


public class GetUrlOfuploadedFile {

	private static final String APP_KEY = "48cphbrivz9sdye";
	private static final String APP_SECRET = "1c8vtl0dj7in60q";
	// String reauth_key="fs853riix19tnjd";
	// String reauth_secret="64nd0d6xf5i5ybg";
	private static final AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
	private static DropboxAPI<WebAuthSession> mDBApi;
	static AccessTokenPair pair = null;
	public static void main(String[] args) throws Exception {
		try
		{
			System.out.println("start");	
			AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
			System.out.println("start");	
			pair=new AccessTokenPair("r1jf9iispxfaezs5","0qww9wjtl456fdc");
			WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE,pair);
			System.out.println("start");	
			mDBApi = new DropboxAPI<WebAuthSession>(session);
			System.out.println("start1");
			System.out.println();
			System.out.print("Uploading file...");
			//String fileContents = "Hello World11111!";
			FileInputStream fileInputStream=null;

			File file = new File("/home/venkat/adage.png");

			byte[] bFile = new byte[(int) file.length()];

			try {
				//convert file into array of bytes
				fileInputStream = new FileInputStream(file);
				fileInputStream.read(bFile);
				fileInputStream.close();

				for (int i = 0; i < bFile.length; i++) {
					System.out.print((char)bFile[i]);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			ByteArrayInputStream inputStream = new ByteArrayInputStream(bFile);
			Entry newEntry = mDBApi.putFile("/testing1.png", inputStream, file.length(), null, null);
			System.out.println("Done. \nRevision of file: " + newEntry.rev);
			
			//get uploaded Image URL
			DropboxLink link = mDBApi.share(newEntry.path);
			System.out.println(link.url);
			
		    URL url = new URL(link.url);
		    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		    urlConnection.setInstanceFollowRedirects(false);

		    String location = urlConnection.getHeaderField("location");
		    System.out.println("final imageURL :"+location);
		    location=location.replaceAll("www.dropbox.com", "dl.dropboxusercontent.com");

		}catch(Exception e)
		{
			System.out.println(e.getMessage());	
		}
	}
}