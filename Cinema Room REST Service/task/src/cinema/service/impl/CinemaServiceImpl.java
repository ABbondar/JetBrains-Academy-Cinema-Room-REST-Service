package cinema.service.impl;

import cinema.dao.CinemaDao;
import cinema.model.Cinema;
import cinema.model.Seat;
import cinema.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaDao cinemaDao;

    @Autowired
    public CinemaServiceImpl(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @Override
    public Cinema getCinema() {
        return cinemaDao.getCinema();
    }

    @Override
    public int currentIncome() {
        int income = 0;
        for (Seat s : cinemaDao.getAvailableSeats()) {
            if (s.isBooked()) {
                income += s.getPrice();
            }
        }
        return income;
    }

    @Override
    public int numberOfAvailableSeats() {
        int number = 0;
        for (Seat s : cinemaDao.getAvailableSeats()) {
            if (!s.isBooked()) {
                number++;
            }
        }
        return number;
    }

    @Override
    public int numberOfPurchasedTickets() {
        int number = 0;
        for (Seat s : cinemaDao.getAvailableSeats()) {
            if (s.isBooked()) {
                number++;
            }
        }
        return number;
    }
}