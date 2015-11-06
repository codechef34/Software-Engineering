package MainSystem.Main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.admin.controller.AdminController;
import com.pharmacist.controller.PharmacistController;


//import MainSystem.Admin.AdminController;
//import MainSystem.Admin.AdminGUI;
import MainSystem.Doctor.DoctorGUI;
//import MainSystem.Pharmacist.PharmacistGUI;
import MainSystem.Utility.Patient;
import MainSystem.Utility.Prescription;
import javax.swing.*;
import MainSystem.Utility.*;
import java.util.*;

public class GUI
{
    private Controller parent;
    //private AdminController adminController;
    private JFrame frame;
    //private DoctorGUI doctorGUI;
    private JComponent doctorPanel;
    private JComponent adminPanel;
    private JComponent pharmacistPanel;
    
    public GUI (Controller parent)
    {
        this.parent = parent;
    }
    
    public void startGUI ()
    {
        frame = new JFrame ("Admin GUI");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setLayout (new BorderLayout ());
        
        JPanel tabPanel = new JPanel ();
        tabPanel.setLayout (new BorderLayout ());
        tabPanel.setPreferredSize (new Dimension (600, 600));
        
        // Create 3 tabs for Admin, Doctor, Pharmacist
        JTabbedPane tabbedPane = new JTabbedPane ();
        
        //adminController = new AdminController (parent);
        //adminPanel = new AdminGUI (adminController);
        
        // JComponent of DoctorGUI
        doctorPanel = new DoctorGUI (parent);
        
        //pharmacistPanel = new PharmacistGUI ();
        
        AdminController adminController = new AdminController();
        JComponent adminPanel = adminController.getAdminPanel();
        
        //JComponent pharmacistPanel = makeTextPanel("Pharmacist");
        PharmacistController pharmacistController = new PharmacistController();
        JComponent pharmacistPanel = pharmacistController.getPharmacistPanel();
    
        // Add 3 tabs to the Start GUI
        tabbedPane.addTab ("Admin",  adminPanel);
        tabbedPane.addTab ("Doctor", doctorPanel);
        tabbedPane.addTab ("Pharmacist", pharmacistPanel);
        
        tabbedPane.setTabLayoutPolicy (JTabbedPane.SCROLL_TAB_LAYOUT);
        
        tabPanel.add (tabbedPane, BorderLayout.CENTER);
        
        
        frame.add(tabPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    public Patient getPatientInformation (Patient patientId)
    {
        throw new UnsupportedOperationException ();
    }

    public Prescription getPrescription (int prescriptionId)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean updatePrescription (Prescription prescription)
    {
        throw new UnsupportedOperationException ();
    }

    public java.util.List<Patient> getPatientRecords ()
    {
        throw new UnsupportedOperationException ();
    }
}
