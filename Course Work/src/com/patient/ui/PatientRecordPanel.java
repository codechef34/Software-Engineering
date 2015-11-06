package com.patient.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import javax.swing.*;
import com.admin.controller.*;

public class PatientRecordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private AdminController controller = null;

	public PatientRecordPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(26, 11, 351, 38);
		add(label);
		
		JLabel lblPatientPanel = new JLabel("Patient Panel");
		lblPatientPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientPanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPatientPanel.setBounds(143, 74, 102, 27);
		add(lblPatientPanel);
		
		JButton btnAddPatient = new JButton("Add Patient");
		btnAddPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addPatientBtnClicked();
			}
		});
		btnAddPatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddPatient.setBounds(120, 112, 157, 27);
		add(btnAddPatient);
		
		JButton btnEditPatient = new JButton("Edit Patient");
		btnEditPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.editPatientBtnClicked();
			}
		});
		btnEditPatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEditPatient.setBounds(120, 150, 157, 27);
		add(btnEditPatient);
		
		JButton btnSearchPatient = new JButton("Search Patient");
		btnSearchPatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.searchPatientBtnClicked();
			}
		});
		btnSearchPatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearchPatient.setBounds(120, 188, 157, 27);
		add(btnSearchPatient);
		
		JButton btnDeletePatient = new JButton("Delete Patient");
		btnDeletePatient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deletePatientBtnClicked();
			}
		});
		btnDeletePatient.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeletePatient.setBounds(120, 226, 157, 27);
		add(btnDeletePatient);
		
		JButton button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnFromRecordPanelClicked();
			}
		});
		button_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button_4.setBounds(353, 262, 75, 27);
		add(button_4);
	}

}
