import Counter.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class CountClient  { 
       public static void main(String args[]) { 
              try  {   
			  
      ORB orb = ORB.init(args, null);
	org.omg.CORBA.Object objRef = 
        orb.resolve_initial_references("NameService");  
      NamingContextExt ncRef = 
        NamingContextExtHelper.narrow(objRef);
      String name = "Count";
      Counter.Count impl = CountHelper.narrow(ncRef.resolve_str(name));

      System.out.println("Handle obtained on server object: " + impl);
                 System.out.println("Initializing sum to 0");
                          impl.sum((int)0);
              
                          long startTime = System.currentTimeMillis();
                          System.out.println("Incrementing");
						  int i=0;
                          while(i<1000){ 
                                impl.increment();
								i++;
								
                          } 
                         long stopTime = System.currentTimeMillis();
                        System.out.println("Response Time = " + ((stopTime - startTime)/1000f) + " msecs");
                        System.out.println("Total = " + impl.sum());
              }  
               catch (Exception e) {
        System.out.println("ERROR : " + e) ;
        e.printStackTrace(System.out);
    }
       } 
} 
