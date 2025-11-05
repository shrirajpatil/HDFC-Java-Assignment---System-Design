package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowRepository showRepository;

    @Transactional
    public Booking bookSeat(Long userId, Long showId, Long seatId) {
        Seat seat = seatRepository.findById(seatId).orElseThrow();
        if (seat.getStatus() != Seat.Status.AVAILABLE) {
            throw new RuntimeException("Seat not available");
        }
        seat.setStatus(Seat.Status.BOOKED);
        seatRepository.save(seat);
        Booking booking = new Booking();
        booking.setUser(userRepository.findById(userId).orElseThrow());
        booking.setShow(showRepository.findById(showId).orElseThrow());
        booking.setSeat(seat);
        booking.setStatus(Booking.Status.CONFIRMED);
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    public List<Booking> getBookingsByUser(Long userId) {
        return bookingRepository.findByUser_UserId(userId);
    }
}

