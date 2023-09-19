package dat3.cars.config;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.entity.Reservation;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import dat3.cars.repositories.ReservationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {
    
    MemberRepository memberRepository;
    CarRepository carRepository;
    
    ReservationRepository reservationRepository;

    public DeveloperData(MemberRepository memberRepository, CarRepository carRepository, ReservationRepository reservationRepository) {
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
    }

    private final String passwordUsedByAll = "test12";
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Member> members = MemberTestDataFactory.generateTestMembers("test12");
        memberRepository.saveAll(members);
     
        List<Car> cars = CarTestDataFactory.generateTestCars();
        carRepository.saveAll(cars);
        Member newUserMember = new Member("farblossom", "test12", "email", "Jens", "Jensen", "hvid", "acity", "2500");
        memberRepository.save(newUserMember);
        
        Car car = new Car("Tesla", "Super", 222, 222);
        carRepository.save(car);
        
        LocalDate date = LocalDate.of(2023,12,12);
        Reservation newRes = new Reservation(date, car, newUserMember);
        reservationRepository.save(newRes);
        
    }
}
