package com.example.demo.controller;

import com.example.demo.entity.Seat;
import com.example.demo.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @GetMapping("/show/{showId}")
    public List<Seat> getAvailableSeats(@PathVariable Long showId) {
        return seatService.getAvailableSeats(showId);
    }
}

