package com.patient.controller;

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
import com.google.zxing.Result;


import com.medipres.utils.QRCodeGenarator;
//import com.nurse.ui.NurseRecord;
import com.patient.model.PatientModel;
import com.patient.ui.AddPatientPanel;
import com.patient.ui.DeletePatientPanel;
import com.patient.ui.EditPatientPanel;
import com.patient.ui.PatientRecordPanel;
import com.patient.ui.SearchPatientPanel;

import com.util.sql.DBconnection;
import com.patient.model.*;
import org.apache.log4j.*;
import java.util.*;

public class PatientController {


	private PatientModel patientmodel;
	private Logger logger=Logger.getLogger(PatientController.class);

	public PatientController() {

	}

	public PatientController(PatientModel pm) {
		this.patientmodel=pm;
	}


	public boolean addPatientRecord(PatientModel pm)
	{
		this.patientmodel=pm;
		PreparedStatement ps=null;
		Connection con=null;
		String query=null;
		boolean insertflag=false;
		try
		{
			con=DBconnection.getConnection();
			query="insert into patient values(?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, patientmodel.getFirst_name());
			ps.setString(2, patientmodel.getLast_name());
			ps.setString(3, patientmodel.getMiddle_name());
			ps.setString(4, patientmodel.getStreet());
			ps.setString(5, patientmodel.getCity());

			ps.setString(6, patientmodel.getZip());
			ps.setString(7, patientmodel.getEmail());
			ps.setString(8, patientmodel.getPhone());
			ps.setString(9, patientmodel.getProblem_description());
			ps.setInt(10, patientmodel.getQr_code());
			System.out.println(ps.toString());
			insertflag=ps.execute();
			QRCodeGenarator qrcode=new QRCodeGenarator(patientmodel);
			qrcode.QRCodePatient();
			logger.debug("patient data inserted to table sucessfully");
			JOptionPane.showConfirmDialog(null, "patient data added sucessfully");
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

	public void updatePatientRecord(PatientModel pm)
	{

		PreparedStatement ps=null;
		Connection con=null;
		String query="";
		try
		{
			query= "UPDATE patient SET first_name = ?, last_name = ?,middle_name= ?,street =?,city=?,zip=?,email=?,phone=?,problem_description=? WHERE qr_code = ?";
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
			ps.setString(9,  pm.getProblem_description());
			ps.setInt(10,  pm.getQr_code());
			System.out.println(ps.toString());
			JOptionPane.showConfirmDialog(null, "patient data updated sucessfully");
			QRCodeGenarator qrcode=new QRCodeGenarator(pm);
			qrcode.QRCodePatient();
			
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}


	}


	public void deletePatientRecord(PatientModel pm)
	{

		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("delete qr code"+pm.getQr_code());
			query="delete from patient where qr_code="+pm.getQr_code();
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			JOptionPane.showConfirmDialog(null, "patient data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}
	}
	
	public void searchPatientRecord(PatientModel pm)
	{

		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("search qr code"+pm.getQr_code());
			query="select * from patient where first_name="+pm.getQr_code();
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			//JOptionPane.showConfirmDialog(null, "patient data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}
	}
	
	
	public boolean deletedocpatient(int qrcode)
	{
		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("delete qr code"+qrcode);
			query="delete from docpatient where qr_code="+qrcode;
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			//JOptionPane.showConfirmDialog(null, "patient data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}	
		return true;
	}
	
	

	public int getQrCodeFromTable()
	{

		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		try
		{
			con=DBconnection.getConnection();
			String query="select max(qr_code) from patient";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);

			if(rs.next())
			{
				count=rs.getInt(1)+1;
			}
			else
			{
				count=1;
			}
		}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return count;
	}


	public ArrayList<String> getPatientList()
	{

		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<String> patientNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select first_name,last_name,middle_name from patient";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			patientNames=new ArrayList<String>();
			while(rs.next())
			{
				patientNames.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return patientNames;
	}
	
	
	public ArrayList<PatientModel> getPatientObjects()
	{
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<PatientModel> patientNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select * from patient";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			patientNames=new ArrayList<PatientModel>();
			PatientModel pm=null;
			while(rs.next())
			{
				pm=new PatientModel();
				pm.setFirst_name(rs.getString(1));
				pm.setLast_name(rs.getString(2));
				pm.setMiddle_name(rs.getString(3));
				
				pm.setStreet(rs.getString(4));
				pm.setCity(rs.getString(5));
				pm.setZip(rs.getString(6));
				pm.setEmail(rs.getString(7));
				pm.setPhone(rs.getString(8));
				pm.setProblem_description(rs.getString(9));
				pm.setQr_code(rs.getInt(10));
				patientNames.add(pm);
				
				
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return patientNames;
	}
	
	
	
	public static void main(String[] args)
	{
		PatientController pc=new PatientController();
		System.out.println(pc.getPatientList());
	}

}
