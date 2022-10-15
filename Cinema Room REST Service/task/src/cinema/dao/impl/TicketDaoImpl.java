package cinema.dao.impl;

import cinema.dao.CinemaDao;
import cinema.dao.TicketDao;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    private final List<Ticket> tickets = new ArrayList<>();
    private final CinemaDao cinemaDao;

    @Autowired
    public TicketDaoImpl(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    @Override
    public List<Ticket> allAvailableTickets() {
        ArrayList<Seat> seats = cinemaDao.getAvailableSeats();
        Token token = new Token("", false);

        for (Seat s : seats) {
            tickets.add(new Ticket(token, s));
        }
        return tickets;
    }
}