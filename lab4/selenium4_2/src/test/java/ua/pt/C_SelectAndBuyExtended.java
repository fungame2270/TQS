package ua.pt;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
class C_SelectAndBuyExtended {

    @Test
    @DisplayName("Open website, select a flight and buy it")
    public void testSelectAndBuy(FirefoxDriver driver) {
      driver.get("https://blazedemo.com/");
      driver.findElement(By.name("fromPort")).click();
      {
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = 'Portland']")).click();
      }
      driver.findElement(By.cssSelector(".form-inline:nth-child(1) > option:nth-child(4)")).click();
      driver.findElement(By.name("toPort")).click();
      {
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = 'Berlin']")).click();
      }
      driver.findElement(By.cssSelector(".form-inline:nth-child(4) > option:nth-child(4)")).click();
      driver.findElement(By.cssSelector(".btn-primary")).click();
      driver.findElement(By.cssSelector("tr:nth-child(1) .btn")).click();
      driver.findElement(By.id("inputName")).click();
      driver.findElement(By.id("inputName")).sendKeys("tomas");
      driver.findElement(By.id("address")).click();
      driver.findElement(By.id("address")).sendKeys("rua vizinha");
      driver.findElement(By.id("city")).click();
      driver.findElement(By.id("city")).click();
      driver.findElement(By.id("city")).sendKeys("acores");
      driver.findElement(By.id("state")).click();
      driver.findElement(By.id("state")).sendKeys("aveiro");
      driver.findElement(By.id("zipCode")).click();
      driver.findElement(By.id("zipCode")).sendKeys("255654");
      driver.findElement(By.id("cardType")).click();
      driver.findElement(By.id("cardType")).click();
      driver.findElement(By.id("creditCardNumber")).click();
      driver.findElement(By.id("creditCardNumber")).sendKeys("999999999");
      driver.findElement(By.id("nameOnCard")).click();
      driver.findElement(By.id("nameOnCard")).sendKeys("heeh");
      driver.findElement(By.id("rememberMe")).click();
      driver.findElement(By.cssSelector(".btn-primary")).click();
      driver.findElement(By.cssSelector("h1")).click();
      {
        List<WebElement> elements = driver.findElements(By.cssSelector("h1"));
        assert(elements.size() > 0);
      }
    }

}