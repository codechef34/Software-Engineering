package com.patient.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import com.patient.controller.PatientController;
import com.patient.model.PatientModel;

import javax.swing.JComboBox;
import javax.swing.*;
import java.awt.event.*;
import com.admin.controller.*;
import com.patient.controller.*;
import com.patient.model.*;
import java.util.*;

public class EditPatientPanel extends JPanel implements ActionListener{
	private JTextField firstNameField;	
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField zipField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField descriptionField;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */

	private AdminController controller = null;
	private PatientController patientcontroller=null;
	private ArrayList<PatientModel> patientobjects=null;
	public EditPatientPanel(AdminController _controller) {
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

		JLabel lblAddCotor = new JLabel("Edit Patient");
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
		firstNameField.setColumns(10);
		firstNameField.setBounds(168, 147, 126, 22);
		firstNameField.setText(patientobjects.get(0).getFirst_name());
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
		streetField.setColumns(10);
		streetField.setText(patientobjects.get(0).getStreet());
		streetField.setBounds(168, 223, 126, 22);
		add(streetField);

		JLabel lblAddress = new JLabel("Street");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddress.setBounds(48, 219, 102, 27);
		add(lblAddress);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(168, 299, 126, 22);
		emailField.setText(patientobjects.get(0).getEmail());
		add(emailField);

		JButton btnCreate = new JButton("Load");
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreate.setBounds(168, 382, 97, 27);
		add(btnCreate);

		JButton btnClear = new JButton("Save");
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
		middleNameField.setColumns(10);
		middleNameField.setBounds(440, 147, 126, 22);
		middleNameField.setText(patientobjects.get(0).getMiddle_name());
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
		lastNameField.setColumns(10);
		lastNameField.setText(patientobjects.get(0).getLast_name());
		lastNameField.setBounds(168, 184, 126, 22);
		add(lastNameField);

		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCity.setBounds(314, 219, 102, 27);
		add(lblCity);

		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setText(patientobjects.get(0).getCity());

		cityField.setBounds(440, 223, 126, 22);
		add(cityField);

		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.LEFT);
		lblZip.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblZip.setBounds(48, 257, 102, 27);
		add(lblZip);

		zipField = new JTextField();
		zipField.setColumns(10);
		zipField.setText(patientobjects.get(0).getZip());
		zipField.setBounds(168, 261, 126, 22);
		add(zipField);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(314, 257, 102, 27);
		add(lblPhone);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(440, 261, 126, 22);
		phoneField.setText(patientobjects.get(0).getPhone());

		add(phoneField);

		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(191, 338, 360, 22);
		descriptionField.setText(patientobjects.get(0).getProblem_description());
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


		if(!e.getActionCommand().toString().equals("Save"))
		{

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

		
		
		
		if(e.getActionCommand().toString().equals("Save"))
		{
			PatientModel pm=patientobjects.get(comboBox.getSelectedIndex());
			pm.setFirst_name(firstNameField.getText());
			
			pm.setMiddle_name(middleNameField.getText());
			
			pm.setLast_name(lastNameField.getText());
			
			pm.setStreet(streetField.getText());
			
			pm.setCity(cityField.getText());
			
			pm.setZip(zipField.getText());
			
			pm.setPhone(phoneField.getText());
			
			pm.setEmail(emailField.getText());
			
			pm.setProblem_description(descriptionField.getText());
			
			
			
			try {
		      System.out.println(pm.getFirst_name());
				patientcontroller.updatePatientRecord(pm);
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

}




}
