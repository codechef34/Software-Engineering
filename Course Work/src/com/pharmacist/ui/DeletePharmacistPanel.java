package com.pharmacist.ui;

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
import com.doctor.controller.DoctorController;
import com.doctor.model.DoctorModel;
import com.nurse.controller.NurseController;
import com.nurse.model.NurseModel;
import com.patient.controller.PatientController;
import com.patient.model.PatientModel;
import com.pharmacist.controller.PharmacistController;
import com.pharmacist.model.PharmacistModel;
import javax.swing.*;
import java.awt.event.*;
import com.admin.controller.*;
import com.pharmacist.controller.*;
import com.pharmacist.model.*;
import java.util.*;

public class DeletePharmacistPanel extends JPanel implements ActionListener{
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
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	
	private AdminController controller = null;
	private PharmacistController pharmacistcontroller=null;
	private ArrayList<PharmacistModel> pharmacistobjects=null;
	
	public DeletePharmacistPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		if(controller.getPharmacistController()==null)
		{
			pharmacistcontroller=new PharmacistController();
			controller.setPharmacistController(pharmacistcontroller);

		}
		else
		{
			pharmacistcontroller=controller.getPharmacistController();
		}

		pharmacistobjects=pharmacistcontroller.getPharmacistObjects();
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(151, 11, 351, 38);
		add(label);
		
		JLabel lblAddCotor = new JLabel("Delete Pharmacist");
		lblAddCotor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCotor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddCotor.setBounds(263, 60, 102, 27);
		add(lblAddCotor);
		
		JLabel lblDoctorName = new JLabel("First Name");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoctorName.setBounds(48, 137, 102, 27);
		add(lblDoctorName);
		
		firstNameField = new JTextField();
		firstNameField.setEditable(false);
		firstNameField.setColumns(10);
		firstNameField.setBounds(168, 141, 126, 22);
		add(firstNameField);
		
		JLabel lblDepartmentCode = new JLabel("Department Code");
		lblDepartmentCode.setHorizontalAlignment(SwingConstants.LEFT);
		lblDepartmentCode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDepartmentCode.setBounds(314, 174, 116, 27);
		add(lblDepartmentCode);
		
		
		department_idField = new JTextField();
		department_idField.setEditable(false);
		department_idField.setColumns(10);
		//JComboBox comboBox = new JComboBox();
		department_idField.setBounds(440, 179, 116, 20);
		add(department_idField);
		
		//JComboBox comboBox = new JComboBox();
		//comboBox.setBounds(440, 179, 116, 20);
		//add(comboBox);
		
		JLabel lblContactNumber = new JLabel("Email");
		lblContactNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactNumber.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblContactNumber.setBounds(48, 289, 102, 27);
		add(lblContactNumber);
		
		streetField = new JTextField();
		streetField.setEditable(false);
		streetField.setColumns(10);
		streetField.setBounds(168, 217, 126, 22);
		add(streetField);
		
		JLabel lblAddress = new JLabel("Street");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddress.setBounds(48, 213, 102, 27);
		add(lblAddress);
		
		emailField = new JTextField();
		emailField.setEditable(false);
		
		emailField.setColumns(10);
		emailField.setBounds(168, 293, 126, 22);
		add(emailField);
		
		
		JButton btnClear = new JButton("Delete");
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnClear.setBounds(272, 353, 97, 27);
		add(btnClear);
		btnClear.addActionListener(this);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPharmacistRecordPanel();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(376, 353, 97, 27);
		add(btnCancel);
		
		middleNameField = new JTextField();
		middleNameField.setEditable(false);
		middleNameField.setColumns(10);
		middleNameField.setBounds(440, 141, 126, 22);
		add(middleNameField);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMiddleName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMiddleName.setBounds(314, 137, 102, 27);
		add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.LEFT);
		lblLastName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblLastName.setBounds(48, 174, 102, 27);
		add(lblLastName);
		
		lastNameField = new JTextField();
		lastNameField.setEditable(false);
		lastNameField.setColumns(10);
		lastNameField.setBounds(168, 178, 126, 22);
		add(lastNameField);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblCity.setBounds(314, 213, 102, 27);
		add(lblCity);
		
		cityField = new JTextField();
		cityField.setEditable(false);
		cityField.setColumns(10);
		cityField.setBounds(440, 217, 126, 22);
		add(cityField);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setHorizontalAlignment(SwingConstants.LEFT);
		lblZip.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblZip.setBounds(48, 251, 102, 27);
		add(lblZip);
		
		zipField = new JTextField();
		zipField.setEditable(false);
		zipField.setColumns(10);
		zipField.setBounds(168, 255, 126, 22);
		add(zipField);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPhone.setBounds(314, 255, 102, 27);
		add(lblPhone);
		
		phoneField = new JTextField();
		phoneField.setEditable(false);
		phoneField.setColumns(10);
		phoneField.setBounds(440, 255, 126, 22);
		add(phoneField);
		
		JLabel lblDoctorId = new JLabel("Pharmacist");
		lblDoctorId.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoctorId.setBounds(48, 99, 102, 27);
		add(lblDoctorId);
		
		
		
		JLabel lblAdminId = new JLabel("Admin Id");
		lblAdminId.setHorizontalAlignment(SwingConstants.LEFT);
		lblAdminId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAdminId.setBounds(315, 289, 102, 27);
		add(lblAdminId);
		
		admin_idField = new JTextField();
		admin_idField.setEditable(false);
		admin_idField.setColumns(10);
		admin_idField.setBounds(441, 289, 126, 22);
		add(admin_idField);
		
		JLabel lblDocotorId = new JLabel("Pharmacist Id");
		lblDocotorId.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocotorId.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDocotorId.setBounds(49, 314, 102, 27);;
		add(lblDocotorId);
		
		pharmacist_idField = new JTextField();
		pharmacist_idField.setEditable(false);
		pharmacist_idField.setColumns(10);
		pharmacist_idField.setBounds(169, 324, 126, 22);
		add(pharmacist_idField);
		
		comboBox = new JComboBox(pharmacistcontroller.getPharmacistList().toArray());
		comboBox.setBounds(167, 104, 263, 20);
		add(comboBox);
		comboBox.addActionListener(this);
		firstNameField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getFirst_name());
		middleNameField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getMiddle_name());
		lastNameField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getLast_name());
		streetField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getStreet());
		cityField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getCity());
		department_idField.setText(Integer.toString(pharmacistobjects.get(comboBox.getSelectedIndex()).getDepartment_code()));
		zipField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getZip());
		phoneField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getPhone());
		emailField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getEmail());
		admin_idField.setText(Integer.toString(pharmacistobjects.get(comboBox.getSelectedIndex()).getAdmin_id()));
		pharmacist_idField.setText(Integer.toString(pharmacistobjects.get(comboBox.getSelectedIndex()).getPharmacist_id()));
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		

		firstNameField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getFirst_name());
		middleNameField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getMiddle_name());
		lastNameField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getLast_name());
		streetField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getStreet());
		cityField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getCity());
		department_idField.setText(Integer.toString(pharmacistobjects.get(comboBox.getSelectedIndex()).getDepartment_code()));
		zipField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getZip());
		phoneField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getPhone());
		emailField.setText(pharmacistobjects.get(comboBox.getSelectedIndex()).getEmail());
		admin_idField.setText(Integer.toString(pharmacistobjects.get(comboBox.getSelectedIndex()).getAdmin_id()));
		pharmacist_idField.setText(Integer.toString(pharmacistobjects.get(comboBox.getSelectedIndex()).getPharmacist_id()));
		
		
		
		if(e.getActionCommand().toString().equals("Delete"))
		{
			try {
		
			pharmacistcontroller.deletePharmacistRecord(pharmacistobjects.get(comboBox.getSelectedIndex()));
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		}

		
	}
}
