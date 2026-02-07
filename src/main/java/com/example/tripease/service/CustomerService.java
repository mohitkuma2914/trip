package com.example.tripease.service;

import com.example.tripease.Enum.Gender;
import com.example.tripease.dto.request.CustomerRequest;
import com.example.tripease.dto.response.CustomerResponse;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Customer;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.transformer.CustomerTransFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse toAddCustomer(CustomerRequest customerRequest){
        Customer customer=CustomerTransFormer.customerRequestToCustomer(customerRequest);


        Customer savecustomer=customerRepository.save(customer);

        return CustomerTransFormer.customerToCustomerResponse(customer);
    }


    public CustomerResponse togetCustomer(int customerId) {
       Optional<Customer> optionalCustomer= customerRepository.findById(customerId);
       if(optionalCustomer.isEmpty()){
           throw new CustomerNotFoundException("invalid customer id");
       }
        Customer savecustomer=optionalCustomer.get();

        return CustomerTransFormer.customerToCustomerResponse(savecustomer);
    }

    public List<CustomerResponse> getBygender(Gender gender) {
        List<Customer> customers= customerRepository.findByGender(gender);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransFormer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
    public List<CustomerResponse> getByGenderAndAge(Gender gender,int age){
        List<Customer> customers=customerRepository.findByGenderAndAge(gender,age);
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransFormer.customerToCustomerResponse(customer));
        }
        return customerResponses;

    }

    public List<CustomerResponse> getAllByGenderAndGreaterBy(Gender gender, int age) {
        List<Customer> customers=customerRepository.getAllByGenderAndGreaterBy(gender,age);

        List<CustomerResponse> customerResponses = new ArrayList<>();
        for(Customer customer:customers){
            customerResponses.add(CustomerTransFormer.customerToCustomerResponse(customer));
        }
        return customerResponses;
    }
}
