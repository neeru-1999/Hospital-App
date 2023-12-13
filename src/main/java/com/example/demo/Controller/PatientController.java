package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Patient;
import com.example.demo.Service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
    private PatientService patientService;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/lastName/{lastName}")
    public ResponseEntity<List<Patient>> getPatientsByLastName(@PathVariable String lastName) {
        return ResponseEntity.ok(patientService.getPatientsByLastName(lastName));
    }

    @GetMapping("/search/gender/{gender}")
    public ResponseEntity<List<Patient>> getPatientsByGender(@PathVariable String gender) {
        return ResponseEntity.ok(patientService.getPatientsByGender(gender));
    }

    @GetMapping("/search/bornAfter/{date}")
    public ResponseEntity<List<Patient>> getPatientsBornAfter(@PathVariable String date) {
        // Parse date from string, handle exceptions as needed
        LocalDate parsedDate = LocalDate.parse(date);
        return ResponseEntity.ok(patientService.getPatientsBornAfter(parsedDate));
    }

    @PostMapping("/create")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.savePatient(patient));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@PathVariable int id, @RequestBody Patient patient){
    	patient.setFirstName(patient.getFirstName());
    	patient.setLastName(patient.getLastName());
    	patient.setGender(patient.getGender());
        patient.setDateOfBirth(patient.getDateOfBirth());
        Patient updatePatient= patientService.savePatient(patient);
        return ResponseEntity.ok (updatePatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

}
