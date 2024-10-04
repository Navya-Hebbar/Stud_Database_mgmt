package com.student.sms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.sms.entity.Marks;
import com.student.sms.repository.MarksRepository;

@Service
public class MarksServiceImpl1 implements MarksService
{

	private MarksRepository marksRepository;
	
	
	public MarksServiceImpl1(MarksRepository marksRepository) {
		super();
		this.marksRepository = marksRepository;
	}



	@Override
	public List<Marks> getAllMarks() {
		// TODO Auto-generated method stub
		return marksRepository.findAll();
	}
	
	@Override
	public Marks saveMarks(Marks marks) {
		return marksRepository.save(marks);
	}

	@Override
	public Marks getMarksById(Long id) {
		// TODO Auto-generated method stub
		return marksRepository.findById(id).get();
	}

	@Override
	public Marks updateMarks(Marks marks) {
		// TODO Auto-generated method stub
		return marksRepository.save(marks);
	}

	@Override
	public void deleteMarksById(Long id) {
		marksRepository.deleteById(id);
		
	}

	@Override
	public List<Marks> getFilteredMarks(String registrationNumber, String semester) {
		  if (registrationNumber != null && !registrationNumber.isEmpty() && semester != null && !semester.isEmpty()) {
	            return marksRepository.findByRegistrationNumberAndSemester(registrationNumber, semester);
	        } else if (registrationNumber != null && !registrationNumber.isEmpty()) {
	            return marksRepository.findByRegistrationNumber(registrationNumber);
	        } else if (semester != null && !semester.isEmpty()) {
	            return marksRepository.findBySemester(semester);
	        } else {
	            return marksRepository.findAll();
	        }
	}
}



