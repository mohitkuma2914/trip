package com.example.tripease.transformer;

import com.example.tripease.dto.request.CabRequest;
import com.example.tripease.dto.response.CabResponse;
import com.example.tripease.model.Cab;
import com.example.tripease.model.Driver;

public class CabTransFormer {
public static Cab cabRequestTocab(CabRequest cabRequest){
    return Cab.builder()
            .cabNumber(cabRequest.getCabNumber())
            .cabModel(cabRequest.getCabModel())
            .perkmRate(cabRequest.getPerkmRate())
            .available(true).build();
}
public static CabResponse cabToCabResponse(Cab cab, Driver driver){
    return CabResponse.builder()
            .cabNumber(cab.getCabNumber())
            .cabModel(cab.getCabModel())
            .perkmRate(cab.getPerkmRate())
            .available(cab.isAvailable())
            .driver(DriverTransFormer.drivartoDriverRespons(driver))
            .build();

}

}
