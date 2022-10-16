package cinema.service;

import cinema.model.Cinema;

public interface CinemaService {

    Cinema getCinema();

    int currentIncome();

    int numberOfAvailableSeats();

    int numberOfPurchasedTickets();
}