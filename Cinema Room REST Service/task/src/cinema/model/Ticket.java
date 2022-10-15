package cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    @JsonProperty("token")
    private Token token;

    @JsonProperty("ticket")
    private Seat seat;
}