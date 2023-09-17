package sem3.cars.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sem3.cars.dto.ReservationRequest;
import sem3.cars.dto.ReservationResponse;
import sem3.cars.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    ReservationService reservationService;
    
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    
    @PostMapping
    ReservationResponse MakeReservation(@RequestBody ReservationRequest body){
        ReservationResponse res = reservationService.reserveCar(body);
        return res;
    }
}
