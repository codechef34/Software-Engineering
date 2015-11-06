package com.pharmacist.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import javax.swing.*;
import com.admin.controller.*;

public class SearchPharmacistPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private AdminController controller = null;
	private JTextField textField;
	
	public SearchPharmacistPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(38, 11, 351, 38);
		add(label);
		
		JLabel lblAddCotor = new JLabel("Search Pharmacist");
		lblAddCotor.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddCotor.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAddCotor.setBounds(150, 60, 102, 27);
		add(lblAddCotor);
		
		JLabel lblDoctorName = new JLabel("Pharmacist Name");
		lblDoctorName.setHorizontalAlignment(SwingConstants.LEFT);
		lblDoctorName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoctorName.setBounds(49, 107, 120, 27);
		add(lblDoctorName);
				
		JButton btnCreate = new JButton("Search");
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCreate.setBounds(108, 169, 97, 27);
		add(btnCreate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnToPharmacistRecordPanel();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnCancel.setBounds(215, 169, 97, 27);
		add(btnCancel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(179, 111, 184, 22);
		add(textField);
	}

}
