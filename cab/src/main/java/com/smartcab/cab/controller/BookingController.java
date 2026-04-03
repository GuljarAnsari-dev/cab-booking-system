package com.smartcab.cab.controller;

import com.smartcab.cab.model.Booking;
import com.smartcab.cab.repository.BookingRepository;
import com.smartcab.cab.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookingController {

    @Autowired
    private BookingService service;

    @Autowired
    private BookingRepository repo;

    @GetMapping("/")
    public String home() {
        return "booking";
    }

    @PostMapping("/book")
    public String book(String pickup, String drop, Model model) {
        Booking b = service.createBooking(pickup, drop);
        model.addAttribute("booking", b);
        return "result";
    }

    @GetMapping("/history")
    public String history(Model model) {
        model.addAttribute("bookings", repo.findAll());
        return "history";
    }
}