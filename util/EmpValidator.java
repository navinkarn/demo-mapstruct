package com.example.demo.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.ValidationException;

@Component
public class EmpValidator {

    public long validateEmpId(long empId) throws ValidationException{
        if(empId == -1){
            throw  new ValidationException("Invalid value in ID");
        }
        return empId;
    }
}
