package com.doctor.controller;

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



import com.doctor.model.*;
import com.doctor.ui.*;
import com.medipres.utils.QRCodeGenarator;
import com.patient.model.PatientModel;
import com.util.sql.DBconnection;
import org.apache.log4j.*;
import java.util.*;

public class DoctorController {


	private DoctorModel doctormodel;
	private Logger logger=Logger.getLogger(DoctorController.class);

	public DoctorController() {

	}

	public DoctorController(DoctorModel dm) {
		this.doctormodel=dm;
	}


	public boolean addDoctorRecord(DoctorModel dm)
	{
		this.doctormodel=dm;
		PreparedStatement ps=null;
		Connection con=null;
		String query=null;
		boolean insertflag=false;
		try
		{
			con=DBconnection.getConnection();
			query="insert into doctor values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, doctormodel.getFirst_name());
			ps.setString(2, doctormodel.getLast_name());
			ps.setString(3, doctormodel.getMiddle_name());
			ps.setString(4, doctormodel.getStreet());
			ps.setString(5, doctormodel.getCity());

			ps.setString(6, doctormodel.getZip());
			ps.setString(7, doctormodel.getEmail());
			ps.setString(8, doctormodel.getPhone());
			ps.setInt(9, doctormodel.getDepartment_code());
			ps.setInt(10, doctormodel.getAdmin_id());
			ps.setInt(11, doctormodel.getDoctor_id());
			System.out.println(ps.toString());
			insertflag=ps.execute();
			
			logger.debug("doctor data inserted to table sucessfully");
			JOptionPane.showConfirmDialog(null, "doctor data added sucessfully");
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

	public void updateDoctorRecord(DoctorModel dm)
	{

		PreparedStatement ps=null;
		Connection con=null;
		String query="";
		try
		{
			query= "UPDATE doctor SET first_name = ?, last_name = ?,middle_name= ?,street =?,city=?,zip=?,email=?,phone=?,department_code=?,admin_id=? WHERE doctor_id = ?";
			con=DBconnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,  dm.getFirst_name());
			ps.setString(2,  dm.getLast_name());
			ps.setString(3,  dm.getMiddle_name());
			ps.setString(4,  dm.getStreet());
			ps.setString(5,  dm.getCity());
			ps.setString(6,  dm.getZip());
			ps.setString(7,  dm.getEmail());
			ps.setString(8,  dm.getPhone());
			ps.setInt(9,  dm.getDepartment_code());
			ps.setInt(10,  dm.getAdmin_id());
			System.out.println(ps.toString());
			JOptionPane.showConfirmDialog(null, "doctor data updated sucessfully");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}


	}


	public void deleteDoctorRecord(DoctorModel dm)
	{

		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("delete doctor id"+dm.getDoctor_id());
			query="delete from doctor where doctor_id="+dm.getDoctor_id();
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			JOptionPane.showConfirmDialog(null, "Doctor data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}
	}
	


	public ArrayList<String> getDoctorList()
	{

		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<String> doctorNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select first_name,last_name,middle_name from doctor";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			doctorNames=new ArrayList<String>();
			while(rs.next())
			{
				doctorNames.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return doctorNames;
	}
	
	
	public ArrayList<DoctorModel> getDoctorObjects()
	{
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<DoctorModel> doctorNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select * from doctor";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			doctorNames=new ArrayList<DoctorModel>();
			DoctorModel dm=null;
			while(rs.next())
			{
				dm=new DoctorModel();
				dm.setFirst_name(rs.getString(1));
				dm.setLast_name(rs.getString(2));
				dm.setMiddle_name(rs.getString(3));
				
				dm.setStreet(rs.getString(4));
				dm.setCity(rs.getString(5));
				dm.setZip(rs.getString(6));
				dm.setEmail(rs.getString(7));
				dm.setPhone(rs.getString(8));
				dm.setDepartment_code(rs.getInt(9));
				dm.setAdmin_id(rs.getInt(10));
				dm.setDoctor_id(rs.getInt(11));
				doctorNames.add(dm);
				
				
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return doctorNames;
	}
	
	
	
	public static void main(String[] args)
	{
		DoctorController pc=new DoctorController();
		System.out.println(pc.getDoctorList());
	}

}
