package com.example.tripease.dto.response;

import com.example.tripease.Enum.TripStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingRessponse {
    String pickup;
     String destination;

    double tripDestinationInKm;
    TripStatus tripStatus;
    double billAmount;

    Date bookedAt;

    Date lastUpdate;
    CustomerResponse customer;
    CabResponse cab;
}
