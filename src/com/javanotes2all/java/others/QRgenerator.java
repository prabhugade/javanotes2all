package com.javanotes2all.java.others;



import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class QRgenerator {
	public static void main(String[] args) {
		ByteArrayOutputStream out = QRCode.from("Hello World").to(ImageType.PNG).stream();

		try {
			FileOutputStream fout = new FileOutputStream(new File("/home/prabhu/qr.png"));

			fout.write(out.toByteArray());

			fout.flush();
			fout.close();

		} catch (FileNotFoundException e) {
			// Do Logging
		} catch (IOException e) {
			// Do Logging
		}
	}
}