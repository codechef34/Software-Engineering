package MainSystem.Main;

import MainSystem.Admin.LoginController;
import MainSystem.DatabaseConnection.Datastore;
import MainSystem.Utility.*;

import java.sql.SQLException;
import java.util.*;
import MainSystem.Admin.*;
import MainSystem.DatabaseConnection.*;

public class Controller
{
    private GUI gui;
    private LoginController loginController;
    private Datastore datastore;

    // PATIENT
    public Patient getPatientInformation (int patientId) 
    {
        throw new UnsupportedOperationException ();
    }
    
    public java.util.List<Patient> getPatientRecords () 
    {
        throw new UnsupportedOperationException ();
    }
    
    // PRESCRIPTION
    public Prescription getPrescription (int prescriptionId) 
    {
        throw new UnsupportedOperationException ();
    }

    public boolean updatePrescription (Prescription prescription) 
    {
        boolean sucess;
        sucess = datastore.updatePrescription(prescription);
        return sucess;
    }

    public boolean createPrescription (Prescription prescription)
    {
        boolean success = false;
        success = datastore.createPrescription(prescription);
        return success;
    }
    
    public boolean removePrescription (int pre_id)
    {
        boolean success;
        success = datastore.removePrescription(pre_id);
        return success;
    }
    
    // DOCTOR 
    //Get a list of doctor
    public java.util.List<Doctor> getDoctorRecords()
    {
        List<Doctor> doctorList = new ArrayList<Doctor>();
        
        doctorList = datastore.getDoctorRecords();
        
        return doctorList;
    }
    
    //Get a list of patient who are assigned to doctor.
    public ArrayList<Patient> getPatientOfDoctor(int doctor_id)
    {
        ArrayList<Patient> patientList = new ArrayList<Patient>();
        
        patientList = datastore.getPatientsOfDoctor(doctor_id);
        
        return patientList;
    }
    
    public Controller ()
    {
        try
        {
            this.loginController = new LoginController (this);
            this.gui = new GUI (this);
            this.datastore = new Datastore ();
            
            loginController.showLoginGUI ();
        }
        catch (SQLException e)
        {
            // TODO: Some form of error message, probably something along the lines of "could not establish a connection with the database"
            System.err.println ("SQL Error: " + e.getMessage ());
        }
    }

    
    //MEDICINE
    public ArrayList<Medicine>  getMedicineRecords()
    {   
        ArrayList<Medicine> medi = new ArrayList<>();
        medi = datastore.getMedicineRecords();
        return medi;
    }
    
    public static void main (String[] args)
    {
        new Controller ();
    }

    public void requestMainStartup ()
    {
        gui.startGUI ();
    }

    public boolean validateCredentials (String username, String password)
    {
        return datastore.validateCredentials (username, password);
    }

    public Patient getPatient (int patientId) {
        return datastore.getPatient (patientId);
    }

}
