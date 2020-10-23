package com.optivision.webapp.appointment.controller;

import com.optivision.webapp.appointment.dto.AppointmentDTO;
import com.optivision.webapp.appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("")
    public ResponseEntity<?> getAllAppointments(){
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PostMapping("")
    public ResponseEntity<?> setAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) throws Exception {
        return ResponseEntity.ok(appointmentService.registerAppointment(appointmentDTO));
    }
}
