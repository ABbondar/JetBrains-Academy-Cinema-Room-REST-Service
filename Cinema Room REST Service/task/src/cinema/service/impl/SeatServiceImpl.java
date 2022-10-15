package cinema.service.impl;

import cinema.dao.CinemaDao;
import cinema.exception.NotAvailableSeatException;
import cinema.exception.NotValidSeatException;
import cinema.model.Seat;
import cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final CinemaDao cinemaDao;

    @Autowired
    public SeatServiceImpl(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @Override
    public boolean isSeatValid(int row, int seat) {
        return row <= cinemaDao.getRowsAmount()
                && seat <= cinemaDao.getSeatsAmount()
                && row > 0 && seat > 0;
    }

    @Override
    public boolean isSeatAvailable(int row, int seat) {
        List<Seat> cinema = cinemaDao.getAvailableSeats();
        for (Seat s : cinema) {
            if (s.getRow() == row && s.getSeat() == seat && s.isBooked()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Seat bookSeat(int row, int seat) {

        if (!isSeatAvailable(row, seat)) {
            throw new NotAvailableSeatException("The ticket has been already purchased!");
        }

        if (!isSeatValid(row, seat)) {
            throw new NotValidSeatException("The number of a row or a column is out of bounds!");
        }

        Seat bookedSeat = new Seat();

        List<Seat> seats = cinemaDao.getCinema().getSeats();
        for (Seat s : seats) {
            if (s.getRow() == row && s.getSeat() == seat) {
                s.setBooked(true);
                bookedSeat = s;
            }
        }
        return bookedSeat;
    }

    @Override
    public int getSeatPrice(int row) {
        return cinemaDao.getSeatPrice(row);
    }
}