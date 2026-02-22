package com.example.tripease.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CabRequest {
    private String cabNumber;
    private String cabModel;
    private double perkmRate;
    private boolean available;
}
