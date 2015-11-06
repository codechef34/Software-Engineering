package com.nurse.controller;

import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.log4j.Logger;

import com.admin.ui.AdminPanel;




import com.doctor.model.DoctorModel;
import com.nurse.model.*;
import com.nurse.ui.*;
import com.util.sql.DBconnection;
import org.apache.log4j.*;
import java.util.*;

public class NurseController {


	private NurseModel nursemodel;
	private Logger logger=Logger.getLogger(NurseController.class);

	public NurseController() {

	}

	public NurseController(NurseModel nm) {
		this.nursemodel=nm;
	}


	public boolean addNurseRecord(NurseModel nm)
	{
		this.nursemodel=nm;
		PreparedStatement ps=null;
		Connection con=null;
		String query=null;
		boolean insertflag=false;
		try
		{
			con=DBconnection.getConnection();
			query="insert into nurse values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, nursemodel.getFirst_name());
			ps.setString(2, nursemodel.getLast_name());
			ps.setString(3, nursemodel.getMiddle_name());
			ps.setString(4, nursemodel.getStreet());
			ps.setString(5, nursemodel.getCity());

			ps.setString(6, nursemodel.getZip());
			ps.setString(7, nursemodel.getEmail());
			ps.setString(8, nursemodel.getPhone());
			ps.setInt(9, nursemodel.getDepartment_code());
			ps.setInt(10, nursemodel.getAdmin_id());
			ps.setInt(11, nursemodel.getNurse_id());
			System.out.println(ps.toString());
			insertflag=ps.execute();
			
			logger.debug("nurse data inserted to table sucessfully");
			JOptionPane.showConfirmDialog(null, "nurse data added sucessfully");
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

	public void updateNurseRecord(NurseModel nm)
	{

		PreparedStatement ps=null;
		Connection con=null;
		String query="";
		try
		{
			query= "UPDATE nurse SET first_name = ?, last_name = ?,middle_name= ?,street =?,city=?,zip=?,email=?,phone=?,department_code=?,admin_id=? WHERE nurse_id = ?";
			con=DBconnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,  nm.getFirst_name());
			ps.setString(2,  nm.getLast_name());
			ps.setString(3,  nm.getMiddle_name());
			ps.setString(4,  nm.getStreet());
			ps.setString(5,  nm.getCity());
			ps.setString(6,  nm.getZip());
			ps.setString(7,  nm.getEmail());
			ps.setString(8,  nm.getPhone());
			ps.setInt(9,  nm.getDepartment_code());
			ps.setInt(10,  nm.getAdmin_id());
			System.out.println(ps.toString());
			JOptionPane.showConfirmDialog(null, "nurse data updated sucessfully");
			
			
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}


	}


	public void deleteNurseRecord(NurseModel nm)
	{

		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("delete nurse id"+nm.getNurse_id());
			query="delete from nurse where qr_code="+nm.getNurse_id();
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			JOptionPane.showConfirmDialog(null, "Nurse data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}
	}
	


	


	public ArrayList<String> getNurseList()
	{

		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<String> nurseNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select first_name,last_name,middle_name from nurse";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			nurseNames=new ArrayList<String>();
			while(rs.next())
			{
				nurseNames.add(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3));
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return nurseNames;
	}
	
	
	public ArrayList<NurseModel> getNurseObjects()
	{
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<NurseModel> nurseNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select * from nurse";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			nurseNames=new ArrayList<NurseModel>();
			NurseModel nm=null;
			while(rs.next())
			{
				nm=new NurseModel();
				nm.setFirst_name(rs.getString(1));
				nm.setLast_name(rs.getString(2));
				nm.setMiddle_name(rs.getString(3));
				
				nm.setStreet(rs.getString(4));
				nm.setCity(rs.getString(5));
				nm.setZip(rs.getString(6));
				nm.setEmail(rs.getString(7));
				nm.setPhone(rs.getString(8));
				nm.setDepartment_code(rs.getInt(9));
				nm.setAdmin_id(rs.getInt(10));
				nm.setNurse_id(rs.getInt(11));
				nurseNames.add(nm);
				
				
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return nurseNames;
	}
	
	
	
	public static void main(String[] args)
	{
		NurseController pc=new NurseController();
		System.out.println(pc.getNurseList());
	}

}
