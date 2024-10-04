package com.student.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.sms.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance,Long>{
	 List<Attendance> findByRegistrationNumberAndSemester(String registrationNumber, String semester);
	    List<Attendance> findByRegistrationNumber(String registrationNumber);
	    List<Attendance> findBySemester(String semester);
	
	

}
