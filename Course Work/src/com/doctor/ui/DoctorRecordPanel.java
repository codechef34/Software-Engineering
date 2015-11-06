package com.doctor.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import com.admin.controller.*;

public class DoctorRecordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private AdminController controller = null;
	
	public DoctorRecordPanel(AdminController _controller) {
		this.setLayout(null);
		
		controller = _controller;
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(38, 11, 351, 38);
		add(label);
		
		JLabel lblDoctorPanel = new JLabel("Doctor Panel");
		lblDoctorPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorPanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblDoctorPanel.setBounds(155, 74, 102, 27);
		add(lblDoctorPanel);
		
		JButton btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addDoctorBtnClicked();
			}
		});
		btnAddDoctor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddDoctor.setBounds(132, 112, 157, 27);
		add(btnAddDoctor);
		
		JButton btnEditDoctor = new JButton("Edit Doctor");
		btnEditDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.editDoctorBtnClicked();
			}
		});
		btnEditDoctor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEditDoctor.setBounds(132, 150, 157, 27);
		add(btnEditDoctor);
		
		JButton btnSearchDoctor = new JButton("Search Doctor");
		btnSearchDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.searchDoctorBtnClicked();
			}
		});
		btnSearchDoctor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearchDoctor.setBounds(132, 188, 157, 27);
		add(btnSearchDoctor);
		
		JButton btnDeleteDoctor = new JButton("Delete Doctor");
		btnDeleteDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteDoctorBtnClicked();
			}
		});
		btnDeleteDoctor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeleteDoctor.setBounds(132, 226, 157, 27);
		add(btnDeleteDoctor);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnFromRecordPanelClicked();
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnBack.setBounds(365, 262, 75, 27);
		add(btnBack);
	}

}
