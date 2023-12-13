package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Patient;
import com.example.demo.Repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public List<Patient> getPatientsByLastName(String lastName) {
        return patientRepository.findByLastName(lastName);
    }

    public List<Patient> getPatientsByGender(String gender) {
        return patientRepository.findByGender(gender);
    }

    public List<Patient> getPatientsBornAfter(LocalDate date) {
        return patientRepository.findByDateOfBirthAfter(date);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    
//    public Patient updatePatient(Patient patient) {
//    	return patientRepository.update(patient);
//    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
