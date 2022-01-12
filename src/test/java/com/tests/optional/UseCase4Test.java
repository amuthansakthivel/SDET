package com.tests.optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class UseCase4Test {

    WebDriver driver;

    @Test
    public void testFindAnyAndFindFirst() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.co.in");

        driver.findElements(By.xpath("//a"))
                .stream()
                .findAny()
                .ifPresent(WebElement::click);
    }

    private int getRandomElement(List<WebElement> elements) { //0 to 10
        return 0;
    }
}
