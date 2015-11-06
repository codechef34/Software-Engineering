package MainSystem.Doctor;

import MainSystem.Main.Controller;
import MainSystem.Utility.*;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import MainSystem.Main.*;
import java.util.*;

/**
 *
 * @author haile
 */
public class DoctorGUI extends JPanel
{   
	private static final long serialVersionUID = 1L; // To remove the warning

	private Controller parent;
    
    private JPanel tabPanel;
    private JTabbedPane tabbedPane;
    private int doctor_id;
    
    public DoctorGUI(Controller parent)
    {
       this.parent = parent;
       
       super.setLayout (new GridLayout (0, 1)); 
       
       tabPanel = new JPanel ();
       tabPanel.setLayout (new GridLayout (0, 1));
       tabPanel.setPreferredSize (new Dimension (600, 600));
       
       tabbedPane = new JTabbedPane();
       
       //Create a JComponent for view all patient GUI
       JComponent viewAllDoctor = new ViewAllDoctorTabs(this);

       tabbedPane.addTab("View All Doctors", viewAllDoctor);
       
       tabbedPane.setTabLayoutPolicy (JTabbedPane.SCROLL_TAB_LAYOUT);
        
       tabPanel.add (tabbedPane);
        
       this.add (tabPanel);
    }
        
    public void doctorSelected (int id, String doctor) 
    {
        JComponent doctorTab = new DoctorTab(this,id);
        doctor_id = id;
        tabbedPane.add (doctor, doctorTab);
        
        tabbedPane.setSelectedComponent(doctorTab);
    }
    
    public void closePatientOfDoctor (DoctorTab doctorviewPatient)
    {
        tabbedPane.remove(doctorviewPatient);
        
    }
    public java.util.List<Doctor> getDoctorRecords()
    {
        java.util.List<Doctor> doctorList = new ArrayList<Doctor>();
        doctorList = parent.getDoctorRecords();
        return doctorList;
    }
    
    public int getDoctorId()
    {
        return doctor_id;
    }
    
    //Get a list of patient who are assigned to doctor with doctor_id
    public ArrayList<Patient> getPatientOfDoctor(int doctor_id)
    {
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        
        patientList = parent.getPatientOfDoctor(doctor_id);
        
        return patientList;
    }

    public Patient getPatient (int patientId) {
        return parent.getPatient (patientId);
    }
    
    //MEDICINE
    public ArrayList<Medicine>  getMedicineRecords()
    {   
        ArrayList<Medicine> medi = new ArrayList<>();
        medi = parent.getMedicineRecords();
        return medi;
    }
    
    //PRESCRIPTION
    //Modified a prescription
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
}
    

