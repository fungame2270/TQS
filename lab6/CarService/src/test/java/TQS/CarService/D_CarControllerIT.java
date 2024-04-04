package TQS.CarService;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;

import TQS.CarService.Domain.Car;
import TQS.CarService.Repository.CarRepository;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = CarServiceApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class D_CarControllerIT {
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private CarRepository carRepository;

    @Test
    void whenValidInput_thenCreateCar() throws IOException, Exception{
        Car carro = new Car("Ferrari","LaFerrari");

        mvc.perform(
            post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(carro)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.maker", is("Ferrari")));
    }

    @Test
    void giverCar_whenGet_status200() throws IOException,Exception{
        Car carro = new Car("Ferrari","LaFerrari");
        carRepository.saveAndFlush(carro);

        mvc.perform(get("/api/cars").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
        .andExpect(jsonPath("$[0].maker", is("Ferrari")));
    }
}
