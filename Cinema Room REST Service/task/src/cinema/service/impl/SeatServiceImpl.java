package cinema.service.impl;

import cinema.dao.ViewDao;
import cinema.exception.NotAvailableSeatException;
import cinema.exception.OutOfBoundException;
import cinema.model.Seat;
import cinema.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    private final ViewDao viewDao;

    @Autowired
    public SeatServiceImpl(ViewDao viewDao) {
        this.viewDao = viewDao;
    }

    @Override
    public int getPrice(int row) {
        return row <= 4 ? 10 : 8;
    }

    @Override
    public void bookSeat(int row, int seat) {

        if (!isAvailable(row, seat)) {
            throw new NotAvailableSeatException("The ticket has been already purchased!");
        }

        if (!isSeatValid(row, seat)) {
            throw new OutOfBoundException("The number of a row or a column is out of bounds!");
        }

        List<Seat> seats = viewDao.getCinema().getSeats();
        for (Seat s : seats) {
            if (s.getRow() == row && s.getSeat() == seat) {
                s.setBooked(true);
            }
        }
    }

    @Override
    public boolean isAvailable(int row, int seat) {
        List<Seat> cinema = viewDao.getAvailableSeats();
        for (Seat s : cinema) {
            if (s.getRow() == row && s.getSeat() == seat && s.isBooked()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isSeatValid(int row, int seat) {
        return row <= viewDao.getRowsAmount() && seat <= viewDao.getSeatsAmount() && row > 0 && seat > 0;
    }
}