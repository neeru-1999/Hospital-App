package com.example.demo.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Appointment;
import com.example.demo.Entity.MedicalStaff;
import com.example.demo.Entity.Patient;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	
	List<Appointment> findByPatient(Patient patient);

    List<Appointment> findByMedicalStaff(MedicalStaff medicalStaff);

    List<Appointment> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);


}
