package MainSystem.Doctor;

import MainSystem.Utility.Medicine;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import MainSystem.Utility.Patient;
import MainSystem.Utility.Prescription;
import java.util.ArrayList;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import javax.swing.*;
import MainSystem.Utility.*;
import java.util.*;

/**
 *
 * @author haile
 */
public class DoctorViewPatientDetailsTab extends JPanel
{   
	private static final long serialVersionUID = 1L; // To remove the warning
	
	private DoctorTab parent;
    JTabbedPane tabbedPane;
    private Patient myPatient;
    DoctorViewPatientOverviewTab patientInfo;
    
    public DoctorViewPatientDetailsTab (DoctorTab doctorTab, Patient patient)
    {
        super.setLayout (new GridLayout (0,1));
        this.parent = doctorTab;
        this.myPatient = patient;
        
        JPanel tabPanel = new JPanel ();
        tabPanel.setLayout (new BorderLayout ());
        tabPanel.setPreferredSize (new Dimension (600, 600));
        
        tabbedPane = new JTabbedPane ();
        
        patientInfo = new DoctorViewPatientOverviewTab(this);
        patientInfo.populatePatient (myPatient);
        JComponent patientInfoTab = patientInfo;
    
        tabbedPane.addTab ("Patient Information",  patientInfoTab);
        
        tabbedPane.setTabLayoutPolicy (JTabbedPane.SCROLL_TAB_LAYOUT);
        
        tabPanel.add (tabbedPane);
        
        this.add (tabPanel, BorderLayout.CENTER);
        
    }
    
    public void closePatient () 
    {
        parent.closePatient (this);
    }
    //DOCTOR
    public int getDoctorId()
    {
        return parent.getDoctorId();
    }
    //MEDICINE
    public  ArrayList<Medicine>  getMedicineRecords()
    {   
        ArrayList<Medicine> medi = new ArrayList<>();
        medi = parent.getMedicineRecords();
        return medi;
    }
    
    public java.util.List<java.util.List<Integer>> getMedicineOfPrescription()
    {
        return patientInfo.getMedicineOfPrescription();
    }
    
    public ArrayList<Integer> getPrescriptionID()
    {
        return patientInfo.getPrescriptionID();
    }
    
    public Patient getPatient()
    {
        return patientInfo.getPatient();
    }
    
    public void updatePrescription()
    {
        //patientInfo.populatePatient(myPatient);
        closePatient();
        parent.addPatientTab(myPatient.getQrCode());
    }
    //
    public void addPrescriptionTab (String prescriptionName , int index)
    {
        if (prescriptionName != null)
        {   
            String[] medications = new String[] 
            {
                    "Aspirin"
            };
            
            
            DateTimeFormatter dtfStart= DateTimeFormat.forPattern("HH:MM:SS");
            String Starttime =  myPatient.getPrescriptions().get(index).getStartTime().toString(dtfStart);
            String Endtime =  myPatient.getPrescriptions().get(index).getEndTime().toString(dtfStart);

            
            DoctorViewPrescriptionTab newTab = new DoctorViewPrescriptionTab (this, medications, 
                    myPatient.getPrescriptions().get(index).getFrequency(), Starttime, 
                    Endtime, "No Need" , index);
            tabbedPane.addTab (prescriptionName, newTab);
            tabbedPane.setSelectedComponent (newTab);
        }
        else
        {
            DoctorViewPrescriptionTab newTab = new DoctorViewPrescriptionTab (this);
            tabbedPane.addTab ("Create Prescription", newTab);
            tabbedPane.setSelectedComponent (newTab);
        }
    }
    
     public boolean updatePrescription (Prescription prescription) 
    {
        boolean sucess;
        sucess = parent.updatePrescription(prescription);
        return sucess;
    }
     
    public boolean removePrescription (int pre_id)
    {
        boolean success;
        success = parent.removePrescription(pre_id);
        return success;
    }
    
    public boolean createPrescription (Prescription prescription)
    {
        boolean success = false;
        success = parent.createPrescription(prescription);
        return success;
    }
     
    public void closePrescriptionTab (DoctorViewPrescriptionTab doctorPatientPrescription) 
    {
        tabbedPane.remove (doctorPatientPrescription);
    }
    
}
