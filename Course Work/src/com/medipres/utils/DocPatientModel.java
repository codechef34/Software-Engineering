package com.medipres.utils;

public class DocPatientModel {
	
	private int id;
	private int  doctor_id;
	private int iqr_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getIqr_code() {
		return iqr_code;
	}
	public void setIqr_code(int iqr_code) {
		this.iqr_code = iqr_code;
	}

}
