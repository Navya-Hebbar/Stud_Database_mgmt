	package com.student.sms.service;
	
	import java.util.List;
	
	import com.student.sms.entity.Marks;
	
	public interface MarksService 
	{
		List<Marks> getAllMarks();
		Marks saveMarks(Marks marks);
	
		Marks getMarksById(Long id);
		Marks updateMarks(Marks marks);
		
		void deleteMarksById(Long id);
		
	
		
		 public List<Marks> getFilteredMarks(String registrationNumber, String semester);
	
	}
