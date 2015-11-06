package com.pharmacist.model;

public class PharmacistModel {
	
	private String first_name;
	private String last_name;
	private String middle_name;
	private String street;
	private String city;
	private String zip	;
	private String email ;
	private String phone   ;
	private int department_code;
	private int admin_id;
	private int pharmacist_id ;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getDepartment_code() {
		return department_code;
	}
	public void setDepartment_code(int department_code) {
		this.department_code = department_code;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public int getPharmacist_id() {
		return pharmacist_id;
	}
	public void setPharmacist_id(int pharmacist_id) {
		this.pharmacist_id = pharmacist_id;
	}

}
