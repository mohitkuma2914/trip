package com.example.tripease.transformer;

import com.example.tripease.Enum.TripStatus;
import com.example.tripease.dto.request.BookingRequest;
import com.example.tripease.dto.response.BookingRessponse;
import com.example.tripease.model.Booking;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Customer;
import com.example.tripease.model.Driver;

public class BookingTransFormers {
    public static Booking bookingRequesttobooking(BookingRequest bookingRequest,double perKmRate){
        return Booking.builder()
                .pickup(bookingRequest.getPickup())
                .destination(bookingRequest.getDestination())
                .tripDestinationInKm(bookingRequest.getTripDestinationInKm())
                .tripStatus(TripStatus.PLANNED)
                .billAmount(bookingRequest.getTripDestinationInKm()*perKmRate)
                .build();
    }
    public static BookingRessponse bookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver){
        return BookingRessponse .builder()
                .pickup(booking.getPickup())
                .destination(booking.getDestination())
                .tripDestinationInKm(booking.getTripDestinationInKm())
                .tripStatus(booking.getTripStatus())
                .billAmount(booking.getBillAmount())
                .bookedAt(booking.getBookedAt())
                .lastUpdate(booking.getLastUpdate())
                .customer(CustomerTransFormer.customerToCustomerResponse(customer))
                .cab(CabTransFormer.cabToCabResponse(cab,driver)).build();
    }


}
