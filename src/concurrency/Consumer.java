
package concurrency;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;



public class Consumer implements Runnable{
    
    
    private final BlockingQueue sharedQueue;
    private static AtomicInteger counter = new AtomicInteger(0);
    public static int teller1=0;
    public static int teller2=0;
    private int teller3=0;
    private int teller4=0;
    private int teller5=0;
    private int teller6=0;
    methodClass obj=new methodClass();
    int threadNumber;
    private long startTime = System.nanoTime(); //Time of initial build
private long simulationTime = 1; //Desired time in minutes
    
   
    public Consumer (BlockingQueue sharedQueue, int th) {
        this.sharedQueue = sharedQueue;
        this.threadNumber=th;
    }
  
  
    @Override
    public void run() {
        
        while((System.nanoTime()-startTime)<=(simulationTime*60000000000L))
        /*while(true)*///for(int k=0; k<10; k++){
            try {
                 Object temp=sharedQueue.take();
                System.out.println(Thread.currentThread().getName()+" Checked out customer with  "+ temp+" items");
                String temp2=temp.toString();
                int i = Integer.parseInt(temp2);
                obj.serve(i);
                obj.incrementProd(i);
                obj.increment();
                
                if(threadNumber==1){
               
                    teller1++;
                    //System.out.println("teller1: "+teller1);
                    obj.putArray(teller1, 0);
                  
                }
                
                if(threadNumber==2){
               
                    teller2++;
                    //System.out.println("teller2: "+teller2);
                    obj.putArray(teller2, 1);
                   
                }
                
                if(threadNumber==3){
               
                    teller3++;
                   // System.out.println("teller2: "+teller3);
                    obj.putArray(teller3, 2);
                   
                }
                
                if(threadNumber==4){
               
                    teller4++;
                   // System.out.println("teller2: "+teller4);
                    obj.putArray(teller4, 3);
                   
                }
                
                if(threadNumber==5){
               
                    teller5++;
                   // System.out.println("teller2: "+teller5);
                    obj.putArray(teller5, 4);
                   
                }
                
                 if(threadNumber==6){
               
                    teller6++;
                    //System.out.println("teller2: "+teller6);
                    obj.putArray(teller6, 5);
                   
                }
             
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    } 
//}
      
 
    
}
