package com.example.demo.controller;

import com.example.demo.entity.Show;
import com.example.demo.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {
    @Autowired
    private ShowService showService;

    @GetMapping
    public List<Show> getShows(@RequestParam Long movieId, @RequestParam Long theaterId) {
        return showService.getShows(movieId, theaterId);
    }

    @GetMapping("/{id}/seats")
    public List<?> getSeats(@PathVariable Long id) {
        return showService.getShow(id).getSeats(); // Will adjust for seat service
    }
}

