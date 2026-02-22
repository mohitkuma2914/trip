package com.example.tripease.transformer;

import com.example.tripease.dto.request.DriverRequest;
import com.example.tripease.dto.response.DriverResponse;
import com.example.tripease.model.Driver;

public class DriverTransFormer {
    public static Driver driverRequesttodriver(DriverRequest driverRequest){
              return  Driver.builder()
                .name(driverRequest.getName())
                .age(driverRequest.getAge())
                .emailId(driverRequest.getEmailId())
                        .build();

    }
    public static  DriverResponse drivartoDriverRespons(Driver driver){
        return DriverResponse.builder()
                .driverId(driver.getDriverId())
                .name(driver.getName())
                .age(driver.getAge())
                .emailId(driver.getEmailId())
                .build();
    }


}
