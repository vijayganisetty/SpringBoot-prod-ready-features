package com.practice.springboot.prod_ready_features.prod_ready_features.clients;

import com.practice.springboot.prod_ready_features.prod_ready_features.DTO.EmployeeDTO;

public interface EmployeeClient {

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employee);
}
