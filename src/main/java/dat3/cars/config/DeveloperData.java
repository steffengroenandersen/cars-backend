package dat3.cars.config;

import dat3.cars.entity.Car;
import dat3.cars.entity.Member;
import dat3.cars.repositories.CarRepository;
import dat3.cars.repositories.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

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
     
        List<Car> cars = CarTestDataFactory.generateTestCars();
        carRepository.saveAll(cars);
        Member newUserMember = new Member("farblossom", "test12", "email", "Jens", "Jensen", "hvid", "acity", "2500");
        memberRepository.save(newUserMember);
    }
}
