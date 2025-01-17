import Counter.*;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;
import org.omg.CosNaming.NamingContextPackage.*;

public class CountServer {

  public static void main(String args[]) {
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

      // create an implementation and register it with the ORB
      CountImpl impl = new CountImpl(orb);

      // get reference to rootpoa & activate the POAManager
      POA rootpoa = POAHelper.narrow(
        orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // get object reference from the servant
      org.omg.CORBA.Object ref = 
        rootpoa.servant_to_reference(impl);
      Counter.Count href = CountHelper.narrow(ref);
	  
      // get the root naming context
      // NameService invokes the name service
      org.omg.CORBA.Object objRef = 
        orb.resolve_initial_references("NameService");
      // Use NamingContextExt which is part of the Interoperable
      // Naming Service (INS) specification.
      NamingContextExt ncRef = 
        NamingContextExtHelper.narrow(objRef);

      // bind the Object Reference in Naming
      String name = "Count";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);

      System.out.println("Counter Server is ready  ....");

      // wait for invocations from clients
      orb.run();
    } catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
    }
    System.out.println("Counter Server Exiting ....");
  }
}