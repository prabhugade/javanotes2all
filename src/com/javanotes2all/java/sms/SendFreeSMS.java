package com.javanotes2all.java.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class SendFreeSMS {

	private final String LOGIN_URL    = "http://fullonsms.com/login.php";
	private final String SEND_SMS_URL = "http://fullonsms.com/home.php";
	private final String LOGOUT_URL = "http://fullonsms.com/logout.php?LogOut=1";

	private final int MESSAGE_LENGTH = 10;
	private final int MOBILE_NUMBER_LENGTH = 140;
	private final int PASSWORD_LENGTH = 10;

	private String mobileNo;
	private String password;
	private DefaultHttpClient httpclient;

	SendFreeSMS(String username,String password){
		this.mobileNo = username;
		this.password = password;
		httpclient = new DefaultHttpClient();
	}


	public boolean isLoggedIn() throws IOException {
		// User Credentials on Login page are sent using POST
		// So create httpost object
		HttpPost httpost = new HttpPost(LOGIN_URL);

		// Add post variables to login url
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("MobileNoLogin", mobileNo));
		nvps.add(new BasicNameValuePair("LoginPassword", password));
		httpost.setEntity(new UrlEncodedFormEntity(nvps));

		// Execute request
		HttpResponse response = this.httpclient.execute(httpost);

		//Check response entity
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			System.out.println("entity " + slurp(entity.getContent(), 10000000));
			System.out.println("entity " + response.getStatusLine().getStatusCode());

			return true;
		}
		return false;
	}

	public boolean sendSMS(String toMobile,String message) throws IOException {
		HttpPost httpost = new HttpPost(SEND_SMS_URL);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("MobileNos", toMobile));
		nvps.add(new BasicNameValuePair("Message", message));

		httpost.setEntity(new UrlEncodedFormEntity(nvps));
		HttpResponse response = this.httpclient.execute(httpost);
		HttpEntity entity = response.getEntity();
		if(entity != null) {
			System.out.println("entity " + slurp(entity.getContent(), 10000000));
			System.out.println("entity " + response.getStatusLine().getStatusCode());
			return true;
		}
		return false;
	}

	public boolean logoutSMS() throws IOException {
		HttpGet httpGet = new HttpGet(LOGOUT_URL);
		HttpResponse response;
		response = this.httpclient.execute(httpGet);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			System.out
			.println("entity " + slurp(entity.getContent(), 10000000));
			System.out.println("entity "
					+ response.getStatusLine().getStatusCode());
			return true;
		}
		return false;
	}


	public static String slurp(final InputStream is, final int bufferSize)
	{
		final char[] buffer = new char[bufferSize];
		final StringBuilder out = new StringBuilder();
		try {
			final Reader in = new InputStreamReader(is, "UTF-8");
			try {
				for (;;) {
					int rsz = in.read(buffer, 0, buffer.length);
					if (rsz < 0)
						break;
					out.append(buffer, 0, rsz);
				}
			}
			finally {
				in.close();
			}
		}
		catch (UnsupportedEncodingException ex) {
			/* ... */
		}
		catch (IOException ex) {
			/* ... */
		}
		return out.toString();
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		//Replace DEMO_USERNAME with username of your account
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Username");
		String username = reader.readLine();
		//Replace DEMO_PASSWORD with password of your account
		System.out.println("Enter Password");
		String password = reader.readLine();
		//Replace TARGET_MOBILE with a valid mobile number 
		
		ArrayList<String> phoneslist=new ArrayList<String>();
		phoneslist.add("0000000000");

		SendFreeSMS fullOnSMS = new SendFreeSMS(username, password);
		try{
			for(int i=0;i<phoneslist.size();i++)
			{
				String toMobile = phoneslist.get(i);
				String toMessage = "Every day may not be good, but there's something good in every day.Have a nice day";
				if(fullOnSMS.isLoggedIn() && fullOnSMS.sendSMS(toMobile,toMessage)){
					fullOnSMS.logoutSMS();
					System.out.println(toMobile+"Message was sent successfully " );
				}
			}
		}catch(IOException e){
			System.out.println("Unable to send message, possible cause: " + e.getMessage());
		}
	}
}