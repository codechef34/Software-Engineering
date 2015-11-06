package com.medipres.utils;

import java.util.Date;
import java.util.*;

public class PrescriptionModel {
	
	
	private int prescription_id;
	private int medicine_qr_code;
	private int  patient_qr_code;
	private int idoctor_id;
	private Date time ;
	private String frequency;
	public int getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
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
	public int getIdoctor_id() {
		return idoctor_id;
	}
	public void setIdoctor_id(int idoctor_id) {
		this.idoctor_id = idoctor_id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

}
