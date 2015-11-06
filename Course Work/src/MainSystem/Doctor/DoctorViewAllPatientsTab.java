package MainSystem.Doctor;

import MainSystem.Utility.Patient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.event.*;
import MainSystem.Utility.*;
import java.util.*;

/**
 *
 * @author haile
 */
public class DoctorViewAllPatientsTab extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L; // To remove the warning
	
    private JButton viewPatientButton;
    private JButton backButton;
    private JList list;
    private DoctorTab parent;
    private ArrayList<Patient> patientList;
    
    public DoctorViewAllPatientsTab (DoctorTab doctorTab, int id) 
    {
        this.parent = doctorTab;
        
        this.setLayout (new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints ();
        
        patientList = parent.getPatientOfDoctor(id);
        

        String[] people = new String[patientList.size()]; 
        
        for ( int i = 0; i < patientList.size(); i++)
        {
            people[i] = patientList.get(i).toString ();
        }
        
        
        list = new JList (people);
        list.setSelectionMode (ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation (JList.VERTICAL);
        list.setVisibleRowCount (-1);
        
        JScrollPane listScroller = new JScrollPane (list);
        listScroller.setPreferredSize (new Dimension (250, 80));

        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.ipady = 40;
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0f;
        c.weighty = 1.0f;
        
        this.add (listScroller, c);
        
        
        viewPatientButton = new JButton ("View Selected Patient");
        viewPatientButton.addActionListener (this);
        
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.ipady = 0;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        //c.weightx = 1.0f;
        c.weighty = 0.1f;
        this.add (viewPatientButton, c);
        
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.ipady = 0;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        //c.weightx = 1.0f;
        c.weighty = 0.1f;
        this.add(backButton,c);
        
    };
    
    
    @Override
    public void actionPerformed (ActionEvent arg0) 
    {
        if (arg0.getSource () == viewPatientButton)
        {
            if (list.getSelectedIndex () == -1) 
            {
                JOptionPane.showMessageDialog (this, "Please select a patient!");
            }
            else 
            {
                // Call addPatientTab function in DoctorTab
                // Return the name of patient
                int patientId = patientList.get (list.getSelectedIndex ()).getQrCode ();
                parent.addPatientTab (patientId);
            }
        }
        else if (arg0.getSource() == backButton)
        {
            parent.clossPatientofDoctor();
        }
    }
    
    
}
