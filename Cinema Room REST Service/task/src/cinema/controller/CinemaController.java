package cinema.controller;

import cinema.dto.models.statistics.StatsResponseDto;
import cinema.exception.NotValidPasswordKeyException;
import cinema.model.Cinema;
import cinema.service.CinemaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class CinemaController {

    private final CinemaService cinemaService;

    @Autowired
    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/seats")
    @ResponseStatus(HttpStatus.OK)
    public Cinema getCinema() {
        return cinemaService.getCinema();
    }

    @PostMapping("/stats")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> getStatistics(@RequestParam(required = false) String password) {

        if (password == null || password.equals("")) {
            throw new NotValidPasswordKeyException("The password is wrong!");
        }

        String key = "super_secret";

        if (!password.equals(key)) {
            throw new NotValidPasswordKeyException("The password is wrong!");
        }

        StatsResponseDto statistics = new StatsResponseDto(
                cinemaService.currentIncome(),
                cinemaService.numberOfAvailableSeats(),
                cinemaService.numberOfPurchasedTickets());

        return ResponseEntity.ok().body(statistics);
    }
}