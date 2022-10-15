package cinema.dao;

import cinema.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketDao {

    List<Ticket> allAvailableTickets();

}