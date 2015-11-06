import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface BookWarehouse extends Remote {
    List<String> getAllISBN() throws  RemoteException;
    List<String> getAllAuthors() throws  RemoteException;
    List<String> getAllBooks() throws RemoteException;

    String getDetailsByIsbn(String isbn) throws RemoteException;
    String getDetailsByAuthor(String author)throws  RemoteException;
    String getDetailsByTitle(String author)throws  RemoteException;

}
