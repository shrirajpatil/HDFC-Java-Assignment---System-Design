package com.example.demo.service;

import com.example.demo.entity.Theater;
import com.example.demo.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getTheatersByCity(String city) {
        return theaterRepository.findByCity(city);
    }
}

