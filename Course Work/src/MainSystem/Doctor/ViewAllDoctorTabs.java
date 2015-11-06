package MainSystem.Doctor;

import MainSystem.Utility.Doctor;
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
public class ViewAllDoctorTabs extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L; // To remove the warning
	
	private JButton viewDoctorButton;
    private JList list;
    private JTabbedPane tabbedPane;
    private DoctorGUI parent;
    private java.util.List<Doctor> doctorList = new ArrayList<Doctor>();
    
    public ViewAllDoctorTabs (DoctorGUI parent)
    {
        this.parent = parent;
        
        this.setLayout (new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints ();
        
        doctorList = parent.getDoctorRecords();
        
        //Will put query 
        String[] people = new String[doctorList.size()]; 
        
        for ( int i = 0; i < doctorList.size(); i++)
        {
            people[i] = doctorList.get(i).getFirstName() + ", " + doctorList.get(i).getLastName();
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
        
        
        viewDoctorButton = new JButton ("View Selected Doctor");
        viewDoctorButton.addActionListener (this);
        
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.ipady = 0;
        c.fill = GridBagConstraints.NONE;
        c.gridx = 0;
        c.gridy = GridBagConstraints.RELATIVE;
        //c.weightx = 1.0f;
        c.weighty = 0.1f;
        
        this.add (viewDoctorButton, c);
        
        
        
    };

    public void addViewAllPatientTab(int id, String doctor)
    {
        parent.doctorSelected (id, doctor); 
    }
    
    
    public void closePatient (DoctorViewPatientDetailsTab doctorPatientTab) 
    {
        tabbedPane.remove (doctorPatientTab);
    }
        
    public int getDoctorId()
    {
        return doctorList.get(list.getSelectedIndex()).getDoctorId();
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) 
    {
         if (arg0.getSource () == viewDoctorButton) 
         {
            if (list.getSelectedIndex () == -1) 
            {
                JOptionPane.showMessageDialog (this, "Please select a doctor!");
            }
            else 
            {
                // Call addViewAllPatientTab function in DoctorGUI
               this.addViewAllPatientTab (doctorList.get(list.getSelectedIndex()).getDoctorId(), (String) list.getSelectedValue ());
            }
        }
    }   
}
