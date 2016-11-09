
package concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;



public class Concurrency {

     
    
    public static void main(String[] args) {
        
        int numberOfTellers=6;
        
     
  
        BlockingQueue sharedQueue1 = new LinkedBlockingQueue();
        BlockingQueue sharedQueue2 = new LinkedBlockingQueue();
        BlockingQueue sharedQueue3 = new LinkedBlockingQueue();
        BlockingQueue sharedQueue4 = new LinkedBlockingQueue();
        BlockingQueue sharedQueue5 = new LinkedBlockingQueue();
        BlockingQueue sharedQueue6 = new LinkedBlockingQueue();
        
        
 
     //Creating Producer and Consumer Thread
     Thread prodThread1 = new Thread(new Producer(sharedQueue1,1),"Line 1");
     Thread consThread1 = new Thread(new Consumer(sharedQueue1,1), "Teller 1");
     
     Thread prodThread2 = new Thread(new Producer(sharedQueue2,2),"Line 2");
     Thread consThread2 = new Thread(new Consumer(sharedQueue2,2), "Teller 2");
     
     Thread prodThread3 = new Thread(new Producer(sharedQueue3,3),"Line 3");
     Thread consThread3 = new Thread(new Consumer(sharedQueue3,3), "Teller 3");
     
     Thread prodThread4 = new Thread(new Producer(sharedQueue4,4),"Line 4");
     Thread consThread4 = new Thread(new Consumer(sharedQueue4,4), "Teller 4");
     
     Thread prodThread5 = new Thread(new Producer(sharedQueue5,5),"Line 5");
     Thread consThread5 = new Thread(new Consumer(sharedQueue5,5), "Teller 5");
     
     Thread prodThread6 = new Thread(new Producer(sharedQueue6,6),"Line 6");
     Thread consThread6 = new Thread(new Consumer(sharedQueue6,6), "Teller 6");

     //Starting producer and Consumer thread
 
   
     prodThread1.start();
     consThread1.start();
     
     prodThread2.start();
     consThread2.start();
     
     prodThread3.start();
     consThread3.start();
     
     prodThread4.start();
     consThread4.start();
     
     prodThread5.start();
     consThread5.start();
     
     prodThread6.start();
     consThread6.start();

     //joining threads after running
     try{
     consThread2.join();
     consThread1.join();
     consThread3.join();
     consThread4.join();
     consThread5.join();
     consThread6.join();
     
     prodThread1.join();
     prodThread2.join();
     prodThread3.join();
     prodThread4.join();
     prodThread5.join();
     prodThread6.join();
     
     } 
     catch(InterruptedException ex){}
     
     methodClass obj=new methodClass();
     int arr[];
     arr=obj.getArray(); 
     int checkout1=arr[0];
     int checkout2=arr[1];
     int checkout3=arr[2];
     int checkout4=arr[3];
     int checkout5=arr[4];
     int checkout6=arr[5];
     int totalCustomer=obj.getCount();
     int totalProduct=obj.getProductNum();
     int averageProduct= obj.trolleyAve(totalProduct,totalCustomer);
     int lostCustomer=obj.getLoss();
     int AverageCheckoutUtil=totalCustomer/numberOfTellers;
     int waitTime=obj.getWait();
     int averageWait=waitTime/totalCustomer;
     
     
     System.out.println("the total number of costomers: "+totalCustomer);
     System.out.println("the total number of products: "+totalProduct);
     System.out.println("average number of things checked out: "+ averageProduct);
     System.out.println("checkout 1 had these customers: "+checkout1);
     System.out.println("checkout 2 had these customers: "+checkout2);
     System.out.println("checkout 3 had these customers: "+checkout3);
     System.out.println("checkout 4 had these customers: "+checkout4);
     System.out.println("checkout 5 had these customers: "+checkout5);
     System.out.println("checkout 6 had these customers: "+checkout6);
     
     System.out.println("total number of customers lost: "+lostCustomer);
     System.out.println("Average teller util is: "+AverageCheckoutUtil);
     System.out.println("total wait time for each customer is: "+waitTime);
     System.out.println("average customer wait time is: "+averageWait);
        
       
   

    }
    
}
