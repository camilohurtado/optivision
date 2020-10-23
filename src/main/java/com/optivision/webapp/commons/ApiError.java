package com.optivision.webapp.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private List<String> msg;
    private int httpStatusCode;
    private LocalDate exceptionDate;

    public ApiError(List<String> errors){
        this.msg = errors;
    }

}
