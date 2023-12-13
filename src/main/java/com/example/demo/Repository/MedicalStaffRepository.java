package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.MedicalStaff;

public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, Long>{
	
	 List<MedicalStaff> findBySpecialization(String specialization);


}
