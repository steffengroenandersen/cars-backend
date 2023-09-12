package sem3.cars.config;

import sem3.cars.entity.Car;
import sem3.cars.entity.Member;
import sem3.cars.repositories.CarRepository;
import sem3.cars.repositories.MemberRepository;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;


import java.util.ArrayList;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {
    
    MemberRepository memberRepository;
    CarRepository carRepository;
    
    public DeveloperData(MemberRepository memberRepository, CarRepository carRepository){
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }
    
    private final String passwordUsedByAll = "test12";
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Member> members = MemberTestDataFactory.generateTestMembers("test12");
        memberRepository.saveAll(members);
     
        Car car = new Car("Ford", "F150", 15000, 500);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        carRepository.saveAll(cars);
    }
}
