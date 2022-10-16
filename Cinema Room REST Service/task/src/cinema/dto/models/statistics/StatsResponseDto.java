package cinema.dto.models.statistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StatsResponseDto {

    @JsonProperty("current_income")
    private int income;

    @JsonProperty("number_of_available_seats")
    private int availableSeats;

    @JsonProperty("number_of_purchased_tickets")
    private int purchasedTickets;

}