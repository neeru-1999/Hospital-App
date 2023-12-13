package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.MedicalStaff;
import com.example.demo.Service.MedicalStaffService;

@RestController
@RequestMapping("/medicalstaff")
public class MedicalStaffController {
	
	@Autowired
    private MedicalStaffService medicalStaffService;

    @GetMapping("/all")
    public ResponseEntity<List<MedicalStaff>> getAllMedicalStaff() {
        return ResponseEntity.ok(medicalStaffService.getAllMedicalStaff());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalStaff> getMedicalStaffById(@PathVariable Long id) {
        MedicalStaff medicalStaff = medicalStaffService.getMedicalStaffById(id);
        if (medicalStaff != null) {
            return ResponseEntity.ok(medicalStaff);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search/specialization/{specialization}")
    public ResponseEntity<List<MedicalStaff>> getMedicalStaffBySpecialization(@PathVariable String specialization) {
        return ResponseEntity.ok(medicalStaffService.getMedicalStaffBySpecialization(specialization));
    }

    @PostMapping("/save")
    public ResponseEntity<MedicalStaff> saveMedicalStaff(@RequestBody MedicalStaff medicalStaff) {
        return ResponseEntity.ok(medicalStaffService.saveMedicalStaff(medicalStaff));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicalStaff(@PathVariable Long id) {
        medicalStaffService.deleteMedicalStaff(id);
        return ResponseEntity.noContent().build();
    }

}
