package com.javanotes2all.java.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Mp3ToText 
{

	public static void main(String[] args) 
	{
		Mp3ToText text=new Mp3ToText();
		text.outputData("/home/prabhu/Music/Chaachina Chethulatho.text");

	}
	public String readFile(String filename) {

	    // variable representing a line of data in the mp3 file
	    String line = "";

	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

	        while (br.readLine() != null) {
	          line+=br.readLine();

	        try {
	            if (br == null) {

	                // close reader when all data is read
	                br.close();
	            }

	        } catch (FileNotFoundException e) {
	            e.getMessage();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        }
	    } catch (FileNotFoundException e) {
	        e.getMessage();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return line;
	}
	    public void outputData(String outputFile) {

            try {

        // Create file
        FileWriter fileStream = new FileWriter(outputFile);
        BufferedWriter writer = new BufferedWriter(fileStream);

        writer.write(readFile("/home/prabhu/Music/Chaachina Chethulatho.mp3"));

        // Close writer
        writer.close();

        // Handle exceptions
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
