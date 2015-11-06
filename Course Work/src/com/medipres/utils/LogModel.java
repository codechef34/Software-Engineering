package com.medipres.utils;

import java.util.Date;
import java.util.*;

public class LogModel {
	
	
	private int log_id;
	private int medicine_qr_code;
	private int patient_qr_code;
	private int nurse_id;
	private Date time;
	private int prescription_id	;
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getMedicine_qr_code() {
		return medicine_qr_code;
	}
	public void setMedicine_qr_code(int medicine_qr_code) {
		this.medicine_qr_code = medicine_qr_code;
	}
	public int getPatient_qr_code() {
		return patient_qr_code;
	}
	public void setPatient_qr_code(int patient_qr_code) {
		this.patient_qr_code = patient_qr_code;
	}
	public int getNurse_id() {
		return nurse_id;
	}
	public void setNurse_id(int nurse_id) {
		this.nurse_id = nurse_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}

}
