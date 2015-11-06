package com.pharmacist.ui;

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

public class PharmacistRecordPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private AdminController controller = null;
	public PharmacistRecordPanel(AdminController _controller) {
		setLayout(null);
		controller = _controller;
		
		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(38, 11, 351, 38);
		add(label);
		
		JLabel lblPharmacistPanel = new JLabel("Pharmacist Panel");
		lblPharmacistPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPharmacistPanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPharmacistPanel.setBounds(142, 74, 134, 27);
		add(lblPharmacistPanel);
		
		JButton btnAddPharmacist = new JButton("Add Pharmacist");
		btnAddPharmacist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addPharmacistBtnClicked();
			}
		});
		btnAddPharmacist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddPharmacist.setBounds(132, 112, 157, 27);
		add(btnAddPharmacist);
		
		JButton btnEditPharmacist = new JButton("Edit Pharmacist");
		btnEditPharmacist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.editPharmacistBtnClicked();
			}
		});
		btnEditPharmacist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEditPharmacist.setBounds(132, 150, 157, 27);
		add(btnEditPharmacist);
		
		JButton btnSearchPharmacist = new JButton("Search Pharmacist");
		btnSearchPharmacist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.searchPharmacistBtnClicked();
			}
		});
		btnSearchPharmacist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnSearchPharmacist.setBounds(132, 188, 157, 27);
		add(btnSearchPharmacist);
		
		JButton btnDeletePharmacist = new JButton("Delete Pharmacist");
		btnDeletePharmacist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deletePharmacistBtnClicked();
			}
		});
		btnDeletePharmacist.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeletePharmacist.setBounds(132, 226, 157, 27);
		add(btnDeletePharmacist);
		
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
