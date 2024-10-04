package com.student.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.sms.entity.Attendance;
import com.student.sms.entity.Marks;
import com.student.sms.entity.StudDet;
import com.student.sms.entity.User;
import com.student.sms.service.AttendanceService;
import com.student.sms.service.MarksService;
import com.student.sms.service.StudService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@SessionAttributes("msg")
public class StudController 
{
	
	private AttendanceService attendanceService;
	public StudController(AttendanceService attendanceService) {
		super();
		this.attendanceService = attendanceService;
	}
	
	 @GetMapping("/attendance_view")
	    public String viewAttendance(@RequestParam(name = "registrationNumber", required = false) String registrationNumber,
	                                 @RequestParam(name = "semester", required = false) String semester,
	                                 Model model) {
	        List<Attendance> filteredAttendance = attendanceService.getFilteredAttendance(registrationNumber, semester);
	        model.addAttribute("attendance_view", filteredAttendance);
	        return "attendance_view";
	    }
	 
	
	@GetMapping("/attendance_view/new")
	public String AttendanceForm(Model model)
	{
		Attendance attendance=new Attendance();
		model.addAttribute("attendance",attendance);
		return "attendance";
	}	
	
	
	@PostMapping("/attendance_view")
	public String saveAttendance(@ModelAttribute("attendance") Attendance attendance) {
	    int theoryClasses = attendance.getTheoryClasses();
	    int labClasses = attendance.getLabClasses();
	    int tutorialClasses = attendance.getTutorialClasses();
	    
	    int attendedTheory = attendance.getAttendedTheory();
	    int attendedLab = attendance.getAttendedLab();
	    int attendedTutorial = attendance.getAttendedTutorial();

	    int totalClasses = theoryClasses + labClasses + tutorialClasses;
	    int totalAttended = attendedTheory + attendedLab + attendedTutorial;
	    
	    double percentage = (double) totalAttended / totalClasses * 100;
	    percentage = Math.ceil(percentage); // Round up the percentage

	    attendance.setPercentage(percentage);
	    
	    attendance.setTotalClasses(totalClasses);
	    attendance.setTotalAttended(totalAttended);
	    
	    attendanceService.saveAttendance(attendance);
	    return "redirect:/attendance_view";
	}
	
	
	
	@GetMapping("/attendance_view/edit/{id}")
	public String editAttendance(@PathVariable Long id,Model model)
	{
		model.addAttribute("attendance",attendanceService.getAttendanceById(id));
		return "edit_attendance";
	}

	
	@PostMapping("/attendance_view/{id}")
	public String updateAttendance(@PathVariable Long id, @ModelAttribute("attendance") Attendance updatedAttendance, Model model) {
	    // Get the existing attendance object
	    Attendance existingAttendance = attendanceService.getAttendanceById(id);
	    
	    // Update the existing attendance object with the new data
	    existingAttendance.setRegistrationNumber(updatedAttendance.getRegistrationNumber());
	    existingAttendance.setDepartment(updatedAttendance.getDepartment());
	    existingAttendance.setSemester(updatedAttendance.getSemester());
	    
	    existingAttendance.setTheoryClasses(updatedAttendance.getTheoryClasses());
	    existingAttendance.setLabClasses(updatedAttendance.getLabClasses());
	    existingAttendance.setTutorialClasses(updatedAttendance.getTutorialClasses());
	    
	    existingAttendance.setAttendedTheory(updatedAttendance.getAttendedTheory());
	    existingAttendance.setAttendedLab(updatedAttendance.getAttendedLab());
	    existingAttendance.setAttendedTutorial(updatedAttendance.getAttendedTutorial());
	    
	    // Recalculate total classes and total attended
	    int totalClasses = existingAttendance.getTheoryClasses() + existingAttendance.getLabClasses() + existingAttendance.getTutorialClasses();
	    int totalAttended = updatedAttendance.getAttendedTheory() + updatedAttendance.getAttendedLab() + updatedAttendance.getAttendedTutorial();
	    
	    // Update the total classes and total attended in the existing attendance object
	    existingAttendance.setTotalClasses(totalClasses);
	    existingAttendance.setTotalAttended(totalAttended);
	    
	    // Recalculate percentage
	    double percentage = (double) totalAttended / totalClasses * 100;
	    percentage = Math.ceil(percentage); // Round up the percentage
	    existingAttendance.setPercentage(percentage);
	    
	    // Save the updated attendance object
	    attendanceService.updateAttendance(existingAttendance);
	    
	    return "redirect:/attendance_view";
	}
	
	
@Autowired
private MarksService marksService;


	 @GetMapping("/marks_view")
	    public String viewMarks(@RequestParam(name = "registrationNumber", required = false) String registrationNumber,
	                                 @RequestParam(name = "semester", required = false) String semester,
	                                 Model model) {
	        List<Marks> filteredMarks = marksService.getFilteredMarks(registrationNumber, semester);
	        model.addAttribute("marksList", filteredMarks);
	        return "marks_view";
	    }
	
	@GetMapping("/attendance_view/{id}")
	public String deleteAttendance(@PathVariable Long id)
	{
		attendanceService.deleteAttendanceById(id);
		return "redirect:/attendance_view";
	}
	
	@GetMapping("/marks_view/new")
	public String MarksForm(Model model)
	{
		Marks marks=new Marks();
		model.addAttribute("marks",marks);
		return "marks";
	}
	
	
	@PostMapping("/marks_view")
	public String saveAttendance(@ModelAttribute("marks") Marks marks)
	{
		int CIE1 = marks.getCIE1();
  int CIE2 = marks.getCIE2();
  int CIE3=marks.getCIE3();
  
  int CIE4=marks.getCIE4();
  int CIE5=marks.getCIE5();
  int CIE6=marks.getCIE6();
  int SEE=marks.getSEE();
 
  
  double avg1 = (double) (CIE1+CIE2+CIE3)/3;
  avg1 = Math.ceil(avg1); // Round up the percentage
  
  double avg2 = (double) (CIE4+CIE5+CIE6)/3;
  avg2 = Math.ceil(avg2); // Round up the percentage
  
  marks.setAVG1(avg1);
  marks.setAVG2(avg2);
  
  int TotalCIE= (int) (avg1+avg2);
  double TotalMarks=TotalCIE+SEE;
  
  
  marks.setTotalCIE(TotalCIE);
  marks.setTotalMarks(TotalMarks);
  marksService.saveMarks(marks);
		return "redirect:/marks_view";
	}
	
		
	
	@GetMapping("/marks_view/edit/{id}")
	public String editMarks(@PathVariable Long id,Model model)
	{
		model.addAttribute("marks",marksService.getMarksById(id));
		return "edit_marks";
	}
	
	
	@PostMapping("/marks_view/{id}")
	public String updateMarks(@PathVariable Long id, @ModelAttribute("marks") Marks updatedMarks, Model model) {
	    // Get the existing attendance object
	    Marks existingMarks = marksService.getMarksById(id);
	    
	    // Update the existing attendance object with the new data
	    existingMarks.setRegistrationNumber(updatedMarks.getRegistrationNumber());
	    existingMarks.setDepartment(updatedMarks.getDepartment());
	    existingMarks.setSemester(updatedMarks.getSemester());
	    
	    existingMarks.setCIE1(updatedMarks.getCIE1());
	    existingMarks.setCIE2(updatedMarks.getCIE2());
	    existingMarks.setCIE3(updatedMarks.getCIE3());
	    
	    existingMarks.setCIE4(updatedMarks.getCIE4());
	    existingMarks.setCIE5(updatedMarks.getCIE5());
	    existingMarks.setCIE6(updatedMarks.getCIE6());
	   
	    
        int avg1=(existingMarks.getCIE1()+existingMarks.getCIE2()+existingMarks.getCIE3())/3;
        int avg2=(existingMarks.getCIE4()+existingMarks.getCIE5()+existingMarks.getCIE6())/3;
        existingMarks.setAVG1(updatedMarks.getAVG1());
        existingMarks.setAVG2(updatedMarks.getAVG2());
        existingMarks.setSEE(updatedMarks.getSEE());
        
	 
	    int TotalCIE = avg1+avg2;
	    int TotalMarks = updatedMarks.getTotalCIE() + updatedMarks.getSEE();
	    
	    existingMarks.setTotalCIE(TotalCIE);
	    existingMarks.setTotalMarks((double) TotalMarks);
	    
	    marksService.updateMarks(existingMarks);
	    return "redirect:/marks_view";
	}
	
	
	

	
	@GetMapping("/marks_view/{id}")
	public String deleteMarks(@PathVariable Long id)
	{
		marksService.deleteMarksById(id);
		return "redirect:/marks_view";
	}
	
	
	
	

	@Autowired
	private StudService studService;
	private Object id;
	
	@GetMapping("/home1")
	public String demohome()
	{
		return "home1";
	}
	
	@GetMapping("/register")
	public String register(Model model, HttpSession session) {
		model.addAttribute("user", new User());
		model.addAttribute("succMsg", session.getAttribute("succMsg"));
		model.addAttribute("errorMsg", session.getAttribute("errorMsg"));
		session.removeAttribute("succMsg");
		session.removeAttribute("errorMsg");
		return "register";
	}
	

	@PostMapping("/createUser")
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model  model, HttpSession session) {
		
		if (result.hasErrors()) {
			System.out.println(result);
			model.addAttribute("user", user);
			return "register";
		}

		boolean emailExist = studService.checkEmail(user.getEmail());

		if (emailExist) {
			session.setAttribute("errorMsg", "Email id already exists");
			model.addAttribute("user", user);


		} else {

			if (!user.getPassword().equals(user.getConfirmPassword())) {
				session.setAttribute("errorMsg", "Passwords do not match. Please try again.");
				model.addAttribute("user", user);
				
			}

			else {
			
				User userDtls = studService.createUser(user);

				if (userDtls != null) {
					session.setAttribute("succMsg", "Registration successful");
					System.out.println();
					return "login";
					
				} else {
					session.setAttribute("errorMsg", "Something went wrong");
				}
			}
		}
		return "redirect:/register";

	}
	@GetMapping("/")
	public String login(Model model, HttpSession session) {
		model.addAttribute("user", new User());
		model.addAttribute("succMsg", session.getAttribute("succMsg"));
		model.addAttribute("errorMsg", session.getAttribute("errorMsg"));
		session.removeAttribute("succMsg");
		session.removeAttribute("errorMsg");
		
		return "login";
	}
	
	
	@PostMapping("/authenticateUser")
	public String authenticateUser(@Valid @ModelAttribute("user") User user, BindingResult bresult, Model  model, HttpSession session) {
			
		 
		 if(!studService.checkEmail(user.getEmail())) {
			 bresult.rejectValue("email","","Username is not existed");
		 }
		 else if(!studService.ValidatePassword(user)){
			 bresult.rejectValue("password","","Invalid password");
			
		 }
		 else {
			 session.setAttribute("succMsg", "Login successfully");
			 return "home";
		 }
		 session.removeAttribute("succMsg");
	return "login";
		
	}
	

	
	

	@GetMapping("/home")
	public String homePage()
	{
		return "home";
	}
	
	@GetMapping("/aboutus")
	public String about()
	{
		return "aboutus";
	}
	
	@GetMapping("/editStud")
	public String index(Model m,String keyword)
	{
		
		if(keyword!=null)
		{
			m.addAttribute("studList",studService.findByKeyword(keyword));
		}
		else
		{
			
		List<StudDet> list=studService.getAllStud();
		m.addAttribute("studList",list);
		}
		return "index";
	}
	
	
	
	@GetMapping("/loadStudSave")
	public String loadStudSave()
	{
		return "stud_save";
	}
	
	
	@GetMapping("/editStud/{id}")
	public String EditStud(@PathVariable int id,Model m)
	{
		StudDet stud= studService.getStudById(id);
		m.addAttribute("stud", stud);
		return "edit_stud";
	}
	
	
	@ModelAttribute("stud")
    public StudDet getStudDet() {
        return new StudDet();
    }
	
	@PostMapping("/saveStud")
	public String saveStud(@Valid @ModelAttribute StudDet stud, BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
	    if (bindingResult.hasErrors()) {
	        redirectAttributes.addFlashAttribute("msg", "Error!! Register number must be at least 10 characters long");
	        return "redirect:/loadStudSave";
	    }
	    
	    StudDet newStud = studService.saveStud(stud);
	    if (newStud != null) {
	        session.setAttribute("msg", "Details Added Successfully");
	    } else {
	        session.setAttribute("msg", "Something went wrong");
	    }
	    return "redirect:/loadStudSave";
	}


	
	@PostMapping("/updateStudDtls")
	public String updateStud(@ModelAttribute StudDet stud,HttpSession session)
	{
		StudDet updateStud=studService.saveStud(stud);
		if(updateStud!=null)
		{
			session.setAttribute("msg","Details Updated Successfully");
		}
		else
		{
			session.setAttribute("msg","Something went wrong");
		}
		return "redirect:/editStud";
	}
	
	
	@GetMapping("/deleteStud/{id}")
	public String loadStudSave(@PathVariable int id,HttpSession session)
	{
		boolean f = studService.deleteStud(id);
		if(f)
		{
			session.setAttribute("msg","Details Deleted Successfully");
		}
		else
		{
			session.setAttribute("msg","Something went wrong");
		}
		 
		return "redirect:/editStud";
	}
	
	@GetMapping("/contact")
	public String contactUs()
	{
		return "contact";
	}
	
	@GetMapping("/userprof")
	public String userprof() {
		return "userprof";
	}

	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		model.addAttribute("user", new User());
		model.addAttribute("succMsg", session.getAttribute("succMsg"));
		model.addAttribute("errorMsg", session.getAttribute("errorMsg"));
		session.removeAttribute("succMsg");
		session.removeAttribute("errorMsg");
		
		return "logout";
	}
	
	@PostMapping("/logoutUser")
	public String logoutUser(@Valid @ModelAttribute("user") User user, BindingResult bresult, Model  model, HttpSession session) {
				 
				 if(!studService.checkEmail(user.getEmail())) {
					 bresult.rejectValue("email","","Username is not existed");

				 }
				 else if(!studService.ValidatePassword(user)){
					 bresult.rejectValue("password","","Invalid password");	
				 }
				 else {
					 session.setAttribute("succMsg", "Logout successfully");
					 return "login";
				 }
			
			return "logout";
		
	}

	
	@GetMapping("/report")
	public String recordAttendance(@RequestParam(name = "registrationNumber", required = false) String registrationNumber,
	                               @RequestParam(name = "semester", required = false) String semester,
	                               Model model) {
	    System.out.println(registrationNumber);
	    
	    // Retrieve attendance and marks data
	    List<Attendance> attendanceList = attendanceService.getFilteredAttendance(registrationNumber, semester);
	    List<Marks> marksList = marksService.getFilteredMarks(registrationNumber, semester);
	    StudDet student = studService.getStudDetByRegNum(registrationNumber);

	    if (attendanceList == null || attendanceList.isEmpty() || student == null) {
	        model.addAttribute("errorMessage", "No data found for the provided registration number.");
	        System.out.println("no data");
	    } else {
	        model.addAttribute("attendanceList", attendanceList);
	        model.addAttribute("marksList", marksList); // Add marks list to the model
	        model.addAttribute("student", student);
	        model.addAttribute("semester", semester);
	        
	        // Calculate overall percentage and remarks
	        double totalPercentage = 0.0;
	        int numAttendances = 0;
	        for (Attendance attendance : attendanceList) {
	            if (attendance.getPercentage() != null) {
	                totalPercentage += attendance.getPercentage();
	                numAttendances++;
	            }
	        }
	        double overallPercentage = numAttendances > 0 ? totalPercentage / numAttendances : 0.0;
	        String remarks = "";
	        if (overallPercentage > 75) {
	            remarks = "Very good attendance";
	        } else if (overallPercentage > 50) {
	            remarks = "Average attendance";
	        } else {
	            remarks = "Very low attendance";
	        }
	        model.addAttribute("overallPercentage", overallPercentage);
	        model.addAttribute("remarks", remarks);
	        System.out.println(overallPercentage);
	    }
	    
	    return "attendance_report";
	}





	

}
