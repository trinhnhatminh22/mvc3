package com.example.demo.common;

import com.example.demo.dto.EmployeeDTO;

public class Common {
    public static String validateEmployee(EmployeeDTO employeeDTO){
        String message = "";
        if(employeeDTO.getName().isEmpty()){
            message = "Input name";
        }else if(employeeDTO.getAge() == 0){
            message = "Input age";
        }else if(employeeDTO.getAddress().isEmpty()){
            message = "input address";
        }
        return message;
    }
}
