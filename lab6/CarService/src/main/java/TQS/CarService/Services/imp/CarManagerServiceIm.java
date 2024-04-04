package TQS.CarService.Services.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TQS.CarService.Domain.Car;
import TQS.CarService.Repository.CarRepository;
import TQS.CarService.Services.CarManagerService;

@Service
public class CarManagerServiceIm implements CarManagerService {
    
    private CarRepository carRepository;
    
    @Autowired
    public CarManagerServiceIm(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car){
       Car retCar =  carRepository.save(car);
       return retCar;
    }

    @Override
    public List<Car> getAllCars(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @Override
    public Optional<Car> getCarDetails(Long id){
        Optional<Car> car = carRepository.findById(id);
        return car;
    }
}
