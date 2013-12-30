package com.javanotes2all.java.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class GeneratePDFWithPassword {

	 private static String USER_PASS = "user123";
	 
	    private static String OWNER_PASS = "owner123";
	     
	     /**
	      * itextpdf-5.2.1.jar
			bcmail-jdk16-1.46.jar
			bcprov-jdk16-1.46.jar
			bctsp-jdk16-1.46.jar
	      * 
	      */
	    public static void main(String[] args) {
	        try {
	             
	            OutputStream file = new FileOutputStream(new File("/home/prabhu/Test.pdf"));
	 
	            Document document = new Document();
	            PdfWriter writer = PdfWriter.getInstance(document, file);
	 
	            writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
	 
	            document.open();
	            document.add(new Paragraph("Hello World, this has password protected data"));
	            document.add(new Paragraph(new Date().toString()));
	 
	            document.close();
	            file.close();
	 
	        } catch (Exception e) {
	 
	            e.printStackTrace();
	        }
	    }

}
