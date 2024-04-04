package TQS.CarService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import TQS.CarService.Domain.Car;
import TQS.CarService.Repository.CarRepository;
import TQS.CarService.Services.imp.CarManagerServiceIm;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class B_CarServiceTests {
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarManagerServiceIm carService;

    @Test
    void validId_getCar(){
        Car car = new Car("ferrari","f40");
        car.setCarID((long)0);

        when(carRepository.findById((long)0)).thenReturn(Optional.of(car));

        assertThat(carService.getCarDetails((long)0).get()).isEqualTo(car);
    }

    @Test
    void invalidId_thenNoCar(){
        when(carRepository.findById(2L)).thenReturn(Optional.empty());
        assertFalse(carService.getCarDetails(2L).isPresent());
    }

    @Test
    void multiplecar_thenGetAll(){
        Car car1 = new Car("lancia","stratus");
        Car car2 = new Car("toyota","mr2");

        List<Car> list = Arrays.asList(car1,car2);
        when(carRepository.findAll()).thenReturn(list);

        assertThat(carService.getAllCars()).isEqualTo(list);
    }

}
