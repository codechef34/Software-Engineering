package com.nurse.ui;

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

public class NurseRecordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private AdminController controller = null;
	public NurseRecordPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(38, 11, 351, 38);
		add(label);
		
		JLabel lblNursePanel = new JLabel("Nurse Panel");
		lblNursePanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNursePanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNursePanel.setBounds(155, 74, 102, 27);
		add(lblNursePanel);
		
		JButton btnAddNurse = new JButton("Add Nurse");
		btnAddNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addNurseBtnClicked();
			}
		});
		btnAddNurse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddNurse.setBounds(132, 112, 157, 27);
		add(btnAddNurse);
		
		JButton btnEditNurse = new JButton("Edit Nurse");
		btnEditNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.editNurseBtnClicked();
			}
		});
		btnEditNurse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEditNurse.setBounds(132, 150, 157, 27);
		add(btnEditNurse);
		
		JButton btnSearchNurse = new JButton("Search Nurse");
		btnSearchNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.searchNurseBtnClicked();
			}
		});
		btnSearchNurse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearchNurse.setBounds(132, 188, 157, 27);
		add(btnSearchNurse);
		
		JButton btnDeleteNurse = new JButton("Delete Nurse");
		btnDeleteNurse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteNurseBtnClicked();
			}
		});
		btnDeleteNurse.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeleteNurse.setBounds(132, 226, 157, 27);
		add(btnDeleteNurse);
		
		JButton button_4 = new JButton("Back");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.backBtnFromRecordPanelClicked();
			}
		});
		button_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		button_4.setBounds(365, 262, 75, 27);
		add(button_4);
	}

}
