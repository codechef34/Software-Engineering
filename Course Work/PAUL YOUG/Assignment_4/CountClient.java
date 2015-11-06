import Counter.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
// CountClient.java  Static Client, VisiBroker for Java
public class CountClient  { 
       public static void main(String args[]) { 
              try  {   // Initialize the ORB
			  
      ORB orb = ORB.init(args, null);

      // get the root naming context
      org.omg.CORBA.Object objRef = 
        orb.resolve_initial_references("NameService");

      // Use NamingContextExt instead of NamingContext. This is 
      // part of the Interoperable Naming Service.  
      NamingContextExt ncRef = 
        NamingContextExtHelper.narrow(objRef);
 
      // resolve the Object Reference in Naming
      String name = "Count";
      Counter.Count impl = CountHelper.narrow(ncRef.resolve_str(name));

      System.out.println("Handle obtained on server object: " + impl);
                          // Set sum to initial value of 0
                          System.out.println("Setting sum to 0");
                          impl.sum((int)0);
                          // Time 1000 iterations
                          long startTime = System.currentTimeMillis();
                          System.out.println("Incrementing");
                          for (int i = 0 ; i < 1000 ; i++ ) { 
                                impl.increment();
								//System.out.println("increment value is"+i);
                          } //end for
                         long stopTime = System.currentTimeMillis();
                        System.out.println("Avg Ping = " + ((stopTime - startTime)/1000f) + " msecs");
                        System.out.println("Sum = " + impl.sum());
              }  //end try 
               catch (Exception e) {
        System.out.println("ERROR : " + e) ;
        e.printStackTrace(System.out);
    }
       } //end main
} //end CountClient
