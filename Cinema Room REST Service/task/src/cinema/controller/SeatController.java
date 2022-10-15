package cinema.controller;

import cinema.dto.models.seat.SeatRequestDto;
import cinema.dto.models.ticket.TicketResponseDto;
import cinema.model.Seat;
import cinema.model.Ticket;
import cinema.service.SeatService;
import cinema.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SeatController {

    private final SeatService seatService;
    private final TicketService ticketService;

    @Autowired
    public SeatController(SeatService seatService, TicketService ticketService) {
        this.seatService = seatService;
        this.ticketService = ticketService;
    }

    @PostMapping("/purchase")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> bookSeat(@RequestBody SeatRequestDto seatRequestDto) {

        Seat seat = seatService.bookSeat(seatRequestDto.getRow(), seatRequestDto.getSeat());

        Ticket ticket = ticketService.bookTicket(seatRequestDto.getRow(), seat);
        TicketResponseDto ticketResponseDto = new TicketResponseDto(ticket.getToken().getName(), seat);
        return ResponseEntity.ok().body(ticketResponseDto);
    }
}