package cinema.dto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeatResponseDto {

    @JsonProperty("row")
    private int row;

    @JsonProperty("column")
    private int seat;

    @JsonProperty("price")
    private int price;

}