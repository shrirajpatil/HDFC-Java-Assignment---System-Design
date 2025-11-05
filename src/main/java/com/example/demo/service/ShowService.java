package com.example.demo.service;

import com.example.demo.entity.Show;
import com.example.demo.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    public List<Show> getShows(Long movieId, Long theaterId) {
        return showRepository.findByMovie_MovieIdAndTheater_TheaterId(movieId, theaterId);
    }

    public Show getShow(Long showId) {
        return showRepository.findById(showId).orElse(null);
    }
}

