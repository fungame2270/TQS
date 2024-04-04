package tqs;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BuySteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = WebDriverManager.firefoxdriver().create();
        driver.get(url);
    }

    @And("I choose from departure {string}")
    public void i_choose_from_departure_portland(String woof) {
        driver.findElement(By.name("fromPort")).click();
        {
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = 'Portland']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(4)")).click();
    }

    @And("I choose destination Berlin")
    public void i_choose_destination_berlin() {
        driver.findElement(By.name("toPort")).click();
        {
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = 'Berlin']")).click();
        }
        driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(4)")).click();
    }

    @And("I click button find flights")
    public void clickFind(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @And("I choose first flight")
    public void firstFligth(){
        driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
    }

    @And("I click Purshase Flight")
    public void purshace(){
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("I find a Thank you page")
    public void iShouldSee() {
        driver.findElement(By.cssSelector("h1")).click();
        {
        List<WebElement> elements = driver.findElements(By.cssSelector("h1"));
        assert(elements.size() > 0);
        }
        driver.quit();
    }

}
