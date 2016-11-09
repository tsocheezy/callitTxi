
package concurrency;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Producer implements Runnable{
    
    private final BlockingQueue sharedQueue;
    Random randomCustomer=new Random();
    methodClass mb=new methodClass();
    int threadNumber=0;
    private long startTime = System.nanoTime(); //Time of initial build
private long simulationTime = 1; //Desired time in minutes
    
    public Producer(BlockingQueue sharedQueue, int th) {
    this.sharedQueue = sharedQueue;
    this.threadNumber=th;
    }
    
    public void run() {
        
        while((System.nanoTime()-startTime)<=(simulationTime*60000000000L))
        //for(int i=0; i<10; i++){
            try {
                int customer = randomCustomer.nextInt(200)+1;
                System.out.println("A customer with " + customer+" items joined "+Thread.currentThread().getName());
                
                if(sharedQueue.size()==6){
                
                    mb.incrementLoss();
                    
                }
                
                else{
                    if(threadNumber==2){
                    
                        if(customer>10){
                        
                            
                            System.out.println( "Sorry, "+Thread.currentThread().getName()+ " is a 10 or less Checkout.");
                        }
  
                    }
                sharedQueue.put(customer);
                waiting();
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
            }
       // }
    }


public void waiting(){

    try{
    
        int waitTime= randomCustomer.nextInt(60);
        int timewait=waitTime*10;
        Thread.sleep(timewait);
    }
    
    catch(InterruptedException ex){}


}


    
}
