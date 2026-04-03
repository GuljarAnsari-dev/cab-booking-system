package com.smartcab.cab.repository;

import com.smartcab.cab.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findFirstByAvailableTrue();
}