import Counter.*;
import org.omg.CORBA.*;
public class CountImpl  extends CountPOA {
     private int sum;
	 private ORB orb;

     public CountImpl(ORB orb) { 
          //super(name);
          //System.out.println("Count Object Created");
          //sum = 0;
		  this.orb = orb;
     } //end CountImpl
     public  int sum()  {
          return sum;
     } //end sum - gets sum
 
     public  void sum(int val)  {
          sum = val;
     } //end sum - set sum

     public int increment() {
          sum++;
          return sum;
     } //end increment
} //end class CounterImpl
