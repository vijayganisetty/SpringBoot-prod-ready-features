package com.practice.springboot.prod_ready_features.prod_ready_features.clients;

import com.practice.springboot.prod_ready_features.prod_ready_features.DTO.EmployeeDTO;
import com.practice.springboot.prod_ready_features.prod_ready_features.advice.ResourceNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Arrays;

@Service
public class EmployeeClientImpl implements EmployeeClient {


    private final RestClient restClient;

//    @PostConstruct
//    void test() {
//        System.out.println(getEmployeeById(11L));
//    }

//    @PostConstruct
//    void createEmp(){
//        EmployeeDTO emp = new EmployeeDTO();
//        emp.setName("Jayasri");
//        System.out.println(createEmployee(emp));
//    }

    public EmployeeClientImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        try {
            EmployeeDTO emp = restClient.get()
                    .uri("/employees/{id}", id)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) ->
                    {
                        System.out.println("------------"+Arrays.toString(res.getBody().readAllBytes()));
                        throw  new ResourceNotFoundException("could not found exception by id +"+id);
                    })
                    .onStatus(HttpStatusCode::is2xxSuccessful, (req, res) ->
                    {
                        System.out.println("we got employee");
                    })
                    .body(EmployeeDTO.class);

            System.out.println(emp);
            return emp;
        } catch (RuntimeException r) {
            throw new RuntimeException(r);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {

        return restClient.post()
                .uri("/employees")
                 .body(employee)
                 .retrieve()
                 .body(EmployeeDTO.class);
    }

}
