package dat3.cars.repositories;

import dat3.cars.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> getByBrand(String brand);
}
