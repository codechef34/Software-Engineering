import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;


public class BookWarehouseServer {
    public static void main(String[] args) throws RemoteException, NamingException {

        System.out.println("Constructing server implementation");

        BookWarehouseImpl bookWarehouse = new BookWarehouseImpl();

        System.out.println("Binding server implementation to registry ...");
        Context namingContext = new InitialContext();
        namingContext.bind("rmi:book_warehouse",bookWarehouse);

        System.out.println("Waiting for invocations from clients");

    }
}
