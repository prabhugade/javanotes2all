package com.javanotes2all.java.log4j;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
public class Log4jExample {
 
    private static Logger logger;
 
    public static void main(String[] args) {
 
        //Allows the configuration of log4j from an external file.
        PropertyConfigurator.configure("/home/prabhu/workspace/projects-jan2013/narmaljava/src/properties/log4j.properties");
        
        //This is the central class in the log4j package. 
        //Most logging operations, except configuration, are 
        //done through this class. 
        logger = Logger.getLogger(Log4jExample.class);
 
        //Log a message object with the INFO Level. 
        logger.info("Put your Log4j Information messages here");
 
        //Log a message object with the WARN Level. 
        logger.warn("Put your Log4j Warning messages here");
 
        //This generic form is intended to be used by wrappers.
        //You can set the priority and the message
        logger.log(Level.TRACE, "Here we go a Log4j trace message");
 
        //Log a message object with the DEBUG level. 
        logger.debug("Put your Log4j debug information here");
 
        // Exception logging example:
        try{
            String logError = "log4j111".substring(6);
        }catch (Exception e){
            //Log a message object with the ERROR Level. 
            logger.error("Log4J error: " +  getFullStackTrace(e));
        }     
 
    }
    
    public static String  getFullStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        throwable.printStackTrace(pw);
        return sw.toString();
   }
    
}