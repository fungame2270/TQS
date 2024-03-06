package TQS.CarService.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import TQS.CarService.Domain.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    public Car findByModel(String model);
    public List<Car> findAll();
}
