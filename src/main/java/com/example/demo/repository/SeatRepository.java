package com.example.demo.repository;

import com.example.demo.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByShow_ShowIdAndStatus(Long showId, Seat.Status status);
    List<Seat> findByShow_ShowId(Long showId);
}

