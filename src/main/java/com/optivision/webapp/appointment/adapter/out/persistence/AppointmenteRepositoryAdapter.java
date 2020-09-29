package com.optivision.webapp.appointment.adapter.out.persistence;

import com.optivision.webapp.appointment.adapter.out.persistence.entity.Appointment;
import com.optivision.webapp.appointment.application.port.out.QueryData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AppointmenteRepositoryAdapter implements QueryData<Appointment, String> {

    private final AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAllOcurrences() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
