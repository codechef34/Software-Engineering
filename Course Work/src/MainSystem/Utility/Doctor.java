package MainSystem.Utility;

public class Doctor
{
    private int doctorId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phone;
    private int departmentCode;
    private int adminId;
    
    public int getDoctorId ()
    {
        return doctorId;
    }
    public void setDoctorId (int doctorId)
    {
        this.doctorId = doctorId;
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
    public String getState ()
    {
        return state;
    }
    public void setState (String state)
    {
        this.state = state;
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
    public int getDepartmentCode ()
    {
        return departmentCode;
    }
    public void setDepartmentCode (int departmentCode)
    {
        this.departmentCode = departmentCode;
    }
    public int getAdminId ()
    {
        return adminId;
    }
    public void setAdminId (int adminId)
    {
        this.adminId = adminId;
    }
    
    public String toString () {
        StringBuilder output = new StringBuilder ();
        
        output.append (getLastName ());
        output.append (", ");
        output.append (getFirstName ());
        
        return output.toString ();
    }
}
