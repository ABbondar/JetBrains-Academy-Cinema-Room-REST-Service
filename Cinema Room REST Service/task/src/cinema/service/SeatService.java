package cinema.service;

import org.springframework.stereotype.Service;

@Service
public interface SeatService {

    int getPrice(int row);

    void bookSeat(int row, int seat);

    boolean isAvailable(int row, int seat);

    boolean isSeatValid (int row, int seat);
}