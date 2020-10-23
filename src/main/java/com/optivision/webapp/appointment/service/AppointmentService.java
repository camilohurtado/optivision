package com.optivision.webapp.cita.service;

import com.optivision.webapp.cita.entity.Appointment;
import com.optivision.webapp.cita.dto.AppointmentDTO;
import com.optivision.webapp.cita.exception.CollidingAppointmentHoursException;
import com.optivision.webapp.cita.persistence.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    /**
     * Get all Appointments stored in database
     *
     * @return List of {@link AppointmentDTO}
     */
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(appointment -> appointment.toDto())
                .collect(Collectors.toList());
    }

    /**
     * Register a new Appointment in the system. This method validates
     * that there is not colliding hours between the appointments. So
     * first checks for this, and then register a new instance. This method
     * also makes the mapping between entity and dto process.
     *
     * @param dto - {@link AppointmentDTO}
     * @return AppointmentDTO - {@link AppointmentDTO}
     * @throws CollidingAppointmentHoursException
     */
    public AppointmentDTO registerAppointment(AppointmentDTO dto) throws CollidingAppointmentHoursException {

        boolean colliding = appointmentRepository.findAll()
                .stream()
                .anyMatch(appointment ->
                        dto.getFechaCita().equals(appointment.getFechaCita()) &&
                                dto.getHoraCita().equals(LocalTime.parse(appointment.getHoraCita())));

        if(colliding){
            throw new CollidingAppointmentHoursException("Ya existe una cita para la fecha y hora indicada. Por" +
                    "favor cambie la hora y/o la fecha de la cita");
        }

        Appointment response = appointmentRepository.save(dto.toEntity());
        return response.toDto();
    }
}
