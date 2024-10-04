package com.student.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.sms.entity.Attendance;
import com.student.sms.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl1 implements AttendanceService{

	private AttendanceRepository attendanceRepository;
	
	
	
	public AttendanceServiceImpl1(AttendanceRepository attendanceRepository) {
		super();
		this.attendanceRepository = attendanceRepository;
	}



	@Override
	public List<Attendance> getAllAttendance() {
		return attendanceRepository.findAll();
	}



	@Override
	public Attendance saveAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		return attendanceRepository.save(attendance);
	}



	@Override
	public Attendance getAttendanceById(Long id) {
		return attendanceRepository.findById(id).get();
	}



	@Override
	public Attendance updateAttendance(Attendance attendance) {
		return attendanceRepository.save(attendance);
	}



	@Override
	public void deleteAttendanceById(Long id) {
		attendanceRepository.deleteById(id);
		
	}



	@Override
	public List<Attendance> getFilteredAttendance(String registrationNumber, String semester) {
		        if (registrationNumber != null && !registrationNumber.isEmpty() && semester != null && !semester.isEmpty()) {
		            return attendanceRepository.findByRegistrationNumberAndSemester(registrationNumber, semester);
		        } else if (registrationNumber != null && !registrationNumber.isEmpty()) {
		            return attendanceRepository.findByRegistrationNumber(registrationNumber);
		        } else if (semester != null && !semester.isEmpty()) {
		            return attendanceRepository.findBySemester(semester);
		        } else {
		            return attendanceRepository.findAll();
		        }
		    }
	}
	

