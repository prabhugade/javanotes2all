package com.javanotes2all.java.files;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class readImageFromUrl 
{
	public static void main(String[] args) 
	{
		InputStream in=null;
		OutputStream out=null;
		try {
		      URL url = new URL("http://restaurant:8080/images/restaurant.png");
		      // 'in' and 'out' declaration goes here
		      try {
		        byte buf[] = new byte[4 * 1024];  // 4kb buffer
		        int read = -1;
		        in = url.openStream();
		        // create a new File 'f' which the output stream will write to.
		        // Create it at a location of your choice with name as that of the image
		        out = new FileOutputStream("/home/prabhu/image.png");
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
	}

}
