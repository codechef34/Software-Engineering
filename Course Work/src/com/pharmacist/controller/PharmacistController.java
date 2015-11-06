package com.pharmacist.controller;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.admin.ui.AdminPanel;
import com.doctor.ui.DoctorRecordPanel;
import com.pharmacist.model.*;
import com.pharmacist.ui.PharmacistPanel1;
import com.doctor.model.*;
import com.doctor.ui.*;
import com.medicine.controller.MedicineController;
import com.medipres.utils.QRCodeGenarator;
import com.patient.model.PatientModel;
import com.util.sql.DBconnection;
import org.apache.log4j.*;
import com.pharmacist.ui.*;
import com.medicine.controller.*;
import java.util.*;

public class PharmacistController {


	private PharmacistModel pharmacistmodel;
	private Logger logger=Logger.getLogger(PharmacistController.class);

	public PharmacistController() {

	}

	public PharmacistController(PharmacistModel pm) {
		this.pharmacistmodel=pm;
	}
	public PharmacistPanel1 pharmacistPanel = new PharmacistPanel1(this);
	private MedicineController medicinecontroll;
	public PharmacistPanel1 getPharmacistPanel(){
		return pharmacistPanel;
	}
	
	public void addMedicineButtonClicked(){
		pharmacistPanel.initAddMedicinePanel();
	}
	
	public void editMedicineButtonClicked(){
		pharmacistPanel.initEditMedicinePanel();
	}
	
	public void searchMedicineButtonClicked(){
		pharmacistPanel.initSearchMedicinePanel();
	}

	public void deleteMedicineButtonClicked(){
		pharmacistPanel.initDeleteMedicinePanel();
	}

	public void backBtnToPharmacistRecordPanel(){
		pharmacistPanel.initMainPanel();
	}
	public void setMedicineController(MedicineController medicinecontrol) {
		this.medicinecontroll=medicinecontrol;
	}
	public MedicineController getMedicineController() {
		return medicinecontroll;
	}


	public boolean addPharmacistRecord(PharmacistModel pm)
	{
		this.pharmacistmodel=pm;
		PreparedStatement ps=null;
		Connection con=null;
		String query=null;
		boolean insertflag=false;
		try
		{
			con=DBconnection.getConnection();
			query="insert into pharmacist values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, pharmacistmodel.getFirst_name());
			ps.setString(2, pharmacistmodel.getLast_name());
			ps.setString(3, pharmacistmodel.getMiddle_name());
			ps.setString(4, pharmacistmodel.getStreet());
			ps.setString(5, pharmacistmodel.getCity());

			ps.setString(6, pharmacistmodel.getZip());
			ps.setString(7, pharmacistmodel.getEmail());
			ps.setString(8, pharmacistmodel.getPhone());
			ps.setInt(9, pharmacistmodel.getDepartment_code());
			ps.setInt(10, pharmacistmodel.getAdmin_id());
			ps.setInt(11, pharmacistmodel.getPharmacist_id());
			System.out.println(ps.toString());
			insertflag=ps.execute();
			
			logger.debug("Pharmacist data inserted to table sucessfully");
			JOptionPane.showConfirmDialog(null, "Pharmacist data added sucessfully");
		}
		catch (Exception e) {
			logger.debug("problem to insert data");
			JOptionPane.showConfirmDialog(null, e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}
		return insertflag;

	}

	public void updatePharmacistRecord(PharmacistModel pm)
	{

		PreparedStatement ps=null;
		Connection con=null;
		String query="";
		try
		{
			query= "UPDATE pharmacist SET first_name = ?, last_name = ?,middle_name= ?,street =?,city=?,zip=?,email=?,phone=?,department_code=?,admin_id=? WHERE pharmacist_id = ?";
			con=DBconnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,  pm.getFirst_name());
			ps.setString(2,  pm.getLast_name());
			ps.setString(3,  pm.getMiddle_name());
			ps.setString(4,  pm.getStreet());
			ps.setString(5,  pm.getCity());
			ps.setString(6,  pm.getZip());
			ps.setString(7,  pm.getEmail());
			ps.setString(8,  pm.getPhone());
			ps.setInt(9,  pm.getDepartment_code());
			ps.setInt(10,  pm.getAdmin_id());
			System.out.println(ps.toString());
			JOptionPane.showConfirmDialog(null, "Pharmacist data updated sucessfully");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}


	}


	public void deletePharmacistRecord(PharmacistModel pm)
	{

		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("delete pharmacist id"+pm.getPharmacist_id());
			query="delete from doctor where doctor_id="+pm.getPharmacist_id();
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			JOptionPane.showConfirmDialog(null, "Pharmacist data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}
	}
	


	public ArrayList<String> getPharmacistList()
	{

		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<String> pharmacistNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select first_name,last_name,middle_name from pharmacist";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			pharmacistNames=new ArrayList<String>();
			while(rs.next())
			{
				pharmacistNames.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return pharmacistNames;
	}
	
	
	public ArrayList<PharmacistModel> getPharmacistObjects()
	{
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<PharmacistModel> pharmacistNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select * from pharmacist";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			pharmacistNames=new ArrayList<PharmacistModel>();
			PharmacistModel pm=null;
			while(rs.next())
			{
				pm=new PharmacistModel();
				pm.setFirst_name(rs.getString(1));
				pm.setLast_name(rs.getString(2));
				pm.setMiddle_name(rs.getString(3));
				
				pm.setStreet(rs.getString(4));
				pm.setCity(rs.getString(5));
				pm.setZip(rs.getString(6));
				pm.setEmail(rs.getString(7));
				pm.setPhone(rs.getString(8));
				pm.setDepartment_code(rs.getInt(9));
				pm.setAdmin_id(rs.getInt(10));
				pm.setPharmacist_id(rs.getInt(11));
				pharmacistNames.add(pm);
				
				
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return pharmacistNames;
	}
	
	
	
	public static void main(String[] args)
	{
		PharmacistController pc=new PharmacistController();
		System.out.println(pc.getPharmacistList());
	}

}
