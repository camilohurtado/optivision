package com.optivision.webapp.appointment.adapter.out.persistence;

import com.optivision.webapp.appointment.adapter.out.persistence.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
}
