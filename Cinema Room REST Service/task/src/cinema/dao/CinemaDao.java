package cinema.dao;

import cinema.model.Cinema;
import cinema.model.Seat;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CinemaDao {

    List<Seat> initCinemaHall();

    int getRowsAmount();

    int getSeatsAmount();

    Cinema getCinema();

    ArrayList<Seat> getAvailableSeats();

    int getSeatPrice(int row);
}