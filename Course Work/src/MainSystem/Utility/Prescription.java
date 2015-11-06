package MainSystem.Utility;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;

import java.util.*;

public class Prescription
{
    private int prescriptionId;
    private String frequency;
    private DateTime startTime;
    private DateTime endTime;
    private int patient_id;
    private int doctor_id;
    
    private ArrayList<Medicine> medications;
    
    public Prescription () {
        this.medications = new ArrayList<Medicine> ();
    }
    
    public DateTime getStartTime () {
        return startTime;
    }
    public void setStartTime (DateTime startTime) {
        this.startTime = startTime;
    }
    public void setStartTime (String startTime) {
        String pattern = "HH:mm:ss";
        this.startTime = DateTime.parse (startTime, DateTimeFormat.forPattern (pattern));
    }
    public DateTime getEndTime () {
        return endTime;
    }
    public void setEndTime (DateTime endTime) {
        this.endTime = endTime;
    }
    public void setEndTime (String endTime) {
        String pattern = "HH:mm:ss";
        this.endTime = DateTime.parse (endTime, DateTimeFormat.forPattern (pattern));
    }
    public int getPrescriptionId () {
        return prescriptionId;
    }
    public void setPrescriptionId (int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }
    public String getFrequency () {
        return frequency;
    }
    public void setFrequency (String frequency) {
        this.frequency = frequency;
    }
    public void addMedicine (Medicine medicine) {
        this.medications.add (medicine);
    }
    public ArrayList<Medicine> getMedications () {
        return medications;
    }
    
    public void setPatient_id( int patient_id)
    {
        this.patient_id = patient_id;
    }
    public int getPatient_id()
    {
        return this.patient_id;
    }
    public void setDoctor_id(int doctor_id)
    {
        this.doctor_id = doctor_id;
    }
    public int getDoctor_id()
    {
        return this.doctor_id;
    }
    public String toString () {
        StringBuilder out = new StringBuilder ();
        
        boolean first = true;
        for (Medicine m : getMedications ()) {
            if (first) first = false;
            else out.append (", ");
            
            out.append (m.getName ());
        }
        
        out.append (" (");
        out.append (getStartTime ().toString ("hh:mm:ss aa"));
        out.append (" - ");
        out.append (getEndTime ().toString ("hh:mm:ss aa"));
        out.append (")");
        
        return out.toString ();
    }
}
