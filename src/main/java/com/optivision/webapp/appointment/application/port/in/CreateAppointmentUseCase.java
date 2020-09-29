package com.optivision.webapp.appointment.application.port.in;

/**
 * USE-CASE: Create an appointment for the business
 */
public interface CreateAppointmentUseCase <S, K>{

    S registerAppointment(S cita);
}
