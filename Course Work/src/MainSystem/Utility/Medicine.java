package MainSystem.Utility;

public class Medicine
{
    private int qrCode;
    private int index;
    
    private String name;
    private String form;
    private String dose;
    private String route;
    
    public int getQrCode () {
        return qrCode;
    }
    public void setQrCode (int qrCode) {
        this.qrCode = qrCode;
    }
    public String getName () {
        return name;
    }
    public void setName (String name) {
        this.name = name;
    }
    public String getForm () {
        return form;
    }
    public void setForm (String form) {
        this.form = form;
    }
    public String getDose () {
        return dose;
    }
    public void setDose (String dose) {
        this.dose = dose;
    }
    public String getRoute () {
        return route;
    }
    public void setRoute (String route) {
        this.route = route;
    }
    
    public void setIndex(int index)
    {
        this.index = index;
    }
    
    public int getIndex()
    {
        return index;
    }
}
