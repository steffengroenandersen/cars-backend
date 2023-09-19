package dat3.cars.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import dat3.cars.dto.ReservationRequest;
import dat3.cars.dto.ReservationResponse;
import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import dat3.cars.repositories.ReservationRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    
    CarRepository carRepository;
    MemberRepository memberRepository;
    ReservationRepository reservationRepository;
    
    public ReservationService(CarRepository carRepository, MemberRepository memberRepository, ReservationRepository reservationRepository){
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
    }
    
    public List<ReservationResponse> getReseverationByUsername(String username){
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(res -> new ReservationResponse(res)).collect(Collectors.toList());
    }
    public ReservationResponse reserveCar(ReservationRequest body){
        if(body.getDate().isBefore(LocalDate.now())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date in past not allowed");
        }
        
        Member member = memberRepository.findById(body.getUsername()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No member found with this id"));
        
        Car car = carRepository.findById(body.getCarId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No car found with this id"));
        
        // TODO: What if already reserved  --> Tomorrow
                
        Reservation res = reservationRepository.save(new Reservation(body.getDate(), car, member));
        
        return new ReservationResponse(res);
    }
}


