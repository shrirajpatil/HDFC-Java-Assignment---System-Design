package com.example.demo.repository;

import com.example.demo.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByMovie_MovieIdAndTheater_TheaterId(Long movieId, Long theaterId);
}

