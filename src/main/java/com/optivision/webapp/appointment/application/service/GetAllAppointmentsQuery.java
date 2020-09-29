package com.optivision.webapp.appointment.application.service;

import com.optivision.webapp.appointment.application.port.in.GetAllAppointmentsUseCase;
import com.optivision.webapp.appointment.application.port.out.QueryData;
import com.optivision.webapp.appointment.domain.appointment.entity.AppointmentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllAppointmentsQuery implements GetAllAppointmentsUseCase {

    private QueryData queryData;

    GetAllAppointmentsQuery(QueryData queryData){
        this.queryData = queryData;
    }
    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return queryData.getAllOcurrences();
    }
}
