package com.smartcab.cab.service;

import com.smartcab.cab.model.*;
import com.smartcab.cab.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private DriverRepository driverRepo;

    public Booking createBooking(String pickup, String drop) {

        Driver driver = driverRepo.findFirstByAvailableTrue();

        Booking b = new Booking();
        b.setPickup(pickup);
        b.setDropLocation(drop);
        b.setDriver(driver);
        b.setPrice(100 + Math.random() * 400);
        b.setStatus("CONFIRMED");

        if (driver != null) {
            driver.setAvailable(false);
            driverRepo.save(driver);
        }

        return bookingRepo.save(b);
    }
}