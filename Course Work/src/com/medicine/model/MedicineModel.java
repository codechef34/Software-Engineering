package com.medicine.model;

public class MedicineModel {

	private String name;
	private String form	;	   
	private String dose;
	private int qr_code	;
	private int pharmacist_id ;
	private String route;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public int getQr_code() {
		return qr_code;
	}
	public void setQr_code(int qr_code) {
		this.qr_code = qr_code;
	}
	public int getPharmacist_id() {
		return pharmacist_id;
	}
	public void setPharmacist_id(int pharmacist_id) {
		this.pharmacist_id = pharmacist_id;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	
}
