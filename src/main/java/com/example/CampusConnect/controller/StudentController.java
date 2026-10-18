package com.example.CampusConnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CampusConnect.entity.Student;
import com.example.CampusConnect.service.StudentService;

@RestController()

public class StudentController {
	@Autowired
	private StudentService es;
	
	
	@GetMapping("/s1/{id}")
	public Student get(@PathVariable Long id) {
	    return es.getuserbyid(id);
	}
	
	@PostMapping("s2")
	public String save(@RequestBody Student student) {
		return es.save(student);
	}
	
	@GetMapping("/s3")
	public List<Student> findall() {
	    return es.all();
	}
	
	@PutMapping("/s4/{id}")
	public Student update(@PathVariable Long id,   @RequestBody Student student) {
		return es.updates(id,student);
		
	}
	
	@DeleteMapping("/s4/{id}")
	public String delete(@PathVariable Long id) {
		return es.deletemap(id);
	}
	
	@DeleteMapping("/s5")
	public String alldelete(){
		
		es.del();
		
		return "all datadeleted";
	}
	
	@GetMapping("/s6/name/{name}")
	public List<Student> searchByName(@PathVariable String name) {
	    return es.searchByName(name);
	}
	
	@GetMapping("/s7/email/{email}")
	public Student searchByEmail(@PathVariable String email) {
	    return es.searchByEmail(email);
	}
	
	
	
	
	
	
	
	

}
