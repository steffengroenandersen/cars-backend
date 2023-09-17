package sem3.cars.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sem3.cars.dto.ReservationRequest;
import sem3.cars.dto.ReservationResponse;
import sem3.cars.entity.Car;
import sem3.cars.entity.Member;
import sem3.cars.entity.Reservation;
import sem3.cars.repositories.CarRepository;
import sem3.cars.repositories.MemberRepository;
import sem3.cars.repositories.ReservationRepository;

import java.time.LocalDate;

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
    
    public ReservationResponse reserveCar(ReservationRequest body){
        if(body.getDate().isBefore(LocalDate.now())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Date in past not allowed");
        }
        
        Member member = memberRepository.findById(body.getUserName()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No member found with this id"));
        
        Car car = carRepository.findById(body.getCarId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No car found with this id"));
        
        // TODO: What if already reserved  --> Tomorrow
                
        Reservation res = reservationRepository.save(new Reservation(body.getDate(), car, member));
        
        return new ReservationResponse(res);
    }
}


