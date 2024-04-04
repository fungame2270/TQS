package TQS.CarService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import TQS.CarService.Domain.Car;
import TQS.CarService.Repository.CarRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
public class E_CarControllerTemplate {
    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository carRepository;

    @AfterEach
    private void resedDB(){
        carRepository.deleteAll();
    }

    @Test
    void whenValidInput_thenCreateCar(){
        Car car = new Car("ferrari","f40");
        ResponseEntity<Car> entity = restTemplate.postForEntity("/api/cars", car, Car.class);

        List<Car> found = carRepository.findAll();
        assertThat(found).extracting(Car::getMaker).containsOnly("ferrari");

    }
    
    @Test
    void giverCar_whenGet_status200(){
        Car car = new Car("ferrari","f40");
        carRepository.saveAndFlush(car);

        ResponseEntity<List<Car>> entity = restTemplate
        .exchange("/api/cars", HttpMethod.GET,null,new ParameterizedTypeReference<List<Car>>() {});

        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).extracting(Car::getMaker).containsExactly("ferrari");

    }
}
