package com.patient.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import com.patient.controller.PatientController;
import com.patient.model.PatientModel;
import javax.swing.*;
import java.awt.event.*;
import com.admin.controller.*;
import com.patient.controller.*;
import com.patient.model.*;
import java.util.*;

public class DeletePatientPanel extends JPanel implements ActionListener {
	private JTextField firstNameField;	
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField descriptionField;

	/**
	 * Create the panel.
	 */
	
	private AdminController controller = null;
	private PatientController patientcontroller=null;
	private ArrayList<PatientModel> patientobjects=null;
	
	JComboBox comboBox =null;
	public DeletePatientPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		if(controller.getPatientController()==null)
		{
			patientcontroller=new PatientController();
			controller.setPatientController(patientcontroller);

		}
		else
		{
			patientcontroller=controller.getPatientController();
		}

		patientobjects=patientcontroller.getPatientObjects();
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(151, 11, 351, 38);
		add(label);
		
		JLabel lblAddCotor = new JLabel("Delete Patient");
		lblAddCotor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCotor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddCotor.setBounds(263, 60, 102, 27);
		add(lblAddCotor);
		
		JLabel lblDoctorName = new JLabel("First Name");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoctorName.setBounds(48, 143, 102, 27);
		add(lblDoctorName);
		
		firstNameField = new JTextField();
		firstNameField.setEditable(false);
		firstNameField.setColumns(10);
		firstNameField.setBounds(168, 147, 126, 22);
		add(firstNameField);
		
		JLabel lblDepartmentCode = new JLabel("Problem Description");
		lblDepartmentCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDepartmentCode.setBounds(48, 333, 133, 27);
		add(lblDepartmentCode);
		
		JLabel lblContactNumber = new JLabel("Email");
		lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactNumber.setBounds(48, 295, 102, 27);
		add(lblContactNumber);
		
		streetField = new JTextField();
		streetField.setEditable(false);
		streetField.setColumns(10);
		streetField.setBounds(168, 223, 126, 22);
		add(streetField);
		
		JLabel lblAddress = new JLabel("Street");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddress.setBounds(48, 219, 102, 27);
		add(lblAddress);
		
		emailField = new JTextField();
		emailField.setEditable(false);
		emailField.setColumns(10);
		emailField.setBounds(168, 299, 126, 22);
		add(emailField);
		
		
		
		JButton btnClear = new JButton("Delete");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnClear.setBounds(272, 382, 97, 27);
		add(btnClear);
		btnClear.addActionListener(this);
	
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPatientRecordPanel();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(376, 382, 97, 27);
		add(btnCancel);
		
		middleNameField = new JTextField();
		middleNameField.setEditable(false);
		middleNameField.setColumns(10);
		middleNameField.setBounds(440, 147, 126, 22);
		add(middleNameField);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMiddleName.setBounds(314, 143, 102, 27);
		add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLastName.setBounds(48, 180, 102, 27);
		add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setEditable(false);
		lastNameField.setColumns(10);
		lastNameField.setBounds(168, 184, 126, 22);
		add(lastNameField);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCity.setBounds(314, 219, 102, 27);
		add(lblCity);
		
		cityField = new JTextField();
		cityField.setEditable(false);
		cityField.setColumns(10);
		cityField.setBounds(440, 223, 126, 22);
		add(cityField);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.LEFT);
		lblZip.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblZip.setBounds(48, 257, 102, 27);
		add(lblZip);
		
		zipField = new JTextField();
		zipField.setEditable(false);
		zipField.setColumns(10);
		zipField.setBounds(168, 261, 126, 22);
		add(zipField);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(314, 257, 102, 27);
		add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setEditable(false);
		phoneField.setColumns(10);
		phoneField.setBounds(440, 261, 126, 22);
		add(phoneField);
		
		descriptionField = new JTextField();
		descriptionField.setEditable(false);
		descriptionField.setColumns(10);
		descriptionField.setBounds(191, 338, 360, 22);
		add(descriptionField);
		
		JLabel lblPatient = new JLabel("Patient");
		lblPatient.setHorizontalAlignment(SwingConstants.LEFT);
		lblPatient.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPatient.setBounds(48, 98, 102, 27);
		add(lblPatient);
		
		comboBox = new JComboBox(patientcontroller.getPatientList().toArray());
		comboBox.setBounds(167, 103, 263, 20);
		add(comboBox);
		comboBox.addActionListener(this);
		
		firstNameField.setText(patientobjects.get(comboBox.getSelectedIndex()).getFirst_name());
		middleNameField.setText(patientobjects.get(comboBox.getSelectedIndex()).getMiddle_name());
		lastNameField.setText(patientobjects.get(comboBox.getSelectedIndex()).getLast_name());
		streetField.setText(patientobjects.get(comboBox.getSelectedIndex()).getStreet());
		cityField.setText(patientobjects.get(comboBox.getSelectedIndex()).getCity());
		zipField.setText(patientobjects.get(comboBox.getSelectedIndex()).getZip());
		phoneField.setText(patientobjects.get(comboBox.getSelectedIndex()).getPhone());
		emailField.setText(patientobjects.get(comboBox.getSelectedIndex()).getEmail());
		descriptionField.setText(patientobjects.get(comboBox.getSelectedIndex()).getProblem_description());
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {



		firstNameField.setText(patientobjects.get(comboBox.getSelectedIndex()).getFirst_name());
		middleNameField.setText(patientobjects.get(comboBox.getSelectedIndex()).getMiddle_name());
		lastNameField.setText(patientobjects.get(comboBox.getSelectedIndex()).getLast_name());
		streetField.setText(patientobjects.get(comboBox.getSelectedIndex()).getStreet());
		cityField.setText(patientobjects.get(comboBox.getSelectedIndex()).getCity());
		zipField.setText(patientobjects.get(comboBox.getSelectedIndex()).getZip());
		phoneField.setText(patientobjects.get(comboBox.getSelectedIndex()).getPhone());
		emailField.setText(patientobjects.get(comboBox.getSelectedIndex()).getEmail());
		descriptionField.setText(patientobjects.get(comboBox.getSelectedIndex()).getProblem_description());
		
		
		if(e.getActionCommand().toString().equals("Delete"))
		{
			try {
		
				patientcontroller.deletePatientRecord(patientobjects.get(comboBox.getSelectedIndex()));
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

}
}
