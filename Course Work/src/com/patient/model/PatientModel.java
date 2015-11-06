package com.patient.model;

public class PatientModel {
	
	private String first_name;
	private String last_name;
	private String middle_name;
	private String street ;
	private String city ;
	private String zip;
	private String email;
	private String phone;
	private String problem_description ;
	private int qr_code;
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
	public String getProblem_description() {
		return problem_description;
	}
	public void setProblem_description(String problem_description) {
		this.problem_description = problem_description;
	}
	public int getQr_code() {
		return qr_code;
	}
	public void setQr_code(int qr_code) {
		this.qr_code = qr_code;
	}
}
