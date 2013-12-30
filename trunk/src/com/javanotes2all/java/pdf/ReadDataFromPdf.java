package com.javanotes2all.java.pdf;

import java.io.IOException;

import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class ReadDataFromPdf {

	//import itext.jar
	public static void main(String[] args) throws IOException 
	{
		PdfReader reader = new PdfReader("/home/prabhu/Documents/worked/personal/prabhu_photos/bm/suvishesha dhorani.PDF");
		int noPages = reader.getNumberOfPages();
		PdfTextExtractor extractor = new PdfTextExtractor(reader);

	String content=""; 
	for(int page=1;page<=noPages;page++){
		System.out.println(page);
		content = extractor.getTextFromPage(page);
		System.out.println(content);
    	}		

	}

}
