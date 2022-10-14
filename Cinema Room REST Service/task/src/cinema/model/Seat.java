package cinema.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
public class Seat {

    private final int row;
    private final int seat;
    private int price;

    @JsonIgnore
    private boolean isBooked;

    public int getRow() {
        return row;
    }

    @JsonGetter("column")
    public int getSeat() {
        return seat;
    }

    @JsonGetter("price")
    public int getPrice() {
        return price;
    }

    @JsonIgnore
    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}