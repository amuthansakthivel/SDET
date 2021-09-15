package com.tests.owner;

import com.utils.owner.FrameworkConfig;
import com.utils.owner.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RunnerWithOwner {

    //Property file and equivalent interface = same package
    public static void main(String[] args) {
        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);
        System.out.println(config.browser());

        System.out.println(config.browser().name());

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        System.out.println(config.timeout());

        driver.manage().timeouts().implicitlyWait(config.timeout(), config.value());

        if(config.takescreenshot()){
            //write code to take screenshot
        }

        config.favtools().forEach(System.out::println);
    }
}
