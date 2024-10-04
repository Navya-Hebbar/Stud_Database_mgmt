package com.student.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="marks_student")
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Marks 
{

	 public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Integer getCIE1() {
		return CIE1;
	}
	public void setCIE1(Integer cIE1) {
		CIE1 = cIE1;
	}
	public Integer getCIE2() {
		return CIE2;
	}
	public void setCIE2(Integer cIE2) {
		CIE2 = cIE2;
	}
	public Integer getCIE3() {
		return CIE3;
	}
	public void setCIE3(Integer cIE3) {
		CIE3 = cIE3;
	}
	public Double getAVG1() {
		return AVG1;
	}
	public void setAVG1(Double aVG1) {
		AVG1 = aVG1;
	}
	public Integer getCIE4() {
		return CIE4;
	}
	public void setCIE4(Integer cIE4) {
		CIE4 = cIE4;
	}
	public Integer getCIE5() {
		return CIE5;
	}
	public void setCIE5(Integer cIE5) {
		CIE5 = cIE5;
	}
	public Integer getCIE6() {
		return CIE6;
	}
	public void setCIE6(Integer cIE6) {
		CIE6 = cIE6;
	}
	public Double getAVG2() {
		return AVG2;
	}
	public void setAVG2(Double aVG2) {
		AVG2 = aVG2;
	}
	public Integer getTotalCIE() {
		return TotalCIE;
	}
	public void setTotalCIE(Integer totalCIE) {
		TotalCIE = totalCIE;
	}
	public Integer getSEE() {
		return SEE;
	}
	public void setSEE(Integer sEE) {
		SEE = sEE;
	}
	public Double getTotalMarks() {
		return TotalMarks;
	}
	public void setTotalMarks(Double totalMarks) {
		TotalMarks = totalMarks;
	}
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  private String semester;
	  private String department;
	  private String registrationNumber;
	  private String subject;
	  private Integer CIE1;
	  private Integer CIE2;
	  private Integer CIE3;
	  private Double AVG1;
	  private Integer CIE4;
	  private Integer CIE5;
	  private Integer CIE6;
	  private Double AVG2;
	  private Integer TotalCIE;
	  private Integer SEE;
	  private Double TotalMarks;
}
