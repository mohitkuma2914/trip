package com.example.tripease.service;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.exception.DriverNotFoundException;
import com.example.tripease.model.Driver;
import com.example.tripease.repository.DriverRepository;
import com.example.tripease.transformer.DriverTransFormer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverService {
    @Autowired
    DriverRepository driverRepository;

    public DriverResponse addDriver(DriverRequest driverRequest) {
    Driver driver = DriverTransFormer.driverRequesttodriver(driverRequest);
    Driver savedDriver=driverRepository.save(driver);
    return DriverTransFormer.drivartoDriverRespons(savedDriver);
    }

    public DriverResponse getDriverById(int driverId) {
        Optional<Driver> optionalDriver=driverRepository.findById(driverId);
        if(optionalDriver.isEmpty()){
            throw new DriverNotFoundException("invalid Input");
        }
        Driver saveDriver=optionalDriver.get();
        return DriverTransFormer.drivartoDriverRespons(saveDriver);
    }
}
