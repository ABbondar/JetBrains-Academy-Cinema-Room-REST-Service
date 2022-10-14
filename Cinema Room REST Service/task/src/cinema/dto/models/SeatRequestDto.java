package cinema.dto.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class SeatRequestDto {

    private int row;

    @JsonProperty("column")
    private int seat;
}
