package com.student.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student_attendance")
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

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
	public Integer getTheoryClasses() {
		return theoryClasses;
	}
	public void setTheoryClasses(Integer theoryClasses) {
		this.theoryClasses = theoryClasses;
	}
	public Integer getLabClasses() {
		return labClasses;
	}
	public void setLabClasses(Integer labClasses) {
		this.labClasses = labClasses;
	}
	public Integer getTutorialClasses() {
		return tutorialClasses;
	}
	public void setTutorialClasses(Integer tutorialClasses) {
		this.tutorialClasses = tutorialClasses;
	}
	public Integer getTotalClasses() {
		return totalClasses;
	}
	public void setTotalClasses(Integer totalClasses) {
		this.totalClasses = totalClasses;
	}
	public Integer getAttendedTheory() {
		return attendedTheory;
	}
	public void setAttendedTheory(Integer attendedTheory) {
		this.attendedTheory = attendedTheory;
	}
	public Integer getAttendedLab() {
		return attendedLab;
	}
	public void setAttendedLab(Integer attendedLab) {
		this.attendedLab = attendedLab;
	}
	public Integer getAttendedTutorial() {
		return attendedTutorial;
	}
	public void setAttendedTutorial(Integer attendedTutorial) {
		this.attendedTutorial = attendedTutorial;
	}
	public Integer getTotalAttended() {
		return totalAttended;
	}
	public void setTotalAttended(Integer totalAttended) {
		this.totalAttended = totalAttended;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String semester;
  private String department;
  private String registrationNumber;
  private String subject;
  private Integer theoryClasses;
  private Integer labClasses;
  private Integer tutorialClasses;
  private Integer totalClasses;
  private Integer attendedTheory;
  private Integer attendedLab;
  private Integer attendedTutorial;
  private Integer totalAttended;
  private Double percentage;

  
 
}

