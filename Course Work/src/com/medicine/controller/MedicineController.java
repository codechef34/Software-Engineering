package com.medicine.controller;



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
import com.medipres.utils.QRCodeGenarator1;
//import com.nurse.ui.NurseRecord;
import com.medicine.model.*;
import com.medicine.ui.*;
import com.patient.model.PatientModel;
import com.util.sql.DBconnection;
import org.apache.log4j.*;
import java.util.*;

public class MedicineController {


	private MedicineModel medicinemodel;
	private Logger logger=Logger.getLogger(MedicineController.class);

	public MedicineController() {

	}

	public MedicineController(MedicineModel mm) {
		this.medicinemodel=mm;
	}


	public boolean addMedicineRecord(MedicineModel mm)
	{
		this.medicinemodel=mm;
		PreparedStatement ps=null;
		Connection con=null;
		String query=null;
		boolean insertflag=false;
		try
		{
			con=DBconnection.getConnection();
			query="insert into medicine values(?,?,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setString(1, medicinemodel.getName());
			ps.setString(2, medicinemodel.getForm());
			ps.setString(3, medicinemodel.getDose());
			ps.setInt(4, medicinemodel.getQr_code());
			ps.setInt(5, medicinemodel.getPharmacist_id());
			ps.setString(6, medicinemodel.getRoute());
			
			System.out.println(ps.toString());
			insertflag=ps.execute();
			QRCodeGenarator1 qrcode=new QRCodeGenarator1(medicinemodel);
			qrcode.QRCodeMedicine();
			logger.debug("medicine data inserted to table sucessfully");
			JOptionPane.showConfirmDialog(null, "medicine data added sucessfully");
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

	public void updateMedicineRecord(MedicineModel mm)
	{

		PreparedStatement ps=null;
		Connection con=null;
		String query="";
		try
		{
			query= "UPDATE Medicine SET name = ?, form = ?,dose= ?,pharmacist_id =?,route=? WHERE qr_code = ?";
			con=DBconnection.getConnection();
			ps=con.prepareStatement(query);
			ps.setString(1,  mm.getName());
			ps.setString(2,  mm.getForm());
			ps.setString(3,  mm.getDose());
			ps.setString(4,  Integer.toString(mm.getPharmacist_id()));
			ps.setString(5,  mm.getRoute());
			
			System.out.println(ps.toString());
			JOptionPane.showConfirmDialog(null, "Medicine data updated sucessfully");
			QRCodeGenarator1 qrcode=new QRCodeGenarator1(mm);
			qrcode.QRCodeMedicine();
			
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		finally
		{
			DBconnection.closeAll(con, ps, null, null);
		}


	}



	public void deleteMedicineRecord(MedicineModel mm)
	{

		Statement stmt=null;
		Connection con=null;
		String query="";
		try
		{
			logger.info("delete qr code"+mm.getQr_code());
			query="delete from medicine where qr_code="+mm.getQr_code();
			con=DBconnection.getConnection();
			stmt=con.createStatement();
			stmt.executeUpdate(query);
			logger.info(stmt.toString());

			JOptionPane.showConfirmDialog(null, "medicine data deleted sucessfully");
		}
		catch (Exception e) {
           e.printStackTrace();
		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, null);
		}
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
			String query="select max(qr_code) from medicine";
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


	public ArrayList<String> getMedicineList()
	{

		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<String> medicineNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select name,dose from medicine";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			medicineNames=new ArrayList<String>();
			while(rs.next())
			{
				medicineNames.add(rs.getString(1)+","+rs.getString(2));
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return medicineNames;
	}
	
	
	public ArrayList<MedicineModel> getMedicineObjects()
	{
		Statement stmt=null;
		ResultSet rs=null;
		Connection con=null;
		int count=0;
		ArrayList<MedicineModel> medicineNames=null;
		try
		{
			con=DBconnection.getConnection();
			String query="select * from medicine";
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			medicineNames=new ArrayList<MedicineModel>();
			MedicineModel mm=null;
			while(rs.next())
			{
				mm=new MedicineModel();
				mm.setName(rs.getString(1));
				mm.setForm(rs.getString(2));
				mm.setDose(rs.getString(3));
				
				mm.setQr_code(rs.getInt(4));
				mm.setPharmacist_id(rs.getInt(5));
				mm.setRoute(rs.getString(6));
				medicineNames.add(mm);
				
				
			}
					}
		catch (Exception e) {

		}
		finally
		{
			DBconnection.closeAll(con, null, stmt, rs);
		}
		return medicineNames;
	}
	
	
	
	public static void main(String[] args)
	{
		MedicineController pc=new MedicineController();
		System.out.println(pc.getMedicineList());
	}

}

