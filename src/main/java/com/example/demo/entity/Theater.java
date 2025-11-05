package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "theaters")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theaterId;
    private String name;
    private String city;
    // getters and setters
}

