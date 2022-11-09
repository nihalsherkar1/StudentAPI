package com.cdac.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.beans.StudentDetails;
import com.cdac.service.UserServiceImp;

@RestController
public class StudentController {
	
	@Autowired
	private UserServiceImp service;
	
	@GetMapping("/getStudent")
	public StudentDetails getStudent() {
		return new StudentDetails();
	}
	
 
	@PostMapping("/createStudent")
  	public StudentDetails createStudent(@RequestBody StudentDetails student) {
	  System.out.println(student);
	  return service.createStudent(student);
	}

 
	@GetMapping("/updateStudentByID/{id}")
	public StudentDetails updateStudentByID(@PathVariable ("id") Integer studentID) {
		return service.updateStudentByID(studentID);
	}
	
	@RequestMapping(value = "/updateStudentWithDynamicValues", method = RequestMethod.PUT)
 
	public StudentDetails updateStudentWithDynamicValues(@RequestBody StudentDetails newStudent) {
		return service.updateStudentWithDynamicValues(newStudent);
	}

 
	@DeleteMapping("/deleteStudentByID/{ID}")
	public String deleteStudentByID(@PathVariable ("ID") Integer studentID) {
		return service.deleteStudentByID(studentID);
	}

 
	@GetMapping("/getStudentByID/{userId}")
	public StudentDetails getStudentByID(@PathVariable("userId") Integer studentID) {
		System.out.println(studentID);
		return service.getStudentByID(studentID);
	}

 
	@GetMapping("/getAllStudent")
	public List<StudentDetails>getAllStudent() {
		return service.getAllStudent();
	}	
}