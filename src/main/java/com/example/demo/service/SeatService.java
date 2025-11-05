package com.example.demo.service;

import com.example.demo.entity.Seat;
import com.example.demo.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatService {
    @Autowired
    private SeatRepository seatRepository;

    public List<Seat> getAvailableSeats(Long showId) {
        return seatRepository.findByShow_ShowIdAndStatus(showId, Seat.Status.AVAILABLE);
    }

    public List<Seat> getSeats(Long showId) {
        return seatRepository.findByShow_ShowId(showId);
    }
}

