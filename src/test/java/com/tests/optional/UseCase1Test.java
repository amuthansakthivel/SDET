package com.tests.optional;

import org.testng.annotations.Test;

import java.util.Objects;
import java.util.Optional;

public class UseCase1Test {

    @Test
    public void testNullSysOrEnvProperty() {
       /* String browser = System.getenv("browser");
        if(browser==null){
            browser = "chrome";
        } else{
            
        }

        String browser1 = Optional.ofNullable(System.getenv("browser")).orElse("chrome");
        System.out.println("browser1 = " + browser1);

        Optional.ofNullable(System.getenv("browser")).orElseGet(this::getDefaultBrowser);*/
        Optional.ofNullable(System.getenv("browser"))
                .orElseThrow(IllegalStateException::new);

        Objects.requireNonNullElseGet(System.getenv("browser"),this::getDefaultBrowser);
        Optional.ofNullable(System.getenv("browser")).orElseGet(this::getDefaultBrowser);

    }
    public String getDefaultBrowser(){
        //db calls, api calls
        return "chrome";
    }
}
