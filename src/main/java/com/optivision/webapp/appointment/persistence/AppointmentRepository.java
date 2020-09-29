package com.optivision.webapp.appointment.persistence;

import com.optivision.webapp.appointment.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
