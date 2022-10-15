package cinema.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@ToString
public class Cinema {

    private int rowsAmount;
    private int seatsAmount;
    private List<Seat> seats;

    public Cinema(int rowsAmount, int seatsAmount, List<Seat> seats) {
        this.rowsAmount = rowsAmount;
        this.seatsAmount = seatsAmount;
        this.seats = seats;
    }

    @JsonGetter("total_rows")
    public int getRowsAmount() {
        return rowsAmount;
    }

    @JsonGetter("total_columns")
    public int getSeatsAmount() {
        return seatsAmount;
    }

    @JsonGetter("available_seats")
    public List<Seat> getSeats() {
        return seats;
    }
}