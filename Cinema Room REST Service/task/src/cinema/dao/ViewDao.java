package cinema.dao;

import cinema.model.Seat;
import cinema.model.View;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewDao {

    private final int rowsAmount = 9;
    private final int seatsAmount = 9;
    private final ArrayList<Seat> availableSeats = new ArrayList<>();

    private final View cinema = new View(rowsAmount, seatsAmount, initCinemaHall());

    public View getCinema() {
        return cinema;
    }

    private List<Seat> initCinemaHall() {
        for (int row = 1; row <= rowsAmount; row++) {
            for (int seat = 1; seat <= seatsAmount; seat++) {
                availableSeats.add(new Seat(row, seat, false));
            }
        }
        return availableSeats;
    }
}