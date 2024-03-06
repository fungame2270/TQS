package TQS.CarService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import TQS.CarService.Domain.Car;
import TQS.CarService.Services.CarManagerService;

@RestController
@RequestMapping("/api")
public class CarRestController {
    
    @Autowired
    private CarManagerService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> CreateCar(@RequestBody Car car){
        HttpStatus status = HttpStatus.CREATED;
        Car saved = carService.save(car);
        return new ResponseEntity<>(saved,status);
    }

    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        HttpStatus status = HttpStatus.OK;
        Optional<Car> car = carService.getCarDetails(id);
        if (car.isPresent()){
            return new ResponseEntity<>(car.get(),status);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
