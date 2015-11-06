package MainSystem.Utility;

import java.util.ArrayList;
import java.util.*;

public class Patient
{
    private int qrCode;
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String zip;
    private String email;
    private String phone;
    private String problemDescription; 
    private ArrayList<Prescription> prescriptions;
    
    public Patient () {
        this.prescriptions = new ArrayList<Prescription> ();
    }
    
    public int getQrCode ()
    {
        return qrCode;
    }
    public void setQrCode (int qrCode)
    {
        this.qrCode = qrCode;
    }
    public String getFirstName ()
    {
        return firstName;
    }
    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }
    public String getMiddleName ()
    {
        return middleName;
    }
    public void setMiddleName (String middleName)
    {
        this.middleName = middleName;
    }
    public String getLastName ()
    {
        return lastName;
    }
    public void setLastName (String lastName)
    {
        this.lastName = lastName;
    }
    public String getStreet ()
    {
        return street;
    }
    public void setStreet (String street)
    {
        this.street = street;
    }
    public String getCity ()
    {
        return city;
    }
    public void setCity (String city)
    {
        this.city = city;
    }
    public String getZip ()
    {
        return zip;
    }
    public void setZip (String zip)
    {
        this.zip = zip;
    }
    public String getEmail ()
    {
        return email;
    }
    public void setEmail (String email)
    {
        this.email = email;
    }
    public String getPhone ()
    {
        return phone;
    }
    public void setPhone (String phone)
    {
        this.phone = phone;
    }
    public String getProblemDescription ()
    {
        return problemDescription;
    }
    public void setProblemDescription (String problemDescription)
    {
        this.problemDescription = problemDescription;
    }
    public ArrayList<Prescription> getPrescriptions () {
        return prescriptions;
    }

    public void addPrescription (Prescription prescription) {
        this.prescriptions.add (prescription);
    }
    
    public String toString () {
        StringBuilder output = new StringBuilder ();
        
        output.append (getLastName ());
        output.append (", ");
        output.append (getFirstName ());
        
        return output.toString ();
    }
}
