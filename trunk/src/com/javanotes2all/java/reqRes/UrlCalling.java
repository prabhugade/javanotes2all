package com.javanotes2all.java.reqRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
// itext.jar file required
public class UrlCalling 
{
	String url = "http://192.168.5.102:8080/Restaurant/justservlet?";
	public static void main(String[] args) 
	{
		UrlCalling call=new UrlCalling();
		call.getService_Method_Response("bid=14");
	}

	// ----------call response ---------------

	public String getService_Method_Response(String paremeters) {

		String element = null;

		try {
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(url + paremeters);

			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			// String line = EntityUtils.toString(entity);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()), 1024);

			int ads;
			StringBuilder bd = new StringBuilder();
			while ((ads = br.read()) != -1) {
				bd.append((char) ads);

			}
			String line = bd.toString().trim();
			System.out.println(line);
			// -----------String---------

			if (line != null) {

				if (line.contains("[") || line.contains("{")) {
					int in = line.length();
					String str = line.substring(1, in - 1);
					element = str;
				} else {
					element = line;
				}
			}

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;

	}
}
