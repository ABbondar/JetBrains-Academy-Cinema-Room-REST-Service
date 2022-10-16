package cinema.service.impl;

import cinema.dao.TicketDao;
import cinema.exception.NotValidTokenException;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.model.Token;
import cinema.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;

    @Autowired
    public TicketServiceImpl(TicketDao ticketDao) {
        this.ticketDao = ticketDao;
    }

    @Override
    public Ticket bookTicket(int row, Seat seat) {

        Ticket ticket = new Ticket();

        for (Ticket t : ticketDao.allAvailableTickets()) {
            if (t.getSeat().equals(seat)) {
                ticket.setToken(new Token(uuid().toString(), true));
                ticket.setSeat(seat);
                ticket.getSeat().setBooked(true);
            }
        }
        ticketDao.allAvailableTickets().add(ticket);
        return ticket;
    }

    @Override
    public Ticket getTicketByToken(Token token) {

        Ticket ticket = new Ticket();
        List<String> tokenNamesList = new ArrayList<>();

        for (Ticket t : ticketDao.allAvailableTickets()) {
            tokenNamesList.add(t.getToken().getName());
        }

        if (!tokenNamesList.contains(token.getName())) {
            throw new NotValidTokenException("Wrong token!");
        }

        for (Ticket t : ticketDao.allAvailableTickets()) {

            if (t.getToken().getName().equals(token.getName())) {
                ticket = t;
            }
        }
        return ticket;
    }

    @Override
    public Seat getSeatByToken(Token token) {

        Seat seat = new Seat();

        for (Ticket t : ticketDao.allAvailableTickets()) {
            if (t.getToken().getName().equals(token.getName())) {
                return t.getSeat();
            }
        }
        return seat;
    }

    @Override
    public Seat returnTicket(Token token) {
        Ticket ticket = getTicketByToken(token);
        ticket.getToken().setValid(false);
        ticket.getSeat().setBooked(false);
        return getSeatByToken(token);
    }

    @Bean
    private UUID uuid() {
        return UUID.randomUUID();
    }
}