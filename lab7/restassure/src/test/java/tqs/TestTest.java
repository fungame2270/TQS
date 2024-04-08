package tqs;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.apache.http.HttpStatus;

public class TestTest {
    
    @Test
    void Test1(){
        when().
            get("https://jsonplaceholder.typicode.com/todos").
        then().
            statusCode(HttpStatus.SC_OK);
    }

    @Test
    void Test2(){
        when()
            .get("https://jsonplaceholder.typicode.com/todos/4").
        then()
            .body("title",equalTo("et porro tempora"));
    }

    @Test
    void Test3(){
        when()
            .get("https://jsonplaceholder.typicode.com/todos")
        .then()
            .body("id", hasItems(199,198));
    }

    @Test
    void Test4(){
        when().
            get("https://jsonplaceholder.typicode.com/todos")
        .then()
            .time(lessThan(2L),TimeUnit.SECONDS);
            
    }
}
