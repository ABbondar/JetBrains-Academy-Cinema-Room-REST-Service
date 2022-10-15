package cinema.controller;

import cinema.model.Cinema;
import cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
@Slf4j
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Cinema getCinema() {
        return cinemaService.getCinema();
    }
}