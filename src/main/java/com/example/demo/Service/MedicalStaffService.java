package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MedicalStaff;
import com.example.demo.Repository.MedicalStaffRepository;

@Service
public class MedicalStaffService {
	
	@Autowired
    private MedicalStaffRepository medicalStaffRepository;
	
	public List<MedicalStaff> getAllMedicalStaff() {
        return medicalStaffRepository.findAll();
    }

    public MedicalStaff getMedicalStaffById(Long id) {
        return medicalStaffRepository.findById(id).orElse(null);
    }

    public List<MedicalStaff> getMedicalStaffBySpecialization(String specialization) {
        return medicalStaffRepository.findBySpecialization(specialization);
    }

    public MedicalStaff saveMedicalStaff(MedicalStaff medicalStaff) {
        return medicalStaffRepository.save(medicalStaff);
    }

    public void deleteMedicalStaff(Long id) {
        medicalStaffRepository.deleteById(id);
    }

}
