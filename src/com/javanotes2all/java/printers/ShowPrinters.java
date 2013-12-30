package com.javanotes2all.java.printers;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class ShowPrinters {

	String defaultPrinter;
    public void SearchPrinter() {
        PrintService[] ser = PrintServiceLookup.lookupPrintServices(null, null);
 
        System.out.println("**************** All Printers ******************");
        for (int i = 0; i < ser.length; ++i) {
            String p_name = ser[i].getName();
            System.out.println(p_name);
        }
        System.out.println("***********************************************\n");
        defaultPrinter  =   PrintServiceLookup.lookupDefaultPrintService().getName();
        System.out.println("Default Printer  : "+defaultPrinter );
    }
 
    public static void main(String[] args) {
        new ShowPrinters().SearchPrinter();
    }
}
