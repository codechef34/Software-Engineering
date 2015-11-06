package com.pharmacist.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.medicine.ui.AddMedicinePanel;
import com.medicine.ui.DeleteMedicinePanel;
import com.medicine.ui.EditMedicinePanel;
import com.medicine.ui.SearchMedicinePanel;
import com.pharmacist.controller.PharmacistController;
import javax.swing.*;
import com.pharmacist.controller.*;
import com.medicine.ui.*;

public class PharmacistPanel1 extends JPanel {

	/**
	 * Create the panel.
	 */
	
	PharmacistController controller = null;
	public JPanel mainPanel = null;
	public AddMedicinePanel addMedicinePanel = null;
	public EditMedicinePanel editMedicinePanel = null;
	public SearchMedicinePanel searchMedicinePanel = null;
	public DeleteMedicinePanel deleteMedicinePanel = null;

	public PharmacistPanel1( PharmacistController _controller) {
		setLayout(new BorderLayout());
		controller = _controller;
		mainPanel = constructMainPanel();
		
		addMedicinePanel = new AddMedicinePanel(controller);
		editMedicinePanel = new EditMedicinePanel(controller);
		searchMedicinePanel = new SearchMedicinePanel(controller);
		deleteMedicinePanel = new DeleteMedicinePanel(controller);
		
		add(mainPanel, BorderLayout.CENTER);
	}
		
	public JPanel constructMainPanel() {

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		JLabel label = new JLabel("University of Central Arkansas");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		label.setBounds(35, 11, 351, 38);
		mainPanel.add(label);
		
		JLabel lblPharmacistPanel = new JLabel("Pharmacist Panel");
		lblPharmacistPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblPharmacistPanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPharmacistPanel.setBounds(149, 82, 135, 27);
		mainPanel.add(lblPharmacistPanel);
		
		JButton btnAddMedicine = new JButton("Add Medicine");
		btnAddMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.addMedicineButtonClicked();
			}
		});
		btnAddMedicine.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddMedicine.setBounds(135, 123, 157, 27);
		mainPanel.add(btnAddMedicine);
		
		JButton btnEditMedicine = new JButton("Edit Medicine");
		btnEditMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.editMedicineButtonClicked();
			}
		});
		btnEditMedicine.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnEditMedicine.setBounds(135, 159, 157, 27);
		mainPanel.add(btnEditMedicine);
		
		JButton btnDeleteMedicine = new JButton("Search Medicine");
		btnDeleteMedicine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.searchMedicineButtonClicked();
			}
		});
		btnDeleteMedicine.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeleteMedicine.setBounds(135, 197, 157, 27);
		mainPanel.add(btnDeleteMedicine);
		
		JButton btnDeleteMedicine_1 = new JButton("Delete Medicine");
		btnDeleteMedicine_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.deleteMedicineButtonClicked();
			}
		});
		btnDeleteMedicine_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDeleteMedicine_1.setBounds(135, 235, 157, 27);
		mainPanel.add(btnDeleteMedicine_1);
		
		return mainPanel;
	}
	
	public void initAddMedicinePanel(){
		
		removeAll();
		add(addMedicinePanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initEditMedicinePanel(){
		
		removeAll();
		add(editMedicinePanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initSearchMedicinePanel(){
		
		removeAll();
		add(searchMedicinePanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initDeleteMedicinePanel(){
		
		removeAll();
		add(deleteMedicinePanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initMainPanel(){
		
		removeAll();
		add(mainPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

}
