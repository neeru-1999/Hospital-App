package com.example.demo.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	
	List<Patient> findByLastName(String lastName);
	
	List<Patient> findByGender(String gender);
	
	List<Patient> findByDateOfBirthAfter(LocalDate date);

//	Patient update(Patient patient);
	


}
