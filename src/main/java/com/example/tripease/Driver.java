package com.example.tripease;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Driver_Info")
public class Driver {
    @Id
    private int driverId;
    @Column(name="firstname")
    private String name;
    private int age;
    private String emailId;
}
