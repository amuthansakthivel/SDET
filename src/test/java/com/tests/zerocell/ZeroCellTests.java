package com.tests.zerocell;

import com.utils.factory.DriverFactory;
import com.utils.zerocell.ExcelReader;
import com.utils.zerocell.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ZeroCellTests {


    @Test(dataProvider = "getData")
    public void testcase1(TestData data){
        data.getList().forEach(System.out::println);
        WebDriver driver = DriverFactory.getDriver(data.getBrowser());
        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys(data.getFirstname());
        driver.quit();
    }
    @Test(dataProvider = "getData")
    public void testcase2(TestData data){
        System.out.println(data.getBrowser());
        WebDriver driver = DriverFactory.getDriver(data.getBrowser());
        driver.get("https://google.co.in");
        driver.findElement(By.name("q")).sendKeys(data.getFirstname());
        driver.quit();
    }

    @DataProvider(parallel = true)
    public Object[] getData(Method method) {
        return ExcelReader.getTestdatas()
                .stream()
                .filter(e->e.getTestcase().equalsIgnoreCase(method.getName())) //testcase1
                .toArray();
    }



}
