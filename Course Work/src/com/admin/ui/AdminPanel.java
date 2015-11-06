package com.admin.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.admin.controller.AdminController;
import com.doctor.ui.AddDoctorPanel;
import com.doctor.ui.DeleteDoctorPanel;
import com.doctor.ui.DoctorRecordPanel;
import com.doctor.ui.EditDoctorPanel;
import com.doctor.ui.SearchDoctorPanel;
import com.nurse.ui.AddNursePanel;
import com.nurse.ui.DeleteNursePanel;
import com.nurse.ui.EditNursePanel;
import com.nurse.ui.NurseRecordPanel;
import com.nurse.ui.SearchNursePanel;
import com.patient.ui.AddPatientPanel;
import com.patient.ui.DeletePatientPanel;
import com.patient.ui.EditPatientPanel;
import com.patient.ui.PatientRecordPanel;
import com.patient.ui.SearchPatientPanel;
import com.pharmacist.ui.AddPharmacistPanel;
import com.pharmacist.ui.DeletePharmacistPanel;
import com.pharmacist.ui.EditPharmacistPanel;
import com.pharmacist.ui.PharmacistRecordPanel;
import com.pharmacist.ui.SearchPharmacistPanel;
import javax.swing.*;
import com.admin.controller.*;
import com.doctor.ui.*;
import com.patient.ui.*;
import com.nurse.ui.*;
import com.pharmacist.ui.*;

public class AdminPanel extends JPanel {
	
	
	AdminController controller = null;
	
	//public AdminLogin adminLogin;
	public DoctorRecordPanel doctorRecordPanel;
	public PatientRecordPanel patientRecordPanel;
	public NurseRecordPanel nurseRecordPanel;
	public PharmacistRecordPanel pharmacistRecordPanel;
	public AddDoctorPanel addDoctorPanel;
	public EditDoctorPanel editDoctorPanel;
	public DeleteDoctorPanel deleteDoctorPanel;
	public SearchDoctorPanel searchDoctorPanel;

	public AddPatientPanel addPatientPanel;
	public EditPatientPanel editPatientPanel;
	public DeletePatientPanel deletePatientPanel;
	public SearchPatientPanel searchPatientPanel;

	public AddNursePanel addNursePanel;
	public EditNursePanel editNursePanel;
	public DeleteNursePanel deleteNursePanel;
	public SearchNursePanel searchNursePanel;

	public AddPharmacistPanel addPharmacistPanel;
	public EditPharmacistPanel editPharmacistPanel;
	public DeletePharmacistPanel deletePharmacistPanel;
	public SearchPharmacistPanel searchPharmacistPanel;

	public JPanel mainPanel = null;
	
	/*
	public AdminLogin getAdminLogin() {
		return adminLogin;
	}
	*/
	
	public AdminPanel( AdminController _controller) {
	
		this.setLayout(new BorderLayout());
		controller = _controller;
		mainPanel = constructMainPanel();
		//adminLogin = new AdminLogin(controller);
                       		
		doctorRecordPanel = new DoctorRecordPanel(controller);
		patientRecordPanel = new PatientRecordPanel(controller);
		nurseRecordPanel = new NurseRecordPanel(controller);
		pharmacistRecordPanel = new PharmacistRecordPanel(controller);

		addDoctorPanel = new AddDoctorPanel(controller);
		editDoctorPanel = new EditDoctorPanel(controller);
		deleteDoctorPanel = new DeleteDoctorPanel(controller);
		searchDoctorPanel = new SearchDoctorPanel(controller);

		addPatientPanel = new AddPatientPanel(controller);
		editPatientPanel = new EditPatientPanel(controller);
		deletePatientPanel = new DeletePatientPanel(controller);
		searchPatientPanel = new SearchPatientPanel(controller);

		addNursePanel = new AddNursePanel(controller);
		editNursePanel = new EditNursePanel(controller);
		deleteNursePanel = new DeleteNursePanel(controller);
		searchNursePanel = new SearchNursePanel(controller);

		addPharmacistPanel = new AddPharmacistPanel(controller);
		editPharmacistPanel = new EditPharmacistPanel(controller);
		deletePharmacistPanel = new DeletePharmacistPanel(controller);
		searchPharmacistPanel = new SearchPharmacistPanel(controller);

		add(mainPanel, BorderLayout.CENTER);
	}
	
	public JPanel constructMainPanel() {
		

		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		JLabel lblUniversityOfCentral = new JLabel("University of Central Arkansas");
		lblUniversityOfCentral.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversityOfCentral.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblUniversityOfCentral.setBounds(37, 11, 351, 38);
		mainPanel.add(lblUniversityOfCentral);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminPanel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblAdminPanel.setBounds(161, 82, 102, 27);
		mainPanel.add(lblAdminPanel);
		
		JButton btnDoctorRecord = new JButton("Doctor Record");
		btnDoctorRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.doctorRecordButtonClicked();
			}
		});
		btnDoctorRecord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnDoctorRecord.setBounds(137, 123, 157, 27);
		mainPanel.add(btnDoctorRecord);
		
		JButton btnPatientRecord = new JButton("Patient Record");
		btnPatientRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.patientRecordButtonClicked();
			}
		});
		btnPatientRecord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPatientRecord.setBounds(137, 159, 157, 27);
		mainPanel.add(btnPatientRecord);
		
		JButton btnRecord = new JButton("Nurse Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.nurseRecordButtonClicked();
			}
		});
		btnRecord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnRecord.setBounds(137, 197, 157, 27);
		mainPanel.add(btnRecord);
		
		JButton btnPharmacistRecord = new JButton("Pharmacist Record");
		btnPharmacistRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.pharmacistRecordButtonClicked();
			}
		});
		btnPharmacistRecord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnPharmacistRecord.setBounds(137, 235, 157, 27);
		mainPanel.add(btnPharmacistRecord);
		
		return mainPanel;
	}
	
	public void initMainPanel(){
		
		removeAll();
		add(mainPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}
	
	public void initDoctorRecordPanel() {
		
		removeAll();
		add(doctorRecordPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initPatientRecordPanel() {
		
		removeAll();
		add(patientRecordPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initNurseRecordPanel() {
		
		removeAll();
		add(nurseRecordPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initPharmacistRecordPanel() {
		
		removeAll();
		add(pharmacistRecordPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}

	public void initAddDoctorPanel() {
		removeAll();
		add(addDoctorPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}
	
	public void initEditDoctorPanel() {
		removeAll();
		add(editDoctorPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initSearchDoctorPanel() {
		removeAll();
		add(searchDoctorPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initDeleteDoctorPanel() {
		removeAll();
		add(deleteDoctorPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initAddPatientPanel() {
		removeAll();
		add(addPatientPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}
	
	public void initEditPatientPanel() {
		removeAll();
		add(editPatientPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initSearchPatientPanel() {
		removeAll();
		add(searchPatientPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initDeletePatientPanel() {
		removeAll();
		add(deletePatientPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initAddNursePanel() {
		removeAll();
		add(addNursePanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}
	
	public void initEditNursePanel() {
		removeAll();
		add(editNursePanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initSearchNursePanel() {
		removeAll();
		add(searchNursePanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initDeleteNursePanel() {
		removeAll();
		add(deleteNursePanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initAddPharmacistPanel() {
		removeAll();
		add(addPharmacistPanel, BorderLayout.CENTER);
		invalidate();
		repaint();
	}
	
	public void initEditPharmacistPanel() {
		removeAll();
		add(editPharmacistPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initSearchPharmacistPanel() {
		removeAll();
		add(searchPharmacistPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	public void initDeletePharmacistPanel() {
		removeAll();
		add(deletePharmacistPanel, BorderLayout.CENTER);
		invalidate();
		repaint();		
	}

	
	
}
