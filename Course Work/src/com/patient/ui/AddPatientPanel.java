package com.patient.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import com.patient.controller.PatientController;
import com.patient.model.PatientModel;
import javax.swing.*;
import com.admin.controller.*;
import com.patient.model.*;
import com.patient.controller.*;

public class AddPatientPanel extends JPanel {
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

	private PatientModel pateintmodel=null;
	private PatientController patientcontroller=null;
	public AddPatientPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		pateintmodel=new PatientModel();
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(151, 11, 351, 38);
		add(label);

		JLabel lblAddCotor = new JLabel("Add Patient");
		lblAddCotor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCotor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddCotor.setBounds(263, 60, 102, 27);
		add(lblAddCotor);

		JLabel lblDoctorName = new JLabel("First Name");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoctorName.setBounds(49, 107, 102, 27);
		add(lblDoctorName);

		firstNameField = new JTextField();
		firstNameField.setColumns(10);
		firstNameField.setBounds(169, 111, 126, 22);
		add(firstNameField);
		pateintmodel.setFirst_name(firstNameField.getText());

		JLabel lblDepartmentCode = new JLabel("Problem Description");
		lblDepartmentCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDepartmentCode.setBounds(49, 297, 133, 27);
		add(lblDepartmentCode);
		JLabel lblContactNumber = new JLabel("Email");
		lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactNumber.setBounds(49, 259, 102, 27);
		add(lblContactNumber);

		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(169, 187, 126, 22);
		add(streetField);




		JLabel lblAddress = new JLabel("Street");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddress.setBounds(49, 183, 102, 27);
		add(lblAddress);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(169, 263, 126, 22);
		add(emailField);



		middleNameField = new JTextField();
		middleNameField.setColumns(10);
		middleNameField.setBounds(441, 111, 126, 22);
		add(middleNameField);

		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMiddleName.setBounds(315, 107, 102, 27);
		add(lblMiddleName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLastName.setBounds(49, 144, 102, 27);
		add(lblLastName);

		lastNameField = new JTextField();
		lastNameField.setColumns(10);
		lastNameField.setBounds(169, 148, 126, 22);
		add(lastNameField);

		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCity.setBounds(315, 183, 102, 27);
		add(lblCity);

		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(441, 187, 126, 22);
		add(cityField);

		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.LEFT);
		lblZip.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblZip.setBounds(49, 221, 102, 27);
		add(lblZip);

		zipField = new JTextField();
		zipField.setColumns(10);
		zipField.setBounds(169, 225, 126, 22);
		add(zipField);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(315, 221, 102, 27);
		add(lblPhone);

		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(441, 225, 126, 22);
		add(phoneField);

		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(192, 302, 360, 22);
		add(descriptionField);

		JButton btnCreate = new JButton("Add");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(controller.getPatientController()==null)
				{
					patientcontroller=new PatientController();
					controller.setPatientController(patientcontroller);

				}
				else
				{
					patientcontroller=controller.getPatientController();

				}
				pateintmodel.setFirst_name(firstNameField.getText());
				pateintmodel.setLast_name(lastNameField.getText());
				pateintmodel.setMiddle_name(middleNameField.getText());
				pateintmodel.setStreet(streetField.getText());
				pateintmodel.setCity(cityField.getText());
				pateintmodel.setZip(zipField.getText());
				pateintmodel.setEmail(emailField.getText());
				pateintmodel.setPhone(phoneField.getText());
				pateintmodel.setProblem_description(descriptionField.getText());
				pateintmodel.setQr_code(patientcontroller.getQrCodeFromTable());
				
				
				patientcontroller.addPatientRecord(pateintmodel);
			}
		});

		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreate.setBounds(169, 346, 97, 27);
		add(btnCreate);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPatientRecordPanel();
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnClear.setBounds(273, 346, 97, 27);
		add(btnClear);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPatientRecordPanel();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(377, 346, 97, 27);
		add(btnCancel);


	}
}
