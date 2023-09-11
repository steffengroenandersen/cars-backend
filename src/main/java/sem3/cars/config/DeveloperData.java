package sem3.cars.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import sem3.cars.entity.Car;
import sem3.cars.repositories.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {
    
    CarRepository carRepository;
    
    public DeveloperData(CarRepository carRepository){
        this.carRepository = carRepository;
    }
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
        
     
        Car car = new Car("Ford", "F150", 15000, 500);
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        carRepository.saveAll(cars);
    }
}
