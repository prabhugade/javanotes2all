package com.javanotes2all.java.files;

import java.io.IOException;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class readpdf {

	public static void main(String[] args) {
	    try {
	        // TODO code application logic here

	         PdfReader pr=new PdfReader("/home/prabhu/Downloads/gwt/jesus books/The_Acts_of_Thomas.pdf");
	         PdfTextExtractor ext=new PdfTextExtractor(pr);
	         
	          String str=ext.getTextFromPage(2); 
	          System.out.println(str);

	    } catch (IOException ex) {
	    }

	}

}
