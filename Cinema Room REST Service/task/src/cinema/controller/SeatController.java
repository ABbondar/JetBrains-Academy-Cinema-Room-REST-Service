package cinema.controller;

import cinema.dto.models.SeatRequestDto;
import cinema.dto.models.SeatResponseDto;
import cinema.service.SeatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@Slf4j
public class SeatController {

    private final SeatService seatService;

    @Autowired
    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> bookSeat(@RequestBody SeatRequestDto seatRequestDto) {

        seatService.bookSeat(seatRequestDto.getRow(), seatRequestDto.getSeat());

        SeatResponseDto seatResponseDto = new SeatResponseDto(
                seatRequestDto.getRow(),
                seatRequestDto.getSeat(),
                seatService.getPrice(seatRequestDto.getRow()));

        return ResponseEntity.ok().body(seatResponseDto);
    }
}