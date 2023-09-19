package dat3.cars.api;

import org.springframework.web.bind.annotation.*;
import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    ReservationService reservationService;
    
    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }
    
    @GetMapping(path = "/{username}")
    List<ReservationResponse> getResevertations(@PathVariable String username){
        return reservationService.getReseverationByUsername(username);
    }
    
    
    @PostMapping
    ReservationResponse MakeReservation(@RequestBody ReservationRequest body){
        ReservationResponse res = reservationService.reserveCar(body);
        return res;
    }
}
