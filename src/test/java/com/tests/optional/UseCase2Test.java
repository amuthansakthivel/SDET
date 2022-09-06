package com.tests.optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.Optional;

public class UseCase2Test {

    WebDriver driver;

    @Test
    public void testOptional() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.co.in");

        //JS popup
        /*JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('Welcome to Guru99');");*/
        Optional.ofNullable(ExpectedConditions.alertIsPresent().apply(driver)).ifPresent(Alert::accept);

    }
}
