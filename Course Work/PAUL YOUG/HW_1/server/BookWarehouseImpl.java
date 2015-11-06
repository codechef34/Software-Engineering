import java.rmi.RemoteException;
import java.rmi.server.*;
import java.rmi.*;
import java.util.*;

public class BookWarehouseImpl extends UnicastRemoteObject implements BookWarehouse {

    private Map<String,Map<String,String>> books;
    private Map<String,String> authorsMap;
    private Map<String,HashMap<String,String>> titlesMap;

    public BookWarehouseImpl() throws  RemoteException
    {
        books = new HashMap<String,Map<String,String>>();

        //BOOK1 Details
        Map bookMapAuthorPrice = new HashMap<String,String>();
        bookMapAuthorPrice.put("Horstman","54.99");

        Map bookMapTitle = new HashMap<String,HashMap<String,String>>();
        bookMapTitle.put("Core II Java",bookMapAuthorPrice);

        // Add this book to Map with Key as the ISBN number
        books.put("0132354799",bookMapTitle);

        //BOOK2 Details
        Map bookMapAuthorPrice2 = new HashMap<String, String>();
        bookMapAuthorPrice2.put("Boehm","75.00");

        Map bookMapTitle2 = new HashMap<String,HashMap<String,String>>();
        bookMapTitle2.put("Software Engineering Economics",bookMapAuthorPrice2);

        // Add book2 to Map with Key as the ISBN number
        books.put("0138221227",bookMapTitle2);


        //BOOK3 Details
        Map bookMapAuthorPrice3 = new HashMap<String, String>();
        bookMapAuthorPrice3.put("Flower","44.99");

        Map bookMapTitle3 = new HashMap<String,HashMap<String,String>>();
        bookMapTitle3.put("UML Distilled",bookMapAuthorPrice3);

        // Add this book to Map with Key as the ISBN number
        books.put("0201325632",bookMapTitle3);


        //ADD more books as needed

    }

    @Override
    public List<String> getAllISBN() throws RemoteException{

        List<String> isbnList = new ArrayList<String>(books.keySet());
        return isbnList;
    }

    @Override
    public List<String> getAllAuthors() throws RemoteException{

        Map authorsMap = new HashMap<String, String>();
        Map tmptitlesMap = new HashMap<String,HashMap<String,String>>();
        List<String> authorsList = new ArrayList<String>();
        List<String> allisbns = this.getAllISBN();
        List<String> allBooks = this.getAllBooks();

        for (int i = 0; i <allBooks.size(); i++)
        {
            tmptitlesMap = books.get(allisbns.get(i));
            authorsMap = (HashMap)tmptitlesMap.get(allBooks.get(i));
            authorsList.addAll(authorsMap.keySet());
        }


        return authorsList;
    }

    @Override
    public List<String> getAllBooks() throws RemoteException{

        Map tmptitlesMap = new HashMap<String,HashMap<String,String>>();
        List titles = new ArrayList<String>();
        List isbns = this.getAllISBN();

        for (int i = 0; i < isbns.size(); i++)
        {
            tmptitlesMap = books.get(isbns.get(i));
            titles.addAll(tmptitlesMap.keySet());
        }

        return titles;
    }

    @Override
    public String getDetailsByIsbn(String isbn) throws RemoteException{

        String detailsString = new String("");
        String titleString = new String("");
        String authorString = new String("");
        String priceString = new String("");

        detailsString = detailsString.concat("ISBN:"+isbn); //Now "012344554"
        detailsString = detailsString.concat(";") ; // Now "012344554;"

        Map tmpMapTitle = new HashMap<String,HashMap<String,String>>();
        Map tmpMapAuthorAndPrice = new HashMap<String, String>();
        Iterator tmpIterator;

        tmpMapTitle = books.get(isbn);
        tmpIterator = tmpMapTitle.keySet().iterator();
        titleString = tmpIterator.next().toString();
        detailsString = detailsString.concat(titleString);   // NOW "ISBN;TITLE"
        detailsString = detailsString.concat(";"); // NOW "ISBN;TITLE;"

        tmpMapAuthorAndPrice =  (HashMap)tmpMapTitle.get(titleString);
        tmpIterator = tmpMapAuthorAndPrice.keySet().iterator();
        authorString = tmpIterator.next().toString();

        detailsString = detailsString.concat(authorString+";");// NOW "ISBN;TITLE;AUTHOR"
        priceString = tmpMapAuthorAndPrice.get(authorString).toString();

        detailsString = detailsString.concat(priceString);// NOW "ISBN;TITLE;AUTHOR;PRICE"

        return detailsString;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getDetailsByAuthor(String author) throws RemoteException{

        String detailsString = new String("");
        String titleString = new String("");
        String authorString = new String("");
        String priceString = new String("");
        String isbnString = new String("");

        Iterator tmpIterator;

        List<String> allIsbnList = this.getAllISBN();
        Map tmpMapTitle = new HashMap<String,HashMap<String,String>>();
        Map tmpMapAuthorAndPrice = new HashMap<String, String>();


        for (int i =0; i < allIsbnList.size(); i++)
        {
            isbnString = allIsbnList.get(i);
            tmpMapTitle = books.get(allIsbnList.get(i));
            tmpIterator = tmpMapTitle.keySet().iterator();
            titleString = tmpIterator.next().toString();

            tmpMapAuthorAndPrice =  (HashMap)tmpMapTitle.get(titleString);
            tmpIterator = tmpMapAuthorAndPrice.keySet().iterator();
            authorString = tmpIterator.next().toString();

            if(authorString.equalsIgnoreCase(author))
            {
                priceString = tmpMapAuthorAndPrice.get(authorString).toString();
                detailsString = detailsString.concat("ISBN :"+isbnString+";"+titleString+";"+authorString+";"+priceString);
                break;
            }

        }

        return detailsString;
    }

    @Override
    public String getDetailsByTitle(String title) throws  RemoteException{

        String detailsString = new String("");
        String titleString = new String("");
        String authorString = new String("");
        String priceString = new String("");
        String isbnString = new String("");

        Iterator tmpIterator;

        List<String> allIsbnList = this.getAllISBN();
        Map tmpMapTitle = new HashMap<String,HashMap<String,String>>();
        Map tmpMapAuthorAndPrice = new HashMap<String, String>();

        for (int i =0; i < allIsbnList.size(); i++)
        {
            isbnString = allIsbnList.get(i);
            tmpMapTitle = books.get(allIsbnList.get(i));
            tmpIterator = tmpMapTitle.keySet().iterator();
            titleString = tmpIterator.next().toString();

            if (titleString.equalsIgnoreCase(title))
            {
                tmpMapAuthorAndPrice =  (HashMap)tmpMapTitle.get(titleString);
                tmpIterator = tmpMapAuthorAndPrice.keySet().iterator();
                authorString = tmpIterator.next().toString();

                priceString = tmpMapAuthorAndPrice.get(authorString).toString();
                detailsString = detailsString.concat("ISBN :"+isbnString+";"+titleString+";"+authorString+";"+priceString);
                break;
            }
        }
        return detailsString;
    }
}
