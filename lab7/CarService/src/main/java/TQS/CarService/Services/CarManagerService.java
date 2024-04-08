package TQS.CarService.Services;

import java.util.List;
import java.util.Optional;

import TQS.CarService.Domain.Car;

public interface CarManagerService {
    public Car save(Car car);

    public List<Car> getAllCars();

    public Optional<Car> getCarDetails(Long id);
}
