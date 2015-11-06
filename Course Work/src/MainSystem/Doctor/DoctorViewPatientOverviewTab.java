package MainSystem.Doctor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import MainSystem.Doctor.DoctorViewPatientDetailsTab;
import MainSystem.Utility.Patient;
import MainSystem.Utility.Prescription;
import java.util.ArrayList;
import java.awt.event.*;
import MainSystem.Utility.*;
import java.util.*;

/**
 *
 * @author haile
 */
public class DoctorViewPatientOverviewTab extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L; // To remove the warning
	
    private Patient myPatient;
	
    private DoctorViewPatientDetailsTab parent;
    private JTextField idField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField middleNameField;
    private javax.swing.JList<java.lang.String> prescriptionsList;
    private JButton editButton;
    private JButton removeButton;
    private JButton createButton;
    private JButton backButton;
    private javax.swing.DefaultListModel<java.lang.String> prescriptionsListModel;
    
    private java.util.List<java.util.List<Integer>> medicineofPrescrip = new ArrayList<java.util.List<Integer>>();
    private ArrayList<Integer> pre_id = new ArrayList<Integer>();
    //private JLabel label_1;
    //private JLabel lblNewLabel;

    public DoctorViewPatientOverviewTab(DoctorViewPatientDetailsTab parent)
    {
        this.parent = parent;

        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.0, 0.0, 0.0, 1.0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0};
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
        setLayout(gridBagLayout);

        JLabel label;

        label = new JLabel("ID:", SwingConstants.RIGHT);
        GridBagConstraints gbc_ID_label = new GridBagConstraints();
        gbc_ID_label.anchor = GridBagConstraints.EAST;
        gbc_ID_label.insets = new Insets(0, 0, 5, 5);
        gbc_ID_label.gridx = 0;
        gbc_ID_label.gridy = 0;
        this.add(label, gbc_ID_label);

        idField = new JTextField();
        GridBagConstraints gbc_ID_Field = new GridBagConstraints();
        gbc_ID_Field.gridwidth = 3;
        gbc_ID_Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_ID_Field.insets = new Insets(0, 0, 5, 0);
        gbc_ID_Field.gridx = 1;
        gbc_ID_Field.gridy = 0;
        this.add(idField, gbc_ID_Field);

        label = new JLabel("First Name:", SwingConstants.RIGHT);
        GridBagConstraints gpc_Firstname_Label = new GridBagConstraints();
        gpc_Firstname_Label.anchor = GridBagConstraints.EAST;
        gpc_Firstname_Label.insets = new Insets(0, 0, 5, 5);
        gpc_Firstname_Label.gridx = 0;
        gpc_Firstname_Label.gridy = 1;
        this.add(label, gpc_Firstname_Label);

        firstNameField = new JTextField();
        GridBagConstraints gbc_FirstName_Field = new GridBagConstraints();
        gbc_FirstName_Field.gridwidth = 3;
        gbc_FirstName_Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_FirstName_Field.insets = new Insets(0, 0, 5, 0);
        gbc_FirstName_Field.gridx = 1;
        gbc_FirstName_Field.gridy = 1;
        this.add(firstNameField, gbc_FirstName_Field);

        label = new JLabel("Middle Name:", SwingConstants.RIGHT);
        GridBagConstraints gbc_MiddleName_Label = new GridBagConstraints();
        gbc_MiddleName_Label.anchor = GridBagConstraints.EAST;
        gbc_MiddleName_Label.insets = new Insets(0, 0, 5, 5);
        gbc_MiddleName_Label.gridx = 0;
        gbc_MiddleName_Label.gridy = 2;
        this.add(label, gbc_MiddleName_Label);

        middleNameField = new JTextField();
        GridBagConstraints gbc_Middle_Field = new GridBagConstraints();
        gbc_Middle_Field.gridwidth = 3;
        gbc_Middle_Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_Middle_Field.insets = new Insets(0, 0, 5, 0);
        gbc_Middle_Field.gridx = 1;
        gbc_Middle_Field.gridy = 2;
        this.add(middleNameField, gbc_Middle_Field);

        label = new JLabel("Last Name:", SwingConstants.RIGHT);
        GridBagConstraints gbc_Lastname_Label = new GridBagConstraints();
        gbc_Lastname_Label.anchor = GridBagConstraints.EAST;
        gbc_Lastname_Label.insets = new Insets(0, 0, 5, 5);
        gbc_Lastname_Label.gridx = 0;
        gbc_Lastname_Label.gridy = 3;
        this.add(label, gbc_Lastname_Label);

        lastNameField = new JTextField();
        GridBagConstraints gbc_Lastname_Field = new GridBagConstraints();
        gbc_Lastname_Field.gridwidth = 3;
        gbc_Lastname_Field.fill = GridBagConstraints.HORIZONTAL;
        gbc_Lastname_Field.insets = new Insets(0, 0, 5, 0);
        gbc_Lastname_Field.gridx = 1;
        gbc_Lastname_Field.gridy = 3;
        this.add(lastNameField, gbc_Lastname_Field);

        label = new JLabel("Prescriptions:", SwingConstants.RIGHT);
        GridBagConstraints gbc_lPrescription_Label = new GridBagConstraints();
        gbc_lPrescription_Label.anchor = GridBagConstraints.EAST;
        gbc_lPrescription_Label.insets = new Insets(0, 0, 5, 5);
        gbc_lPrescription_Label.gridx = 0;
        gbc_lPrescription_Label.gridy = 4;
        this.add(label, gbc_lPrescription_Label);

        prescriptionsListModel = new DefaultListModel ();
        prescriptionsList = new JList(prescriptionsListModel);
        prescriptionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        prescriptionsList.setLayoutOrientation(JList.VERTICAL);
        prescriptionsList.setVisibleRowCount(-1);

        JScrollPane prescriptionsScrollPane = new JScrollPane(prescriptionsList);

        GridBagConstraints gbc_Prescriptions_List = new GridBagConstraints();
        gbc_Prescriptions_List.fill = GridBagConstraints.BOTH;
        gbc_Prescriptions_List.gridwidth = 3;
        gbc_Prescriptions_List.insets = new Insets(0, 0, 5, 0);
        gbc_Prescriptions_List.gridx = 1;
        gbc_Prescriptions_List.gridy = 4;
        add(prescriptionsScrollPane, gbc_Prescriptions_List);

        editButton = new JButton("Edit");
        editButton.addActionListener(this);
        GridBagConstraints gbc_edit_Button = new GridBagConstraints();
        gbc_edit_Button.fill = GridBagConstraints.HORIZONTAL;
        gbc_edit_Button.insets = new Insets(0, 0, 5, 5);
        gbc_edit_Button.gridx = 1;
        gbc_edit_Button.gridy = 5;
        this.add(editButton, gbc_edit_Button);
        gbc_edit_Button.insets = new Insets(0, 0, 0, 5);
        gbc_edit_Button.gridx = 2;
        gbc_edit_Button.gridy = 5;
        gbc_edit_Button.insets = new Insets(0, 0, 0, 5);
        gbc_edit_Button.gridx = 1;
        gbc_edit_Button.gridy = 6;

        removeButton = new JButton("Remove");
        removeButton.addActionListener(this);
        GridBagConstraints gbc_remove_Button = new GridBagConstraints();
        gbc_remove_Button.fill = GridBagConstraints.HORIZONTAL;
        gbc_remove_Button.insets = new Insets(0, 0, 5, 5);
        gbc_remove_Button.gridx = 2;
        gbc_remove_Button.gridy = 5;
        this.add(removeButton, gbc_remove_Button);

        createButton = new JButton("Create");
        createButton.addActionListener(this);
        GridBagConstraints gbc_create_Button = new GridBagConstraints();
        gbc_create_Button.fill = GridBagConstraints.HORIZONTAL;
        gbc_create_Button.insets = new Insets(0, 0, 5, 5);
        gbc_create_Button.gridx = 1;
        gbc_create_Button.gridy = 6;
        this.add(createButton, gbc_create_Button);
        gbc_create_Button.insets = new Insets(0, 0, 0, 5);
        gbc_create_Button.gridx = 2;
        gbc_create_Button.gridy = 7;

        backButton = new JButton("Back");
        backButton.addActionListener(this);
        GridBagConstraints gbc_back_Button = new GridBagConstraints();
        gbc_back_Button.fill = GridBagConstraints.HORIZONTAL;
        gbc_back_Button.insets = new Insets(0, 0, 5, 5);
        gbc_back_Button.gridx = 2;
        gbc_back_Button.gridy = 7;
        this.add(backButton, gbc_back_Button);
    }
    
    public void populatePatient (Patient p) 
    {
        
        this.myPatient = p;
        
        this.idField.setText (String.valueOf (p.getQrCode ()));
        this.firstNameField.setText (p.getFirstName ());
        this.middleNameField.setText (p.getMiddleName ());
        this.lastNameField.setText (p.getLastName ());
        
        prescriptionsListModel.clear ();
        /*
        for (Prescription pre : p.getPrescriptions ()) 
        {
            prescriptionsListModel.addElement (pre.toString());
        }
        */
        //medicineIndex = new int[p.getPrescriptions()]
        
        ArrayList<Medicine> medi = new ArrayList<>();
        medi = parent.getMedicineRecords();
        
        for (int i = 0; i < p.getPrescriptions().size(); i++)
        {   
            String temp = "";
            ArrayList<Integer> medicine_temp = new ArrayList<>();
            for (int j = 0; j < p.getPrescriptions().get(i).getMedications().size(); j++)
            {
                //Need to change if medicine QR codes are changed
                
                temp += (p.getPrescriptions().get(i).getMedications().get(j).getName() + " " + p.getPrescriptions().get(i).getMedications().get(j).getDose() + " | ");
                for (int k = 0; k < medi.size(); k++)
                {   
                    if(p.getPrescriptions().get(i).getMedications().get(j).getQrCode() == medi.get(k).getQrCode())
                    {
                    //medicine_temp.add(p.getPrescriptions().get(i).getMedications().get(j).getQrCode()%1000-1);
                        medicine_temp.add(k);
                        break;
                    }
                }
            }
            //temp += p.getPrescriptions().get(i).getStartTime().+" "+ p.getPrescriptions().get(i).getEndTime().getMinuteOfHour();
            pre_id.add(p.getPrescriptions().get(i).getPrescriptionId());
            
            medicineofPrescrip.add(medicine_temp);
            
            prescriptionsListModel.addElement (temp);
        }
    }
    
    public java.util.List<java.util.List<Integer>> getMedicineOfPrescription()
    {
        return medicineofPrescrip;
    }
    
    public ArrayList<Integer> getPrescriptionID()
    {
        return pre_id;
    }
    
    public Patient getPatient()
    {
        return myPatient;
    }
    @Override
    // Parent is Doctor_View_Detail_Pateints_Tab
    public void actionPerformed (ActionEvent arg0) 
    {
        if (arg0.getSource () == editButton) 
        {
            if (prescriptionsList.getSelectedIndex () != -1) 
            {
                parent.addPrescriptionTab ((String) prescriptionsList.getSelectedValue(),prescriptionsList.getSelectedIndex());
               
            }
        }
        else if (arg0.getSource () == createButton) 
        {
            //Add new medicie to the prescription.
            parent.addPrescriptionTab (null,0);
        }
        else if (arg0.getSource () == removeButton) 
        {
            if (prescriptionsList.getSelectedIndex () == -1)
            {
                JOptionPane.showMessageDialog (this, "You must select a prescription to remove it!");
            }
            else
            {
                int result = JOptionPane.showConfirmDialog (this, "Are you sure you would like to remove the " + prescriptionsList.getSelectedValue () + " prescription?");
                if (result == JOptionPane.YES_OPTION)
                {
                    // TODO: Remove element from list
                    boolean success;
                    success = parent.removePrescription(myPatient.getPrescriptions().get(prescriptionsList.getSelectedIndex()).getPrescriptionId());
                    parent.updatePrescription();
                }
            }
        }
        else if (arg0.getSource () == backButton) 
        {
            parent.closePatient ();
        }
    }
}
