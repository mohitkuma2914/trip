package com.example.tripease.transformer;

import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.model.Customer;

public class CustomerTransFormer {
    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){
        return  Customer.builder()
                .name(customerRequest.getName())
                .age(customerRequest.getAge())
                .emailId(customerRequest.getEmailId())
                .age(customerRequest.getAge()).build();
    }
    public static CustomerResponse customerToCustomerResponse(Customer customer){
        return CustomerResponse.builder().name(customer.getName()).age(customer.getAge()).emailId(customer.getEmailId()).gender(customer.getGender()).build();
    }


}
