package com.medicine.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.pharmacist.controller.PharmacistController;
import javax.swing.*;
import com.pharmacist.controller.*;

public class SearchMedicinePanel extends JPanel {
	private JTextField nameField;

	/**
	 * Create the panel.
	 */
	
	PharmacistController controller = null;
	public SearchMedicinePanel(PharmacistController _controller) {
		setLayout(null);
		controller = _controller;
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(45, 11, 351, 38);
		add(label);
		
		JLabel lblAddMedicine = new JLabel("Search Medicine");
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
		nameField.setColumns(10);
		nameField.setBounds(210, 124, 126, 22);
		add(nameField);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearch.setBounds(133, 180, 97, 27);
		add(btnSearch);
		
		JButton button_2 = new JButton("Cancel");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPharmacistRecordPanel();
			}
		});
		button_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button_2.setBounds(255, 180, 97, 27);
		add(button_2);
	}
}
