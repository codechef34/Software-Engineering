package MainSystem.Doctor;

import MainSystem.Utility.Medicine;
import MainSystem.Utility.Patient;
import MainSystem.Utility.Prescription;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.util.*;
/**
 *
 * @author haile
 */
public class DoctorViewPrescriptionTab extends JPanel implements ActionListener 
{
    private static final long serialVersionUID = 1L; // To remove the warning
	
    JButton submitButton;
    JButton backButton;
    DoctorViewPatientDetailsTab parent;
     JList medications_List;
    private java.util.List<java.util.List<Integer>> medicineofPrescrip = new ArrayList<java.util.List<Integer>>();
    
    JFormattedTextField stopTime_Field;
    JFormattedTextField startTime_Field;
    JTextField Schedule_Field;
    int index;
    
    public DoctorViewPrescriptionTab (DoctorViewPatientDetailsTab parent) 
    {
        this.parent = parent;
        buildGUI (null, null, null, null, null,-1);
    }
    
    public DoctorViewPrescriptionTab (DoctorViewPatientDetailsTab parent, String[] medications, String schedule, String startTime, String stopTime, String route,int index)
    {
        this.parent = parent;
        buildGUI (medications, schedule, startTime, stopTime, route,index);
    }
    
     private void buildGUI (String[] medications, String schedule, String startTime, String stopTime, String route,int index)
     {
        GridBagLayout gridBagLayout = new GridBagLayout ();
        gridBagLayout.rowWeights = new double[]{0.5, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0};
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        setLayout (gridBagLayout);
        
        JLabel label;
        
        label = new JLabel ("Medications:", SwingConstants.RIGHT);
        GridBagConstraints gbc_Medication_Label = new GridBagConstraints();
        gbc_Medication_Label.anchor = GridBagConstraints.EAST;
        gbc_Medication_Label.insets = new Insets(0, 0, 5, 5);
        gbc_Medication_Label.gridx = 0;
        gbc_Medication_Label.gridy = 0;
        this.add (label, gbc_Medication_Label);
        
        medications_List = new JList (getMedicationsList());
        this.index = index;
        if(this.index != -1)
        {
            //Pre-Select all medicines of Presciption
            medicineofPrescrip = parent.getMedicineOfPrescription();
            
            int[] selected_array = new int[medicineofPrescrip.get(index).size()];
        
            for( int i = 0; i < medicineofPrescrip.get(index).size(); i++)
            {
                selected_array[i] = medicineofPrescrip.get(index).get(i);
            }
        
    
        medications_List.setSelectedIndices(selected_array);
        }
        medications_List.setSelectionMode (ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        medications_List.setLayoutOrientation (JList.VERTICAL);
        medications_List.setVisibleRowCount (-1);
        
        
        JScrollPane scrollPane = new JScrollPane (medications_List);
        
        GridBagConstraints gbc_Prescriptions_List = new GridBagConstraints();
        gbc_Prescriptions_List.fill = GridBagConstraints.BOTH;
        gbc_Prescriptions_List.gridwidth = 3;
        gbc_Prescriptions_List.insets = new Insets(0, 0, 5, 0);
        gbc_Prescriptions_List.gridx = 1;
        gbc_Prescriptions_List.gridy = 0;
        add(scrollPane, gbc_Prescriptions_List);
        
        
        label = new JLabel ("Frequency:", SwingConstants.RIGHT);
        GridBagConstraints gbc_Schedule_Label = new GridBagConstraints();
        gbc_Schedule_Label.anchor = GridBagConstraints.EAST;
        gbc_Schedule_Label.insets = new Insets(0, 0, 5, 5);
        gbc_Schedule_Label.gridx = 0;
        gbc_Schedule_Label.gridy = 1;
        this.add (label, gbc_Schedule_Label);
        
        Schedule_Field = new JTextField ();
        if (schedule != null)
        {
            Schedule_Field.setText (schedule);
        }
        
        GridBagConstraints gbc_FirstName_Field = new GridBagConstraints();
        gbc_FirstName_Field.gridwidth = 3;
        gbc_FirstName_Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_FirstName_Field.insets = new Insets(0, 0, 5, 0);
        gbc_FirstName_Field.gridx = 1;
        gbc_FirstName_Field.gridy = 1;
        this.add (Schedule_Field, gbc_FirstName_Field);
        
        label = new JLabel ("Start Time:", SwingConstants.RIGHT);
        GridBagConstraints gbc_StartTime_Label = new GridBagConstraints();
        gbc_StartTime_Label.anchor = GridBagConstraints.EAST;
        gbc_StartTime_Label.insets = new Insets(0, 0, 5, 5);
        gbc_StartTime_Label.gridx = 0;
        gbc_StartTime_Label.gridy = 2;
        this.add (label, gbc_StartTime_Label);
        
        MaskFormatter mask = null;
        try 
        {
            mask = new MaskFormatter("##:##:00");//the # is for numeric values
            mask.setPlaceholderCharacter('#');
            
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        
        startTime_Field = new JFormattedTextField(mask);
        
        if (startTime != null)
        {
            startTime_Field.setText (startTime);
        }
        
        GridBagConstraints gbc_lastNameField = new GridBagConstraints();
        gbc_lastNameField.gridwidth = 3;
        gbc_lastNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_lastNameField.insets = new Insets(0, 0, 5, 0);
        gbc_lastNameField.gridx = 1;
        gbc_lastNameField.gridy = 2;
        this.add (startTime_Field, gbc_lastNameField);
        
        label = new JLabel ("Stop Time:", SwingConstants.RIGHT);
        GridBagConstraints gbc_StopTime_Label = new GridBagConstraints();
        gbc_StopTime_Label.anchor = GridBagConstraints.EAST;
        gbc_StopTime_Label.insets = new Insets(0, 0, 5, 5);
        gbc_StopTime_Label.gridx = 0;
        gbc_StopTime_Label.gridy = 3;
        this.add (label, gbc_StopTime_Label);
        
        stopTime_Field = new JFormattedTextField(mask);
        
        if (stopTime != null)
        {
            stopTime_Field.setText (stopTime);
        }
        
        GridBagConstraints gbc_middleNameField = new GridBagConstraints();
        gbc_middleNameField.gridwidth = 3;
        gbc_middleNameField.fill = GridBagConstraints.HORIZONTAL;
        gbc_middleNameField.insets = new Insets(0, 0, 5, 0);
        gbc_middleNameField.gridx = 1;
        gbc_middleNameField.gridy = 3;
        this.add (stopTime_Field, gbc_middleNameField);
        
        /*
        label = new JLabel ("Route:", SwingConstants.RIGHT);
        GridBagConstraints gbc_Route_Label = new GridBagConstraints();
        gbc_Route_Label.anchor = GridBagConstraints.EAST;
        gbc_Route_Label.insets = new Insets(0, 0, 5, 5);
        gbc_Route_Label.gridx = 0;
        gbc_Route_Label.gridy = 4;
        this.add (label, gbc_Route_Label);
        
        
        JTextField route_Field = new JTextField ();
        if (route != null)
        {
            route_Field.setText (route);
        }
        
        GridBagConstraints gbc_routeField = new GridBagConstraints();
        gbc_routeField.gridwidth = 3;
        gbc_routeField.fill = GridBagConstraints.HORIZONTAL;
        gbc_routeField.insets = new Insets(0, 0, 5, 0);
        gbc_routeField.gridx = 1;
        gbc_routeField.gridy = 4;
        this.add (route_Field, gbc_routeField);
        */
        
        submitButton = new JButton ("Submit");
        submitButton.addActionListener (this);
        GridBagConstraints gbc_editButton = new GridBagConstraints();
        gbc_editButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_editButton.insets = new Insets(0, 0, 5, 5);
        gbc_editButton.gridx = 1;
        gbc_editButton.gridy = 5;
        this.add (submitButton, gbc_editButton);
        
        
        backButton = new JButton ("Back");
        backButton.addActionListener (this);
        GridBagConstraints gbc_removeButton = new GridBagConstraints();
        gbc_removeButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_removeButton.insets = new Insets(0, 0, 5, 5);
        gbc_removeButton.gridx = 2;
        gbc_removeButton.gridy = 5;
        this.add (backButton, gbc_removeButton);
     }
     
    private String[] getMedicationsList ()     
    {   
        ArrayList<Medicine> medi = new ArrayList<>();
        medi = parent.getMedicineRecords();
        
        String[] medicine = new String[medi.size()]; 
        
        for ( int i = 0; i < medi.size(); i++)
        {
            medicine[i] = medi.get(i).getName() +" | Dose: "+ medi.get(i).getDose()+"mg " + "| Route: "+medi.get(i).getRoute() + " | Form: "+medi.get(i).getForm();
        }
        
        return medicine;
    }
    
    private int[] getMedicineOfPrescription()
    {
        ArrayList<Medicine> medi = new ArrayList<>();
        
        int[] mediOfPre = new int[10];
        
        return mediOfPre;
    }
     
     @Override
    public void actionPerformed (ActionEvent arg0) 
    {
        
        
        if (arg0.getSource () == submitButton)
        {   
            //Check validate of all source
            //Must choose at least one medicine
            if (medications_List.getSelectedIndex () == -1)
            {
                JOptionPane.showMessageDialog (this, "You must select at least one medicine");
            }
            //Must input valid format 
            else if (startTime_Field.isEditValid() == false)
            {
                 JOptionPane.showMessageDialog (this, "You must input valid format for start time.");
            }
            else if (stopTime_Field.isEditValid() == false)
            {
                JOptionPane.showMessageDialog (this, "You must input valid format for stop time.");
            }
            //Must input validate values
            //HOURS
            else if (Integer.valueOf(startTime_Field.getText().substring(0, 2)) > 24)
            {
                JOptionPane.showMessageDialog (this, "Start hour must be less than 24");
            }
            else if (Integer.valueOf(stopTime_Field.getText().substring(0, 2)) > 24)
            {
                JOptionPane.showMessageDialog (this, "Start hour must be less than 24");
            }
            //MINUTES
            else if (Integer.valueOf(startTime_Field.getText().substring(3, 5)) > 60)
            {
                JOptionPane.showMessageDialog (this, "Start hour must be less than 60");
            }
            else if (Integer.valueOf(stopTime_Field.getText().substring(3, 5)) > 60)
            {
                JOptionPane.showMessageDialog (this, "Start hour must be less than 60");
            }
            //Start time must smaller than stop time.
            else if (Integer.valueOf(startTime_Field.getText().substring(0, 2)) > Integer.valueOf(stopTime_Field.getText().substring(0, 2)))
            {
                JOptionPane.showMessageDialog (this, "Start hour must be before stop hour");
            }
            else if (Integer.valueOf(startTime_Field.getText().substring(0, 2)) == Integer.valueOf(stopTime_Field.getText().substring(0, 2)))
            {
                if(Integer.valueOf(startTime_Field.getText().substring(3, 5)) > Integer.valueOf(stopTime_Field.getText().substring(3, 5)))
                    JOptionPane.showMessageDialog (this, "Start minute must be before stop minute");
            }
           
            else if (index != -1) 
            {
                //Medicine medi = new Medicine();
                boolean success = false;
                ArrayList<Medicine> medi_modify = new ArrayList<>();
                ArrayList<Medicine> medi = new ArrayList<>();
                medi = parent.getMedicineRecords();

                ArrayList<Integer> pre_id = new ArrayList<Integer>();
                pre_id = parent.getPrescriptionID();

                //Create update version of a prescription
                Prescription pre = new Prescription();
                pre.setPrescriptionId(pre_id.get(index));
                pre.setFrequency(Schedule_Field.getText());
                pre.setStartTime(startTime_Field.getText());
                pre.setEndTime(stopTime_Field.getText());

            // TODO: Save changes
                //Get the selected medicine indices from the user
                int[] indices = new int[medications_List.getSelectedIndices().length];
                indices = medications_List.getSelectedIndices();

                //Might need to fix later if QR code ID change.
                for (int i = 0; i < medications_List.getSelectedIndices().length; i++) {
                    medi_modify.add(medi.get(indices[i]));
                    pre.addMedicine(medi.get(indices[i]));
                }

            //Get medicine_qr from the selection.
                //int[] medicine_qr = new int[medications_List.getSelectedIndices().length];
                success = parent.updatePrescription(pre);
                if(success == true)
                {
                     JOptionPane.showMessageDialog (this, "Successfully update a new prescription");
                }
                else
                {
                    JOptionPane.showMessageDialog (this, "Fail to update a new prescription");
                }
                parent.closePrescriptionTab(this);
                parent.updatePrescription();
            }
            else
            {
                //Create a new prescription
                boolean success = false;
                Prescription pre = new Prescription();
                ArrayList<Medicine> medi = new ArrayList<>();
                medi = parent.getMedicineRecords();
             
                //Get info of patient.
                Patient myPatient = new Patient();
                myPatient = parent.getPatient();
                //Get everything except the prescriptionID
                pre.setPatient_id(myPatient.getQrCode());
                pre.setDoctor_id(parent.getDoctorId());
                pre.setFrequency(Schedule_Field.getText());
                pre.setStartTime(startTime_Field.getText());
                pre.setEndTime(stopTime_Field.getText());
                
                //Get the selected medicine indices from the user
                int[] indices = new int[medications_List.getSelectedIndices().length];
                indices = medications_List.getSelectedIndices();
                
                for (int i = 0; i < medications_List.getSelectedIndices().length; i++) 
                {
                    //medi_modify.add(medi.get(indices[i]));
                    pre.addMedicine(medi.get(indices[i]));    
                }
                
                success = parent.createPrescription(pre);
                if(success == true)
                {
                     JOptionPane.showMessageDialog (this, "Successfully create a new prescription");
                }
                else
                {
                    JOptionPane.showMessageDialog (this, "Fail to create a new prescription");
                }
                parent.closePrescriptionTab(this);
                parent.updatePrescription();
                
            }
        }
        else if (arg0.getSource () == backButton) 
        {
            parent.closePrescriptionTab (this);
        }
    }
}
