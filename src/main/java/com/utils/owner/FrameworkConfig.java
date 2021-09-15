package com.utils.owner;

import org.aeonbits.owner.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Config.Sources(value="file:${user.dir}/src/test/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {

    @DefaultValue("CHROME")
    BrowserType browser();

    @DefaultValue("SECONDS")
    TimeUnit value();

    @DefaultValue("15")
    Long timeout();

    @Key("lovescoffee")
    boolean takescreenshot();
    List<String> favtools();
}
