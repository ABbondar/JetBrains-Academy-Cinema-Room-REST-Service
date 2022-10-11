package cinema.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
public class Seat {

    private final int row;
    private final int seat;

    @JsonIgnore
    private final boolean isBooked;

    public int getRow() {
        return row;
    }

    @JsonGetter("column")
    public int getSeat() {
        return seat;
    }
}