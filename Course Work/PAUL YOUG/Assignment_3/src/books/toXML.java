/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package books;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;




public class toXML {

       public toXML() { }
 
    public void readFile() {
    try {
        
        ClassLoader loader = books.ObjectFactory.class.getClassLoader();
        JAXBContext jc = JAXBContext.newInstance("books",loader);
 
       
        File inFile = new File("books.xml");

        Books myBooks;
 
        
        Unmarshaller u = jc.createUnmarshaller();
 
      
        myBooks = (Books) u.unmarshal(inFile);
        
       System.out.println("\nGiven prices:\n");  
 
        for(int i = 0; i < myBooks.getBook().size(); i++)
        {
            System.out.println(myBooks.getBook().get(i).getTitle() + "; " +
                    myBooks.getBook().get(i).getAuthor() + "; " +
                    myBooks.getBook().get(i).getPrice());
        }
        
        //Now update prices of the books 
        this.xmlconvert(myBooks);
        
        //Now write the new xml by marshing
        //this.writeXml(myBooks);
        
    }
    catch (JAXBException cnf) {
        System.out.println("Class not found");
        cnf.printStackTrace();
    }
 
}// end readFile()
    
    public void xmlconvert(Books mybook){
       
       ArrayList<Double> updatedprices = new ArrayList<Double>();
       updatedprices.add(22.00);
       updatedprices.add(63.05);
       updatedprices.add(4.70);
       updatedprices.add(16.65);
       
        
        
        for(int i = 0; i < mybook.getBook().size(); i++)
        {
            mybook.getBook().get(i).setPrice(BigDecimal.valueOf(updatedprices.get(i)));
        }
       
        System.out.println("\nLatestprices:\n");   
      
        
        for(int i = 0; i < mybook.getBook().size(); i++)
        {
            System.out.println(mybook.getBook().get(i).getTitle() + "; " +
                    mybook.getBook().get(i).getAuthor() + "; " +
                    mybook.getBook().get(i).getPrice());
        }
        try{
        File xmlout = new File("newbooks.xml");
		JAXBContext jc = JAXBContext.newInstance(Books.class);
		Marshaller jm = jc.createMarshaller();
 
		
		jm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jm.marshal(mybook, xmlout);
		jm.marshal(mybook, System.out);
                
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
        
        
    } 
    
  
    public static void main(String[] args) {
       toXML print = new toXML();
       print.readFile();
    }
}

