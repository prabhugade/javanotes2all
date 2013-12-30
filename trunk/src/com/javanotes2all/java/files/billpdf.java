package com.javanotes2all.java.files;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfWriter;

public class billpdf {

	public static void main(String[] args)throws Exception {
		
		Rectangle pageSize = new Rectangle(200, 500);
		pageSize.setBackgroundColor(new java.awt.Color(0xFF, 0xFF, 0xDE));
		pageSize.setBorder(1);
		pageSize.setLeft(0);
		Document document = new Document(pageSize); 
		//Document document = new Document();
		//document.setPageSize(PageSize.HALFLETTER);
		PdfWriter.getInstance(document,new FileOutputStream("/home/prabhu/billpdf.pdf"));
		document.open();
		document.add(new Paragraph("The default PageSize==>>RoseIndia"));
		document.close();
		System.out.println("success");
	        
	    }
}
