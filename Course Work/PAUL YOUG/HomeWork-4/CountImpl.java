import Counter.*;
import org.omg.CORBA.*;
public class CountImpl  extends CountPOA {
     private int sum;
	 private ORB orb;

     public CountImpl(ORB orb) { 
         this.orb = orb;
     } 
     public  int sum()  {
          return sum;
     } 
 
     public  void sum(int val)  {
          sum = val;
     } 

     public int increment() {
          sum++;
          return sum;
     } 
} 
