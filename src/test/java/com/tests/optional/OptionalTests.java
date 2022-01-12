package com.tests.optional;

import org.testng.annotations.Test;

import java.util.Optional;

public class OptionalTests {

    @Test
    public void testOptional() {

       Optional<String> name = Optional.ofNullable("Amuthan");

    }


}
