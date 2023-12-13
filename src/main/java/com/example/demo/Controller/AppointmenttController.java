package com.example.demo.Controller;

import java.time.LocalDateTime;
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

import com.example.demo.Entity.Appointment;
import com.example.demo.Entity.MedicalStaff;
import com.example.demo.Entity.Patient;
import com.example.demo.Service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmenttController {
	
	@Autowired
    private AppointmentService appointmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id) {
        Appointment appointment = appointmentService.getAppointmentById(id);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatient(@PathVariable Long patientId) {
        Patient patient = new Patient();
        patient.setId(patientId);
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patient));
    }

    @GetMapping("/medicalstaff/{medicalStaffId}")
    public ResponseEntity<List<Appointment>> getAppointmentsByMedicalStaff(@PathVariable Long medicalStaffId) {
        MedicalStaff medicalStaff = new MedicalStaff();
        medicalStaff.setId(medicalStaffId);
        return ResponseEntity.ok(appointmentService.getAppointmentsByMedicalStaff(medicalStaff));
    }

    @GetMapping("/dateRange/{start}/{end}")
    public ResponseEntity<List<Appointment>> getAppointmentsInDateRange(
            @PathVariable String start, @PathVariable String end) {
        // Parse dates from strings, handle exceptions as needed
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
        return ResponseEntity.ok(appointmentService.getAppointmentsInDateRange(startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.saveAppointment(appointment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }

}
