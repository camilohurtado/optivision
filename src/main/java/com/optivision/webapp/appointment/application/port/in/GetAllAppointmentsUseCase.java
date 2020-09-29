package com.optivision.webapp.appointment.application.port.in;

import java.util.List;

public interface GetAllAppointmentsUseCase<E, K> {
    List<E> getAllAppointments();
}
