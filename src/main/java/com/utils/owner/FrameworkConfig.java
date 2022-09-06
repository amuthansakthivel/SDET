package com.utils.owner;

import org.aeonbits.owner.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
                "system:env",
                "file:${user.dir}/src/test/resources/FrameworkConfig.properties",
                "file:${user.dir}/src/test/resources/dev-config.properties",
                "file:${user.dir}/src/test/resources/staging-config.properties"
})
public interface FrameworkConfig extends Config {

    @DefaultValue("dev")
    String environment();

    @Key("${environment}.username")
    String username();

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













