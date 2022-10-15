package cinema.service;

import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.model.Token;

public interface TicketService {

    Ticket bookTicket(int row, Seat seat);

    Seat getSeatByToken(Token token);

    Ticket getTicketByToken(Token token);

    Seat returnTicket(Token token);

}