package MainSystem.Doctor;

import MainSystem.Utility.Medicine;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import MainSystem.Utility.Patient;
import MainSystem.Utility.Prescription;
import javax.swing.*;
import MainSystem.Utility.*;
import java.util.*;

public class DoctorTab extends JPanel 
{
	private static final long serialVersionUID = 1L; // To remove the warning

	private DoctorGUI parent;
    
    private JPanel tabPanel;
    private JTabbedPane tabbedPane;
    
    public DoctorTab (DoctorGUI parent, int id) 
    {
        super.setLayout (new GridLayout (0, 1)); 
        this.parent = parent;
        
        tabPanel = new JPanel ();
        tabPanel.setLayout (new GridLayout (0, 1));
        tabPanel.setPreferredSize (new Dimension (600, 600));
        
        tabbedPane = new JTabbedPane();
        
        // Create a JComponent for view all patient GUI
        JComponent doctorViewAllPatientsTab = new DoctorViewAllPatientsTab(this, id);
        
        tabbedPane.addTab("View All Patients", doctorViewAllPatientsTab);
        
        tabbedPane.setTabLayoutPolicy (JTabbedPane.SCROLL_TAB_LAYOUT);
         
        tabPanel.add (tabbedPane);
         
        this.add (tabPanel);
        
    }
    
    public ArrayList<Patient> getPatientOfDoctor(int doctor_id)
    {
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        
        patientList = parent.getPatientOfDoctor(doctor_id);
        
        return patientList;
    }
    
    public void addPatientTab (int patientId) 
    {
        Patient patient = parent.getPatient (patientId);
        JComponent patientTab = new DoctorViewPatientDetailsTab (this, patient);
        
        tabbedPane.addTab (patient.toString (), patientTab);
        tabbedPane.setSelectedComponent (patientTab);
    }

    public void closePatient (DoctorViewPatientDetailsTab doctorViewPatientDetailsTab) 
    {
        tabbedPane.remove (doctorViewPatientDetailsTab);
    }
    
    public void clossPatientofDoctor ()
    {
        parent.closePatientOfDoctor(this);
    }
    
     //MEDICINE
    public  ArrayList<Medicine>  getMedicineRecords()
    {   
        ArrayList<Medicine> medi = new ArrayList<>();
        medi = parent.getMedicineRecords();
        return medi;
    }
    
    //PRESCRIPTION
     public boolean updatePrescription (Prescription prescription) 
    {
        boolean sucess;
        sucess = parent.updatePrescription(prescription);
        return sucess;
    }
     
    public boolean createPrescription (Prescription prescription)
    {
        boolean success = false;
        success = parent.createPrescription(prescription);
        return success;
    }
    
    public boolean removePrescription (int pre_id)
    {
        boolean success;
        success = parent.removePrescription(pre_id);
        return success;
    }
    
    //DOCTOR
    public int getDoctorId()
    {
        return parent.getDoctorId();
    }
}
