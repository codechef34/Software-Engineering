package com.medicine.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.medicine.controller.MedicineController;
import com.medicine.model.MedicineModel;
import com.patient.controller.PatientController;
import com.patient.model.PatientModel;
import com.pharmacist.controller.PharmacistController;

import javax.swing.JComboBox;
import javax.swing.*;
import java.awt.event.*;
import com.pharmacist.controller.*;
import com.medicine.model.*;
import com.medicine.controller.*;
import java.util.*;

public class DeleteMedicinePanel extends JPanel implements ActionListener {
	private JTextField nameField;
	private JTextField formField;
	private JTextField doseField;
	private JTextField qrCodeField;
	private JTextField pharmacistIDField;
	private JTextField routeField;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	
	PharmacistController controller = null;
	private MedicineModel medicinemodel=null;
	private MedicineController medicinecontroller=null;
	private ArrayList<MedicineModel> medicineobjects=null;
	public DeleteMedicinePanel(PharmacistController _controller) {
		setLayout(null);
		controller = _controller;


		if(controller.getMedicineController()==null)
		{
			medicinecontroller=new MedicineController();
			controller.setMedicineController(medicinecontroller);

		}
		else
		{
			medicinecontroller=controller.getMedicineController();
		}

		medicineobjects=medicinecontroller.getMedicineObjects();
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(45, 11, 351, 38);
		add(label);
		
		JLabel lblAddMedicine = new JLabel("Delete Medicine");
		lblAddMedicine.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddMedicine.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddMedicine.setBounds(159, 73, 135, 27);
		add(lblAddMedicine);
		
		JLabel lblMedicineName = new JLabel("Medicine Name");
		lblMedicineName.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedicineName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMedicineName.setBounds(90, 120, 102, 27);
		add(lblMedicineName);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setColumns(10);
		nameField.setBounds(210, 124, 126, 22);
		add(nameField);
		
		JLabel lblMedicineForm = new JLabel("Medicine Form");
		lblMedicineForm.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedicineForm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMedicineForm.setBounds(90, 158, 102, 27);
		add(lblMedicineForm);
		
		formField = new JTextField();
		formField.setEditable(false);
		formField.setColumns(10);
		formField.setBounds(210, 162, 126, 22);
		add(formField);
		
		JLabel lblMedicineDose = new JLabel("Medicine Dose");
		lblMedicineDose.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedicineDose.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMedicineDose.setBounds(90, 196, 102, 27);
		add(lblMedicineDose);
		
		doseField = new JTextField();
		doseField.setEditable(false);
		doseField.setColumns(10);
		doseField.setBounds(210, 200, 126, 22);
		add(doseField);
		
		JLabel lblMedicinepharmacistid = new JLabel("Pharmacist Id");
		lblMedicinepharmacistid.setHorizontalAlignment(SwingConstants.LEFT);
		lblMedicinepharmacistid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblMedicinepharmacistid.setBounds(90, 235, 102, 27);
		add(lblMedicinepharmacistid);
		
		pharmacistIDField = new JTextField();
		pharmacistIDField.setEditable(false);
		pharmacistIDField.setColumns(10);
		
		pharmacistIDField.setBounds(210, 239, 126, 22);
		add(pharmacistIDField);
		JLabel lblroute = new JLabel("Route");
		lblroute.setHorizontalAlignment(SwingConstants.LEFT);
		lblroute.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblroute.setBounds(90, 274, 102, 27);
		add(lblroute);
		
		routeField = new JTextField();
		routeField.setEditable(false);
		routeField.setColumns(10);
		routeField.setBounds(210, 278, 126, 22);
		add(routeField);
		
		JButton button = new JButton("Delete");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button.setBounds(62, 310, 97, 27);
		add(button);
		button.addActionListener(this);
		
		
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPharmacistRecordPanel();
			}
		});
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button_2.setBounds(270, 310, 97, 27);
		add(button_2);
		comboBox = new JComboBox(medicinecontroller.getMedicineList().toArray());
		comboBox.setBounds(167, 103, 263, 20);
		add(comboBox);
		comboBox.addActionListener(this);
		nameField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getName());
		formField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getForm());
		doseField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getDose());
		pharmacistIDField.setText(Integer.toString(medicineobjects.get(comboBox.getSelectedIndex()).getPharmacist_id()));
		routeField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getRoute());
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			nameField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getName());
			formField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getForm());
			doseField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getDose());
			pharmacistIDField.setText(Integer.toString(medicineobjects.get(comboBox.getSelectedIndex()).getPharmacist_id()));
			routeField.setText(medicineobjects.get(comboBox.getSelectedIndex()).getRoute());
		
	

		
		
		
		if(e.getActionCommand().toString().equals("Delete"))
		{
			try {
		
				medicinecontroller.deleteMedicineRecord(medicineobjects.get(comboBox.getSelectedIndex()));
			} catch (Exception exe) {
				exe.printStackTrace();
			}
		

		
	}
	}
}