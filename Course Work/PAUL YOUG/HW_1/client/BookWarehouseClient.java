import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Exception;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.rmi.*;
import java.util.*;
import javax.naming.*;




public class BookWarehouseClient {

    static List<String> allIsbns = new ArrayList<String>();
    static List<String> allAuthors = new ArrayList<String>();
    static List<String> allTitles = new ArrayList<String>();


    static JComboBox isbnBox = new JComboBox();
    static JComboBox authorBox = new JComboBox();
    static JComboBox titleBox = new JComboBox();
    static JLabel bookDetailsPrint = new JLabel("--");
    static Container pane;
    static BookWarehouse bw;


    public static void main(String[] args) throws NamingException, RemoteException{





        Context namingContext = new InitialContext();

        System.out.println("RMI registry bindings: ");

        Enumeration<NameClassPair> e = namingContext.list("rmi://localhost/");
        while(e.hasMoreElements())
            System.out.println(e.nextElement().getName());

        String url = "rmi://localhost/book_warehouse";
        bw = (BookWarehouse) namingContext.lookup(url);


        JFrame frame = new JFrame("Bookstore Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         pane = frame.getContentPane();

        allIsbns = bw.getAllISBN();
        allAuthors = bw.getAllAuthors();
        allTitles = bw.getAllBooks();

        isbnBox = new JComboBox(bw.getAllISBN().toArray());
        authorBox = new JComboBox(bw.getAllAuthors().toArray());
        titleBox = new JComboBox(bw.getAllBooks().toArray());

        JLabel priceLabelLbl = new JLabel();
        JLabel selectBookLbl = new JLabel("Select Book");
        selectBookLbl.setText("Select Book");
        JLabel byTitleLbl = new JLabel("By Title");
        byTitleLbl.setText("By Title");
        JLabel byAuthorLbl = new JLabel("By Author");
        byAuthorLbl.setText("By Author");
        JLabel byIsbnLbl = new JLabel("By ISBN");
        byIsbnLbl.setText("By ISBN");

        JLabel bookDetailsLbl = new JLabel("Book Details");

        isbnBox.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try
                {

                bookDetailsPrint.setText(bw.getDetailsByIsbn(allIsbns.get(isbnBox.getSelectedIndex())));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        authorBox.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                bookDetailsPrint.setText(bw.getDetailsByAuthor(allAuthors.get(authorBox.getSelectedIndex())));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });


        titleBox.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {

                bookDetailsPrint.setText(bw.getDetailsByTitle(allTitles.get(titleBox.getSelectedIndex())));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });


        pane.setLayout(new GridBagLayout());

        GridBagConstraints c =   new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 40;
        pane.add(selectBookLbl, c);


        //ByISBN
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(byIsbnLbl,c);

        //By Author
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(byAuthorLbl,c);

        //By ISBN
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(byTitleLbl,c);

        //By ISBN Combo
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(isbnBox,c);

        //By Title Combo
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(authorBox,c);

        //By Author Combo
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(titleBox,c);


        //Book Details Lbl
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(bookDetailsLbl,c);

        //Book Details Print

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 3;
        pane.add(bookDetailsPrint,c);

        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
}

