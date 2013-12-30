package com.javanotes2all.java.others;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ScreenCapture
{
	public static void main(String[] args) throws Exception 
	{
		ScreenCapture cp=new ScreenCapture();
		cp.captureScreen("/home/prabhu/screencap.png");
		System.out.println("success");
	}
	public void captureScreen(String fileName) throws Exception {
		 
		   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		   Rectangle screenRectangle = new Rectangle(screenSize);
		   Robot robot = new Robot();
		   BufferedImage image = robot.createScreenCapture(screenRectangle);
		   ImageIO.write(image, "png", new File(fileName));
		 
		}
}
