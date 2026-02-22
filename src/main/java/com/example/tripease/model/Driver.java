package com.example.tripease.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="Driver_Info")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId;
    @Column(name="firstname")
    private String name;
    private int age;
    @Column(unique = true,nullable = false)
    private String emailId;


    @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn( name="DriverId")
    List<Booking> booking=new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cabId")
    Cab cab;
}
