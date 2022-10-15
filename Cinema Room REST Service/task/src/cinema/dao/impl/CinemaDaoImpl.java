package cinema.dao.impl;

import cinema.dao.CinemaDao;
import cinema.model.Seat;
import cinema.model.Cinema;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaDaoImpl implements CinemaDao {

    private final int rowsAmount = 9;
    private final int seatsAmount = 9;
    private final ArrayList<Seat> availableSeats = new ArrayList<>();

    private final Cinema cinema = new Cinema(rowsAmount, seatsAmount, initCinemaHall());

    @Override
    public List<Seat> initCinemaHall() {
        for (int row = 1; row <= rowsAmount; row++) {
            for (int seat = 1; seat <= seatsAmount; seat++) {
                availableSeats.add(new Seat(row, seat, getSeatPrice(row), false));
            }
        }
        return availableSeats;
    }

    @Override
    public int getRowsAmount() {
        return rowsAmount;
    }

    @Override
    public int getSeatsAmount() {
        return seatsAmount;
    }

    @Override
    public Cinema getCinema() {
        return cinema;
    }

    @Override
    public ArrayList<Seat> getAvailableSeats() {
        return availableSeats;
    }

    @Override
    public int getSeatPrice(int row) {
        return row <= 4 ? 10 : 8;
    }
}