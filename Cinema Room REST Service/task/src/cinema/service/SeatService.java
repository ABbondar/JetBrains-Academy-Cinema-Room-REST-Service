package cinema.service;

import cinema.model.Seat;

public interface SeatService {

    boolean isSeatValid(int row, int seat);

    boolean isSeatAvailable(int row, int seat);

    Seat bookSeat(int row, int seat);

    int getSeatPrice(int row);

}