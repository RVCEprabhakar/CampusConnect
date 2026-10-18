package com.example.CampusConnect.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.CampusConnect.entity.Student;
import com.example.CampusConnect.repository.UserRepository;

@Service
public class StudentService {
	@Autowired
	private UserRepository repo;
	
	public Student getuserbyid(Long id) {

	    Optional<Student> student = repo.findById(id);

	    if (student.isPresent()) {
	        return student.get();
	    }

	    return null;
	}
	
	
	public String save(Student student) {
		 repo.save(student);
		 return "data save sucessfully ";
	
	}
	
	
	public List<Student>all(){
		return repo.findAll();
		
	}
	

	 public Student updates(Long id,Student student) {
		 Student ex = repo.findById(id).orElse(null);
		 
		 if(ex==null) {
			 return null;
		 }
		 ex.setName(student.getName());
		 ex.setEmail(student.getEmail());
		 return repo.save(ex); 
	 }
	 
	 public String deletemap(Long id) {
		 Optional<Student>s=repo.findById(id);
		 
		 if(s.isPresent()) {
			 repo.deleteById(id);
			 return "Deleted successfully";
		 }
		 return "deleted id not found";
	 }
	 
	 public void del(){
		  repo.deleteAll();
		 
	 }
	 public List<Student> searchByName(String name) {
		    return repo.findByName(name);
		}
	 
	 public Student searchByEmail(String email) {
		    return repo.findByEmail(email).orElse(null);
		}
	
	
	
	
	
	

}
