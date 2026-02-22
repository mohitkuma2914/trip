package com.example.tripease.controller;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;
import com.example.tripease.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
@Autowired
    CustomerService customerService;

@PostMapping("/add")
    public CustomerResponse toAddCustomer(@RequestBody CustomerRequest customerrequest){
        return customerService.toAddCustomer(customerrequest);
    }
    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse togetCustomer(@PathVariable("id") int customerId){
     return customerService.togetCustomer(customerId);
    }
    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getBygender( @PathVariable("gender") Gender gender){
    return customerService.getBygender(gender);
    }
    @GetMapping("/get")
    public List<CustomerResponse> getByGenderAndAge(@RequestParam("gender") Gender gender,
                                                    @RequestParam("age") int age){
        return customerService.getByGenderAndAge(gender,age);
    }
    @GetMapping("/gender-greater-age")
    public List<CustomerResponse> getAllByGenderAndGreaterBy(@RequestParam("gender") String gender,
                                                             @RequestParam("age") int age){
    return customerService.getAllByGenderAndGreaterBy(gender,age);
    }


}
