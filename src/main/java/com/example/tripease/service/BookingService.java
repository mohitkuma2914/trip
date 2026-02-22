package com.example.tripease.service;

import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingRessponse;
import com.example.tripease.exception.CabUnavailableException;
import com.example.tripease.exception.CustomerNotFoundException;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.BookingRepository;
import com.example.tripease.repository.CabRepository;
import com.example.tripease.repository.CustomerRepository;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.BookingTransFormers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BookingService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CabRepository cabRepository;
    @Autowired
    DriverRepository driverRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public BookingRessponse bookCab(BookingRequest bookingRequest, int customerId) {
        Optional<Customer> optionalCustomer=customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("invalid customer");

        }
        Customer customer=optionalCustomer.get();
        Cab availableCab=cabRepository.getAvailableCabTRandomly();
        if(availableCab==null){
            throw new CabUnavailableException("Sorry ! no cabs available");
        }
        Booking booking= BookingTransFormers.bookingRequesttobooking(bookingRequest, availableCab.getPerkmRate());
        Booking savedBooking=bookingRepository.save(booking);
        availableCab.setAvailable(false);
        customer.getBooking().add(savedBooking);
        Driver driver=driverRepository.getDriverbyCabId(availableCab.getCabId());
        driver.getBooking().add(savedBooking);
       Customer saveCustomer= customerRepository.save(customer);
       Driver saveDriver=driverRepository.save(driver);
       sendEmail(saveCustomer);
       return BookingTransFormers.bookingToBookingResponse(savedBooking,saveCustomer,availableCab,saveDriver);
    }
    private  void sendEmail(Customer customer){
        String text="Congrates !!"+customer.getName()+"your cab has been booked";
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("mohitspringaccio@gmail.com");
        simpleMailMessage.setTo(customer.getEmailId());
        simpleMailMessage.setSubject("cab booked");
        simpleMailMessage.setText(text);
        javaMailSender.send(simpleMailMessage);

    }

}
