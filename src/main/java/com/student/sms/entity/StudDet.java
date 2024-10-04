package com.student.sms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student_details")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudDet 
{
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegnum() {
		return regnum;
	}

	public void setRegnum(String regnum) {
		this.regnum = regnum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getFocc() {
		return focc;
	}

	public void setFocc(String focc) {
		this.focc = focc;
	}

	public String getMocc() {
		return mocc;
	}

	public void setMocc(String mocc) {
		this.mocc = mocc;
	}

	public String getPemail() {
		return pemail;
	}

	public void setPemail(String pemail) {
		this.pemail = pemail;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Register_Number")
	@Pattern(regexp = "^\\w{10}$", message = "Register number must be exactly 10 characters long")
	private String regnum;
	
	@NotBlank(message="It should not be blank")
	@Column(name="Name")
	private String name;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="Date_Of_Birth")
	private String dob;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Students_Phno")
	@Pattern(regexp = "\\d{10}", message = "Register number must be exactly 10 digits long")
	private String snum;
	
	@Column(name="Class")
	private String sclass;
	
	@Column(name="Branch")
	private String branch;
	
	@Column(name="Address")
	private String address;
	
	@Column(name="Fathers_Name")
	private String fname;
	
	@Column(name="Mothers_Name")
	private String mname;
	
	@Column(name="Fathers_Occ")
	private String focc;
	
	@Column(name="Mothers_Occ")
	private String mocc;
	
	@Column(name="Parents_Email")
	private String pemail;
	
	@Column(name="Parents_Phno")
	private String pnum;

}
