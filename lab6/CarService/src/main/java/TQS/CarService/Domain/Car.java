package TQS.CarService.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tqs_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carID;

    @Size(min = 3, max = 60)
    private String maker;

    @Size(min = 3, max = 60)
    private String model;

    public Car (String maker,String model){
        this.maker = maker;
        this.model = model;
    }

}
