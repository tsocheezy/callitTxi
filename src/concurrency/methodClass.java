
package concurrency;
import java.util.*;

public class methodClass {
    
    private static int customerNumber=0;
    private static int productNumber=0;
     private static int lostCust=0;
     public static int[] arr={0,0,0,0,0,0};
    private static int waitingTime=0;
     
     public void putArray(int numb, int place){
     
         arr[place]=numb;
     }
     
     public int[] getArray(){
     
         return arr;
     
     }
     
    public synchronized void increment(){
    
        customerNumber++;
        //System.out.println("customer count: "+customerNumber);
    
    }
    
    public int getCount(){
    
        return customerNumber;
    
    }
    
    public void serve(int num){
    
        try{
        
            Random serveTime=new Random();
            int time = serveTime.nextInt(6)+1;
            
            int temp=num*(time);
           // System.out.println("waiting for: "+temp);
            setWait(temp);
            Thread.sleep(temp);
        }
        
        catch(InterruptedException ex){
        
        }
    
    }
    public void setWait(int D){
    
        waitingTime+=D;
    
    }
    public int getWait(){
    
        return waitingTime;
    }
    
    public synchronized void incrementProd(int i){
    
        productNumber+=i;
       // System.out.println("total products served in shop: "+productNumber);
   
    }
    
    public int getProductNum(){
    
        return productNumber;
    
    }
    
   
    
    public int trolleyAve(int k, int j){
    
        int aveTrolley=k/j;
        return aveTrolley;
    
    }
    
    public synchronized void incrementLoss(){

     lostCust++;
    System.out.println("Sorry queue too long: I am leaving");
       
    }
    
    public int getLoss(){
    
        return lostCust;
    }
    
    
     

}
