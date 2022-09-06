package com.tests.owner;

import com.utils.owner.FrameworkConfig;
import com.utils.owner.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class RunnerWithOwner {

    //Property file and equivalent interface = same package
    public static void main(String[] args) {

        FrameworkConfig config = ConfigFactory.create(FrameworkConfig.class);

        System.out.println(config.environment());
        System.out.println(config.username());

    }
}
