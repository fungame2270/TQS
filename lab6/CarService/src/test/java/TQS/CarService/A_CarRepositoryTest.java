package TQS.CarService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import TQS.CarService.Domain.Car;
import TQS.CarService.Repository.CarRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;


@DataJpaTest
public class A_CarRepositoryTest {
    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    void whenFindCarById_thenReturnCar() {
        Car car = new Car();
        
        entityManager.persistAndFlush(car);
        long id = car.getCarID();

        Optional<Car> found = carRepository.findById(id);
        assertThat(found.get()).isEqualTo(car);
    }
    @Test 
    void whenDeleteCarNoteFound(){
        Car car = new Car();
        
        entityManager.persistAndFlush(car);
        long id = car.getCarID();
        entityManager.remove(car);

        Optional<Car> found = carRepository.findById(id);
        assertFalse(found.isPresent());
    }
    @Test
    void findAll_ReturnAll(){
        Car car = new Car("ferrari","f40");
        Car car2 = new Car("toyota","supra");
        Car car3 = new Car("mercedes","clk200");

        entityManager.persist(car);
        entityManager.persist(car2);
        entityManager.persist(car3);
        entityManager.flush();

        List<Car> allCars = carRepository.findAll();

        assertThat(allCars).hasSize(3).extracting(Car::getMaker).containsOnly(car.getMaker(),car2.getMaker(),car3.getMaker());

    }
}
