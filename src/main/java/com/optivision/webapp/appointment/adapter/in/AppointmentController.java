package com.optivision.webapp.appointment.adapter.in;

import com.optivision.webapp.appointment.application.port.in.CreateAppointmentUseCase;
import com.optivision.webapp.appointment.application.port.in.GetAllAppointmentsUseCase;
import com.optivision.webapp.appointment.domain.appointment.entity.AppointmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final CreateAppointmentUseCase createAppointmentUseCase;
    //private final DeleteAppointmentUseCase deleteAppointmentUseCase;
    private final GetAllAppointmentsUseCase getAllAppointmentsUseCase;
    //private final UpdateAppointmentUseCase updateAppointmentUseCase;

    @GetMapping("")
    public ResponseEntity<?> getAllAppointments(){
        return ResponseEntity.ok(getAllAppointmentsUseCase.getAllAppointments());
    }

    @PostMapping("")
    public ResponseEntity<?> setAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO){
        return ResponseEntity.ok(createAppointmentUseCase.registerAppointment(appointmentDTO));
    }
}
