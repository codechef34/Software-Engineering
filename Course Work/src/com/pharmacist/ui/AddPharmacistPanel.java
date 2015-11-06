
package com.pharmacist.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import com.doctor.controller.DoctorController;
import com.doctor.model.DoctorModel;
import com.nurse.controller.NurseController;
import com.nurse.model.NurseModel;
import com.patient.controller.PatientController;
import com.patient.model.PatientModel;
import com.pharmacist.controller.PharmacistController;
import com.pharmacist.model.PharmacistModel;
import javax.swing.*;
import com.admin.controller.*;
import com.pharmacist.model.*;
import com.pharmacist.controller.*;

public class AddPharmacistPanel extends JPanel {
	private JTextField firstNameField;	
	private JTextField middleNameField;
	private JTextField lastNameField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField department_idField;
	private JTextField zipField;
	private JTextField phoneField;
	private JTextField emailField;
	private JTextField admin_idField;
	private JTextField pharmacist_idField;

	/**
	 * Create the panel.
	 */
	
	private AdminController controller = null;
	private PharmacistModel pharmacistmodel=null;
	private PharmacistController pharmacistcontroller=null;
	public AddPharmacistPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		pharmacistmodel=new PharmacistModel();
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(151, 11, 351, 38);
		add(label);
		
		JLabel lblAddCotor = new JLabel("Add Pharmacist");
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
		
		JLabel lblDepartmentCode = new JLabel("Department Code");
		lblDepartmentCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDepartmentCode.setBounds(315, 144, 116, 27);
		add(lblDepartmentCode);
		
		department_idField = new JTextField();
		department_idField.setColumns(10);
		//JComboBox comboBox = new JComboBox();
		department_idField.setBounds(441, 149, 116, 20);
		add(department_idField);
		
		JLabel lblContactNumber = new JLabel("Email");
		lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactNumber.setBounds(49, 259, 102, 27);
		add(lblContactNumber);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(169, 263, 126, 22);
		add(emailField);
		
		
		
		JLabel lblAddress = new JLabel("Street");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddress.setBounds(49, 183, 102, 27);
		add(lblAddress);
		
		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(169, 187, 126, 22);
		add(streetField);
		
		JButton btnCreate = new JButton("Add");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(controller.getPharmacistController()==null)
				{
					pharmacistcontroller=new PharmacistController();
					controller.setPharmacistController(pharmacistcontroller);

				}
				else
				{
					pharmacistcontroller=controller.getPharmacistController();

				}
				pharmacistmodel.setFirst_name(firstNameField.getText());
				pharmacistmodel.setLast_name(lastNameField.getText());
				pharmacistmodel.setMiddle_name(middleNameField.getText());
				pharmacistmodel.setStreet(streetField.getText());
				pharmacistmodel.setCity(cityField.getText());
				pharmacistmodel.setZip(zipField.getText());
				pharmacistmodel.setEmail(emailField.getText());
				pharmacistmodel.setPhone(phoneField.getText());
				pharmacistmodel.setDepartment_code(Integer.parseInt(department_idField.getText()));
				pharmacistmodel.setAdmin_id(Integer.parseInt(admin_idField.getText()));
				pharmacistmodel.setPharmacist_id(Integer.parseInt(pharmacist_idField.getText()));
				
				
				
				pharmacistcontroller.addPharmacistRecord(pharmacistmodel);
			}
		});
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreate.setBounds(169, 333, 97, 27);
		add(btnCreate);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnClear.setBounds(273, 333, 97, 27);
		add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToNurseRecordPanel();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(377, 333, 97, 27);
		add(btnCancel);
		
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
		
		
		JLabel lblAdminId = new JLabel("Admin Id");
		lblAdminId.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdminId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAdminId.setBounds(315, 259, 102, 27);
		add(lblAdminId);
		
		admin_idField = new JTextField();
		admin_idField.setColumns(10);
		admin_idField.setBounds(441, 259, 126, 22);
		add(admin_idField);
		
		JLabel lblDocotorId = new JLabel("Pharmacist Id");
		lblDocotorId.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocotorId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDocotorId.setBounds(49, 284, 102, 27);;
		add(lblDocotorId);
		
		pharmacist_idField = new JTextField();
		pharmacist_idField.setColumns(10);
		pharmacist_idField.setBounds(169, 292, 126, 22);
		add(pharmacist_idField);
		
	}
}
