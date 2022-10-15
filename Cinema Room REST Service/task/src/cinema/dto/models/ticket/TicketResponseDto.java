package cinema.dto.models.ticket;

import cinema.model.Seat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TicketResponseDto {

    @JsonProperty("token")
    private String token;

    @JsonProperty("ticket")
    private Seat seat;
}