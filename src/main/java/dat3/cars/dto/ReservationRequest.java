package dat3.cars.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {
    int carId;
    String userName;
    @JsonFormat(pattern = "yyy-MM-dd", shape = JsonFormat.Shape.STRING)
    LocalDate date;
}
