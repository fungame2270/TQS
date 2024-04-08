package TQS.CarService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Optional;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import TQS.CarService.Controller.CarRestController;
import TQS.CarService.Domain.Car;
import TQS.CarService.Services.CarManagerService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(CarRestController.class)
public class C_CarControllerTest {
    
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarManagerService service;


    @Test void 
    whenPostCar_thenCreateCar() throws Exception{
        Car carro = new Car("Ferrari","LaFerrari");

        when(service.save(Mockito.any())).thenReturn(carro);

        RestAssuredMockMvc.given().mockMvc(mvc).contentType(ContentType.JSON).body(carro)
        .when().post("/api/cars")
        .then().statusCode(201).body("maker",equalTo("Ferrari"));

        
    }
}
