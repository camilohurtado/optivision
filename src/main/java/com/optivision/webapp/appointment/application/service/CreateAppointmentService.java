package com.optivision.webapp.appointment.application.service;

import com.optivision.webapp.appointment.adapter.out.persistence.entity.Appointment;
import com.optivision.webapp.appointment.application.port.in.CreateAppointmentUseCase;
import com.optivision.webapp.appointment.application.port.out.QueryData;
import com.optivision.webapp.appointment.domain.appointment.entity.AppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateAppointmentService implements CreateAppointmentUseCase<AppointmentDTO, String> {

    private final QueryData<Appointment, String> queryData;

    @Override
    public AppointmentDTO registerAppointment(AppointmentDTO dto) {

        queryData.getAllOcurrences().stream()
                .


        Appointment response = queryData.save(dto.toEntity());
        return response.toDto();
    }
}
