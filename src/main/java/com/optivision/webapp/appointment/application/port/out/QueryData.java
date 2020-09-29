package com.optivision.webapp.appointment.application.port.out;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface QueryData <E, K>{
    List<E> getAllOcurrences();
    E save(E e);
}
