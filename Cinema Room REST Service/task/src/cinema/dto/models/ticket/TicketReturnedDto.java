package cinema.dto.models.ticket;

import cinema.model.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketReturnedDto {

    @JsonProperty("returned_ticket")
    private Seat seat;
}