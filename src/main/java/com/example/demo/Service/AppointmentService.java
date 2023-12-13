package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Appointment;
import com.example.demo.Entity.MedicalStaff;
import com.example.demo.Entity.Patient;
import com.example.demo.Repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    public List<Appointment> getAppointmentsByPatient(Patient patient) {
        return appointmentRepository.findByPatient(patient);
    }

    public List<Appointment> getAppointmentsByMedicalStaff(MedicalStaff medicalStaff) {
        return appointmentRepository.findByMedicalStaff(medicalStaff);
    }

    public List<Appointment> getAppointmentsInDateRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByAppointmentDateTimeBetween(start, end);
    }

    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

}
