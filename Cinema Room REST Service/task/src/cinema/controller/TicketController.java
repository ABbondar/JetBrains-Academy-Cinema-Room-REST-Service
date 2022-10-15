package cinema.controller;

import cinema.dto.models.ticket.TicketReturnedDto;
import cinema.exception.NotValidTokenException;
import cinema.model.Ticket;
import cinema.model.Token;
import cinema.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> returnTicket(@RequestBody Token token) {

        Ticket ticket = ticketService.getTicketByToken(token);

        if (ticket.getToken().isValid()) {
            ticketService.returnTicket(token);

        } else {
            throw new NotValidTokenException("Wrong token!");
        }

        TicketReturnedDto ticketReturnedDto =
                new TicketReturnedDto(ticketService.returnTicket(token));

        return ResponseEntity.ok().body(ticketReturnedDto);
    }
}