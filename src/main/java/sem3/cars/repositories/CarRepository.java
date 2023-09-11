package sem3.cars.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sem3.cars.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> getByBrand(String brand);
}
