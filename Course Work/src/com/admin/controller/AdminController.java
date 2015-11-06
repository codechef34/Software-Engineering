package com.admin.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import com.admin.ui.AdminPanel;
import com.doctor.controller.DoctorController;
import com.nurse.controller.NurseController;
import com.patient.controller.PatientController;
import com.pharmacist.controller.PharmacistController;
import com.util.sql.DBconnection;
import com.admin.ui.*;
import com.patient.controller.*;
import com.doctor.controller.*;
import com.nurse.controller.*;
import com.pharmacist.controller.*;
import java.util.*;

public class AdminController {

	public AdminPanel adminPanel = new AdminPanel( this );


	private PatientController patientcontroll;
	private DoctorController doctorcontroll;
	private NurseController nursecontroll;
	private PharmacistController pharmacistcontroll;
	private String username;
	private String password;

	public AdminPanel getAdminPanel() {
		return adminPanel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void setDoctorController(DoctorController doctorcontrol) {
		this.doctorcontroll=doctorcontrol;
	}
	public DoctorController getDoctorController() {
		return doctorcontroll;
	}

	public void setPatientController(PatientController patientcontrol) {
		this.patientcontroll=patientcontrol;
	}
	public PatientController getPatientController() {
		return patientcontroll;
	}
	
	public void setNurseController(NurseController nursecontrol) {
		this.nursecontroll=nursecontrol;
	}
	public NurseController getNurseController() {
		return nursecontroll;
	}
	public void setPharmacistController(PharmacistController pharmacistcontrol) {
		this.pharmacistcontroll=pharmacistcontrol;
	}
	public PharmacistController getPharmacistController() {
		return pharmacistcontroll;
	}



	/*
	public void loginButtonCicked(){

		boolean isValid = isLoginValid();
		if (isValid) {
			adminPanel.initMainPanel();
		}
	}
	*/

	/*
	private boolean isLoginValid() {
		try {
			Hashtable<String, String> getuserlist=getUserList();
			if(getuserlist!=null&&getUsername().length()>=0)
			{
				if(getuserlist.get(getUsername())!=null)
				{
					if(getuserlist.get(getUsername()).equalsIgnoreCase(getPassword()))
					{
						return true;	
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Username and password are not Match");
						return false;
					}
				}
				else
				{

					JOptionPane.showMessageDialog(null, "Username is not Exists in Plase try different User");
					return false;
				}
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Problem "+e.getMessage());
			e.printStackTrace();
			return false;
		}

		return true;
	}
	*/



	public Hashtable<String, String> getUserList()
	{
		Hashtable<String, String> getUserList=new Hashtable<String, String>();
		PreparedStatement ps=null;
		Connection con=null;
		ResultSet rs=null;
		String query=null;
		//boolean insertflag=false;
		try
		{
			con=DBconnection.getConnection();
			query="select username,password from admin";
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next())
			{
				getUserList.put(rs.getString(1), rs.getString(2));
			}

		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Problem "+e.getMessage());
			e.printStackTrace();
			return null;
		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}
		return getUserList;
	}

	public void doctorRecordButtonClicked(){
		adminPanel.initDoctorRecordPanel();
	}

	public void patientRecordButtonClicked(){
		adminPanel.initPatientRecordPanel();
	}

	public void nurseRecordButtonClicked(){
		adminPanel.initNurseRecordPanel();
	}

	public void pharmacistRecordButtonClicked(){
		adminPanel.initPharmacistRecordPanel();
	}

	public void backBtnFromRecordPanelClicked() {
		adminPanel.initMainPanel();
	}

	public void addDoctorBtnClicked(){
		adminPanel.initAddDoctorPanel();
	}

	public void editDoctorBtnClicked(){
		adminPanel.initEditDoctorPanel();
	}

	public void searchDoctorBtnClicked(){
		adminPanel.initSearchDoctorPanel();
	}

	public void deleteDoctorBtnClicked(){
		adminPanel.initDeleteDoctorPanel();
	}

	public void addPatientBtnClicked(){
		adminPanel.initAddPatientPanel();
	}

	public void editPatientBtnClicked(){
		adminPanel.initEditPatientPanel();
	}

	public void searchPatientBtnClicked(){
		adminPanel.initSearchPatientPanel();
	}

	public void deletePatientBtnClicked(){
		adminPanel.initDeletePatientPanel();
	}

	public void addNurseBtnClicked(){
		adminPanel.initAddNursePanel();
	}

	public void editNurseBtnClicked(){
		adminPanel.initEditNursePanel();
	}

	public void searchNurseBtnClicked(){
		adminPanel.initSearchNursePanel();
	}

	public void deleteNurseBtnClicked(){
		adminPanel.initDeleteNursePanel();
	}

	public void addPharmacistBtnClicked(){
		adminPanel.initAddPharmacistPanel();
	}

	public void editPharmacistBtnClicked(){
		adminPanel.initEditPharmacistPanel();
	}

	public void searchPharmacistBtnClicked(){
		adminPanel.initSearchPharmacistPanel();
	}

	public void deletePharmacistBtnClicked(){
		adminPanel.initDeletePharmacistPanel();
	}

	public void backBtnToDoctorRecordPanel() {
		adminPanel.initDoctorRecordPanel();
	}

	public void backBtnToPatientRecordPanel() {
		adminPanel.initPatientRecordPanel();
	}

	public void backBtnToNurseRecordPanel() {
		adminPanel.initNurseRecordPanel();
	}

	public void backBtnToPharmacistRecordPanel() {
		adminPanel.initPharmacistRecordPanel();
	}

}