package com.student.sms.service;

import java.util.List;

import com.student.sms.entity.Attendance;

public interface AttendanceService {
	List<Attendance> getAllAttendance();
	Attendance saveAttendance(Attendance attendance);

	Attendance getAttendanceById(Long id);
	Attendance updateAttendance(Attendance attendance);
	
	void deleteAttendanceById(Long id);
	

	
	 public List<Attendance> getFilteredAttendance(String registrationNumber, String semester);
}
