package com.student.sms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.student.sms.entity.Marks;

public interface MarksRepository extends JpaRepository<Marks,Long>{
	 List<Marks> findByRegistrationNumberAndSemester(String registrationNumber, String semester);
	    List<Marks> findByRegistrationNumber(String registrationNumber);
	    List<Marks> findBySemester(String semester);
	
}