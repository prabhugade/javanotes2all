package com.javanotes2all.java.awt;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/* 
 * To change this template, choose Tools | Templates 
 * and open the template in the editor. 
 */ 
/** 
 * 
 * @author Anurag 
 */ 
public class ControlKeyboard { 

    public static void main(String args[]) { 
        new ControlKeyboard().control_keyboard(); 
    } 

    public void control_keyboard() { 
        try { 
            Robot robot = new Robot(); 

            //Perform ALT+TAB which will switch your window 
            robot.keyPress(KeyEvent.VK_ALT); 
            robot.keyPress(KeyEvent.VK_TAB); 

            Thread.sleep(1000); 

            robot.keyRelease(KeyEvent.VK_ALT); 
            robot.keyRelease(KeyEvent.VK_TAB); 

            //Press Key A 
            robot.keyPress(KeyEvent.VK_A); 
            Thread.sleep(1000); 
            robot.keyRelease(KeyEvent.VK_A); 
            //Similarly to press key Z use  
            robot.keyPress(KeyEvent.VK_Z); 
            Thread.sleep(1000); 
            robot.keyRelease(KeyEvent.VK_Z); 

            //Press ALT key 
            robot.keyPress(KeyEvent.VK_ALT); 
            Thread.sleep(1000); 
            robot.keyRelease(KeyEvent.VK_ALT); 

            //Press Control Key 
            robot.keyPress(KeyEvent.VK_CONTROL); 
            Thread.sleep(1000); 
            robot.keyRelease(KeyEvent.VK_CONTROL); 




        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 