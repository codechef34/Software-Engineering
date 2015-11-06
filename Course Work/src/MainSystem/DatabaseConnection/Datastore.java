package MainSystem.DatabaseConnection;

import MainSystem.Utility.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.util.sql.DBconnection;
import java.sql.*;

public class Datastore
{
    private Connection conn = null;
    private Statement stmt;
    
    public Datastore () throws SQLException
    {
        conn = DBconnection.getConnection();
        stmt = conn.createStatement ();
    }

    public java.util.List<Patient> getPatientRecords ()
    {
        throw new UnsupportedOperationException ();
    }
    
    public Patient getPatientInformation (int patientId)
    {
        throw new UnsupportedOperationException ();
    }

    public Prescription getPrescription (int prescriptionId)
    {
        throw new UnsupportedOperationException ();
    }

    public String getAllMedicineQRHtml ()
    {
        throw new UnsupportedOperationException ();
    }

    public String getAllPatientQRHtml ()
    {
        throw new UnsupportedOperationException ();
    }

    public java.util.List<Medicine> getListOfMedicine ()
    {
        throw new UnsupportedOperationException ();
    }

    public Medicine getMedicineDetails (Medicine medicineId)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean createPatient (Patient patient)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean createDoctor (Doctor doctor)
    {
        throw new UnsupportedOperationException ();
    }
    
    public boolean createNewMedicine (Medicine medicine)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean updateDoctor (Doctor doctor)
    {
        throw new UnsupportedOperationException ();
    }
    
    //Update prescription
    public boolean updatePrescription (Prescription prescription)
    {
        boolean sucess = false;
        DateTimeFormatter dtf= DateTimeFormat.forPattern("HH:MM:SS");
        String Starttime =  prescription.getStartTime().toString(dtf);
        String Endtime =  prescription.getEndTime().toString(dtf);
            
        String query = "UPDATE prescription SET frequency='"+prescription.getFrequency()
                +"',startTime='"+Starttime+"',endTime='"+Endtime+"'"
                +" WHERE prescription_id="+prescription.getPrescriptionId();
        
        try 
        {
            stmt.executeUpdate(query);
            sucess = true;
            

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            sucess = false;
        }
        
        String query1 = "DELETE FROM medpres WHERE prescription_id = "+ prescription.getPrescriptionId();
        try 
        {
            stmt.executeUpdate(query1);
            sucess = true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            sucess = false;
        }
        
        for (int i = 0; i < prescription.getMedications().size();i++)
        {
            String query2 = "INSERT INTO medpres (id,qr_code,prescription_id) "
                + "VALUES ('1','"+prescription.getMedications().get(i).getQrCode()+"','"+prescription.getPrescriptionId()+"')";
            
            try 
            {   
                stmt.executeUpdate(query2);
                sucess = true;
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
                sucess = false;
            }
        }
        return sucess;
    }
    
    //Create prescription
    public boolean createPrescription (Prescription prescription)
    {
        boolean success = false;
        boolean id_full = true;
        String query1 = "SELECT prescription_id from prescription ORDER BY prescription_id ASC";
        try 
        {
            Statement stmt1 = conn.createStatement ();
            ResultSet rs = stmt1.executeQuery (query1);
            success = true;
            int i = 1;
            /*
            while (rs.next ()) 
            {   
                
                //Reuse the old ID
                //Check if id is already exist.
                if(rs.getInt("prescription_id") != i)
                {
                    DateTimeFormatter dtf= DateTimeFormat.forPattern("HH:MM:SS");
                    String Starttime =  prescription.getStartTime().toString(dtf);
                    String Endtime =  prescription.getEndTime().toString(dtf);
                    
                    id_full = false;
                    String query2 = "insert into prescription" +
                                    " VALUES  ("+i+","+prescription.getPatient_id()+","+prescription.getDoctor_id()+",'0000-00-00 00:00:00','"
                                    +prescription.getFrequency()+"','null','" + Starttime + "','" + Endtime + "')";
                    try 
                    {
                        stmt.executeUpdate(query2);
                        success = true;
                    } 
                    catch (SQLException e) 
                    {    
                        e.printStackTrace();
                        success = false;
                    }
                    break;
                }
              
                
                i++;
                
            }
            
            */
            //Get the max id value
            while(rs.next())
            {
                if (i < rs.getInt("prescription_id"))
                {
                    i = rs.getInt("prescription_id");
                }
            }
            
            i++;
            
            if(id_full == true)
            {

                DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:MM:SS");
                String Starttime = prescription.getStartTime().toString(dtf);
                String Endtime = prescription.getEndTime().toString(dtf);

                id_full = false;
               String query2 = "insert into prescription" +
                                    " VALUES  ("+i+","+prescription.getPatient_id()+","+prescription.getDoctor_id()+",'0000-00-00 00:00:00','"
                                    +prescription.getFrequency()+"','null','" + Starttime + "','" + Endtime + "')";
                try {
                    stmt.executeUpdate(query2);
                    success = true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    success = false;
                }
            }
            
            for (int j = 0; j < prescription.getMedications().size(); j++) 
            {
                String query2 = "INSERT INTO medpres (id,qr_code,prescription_id) "
                        + "VALUES ('1','" + prescription.getMedications().get(j).getQrCode() + "','" + i + "')";

                try 
                {
                    stmt.executeUpdate(query2);
                    success = true;
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                    success = false;
                }
            } 
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            success = false;
        }
        
        return success;
    }
    
    //Delete prescriptioin
    public boolean removePrescription (int pre_id)
    {
        boolean success = false;
        String query1 = "DELETE FROM medpres WHERE prescription_id = " + pre_id;
        try 
        {
            stmt.executeUpdate(query1);
            success = true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            success = false;
        }
        
        String query2 = "DELETE FROM prescription WHERE prescription_id = " + pre_id;
        try 
        {
            stmt.executeUpdate(query2);
            success = true;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            success = false;
        }
        
        return success;
    }
    //MEDICINE
    public ArrayList<Medicine>  getMedicineRecords()
    {   
        ArrayList<Medicine> medicine = new ArrayList<>();
        String query = "select name,form,dose,qr_code,route from medicine";
        int i = 1;
        try
        {
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) 
            {
                Medicine medi = new Medicine();
                medi.setQrCode(rs.getInt("qr_code"));
                medi.setName(rs.getString("name"));
                medi.setForm(rs.getString("form"));
                medi.setDose(rs.getString("dose"));
                medi.setRoute(rs.getString("route"));
                medi.setIndex(i);
                i++;
              medicine.add(medi);
            }
            rs.close();

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return null;
        }

        return medicine;
    }
    
    public boolean updateMedicine (Medicine medicine)
    {
        throw new UnsupportedOperationException ();
    }

    //Get a list of doctor.
    public ArrayList<Doctor> getDoctorRecords () 
    {
        ArrayList<Doctor> retVal = new ArrayList<Doctor> ();
        
        String query = "select doctor_id, first_name, middle_name, last_name, street, city, zip, email, phone, department_code, admin_id from doctor";
        
        try 
        {
            ResultSet rs = stmt.executeQuery (query);
            
            while (rs.next ()) 
            {
                Doctor doc = new Doctor ();
                
                doc.setDoctorId (rs.getInt ("doctor_id"));
                doc.setFirstName (rs.getString ("first_name"));
                doc.setMiddleName (rs.getString ("middle_name"));
                doc.setLastName (rs.getString ("last_name"));
                doc.setStreet (rs.getString ("street"));
                doc.setCity (rs.getString ("city"));
                doc.setZip (rs.getString ("zip"));
                doc.setEmail (rs.getString ("email"));
                doc.setPhone (rs.getString ("phone"));
                doc.setDepartmentCode (rs.getInt ("department_code"));
                doc.setAdminId (rs.getInt ("admin_id"));
                
                retVal.add (doc);
            }
            rs.close ();
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
        return retVal;
    }
    
    //Get a list of patients who assigned to a doctor
    public ArrayList<Patient> getPatientsOfDoctor (int doctor_id)
    {
        ArrayList<Patient> retVal = new ArrayList<Patient> ();
        
        String query = "select "
                + "a.qr_code, first_name, middle_name, last_name, street, city, zip, email, phone, problem_description "
                + "from "
                + "patient a "
                + "join docpatient b "
                + "on a.qr_code = b.qr_code "
                + "where b.doctor_id = " + doctor_id;
        
        try 
        {
            ResultSet rs = stmt.executeQuery (query);
            
            while (rs.next ())
            {
                Patient pat = new Patient ();
                
                pat.setQrCode (rs.getInt ("qr_code"));
                pat.setFirstName (rs.getString ("first_name"));
                pat.setMiddleName (rs.getString ("middle_name"));
                pat.setLastName (rs.getString ("last_name"));
                pat.setStreet (rs.getString ("street"));
                pat.setCity (rs.getString ("city"));
                pat.setZip (rs.getString ("zip"));
                pat.setEmail (rs.getString ("email"));
                pat.setPhone (rs.getString ("phone"));
                pat.setProblemDescription (rs.getString ("problem_description"));
                
                // TODO: Get the prescriptions for the patient and add them to the patient object
                //       then for each of the prescriptions, we need the list of medications.
                
                retVal.add (pat);
            }
            rs.close ();
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        
        return retVal;
    }
    
    public boolean validateCredentials (String username, String password)
    {
        String query = "SELECT count(*) AS cnt FROM admin WHERE username = ? AND password = MD5(?)";
        
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement (query);
            
            preparedStatement.setString (1, username);
            preparedStatement.setString (2, password);
            
            ResultSet rs = preparedStatement.executeQuery ();
            
            // Get the result, if there is one, then we pass
            boolean pass = false;
            if (rs.next ())
            {
                if (rs.getInt ("cnt") == 1)
                {
                    pass = true;
                }
            }
            rs.close ();
            
            return pass;
            
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
            return false;
        }
        
    }

    public boolean deletePatients (List<Integer> patientIds)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean deleteDoctors (List<Integer> doctorIds)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean deleteNurses (List<Integer> nurseIds)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean deletePharmacists (List<Integer> pharmacistIds)
    {
        throw new UnsupportedOperationException ();
    }

    public boolean deleteMedicine (List<Integer> medicineIds)
    {
        throw new UnsupportedOperationException ();
    }

    public Patient getPatient (int patientId) 
    {
        Patient patient = null;
        
        String query = "SELECT qr_code, first_name, last_name, middle_name, street, city, zip, email, phone, problem_description "
                + "FROM patient "
                + "WHERE qr_code = " + patientId;
        
        try 
        {
            Statement stmt1 = conn.createStatement ();
            ResultSet rs = stmt1.executeQuery (query);
            
            while (rs.next ()) {
                patient = new Patient ();
                
                patient.setQrCode (rs.getInt ("qr_code"));
                patient.setFirstName (rs.getString ("first_name"));
                patient.setLastName (rs.getString ("last_name"));
                patient.setMiddleName (rs.getString ("middle_name"));
                patient.setStreet (rs.getString ("street"));
                patient.setCity (rs.getString ("city"));
                patient.setZip (rs.getString ("zip"));
                patient.setEmail (rs.getString ("email"));
                patient.setPhone (rs.getString ("phone"));
                patient.setProblemDescription (rs.getString ("problem_description"));
                
                query = "SELECT prescription_id, patient_qr_code, doctor_id, startTime, endTime, frequency "
                        + "FROM prescription "
                        + "WHERE patient_qr_code = " + patient.getQrCode ();
                
                Statement stmt2 = conn.createStatement ();
                ResultSet prescriptionRS = stmt2.executeQuery (query);
                
                while (prescriptionRS.next ()) {
                    Prescription prescription = new Prescription ();
                    
                    prescription.setPrescriptionId (prescriptionRS.getInt ("prescription_id"));
                    prescription.setStartTime (prescriptionRS.getString ("startTime"));
                    prescription.setEndTime (prescriptionRS.getString ("endTime"));
                    prescription.setFrequency (prescriptionRS.getString ("frequency"));
                    
                    query = "SELECT name, form, dose, a.qr_code, route FROM medicine a "
                            + "JOIN medpres b "
                            + "ON a.qr_code = b.qr_code "
                            + "WHERE b.prescription_id = " + prescription.getPrescriptionId ();
                    
                    Statement stmt3 = conn.createStatement ();
                    ResultSet medicineRS = stmt3.executeQuery (query);
                    
                    while (medicineRS.next ()) {
                        Medicine medicine = new Medicine ();
                        
                        medicine.setQrCode (medicineRS.getInt ("qr_code"));
                        medicine.setName (medicineRS.getString ("name"));
                        medicine.setForm (medicineRS.getString ("form"));
                        medicine.setDose (medicineRS.getString ("dose"));
                        medicine.setRoute (medicineRS.getString ("route"));
                        
                        prescription.addMedicine (medicine);
                    }
                    medicineRS.close ();
                    stmt3.close ();
                    
                    patient.addPrescription (prescription);
                    
                }
                prescriptionRS.close ();
                stmt2.close ();
                
            }
            rs.close ();
            stmt1.close ();
        } catch (SQLException e) {
            e.printStackTrace ();
            return null;
        }
        
        return patient;
    }
}
