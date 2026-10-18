package com.example.CampusConnect.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CampusConnect.entity.Student;

public interface UserRepository extends JpaRepository<Student, Long> {
	List<Student> findByName(String name);

	Optional<Student> findByEmail(String email);
	

}
