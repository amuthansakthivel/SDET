package com.tests.noexception;

import com.machinezoo.noexception.Exceptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Runner {


    @Test
    public void testSeleniumException() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");


        try{
            driver.findElement(By.xpath("abcd1234")).click();
        }
        catch(Exception e){
            driver.findElement(By.xpath("1234")).click();
        }



        Exceptions.silence()
                .get(() -> driver.findElement(By.xpath("q")))
                .orElseGet(() -> driver.findElement(By.xpath("abcd123")))
                .click();


    }
}
