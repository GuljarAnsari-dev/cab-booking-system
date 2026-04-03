package com.smartcab.cab.repository;

import com.smartcab.cab.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}