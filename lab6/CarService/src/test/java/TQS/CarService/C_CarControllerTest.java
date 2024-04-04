package TQS.CarService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import TQS.CarService.Controller.CarRestController;
import TQS.CarService.Domain.Car;
import TQS.CarService.Services.CarManagerService;

@WebMvcTest(CarRestController.class)
public class C_CarControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;

    @BeforeEach
    public void setUp() throws Exception{
    }

    @Test
    void whenPostCar_thenCreateCar() throws Exception{
        Car carro = new Car("Ferrari","LaFerrari");

        when(service.save(Mockito.any())).thenReturn(carro);

        mvc.perform(
            post("/api/cars").contentType(MediaType.APPLICATION_JSON).content(JsonUtils.toJson(carro)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.maker", is("Ferrari")));
        
            verify(service,times(1)).save(Mockito.any());
    }

    @Test
    void findCarByIdReturnsCarOnGet() throws Exception{
        Car car = new Car("Ferrari", "LaFerrari");
        car.setCarID((long) 1);

        when(service.getCarDetails((long)1)).thenReturn(Optional.of(car));
        

        mvc.perform(get("/api/cars/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.model", is("LaFerrari")));

        verify(service, times(1)).getCarDetails((long)1);
    }

    @Test
    void findCarByIdReturnsNotFound() throws Exception{
        when(service.getCarDetails((long)0)).thenReturn(Optional.empty());

        mvc.perform(get("/api/cars/0")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound());

        verify(service, times(1)).getCarDetails((long)0);
    }
}
