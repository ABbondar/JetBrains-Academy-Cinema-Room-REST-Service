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

    public List<Seat> initCinemaHall() {
        for (int row = 1; row <= rowsAmount; row++) {
            for (int seat = 1; seat <= seatsAmount; seat++) {
                availableSeats.add(new Seat(row, seat, getPrice(row), false));
            }
        }
        return availableSeats;
    }

    public ArrayList<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public int getPrice(int row) {
        return row <= 4 ? 10 : 8;
    }

    public int getRowsAmount() {
        return rowsAmount;
    }

    public int getSeatsAmount() {
        return seatsAmount;
    }
}