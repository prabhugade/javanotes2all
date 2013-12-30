package com.javanotes2all.java.multithread;

public class AsyncServiceMethod {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AsyncServiceMethod service=new AsyncServiceMethod();
		System.out.println("Main Method start"); 
        //longRunningMethod("testing", new Object()); 
		service.asyncServiceMethod("testing",new Object()); 
		service.otherMethod(); 

	}
	public Integer longRunningMethod(String param1,Object parm2) throws InterruptedException{ 
        System.out.println("Long running method"); 
        Thread.sleep(5000); 
        //long process 
        return 1; 
    } 
    
    public void otherMethod(){ 
        System.out.println("Other Method"); 
    } 
    
    
    public void asyncServiceMethod(final String parm1,final Object obj){ 
        Runnable task = new Runnable() {

            @Override 
            public void run() { 
                try { 
                   longRunningMethod(parm1,obj); 
                } catch (Exception ex) { 
                    //handle error which cannot be thrown back 
                } 
            } 
        }; 
        new Thread(task, "ServiceThread").start(); 
    }
}
