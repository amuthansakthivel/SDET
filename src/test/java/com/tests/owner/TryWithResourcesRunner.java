package com.tests.owner;

import com.utils.owner.ConfigProperties;
import com.utils.owner.TryWithResources;

public class TryWithResourcesRunner {
    public static void main(String[] args) {
        String browser = TryWithResources.get(ConfigProperties.BROWSER);
        System.out.println("browser = " + browser);
    }
}
