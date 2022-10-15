package cinema.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    private int row;
    private int seat;
    private int price;

    @JsonIgnore
    private boolean isBooked;

    @JsonGetter("row")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seat)) return false;
        Seat seat1 = (Seat) o;
        return row == seat1.row && seat == seat1.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }
}