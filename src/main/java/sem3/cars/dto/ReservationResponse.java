package sem3.cars.dto;

import sem3.cars.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationResponse {
    int id;
    int carId;
    String brand;
    String model;
    LocalDate reservationDate;
    
    public ReservationResponse(Reservation reservation){
        this.id = reservation.getId();
        this.carId = reservation.getCar().getId();
        this.brand = reservation.getCar().getBrand();
        this.model = reservation.getCar().getModel();
        this.reservationDate = reservation.getRentalDate();
    }
}
