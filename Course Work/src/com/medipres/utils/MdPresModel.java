package com.medipres.utils;

public class MdPresModel {
	
	private int id;
	private int  qr_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQr_code() {
		return qr_code;
	}
	public void setQr_code(int qr_code) {
		this.qr_code = qr_code;
	}
	public int getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}
	private int  prescription_id;


}
