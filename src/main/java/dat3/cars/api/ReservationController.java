package dat3.cars.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.service.ReservationService;

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
