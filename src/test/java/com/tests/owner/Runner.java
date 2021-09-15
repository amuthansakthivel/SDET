package com.tests.owner;

import com.utils.owner.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runner {

    public static void main(String[] args)  {
        String browser = PropertyUtils.readPropertyFile("browser");
        System.out.println("browser : " + browser);

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String timeout = PropertyUtils.readPropertyFile("timeout");

        driver.manage().timeouts().implicitlyWait(Long.parseLong(timeout), TimeUnit.SECONDS);

        String isScreenshotNeeded = PropertyUtils.readPropertyFile("takesscreenshot");
        if(isScreenshotNeeded.equalsIgnoreCase("true")){
            //write code to take screenshot
        }

        String favtools = PropertyUtils.readPropertyFile("favtools");
        List<String> strings = Arrays.asList(favtools.split(","));
        strings.forEach(System.out::println);

    }
}
