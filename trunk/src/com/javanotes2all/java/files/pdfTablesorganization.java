package com.javanotes2all.java.files;

import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class pdfTablesorganization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		pdfTablesorganization cra=new pdfTablesorganization();
		cra.tables();

	}
	public void tables () {
	    try {
	        Document document = new Document ();
	        PdfWriter pdfWriter = PdfWriter.getInstance (document, new FileOutputStream ("/home/prabhu/test.pdf"));
	        document.open ();

	        PdfPTable outerTable = new PdfPTable (1);
	        outerTable.setWidthPercentage (100);

	        PdfPCell cell = new PdfPCell ();
	        cell.setMinimumHeight(document.getPageSize ().getHeight () - 36.0f - 36.0f);
	        cell.setVerticalAlignment (Element.ALIGN_TOP);
	        cell.addElement (createTable ());

	        outerTable.addCell (cell);
	        document.add (outerTable);
	        document.newPage ();
	        document.close ();
	    } catch (Exception e) {
	        e.printStackTrace ();
	    }

	}

	public PdfPTable leftTable () {
	    PdfPTable table = new PdfPTable (1);
	    for (int i = 0; i < 50; i++) {
	        table.addCell ("Cell: " + i);
	    }
	    return table;
	}

	public PdfPTable middleTable () {
	    PdfPTable table = new PdfPTable (1);
	    for (int i = 0; i < 10; i++) {
	        table.addCell ("Cell: " + i);
	    }
	    return table;
	}

	public PdfPTable rightTable () {
	    PdfPTable table = new PdfPTable (1);
	    for (int i = 0; i < 100; i++) {
	        table.addCell ("Cell: " + i);
	    }
	    return table;
	}

	public PdfPTable createTable () {
	    PdfPTable table = new PdfPTable (3);
	    table.setWidthPercentage(100);
	    table.getDefaultCell ().setVerticalAlignment (Element.ALIGN_TOP);
	    table.addCell (leftTable ());
	    table.addCell (middleTable ());
	    table.addCell (rightTable ());

	    return table;
	}
}
