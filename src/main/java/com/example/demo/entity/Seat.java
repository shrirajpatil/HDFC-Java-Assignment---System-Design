package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        AVAILABLE, BOOKED
    }
    // getters and setters
}

